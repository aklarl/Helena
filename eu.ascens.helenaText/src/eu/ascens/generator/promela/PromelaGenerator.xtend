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
package eu.ascens.generator.promela

import com.google.inject.Inject
import eu.ascens.generator.HelenaTextOutputConfigurationProvider
import eu.ascens.helenaText.Model
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

import static extension eu.ascens.generator.promela.ComponentTypeGenerator.*
import static extension eu.ascens.generator.promela.MessageTypeGenerator.*
import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_EnsembleStructure.*

/**
 * Generates the Promela code from a HelenaText file on save.
 * 
 */
class PromelaGenerator implements IGenerator {
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		var Model model = resource.allContents.filter(Model).head;
		fsa.generateFile(
				model.headPkg.name + ".pml",
				HelenaTextOutputConfigurationProvider::PROMELA_GEN_OUTPUT,
				compile(model)
		)
	}
	
	/**
	 * Compiles the whole model
	 */
	@Inject RoleTypeGenerator rtGenerator;
	def compile(Model model) {
		'''
««« multiplicities for role types (caution: we assume just one ensemble structure)
		«model.compileMultiplicities»
		
««« operations for component types
		«FOR ct: model.headPkg.compTypes»
		«ct.compileOperations(model.headPkg.ensStructs.head)»
		«ENDFOR»
		
««« helpers for communication between roles and components
		«FOR ct: model.headPkg.compTypes SEPARATOR '\n'»
		«ct.compileOperationCallHelpers»
		«ENDFOR»

««« messages for role types
		«model.compileMsgs» 

««« helpers for communication between roles
		«model.compileMsgCallHelpers»
		
««« processes for component types
		«FOR ct: model.headPkg.compTypes SEPARATOR '\n'»
		«ct.compileProctype(model.headPkg.ensStructs.head, model)»
		«ENDFOR»

««« processes for role behaviors
		«FOR rt: model.headPkg.roleTypes SEPARATOR '\n'»
		«rtGenerator.compileProctype(rt, model)»
		«ENDFOR»
		'''
	}
	
	def static compileMultiplicities(Model model) {
		'''
		///////////// ensemble structure multiplicities //////////////////////
		«FOR rtWithMult:model.headPkg.ensStructs.head.rtWithMult SEPARATOR '\n'»
		int «rtWithMult.roleType.minName» = «rtWithMult.min.calculateMultiplicityPromela»;
		int «rtWithMult.roleType.maxName» = «rtWithMult.max.calculateMultiplicityPromela»;
		int «rtWithMult.roleType.currentName» = 0;
		«ENDFOR»
		'''
	}

}
