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
package eu.ascens.generator.jHelena

import eu.ascens.helenaText.AbstractAssignment
import eu.ascens.helenaText.AbstractDataReference
import eu.ascens.helenaText.AbstractDataValue
import eu.ascens.helenaText.AbstractDataVariableReference
import eu.ascens.helenaText.AbstractRoleInstanceReference
import eu.ascens.helenaText.ActionPrefix
import eu.ascens.helenaText.Addition
import eu.ascens.helenaText.AndTerm
import eu.ascens.helenaText.BooleanValue
import eu.ascens.helenaText.ComponentAssociationTypeReference
import eu.ascens.helenaText.ComponentAttributeSetter
import eu.ascens.helenaText.ComponentAttributeTypeReference
import eu.ascens.helenaText.DeclaringRoleBehavior
import eu.ascens.helenaText.EqualityTerm
import eu.ascens.helenaText.GuardInParentheses
import eu.ascens.helenaText.IfThenElse
import eu.ascens.helenaText.IncomingMessageCall
import eu.ascens.helenaText.InvokingRoleBehavior
import eu.ascens.helenaText.Label
import eu.ascens.helenaText.NondeterministicChoice
import eu.ascens.helenaText.NotTerm
import eu.ascens.helenaText.NumberValue
import eu.ascens.helenaText.OperationCall
import eu.ascens.helenaText.OrTerm
import eu.ascens.helenaText.OutgoingMessageCall
import eu.ascens.helenaText.OwnerReference
import eu.ascens.helenaText.PlaysQuery
import eu.ascens.helenaText.Process
import eu.ascens.helenaText.ProcessInvocation
import eu.ascens.helenaText.QuitTerm
import eu.ascens.helenaText.Relation
import eu.ascens.helenaText.RoleAttributeSetter
import eu.ascens.helenaText.RoleAttributeTypeReference
import eu.ascens.helenaText.RoleBehavior
import eu.ascens.helenaText.RoleType
import eu.ascens.helenaText.SelfReference
import eu.ascens.helenaText.StringValue
import eu.ascens.helenaText.Subtraction
import java.util.Set
import java.util.TreeSet
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable

import static extension eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Action.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_JvmType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

/**
 * Generates Java Code for RoleTypes (abstract and concrete Implementation classes) and 
 * returns it to the caller HelenaLanguageGenerator, who creates the Java Files
 */
class RoleTypeGenerator extends AbstractHelenaTextGenerator{
	private AbstractFieldTypeGenerator fieldTypeGenerator;
	private XbaseCompiler xbase;
	
	protected new (XbaseCompiler xbase, TypeReferenceSerializer serializer, ImportManager im, GeneratorHelper genHelper) {
		super(serializer, im, genHelper)
		this.xbase = xbase;
		
		//Generate AttrTypeGenerator
		this.fieldTypeGenerator = new AbstractFieldTypeGenerator(this.serializer,this.im, this.genHelper)
	}
	
	
	def String compile(RoleType it){
		'''

		«««package 
		package «packageName»;
	    
	    «««imports
		«ImportGenerator.compileImports(it, im)»
		
		
		«««body
		public class «classname» extends Role{
			
			«var RoleBehavior rb = it.roleBehavior»
			«var Set<String> classVars = new TreeSet<String>()»
			
			«««Attributes and assocs from role type
			// role attributes
	   		«FOR field : it.roleattrs»
				«««Add instance variable only if it was not already declared   		
				«IF classVars.add(field.name)»
					«fieldTypeGenerator.compile(field,im)»
				«ENDIF»
		    «ENDFOR»
		    
			«««Attributes from RoleBehavior
			// self variable
			protected final Variable<«classname»> self  = new Variable<>(«classname».«CLASS_EXTENSION»);
			
			// global variables for behavior
			«IF rb != null»
			
				«FOR inst : rb.params»
					«var name = inst.instName»
					«var type = genHelper.getWrappedTypeAsString(inst)»
					«IF classVars.add(name)»
						protected final Variable<«type»> «name» = new Variable<>(«type».«CLASS_EXTENSION»);
					«ENDIF»
				«ENDFOR»
				
				«FOR op : rb.operationCalls»
					«var optype = op.operationType»
					«IF optype.returnType != null && !optype.returnType.type.isVoid»
					«var jvmtype = genHelper.getWrappedTypeAsString(optype.returnType)»
						protected final Variable<«jvmtype»> «op.variable.name» = new Variable<>(«jvmtype».«CLASS_EXTENSION»);
					«ENDIF»
				«ENDFOR»
			«ENDIF»
	
			«««Constructor
			public «classname»(Component comp, Ensemble ens, Integer capacity) {
				super(comp, ens, capacity);
				this.self.setValue(this);
			}

			@Override
			protected ProcessExpression initializeRoleBehavior() throws ReflectionException, PropertyNotDeclaredInClassException {
				«rb.compileRoleBehavior»
			}
		}
		'''
	} 

	def String compileImpl(RoleType it){
		'''
		«««package 
		package «packageName»;
	    
	    «««imports
		«ImportGenerator.compileImplImports(it, im)»
				
		«««body	
		public class «implClassname» extends «classname» {
			
			«««Constructor		
			public «implClassname»(Ensemble ens) {
				super(ens);
			}
		}
		
		'''
	} 

	/**
	 * This compiles a role behavior
	 */
	private def dispatch String compileRoleBehavior(InvokingRoleBehavior rb){
		'''
		«FOR invoc : rb.processInvocations»
		ProcessInvocation invoc«invoc.hashCode» = new ProcessInvocation();
		«ENDFOR»
		
		«FOR proc : rb.processes»
			ProcessExpression «proc.processVarName» = «proc.processExpr.compileProcExpr»;
		«ENDFOR»
		
		«FOR invoc : rb.processInvocations»
		invoc«invoc.hashCode».setInvocatedProcess(«invoc.process.processVarName»);
		«ENDFOR»
		
		return «rb.processInvocation.process.processVarName»;
		'''	
	}
	private def dispatch String compileRoleBehavior(DeclaringRoleBehavior rb){
		'''
		return «rb.processExpr.compileProcExpr»;
		'''
	}
	
	def String getProcessVarName(Process process) {
		return process.name.toFirstLower;
	}
	
	/**
	 * This compiles a process term
	 */
	private def dispatch String compileProcExpr(QuitTerm nil){
		'''
		Quit.getInstance()
		'''
	}
	private def dispatch String compileProcExpr(ActionPrefix actionPrefix){
		'''
		«IF actionPrefix.action instanceof Label»
			«actionPrefix.processExpr.compileProcExpr»
		«ELSE»
		new ActionPrefix(
			«actionPrefix.action.compileAction»,
			«actionPrefix.processExpr.compileProcExpr»
		)
		«ENDIF»
		'''
	}
	private def dispatch String compileProcExpr(IfThenElse condSel){
		'''
		new IfThenElse(
			«condSel.guard.compileRelation»,
			«condSel.ifProcessExpr.compileProcExpr»,
			«condSel.elseProcessExpr.compileProcExpr»
		)
		'''
	}
	private def dispatch String compileProcExpr(NondeterministicChoice choice){
		'''
		new NondeterministicChoice(
			«choice.first.compileProcExpr»,
			«choice.second.compileProcExpr»
		)
		'''
	}
	private def dispatch String compileProcExpr(ProcessInvocation procInvocation){
		'''
		invoc«procInvocation.hashCode»
		'''
	}
	
	/**
	 * This compiles an action
	 */
	private def dispatch String compileAction(OutgoingMessageCall msgCall){
		var actualRoleParams = msgCall.actualRoleParamsBlock.params
		var actualDataParams = msgCall.actualDataParamsBlock.params
		
		'''
		
		new SendMessageAction(
			this.«msgCall.receiver.ref.instName»,
			new «msgCall.messageType.classname»(
				«FOR roleParam : actualRoleParams SEPARATOR ","»
					«roleParam.compileRoleInstance»
				«ENDFOR»
				«IF actualRoleParams.size > 0 && actualDataParams.size > 0», «ENDIF»
				«FOR dataParam : actualDataParams SEPARATOR ","»
					«dataParam.compileDataExpressionVariable»
				«ENDFOR»			
			)
		)
		'''
	}
	private def dispatch String compileAction(IncomingMessageCall msgCall){
		var roleParams = msgCall.formalRoleParamsBlock.params
		var dataParams = msgCall.formalDataParamsBlock.params
		
		'''
		new ReceiveMessageAction(
			new «msgCall.messageType.classname»(
				«FOR roleParam : roleParams SEPARATOR ","»
					«roleParam.instName»
				«ENDFOR»
				«IF roleParams.size > 0 && dataParams.size > 0», «ENDIF»
				«FOR dataParam : dataParams SEPARATOR ","»
					«dataParam.instName»
				«ENDFOR»			
			)
		)
		'''
	}
	private def dispatch String compileAction(AbstractAssignment a){
		'''
		new CreateRoleAction<>(
			«a.roleInst.instName»,
			«a.roleTypeRef.classname».«CLASS_EXTENSION»,
			«compileComponentInstance(a.compInstance)»
		)
		'''
	}
	private def dispatch String compileAction(OperationCall opCall){
		var optype = opCall.operationType
		'''
		new OperationCallAction<>(
			new Variable<>(«genHelper.getWrappedTypeAsString(optype.returnType)».«CLASS_EXTENSION»),
			new «optype.classname»(
			«FOR param: opCall.actualDataParamsBlock.params SEPARATOR ','»
				«param.compileDataExpressionVariable»
			«ENDFOR»
			), 
			«genHelper.getWrappedTypeAsString(optype.returnType)».«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileAction(RoleAttributeSetter roleAttrSetter){
		'''
		new RoleAttrSetterAction(
			"«roleAttrSetter.attr.ref.name»", 
			«roleAttrSetter.value.compileDataExpressionVariable»
		)
		'''
	}
	private def dispatch String compileAction(ComponentAttributeSetter compAttrSetter){
		'''
		new CompAttrSetterAction(
			"«compAttrSetter.attr.ref.name»", 
			«compAttrSetter.value.compileDataExpressionVariable»
		)
		'''
	}
	
	private def dispatch String compileRelation(OrTerm term){
		'''
		«IF term.right != null»
		new OrGuard(«compileRelation(term.left)», «compileRelation(term.right)»)
		«ELSE»
		«compileRelation(term.left)»
		«ENDIF»
		'''
	}
	private def dispatch String compileRelation(AndTerm term){
		'''
		«IF term.right != null»
		new AndGuard(«compileRelation(term.left)», «compileRelation(term.right)»)
		«ELSE»
		«compileRelation(term.left)»
		«ENDIF»
		'''
	}
	private def dispatch String compileRelation(EqualityTerm term){
		'''
		«IF term.right != null»
		new ComposedExpression(
			«term.left.compileRelation»
			,
			«IF term.operator == '=='»
			ExpressionOperator.EQUAL
			«ELSE»
			ExpressionOperator.UNEQUAL
			«ENDIF»
			,
			 «term.right.compileRelation»
		)
		«ELSE»
		«compileRelation(term.left)»
		«ENDIF»
		'''
	}
	private def dispatch String compileRelation(NotTerm term){
		'''
		«IF term.not != null»
		new NotGuard(«compileAtom(term.atom)»)
		«ELSE»
		«compileAtom(term.atom)»
		«ENDIF»
		'''
	}
	
	private def dispatch String compileAtom(Addition atom) {
		'''new Atom(«atom.left.compileDataExpression» + «atom.right.compileDataExpression»)'''
	}
	private def dispatch String compileAtom(Subtraction atom) {
		'''new Atom(«atom.left.compileDataExpression» - «atom.right.compileDataExpression»)'''
	}
	private def dispatch String compileAtom(AbstractDataValue atom){
		return atom.compileDataExpressionAtom;
	}
	private def dispatch String compileAtom(AbstractDataReference atom){
		return atom.compileDataExpressionAtom;
	}
	private def dispatch String compileAtom(PlaysQuery atom){
		'''
		new PlaysQuery(
			«atom.compInstance.compileComponentInstance»,
			«atom.roleTypeRef.classname».«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileAtom(Relation term){
		'''
		new Atom(
			«term.left.compileDataExpression» «term.operator» «term.right.compileDataExpression»
		)
		'''
	}
	private def dispatch String compileAtom(GuardInParentheses atom){
		'''
		«atom.guard.compileRelation»
		'''
	}
	
	private def dispatch String compileComponentInstance(ComponentAssociationTypeReference compInst){
		'''
		new CompAssociationGetter("«compInst.ref.name»").getValue(this)
		'''
	}
	private def dispatch String compileComponentInstance(OwnerReference compInst){
		'''this.getOwner()'''
	}
	
	private def dispatch String compileRoleInstance(AbstractRoleInstanceReference roleInstRef){
		'''
		this.«roleInstRef.ref.instName»
		'''
	}
	private def dispatch String compileRoleInstance(SelfReference selfRef){
		'''
		this.self
		'''
	}
	
	private def dispatch String compileDataExpressionVariable(AbstractDataVariableReference dataVarRef){
		'''
		this.«dataVarRef.ref.instName»
		'''
	}
	private def dispatch String compileDataExpressionVariable(RoleAttributeTypeReference roleAttrTypeRef){
		'''
		new Variable<>(
			new RoleAttrGetter<>(
				"«roleAttrTypeRef.ref.name»", 
				«genHelper.getWrappedTypeAsString(roleAttrTypeRef.ref)».«CLASS_EXTENSION»
			).getValue(this),
			«genHelper.getWrappedTypeAsString(roleAttrTypeRef.ref)».«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionVariable(ComponentAttributeTypeReference compAttrTypeRef){
		'''
		new Variable<>(
			new CompAttrGetter<>(
				"«compAttrTypeRef.ref.name»", 
				«genHelper.getWrappedTypeAsString(compAttrTypeRef.ref)».«CLASS_EXTENSION»
			).getValue(this),
			«genHelper.getWrappedTypeAsString(compAttrTypeRef.ref)».«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionVariable(BooleanValue expr){
		'''
		new Variable<Boolean>(
			new Boolean(«expr.value.compile»),
			Boolean.«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionVariable(NumberValue expr){
		'''
		new Variable<Double>(
			new Double(«expr.value.compile»),
			Double.«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionVariable(StringValue expr){
		'''
		new Variable<String>(
			new String(«expr.value.compile»),
			String.«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionVariable(Addition exp) {
		'''
		new Variable<>(
			«exp.left.compileDataExpression» + «exp.right.compileDataExpression»,
			Double.«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionVariable(Subtraction exp) {
		'''
		new Variable<>(
			«exp.left.compileDataExpression» - «exp.right.compileDataExpression»,
			Double.«CLASS_EXTENSION»
		)
		'''
	}
	
	private def dispatch String compileDataExpression(AbstractDataVariableReference dataVarRef){
		'''
		this.«dataVarRef.ref.instName».getValue()
		'''
	}
	private def dispatch String compileDataExpression(RoleAttributeTypeReference roleAttrTypeRef){
		'''
		new RoleAttrGetter<>(
			"«roleAttrTypeRef.ref.name»", 
			«genHelper.getWrappedTypeAsString(roleAttrTypeRef.ref)».«CLASS_EXTENSION»
		).getValue(this)
		'''
	}
	private def dispatch String compileDataExpression(ComponentAttributeTypeReference compAttrTypeRef){
		'''
		new CompAttrGetter<>(
			"«compAttrTypeRef.ref.name»", 
			«genHelper.getWrappedTypeAsString(compAttrTypeRef.ref)».«CLASS_EXTENSION»
		).getValue(this)
		'''
	}
	private def dispatch String compileDataExpression(AbstractDataValue expr){
		'''«expr.value.compile»'''
	}
	private def dispatch String compileDataExpression(Addition exp) {
		'''«exp.left.compileDataExpression» + «exp.right.compileDataExpression»'''
	}
	private def dispatch String compileDataExpression(Subtraction exp) {
		'''«exp.left.compileDataExpression» - «exp.right.compileDataExpression»'''
	}
	
	private def dispatch String compileDataExpressionAtom(AbstractDataVariableReference dataVarRef){
		'''
		new Atom(this.«dataVarRef.ref.instName».getValue())
		'''
	}
	private def dispatch String compileDataExpressionAtom(RoleAttributeTypeReference roleAttrTypeRef){
		'''
		new RoleAttrGetter<>(
			"«roleAttrTypeRef.ref.name»", 
			«genHelper.getWrappedTypeAsString(roleAttrTypeRef.ref)».«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionAtom(ComponentAttributeTypeReference compAttrTypeRef){
		'''
		new CompAttrGetter<>(
			"«compAttrTypeRef.ref.name»", 
			«genHelper.getWrappedTypeAsString(compAttrTypeRef.ref)».«CLASS_EXTENSION»
		)
		'''
	}
	private def dispatch String compileDataExpressionAtom(AbstractDataValue expr){
		'''new Atom(«expr.value.compile»)'''
	}
	private def dispatch String compileDataExpressionAtom(Addition exp) {
		'''new Atom(«exp.left.compileDataExpression» + «exp.right.compileDataExpression»)'''
	}
	private def dispatch String compileDataExpressionAtom(Subtraction exp) {
		'''new Atom(«exp.left.compileDataExpression» - «exp.right.compileDataExpression»)'''
	}
	
	private def String compile(XExpression expr){
		val result = new FakeTreeAppendable(im);
		try{
			xbase.toJavaExpression(expr, result);
		}catch(NullPointerException e){
			System.err.println("Error in toJavaStatement")
			return "error"
		}
		return result.toString;
	}
}