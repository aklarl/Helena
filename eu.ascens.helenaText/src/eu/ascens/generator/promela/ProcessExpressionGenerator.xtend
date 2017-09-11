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
import eu.ascens.helenaText.ActionPrefix
import eu.ascens.helenaText.IfThenElse
import eu.ascens.helenaText.NondeterministicChoice
import eu.ascens.helenaText.Process
import eu.ascens.helenaText.ProcessInvocation
import eu.ascens.helenaText.QuitTerm
import java.util.Collection

import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.generator.promela.OperationCallGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Logic.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

class ProcessExpressionGenerator {
	@Inject GuardGenerator guardGenerator;
	@Inject ActionGenerator actionGenerator;
	
	/**
	 * Compiles a process term:
	 * - action prefix is realized with sequential composition
	 * - conditional selection is realized with if-selection
	 * - process invocation is realized with labels and gotos since we cannot use inline method with interlaced recursive processes
	 */
	def dispatch CharSequence compileProcExpr(QuitTerm term, Collection<Process> alreadyTraversedProcesses) {
		var rt = term.parentRoleBehavior.roleTypeRef;
		var owner = term.parentRoleBehavior.roleTypeRef.ownerComponentType;
		'''
		
		// quit
		«owner.quitRole»(«rt.getCompOperationNameForQuit»,owner);
		goto «rt.endLabelName»'''
	}
	def dispatch CharSequence compileProcExpr(ActionPrefix term, Collection<Process> alreadyTraversedProcesses) {
		'''
		«actionGenerator.compileAction(term.action)»;
		«term.processExpr.compileProcExpr(alreadyTraversedProcesses)»
		'''
	}
	def dispatch CharSequence compileProcExpr(NondeterministicChoice term, Collection<Process> alreadyTraversedProcesses) {
		'''
		
		// nondeterministic choice
		if
		:: // first branch
			«term.first.compileProcExpr(alreadyTraversedProcesses)»
		:: // second branch
			«term.second.compileProcExpr(alreadyTraversedProcesses)»
		fi'''
	}
	def dispatch CharSequence compileProcExpr(IfThenElse term, Collection<Process> alreadyTraversedProcesses) {
		var owner = term.parentRoleBehavior.roleTypeRef.ownerComponentType;
		var playsQueries = term.guard.playsQueries;
		var compAttributes = term.guard.componentAttributes;
		
		'''
		
		// if-then-else
		atomic {		
			// retrieve values for guards in guarded choice
			«FOR query:playsQueries»
			«query.compInstance.retrieveCompInstanceFromOwner»
			«query.compInstance.componentType.compileOperationCall(query)»;
			«ENDFOR»
			«FOR attr:compAttributes»
			«owner.compileGetterOperationCall(attr)»;
			«ENDFOR»
			
			if
			::(«guardGenerator.compileRelation(term.guard)») ->
				«term.ifProcessExpr.compileFirstActionForIf(alreadyTraversedProcesses)»
			:: else ->
				«term.elseProcessExpr.compileFirstActionForIf(alreadyTraversedProcesses)»
			fi
		};
		
		«term.ifProcessExpr.compileRemainingProcExprForIf(alreadyTraversedProcesses)»;
		
		«term.elseProcessExpr.compileRemainingProcExprForIf(alreadyTraversedProcesses)»'''
	}
	def dispatch CharSequence compileProcExpr(ProcessInvocation term, Collection<Process> alreadyTraversedProcesses) {
		// if the process was already declared, we can now just go to it
		if (alreadyTraversedProcesses.contains(term.process)) {
			return 
				'''
				
				// process invocation by goto label
				goto «term.process.label»'''
		}
		// if the process was not yet declared, we inline it here and add a label to be able to invoke it later on
		else {
			alreadyTraversedProcesses.add(term.process)
			return 
				'''
				
				// declare local process by label
				«term.process.label»: true;
				«term.process.processExpr.compileProcExpr(alreadyTraversedProcesses)»'''
		}
	}
	
	/**
	 * compiles the first action of a process term (recursively!) and a jump to the remaining process term
	 */
	private def dispatch CharSequence compileFirstActionForIf(QuitTerm term, Collection<Process> alreadyTraversedProcesses) {
		return term.compileProcExpr(alreadyTraversedProcesses);
	}
	private def dispatch CharSequence compileFirstActionForIf(ActionPrefix term, Collection<Process> alreadyTraversedProcesses) {
		'''
		«actionGenerator.compileAction(term.action)»;
		
		goto «term.ifGotoLabel»'''
	}
	private def dispatch CharSequence compileFirstActionForIf(NondeterministicChoice term, Collection<Process> alreadyTraversedProcesses) {
		'''
		
		// nondeterministic choice
		if
		:: // first branch
			«term.first.compileFirstActionForIf(alreadyTraversedProcesses)»
		:: // second branch
			«term.second.compileFirstActionForIf(alreadyTraversedProcesses)»
		fi'''
	}
	private def dispatch CharSequence compileFirstActionForIf(IfThenElse term, Collection<Process> alreadyTraversedProcesses) {
		var owner = term.parentRoleBehavior.roleTypeRef.ownerComponentType;
		var playsQueries = term.guard.playsQueries;
		var compAttributes = term.guard.componentAttributes;
		
		'''
		
		// if-then-else
		// retrieve values for guards in if-then-else
		«FOR query:playsQueries»
		«query.compInstance.retrieveCompInstanceFromOwner»
		«query.compInstance.componentType.compileOperationCall(query)»;
		«ENDFOR»
		«FOR attr:compAttributes»
		«owner.compileGetterOperationCall(attr)»;
		«ENDFOR»
		
		if
		::(«guardGenerator.compileRelation(term.guard)») ->
			«term.ifProcessExpr.compileFirstActionForIf(alreadyTraversedProcesses)»
			
		:: else ->
			«term.elseProcessExpr.compileFirstActionForIf(alreadyTraversedProcesses)»
		fi'''
	}
	
	/**
	 * compiles the remaining process term after an if-then-else
	 */
	private def dispatch CharSequence compileRemainingProcExprForIf(QuitTerm term, Collection<Process> alreadyTraversedProcesses) {
		''''''
	}
	private def dispatch CharSequence compileRemainingProcExprForIf(ActionPrefix term, Collection<Process> alreadyTraversedProcesses) {
		'''
		«term.ifGotoLabel»: true;
		«term.processExpr.compileProcExpr(alreadyTraversedProcesses)»'''
	}
	private def dispatch CharSequence compileRemainingProcExprForIf(NondeterministicChoice term, Collection<Process> alreadyTraversedProcesses) {
		'''
		«term.first.compileRemainingProcExprForIf(alreadyTraversedProcesses)»;
		«term.second.compileRemainingProcExprForIf(alreadyTraversedProcesses)»'''
	}
	private def dispatch CharSequence compileRemainingProcExprForIf(IfThenElse term, Collection<Process> alreadyTraversedProcesses) {
		'''
		«term.ifProcessExpr.compileRemainingProcExprForIf(alreadyTraversedProcesses)»;
		«term.elseProcessExpr.compileRemainingProcExprForIf(alreadyTraversedProcesses)»'''
	}
}