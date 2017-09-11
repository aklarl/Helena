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

import eu.ascens.helenaText.AndTerm
import eu.ascens.helenaText.DataExpression
import eu.ascens.helenaText.EqualityTerm
import eu.ascens.helenaText.Guard
import eu.ascens.helenaText.GuardInParentheses
import eu.ascens.helenaText.HelenaTextPackage
import eu.ascens.helenaText.IfThenElse
import eu.ascens.helenaText.NotTerm
import eu.ascens.helenaText.OrTerm
import eu.ascens.helenaText.PlaysQuery
import eu.ascens.helenaText.Relation
import eu.ascens.helenaText.util.Helper
import eu.ascens.helenaText.util.JvmTypesHelper
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static eu.ascens.helenaText.util.JvmTypesHelper.*

import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Logic.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

class LogicValidator extends AbstractDeclarativeValidator {
	private static val JvmGenericType BOOLEAN_JVM_TYPE = createJvmType(Boolean.simpleName);
	
	override register(EValidatorRegistrar registrar) {
		//not needed for classes used as ComposedCheck
	}
	
	/**
	 * Checks whether plays is called for a component instance
	 * which can actually play the given role type
	 */
	@Check
	def check_roleBehavior_playsForCorrectCompTypeInvoked(PlaysQuery plays) {
		if( plays.compInstance != null && 
		    !plays.compInstance.isAllowedAsOwnerType(plays.roleTypeRef)) { 
			error(
				'A role instance of type ' + plays.roleTypeRef.name + 
					' cannot be owned by the given component instance. Allowed component types are ' + 
					Helper.joinToString(",", plays.roleTypeRef.compTypes.map[name]) ,
				HelenaTextPackage.Literals.PLAYS_QUERY__COMP_INSTANCE,
				HelenaTextValidator.NOT_ALLOWED
			);
		}
	}
	
	
	
	/**
	 * Checks for ConditionalSelection with a unary guard that only 
	 * a boolean is allowed (as guard) 
	 */	
	@Check 
	def check_roleBehavior_unaryRelationIsBool(IfThenElse ifThenElse){
		
		val errorText = 'Only boolean is allowed for a unary guard';
		
		//guard check
		if(ifThenElse.guard.isUnaryExpression && !ifThenElse.guard.type.isBoolean){
			error(
				errorText,
				HelenaTextPackage.Literals.IF_THEN_ELSE__GUARD,
				HelenaTextValidator.NOT_ALLOWED
			); 
		}
	}
	
	
	/**
	 * Checks if the operands of a guard do have matching types
	 */
	@Check 
	def check_roleBehavior_operandsMatch(Guard guard){
		if(guard.isBinaryRelation){	//Only check relations, not terminal rule NotTerm (e.g. plays)
			var typesMatch = guard.typesMatch; 
			if(!typesMatch){
				error(
					'Operands do not match',
					guard.getStructuralFeature(),
					HelenaTextValidator.NOT_ALLOWED
				);
			}
		}
	}
	
	/**
	 * Checks if for different types of relations (e.g. AndTerm) that operands have an allowed type
	 * 
	 * An Guard/OrTerm and an AndTerm should only have operands of type boolean. 
	 * A RelationalTerm (e.g. 1 < 3) should only have operands of type number
	 */
	@Check
	def check_roleBehavior_operandTypesBoolean(AndTerm guard){
		
		//AndTerm operands have to be boolean
		if(!(guard.left.type.isBoolean && guard.right.type.isBoolean)){
			error(
				'Only boolean operands are allowed for this type of relation',
				guard.getStructuralFeature,
				HelenaTextValidator.NOT_ALLOWED
			);
		}
	}
	@Check
	def check_roleBehavior_operandTypesBoolean(OrTerm guard){
		
		//OrTerm operands have to be boolean
		if(!(guard.left.type.isBoolean && guard.right.type.isBoolean)){
			error(
				'Only boolean operands are allowed for this type of relation',
				guard.getStructuralFeature,
				HelenaTextValidator.NOT_ALLOWED
			);
		}
	}
	
	@Check
	def check_roleBehavior_operandTypesNumbers(Relation relation){
		if(!(relation.left.isNumber && relation.right.isNumber)){
			error(
				'Only number operands are allowed for this type of relation',
				HelenaTextPackage.Literals.RELATION__RIGHT,
				HelenaTextValidator.NOT_ALLOWED
			);
		}
	}
	
	/**
	 * Checks if a NotTerm that has the not operator set (e.g. !(true) ) 
	 * contains a boolean value
	 */
	@Check
	def check_roleBehavior_notTermCorrect(NotTerm term){
		if(term.not != null && !term.type.isBoolean){
			error(
				'Only a boolean expression is allowed',
				HelenaTextPackage.Literals.NOT_TERM__ATOM,
				HelenaTextValidator.NOT_ALLOWED
			);
		}
	}
	
	/**
	 * Calculates if both operands of a relation do have the same type
	 */
	private def boolean typesMatch(Guard guard){
		if(guard.isBinaryRelation && guard.right != null && guard.left != null){
			var left = guard.left.type;
			var right = guard.right.type;
			return JvmTypesHelper.typesEqual(left, right)
		}else if(!guard.isBinaryRelation){	//unary relation
			return guard.type.isBoolean;		
		}
		return false;
	}
	
	
	/**
	 * Calculates the jvmType of a guard
	 */
	def dispatch JvmType getType(OrTerm term){
		return BOOLEAN_JVM_TYPE;
	}
	def dispatch JvmType getType(AndTerm term){
		return BOOLEAN_JVM_TYPE;
	}
	def dispatch JvmType getType(EqualityTerm term){
		return BOOLEAN_JVM_TYPE;
	}
	def dispatch JvmType getType(NotTerm term){
		var atom = term.atom;
		if(atom != null)	return atom.typeFromAtom
		else 				return null
	}
	
	/**
	 * Get jvm type from an atom 
	 */
	def dispatch JvmType getTypeFromAtom(DataExpression atom){
		return atom.wrappedJvmType;
	}
	def dispatch JvmType getTypeFromAtom(PlaysQuery atom){
		return BOOLEAN_JVM_TYPE;
	}
	def dispatch JvmType getTypeFromAtom(Relation atom){
		return BOOLEAN_JVM_TYPE;
	}
	def dispatch JvmType getTypeFromAtom(GuardInParentheses atom){
		return atom.guard.type;
	}
	
	/**
	 * Returns true if a guard is a not Term and consists of a DataExpression
	 * false otherwise
	 */
	def static boolean isUnaryExpression(Guard guard){
		if(guard instanceof NotTerm){
			var term = guard as NotTerm;
			if(term.atom instanceof DataExpression)		return true
			if(term.atom instanceof GuardInParentheses)	return (term.atom as GuardInParentheses).guard.isUnaryExpression()
		}
		return false
	}
	
	
	
	private dispatch def EStructuralFeature getStructuralFeature(AndTerm term){
		return HelenaTextPackage.Literals.AND_TERM__RIGHT;
	}
	private dispatch def EStructuralFeature getStructuralFeature(OrTerm term){
		return HelenaTextPackage.Literals.OR_TERM__RIGHT;
	}
	private dispatch def EStructuralFeature getStructuralFeature(EqualityTerm term){
		return HelenaTextPackage.Literals.EQUALITY_TERM__RIGHT;
	}
	private dispatch def EStructuralFeature getStructuralFeature(NotTerm term){
		return HelenaTextPackage.Literals.NOT_TERM__ATOM;
	}
}