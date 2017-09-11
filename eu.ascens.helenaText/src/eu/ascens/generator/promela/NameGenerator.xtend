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
import eu.ascens.helenaText.AbstractDataValue
import eu.ascens.helenaText.AbstractDataVariableReference
import eu.ascens.helenaText.AbstractRoleInstance
import eu.ascens.helenaText.AbstractRoleInstanceReference
import eu.ascens.helenaText.Addition
import eu.ascens.helenaText.ComponentAssociationType
import eu.ascens.helenaText.ComponentAssociationTypeReference
import eu.ascens.helenaText.ComponentAttributeType
import eu.ascens.helenaText.ComponentAttributeTypeReference
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.CreateAssignment
import eu.ascens.helenaText.DataVariable
import eu.ascens.helenaText.FormalDataParam
import eu.ascens.helenaText.GetAssignment
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.OwnerReference
import eu.ascens.helenaText.PlaysQuery
import eu.ascens.helenaText.Process
import eu.ascens.helenaText.ProcessExpression
import eu.ascens.helenaText.RoleAttributeType
import eu.ascens.helenaText.RoleAttributeTypeReference
import eu.ascens.helenaText.RoleType
import eu.ascens.helenaText.SelfReference
import eu.ascens.helenaText.Subtraction
import org.eclipse.xtext.common.types.JvmTypeReference

class NameGenerator {
	@Inject TypesGenerator typeGen;
	
	def static getIfGotoLabel(ProcessExpression term) {
		return 'label' + term.hashCode;
	}
		
	def static getOperationTypeName(ComponentType ct) {
		return ct.name.toFirstUpper+'Operation';
	}
	
	def static getProctypeName(ComponentType ct) {
		return ct.name.toFirstUpper;
	}
	
	def static getStartLabelName(ComponentType ct) {
		return "start" + ct.name.toFirstUpper;
	}
	
	private def static getInlinePrefix(ComponentType ct) {
		return ct.name.toFirstLower + '_';
	}
	
	def static getRetrieveRole(ComponentType ct) {
		return ct.inlinePrefix + 'retrieveRole'
	}
	
	def static getQuitRole(ComponentType ct) {
		return ct.inlinePrefix + 'quitRole'
	}
	
	def static getIsPlaying(ComponentType ct) {
		return ct.inlinePrefix + 'isPlaying'
	}
	
	def static getRetrieveAssociation(ComponentType ct) {
		return ct.inlinePrefix + 'retrieveAssociation'
	}
	def static getOperationCall(ComponentType ct, OperationType op) {
		return ct.inlinePrefix + 'call' + op.name.toFirstUpper;
	}
	
	def static getGetterCompOperationName(ComponentAttributeType at) {
		return 'GET_' + at.name.toUpperCase;
	}
	
	def static getSetterCompOperationName(ComponentAttributeType at) {
		return 'SET_' + at.name.toUpperCase;
	}

	def static getGetterName(ComponentType ct, ComponentAttributeType at) {
		return ct.inlinePrefix + 'get' + at.name.toFirstUpper;
	}
	
	def static getSetterName(ComponentType ct, ComponentAttributeType at) {
		return ct.inlinePrefix + 'set' + at.name.toFirstUpper;
	}

	def static getCompProctypeParamName(ComponentAttributeType at) {
		return at.name.toFirstLower;
	}
	
	def static getVariableName(ComponentAttributeType at) {
		return 'compAttr_' + at.name.toFirstLower;
	}
	
	def static getGetterCompOperationName(ComponentAssociationType at) {
		return 'GET_' + at.name.toUpperCase;
	}
	
	def static getCompProctypeParamName(ComponentAssociationType at) {
		return at.name.toFirstLower;
	}
	
	def static getVariableName(ComponentAssociationType assoc) {
		return 'compAssoc_' + assoc.name.toFirstLower;
	}
	
	def static getOperationCompOperationName(OperationType op) {
		return 'OP_' + op.name.toUpperCase;
	}
	
	def dispatch static getCompOperationNameForAssignment(GetAssignment call) {
		return call.roleTypeRef.compOperationNameForGet;
	}
	def dispatch static getCompOperationNameForAssignment(CreateAssignment call) {
		return call.roleTypeRef.compOperationNameForCreate;
	}
	
	def static getVariableName(RoleAttributeType at) {
		return 'roleAttr_' + at.name.toFirstLower;
	}
	
	def static getMinName(RoleType rt) {
		return 'min' + rt.name.toFirstUpper;
	}
	
	def static getMaxName(RoleType rt) {
		return 'max' + rt.name.toFirstUpper;
	}
	
	def static getCurrentName(RoleType rt) {
		return 'current' + rt.name.toFirstUpper;
	}
	
	def static getChanName(RoleType rt) {
		return rt.name.toLowerCase;
	}
	
	def static getCompOperationNameForCreate(RoleType rt) {
		return 'CREATE_'+rt.name.toUpperCase;
	}
	
	def static getCompOperationNameForGet(RoleType rt) {
		return 'GET_'+rt.name.toUpperCase;
	}
	
	def static getCompOperationNameForQuit(RoleType rt) {
		return 'QUIT_'+rt.name.toUpperCase;
	}
	
	def static getCompOperationNameForPlays(RoleType rt) {
		return 'PLAYS_'+rt.name.toUpperCase;
	}
	
	def static getVariableNameForPlays(RoleType rt) {
		return 'plays'+rt.name.toFirstUpper;
	}

	def static getProctypeName(RoleType ct) {
		return ct.name.toFirstUpper;
	}
	
	def static getStartLabelName(RoleType ct) {
		return "start" + ct.name.toFirstUpper;
	}
	
	def static getEndLabelName(RoleType ct) {
		return "end" + ct.name.toFirstUpper;
	}
	
	def static getPromelaType(JvmTypeReference type) {
		switch type.type.simpleName {
			case "byte": return "byte"
			case "short": return "short"
			case "int": return "int"
			case "boolean": return "bool"
			default: return type.type.simpleName
		}
	}
	
	def static getMsgName(MessageType msg) {
		return msg.name.toFirstLower;
	}
	
	def static getVariableName(MessageType msg) {
		return msg.name.toFirstLower + 'Msg';
	}
	
	def static getSndMsgHelperName(MessageType msg) {
		return 'send_' + msg.name.toFirstLower;
	}
	
	def static getRcvMsgHelperName(MessageType msg) {
		return 'receive_' + msg.name.toFirstLower;
	}
	
	def static getLabel(Process process) {
		return "process" + process.name;
	}
	
	def dispatch static getCompInstanceName(OwnerReference reference) {
		return "owner";
	}
	def dispatch static getCompInstanceName(ComponentAssociationTypeReference reference) {
		return reference.ref.variableName;
	}
	
	def static getVariableName(PlaysQuery query) {
		return query.compInstance.compInstanceName + "Plays" + query.roleTypeRef.name.toFirstUpper;
	}
	
	def static getVariableName(AbstractRoleInstance param) {
		return param.name.toFirstLower;
	}
	
	def dispatch static getVarName(FormalDataParam param) {
		return param.name.toFirstLower;
	}
	def dispatch static getVarName(DataVariable param) {
		return param.name.toFirstLower;
	}
	
	def dispatch static getRoleInstance(SelfReference param) {
		return 'self';
	}
	def dispatch static getRoleInstance(AbstractRoleInstanceReference param) {
		return param.ref.variableName;
	}
	
	def dispatch String getDataValue(Addition exp) {
		return exp.left.dataValue + exp.operator + exp.right.dataValue;
	}
	def dispatch String getDataValue(Subtraction exp) {
		return exp.left.dataValue + exp.operator + exp.right.dataValue;
	}
	def dispatch getDataValue(AbstractDataVariableReference param) {
		return param.ref.varName;
	}
	def dispatch getDataValue(RoleAttributeTypeReference param) {
		return param.ref.variableName;
	}
	def dispatch getDataValue(ComponentAttributeTypeReference param) {
		return param.ref.variableName;
	}
	def dispatch getDataValue(AbstractDataValue param){
		typeGen.getValueFromXExpression(param.value);
	}
	
	
	
	def static getLabelName(Label label) {
		return label.name.toFirstLower;
	}
}