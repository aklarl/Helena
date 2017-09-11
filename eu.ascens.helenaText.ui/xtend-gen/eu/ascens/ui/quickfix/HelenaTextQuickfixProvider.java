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
package eu.ascens.ui.quickfix;

import eu.ascens.validation.HelenaTextValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.ui.quickfix.XbaseQuickfixProvider;

/**
 * Custom quickfixes.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
@SuppressWarnings("all")
public class HelenaTextQuickfixProvider extends XbaseQuickfixProvider {
  @Fix(HelenaTextValidator.HAS_TO_START_UPPERCASE)
  public void capitalizeName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        Integer _offset = issue.getOffset();
        final String firstLetter = xtextDocument.get((_offset).intValue(), 1);
        Integer _offset_1 = issue.getOffset();
        String _upperCase = firstLetter.toUpperCase();
        xtextDocument.replace((_offset_1).intValue(), 1, _upperCase);
      }
    };
    acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", _function);
  }
  
  @Fix(HelenaTextValidator.HAS_TO_START_LOWERCASE)
  public void decapitalizeName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext context) throws Exception {
        final IXtextDocument xtextDocument = context.getXtextDocument();
        Integer _offset = issue.getOffset();
        final String firstLetter = xtextDocument.get((_offset).intValue(), 1);
        Integer _offset_1 = issue.getOffset();
        String _lowerCase = firstLetter.toLowerCase();
        xtextDocument.replace((_offset_1).intValue(), 1, _lowerCase);
      }
    };
    acceptor.accept(issue, "Decapitalize name", "Decapitalize the name.", "upcase.png", _function);
  }
}
