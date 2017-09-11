/*
 * generated by Xtext
 */
package eu.ascens.serializer;

import com.google.inject.Inject;
import eu.ascens.services.HelenaTextGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class HelenaTextSyntacticSequencer extends AbstractSyntacticSequencer {

	protected HelenaTextGrammarAccess grammarAccess;
	protected AbstractElementAlias match_PackageDeclaration_RightCurlyBracketKeyword_3_1_a;
	protected AbstractElementAlias match_PackageDeclaration_RightCurlyBracketKeyword_3_1_p;
	protected AbstractElementAlias match_XBlockExpression_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_XExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_XParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (HelenaTextGrammarAccess) access;
		match_PackageDeclaration_RightCurlyBracketKeyword_3_1_a = new TokenAlias(true, true, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_3_1());
		match_PackageDeclaration_RightCurlyBracketKeyword_3_1_p = new TokenAlias(true, false, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_3_1());
		match_XBlockExpression_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
		match_XExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_XParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_PackageDeclaration_RightCurlyBracketKeyword_3_1_a.equals(syntax))
				emit_PackageDeclaration_RightCurlyBracketKeyword_3_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PackageDeclaration_RightCurlyBracketKeyword_3_1_p.equals(syntax))
				emit_PackageDeclaration_RightCurlyBracketKeyword_3_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XBlockExpression_SemicolonKeyword_2_1_q.equals(syntax))
				emit_XBlockExpression_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_XExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XImportDeclaration_SemicolonKeyword_2_q.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '}'*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'package' name=QualifiedName
	 *     (rule start) (ambiguity) (rule start)
	 *     (rule start) (ambiguity) ensStructs+=EnsembleStructure
	 *     (rule start) (ambiguity) roleBehaviors+=RoleBehavior
	 *     (rule start) (ambiguity) roleTypes+=RoleType
	 *     compTypes+=ComponentType (ambiguity) 'package' name=QualifiedName
	 *     compTypes+=ComponentType (ambiguity) (rule end)
	 *     compTypes+=ComponentType (ambiguity) ensStructs+=EnsembleStructure
	 *     compTypes+=ComponentType (ambiguity) roleBehaviors+=RoleBehavior
	 *     compTypes+=ComponentType (ambiguity) roleTypes+=RoleType
	 *     ensStructs+=EnsembleStructure (ambiguity) 'package' name=QualifiedName
	 *     ensStructs+=EnsembleStructure (ambiguity) (rule end)
	 *     ensStructs+=EnsembleStructure (ambiguity) ensStructs+=EnsembleStructure
	 *     ensStructs+=EnsembleStructure (ambiguity) roleBehaviors+=RoleBehavior
	 *     ensStructs+=EnsembleStructure (ambiguity) roleTypes+=RoleType
	 *     name=QualifiedName '{' (ambiguity) 'package' name=QualifiedName
	 *     name=QualifiedName '{' (ambiguity) (rule end)
	 *     name=QualifiedName '{' (ambiguity) ensStructs+=EnsembleStructure
	 *     name=QualifiedName '{' (ambiguity) roleBehaviors+=RoleBehavior
	 *     name=QualifiedName '{' (ambiguity) roleTypes+=RoleType
	 *     roleBehaviors+=RoleBehavior (ambiguity) roleBehaviors+=RoleBehavior
	 *     roleTypes+=RoleType (ambiguity) 'package' name=QualifiedName
	 *     roleTypes+=RoleType (ambiguity) (rule end)
	 *     roleTypes+=RoleType (ambiguity) ensStructs+=EnsembleStructure
	 *     roleTypes+=RoleType (ambiguity) roleBehaviors+=RoleBehavior
	 *     roleTypes+=RoleType (ambiguity) roleTypes+=RoleType
	 */
	protected void emit_PackageDeclaration_RightCurlyBracketKeyword_3_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '}'+
	 *
	 * This ambiguous syntax occurs at:
	 *     roleBehaviors+=RoleBehavior (ambiguity) 'package' name=QualifiedName
	 *     roleBehaviors+=RoleBehavior (ambiguity) (rule end)
	 *     roleBehaviors+=RoleBehavior (ambiguity) ensStructs+=EnsembleStructure
	 *     roleBehaviors+=RoleBehavior (ambiguity) roleTypes+=RoleType
	 */
	protected void emit_PackageDeclaration_RightCurlyBracketKeyword_3_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) '}' ')' (rule end)
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) '}' (rule end)
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) expressions+=XExpressionOrVarDeclaration
	 */
	protected void emit_XBlockExpression_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) (rule end)
	 *     expressions+=XExpressionOrVarDeclaration (ambiguity) expressions+=XExpressionOrVarDeclaration
	 */
	protected void emit_XExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '=>' returnType=JvmTypeReference
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     importedNamespace=QualifiedNameWithWildcard (ambiguity) (rule end)
	 *     importedType=[JvmDeclaredType|QualifiedName] (ambiguity) (rule end)
	 *     memberName=ValidID (ambiguity) (rule end)
	 *     wildcard?='*' (ambiguity) (rule end)
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=XExpression
	 *     (rule start) (ambiguity) '#' '{' '}' (rule start)
	 *     (rule start) (ambiguity) '#' '{' elements+=XExpression
	 *     (rule start) (ambiguity) '<' typeArguments+=JvmArgumentTypeReference
	 *     (rule start) (ambiguity) '[' declaredFormalParameters+=JvmFormalParameter
	 *     (rule start) (ambiguity) '[' explicitSyntax?='|'
	 *     (rule start) (ambiguity) '[' expression=XExpressionInClosure
	 *     (rule start) (ambiguity) 'do' body=XExpression
	 *     (rule start) (ambiguity) 'false' (rule start)
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' ')' eachExpression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' updateExpressions+=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' expression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'for' '(' initExpressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) 'if' '(' if=XExpression
	 *     (rule start) (ambiguity) 'new' constructor=[JvmConstructor|QualifiedName]
	 *     (rule start) (ambiguity) 'null' (rule start)
	 *     (rule start) (ambiguity) 'return' (rule start)
	 *     (rule start) (ambiguity) 'return' expression=XExpression
	 *     (rule start) (ambiguity) 'switch' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' switch=XExpression
	 *     (rule start) (ambiguity) 'synchronized' '(' param=XExpression
	 *     (rule start) (ambiguity) 'throw' expression=XExpression
	 *     (rule start) (ambiguity) 'try' expression=XExpression
	 *     (rule start) (ambiguity) 'typeof' '(' type=[JvmType|QualifiedName]
	 *     (rule start) (ambiguity) 'while' '(' predicate=XExpression
	 *     (rule start) (ambiguity) '{' '}' (rule start)
	 *     (rule start) (ambiguity) '{' expressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|FeatureCallID]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|IdOrSuper]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpUnary]
	 *     (rule start) (ambiguity) isTrue?='true'
	 *     (rule start) (ambiguity) value=Number
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {XAssignment.assignable=}
	 *     (rule start) (ambiguity) {XBinaryOperation.leftOperand=}
	 *     (rule start) (ambiguity) {XCastedExpression.target=}
	 *     (rule start) (ambiguity) {XInstanceOfExpression.expression=}
	 *     (rule start) (ambiguity) {XMemberFeatureCall.memberCallTarget=}
	 *     (rule start) (ambiguity) {XPostfixOperation.operand=}
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '#' '[' ']' ')' (rule start)
	 *     (rule start) (ambiguity) '#' '[' elements+=XExpression
	 *     (rule start) (ambiguity) '#' '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '#' '{' elements+=XExpression
	 *     (rule start) (ambiguity) '<' typeArguments+=JvmArgumentTypeReference
	 *     (rule start) (ambiguity) '[' declaredFormalParameters+=JvmFormalParameter
	 *     (rule start) (ambiguity) '[' explicitSyntax?='|'
	 *     (rule start) (ambiguity) '[' expression=XExpressionInClosure
	 *     (rule start) (ambiguity) 'do' body=XExpression
	 *     (rule start) (ambiguity) 'false' ')' (rule start)
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' ')' eachExpression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' ';' updateExpressions+=XExpression
	 *     (rule start) (ambiguity) 'for' '(' ';' expression=XExpression
	 *     (rule start) (ambiguity) 'for' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'for' '(' initExpressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) 'if' '(' if=XExpression
	 *     (rule start) (ambiguity) 'new' constructor=[JvmConstructor|QualifiedName]
	 *     (rule start) (ambiguity) 'null' ')' (rule start)
	 *     (rule start) (ambiguity) 'return' ')' (rule start)
	 *     (rule start) (ambiguity) 'return' expression=XExpression
	 *     (rule start) (ambiguity) 'switch' '(' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' declaredParam=JvmFormalParameter
	 *     (rule start) (ambiguity) 'switch' switch=XExpression
	 *     (rule start) (ambiguity) 'synchronized' '(' param=XExpression
	 *     (rule start) (ambiguity) 'throw' expression=XExpression
	 *     (rule start) (ambiguity) 'try' expression=XExpression
	 *     (rule start) (ambiguity) 'typeof' '(' type=[JvmType|QualifiedName]
	 *     (rule start) (ambiguity) 'while' '(' predicate=XExpression
	 *     (rule start) (ambiguity) '{' '}' ')' (rule start)
	 *     (rule start) (ambiguity) '{' expressions+=XExpressionOrVarDeclaration
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|FeatureCallID]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|IdOrSuper]
	 *     (rule start) (ambiguity) feature=[JvmIdentifiableElement|OpUnary]
	 *     (rule start) (ambiguity) isTrue?='true'
	 *     (rule start) (ambiguity) value=Number
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) {XAssignment.assignable=}
	 *     (rule start) (ambiguity) {XBinaryOperation.leftOperand=}
	 *     (rule start) (ambiguity) {XCastedExpression.target=}
	 *     (rule start) (ambiguity) {XInstanceOfExpression.expression=}
	 *     (rule start) (ambiguity) {XMemberFeatureCall.memberCallTarget=}
	 *     (rule start) (ambiguity) {XPostfixOperation.operand=}
	 */
	protected void emit_XParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}