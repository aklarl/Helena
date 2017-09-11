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

import eu.ascens.helenaText.Model

import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Model.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

class MessageTypeGenerator {
	
	/**
	 * Compiles a user defined type declaration for every message which can be sent in the model
	 */
	def static compileMsgs(Model model) {
		'''
		///////////// message definitions //////////////////////
		mtype {
			setOffInitialRole, 
			«FOR msg: model.allMessagesInModel SEPARATOR ', '»
				«msg.msgName»
			«ENDFOR»
		}
		'''
	}
	
	/**
	 * Compiles helpers to send messages between roles
	 */
	def static compileMsgCallHelpers(Model model) {
		'''
		//////// helper for setting up initial state /////////
		inline send_setOffInitialRole(receiver) {
			receiver!setOffInitialRole«
				»«FOR i : 0 ..< model.maxNumberOfRoleParamsInModel BEFORE ',' SEPARATOR ','»1«ENDFOR»«
				»«FOR i : 0 ..< model.maxNumberOfDataParamsInModel BEFORE ',' SEPARATOR ','»1«ENDFOR»;
		}
		
		inline receive_setOffInitialRole() {
			self?setOffInitialRole«
				»«FOR i : 0 ..< model.maxNumberOfRoleParamsInModel BEFORE ',' SEPARATOR ','»1«ENDFOR»«
				»«FOR i : 0 ..< model.maxNumberOfDataParamsInModel BEFORE ',' SEPARATOR ','»1«ENDFOR»;
		}
		
		//////// helper for communication between roles /////////
		«FOR msg:model.allMessagesInModel SEPARATOR '\n'»
		«var roleparams = msg.formalRoleParamsBlock.params»
		«var dataparams = msg.formalDataParamsBlock.params»
		inline «msg.sndMsgHelperName»(receiver«FOR param:roleparams BEFORE ',' SEPARATOR ','»«param.variableName»«ENDFOR»«FOR param:dataparams BEFORE ',' SEPARATOR ','»«param.varName»«ENDFOR») {
			receiver!«msg.msgName»«
				»«FOR i : 0 ..< model.maxNumberOfRoleParamsInModel BEFORE ',' SEPARATOR ','»«
					»«IF i < roleparams.size»«roleparams.get(i).variableName»«ELSE»1«ENDIF»«
				»«ENDFOR»«
				»«FOR i : 0 ..< model.maxNumberOfDataParamsInModel BEFORE ',' SEPARATOR ','»«
					»«IF i < dataparams.size»«dataparams.get(i).varName»«ELSE»1«ENDIF»«
				»«ENDFOR»;
		}
		
		inline «msg.rcvMsgHelperName»(«FOR param:roleparams SEPARATOR ','»«param.variableName»«ENDFOR»«IF !roleparams.empty && !dataparams.empty»,«ENDIF»«FOR param:dataparams SEPARATOR ','»«param.varName»«ENDFOR») {
			self?«msg.msgName»«
				»«FOR i : 0 ..< model.maxNumberOfRoleParamsInModel BEFORE ',' SEPARATOR ','»«
					»«IF i < roleparams.size»«roleparams.get(i).variableName»«ELSE»1«ENDIF»«
				»«ENDFOR»«
				»«FOR i : 0 ..< model.maxNumberOfDataParamsInModel BEFORE ',' SEPARATOR ','»«
					»«IF i < dataparams.size»«dataparams.get(i).varName»«ELSE»1«ENDIF»«
				»«ENDFOR»;
		}
		«ENDFOR»
		'''
	}
}