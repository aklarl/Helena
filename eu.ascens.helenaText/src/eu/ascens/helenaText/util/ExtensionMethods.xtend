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

import eu.ascens.helenaText.AbstractDataVariable
import eu.ascens.helenaText.AbstractFieldType
import eu.ascens.helenaText.AbstractHelenaEntity
import eu.ascens.helenaText.AbstractInstance
import eu.ascens.helenaText.AbstractRoleInstance
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.IncomingMessageCall
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.Process
import eu.ascens.helenaText.RoleBehavior
import java.util.ArrayList
import java.util.List
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XSetLiteral
import org.eclipse.xtext.xbase.XStringLiteral

public class ExtensionMethods {


	//Get name for AbstractDuplicateFreeObject
	def dispatch static String getName(AbstractFieldType at) {
		return at.name;
	}
	def dispatch static String getName(MessageType mt) {
		return mt.name;
	}
	def dispatch static String getName(OperationType mt) {
		return mt.name;
	}
	def dispatch static String getName(AbstractHelenaEntity entity) {
		return entity.name;
	}
	def dispatch static String getName(RoleBehavior rb) {
		return rb.roleTypeRef.name;
	}
	def dispatch static String getName(Process process) {
		return process.name;
	}
	def dispatch static String getName(Label label) {
		return label.name;
	}
	def dispatch static String getName(AbstractRoleInstance inst) {
		return inst.name;
	}
	def dispatch static String getName(AbstractDataVariable variable) {
		return variable.name;
	}


	//Get name for AbstractInstance
	def static getInstName(AbstractInstance inst){
		return inst.getInstName_
	}
	private def static dispatch getInstName_(AbstractDataVariable dataVar){
		return dataVar.name;
	}
	private def static dispatch getInstName_(AbstractRoleInstance roleInst){
		return roleInst.name
	}

	def static String getJavaIdentifier(XExpression expr){
		switch expr {
			case expr instanceof XStringLiteral:
				return "java.lang.String"
			case expr instanceof XBooleanLiteral:
				return "java.lang.Boolean"
			case expr instanceof XNumberLiteral:
				return "java.lang.Double"
			case expr instanceof XListLiteral:
				return "java.util.List"
			case expr instanceof XSetLiteral:
				return "java.util.Set"
		}
	}
	
	/**
	 * Checks whether all incoming call use the same message
 	*/
	def static boolean allMsgNamesEqual(List<IncomingMessageCall> inCalls){
		return inCalls.forall[it.msgName == inCalls.head.msgName]
	}
 	 
	
	/**
	 * @return All attributes and assocs of a component type
	 */
	def static List<AbstractFieldType> getFields(ComponentType ct){
		var List<AbstractFieldType> fields = new ArrayList();
		fields.addAll(ct.attrs);
		fields.addAll(ct.assocs);
		return fields;
	}
	
}
