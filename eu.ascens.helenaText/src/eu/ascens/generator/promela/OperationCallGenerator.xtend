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
import eu.ascens.helenaText.AbstractDataValue
import eu.ascens.helenaText.AbstractDataVariableReference
import eu.ascens.helenaText.Addition
import eu.ascens.helenaText.ComponentAssociationTypeReference
import eu.ascens.helenaText.ComponentAttributeType
import eu.ascens.helenaText.ComponentAttributeTypeReference
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.DataExpression
import eu.ascens.helenaText.DataVariable
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.OwnerReference
import eu.ascens.helenaText.PlaysQuery
import eu.ascens.helenaText.RoleAttributeTypeReference
import eu.ascens.helenaText.Subtraction

import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

class OperationCallGenerator {
	
	@Inject NameGenerator nameGenerator;
	/**
	 * Retrieves the value for a given expression from the owner (if necessary)
	 */
	def dispatch static CharSequence retrieveDataValueFromOwner(Addition param) {
		param.left.retrieveDataValueFromOwner;
		param.right.retrieveDataValueFromOwner;
	}
	def dispatch static CharSequence retrieveDataValueFromOwner(Subtraction param) {
		param.left.retrieveDataValueFromOwner;
		param.right.retrieveDataValueFromOwner;
	}
	def dispatch static CharSequence retrieveDataValueFromOwner(AbstractDataVariableReference param) {
		''''''
	}
	def dispatch static CharSequence retrieveDataValueFromOwner(RoleAttributeTypeReference param) {
		''''''
	}
	def dispatch static CharSequence retrieveDataValueFromOwner(ComponentAttributeTypeReference param) {
		param.parentRoleBehavior.roleTypeRef.ownerComponentType.compileGetterOperationCall(param.ref);
	}
	def dispatch static CharSequence retrieveDataValueFromOwner(AbstractDataValue value){
		''''''
	}
	
	/**
	 * Retrieves the channel to a component instance from the owner (if necessary)
	 */
	def dispatch static CharSequence retrieveCompInstanceFromOwner(OwnerReference ref) {
		''''''
	}
	def dispatch static CharSequence retrieveCompInstanceFromOwner(ComponentAssociationTypeReference association) {
		'''«association.parentRoleBehavior.roleTypeRef.ownerComponentType.compileGetterOperationCall(association)»;'''
	}
	
	/**
	 * Compiles the operation call to the owner to retrieve the owner's attribute value
	 */
	def static compileGetterOperationCall(ComponentType owner, ComponentAttributeType attr) {
		'''«owner.getGetterName(attr)»(owner,«attr.variableName»);'''
	}
	
	/**
	 * Compiles the operation call to the owner to retrieve the owner's attribute value
	 */
	def compileSetterOperationCall(ComponentType owner, ComponentAttributeType attr, DataExpression value) {
		'''«owner.getSetterName(attr)»(owner,«nameGenerator.getDataValue(value)»)'''
	}
	
	/**
	 * Compiles the operation call to call the given operation of the owner (with result type)
	 */
	def compileOperationCall(ComponentType owner, OperationType op, DataVariable result, DataExpression... params) {
		'''«owner.getOperationCall(op)»(owner«FOR param:params BEFORE ',' SEPARATOR ','»«nameGenerator.getDataValue(param)»«ENDFOR»«IF result != null»,«result.varName»«ENDIF»)'''
	}
	/**
	 * Compiles the operation call to call the given operation of the owner
	 */
	def compileOperationCall(ComponentType owner, OperationType op, DataExpression... params) {
		owner.compileOperationCall(op, null, params);
	}
	
	/**
	 * Compiles the operation call to the owner to retrieve the owner's association value
	 */
	def static compileGetterOperationCall(ComponentType owner, ComponentAssociationTypeReference association) {
		'''«owner.retrieveAssociation»(«association.ref.getterCompOperationName»,owner,«association.compInstanceName»)'''
	}
	
	/**
	 * Compiles the operation call whether a given target component is playing a given role
	 */
	def static compileOperationCall(ComponentType target, PlaysQuery query) {
		'''«target.isPlaying»(«query.roleTypeRef.compOperationNameForPlays»,«query.compInstance.compInstanceName»,«query.variableName»)'''
	}
	
	/**
	 * Compiles the operation call to create or get the given role from the given target component
	 */
	def static compileOperationCall(ComponentType target, AbstractAssignment call) {
		'''«target.retrieveRole»(«call.compOperationNameForAssignment»,«call.compInstance.compInstanceName»,«call.roleInst.variableName»)'''
	}
}