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

import eu.ascens.helenaText.AbstractInstance
import eu.ascens.helenaText.AbstractMessageCall
import eu.ascens.helenaText.AbstractRoleBehaviorEntity
import eu.ascens.helenaText.AbstractRoleInstance
import eu.ascens.helenaText.Action
import eu.ascens.helenaText.ActionPrefix
import eu.ascens.helenaText.DataVariable
import eu.ascens.helenaText.DeclaringRoleBehavior
import eu.ascens.helenaText.FormalDataParam
import eu.ascens.helenaText.Guard
import eu.ascens.helenaText.IfThenElse
import eu.ascens.helenaText.InvokingRoleBehavior
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.NondeterministicChoice
import eu.ascens.helenaText.OperationCall
import eu.ascens.helenaText.PlaysQuery
import eu.ascens.helenaText.Process
import eu.ascens.helenaText.ProcessExpression
import eu.ascens.helenaText.ProcessInvocation
import eu.ascens.helenaText.QuitTerm
import eu.ascens.helenaText.RoleBehavior
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import org.eclipse.emf.ecore.EObject

import static extension eu.ascens.helenaText.util.ExtensionMethods_Action.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Logic.*
import static extension eu.ascens.helenaText.util.Helper.*

class ExtensionMethods_RoleBehavior {

	/**
	 * Returns the role behavior where the entity is used
	 */
	def static RoleBehavior getParentRoleBehavior(AbstractRoleBehaviorEntity entity) {
	 	var EObject current = entity.eContainer;
	 	while (! (current instanceof RoleBehavior) ) {
	 		current = current.eContainer;
	 	}
	 	return current as RoleBehavior;
	}

	/**
	 * Returns all processes declared in a role behavior
	 */
	def dispatch static Collection<Process> getProcesses(DeclaringRoleBehavior rb) {
		return new ArrayList<Process>();
	}
	def dispatch static Collection<Process> getProcesses(InvokingRoleBehavior rb) {
		return rb.processes;
	}
	
	def static Collection<ProcessInvocation> getProcessInvocations(RoleBehavior rb){
		var invocs = rb.eAllContents.toIterable.filter[elem | elem instanceof ProcessInvocation].map[elem | elem as ProcessInvocation];
		return invocs.toList;
	}
	
	def static Collection<AbstractMessageCall> getAbstractMessageCalls(RoleBehavior rb){
		var abstrMsgCalls =  rb.eAllContents.toIterable.filter[elem | elem instanceof AbstractMessageCall].map[elem | elem as AbstractMessageCall];
		return abstrMsgCalls.toList;
	}
	
	def static Collection<OperationCall> getOperationCalls(RoleBehavior rb){
		var opCalls = rb.eAllContents.toIterable.filter[elem | elem instanceof OperationCall].map[elem | elem as OperationCall];
		return opCalls.toList;
	}
	
	def static Collection<Action> getFirstActions(ProcessExpression term) {
		return term.getFirstActions_(new HashSet);
	}
	
	/**
	 * Returns the first action(s) of a process term
	 * (there might be several if it is if-then-else or nondeterministic choice)
	 */
	def dispatch static Collection<Action> getFirstActions_(QuitTerm term, Collection<Process> alreadyTraversedProcesses) {
		return new ArrayList;
	}
	def dispatch static Collection<Action> getFirstActions_(ActionPrefix term, Collection<Process> alreadyTraversedProcesses) {
		return term.action.asList;
	}
	def dispatch static Collection<Action> getFirstActions_(IfThenElse term, Collection<Process> alreadyTraversedProcesses) {
		var actions = new ArrayList;
		if (term.ifProcessExpr != null) actions.addAll(term.ifProcessExpr.getFirstActions_(alreadyTraversedProcesses));
		if (term.elseProcessExpr != null) actions.addAll(term.elseProcessExpr.getFirstActions_(alreadyTraversedProcesses));
		return actions;
	}
	def dispatch static Collection<Action> getFirstActions_(NondeterministicChoice term, Collection<Process> alreadyTraversedProcesses) {
		var actions = new ArrayList;
		if (term.first != null) actions.addAll(term.first.getFirstActions_(alreadyTraversedProcesses));
		if (term.second != null) actions.addAll(term.second.getFirstActions_(alreadyTraversedProcesses));
		return actions;
	}
	def dispatch static Collection<Action> getFirstActions_(ProcessInvocation term, Collection<Process> alreadyTraversedProcesses) {
		if (term.process != null && term.process.processExpr != null && !alreadyTraversedProcesses.contains(term.process)) {
			alreadyTraversedProcesses.add(term.process);
			return term.process.processExpr.getFirstActions_(alreadyTraversedProcesses);
		}
		else return new HashSet;
	}
	
	/**
	 * Returns all plays queries without duplicates contained in the role behavior
	 */
	def static Collection<PlaysQuery> getPlaysQueries(RoleBehavior rb) {
		return rb.getCollectionFromGuards( [playsQueries], [query1,query2 | query1.equal(query2)] );
	}
	
	/**
	 * Returns all abstract role instances in a role behavior
	 * (this set is *not* duplicate-free referring to names!)
	 */
	def static Collection<AbstractRoleInstance> getAbstractRoleInstances(RoleBehavior rb) {
		return rb.getCollectionFromActions( [abstractRoleInstances] , [ri1,ri2 | ri1.equals(ri2)] );
	}
	
	/**
	 * Returns all formal data params in a role behavior
	 * (this set is *not* duplicate-free referring to names!)
	 */
	def static Collection<FormalDataParam> getFormalDataParams(RoleBehavior rb) {
		return rb.getCollectionFromActions( [formalDataParams] , [ri1,ri2 | ri1.equals(ri2)] );
	}
	
	/**
	 * Returns all data variables from operations calls in a role behavior
	 * (this set is *not* duplicate-free referring to names!)
	 */
	def static Collection<DataVariable> getOpDataVariables(RoleBehavior rb) {
		return rb.getCollectionFromActions( [opDataVariables] , [ri1,ri2 | ri1.equals(ri2)] );
	}
	
	/**
	 * Returns all abstract instances from incoming messages and get/create actions in a role behavior
	 * (this set is *not* duplicate-free referring to names!)
	 */
	def static Collection<AbstractInstance> getParams(RoleBehavior rb){
		var abstractRoleInsts = rb.abstractRoleInstances;
		var formalDataParams = rb.formalDataParams;
		
		var Collection<AbstractInstance> abstractInsts = new ArrayList<AbstractInstance>();
		abstractInsts.addAll(abstractRoleInsts);
		abstractInsts.addAll(formalDataParams);
		 
		return abstractInsts;
	}

	/**
	 * Returns all labels declared in a role behavior
	 * (this set is *not* duplicate-free referring to names)
	 */
	def static Collection<Label> getLabels(RoleBehavior rb) {
		return rb.getCollectionFromActions([labels] , [l1,l2 | l1.equals(l2)]);
	}
	 
	/**
	 * Get a (duplicate free) collection where the elements are contained in guards
	 */
	private def static <T> Collection<T> getCollectionFromGuards
			(RoleBehavior rb, (Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		// hack since generics are not allowed in dispatch methods
		switch rb {
			DeclaringRoleBehavior : {
				var rb2 = rb as DeclaringRoleBehavior;
				return rb2.getCollectionFromGuardsForDeclaringRB(toRetrieve, equals);
			}
			InvokingRoleBehavior : {
				var rb2 = rb as InvokingRoleBehavior;
				rb2.getCollectionFromGuardsForInvokingRB(toRetrieve, equals); 
			}
		}
	}
	
	private def static <T> Collection<T> getCollectionFromGuardsForDeclaringRB
			(DeclaringRoleBehavior rb, (Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		// null test necessary for incompletly specified processes
		if (rb.processExpr != null) 
			return rb.processExpr.getCollectionFromGuardsInProcessTerm(new ArrayList, toRetrieve, equals);
	}
	private def static <T> Collection<T> getCollectionFromGuardsForInvokingRB
			(InvokingRoleBehavior rb, (Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		// null test necessary for incompletly specified processes
		if (rb.processInvocation != null && rb.processInvocation.process != null && rb.processInvocation.process.processExpr != null)
			return rb.processInvocation.process.processExpr.getCollectionFromGuardsInProcessTerm(rb.processInvocation.process.asList, toRetrieve, equals);
	}
	
	private def static <T> Collection<T> getCollectionFromGuardsInProcessTerm
			(ProcessExpression term, Collection<Process> alreadyTraversedProcesses, 
				(Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals
			) {
		// hack since generics are not allowed in dispatch methods
		switch term {
			QuitTerm : {
				var term2 = term as QuitTerm;
				return term2.getCollectionFromGuardsInQuitTerm(alreadyTraversedProcesses, toRetrieve, equals);
			}
			ActionPrefix : {
				var term2 = term as ActionPrefix;
				return term2.getCollectionFromGuardsInActionPrefix(alreadyTraversedProcesses, toRetrieve, equals);
			}
			IfThenElse : {
				var term2 = term as IfThenElse;
				return term2.getCollectionFromGuardsInIfThenElse(alreadyTraversedProcesses, toRetrieve, equals);
			}
			NondeterministicChoice: {
				var term2 = term as NondeterministicChoice;
				return term2.getCollectionFromGuardsInNondeterministicChoice(alreadyTraversedProcesses, toRetrieve, equals);
			}
			ProcessInvocation : {
				var term2 = term as ProcessInvocation;
				return term2.getCollectionFromGuardsInProcessInvocation(alreadyTraversedProcesses, toRetrieve, equals);
			}
		}
	}
	
	private def static <T> Collection<T> getCollectionFromGuardsInQuitTerm
			(QuitTerm term, Collection<Process> alreadyTraversedProcesses, 
				(Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals
			) {
		return new HashSet;
	}
	private def static <T> Collection<T> getCollectionFromGuardsInActionPrefix
			(ActionPrefix term, Collection<Process> alreadyTraversedProcesses, 
				(Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals
			) {
		if (term.processExpr != null) return term.processExpr.getCollectionFromGuardsInProcessTerm(alreadyTraversedProcesses, toRetrieve, equals);
	}
	private def static <T> Collection<T> getCollectionFromGuardsInIfThenElse
			(IfThenElse term, Collection<Process> alreadyTraversedProcesses, 
				(Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals
			) {
		var list = new HashSet;
		if (term.guard != null)
			list.addAllDuplicateFree(toRetrieve.apply(term.guard), equals);
		if (term.ifProcessExpr != null) 
			list.addAllDuplicateFree(term.ifProcessExpr.getCollectionFromGuardsInProcessTerm(alreadyTraversedProcesses, toRetrieve, equals), equals);
		if (term.elseProcessExpr != null) 
			list.addAllDuplicateFree(term.elseProcessExpr.getCollectionFromGuardsInProcessTerm(alreadyTraversedProcesses, toRetrieve, equals), equals);
		return list;
	}
		private def static <T> Collection<T> getCollectionFromGuardsInNondeterministicChoice
			(NondeterministicChoice term, Collection<Process> alreadyTraversedProcesses, 
				(Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals
			) {
		var list = new HashSet;
		if (term.first != null) 
			list.addAllDuplicateFree(term.first.getCollectionFromGuardsInProcessTerm(alreadyTraversedProcesses, toRetrieve, equals), equals);
		if (term.second != null) 
			list.addAllDuplicateFree(term.second.getCollectionFromGuardsInProcessTerm(alreadyTraversedProcesses, toRetrieve, equals), equals);
		return list;
	}
	private def static <T> Collection<T> getCollectionFromGuardsInProcessInvocation
			(ProcessInvocation term, Collection<Process> alreadyTraversedProcesses, 
				(Guard) => Collection<T> toRetrieve, (T,T) => Boolean equals
			) {
		var list = new HashSet;
		if (!alreadyTraversedProcesses.contains(term.process) && term.process != null && term.process.processExpr != null) {
			alreadyTraversedProcesses.add(term.process);
			list.addAllDuplicateFree(term.process.processExpr.getCollectionFromGuardsInProcessTerm(alreadyTraversedProcesses, toRetrieve, equals), equals);
		}
		return list;
	}
	
		/**
	 * Get a (duplicate free) collection where the elements are contained in actions
	 */
	private def static <T> Collection<T> getCollectionFromActions
			(RoleBehavior rb, (Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		// hack since generics are not allowed in dispatch methods
		switch rb {
			DeclaringRoleBehavior : {
				var rb2 = rb as DeclaringRoleBehavior;
				return rb2.getCollectionFromActionsForDeclaringRB(toRetrieve, equals);
			}
			InvokingRoleBehavior : {
				var rb2 = rb as InvokingRoleBehavior;
				rb2.getCollectionFromActionsForInvokingRB(toRetrieve, equals); 
			}
		}
	}
	
	private def static <T> Collection<T> getCollectionFromActionsForDeclaringRB
			(DeclaringRoleBehavior rb, (Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		// null test necessary for incompletly specified processes
		if (rb.processExpr != null) 
			return rb.processExpr.getCollectionFromActionsInProcessExpressions(new ArrayList, toRetrieve, equals);
	}
	private def static <T> Collection<T> getCollectionFromActionsForInvokingRB
			(InvokingRoleBehavior rb, (Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		// null test necessary for incompletly specified processes
		if (rb.processInvocation != null && rb.processInvocation.process != null && rb.processInvocation.process.processExpr != null)
			return rb.processInvocation.process.processExpr.getCollectionFromActionsInProcessExpressions(rb.processInvocation.process.asList, toRetrieve, equals);
	}
	
	private def static <T> Collection<T> getCollectionFromActionsInProcessExpressions
			(ProcessExpression term, Collection<Process> alreadyTraversedProcesses, 
				(Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		// hack since generics are not allowed in dispatch methods
		switch term {
			QuitTerm : {
				var term2 = term as QuitTerm;
				return term2.getCollectionFromActionsInQuitTerm(alreadyTraversedProcesses, toRetrieve, equals);
			}
			ActionPrefix : {
				var term2 = term as ActionPrefix;
				return term2.getCollectionFromActionsInActionPrefix(alreadyTraversedProcesses, toRetrieve, equals);
			}
			IfThenElse : {
				var term2 = term as IfThenElse;
				return term2.getCollectionFromActionsInIfThenElse(alreadyTraversedProcesses, toRetrieve, equals);
			}
			NondeterministicChoice : {
				var term2 = term as NondeterministicChoice;
				return term2.getCollectionFromActionsInNondeterministicChoice(alreadyTraversedProcesses, toRetrieve, equals);
			}
			ProcessInvocation : {
				var term2 = term as ProcessInvocation;
				return term2.getCollectionFromActionsInProcessInvocation(alreadyTraversedProcesses, toRetrieve, equals);
			}
		}
	}
	
	private def static <T> Collection<T> getCollectionFromActionsInQuitTerm
			(QuitTerm term, Collection<Process> alreadyTraversedProcesses, 
				(Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		return new HashSet;
	}
	private def static <T> Collection<T> getCollectionFromActionsInActionPrefix
			(ActionPrefix term, Collection<Process> alreadyTraversedProcesses, 
				(Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		var list = new HashSet;
		if (term.action != null) list.addAllDuplicateFree(toRetrieve.apply(term.action), equals);
		if (term.processExpr != null) list.addAllDuplicateFree(term.processExpr.getCollectionFromActionsInProcessExpressions(alreadyTraversedProcesses, toRetrieve, equals), equals);
		return list
	}
	private def static <T> Collection<T> getCollectionFromActionsInIfThenElse
			(IfThenElse term, Collection<Process> alreadyTraversedProcesses, 
				(Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		var list = new HashSet;
		if (term.ifProcessExpr != null) 
			list.addAllDuplicateFree(term.ifProcessExpr.getCollectionFromActionsInProcessExpressions(alreadyTraversedProcesses, toRetrieve, equals), equals);
		if (term.elseProcessExpr != null) 
			list.addAllDuplicateFree(term.elseProcessExpr.getCollectionFromActionsInProcessExpressions(alreadyTraversedProcesses, toRetrieve, equals), equals);
		return list;
	}
	private def static <T> Collection<T> getCollectionFromActionsInNondeterministicChoice
			(NondeterministicChoice term, Collection<Process> alreadyTraversedProcesses, 
				(Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		var list = new HashSet;
		if (term.first != null) 
			list.addAllDuplicateFree(term.first.getCollectionFromActionsInProcessExpressions(alreadyTraversedProcesses, toRetrieve, equals), equals);
		if (term.second != null) 
			list.addAllDuplicateFree(term.second.getCollectionFromActionsInProcessExpressions(alreadyTraversedProcesses, toRetrieve, equals), equals);
		return list;
	}
	private def static <T> Collection<T> getCollectionFromActionsInProcessInvocation
			(ProcessInvocation term, Collection<Process> alreadyTraversedProcesses, 
				(Action) => Collection<T> toRetrieve, (T,T) => Boolean equals) {
		var list = new HashSet;
		if (!alreadyTraversedProcesses.contains(term.process) && term.process != null && term.process.processExpr != null) {
			alreadyTraversedProcesses.add(term.process);
			list.addAllDuplicateFree(term.process.processExpr.getCollectionFromActionsInProcessExpressions(alreadyTraversedProcesses, toRetrieve, equals), equals);
		}
		return list;
	}
}
