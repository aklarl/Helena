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
import eu.ascens.helenaText.AbstractDataReference
import eu.ascens.helenaText.AbstractDataValue
import eu.ascens.helenaText.AbstractDataVariable
import eu.ascens.helenaText.AbstractDataVariableReference
import eu.ascens.helenaText.AbstractRoleInstance
import eu.ascens.helenaText.AbstractRoleInstanceReference
import eu.ascens.helenaText.Addition
import eu.ascens.helenaText.BooleanValue
import eu.ascens.helenaText.ComponentAssociationTypeReference
import eu.ascens.helenaText.ComponentAttributeTypeReference
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.DataVariable
import eu.ascens.helenaText.FormalDataParam
import eu.ascens.helenaText.FormalRoleParam
import eu.ascens.helenaText.NumberValue
import eu.ascens.helenaText.OperationCall
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.OwnerReference
import eu.ascens.helenaText.RoleAttributeTypeReference
import eu.ascens.helenaText.RoleInstanceVariable
import eu.ascens.helenaText.RoleType
import eu.ascens.helenaText.SelfReference
import eu.ascens.helenaText.StringValue
import eu.ascens.helenaText.Subtraction
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.xbase.XNumberLiteral

import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*
import static extension eu.ascens.helenaText.util.JvmTypesHelper.*

class ExtensionMethods_Param {
	
	/**
	 * Returns the component type of a component instance
	 */
	def dispatch static ComponentType getComponentType(ComponentAssociationTypeReference association) {
		return association.ref.type;
	}
	def dispatch static ComponentType getComponentType(OwnerReference reference) {
		return reference.parentRoleBehavior.roleTypeRef.ownerComponentType;
	}
	
	/**
	 * Returns the type for a role instance reference via the parent role behavior
	 * @null if type cannot be detected
	 * 
	 */
	def dispatch static RoleType getRoleTypeForRef(AbstractRoleInstanceReference reference) {
		return reference.ref.roleType;
	}
	def dispatch static RoleType getRoleTypeForRef(SelfReference reference) {
	 	return reference.parentRoleBehavior.roleTypeRef;
	}
	
	/**
	 * Returns the role type of a role instance variable
	 */
	def dispatch static RoleType getRoleType(RoleInstanceVariable variable){
		var container = variable.eContainer;
		while ( !(container instanceof AbstractAssignment) ) {
			container = container.eContainer;
		}
		
		var call = container as AbstractAssignment;
		return call.roleTypeRef;
	}
	def dispatch static RoleType getRoleType(FormalRoleParam param) { 
		return param.type;
	}
	def dispatch static RoleType getRoleType(AbstractRoleInstance param) {
		return null;
	}
	
	
	//Get JVM type from data expression
	def static dispatch JvmType getWrappedJvmType(Addition exp) {
		return exp.left.wrappedJvmType
	}
	def static dispatch JvmType getWrappedJvmType(Subtraction exp) {
		return exp.left.wrappedJvmType
	}
	def static dispatch JvmType getWrappedJvmType(AbstractDataReference dataRef) {
		return dataRef.jvmTypeForAbstrDataRef.wrappedType;
	}
	def static dispatch JvmType getWrappedJvmType(AbstractDataValue dataValue){
		return dataValue.getWrappedJvmTypeFromValue;
	}
	
	def static dispatch JvmType getWrappedJvmTypeFromValue(StringValue stringValue){
		return createJvmType(String.simpleName) 
	}
	def static dispatch JvmType getWrappedJvmTypeFromValue(BooleanValue booleanValue){
		return createJvmType(Boolean.simpleName) 
	}
	def static dispatch JvmType getWrappedJvmTypeFromValue(NumberValue numberValue){
		var value = (numberValue.value as XNumberLiteral).value;
		if (value.contains('.')) 
			return createJvmType(Double.simpleName) 
		else 
			return createJvmType(Integer.simpleName) 
	}
		
	/**
	 * Returns the type for a data expression via the parent role behavior
	 * @null if type cannot be detected
	 * 
	 */
	private def dispatch static JvmType getJvmTypeForAbstrDataRef(AbstractDataVariableReference reference) {
	 	return reference.ref.jvmTypeRefFromAbstrDataVar.type;
	}
	private def dispatch static JvmType getJvmTypeForAbstrDataRef(RoleAttributeTypeReference reference) {
		return reference.ref.type.type;
	}
	private def dispatch static JvmType getJvmTypeForAbstrDataRef(ComponentAttributeTypeReference reference) {
		return reference.ref.type.type;
	}
	 
	/**
	 * Returns the jvm type of a data variable
	 */
	def dispatch static JvmTypeReference getJvmTypeRefFromAbstrDataVar(DataVariable variable){
		var container = variable.eContainer;
		while ( !(container instanceof OperationCall) ) {
			container = container.eContainer;
		}
		
		var call = container as OperationCall;
		
		var owner = variable.parentRoleBehavior.roleTypeRef.ownerComponentType;
		for (OperationType op : owner.ops) {
			if (op.name.equals(call.opName)) {
				return op.returnType;
			}
		}
	}
	def dispatch static JvmTypeReference getJvmTypeRefFromAbstrDataVar(FormalDataParam param) { 
		return param.type;
	}
	def dispatch static JvmTypeReference getJvmTypeRefFromAbstrDataVar(AbstractDataVariable dataVar){
		return null;
	}
	
}