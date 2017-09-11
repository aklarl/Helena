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
import eu.ascens.helenaText.ComponentAssociationTypeReference
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.MsgDirection
import eu.ascens.helenaText.OwnerReference
import eu.ascens.helenaText.RoleBehavior
import eu.ascens.helenaText.RoleInstanceVariable
import eu.ascens.helenaText.RoleType
import java.util.HashSet
import java.util.Set

class ExtensionMethods_RoleType {
	
	/**
	 * Returns type of the owner
	 */
	def static ComponentType getOwnerComponentType(RoleType rt) {
		return rt.compTypes.get(0);
	}
	
	/**
	 * Returns whether the type of the given component instance is allowed as owner of the given role type
	 * 
	 */
	 def dispatch static boolean isAllowedAsOwnerType(ComponentAssociationTypeReference reference, RoleType rt) {
	 	if (reference.ref != null) {
		 	return rt.compTypes.contains(reference.ref.type);
	 	}
	 	else return false;
	 }
	 def dispatch static boolean isAllowedAsOwnerType(OwnerReference reference, RoleType rt) {
	 	return true;
	 }
	
	
	/**
	 * Returns the state machine role behavior for a role type
	 */
	def static RoleBehavior getRoleBehavior(RoleType rt) {
		var container = rt.eContainer;
		while ( !(container instanceof Model) ) {
			container = container.eContainer;
		}
		
		var model = container as Model;
		return model.headPkg.roleBehaviors.findFirst[it.roleTypeRef == rt];
	}
	
	/**
	 * Returns the role type of a role instance variable
	 */
	def static RoleType getRoleType(RoleInstanceVariable inst){
		var container = inst.eContainer;
		while ( !(container instanceof AbstractAssignment) ) {
			container = container.eContainer;
		}
		
		var assignment = container as AbstractAssignment;
		return assignment.roleTypeRef;
	}

	/**
	 * Returns the role message of a role type with name 'name'; null otherwise
	 */
	def static MessageType getRoleMsg(RoleType rt, String name) {
		return rt.rolemsgs.findFirst[it.name == name];
	}

	/**
	 * Returns a list of all role messages of a role type
	 * with the given msg direction (caution: in/out matches in resp. out)
	 */
	def static Iterable<MessageType> getAllMessagesOfDirection(RoleType rt, MsgDirection msgDirection) {
		return rt.rolemsgs.filter[msg | ofSameMsgDirection(msg.direction, msgDirection)];
	}
	
	/**
	 * Returns true if two messages are of the same type 
	 * (both in, both out, both in/out, one in/out and one in or out)
	 */
	private def static boolean ofSameMsgDirection(MsgDirection msgType1, MsgDirection msgType2) {
		return msgType1.equals(msgType2) ||
			((msgType1.equals(MsgDirection.IN) || msgType1.equals(MsgDirection.OUT)) && msgType2.equals(MsgDirection.INOUT)) ||
			((msgType2.equals(MsgDirection.IN) || msgType2.equals(MsgDirection.OUT)) && msgType1.equals(MsgDirection.INOUT));
	}
	
	/**
	 * Returns the set of all messages in the model 
	 * not taking care of parameters!! or direction!!
	 */
	def static Iterable<MessageType> getAllMessagesInModel(Model model) {
		var Set<MessageType> messages = new HashSet<MessageType>();
		var Set<String> names = new HashSet<String>();
		
		for (rt : model.headPkg.roleTypes) {
			for (msg : rt.rolemsgs) {
				if (!names.contains(msg.name)) {
					names.add(msg.name);
					messages.add(msg);
				}
			}
		}
		return messages;
	}
}