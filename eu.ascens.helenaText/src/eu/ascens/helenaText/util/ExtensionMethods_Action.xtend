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
package eu.ascens.helenaText.util

import eu.ascens.helenaText.AbstractAssignment
import eu.ascens.helenaText.AbstractMessageCall
import eu.ascens.helenaText.AbstractRoleInstance
import eu.ascens.helenaText.Action
import eu.ascens.helenaText.DataExpression
import eu.ascens.helenaText.FormalDataParam
import eu.ascens.helenaText.IncomingMessageCall
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.MsgDirection
import eu.ascens.helenaText.OperationCall
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.OutgoingMessageCall
import eu.ascens.helenaText.RoleInstanceReference
import eu.ascens.helenaText.RoleType
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.List
import org.eclipse.xtext.common.types.JvmType

import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*
import static extension eu.ascens.helenaText.util.Helper.*
import static extension eu.ascens.helenaText.util.JvmTypesHelper.*
import eu.ascens.helenaText.DataVariable

class ExtensionMethods_Action {
	
	/** 
	 * Returns the operation type which corresponds to this call 
	 */
	def static OperationType getOperationType(OperationCall call) {
		var owner = call.parentRoleBehavior.roleTypeRef.ownerComponentType;
		for (OperationType op : owner.ops) {
			if (call.opName.equals(op.name)) {
				return op;
			}
		}
		return null;
	}
	
	/**
	 * Returns the message type which corresponds to this call
	 */
	def static MessageType getMessageType(AbstractMessageCall call) {
		var rb = call.parentRoleBehavior;
		for (roleMsg : rb.roleTypeRef.rolemsgs) {
			//it is ensured by validation in HelenaText that there exists one!
			if (call.msgName == roleMsg.name) {
				return roleMsg;
			}
		}
		return null;
	}
	
	/**
	 * Checks that the direction of the declared message type fits to the used direction in the io-call
	 */
	def dispatch static boolean directionMatches(IncomingMessageCall call, MessageType msg) {
		return MsgDirection.IN == msg.direction || MsgDirection.INOUT == msg.direction;
	}
	def dispatch static boolean directionMatches(OutgoingMessageCall call, MessageType msg) {
		return MsgDirection.OUT == msg.direction || MsgDirection.INOUT == msg.direction;
	}
	
	/**
	 * Checks that the direction of the declared message type is the inverse of the used direction in the io-call
	 */
	def dispatch static boolean directionInverse(IncomingMessageCall call, MessageType msg) {
		return MsgDirection.OUT == msg.direction || MsgDirection.INOUT == msg.direction;
	}
	def dispatch static boolean directionInverse(OutgoingMessageCall call, MessageType msg) {
		return MsgDirection.IN == msg.direction || MsgDirection.INOUT == msg.direction;
	}
	
	/**
	 * Checks that the given (formal or actual) role params fit in type to the formal role params
	 * of the declared message type
	 */
	def dispatch static boolean roleParamsMatchInType(IncomingMessageCall call, MessageType roleMsg) {
		return Helper.equals(roleMsg.formalRoleParamsBlock.params.map[type], call.formalRoleParamsBlock.params.map[type]);
	}
	def dispatch static boolean roleParamsMatchInType(OutgoingMessageCall call , MessageType roleMsg) {
		return Helper.equals(roleMsg.formalRoleParamsBlock.params.map[type], call.actualRoleParamsTypes);
	}
	
	/**
	 * Retrieves an ordered list of the  role types of all actual role params of the outgoing call
	 */
	private def static List<RoleType> getActualRoleParamsTypes(OutgoingMessageCall call) {
		var List<RoleType> roleTypes = new ArrayList<RoleType>();	
		for (RoleInstanceReference actualRoleParam: call.actualRoleParamsBlock.params) {
			roleTypes.add(actualRoleParam.roleTypeForRef);
		}
		return roleTypes;
	}
	
	/**
	 * Checks that the given (formal or actual) data params fit in type to the formal data params
	 * of the declared messsage type
	 */
	def dispatch static boolean dataParamsMatchInType(IncomingMessageCall call, MessageType roleMsg) {
		return JvmTypesHelper.typesEqual(roleMsg.formalDataParamsBlock.params.map[type.type.wrappedType], call.formalDataParamsBlock.params.map[type.type.wrappedType]);
	}
	def dispatch static boolean dataParamsMatchInType(OutgoingMessageCall call, MessageType roleMsg) {
		return JvmTypesHelper.typesEqual(roleMsg.formalDataParamsBlock.params.map[type.type.wrappedType], call.actualDataParamsTypes.map[wrappedType]);
	}
	
	/**
	 * Retrieves an ordered list of the jvm types as strings of all actual data params of the outgoing call
	 */
	private def static List<JvmType> getActualDataParamsTypes(OutgoingMessageCall call) {
		var List<JvmType> dataTypes = new ArrayList<JvmType>();	
		for (DataExpression actualDataParam: call.actualDataParamsBlock.params) {
			dataTypes.add(actualDataParam.wrappedJvmType);
		}
		return dataTypes;
	}
	
	
	/**
	 * Checks whether the role type of the communication partner also allows the
	 * message with inverse message direction
	 */
	def dispatch static boolean communicationPartnerHasMatchingMsg(IncomingMessageCall call) {
		return true;
	}
	def dispatch static boolean communicationPartnerHasMatchingMsg(OutgoingMessageCall call) {
		for (roleMsg : call.receiver.roleTypeForRef.rolemsgs) {
			if (call.msgName == roleMsg.name) {
				if (!call.directionInverse(roleMsg)) {
					return false;
				}
				if (!call.roleParamsMatchInType(roleMsg)) {
					return false;
				}
				if (!call.dataParamsMatchInType(roleMsg)) {
					return false;
				}
				
				// everything was alright
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns all abstract role instances in an action
	 */
	def dispatch static Collection<AbstractRoleInstance> getAbstractRoleInstances(Action action) {
		return new HashSet;
	}
	def dispatch static Collection<AbstractRoleInstance> getAbstractRoleInstances(IncomingMessageCall action) {
		var list = new HashSet<AbstractRoleInstance>;
		list.addAll(action.formalRoleParamsBlock.params);
		return list;
	}
	def dispatch static Collection<AbstractRoleInstance> getAbstractRoleInstances(AbstractAssignment action) {
		return action.roleInst.asList;
	}
	
	/**
	 * Returns all formal data params in an action
	 */
	def dispatch static Collection<FormalDataParam> getFormalDataParams(Action action) {
		return new HashSet;
	}
	def dispatch static Collection<FormalDataParam> getFormalDataParams(IncomingMessageCall action) {
		var list = new HashSet;
		list.addAll(action.formalDataParamsBlock.params);
		return list;
	}
	
	/**
	 * Returns all data variables in an action
	 */
	def dispatch static Collection<DataVariable> getOpDataVariables(Action action) {
		return new HashSet;
	}
	def dispatch static Collection<DataVariable> getOpDataVariables(OperationCall action) {
		var list = new HashSet;
		if (action.operationType.returnType != null) {
			list.add(action.variable);
			
		}
		return list;
	}
	
	/**
	 * Returns all abstract data variables in an action
	 */
	def dispatch static Collection<Label> getLabels(Action action) {
		return new HashSet;
	}
	def dispatch static Collection<Label> getLabels(Label action) {
		return action.asList;
	}
}