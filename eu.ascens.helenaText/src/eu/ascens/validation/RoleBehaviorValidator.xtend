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

import eu.ascens.helenaText.ActionPrefix
import eu.ascens.helenaText.Addition
import eu.ascens.helenaText.GetAssignment
import eu.ascens.helenaText.HelenaTextPackage
import eu.ascens.helenaText.IfThenElse
import eu.ascens.helenaText.IncomingMessageCall
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.NondeterministicChoice
import eu.ascens.helenaText.ProcessInvocation
import eu.ascens.helenaText.Subtraction
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Logic.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import eu.ascens.helenaText.CreateAssignment
import eu.ascens.helenaText.AbstractAssignment
import eu.ascens.helenaText.OwnerReference
import eu.ascens.helenaText.RoleType
import eu.ascens.helenaText.ComponentInstance
import eu.ascens.helenaText.ComponentAssociationTypeReference

class RoleBehaviorValidator extends AbstractDeclarativeValidator {
	override register(EValidatorRegistrar registrar) {
		//not needed for classes used as ComposedCheck
	}
		
	/**
	 * Checks that a process does not immediately invoke itself 
	 * (if if-then-else and nondeterministic choice are the first process construct, 
	 * this is checked in another function).
	 */
	@Check
	def check_roleBehavior_processDoesNotImmediatelyInvokeItself(ProcessInvocation invocation) {
		var toCheck = invocation;
		while (toCheck.process.processExpr instanceof ProcessInvocation) {
			toCheck = toCheck.process.processExpr as ProcessInvocation;
			if (invocation.process.name == toCheck.process.name) {
				error(
					'A process invocation should not immediately invoke itself ' + 
					'(also not through a chain of invocations). ' +
					'This results in a infinite loop when executing the role behavior.',
					HelenaTextPackage.Literals.PROCESS_INVOCATION__PROCESS,
					HelenaTextValidator.NOT_ALLOWED
				);
				return;
			}
		}
	}
	
	/**
	 * Checks that in a role behavior only local processes which were declared inside the
	 * role behavior are called
	 */
	@Check
	def check_roleBehavior_onlyProcessesOfTheRoleBehaviorInvoked(ProcessInvocation invocation) {
		if (invocation.parentRoleBehavior != invocation.process.parentRoleBehavior) {
			error(
				'The process ' + invocation.process.name + ' can only be invoked inside the role behavior where it was defined.',
				HelenaTextPackage.Literals.PROCESS_INVOCATION__PROCESS,
				HelenaTextValidator.NOT_ALLOWED
			);
		}
	}
	
	/**
	 * Checks there are no mixed actions in nondeterministic choice
	 * i.e. either all actions are outgoing (and internal) or incoming
	 */
	@Check
	def check_roleBehavior_noMixedStates(NondeterministicChoice term) {
		var actions = term.first.firstActions;
		if (! (actions.forall[it instanceof IncomingMessageCall] ||
			   actions.forall[! (it instanceof IncomingMessageCall)]) ) {
			error(
				'In nondeterministic choice, mixed states are not allowed.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST,
				HelenaTextValidator.NOT_ALLOWED
			);	
		}
		var actions2 = term.second.firstActions;
		if (! (actions2.forall[it instanceof IncomingMessageCall] ||
			   actions2.forall[! (it instanceof IncomingMessageCall)]) ) {
			error(
				'In nondeterministic choice, mixed states are not allowed.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND,
				HelenaTextValidator.NOT_ALLOWED
			);	
		}
	}
	
	/**
	 * Checks no branch of nondeterministic choice is a direct process invocation
	 */
	@Check
	def check_roleBehavior_noProcInvocInNDC(NondeterministicChoice term) {
		if (term.first instanceof ProcessInvocation) {
			warning(
				'In nondeterministic choice, direct process invocation should not be used.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST,
				HelenaTextValidator.NOT_ALLOWED
			)
		}
		if (term.second instanceof ProcessInvocation) {
			warning(
				'In nondeterministic choice, direct process invocation should not be used.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND,
				HelenaTextValidator.NOT_ALLOWED
			)
		}
	}
	
	/**
	 * Checks no branch of if-then-else is a direct process invocation
	 */
	@Check
	def check_roleBehavior_noProcInvocInIfThenElse(IfThenElse term) {
		if (term.ifProcessExpr instanceof ProcessInvocation) {
			warning(
				'In if-then-else, direct process invocation should not be used.',
				HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR,
				HelenaTextValidator.NOT_ALLOWED
			)
		}
		if (term.elseProcessExpr instanceof ProcessInvocation) {
			warning(
				'In if-then-else, direct process invocation should not be used.',
				HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR,
				HelenaTextValidator.NOT_ALLOWED
			)
		}
	}
	
	/**
	 * Checks no branch of nondeterministic choice starts with a create/get action
	 */
	@Check
	def check_roleBehavior_noCreateGetInNDC(NondeterministicChoice term) {
		var actions = term.first.firstActions;
		if (actions.exists[it instanceof CreateAssignment]) {
			warning(
				'In nondeterministic choice, create should only be used as first action of a branch' + 
				' if one can guarantee that a new role instance can be created.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST,
				HelenaTextValidator.NOT_ALLOWED
			);	
		}
		if (actions.exists[it instanceof GetAssignment]) {
			warning(
				'In nondeterministic choice, get should only be used as first action of a branch' + 
				' if one can guarantee that there exists a corresponding role instance.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST,
				HelenaTextValidator.NOT_ALLOWED
			);	
		}
		actions = term.second.firstActions;
		if (actions.exists[it instanceof CreateAssignment]) {
			warning(
				'In nondeterministic choice, create should only be used as first action of a branch' + 
				' if one can guarantee that a new role instance can be created.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND,
				HelenaTextValidator.NOT_ALLOWED
			);	
		}
		if (actions.exists[it instanceof GetAssignment]) {
			warning(
				'In nondeterministic choice, get should only be used as first action of a branch' + 
				' if one can guarantee that there exists a corresponding role instance.',
				HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND,
				HelenaTextValidator.NOT_ALLOWED
			);	
		}
	}
	
	/**
	 * Checks no branch of if-then-else starts with a create/get action if not preceeded by a corresponding plays query
	 */
	@Check
	def check_roleBehavior_noCreateGetInIfThenElse(IfThenElse term) {
		var playsQueries = term.guard.playsQueries;
		
		if (term.ifProcessExpr instanceof ActionPrefix) {
			var procTerm = term.ifProcessExpr as ActionPrefix;
			if (procTerm.action instanceof AbstractAssignment) {
				var assignment = procTerm.action as AbstractAssignment;
				var found = false;
				for (playsQuery : playsQueries) {
					if (same(playsQuery.roleTypeRef, assignment.roleTypeRef, playsQuery.compInstance, assignment.compInstance)) {
						found = true;
					}
				}
				if (!found) {
					warning(
						'In if-then-else, create/get should only be used as first action of a branch' + 
						' if they can be guaranteed to succeed.',
						HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR,
						HelenaTextValidator.NOT_ALLOWED
					);	
				}
			}
		}
		
		if (term.elseProcessExpr instanceof ActionPrefix) {
			var procTerm = term.elseProcessExpr as ActionPrefix;
			if (procTerm.action instanceof AbstractAssignment) {
				var assignment = procTerm.action as AbstractAssignment;
				var found = false;
				for (playsQuery : playsQueries) {
					if (same(playsQuery.roleTypeRef, assignment.roleTypeRef, playsQuery.compInstance, assignment.compInstance)) {
						found = true;
					}
				}
				if (!found) {
					warning(
						'In if-then-else, create/get should only be used as first action of a branch' + 
						' if preceeded by a corresponding plays query.',
						HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR,
						HelenaTextValidator.NOT_ALLOWED
					);	
				}
			}
		}
	}
	
	private dispatch def same(RoleType roleType, RoleType roleType2, ComponentInstance component, ComponentInstance component2) {
		return false;
	}
	private dispatch def same(RoleType roleType, RoleType roleType2, OwnerReference component, OwnerReference component2) {
		return roleType == roleType2;
	}
	private dispatch def same(RoleType roleType, RoleType roleType2, ComponentAssociationTypeReference component, ComponentAssociationTypeReference component2) {
		return roleType == roleType2 && component.ref == component2.ref;
	}
	
		/**
	 * Checks that message reception is not first action of any branch in if-then-else
	 */
	@Check
	def check_roleBehavior_noReceiveInIfThenElse(IfThenElse term) {
		if (term.ifProcessExpr instanceof ActionPrefix) {
			var prefix = term.ifProcessExpr as ActionPrefix;
			if (prefix.action instanceof IncomingMessageCall) {
				error(
					'In if-then-else, message reception should not be used as first action.',
					HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR,
					HelenaTextValidator.NOT_ALLOWED
				)
			}
		}
		if (term.elseProcessExpr instanceof ActionPrefix) {
			var prefix = term.elseProcessExpr as ActionPrefix;
			if (prefix.action instanceof Label) {
				error(
					'In if-then-else, message reception should not be used as first action.',
					HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR,
					HelenaTextValidator.NOT_ALLOWED
				)
			}
		}
	}
	
	/**
	 * Checks that state labels are not first action of any branch in nondeterministic choice
	 */
	@Check
	def check_roleBehavior_noLabelsInNDC(NondeterministicChoice term) {
		if (term.first instanceof ActionPrefix) {
			var prefix = term.first as ActionPrefix;
			if (prefix.action instanceof Label) {
				error(
					'In nondeterministic choice, labels are not allowed as first action.',
					HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST,
					HelenaTextValidator.NOT_ALLOWED
				)
			}
		}
		if (term.second instanceof ProcessInvocation) {
			var prefix = term.second as ActionPrefix;
			if (prefix.action instanceof Label) {
				error(
					'In nondeterministic choice, labels are not allowed as first action.',
					HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST,
					HelenaTextValidator.NOT_ALLOWED
				)
			}
		}
	}
	
	/**
	 * Checks that state labels are not first action of any branch in if-then-else
	 */
	@Check
	def check_roleBehavior_noLabelsInIfThenElse(IfThenElse term) {
		if (term.ifProcessExpr instanceof ActionPrefix) {
			var prefix = term.ifProcessExpr as ActionPrefix;
			if (prefix.action instanceof Label) {
				error(
					'In if-then-else, labels are not allowed as first action.',
					HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR,
					HelenaTextValidator.NOT_ALLOWED
				)
			}
		}
		if (term.elseProcessExpr instanceof ActionPrefix) {
			var prefix = term.elseProcessExpr as ActionPrefix;
			if (prefix.action instanceof Label) {
				error(
					'In if-then-else, labels are not allowed as first action.',
					HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR,
					HelenaTextValidator.NOT_ALLOWED
				)
			}
		}
	}
	
	/**
	 * Checks that addition only use numbers
	 */
	@Check
	def check_addition_typesMatch(Addition exp) {
		if (exp.right != null) {
			if (!exp.left.isNumber()) {
				error (
					'Only numbers can be used in addition expressions',
					HelenaTextPackage.Literals.ADDITION__LEFT,
					HelenaTextValidator.NOT_ALLOWED
				);
			}
			if (!exp.right.isNumber()) {
				error (
					'Only numbers can be used in addition expressions',
					HelenaTextPackage.Literals.ADDITION__RIGHT,
					HelenaTextValidator.NOT_ALLOWED
				);
			} 
		}
	}
	
	/**
	 * Checks that subtraction only use numbers
	 */
	@Check
	def check_subtraction_typesMatch(Subtraction exp) {
		if (exp.right != null) {
			if (!exp.left.isNumber()) {
				error (
					'Only numbers can be used in subtraction expressions',
					HelenaTextPackage.Literals.SUBTRACTION__LEFT,
					HelenaTextValidator.NOT_ALLOWED
				);
			}
			if (!exp.right.isNumber()) {
				error (
					'Only numbers can be used in subtraction expressions',
					HelenaTextPackage.Literals.SUBTRACTION__RIGHT,
					HelenaTextValidator.NOT_ALLOWED
				);
			} 
		}
	}
}