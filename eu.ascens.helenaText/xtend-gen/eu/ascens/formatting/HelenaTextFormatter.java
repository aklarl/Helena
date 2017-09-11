/**
 * The Helena workbench is an Eclipse plugin for the development of ensemble-based systems
 *  according to the Helena approach. It is fully documented in the PhD
 *  thesis "Helena - Handling massively distributed systems with ELaborate
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 * 
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
 */
package eu.ascens.formatting;

import com.google.common.base.Objects;
import eu.ascens.services.HelenaTextGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class HelenaTextFormatter extends AbstractDeclarativeFormatter {
  @Override
  protected void configureFormatting(final FormattingConfig c) {
    IGrammarAccess _grammarAccess = this.getGrammarAccess();
    HelenaTextGrammarAccess f = ((HelenaTextGrammarAccess) _grammarAccess);
    c.setAutoLinewrap(120);
    this.setNoSpaceAroundPair("(", ")", c, f);
    this.setNoSpacesInsidePair("<", ">", c, f);
    this.setNoSpaceBefore(",", c, f);
    this.setNoSpaceBefore(";", c, f);
    this.setNoSpaceAfter("owner.", c, f);
    this.setNoSpaceAfter("self.", c, f);
    this.setSpacesAround("=", c, f);
    List<Keyword> _findKeywords = f.findKeywords(";");
    for (final Keyword semicolon : _findKeywords) {
      FormattingConfig.LinewrapLocator _setLinewrap = c.setLinewrap(1);
      _setLinewrap.after(semicolon);
    }
    FormattingConfig.LinewrapLocator _setLinewrap_1 = c.setLinewrap(2);
    HelenaTextGrammarAccess.PackageDeclarationElements _packageDeclarationAccess = f.getPackageDeclarationAccess();
    Keyword _leftCurlyBracketKeyword_0_2 = _packageDeclarationAccess.getLeftCurlyBracketKeyword_0_2();
    _setLinewrap_1.after(_leftCurlyBracketKeyword_0_2);
    FormattingConfig.LinewrapLocator _setLinewrap_2 = c.setLinewrap(2);
    HelenaTextGrammarAccess.PackageDeclarationElements _packageDeclarationAccess_1 = f.getPackageDeclarationAccess();
    Keyword _rightCurlyBracketKeyword_3_1 = _packageDeclarationAccess_1.getRightCurlyBracketKeyword_3_1();
    _setLinewrap_2.before(_rightCurlyBracketKeyword_3_1);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement = c.setIndentationIncrement();
    HelenaTextGrammarAccess.PackageDeclarationElements _packageDeclarationAccess_2 = f.getPackageDeclarationAccess();
    Keyword _leftCurlyBracketKeyword_0_2_1 = _packageDeclarationAccess_2.getLeftCurlyBracketKeyword_0_2();
    _setIndentationIncrement.after(_leftCurlyBracketKeyword_0_2_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement = c.setIndentationDecrement();
    HelenaTextGrammarAccess.PackageDeclarationElements _packageDeclarationAccess_3 = f.getPackageDeclarationAccess();
    Keyword _rightCurlyBracketKeyword_3_1_1 = _packageDeclarationAccess_3.getRightCurlyBracketKeyword_3_1();
    _setIndentationDecrement.before(_rightCurlyBracketKeyword_3_1_1);
    FormattingConfig.LinewrapLocator _setLinewrap_3 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ComponentTypeElements _componentTypeAccess = f.getComponentTypeAccess();
    Keyword _leftCurlyBracketKeyword_2 = _componentTypeAccess.getLeftCurlyBracketKeyword_2();
    _setLinewrap_3.after(_leftCurlyBracketKeyword_2);
    FormattingConfig.LinewrapLocator _setLinewrap_4 = c.setLinewrap(2);
    HelenaTextGrammarAccess.ComponentTypeElements _componentTypeAccess_1 = f.getComponentTypeAccess();
    Keyword _rightCurlyBracketKeyword_4 = _componentTypeAccess_1.getRightCurlyBracketKeyword_4();
    _setLinewrap_4.after(_rightCurlyBracketKeyword_4);
    HelenaTextGrammarAccess.ComponentTypeElements _componentTypeAccess_2 = f.getComponentTypeAccess();
    Keyword _leftCurlyBracketKeyword_2_1 = _componentTypeAccess_2.getLeftCurlyBracketKeyword_2();
    HelenaTextGrammarAccess.ComponentTypeElements _componentTypeAccess_3 = f.getComponentTypeAccess();
    Keyword _rightCurlyBracketKeyword_4_1 = _componentTypeAccess_3.getRightCurlyBracketKeyword_4();
    c.setIndentation(_leftCurlyBracketKeyword_2_1, _rightCurlyBracketKeyword_4_1);
    FormattingConfig.LinewrapLocator _setLinewrap_5 = c.setLinewrap(1);
    HelenaTextGrammarAccess.RoleTypeElements _roleTypeAccess = f.getRoleTypeAccess();
    Keyword _leftCurlyBracketKeyword_5 = _roleTypeAccess.getLeftCurlyBracketKeyword_5();
    _setLinewrap_5.after(_leftCurlyBracketKeyword_5);
    FormattingConfig.LinewrapLocator _setLinewrap_6 = c.setLinewrap(2);
    HelenaTextGrammarAccess.RoleTypeElements _roleTypeAccess_1 = f.getRoleTypeAccess();
    Keyword _rightCurlyBracketKeyword_7 = _roleTypeAccess_1.getRightCurlyBracketKeyword_7();
    _setLinewrap_6.after(_rightCurlyBracketKeyword_7);
    HelenaTextGrammarAccess.RoleTypeElements _roleTypeAccess_2 = f.getRoleTypeAccess();
    Keyword _leftCurlyBracketKeyword_5_1 = _roleTypeAccess_2.getLeftCurlyBracketKeyword_5();
    HelenaTextGrammarAccess.RoleTypeElements _roleTypeAccess_3 = f.getRoleTypeAccess();
    Keyword _rightCurlyBracketKeyword_7_1 = _roleTypeAccess_3.getRightCurlyBracketKeyword_7();
    c.setIndentation(_leftCurlyBracketKeyword_5_1, _rightCurlyBracketKeyword_7_1);
    FormattingConfig.LinewrapLocator _setLinewrap_7 = c.setLinewrap(1);
    HelenaTextGrammarAccess.EnsembleStructureElements _ensembleStructureAccess = f.getEnsembleStructureAccess();
    Keyword _leftCurlyBracketKeyword_2_2 = _ensembleStructureAccess.getLeftCurlyBracketKeyword_2();
    _setLinewrap_7.after(_leftCurlyBracketKeyword_2_2);
    FormattingConfig.LinewrapLocator _setLinewrap_8 = c.setLinewrap(2);
    HelenaTextGrammarAccess.EnsembleStructureElements _ensembleStructureAccess_1 = f.getEnsembleStructureAccess();
    Keyword _rightCurlyBracketKeyword_5 = _ensembleStructureAccess_1.getRightCurlyBracketKeyword_5();
    _setLinewrap_8.after(_rightCurlyBracketKeyword_5);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_1 = c.setIndentationIncrement();
    HelenaTextGrammarAccess.EnsembleStructureElements _ensembleStructureAccess_2 = f.getEnsembleStructureAccess();
    Keyword _leftCurlyBracketKeyword_2_3 = _ensembleStructureAccess_2.getLeftCurlyBracketKeyword_2();
    _setIndentationIncrement_1.after(_leftCurlyBracketKeyword_2_3);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_1 = c.setIndentationDecrement();
    HelenaTextGrammarAccess.EnsembleStructureElements _ensembleStructureAccess_3 = f.getEnsembleStructureAccess();
    Keyword _rightCurlyBracketKeyword_5_1 = _ensembleStructureAccess_3.getRightCurlyBracketKeyword_5();
    _setIndentationDecrement_1.before(_rightCurlyBracketKeyword_5_1);
    FormattingConfig.LinewrapLocator _setLinewrap_9 = c.setLinewrap(2);
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess = f.getRoleBehaviorAccess();
    Keyword _roleBehaviorKeyword_0_1 = _roleBehaviorAccess.getRoleBehaviorKeyword_0_1();
    _setLinewrap_9.before(_roleBehaviorKeyword_0_1);
    FormattingConfig.LinewrapLocator _setLinewrap_10 = c.setLinewrap(2);
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess_1 = f.getRoleBehaviorAccess();
    Keyword _roleBehaviorKeyword_1_1 = _roleBehaviorAccess_1.getRoleBehaviorKeyword_1_1();
    _setLinewrap_10.before(_roleBehaviorKeyword_1_1);
    FormattingConfig.LinewrapLocator _setLinewrap_11 = c.setLinewrap(1);
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess_2 = f.getRoleBehaviorAccess();
    Keyword _leftCurlyBracketKeyword_1_5 = _roleBehaviorAccess_2.getLeftCurlyBracketKeyword_1_5();
    _setLinewrap_11.after(_leftCurlyBracketKeyword_1_5);
    FormattingConfig.LinewrapLocator _setLinewrap_12 = c.setLinewrap(1);
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess_3 = f.getRoleBehaviorAccess();
    Keyword _rightCurlyBracketKeyword_1_7 = _roleBehaviorAccess_3.getRightCurlyBracketKeyword_1_7();
    _setLinewrap_12.before(_rightCurlyBracketKeyword_1_7);
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess_4 = f.getRoleBehaviorAccess();
    Keyword _leftCurlyBracketKeyword_1_5_1 = _roleBehaviorAccess_4.getLeftCurlyBracketKeyword_1_5();
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess_5 = f.getRoleBehaviorAccess();
    Keyword _rightCurlyBracketKeyword_1_7_1 = _roleBehaviorAccess_5.getRightCurlyBracketKeyword_1_7();
    c.setIndentation(_leftCurlyBracketKeyword_1_5_1, _rightCurlyBracketKeyword_1_7_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_2 = c.setIndentationDecrement();
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess_6 = f.getRoleBehaviorAccess();
    Keyword _rightCurlyBracketKeyword_1_7_2 = _roleBehaviorAccess_6.getRightCurlyBracketKeyword_1_7();
    _setIndentationDecrement_2.before(_rightCurlyBracketKeyword_1_7_2);
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess = f.getIfThenElseAccess();
    Keyword _leftCurlyBracketKeyword_4 = _ifThenElseAccess.getLeftCurlyBracketKeyword_4();
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_1 = f.getIfThenElseAccess();
    Keyword _rightCurlyBracketKeyword_6 = _ifThenElseAccess_1.getRightCurlyBracketKeyword_6();
    c.setIndentation(_leftCurlyBracketKeyword_4, _rightCurlyBracketKeyword_6);
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_2 = f.getIfThenElseAccess();
    Keyword _leftCurlyBracketKeyword_8 = _ifThenElseAccess_2.getLeftCurlyBracketKeyword_8();
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_3 = f.getIfThenElseAccess();
    Keyword _rightCurlyBracketKeyword_10 = _ifThenElseAccess_3.getRightCurlyBracketKeyword_10();
    c.setIndentation(_leftCurlyBracketKeyword_8, _rightCurlyBracketKeyword_10);
    FormattingConfig.LinewrapLocator _setLinewrap_13 = c.setLinewrap(1);
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_4 = f.getIfThenElseAccess();
    Keyword _leftCurlyBracketKeyword_4_1 = _ifThenElseAccess_4.getLeftCurlyBracketKeyword_4();
    _setLinewrap_13.after(_leftCurlyBracketKeyword_4_1);
    FormattingConfig.LinewrapLocator _setLinewrap_14 = c.setLinewrap(1);
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_5 = f.getIfThenElseAccess();
    Keyword _leftCurlyBracketKeyword_8_1 = _ifThenElseAccess_5.getLeftCurlyBracketKeyword_8();
    _setLinewrap_14.after(_leftCurlyBracketKeyword_8_1);
    FormattingConfig.LinewrapLocator _setLinewrap_15 = c.setLinewrap(1);
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_6 = f.getIfThenElseAccess();
    Keyword _rightCurlyBracketKeyword_6_1 = _ifThenElseAccess_6.getRightCurlyBracketKeyword_6();
    _setLinewrap_15.before(_rightCurlyBracketKeyword_6_1);
    FormattingConfig.LinewrapLocator _setLinewrap_16 = c.setLinewrap(1);
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_7 = f.getIfThenElseAccess();
    Keyword _rightCurlyBracketKeyword_10_1 = _ifThenElseAccess_7.getRightCurlyBracketKeyword_10();
    _setLinewrap_16.before(_rightCurlyBracketKeyword_10_1);
    FormattingConfig.LinewrapLocator _setLinewrap_17 = c.setLinewrap(1);
    HelenaTextGrammarAccess.IfThenElseElements _ifThenElseAccess_8 = f.getIfThenElseAccess();
    Keyword _elseKeyword_7 = _ifThenElseAccess_8.getElseKeyword_7();
    _setLinewrap_17.before(_elseKeyword_7);
    HelenaTextGrammarAccess.NondeterministicChoiceElements _nondeterministicChoiceAccess = f.getNondeterministicChoiceAccess();
    Keyword _leftParenthesisKeyword_0 = _nondeterministicChoiceAccess.getLeftParenthesisKeyword_0();
    HelenaTextGrammarAccess.NondeterministicChoiceElements _nondeterministicChoiceAccess_1 = f.getNondeterministicChoiceAccess();
    Keyword _rightParenthesisKeyword_4 = _nondeterministicChoiceAccess_1.getRightParenthesisKeyword_4();
    c.setIndentation(_leftParenthesisKeyword_0, _rightParenthesisKeyword_4);
    FormattingConfig.LinewrapLocator _setLinewrap_18 = c.setLinewrap(1);
    HelenaTextGrammarAccess.NondeterministicChoiceElements _nondeterministicChoiceAccess_2 = f.getNondeterministicChoiceAccess();
    Keyword _plusSignKeyword_2 = _nondeterministicChoiceAccess_2.getPlusSignKeyword_2();
    _setLinewrap_18.before(_plusSignKeyword_2);
    FormattingConfig.LinewrapLocator _setLinewrap_19 = c.setLinewrap(1);
    HelenaTextGrammarAccess.NondeterministicChoiceElements _nondeterministicChoiceAccess_3 = f.getNondeterministicChoiceAccess();
    Keyword _plusSignKeyword_2_1 = _nondeterministicChoiceAccess_3.getPlusSignKeyword_2();
    _setLinewrap_19.after(_plusSignKeyword_2_1);
    FormattingConfig.LinewrapLocator _setLinewrap_20 = c.setLinewrap(1);
    HelenaTextGrammarAccess.NondeterministicChoiceElements _nondeterministicChoiceAccess_4 = f.getNondeterministicChoiceAccess();
    Keyword _leftParenthesisKeyword_0_1 = _nondeterministicChoiceAccess_4.getLeftParenthesisKeyword_0();
    _setLinewrap_20.before(_leftParenthesisKeyword_0_1);
    FormattingConfig.LinewrapLocator _setLinewrap_21 = c.setLinewrap(1);
    HelenaTextGrammarAccess.NondeterministicChoiceElements _nondeterministicChoiceAccess_5 = f.getNondeterministicChoiceAccess();
    Keyword _rightParenthesisKeyword_4_1 = _nondeterministicChoiceAccess_5.getRightParenthesisKeyword_4();
    _setLinewrap_21.after(_rightParenthesisKeyword_4_1);
    FormattingConfig.LinewrapLocator _setLinewrap_22 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ProcessExpressionElements _processExpressionAccess = f.getProcessExpressionAccess();
    Action _quitTermAction_0_0 = _processExpressionAccess.getQuitTermAction_0_0();
    _setLinewrap_22.before(_quitTermAction_0_0);
    FormattingConfig.LinewrapLocator _setLinewrap_23 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ProcessExpressionElements _processExpressionAccess_1 = f.getProcessExpressionAccess();
    RuleCall _actionPrefixParserRuleCall_1 = _processExpressionAccess_1.getActionPrefixParserRuleCall_1();
    _setLinewrap_23.before(_actionPrefixParserRuleCall_1);
    FormattingConfig.LinewrapLocator _setLinewrap_24 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ProcessExpressionElements _processExpressionAccess_2 = f.getProcessExpressionAccess();
    RuleCall _nondeterministicChoiceParserRuleCall_2 = _processExpressionAccess_2.getNondeterministicChoiceParserRuleCall_2();
    _setLinewrap_24.before(_nondeterministicChoiceParserRuleCall_2);
    FormattingConfig.LinewrapLocator _setLinewrap_25 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ProcessExpressionElements _processExpressionAccess_3 = f.getProcessExpressionAccess();
    RuleCall _ifThenElseParserRuleCall_3 = _processExpressionAccess_3.getIfThenElseParserRuleCall_3();
    _setLinewrap_25.before(_ifThenElseParserRuleCall_3);
    FormattingConfig.LinewrapLocator _setLinewrap_26 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ProcessExpressionElements _processExpressionAccess_4 = f.getProcessExpressionAccess();
    RuleCall _processInvocationParserRuleCall_4 = _processExpressionAccess_4.getProcessInvocationParserRuleCall_4();
    _setLinewrap_26.before(_processInvocationParserRuleCall_4);
    FormattingConfig.LinewrapLocator _setLinewrap_27 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ProcessElements _processAccess = f.getProcessAccess();
    Keyword _processKeyword_0 = _processAccess.getProcessKeyword_0();
    _setLinewrap_27.before(_processKeyword_0);
    FormattingConfig.LinewrapLocator _setLinewrap_28 = c.setLinewrap(1);
    HelenaTextGrammarAccess.ProcessElements _processAccess_1 = f.getProcessAccess();
    Keyword _equalsSignKeyword_2 = _processAccess_1.getEqualsSignKeyword_2();
    _setLinewrap_28.after(_equalsSignKeyword_2);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_2 = c.setIndentationIncrement();
    HelenaTextGrammarAccess.ProcessElements _processAccess_2 = f.getProcessAccess();
    Keyword _processKeyword_0_1 = _processAccess_2.getProcessKeyword_0();
    _setIndentationIncrement_2.after(_processKeyword_0_1);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement_3 = c.setIndentationDecrement();
    HelenaTextGrammarAccess.ProcessElements _processAccess_3 = f.getProcessAccess();
    Keyword _processKeyword_0_2 = _processAccess_3.getProcessKeyword_0();
    _setIndentationDecrement_3.before(_processKeyword_0_2);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement_3 = c.setIndentationIncrement();
    HelenaTextGrammarAccess.RoleBehaviorElements _roleBehaviorAccess_7 = f.getRoleBehaviorAccess();
    Keyword _leftCurlyBracketKeyword_1_5_2 = _roleBehaviorAccess_7.getLeftCurlyBracketKeyword_1_5();
    _setIndentationIncrement_3.after(_leftCurlyBracketKeyword_1_5_2);
    FormattingConfig _config = this.getConfig();
    FormattingConfig.LinewrapLocator _setLinewrap_29 = _config.setLinewrap(0, 1, 2);
    TerminalRule _sL_COMMENTRule = f.getSL_COMMENTRule();
    _setLinewrap_29.before(_sL_COMMENTRule);
    FormattingConfig _config_1 = this.getConfig();
    FormattingConfig.LinewrapLocator _setLinewrap_30 = _config_1.setLinewrap(0, 1, 2);
    TerminalRule _mL_COMMENTRule = f.getML_COMMENTRule();
    _setLinewrap_30.before(_mL_COMMENTRule);
    FormattingConfig _config_2 = this.getConfig();
    FormattingConfig.LinewrapLocator _setLinewrap_31 = _config_2.setLinewrap(0, 1, 1);
    TerminalRule _mL_COMMENTRule_1 = f.getML_COMMENTRule();
    _setLinewrap_31.after(_mL_COMMENTRule_1);
  }
  
  /**
   * Sets no space before first, after first and before second PairKeyword in the FormattingConfig
   */
  private void setNoSpaceAroundPair(final String first, final String second, final FormattingConfig c, final HelenaTextGrammarAccess f) {
    List<Pair<Keyword, Keyword>> _findKeywordPairs = f.findKeywordPairs(first, second);
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
        Keyword _first = pair.getFirst();
        _setNoSpace.before(_first);
        FormattingConfig.NoSpaceLocator _setNoSpace_1 = c.setNoSpace();
        Keyword _first_1 = pair.getFirst();
        _setNoSpace_1.after(_first_1);
        FormattingConfig.NoSpaceLocator _setNoSpace_2 = c.setNoSpace();
        Keyword _second = pair.getSecond();
        _setNoSpace_2.before(_second);
      }
    }
  }
  
  private void setNoSpacesInsidePair(final String first, final String second, final FormattingConfig c, final HelenaTextGrammarAccess f) {
    List<Pair<Keyword, Keyword>> _findKeywordPairs = f.findKeywordPairs(first, second);
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
        Keyword _first = pair.getFirst();
        _setNoSpace.after(_first);
        FormattingConfig.NoSpaceLocator _setNoSpace_1 = c.setNoSpace();
        Keyword _second = pair.getSecond();
        _setNoSpace_1.before(_second);
      }
    }
  }
  
  private void setNoSpaceBefore(final String keyword, final FormattingConfig c, final HelenaTextGrammarAccess f) {
    List<Keyword> _findKeywords = f.findKeywords(keyword);
    for (final Keyword k : _findKeywords) {
      FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
      _setNoSpace.before(k);
    }
  }
  
  private void setNoSpaceAfter(final String keyword, final FormattingConfig c, final HelenaTextGrammarAccess f) {
    List<Keyword> _findKeywords = f.findKeywords(keyword);
    for (final Keyword k : _findKeywords) {
      FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
      _setNoSpace.after(k);
    }
  }
  
  private void setSpacesAround(final String keyword, final FormattingConfig c, final HelenaTextGrammarAccess f) {
    List<Keyword> _findKeywords = f.findKeywords(keyword);
    for (final Keyword k : _findKeywords) {
      {
        EObject current = k.eContainer();
        while (((!Objects.equal(current, null)) || (!(current instanceof eu.ascens.helenaText.Process)))) {
          return;
        }
        FormattingConfig.SpaceLocator _setSpace = c.setSpace(" ");
        _setSpace.before(k);
        FormattingConfig.SpaceLocator _setSpace_1 = c.setSpace(" ");
        _setSpace_1.after(k);
      }
    }
  }
}
