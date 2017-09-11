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
package eu.ascens.serializer

//import org.eclipse.xtext.EcoreUtil2

import java.io.IOException
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMIResource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmVisibility
import org.eclipse.xtext.common.types.JvmVoid
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.serializer.impl.Serializer

class HelenaTextEcoreSerializer extends Serializer{
		
	/**
	 * @param modelURI model that shall be serialized
	 * @param targetURI URI of the target XMI file that shall be generated
	 */	
	public def void serializeXtext(Resource model) {
		var	URI modelURI = model.getURI();
		var URI destinationURI = modelURI.trimSegments(2).appendSegment("model"); 
		var String fileName = modelURI.trimFileExtension().lastSegment() + "_helena";
		var URI targetURI = destinationURI.appendSegment(fileName).appendFileExtension("xmi");
		
		var XtextResourceSet xrs = new XtextResourceSet();
		xrs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		// load the xtext resource
		var Resource xtextResource = model;//xrs.getResource(modelURI, true) as XtextResource;
		xtextResource.load(null);
		EcoreUtil2.resolveAll(xtextResource);
		
		var EObject newMod = xtextResource.getContents().get(0);
		
		// store in a xmi-resoure
		var Resource xmiResource = xrs.createResource(targetURI);
		xmiResource.getContents().add(newMod);
		try {
			var Map options = (xmiResource as XMIResource).getDefaultLoadOptions();
			options.put(XMIResource.OPTION_PROXY_ATTRIBUTES, Boolean.TRUE);
			xmiResource.save(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	package def void XMItoXtext(URI src_xmi_uri, URI trg_uri){
        var  XtextResourceSet xrs = new XtextResourceSet();
		xrs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		
		// load the xmi resource
		var Resource xmiResource = xrs.getResource(src_xmi_uri, true);
		xmiResource.load(null);
		EcoreUtil2.resolveAll(xmiResource);
		var EObject model= xmiResource.getContents().get(0);
				
		var jvmTypes = model.eAllContents.toIterable.toList.filter[elem | 
			elem instanceof JvmParameterizedTypeReference
		].map[elem | elem as JvmParameterizedTypeReference].toList;
		for(type : jvmTypes){
			var subType = type.type;
			if(subType != null){
				//Workaround: since atl does not create correct proxy information for JvmTypes
				calculateAndSetSimpleName(subType);
			}
		}
		
		
		
		// create the resource and add the model to the xtext resource
		var XtextResource a = xrs.createResource(trg_uri) as XtextResource;
		a.getContents().add(model);

		// save the new resource with the model
		try {
			a.save(null);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	
	
	def private dispatch void calculateAndSetSimpleName(JvmPrimitiveType primitive){
		var URI ref = EcoreUtil.getURI(primitive);
		primitive.simpleName = ref.fragment;
	}
	def private dispatch void calculateAndSetSimpleName(JvmGenericType it){
		var String shortName = "";
		var String pkgName;
		
		var URI ref = EcoreUtil.getURI(it);
		var qualifiedName = ref.fragment; //full name like e.g. java.lang.String
		
		//URI looks like the following: java:/Objects/java.lang.Integer#java.lang.Integer
		if(!ref.isPlatformResource){ //true jvm type 
			//calculate simpleName and package
			var lastDotPos = qualifiedName.lastIndexOf(".");
			shortName = qualifiedName.substring(lastDotPos+1);
			pkgName = qualifiedName.substring(0, qualifiedName.lastIndexOf("."));
			
		}

		//set values
		simpleName = shortName;	//e.g. String
		packageName= "";		//use empty packageName to get only String as type 
		visibility = JvmVisibility.PUBLIC; 
		deprecated = false; 
		final = true; 
	}

	def private dispatch void calculateAndSetSimpleName(JvmVoid voidType){
		//only needed to grant the common supertype "JvmType" for the dispatch method
	}
	
}