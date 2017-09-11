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
package eu.ascens.formatting

import eu.ascens.services.HelenaTextGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import org.eclipse.xtext.util.Pair;
import org.eclipse.emf.ecore.EObject

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class HelenaTextFormatter extends AbstractDeclarativeFormatter {


	override protected void configureFormatting(FormattingConfig c) {
		var HelenaTextGrammarAccess f = getGrammarAccess() as HelenaTextGrammarAccess;
		
		c.setAutoLinewrap(120);

		// find common keywords an specify formatting for them
		setNoSpaceAroundPair("(",")", c, f);
		setNoSpacesInsidePair("<",">", c, f);
		
		setNoSpaceBefore(",", c, f);
		setNoSpaceBefore(";", c, f);
		setNoSpaceAfter("owner.", c, f);
		setNoSpaceAfter("self.", c, f);
		setSpacesAround("=", c, f);
		
		// linebreak after ;
		for (Keyword semicolon : f.findKeywords(";")) {
			c.setLinewrap(1).after(semicolon);
		}
		
		
		// formatting for grammar rule PackageDeclartion
		c.setLinewrap(2).after(f.getPackageDeclarationAccess().leftCurlyBracketKeyword_0_2);
		c.setLinewrap(2).before(f.getPackageDeclarationAccess().rightCurlyBracketKeyword_3_1);
		c.setIndentationIncrement().after(f.getPackageDeclarationAccess.leftCurlyBracketKeyword_0_2);
		c.setIndentationDecrement().before(f.getPackageDeclarationAccess().rightCurlyBracketKeyword_3_1);
		
		
		// formatting for grammar rule ComponentType
		c.setLinewrap(1).after(f.getComponentTypeAccess().leftCurlyBracketKeyword_2);
		c.setLinewrap(2).after(f.getComponentTypeAccess().rightCurlyBracketKeyword_4);
		c.setIndentation(f.getComponentTypeAccess().leftCurlyBracketKeyword_2, f.getComponentTypeAccess().rightCurlyBracketKeyword_4);
		
		// formatting for grammar rule RoleType
		c.setLinewrap(1).after(f.getRoleTypeAccess().leftCurlyBracketKeyword_5);
		c.setLinewrap(2).after(f.getRoleTypeAccess().rightCurlyBracketKeyword_7);
		c.setIndentation(f.getRoleTypeAccess().leftCurlyBracketKeyword_5, f.getRoleTypeAccess().rightCurlyBracketKeyword_7);
		
		// formatting for grammar rule Ensemble Structure
		c.setLinewrap(1).after(f.getEnsembleStructureAccess().leftCurlyBracketKeyword_2);
		c.setLinewrap(2).after(f.getEnsembleStructureAccess().rightCurlyBracketKeyword_5);
		c.setIndentationIncrement().after(f.getEnsembleStructureAccess().leftCurlyBracketKeyword_2);
		c.setIndentationDecrement().before(f.getEnsembleStructureAccess().rightCurlyBracketKeyword_5);
		
		// formatting for grammar rule RoleBehavior
		c.setLinewrap(2).before(f.getRoleBehaviorAccess().roleBehaviorKeyword_0_1);
		c.setLinewrap(2).before(f.getRoleBehaviorAccess().roleBehaviorKeyword_1_1);

		// wrap and indent after processInvocation in InvokingRoleBehavior
		c.setLinewrap(1).after(f.getRoleBehaviorAccess().leftCurlyBracketKeyword_1_5);
		c.setLinewrap(1).before(f.getRoleBehaviorAccess().rightCurlyBracketKeyword_1_7);
		c.setIndentation(f.roleBehaviorAccess.leftCurlyBracketKeyword_1_5, f.roleBehaviorAccess.rightCurlyBracketKeyword_1_7);
		c.setIndentationDecrement().before(f.getRoleBehaviorAccess().rightCurlyBracketKeyword_1_7);
		
		// indentation and wrap for if-then-else
		c.setIndentation(f.ifThenElseAccess.leftCurlyBracketKeyword_4, f.ifThenElseAccess.rightCurlyBracketKeyword_6);
		c.setIndentation(f.ifThenElseAccess.leftCurlyBracketKeyword_8, f.ifThenElseAccess.rightCurlyBracketKeyword_10);
		// wrap after left curly bracket of conditional selection
		c.setLinewrap(1).after(f.ifThenElseAccess.leftCurlyBracketKeyword_4);
		c.setLinewrap(1).after(f.ifThenElseAccess.leftCurlyBracketKeyword_8);
		// wrap right bracket of conditional selection into next line
		c.setLinewrap(1).before(f.ifThenElseAccess.rightCurlyBracketKeyword_6);
		c.setLinewrap(1).before(f.ifThenElseAccess.rightCurlyBracketKeyword_10);
		// wrap in If-Then-Else: before or keyword, 
		c.setLinewrap(1).before(f.ifThenElseAccess.elseKeyword_7);
		
		// indentation and wrap for nondeterministic choice
		c.setIndentation(f.nondeterministicChoiceAccess.leftParenthesisKeyword_0, f.nondeterministicChoiceAccess.rightParenthesisKeyword_4);
		// wrap plus of nondeterministic choice into next line
		c.setLinewrap(1).before(f.nondeterministicChoiceAccess.plusSignKeyword_2);
		c.setLinewrap(1).after(f.nondeterministicChoiceAccess.plusSignKeyword_2);
		// wrap bracket of nondeterministic choice into next line
		c.setLinewrap(1).before(f.nondeterministicChoiceAccess.leftParenthesisKeyword_0);
		c.setLinewrap(1).after(f.nondeterministicChoiceAccess.rightParenthesisKeyword_4);
			
		// wrap before procTerm
		c.setLinewrap(1).before(f.processExpressionAccess.quitTermAction_0_0);
		c.setLinewrap(1).before(f.processExpressionAccess.actionPrefixParserRuleCall_1);
		c.setLinewrap(1).before(f.processExpressionAccess.nondeterministicChoiceParserRuleCall_2);
		c.setLinewrap(1).before(f.processExpressionAccess.ifThenElseParserRuleCall_3);
		c.setLinewrap(1).before(f.processExpressionAccess.processInvocationParserRuleCall_4);
		
		// wrap before process keyword, after = keyword
		c.setLinewrap(1).before(f.getProcessAccess().processKeyword_0);
		c.setLinewrap(1).after(f.getProcessAccess().equalsSignKeyword_2);
		c.setIndentationIncrement().after(f.getProcessAccess().processKeyword_0);
		c.setIndentationDecrement().before(f.getProcessAccess().processKeyword_0);
		

		// just for making decrement before process keyword work
		c.setIndentationIncrement().after(f.getRoleBehaviorAccess().leftCurlyBracketKeyword_1_5);
		
		
		// formatting for comments
		config.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		config.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		config.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());
	}
	
	
	/**
	 * Sets no space before first, after first and before second PairKeyword in the FormattingConfig
	 */
	private def void setNoSpaceAroundPair(String first, String second, FormattingConfig c, HelenaTextGrammarAccess f){
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs(first, second)) {
			c.setNoSpace().before(pair.getFirst());
			c.setNoSpace().after(pair.getFirst());
			c.setNoSpace().before(pair.getSecond());
		}
	}
	private def void setNoSpacesInsidePair(String first, String second, FormattingConfig c, HelenaTextGrammarAccess f){
		for (Pair<Keyword, Keyword> pair : f.findKeywordPairs(first, second)) {
			c.setNoSpace().after(pair.getFirst());
			c.setNoSpace().before(pair.getSecond());
		}
	}
	
	private def void setNoSpaceBefore(String keyword, FormattingConfig c, HelenaTextGrammarAccess f){
		for (Keyword k : f.findKeywords(keyword)){
			c.setNoSpace().before(k);
		}
	}
	private def void setNoSpaceAfter(String keyword, FormattingConfig c, HelenaTextGrammarAccess f){
		for (Keyword k : f.findKeywords(keyword)){
			c.setNoSpace().after(k);
		}
	}
	private def void setSpacesAround(String keyword, FormattingConfig c, HelenaTextGrammarAccess f){
		for (Keyword k : f.findKeywords(keyword)){
			
			var EObject current = k.eContainer;
			while (current != null || ! (current instanceof eu.ascens.helenaText.Process)) {
				return;
			}
			
			c.setSpace(" ").before(k);
			c.setSpace(" ").after(k);
		}
	}
}
