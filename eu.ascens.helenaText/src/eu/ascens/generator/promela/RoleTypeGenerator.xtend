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
import eu.ascens.helenaText.DeclaringRoleBehavior
import eu.ascens.helenaText.InvokingRoleBehavior
import eu.ascens.helenaText.RoleBehavior
import java.util.ArrayList

import static extension eu.ascens.generator.promela.NameGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Action.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import eu.ascens.helenaText.RoleType
import eu.ascens.helenaText.Model

class RoleTypeGenerator {
	@Inject ProcessExpressionGenerator procTermGenerator;
	/**
	 * Compiles the process type for a role behavior:
	 * - role type attributes, component type attributes, component type associations become local variables
	 * - for all plays queries, local variable are generated (to avoid redeclaration)
	 * - the role behavior is compiled
	 */
	def compileProctype(RoleType rt, Model model) {
		var rb = model.headPkg.roleBehaviors.findFirst[it.roleTypeRef == rt]
		'''
		/////////////// process definition for role type «rb.roleTypeRef.proctypeName» ////////////////////
		proctype «rb.roleTypeRef.proctypeName»(chan owner, self) {
			// role type attributes
			«FOR attr:rt.roleattrs»
			«attr.type.promelaType» «attr.variableName»;
			«ENDFOR»
			
			// component type attributes
			«FOR attr:rt.ownerComponentType.attrs»
			«attr.type.promelaType» «attr.variableName»;
			«ENDFOR»
			
			// component type associations
			«FOR assoc:rt.ownerComponentType.assocs»
			chan «assoc.variableName»;
			«ENDFOR»
			
			// local variables for all role instance variables (of create/get and incoming messages)
			«FOR inst : rb.abstractRoleInstances»
			chan «inst.variableName»;
			«ENDFOR»
			
			// local variables for all formal data parameters (of incoming messages)
			«FOR param : rb.formalDataParams»
			«param.type.promelaType» «param.varName»;
			«ENDFOR»
			
			// local variables for all return values of operations
			«FOR op : rb.operationCalls»
			«var optype = op.operationType»
			«IF optype.returnType != null && !optype.returnType.type.isVoid»
			«optype.returnType.promelaType» «op.variable.varName»;
			«ENDIF»
			«ENDFOR»
			
			// local variables for all plays queries
			«FOR query:rb.playsQueries»
			bool «query.variableName»;
			«ENDFOR»
			
			// start label
			«rt.startLabelName»: true;
			
			//////// role behavior //////////
			«rb.compileRoleBehavior»;
			
			«rt.endLabelName»: false
		}
		'''
	}
	
	/**
	 * Compiles a role behavior:
	 * - action prefix is realized with sequential composition
	 * - conditional selection is realized with if-selection
	 * - process invocation is realized with labels and gotos since we cannot use inline method with interlaced recursive processes
	 */
	private def dispatch CharSequence compileRoleBehavior(DeclaringRoleBehavior rb) {
		'''«procTermGenerator.compileProcExpr(rb.processExpr, new ArrayList)»'''
	}
	private def dispatch CharSequence compileRoleBehavior(InvokingRoleBehavior rb) {
		'''«procTermGenerator.compileProcExpr(rb.processInvocation, new ArrayList)»'''
	}
}