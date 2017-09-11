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
import eu.ascens.helenaText.AndTerm
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.DataExpression
import eu.ascens.helenaText.EqualityTerm
import eu.ascens.helenaText.GuardInParentheses
import eu.ascens.helenaText.NotTerm
import eu.ascens.helenaText.OrTerm
import eu.ascens.helenaText.PlaysQuery

import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.generator.promela.OperationCallGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*
import eu.ascens.helenaText.Relation

class GuardGenerator {
	@Inject NameGenerator nameGenerator
	
	/**
	 * Compiles a guard composed of or terms
	 */
	def dispatch CharSequence compileRelation(OrTerm term) {
		'''«compileRelation(term.left)» || «compileRelation(term.right)»'''
	}
	
	/**
	 * Compiles a guard composed of and terms
	 */
	def dispatch CharSequence compileRelation(AndTerm term) {
		'''«compileRelation(term.left)» && «compileRelation(term.right)»'''
	}
	/**
	 * Compiles a guard composed of a equality term
	 */
	def dispatch CharSequence compileRelation(EqualityTerm term) {
		'''«compileRelation(term.left)» «term.operator» «compileRelation(term.right)»'''
	}
	
	/**
	 * Compiles a guard composed of a not term
	 */
	def dispatch CharSequence compileRelation(NotTerm term) {
		'''«IF term.not != null»!«ENDIF»«compileAtom(term.atom)»'''
	}
	
	/**
	 * Compiles single atoms in guard
	 * - expressions (formal data params, role attributes, component attributes, data values)
	 * - plays queries
	 * - relations
	 * - guard in parentheses
	 */
	private dispatch def CharSequence compileAtom(DataExpression term) {
		'''«nameGenerator.getDataValue(term)»'''
	}
	private dispatch def CharSequence compileAtom(PlaysQuery term) {
		'''«term.variableName»'''
	}
	private dispatch def CharSequence compileAtom(Relation term) {
		'''«nameGenerator.getDataValue(term.left)» «term.operator» «nameGenerator.getDataValue(term.right)»'''
	}
	private dispatch def CharSequence compileAtom(GuardInParentheses term) {
		'''(«term.guard.compileRelation»)'''
	}
	
	def static compileOperationCallForComponentAttributeQuery(PlaysQuery query, ComponentType owner) {
		'''«query.compInstance.componentType.compileOperationCall(query)»'''
	}
	
	
	
}