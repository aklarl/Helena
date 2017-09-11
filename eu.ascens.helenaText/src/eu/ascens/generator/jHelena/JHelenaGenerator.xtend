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
package eu.ascens.generator.jHelena

import com.google.inject.Inject
import eu.ascens.generator.HelenaTextOutputConfigurationProvider
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.EnsembleStructure
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.RoleType
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.XbaseCompiler

import static extension eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator.*

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class JHelenaGenerator implements IGenerator {

	@Inject	protected XbaseCompiler xbaseCompiler
	@Inject protected TypeReferenceSerializer serializer
	
	private var ImportManager im = new ImportManager(true);
	
	//Generators
	private var GeneratorHelper genHelper;
	private var EnsembleStructureGenerator ensembleGenerator;
	private var SysManagerGenerator sysManagerGenerator;
	private var RoleTypeGenerator roleTypeGenerator;
	private var MessageTypeGenerator msgTypeGenerator;
	private var OperationTypeGenerator opTypeGenerator;
	private var ComponentTypeGenerator componentTypeGenerator;
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		genHelper = new GeneratorHelper(xbaseCompiler, serializer, im);
		
		componentTypeGenerator = new ComponentTypeGenerator(serializer, im, genHelper);
		ensembleGenerator = new EnsembleStructureGenerator(serializer, im, genHelper);
		sysManagerGenerator = new SysManagerGenerator(serializer, im, genHelper);
		msgTypeGenerator = new MessageTypeGenerator(serializer, im, genHelper);
		opTypeGenerator = new OperationTypeGenerator(serializer, im, genHelper);
		roleTypeGenerator = new RoleTypeGenerator(xbaseCompiler, serializer, im, genHelper);
		
		//Generates ComponentType Files
		for(e: resource.allContents.toIterable.filter(ComponentType)) {
			var fullName = e.getFullName("/");
			fsa.generateFile(
				fullName + ".java",
				HelenaTextOutputConfigurationProvider::JHELENA_GEN_OUTPUT,
				componentTypeGenerator.compile(e))
			fsa.generateFile(
				fullName + AbstractHelenaTextGenerator.IMPL + ".java",
				HelenaTextOutputConfigurationProvider::JHELENA_GEN_ONCE_OUTPUT,
				componentTypeGenerator.compileImpl(e))
		}
		
		//Generates RoleType Files
		for(e: resource.allContents.toIterable.filter(RoleType)) {
			var fullName = e.getFullName("/")
			fsa.generateFile(
				fullName + ".java",
				HelenaTextOutputConfigurationProvider::JHELENA_GEN_OUTPUT,
				roleTypeGenerator.compile(e))
//			fsa.generateFile(
//				fullName + AbstractHelenaTextGenerator.IMPL + ".java",
//				HelenaTextOutputConfigurationProvider::JHELENA_GEN_ONCE_OUTPUT,
//				roleTypeGenerator.compileImpl(e))
		}
		
		//Generates MessageType Files
		for(e: resource.allContents.toIterable.filter(MessageType)) {
			var fn = e.getFullName("/");
			
			fsa.generateFile(
				fn + ".java",
				msgTypeGenerator.compile(e))
		}
		
		//Generates OperationType Files
		for(e: resource.allContents.toIterable.filter(OperationType)) {
			var fn = e.getFullName("/");
			
			fsa.generateFile(
				fn + ".java",
				opTypeGenerator.compile(e))
		}
			
		//Generates EnsembleStructure Files
		for(e: resource.allContents.toIterable.filter(EnsembleStructure)) {
			var fullName = e.getFullName("/");
			fsa.generateFile(
				fullName + ".java",
				HelenaTextOutputConfigurationProvider::JHELENA_GEN_OUTPUT,
				ensembleGenerator.compile(e))
			fsa.generateFile(
				fullName + AbstractHelenaTextGenerator.IMPL + ".java",
				HelenaTextOutputConfigurationProvider::JHELENA_GEN_ONCE_OUTPUT,
				ensembleGenerator.compileImpl(e))
		}
		
		//Generate SysManager
		for(e: resource.allContents.toIterable.filter(Model)){
			var fullName = e.getSysMgrFullName("/");
			
			fsa.generateFile(
					fullName + ".java",
					HelenaTextOutputConfigurationProvider::JHELENA_GEN_OUTPUT,
					sysManagerGenerator.compile(e)
			)
			fsa.generateFile(
				fullName + AbstractHelenaTextGenerator.IMPL + ".java",
				HelenaTextOutputConfigurationProvider::JHELENA_GEN_ONCE_OUTPUT,
				sysManagerGenerator.compileImpl(e))
		
		}
		
	}
}
