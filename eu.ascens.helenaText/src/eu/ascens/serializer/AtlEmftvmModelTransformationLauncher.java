/*
 *  The Helena workbench is an Eclipse plugin for the development of ensemble-based systems
 *  according to the Helena approach. It is fully documented in the PhD 
 *  thesis "Helena - Handling massively distributed systems with ELaborate 
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 
 *  Website: http://www.pst.ifi.lmu.de/Personen/team/klarl/helena.html
 *  PhD thesis: https://edoc.ub.uni-muenchen.de/20087/
 *
 *  Copyright (C) 2013-2017  Annabelle Klarl
 *  All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 */
package eu.ascens.serializer;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;

import com.google.inject.Inject;

public class AtlEmftvmModelTransformationLauncher {

	private static final String XMI = "xmi";

	private static final String MODEL_FOLDER = "transformation_models/";
	private static final String TRANSFORMATIONS_FOLDER = MODEL_FOLDER
			+ "transformations/";
	private static final String HELENA_TRANSFORMATION_MODULE = "HelenaDraft2Helena";
	private static final String HELENATEXT_PLUGIN_PROJECT = "eu.ascens.helenaText";

	// Constants referring to metamodel
	private static final String HELENA_TEXT_METAMODEL_NAME = "HelenaText";
	private static final String HELENA_TEXT_METAMODEL_NSURI = "http://www.ascens.eu/HelenaText";
	private static final String IN = "IN";

	// Constants referring to the naming of the target files
	private static final String TARGET_HELENA_FILE_EXTENSION = "helena";
	private static final String TARGET_HELENA_FILE__STRING_TO_APPEND = "interruptable";

	// Constants to determine into which folder the target xmi and the target
	// helena file shall be generated
	private static final String TARGET_HELENA_FILE__FOLDER = "model";
	private static final String TARGET_HELENA_XMIS__FOLDER = "model";

	private URI src_model_xmi;
	private URI trg_model_xmi;

	@Inject
	HelenaTextEcoreSerializer serializer;

	public void launchTransformation(Resource modelResource) {

		// serialize adaptive model
		this.serializer.serializeXtext(modelResource);

		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		ResourceSet rs = new ResourceSetImpl();

		// load metamodels
		Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		Resource helenaTextMetaModelRes = rs
				.getResource(URI.createURI(HELENA_TEXT_METAMODEL_NSURI), true);
		metaModel.setResource(helenaTextMetaModelRes);
		env.registerMetaModel(HELENA_TEXT_METAMODEL_NAME, metaModel);

		// calculate model paths
		this.calculatePaths(modelResource);

		// create and register model
		Model inOutModel = EmftvmFactory.eINSTANCE.createModel();
		inOutModel.setResource(rs.getResource(this.src_model_xmi, true));
		inOutModel.setAllowInterModelReferences(true);
		env.registerInOutModel(IN, inOutModel);

		// load and run transformation
		ModuleResolver mr = new DefaultModuleResolver("platform:/plugin/"
				+ HELENATEXT_PLUGIN_PROJECT + "/" + TRANSFORMATIONS_FOLDER, rs);
		TimingData td = new TimingData();
		env.loadModule(mr, HELENA_TRANSFORMATION_MODULE);
		td.finishLoading();
		env.run(td);
		td.finish();

		// save models
		try {
			// change URI of the inOut model, so that the source model is not
			// overwritten
			Resource inOutModelRes = inOutModel.getResource();
			inOutModelRes.setURI(this.trg_model_xmi);

			// save xmi
			inOutModelRes.save(Collections.emptyMap());

			// make helena file from xmi
			this.materializeTrgModel(this.trg_model_xmi,
					TARGET_HELENA_FILE_EXTENSION, modelResource.getURI());

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Triggers the generation of the .helena file from the XMI
	 * 
	 * @param trgModel_xmi
	 * @param trgFileExtension
	 * @param baseModelURI
	 */
	private void materializeTrgModel(URI trgModel_xmi, String trgFileExtension,
			URI baseModelURI) {
		String modelBaseName = this.getModelBaseName(baseModelURI);
		URI modelDestinationURI = this.getTrgModelDestinationURI(baseModelURI);

		// Set the filename of the new helena file
		URI trg_platform_file = modelDestinationURI.trimSegments(1)
				.appendSegment(TARGET_HELENA_FILE__FOLDER)
				.appendSegment(modelBaseName + "_"
						+ TARGET_HELENA_FILE__STRING_TO_APPEND)
				.appendFileExtension(trgFileExtension);
		URI trg_file = URI
				.createFileURI(this.getAbsolutePath(trg_platform_file));

		// serialize xmi -> create .helena file
		this.serializer.XMItoXtext(trgModel_xmi, trg_file);
	}

	private String getAbsolutePath(URI file) {

		return Platform.getLocation().toString() + file.toPlatformString(true);
	}

	private void calculatePaths(Resource modelResource) {
		URI modelURI = modelResource.getURI();
		URI destinationURI = this.getXmiDestinationURI(modelURI);
		String fileName = this.getModelBaseName(modelURI);

		this.src_model_xmi = destinationURI.appendSegment(fileName + "_helena")
				.appendFileExtension(XMI);
		this.trg_model_xmi = destinationURI
				.appendSegment(fileName + "_helena_"
						+ TARGET_HELENA_FILE__STRING_TO_APPEND)
				.appendFileExtension(XMI);

	}

	/**
	 * Calculates the path for the target XMI file, based on the location of the
	 * src model
	 * 
	 * @param srcModelURI URI of the source model
	 * @return
	 */
	private URI getXmiDestinationURI(URI srcModelURI) {
		URI destinationURI = srcModelURI.trimSegments(2)
				.appendSegment(TARGET_HELENA_XMIS__FOLDER);

		return destinationURI;
	}

	/**
	 * Calculates the path for the target model (.helena)file, based on the
	 * location of the src model
	 * 
	 * @param srcModelURI URI of the source model
	 * @return
	 */
	private URI getTrgModelDestinationURI(URI srcModelURI) {
		URI destinationURI = srcModelURI.trimSegments(2)
				.appendSegment(TARGET_HELENA_XMIS__FOLDER);

		return destinationURI;
	}

	private String getModelBaseName(URI srcModelURI) {
		String fileName = srcModelURI.trimFileExtension().lastSegment();
		return fileName;
	}
}