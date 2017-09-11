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
import eu.ascens.helenaText.AbstractAssignment
import eu.ascens.helenaText.Action
import eu.ascens.helenaText.ComponentAttributeSetter
import eu.ascens.helenaText.IncomingMessageCall
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.OperationCall
import eu.ascens.helenaText.OutgoingMessageCall
import eu.ascens.helenaText.RoleAttributeSetter

import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.generator.promela.OperationCallGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Action.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

class ActionGenerator {
	@Inject NameGenerator nameGenerator;
	@Inject OperationCallGenerator opCallGenerator;
	
	def CharSequence compileAction(Action action) {
		return action.compileAction_;
	}
	
	/**
	 * Compiles an incoming call action:
	 * - for each (role or data) param, a local variable is declared
	 * - the corresponding incoming msg is received via the own channel via a msg helper
	 */
	def dispatch CharSequence compileAction_(IncomingMessageCall call) {
		var roleparams = call.formalRoleParamsBlock.params;
		var dataparams = call.formalDataParamsBlock.params;
		
		'''
		
		// incoming message
		«call.messageType.rcvMsgHelperName»(«FOR param:roleparams SEPARATOR ','»«param.variableName»«ENDFOR»«IF roleparams.size!=0 && dataparams.size!=0»,«ENDIF»«FOR param:dataparams SEPARATOR ','»«param.varName»«ENDFOR»)'''
	}
	
	/**
	 * Compiles an outgoing call action:
	 * - for each data param, the value is retrieved from the component (only necessary if it is a component attribute)
	 * - the corresponding outgoing msg is sent via a msg helper
	 */
	def dispatch CharSequence compileAction_(OutgoingMessageCall call) {
		var roleparams = call.actualRoleParamsBlock.params;
		var dataparams = call.actualDataParamsBlock.params;
		
		'''
		
		// outgoing message
		«FOR param:dataparams»«param.retrieveDataValueFromOwner»«ENDFOR»
		«call.messageType.sndMsgHelperName»(«call.receiver.roleInstance»«FOR param:roleparams BEFORE ',' SEPARATOR ','»«param.roleInstance»«ENDFOR»«FOR param:dataparams BEFORE ','  SEPARATOR ','»«nameGenerator.getDataValue(param)»«ENDFOR»)'''
	}
	
	/**
	 * Compiles a create or get action:
	 * - the component instance where to create or get the role is retrieved from the owner
	 * - a local variable for the channel to the new role instance is declared
	 * - the retrieval is issued by calling an operation on the target component
	 */
	def dispatch CharSequence compileAction_(AbstractAssignment call) {
		'''
		
		// retrieve reference to component instance
		«call.compInstance.retrieveCompInstanceFromOwner»
		
		// create/get role instance
		«call.compInstance.componentType.compileOperationCall(call)»'''
	}
	
	/**
	 * Compiles a setter of a role attribute
	 */
	def dispatch compileAction_(RoleAttributeSetter setter) {
		'''
		
		// set role attr
		«setter.value.retrieveDataValueFromOwner»
		«setter.attr.ref.variableName» = «nameGenerator.getDataValue(setter.value)»'''
	}
	
	/**
	 * Compiles a setter of a component attribute
	 */
	def dispatch compileAction_(ComponentAttributeSetter setter) {
		var owner = setter.parentRoleBehavior.roleTypeRef.ownerComponentType;
		'''
		
		// set comp attr
		«setter.value.retrieveDataValueFromOwner»
		«opCallGenerator.compileSetterOperationCall(owner, setter.attr.ref, setter.value)»'''
	}
	
	def dispatch compileAction_(OperationCall call) {
		var owner = call.parentRoleBehavior.roleTypeRef.ownerComponentType;
		var op = call.operationType;
		'''
		
		// call operation at component
		«FOR param : call.actualDataParamsBlock.params»«param.retrieveDataValueFromOwner»«ENDFOR»
		«IF op.returnType.type.isVoid»«
			»«opCallGenerator.compileOperationCall(owner, call.operationType, call.actualDataParamsBlock.params)»«
		»«ELSE»«
			»«opCallGenerator.compileOperationCall(owner, call.operationType, call.variable, call.actualDataParamsBlock.params)»«
		»«ENDIF»''' 
	}
	
	def dispatch CharSequence compileAction_(Label label) {
		'''
		
		// state label
		«label.labelName»: true'''
	}
}