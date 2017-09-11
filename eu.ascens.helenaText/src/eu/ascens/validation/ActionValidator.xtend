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
package eu.ascens.validation

import eu.ascens.helenaText.AbstractAssignment
import eu.ascens.helenaText.AbstractMessageCall
import eu.ascens.helenaText.ComponentAttributeSetter
import eu.ascens.helenaText.HelenaTextPackage
import eu.ascens.helenaText.IncomingMessageCall
import eu.ascens.helenaText.OperationCall
import eu.ascens.helenaText.OutgoingMessageCall
import eu.ascens.helenaText.PackageDeclaration
import eu.ascens.helenaText.RoleAttributeSetter
import eu.ascens.helenaText.util.Helper
import eu.ascens.helenaText.util.JvmTypesHelper
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static extension eu.ascens.helenaText.util.ExtensionMethods_Action.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*
import static extension eu.ascens.helenaText.util.JvmTypesHelper.*

class ActionValidator extends AbstractDeclarativeValidator {
	override register(EValidatorRegistrar registrar) {
		//not needed for classes used as ComposedCheck
	}
	
	/**
	 * Checks if the io call of a role behavior fit to the messages in the role type
	 * 1) msg-name exists in messages of the role type
	 * 2) direction is allowed in the message in the role type
	 * 3) given role params fit to the types of the role params in the message of the role type
	 * 4) given data params fit to the types of the data params in the message of the role type
	 * 5) the communication partner also accepts the message in inverse direction
	 * 
	 * ! We do not have to check that actual params are references to previously declared variables
	 * or params since they are defined as cross-references in Xtext
	 */
	@Check
	def check_action_messageCallsFitToRoleType(AbstractMessageCall call) {
		var rb = call.parentRoleBehavior;

		for (roleMsg : rb.roleTypeRef.rolemsgs) {
			if (call.msgName == roleMsg.name) {
				if (!call.directionMatches(roleMsg)) {
					error(
						'The underlying role type has to allow sending/receiving the message ' + call.msgName,
						call,
						HelenaTextPackage.Literals.ABSTRACT_MESSAGE_CALL__MSG_NAME,
						HelenaTextValidator.NOT_ALLOWED
					);
					return;
				}
				
				if (!call.roleParamsMatchInType(roleMsg)) {
					error(
						'The role parameters of the message ' + call.msgName + ' do not fit to the ones of the message in the role type.',
						call,
						call.roleParamsFeature,
						HelenaTextValidator.NOT_ALLOWED
					);
					return;
				}
				
				if (!call.dataParamsMatchInType(roleMsg)) {
					error(
						'The data parameters of the message ' + call.msgName + ' do not fit to the ones of the message in the role type.',
						call,
						call.dataParamsFeature,
						HelenaTextValidator.NOT_ALLOWED
					);
					return;
				}
				
				if (!call.communicationPartnerHasMatchingMsg()) {
					error(
						'The message ' + call.msgName + ' has to be allowed for the communication partner.',
						call,
						call.communicationPartnerFeature,
						HelenaTextValidator.MISSING_CONNECTION
					);
					return;
				}
				
				// everything was ok
				return;
			}
		}
		error(
			'The message ' + call.msgName + ' has to be a message of the role type ' + rb.roleTypeRef.name +
				"(possible msg[s]: " + Helper.joinToString(",", rb.roleTypeRef.rolemsgs.map[name]) + ")",
			HelenaTextPackage.Literals.ABSTRACT_MESSAGE_CALL__MSG_NAME,
			HelenaTextValidator.MISSING_CONNECTION
		);
	}
	
	private def static dispatch EStructuralFeature getRoleParamsFeature(IncomingMessageCall call) {
		return HelenaTextPackage.Literals.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK;
	}
	private def static dispatch EStructuralFeature getRoleParamsFeature(OutgoingMessageCall call) {
		return HelenaTextPackage.Literals.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK;
	}
	
	private def static dispatch EStructuralFeature getDataParamsFeature(IncomingMessageCall call) {
		return HelenaTextPackage.Literals.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK;
	}
	private def static dispatch EStructuralFeature getDataParamsFeature(OutgoingMessageCall call) {
		return HelenaTextPackage.Literals.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK;
	}
	
	private def static dispatch EStructuralFeature getCommunicationPartnerFeature(IncomingMessageCall call) {
		return HelenaTextPackage.Literals.ABSTRACT_MESSAGE_CALL__MSG_NAME;
	}
	private def static dispatch EStructuralFeature getCommunicationPartnerFeature(OutgoingMessageCall call) {
		return HelenaTextPackage.Literals.OUTGOING_MESSAGE_CALL__RECEIVER;
	}
	
	/**
	 * Checks whether an operation call fits to the operation in the component
	 * 1) the operation exists for the owner of the role type of the role behavior
	 * 2) the actual data params fit to the formal ones
	 * 3) only a operation with a return type is assigned to a variable
	 */
	@Check
	def check_action_operationForCorrectCompTypeInvoked(OperationCall call) {
		var op = call.operationType;
		
		if (op == null) {
			error(
				'The operation call did not invoke any operation of the owning component. '
				+ 'Allowed operations are ' + 
					Helper.joinToString(",", call.parentRoleBehavior.roleTypeRef.ownerComponentType.ops.map[it.name]) ,
				HelenaTextPackage.Literals.OPERATION_CALL__OP_NAME,
				HelenaTextValidator.NOT_ALLOWED
			);
			return;
		}

		if (!JvmTypesHelper.typesEqual(op.formalDataParamsBlock.params.map[it.type.type.wrappedType], call.actualDataParamsBlock.params.map[wrappedJvmType])) {
			error(
				'The data parameters of the message ' + call.opName + ' do not fit to the ones of the operation in the component type.',
				call,
				HelenaTextPackage.Literals.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK,
				HelenaTextValidator.NOT_ALLOWED
			);
			return;
		}
		
		if (op.returnType.type.isVoid && call.variable != null) {
			error(
				'An operation call of a void method cannot be assigned to a variable.',
				call,
				HelenaTextPackage.Literals.OPERATION_CALL__VARIABLE,
				HelenaTextValidator.NOT_ALLOWED
			);
			return;
		}
	}
	
	
	/**
	 * Checks whether get or create is called for a component instance
	 * which can actually play the given role type.
	 */
	@Check
	def check_action_compInstanceAllowedAsOwner(AbstractAssignment assignment) {
		if(!assignment.compInstance
		 	.isAllowedAsOwnerType(assignment.roleTypeRef)) { 
			error(
				'A role instance of type ' + assignment.roleTypeRef.name + 
					' cannot be owned by the given component instance. Allowed component types are ' + 
					Helper.joinToString(",", assignment.roleTypeRef.compTypes.map[name]) ,
				HelenaTextPackage.Literals.ABSTRACT_ASSIGNMENT__COMP_INSTANCE,
				HelenaTextValidator.NOT_ALLOWED
			);
		}
	}
	
	/**
	 * Checks if a setter is called with a value matching the type of the role attr
	 */
	@Check
	def check_action_setterValueMatches(RoleAttributeSetter setter) {
		if (setter.attr!=null && setter.value!= null &&
			!JvmTypesHelper.typesEqual(setter.attr.ref.type.type.wrappedType, setter.value.wrappedJvmType)) {
			error(
				'The type of the value assigned to the attribute must match the attribute\'s type.', 
				HelenaTextPackage.Literals.ROLE_ATTRIBUTE_SETTER__VALUE,
				HelenaTextValidator.MISSING_CONNECTION
			);
		}
	}
	
	/**
	 * Checks if a setter is called with a value matching the type of the component attr
	 */
	@Check
	def check_action_setterValueMatches(ComponentAttributeSetter setter) {
		if (setter.attr!=null && setter.value!= null &&
			!JvmTypesHelper.typesEqual(setter.attr.ref.type.type.wrappedType,  setter.value.wrappedJvmType)) {
			error(
				'The type of the value assigned to the attribute must match the attribute\'s type.', 
				HelenaTextPackage.Literals.COMPONENT_ATTRIBUTE_SETTER__VALUE,
				HelenaTextValidator.MISSING_CONNECTION
			);
		}
	}
	
	/**
	 * Checks for valid use of abstract assignment. If an abstract assignment, like getRole or createRole, is used in a role behavior,
	 * the role that shall be created or received has to be listed in all ensemble structure, where the role of the current
	 * role behavior can participate.
	 * If more than one ensemble structure exists that contains the role of the current role behavior, the role that shall be created/received
	 * has to be in all of them.  
	 */
	 @Check
	 def check_action_assignmentOfRoleTypeFromEnsembleStrucuture(AbstractAssignment assignment){
	 	val assignmentRT = assignment.roleTypeRef;
	 	val parentRT = assignment.parentRoleBehavior.roleTypeRef;
  		var allEnsembleStructs = (parentRT.eContainer as PackageDeclaration).ensStructs;
  		
 		for (ens : allEnsembleStructs){
 			var ensRoleTypes = ens.rtWithMult.map[roleType];
 			//If the parent role type is listed, but not the role type to get/create, an error is raised
 			if(ensRoleTypes.contains(parentRT) && !ensRoleTypes.contains(assignmentRT)){
				error(
					'To create/get a '+ assignmentRT.name +
					' here, the role type has to be listed in all ensemble structures where role type '+ parentRT.name +
					' participates. (Currently missing in ensemble structure: ' + ens.name + ')', 
					HelenaTextPackage.Literals.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF,
					HelenaTextValidator.MISSING_CONNECTION
				);	 
 			}
 		}
 		
	 }
	
}
