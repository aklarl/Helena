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

import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.EnsembleStructure
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.RoleType

import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_EnsembleStructure.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Model.*

class ComponentTypeGenerator {
	
	/**
	 * Compiles a user defined type declaration for every operation which can be called on a component type
	 * - attribute getters
	 * - association getters
	 * - role creators, getters, and isPlaying-queries
	 */
	def static compileOperations(ComponentType ct, EnsembleStructure es) {
		var Iterable<RoleType> roleTypesAdoptableByCT = es.rtWithMult.map[roleType].filter[compTypes.contains(ct)];
		'''
		///////////// component operation definitions //////////////////////
		typedef «ct.name.toFirstUpper»Operation {
			mtype {
				// operations to access attributes of component
				«FOR attr:ct.attrs SEPARATOR ', ' AFTER ', '»«attr.getterCompOperationName», «attr.setterCompOperationName»«ENDFOR»
				
				// operations to access associations to other components
				«FOR assoc:ct.assocs SEPARATOR ', ' AFTER ', ' »«assoc.getterCompOperationName»«ENDFOR»
				
				// operations
				«FOR op:ct.ops SEPARATOR ', ' AFTER ', ' »«op.operationCompOperationName»«ENDFOR»
				
				// operations to manage role playing
				«FOR rt:roleTypesAdoptableByCT SEPARATOR ', '»
				«rt.compOperationNameForCreate», «rt.compOperationNameForGet», «rt.compOperationNameForQuit», «rt.compOperationNameForPlays»
				«ENDFOR»
			};
			
			mtype optype;
			chan parameters;
			chan answer;
		}
		'''
	}
	
	/**
	 * Compiles a process type for a given component which allows to receive operation
	 * calls to this components. Operation calls are attributes getters, association getters,
	 * and role creators, getters, and isPlaying-queries
	 */
	def static compileProctype(ComponentType ct, EnsembleStructure es, Model model) {
		var Iterable<RoleType> roleTypesAdoptableByCT = es.rtWithMult.map[roleType].filter[compTypes.contains(ct)];
		'''
		////////////// process definition of component type «ct.proctypeName» /////////////
		proctype «ct.proctypeName»(
				«FOR attr:ct.attrs SEPARATOR '; ' AFTER '; '»«attr.type.promelaType» «attr.compProctypeParamName»«ENDFOR»
				«FOR assoc:ct.assocs SEPARATOR '; ' AFTER '; '»chan «assoc.compProctypeParamName»«ENDFOR»
				chan self) {
		
			«FOR rt:roleTypesAdoptableByCT»
			bool «rt.variableNameForPlays» = false;
			chan «rt.chanName» = [«es.getCapacityForRoleType(rt)»] of { mtype«
				»«FOR i: 0 ..< model.maxNumberOfRoleParamsInModel BEFORE ',' SEPARATOR ','»chan«ENDFOR»«
				»«FOR i: 0 ..< model.maxNumberOfDataParamsInModel BEFORE ',' SEPARATOR ','»int«ENDFOR» };
			«ENDFOR»
		
			«ct.startLabelName»: true;
		
			«ct.operationTypeName» op;
		
			do
			::atomic { 
				self?op ->
				if
				«FOR attr:ct.attrs»
				::op.optype == «attr.getterCompOperationName» -> op.answer!«attr.compProctypeParamName»
				::op.optype == «attr.setterCompOperationName» -> op.parameters?«attr.compProctypeParamName»
				«ENDFOR»
				
				«FOR assoc:ct.assocs»
				::op.optype == «assoc.getterCompOperationName» -> op.answer!«assoc.compProctypeParamName»
				«ENDFOR»
				
				«FOR op:ct.ops»
				::op.optype == «op.operationCompOperationName» -> 
					«IF !op.formalDataParamsBlock.params.empty»
					«FOR param:op.formalDataParamsBlock.params SEPARATOR '\n'»«param.type.promelaType» «param.varName»;«ENDFOR»
					op.parameters?«FOR param:op.formalDataParamsBlock.params SEPARATOR ','»«param.varName»«ENDFOR»;
					«ENDIF»
					// add intended behavior of this operation
					«IF op.returnType.type.simpleName != 'void'»op.answer!1;«ENDIF»
				«ENDFOR»
				
				«FOR rt:roleTypesAdoptableByCT»
				::op.optype == «rt.compOperationNameForCreate» ->
					if
					::!«rt.variableNameForPlays» && «rt.currentName» < «rt.maxName» ->
						run «rt.proctypeName»(self, «rt.chanName»);
						«rt.variableNameForPlays» = true;
						«rt.currentName»++;
						op.answer!«rt.chanName»
					fi
				::op.optype == «rt.compOperationNameForGet» ->
					if
					::«rt.variableNameForPlays» ->
						op.answer!«rt.chanName»
					fi
				::op.optype == «rt.compOperationNameForQuit» ->
					if
					::«rt.variableNameForPlays» && «rt.currentName» > «rt.minName» ->
						«rt.variableNameForPlays» = false;
						«rt.currentName»--
					fi
				::op.optype == «rt.compOperationNameForPlays» ->
					op.answer!«rt.variableNameForPlays»
				«ENDFOR»
				fi
			}
			od
		}
		'''
	}
	
	/**
	 * Compiles helpers to call operations on the component
	 */
	def static compileOperationCallHelpers(ComponentType ct) {
		'''
		//////// helpers for communication between roles and «ct.proctypeName» components /////////
		inline «ct.retrieveRole»(rtOperation,component,role) {
			«ct.operationTypeName» op;
			op.optype = rtOperation;
				chan answer = [0] of { chan };
			op.answer = answer;
			component!op;
			answer?role;
		}
		
		inline «ct.quitRole»(rtOperation,component) {
			«ct.operationTypeName» op;
			op.optype = rtOperation;
			component!op;
		}
		
		inline «ct.isPlaying»(playsOperation,component,plays) {
			«ct.operationTypeName» op;
			op.optype = playsOperation;
				chan answer = [0] of { bool };
			op.answer = answer;
			component!op;
			answer?plays;
		}
		
		inline «ct.retrieveAssociation»(assocOperation,component,assoc) {
			«ct.operationTypeName» op;
			op.optype = assocOperation;
				chan answer = [0] of { chan };
			op.answer = answer;
			component!op;	
			answer?assoc;
		}
		
		«FOR attr:ct.attrs SEPARATOR '\n'»
		inline «ct.getGetterName(attr)»(component,«attr.compProctypeParamName») {
			«ct.operationTypeName» op;
			op.optype = «attr.getterCompOperationName»;
				chan answer = [0] of { «attr.type.promelaType» };
			op.answer = answer;
			component!op;
			answer?«attr.compProctypeParamName»;
		}
		
		inline «ct.getSetterName(attr)»(component,value) {
			«ct.operationTypeName» op;
			op.optype = «attr.setterCompOperationName»;
				chan parameters = [0] of { «attr.type.promelaType» };
			op.parameters = parameters;
			component!op;
			parameters!value;
		}
		«ENDFOR»
		
		«FOR op:ct.ops SEPARATOR '\n'»
		inline «ct.getOperationCall(op)»(component«FOR param:op.formalDataParamsBlock.params BEFORE ',' SEPARATOR ','»«param.varName»«ENDFOR»«IF !op.returnType.type.isVoid»,re«ENDIF») {
			«ct.operationTypeName» op;
			op.optype = «op.operationCompOperationName»;
			«IF !op.formalDataParamsBlock.params.isEmpty»
			chan parameters = [0] of { «FOR param:op.formalDataParamsBlock.params SEPARATOR ','»«param.type.promelaType»«ENDFOR» };
			op.parameters = parameters;
			«ENDIF»
			«IF !op.returnType.type.isVoid»
			chan answer = [0] of { «op.returnType.promelaType» };
			op.answer = answer;
			«ENDIF»
			component!op;
			«IF !op.formalDataParamsBlock.params.isEmpty»
			parameters!«FOR param:op.formalDataParamsBlock.params SEPARATOR ','»«param.varName»«ENDFOR»;
			«ENDIF»
			«IF !op.returnType.type.isVoid»
			answer?re;
			«ENDIF»
		}
		«ENDFOR»
		'''
	}
	
}