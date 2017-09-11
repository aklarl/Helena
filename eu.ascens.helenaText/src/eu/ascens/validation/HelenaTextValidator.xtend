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

import com.google.inject.Inject
import eu.ascens.helenaText.AbstractDataVariable
import eu.ascens.helenaText.AbstractDuplicateFreeObject
import eu.ascens.helenaText.AbstractFieldType
import eu.ascens.helenaText.AbstractHelenaEntity
import eu.ascens.helenaText.AbstractRoleInstance
import eu.ascens.helenaText.ComponentAttributeType
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.EnsembleStructure
import eu.ascens.helenaText.HelenaTextPackage
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.MsgDirection
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.RoleAttributeType
import eu.ascens.helenaText.RoleBehavior
import eu.ascens.helenaText.RoleType
import java.util.ArrayList
import java.util.List
import java.util.Set
import java.util.TreeSet
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

import static extension eu.ascens.helenaText.util.ExtensionMethods.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class HelenaTextValidator extends AbstractHelenaTextValidator {

	@Inject protected TypeReferenceSerializer serializer

	public static val HAS_TO_START_LOWERCASE = 'lower case'
	public static val HAS_TO_START_UPPERCASE = 'upper case'

	public static val NOT_ALLOWED = 'not allowed'
	public static val NOT_DISJOINT = 'not disjoint'
	public static val MISSING_CONNECTION = 'missing connection'
	public static val KEYWORD_NOT_ALLOWED = 'keyword is not allowed in this context'
	public static val DUPLICATE = 'duplicate'
	public static val MULT_RANGE_WRONG = 'multiplicity range wrong'

	/**
	 * Checks if duplicate elements (component types, role types, ensemble structures, role behaviors) were defined 
	 */
	@Check
	def check_model_hasDuplicateModelElements(Model m) {
		findDuplicates(m.headPkg.compTypes); // CT is a SET of component types
		findDuplicates(m.headPkg.roleTypes); // an ensemble structure allows only a SET of role types
		findDuplicates(m.headPkg.ensStructs);
		findDuplicates(m.headPkg.roleBehaviors); // an ensemble specification only allows a FAMILY of role behaviors
		
		for (ComponentType ct : m.headPkg.compTypes) {
			findDuplicates(ct.attrs); // each component type has a SET of attribute types
			findDuplicates(ct.assocs); // each component type has a SET of component types
			findDuplicates(ct.ops); // each component type has a SET of operations
		}
		for (RoleType rt : m.headPkg.roleTypes) {
			findDuplicates(rt.compTypes, HelenaTextPackage.Literals::ROLE_TYPE__COMP_TYPES); // each role type has a non-empty SET of component types
			findDuplicates(rt.roleattrs); // each role type has a SET of attributes types
			findDuplicates(rt.rolemsgs.
				filter[direction == MsgDirection.OUT || direction == MsgDirection.INOUT]
			); // each role type has SET of outgoing messages
			findDuplicates(rt.rolemsgs.filter[direction == MsgDirection.IN || direction == MsgDirection.INOUT]); // each role type has SET of incoming messages
		}
		for (EnsembleStructure es : m.headPkg.ensStructs) {
			findDuplicates(es.rtWithMult.map[roleType]); // each ensemble structure has a SET of role types
		}
		for (RoleBehavior rb : m.headPkg.roleBehaviors) {
			findDuplicates(rb.processes); 
			findDuplicates(rb.labels); // state labels must be unique
			
			//Checks if a duplicate variable declaration exists in a role behavior. Variable names have to be unique 
			//both for instances from the role behavior and for variables declared in the corresponding role type 
			var List<AbstractDuplicateFreeObject> allVariables = new ArrayList();
			allVariables.addAll(rb.roleTypeRef.roleattrs);
			allVariables.addAll(rb.abstractRoleInstances);
			allVariables.addAll(rb.formalDataParams);
			allVariables.addAll(rb.opDataVariables);
			findDuplicates(allVariables);
		}
	}

	/**
	 * Checks for duplicates in list. If the method finds a duplicate, an error is raised
	 */
	private def void findDuplicates(Iterable<? extends AbstractDuplicateFreeObject> list) {
		findDuplicates(list, null);
	}

	/**
	 * @param list List that is checked for duplicates 
	 * @param optionalFeature optional structural feature; if this parameter is null the function calculates the corresponding name feature for each list element 
	 */
	private def void findDuplicates(Iterable<? extends AbstractDuplicateFreeObject> list, EStructuralFeature optionalFeature) {
		var feature = optionalFeature;
		var Set<String> nameSet = new TreeSet();

		for (AbstractDuplicateFreeObject elem : list.filterNull) {
			if (!nameSet.add(elem.name)) {
				if (feature == null) feature = elem.duplicateFreeObjectFeature;
				error(
					'Duplicate declaration of ' + elem.name,
					elem,
					feature,
					DUPLICATE
				)
			}
		}
	}


	@Check
	def check_helenaEntity_startsWithUppercase(AbstractHelenaEntity elem) {
		if (!Character.isUpperCase(elem.name.charAt(0))) {
			warning(
				'Names of declared types should start with a capital letter',
				HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME,
				HelenaTextValidator.HAS_TO_START_UPPERCASE
			)
		}
	}

	@Check
	def check_attrType_startsWithLowercase(AbstractFieldType attr) {
		if (!Character.isLowerCase(attr.name.charAt(0))) {
			warning(
				'Attribute names should start with a lower-case letter',
				HelenaTextPackage.Literals.ABSTRACT_FIELD_TYPE__NAME,
				HAS_TO_START_LOWERCASE
			)
		}
	}
	
	@Check
	def check_messageType_startsWithLowercase(MessageType mt) {
		if (!Character.isLowerCase(mt.name.charAt(0))) {
			warning(
				'Message or RoleMessage names should start with a lower-case letter',
				mt,
				HelenaTextPackage.Literals.MESSAGE_TYPE__NAME,
				HAS_TO_START_LOWERCASE
			)
		}
	}
	

	@Check
	def check_attrType_ofPromelaType(RoleAttributeType attr) {
		if (!attr.type.type.isOfPromelaType) {
			warning(
				'Only attributes of type byte, short, int or boolean can be checked with Promela',
				HelenaTextPackage.Literals.ROLE_ATTRIBUTE_TYPE__TYPE,
				NOT_ALLOWED
			)
		}
	}

	@Check
	def check_attrType_ofPromelaType(ComponentAttributeType attr) {
		if (!attr.type.type.isOfPromelaType) {
			warning(
				'Only attributes of type byte, short, int or boolean can be checked with Promela',
				HelenaTextPackage.Literals.COMPONENT_ATTRIBUTE_TYPE__TYPE,
				NOT_ALLOWED
			)
		}
	}

	@Check
	def check_compop_ofPromelaType(OperationType op) {
		for (param : op.formalDataParamsBlock.params) {
			if (!param.type.type.isOfPromelaType) {
				warning(
					'Only parameters of type byte, short, int or boolean can be checked with Promela',
					HelenaTextPackage.Literals.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK,
					NOT_ALLOWED
				)
			}
		}
	}
	
	@Check
	def check_rolemsg_ofPromelaType(MessageType msg) {
		for (param: msg.formalDataParamsBlock.params) {
			if (!param.type.type.isInt) {
				warning(
					'Only parameters of type int can be checked with Promela',
					HelenaTextPackage.Literals.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK,
					NOT_ALLOWED
				)
			}
		}
	}
	
	
	@Check
	def check_moreThanOneEnsembleStructure(Model model){
		
		if(model.headPkg != null && model.headPkg.ensStructs.length > 1){
			for (es: model.headPkg.ensStructs.tail){
				warning(
					'Only first ensemble structure is used for Promela',
					es,
					HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME, 
					NOT_ALLOWED
				)
			}
		}
	}
	
	/**
	 * Check if first declared ensemble structure (which is used for Promela)
	 * contains all declared role types
	 * If not a warning is raised, as Promela cannot handle that
	 */
	@Check
	def check_allRoleTypesInEnsembleStructure(Model model){
		if(model != null && model.headPkg != null && model.headPkg.ensStructs.length > 0){
			var es = model.headPkg.ensStructs.head;
			val roleTypesFromEs = es.rtWithMult.map[roleType];
			
			val declaredRoleTypes = model.headPkg.roleTypes;
			if (!roleTypesFromEs.containsAll(declaredRoleTypes)){
				error(
					'Promela needs all declared role types to be listed in the first ensemble structure.',
					es,
					HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME, 
					NOT_ALLOWED
				)
			}
		}
	}
	
	
	@Check 
	def check_roleTypeOverMoreThanOneComponentType(RoleType rt){
		if (rt.compTypes.length > 1){
			for (var counter = 1; counter < rt.compTypes.length; counter++){
				warning(
					'Promela can only handle role types over one component type',
					HelenaTextPackage.Literals.ROLE_TYPE__COMP_TYPES, 
					counter,
					NOT_ALLOWED
				)
			}
		}
	}
	/**
	 * Return the EStructuralFeature of an AbstractDuplicateFreeObject 
	 */
	private def static EStructuralFeature getDuplicateFreeObjectFeature(AbstractDuplicateFreeObject obj){
		return obj.getDuplicateFreeObjectFeature_
	}
	
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(AbstractFieldType obj) {
		return HelenaTextPackage.Literals.ABSTRACT_FIELD_TYPE__NAME;
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(AbstractHelenaEntity obj) {
		return HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME;
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(AbstractRoleInstance obj) {
		return HelenaTextPackage.Literals.ABSTRACT_ROLE_INSTANCE__NAME;
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(AbstractDataVariable obj) {
		return HelenaTextPackage.Literals.ABSTRACT_DATA_VARIABLE__NAME;		
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(MessageType obj) {
		return HelenaTextPackage.Literals.MESSAGE_TYPE__NAME;		
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(OperationType obj) {
		return HelenaTextPackage.Literals.OPERATION_TYPE__NAME;		
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(RoleBehavior obj) {
		return HelenaTextPackage.Literals.ROLE_BEHAVIOR__ROLE_TYPE_REF;	
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(Process obj) {
		return HelenaTextPackage.Literals.PROCESS__NAME;
	}
	private def static dispatch EStructuralFeature getDuplicateFreeObjectFeature_(Label obj) {
		return HelenaTextPackage.Literals.LABEL__NAME;
	}
	
	
}
