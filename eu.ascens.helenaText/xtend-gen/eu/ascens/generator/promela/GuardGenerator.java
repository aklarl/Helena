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
package eu.ascens.generator.promela;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import eu.ascens.generator.promela.NameGenerator;
import eu.ascens.generator.promela.OperationCallGenerator;
import eu.ascens.helenaText.AndTerm;
import eu.ascens.helenaText.Atom;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.EqualityTerm;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.GuardInParentheses;
import eu.ascens.helenaText.NotTerm;
import eu.ascens.helenaText.OrTerm;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.Relation;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class GuardGenerator {
  @Inject
  private NameGenerator nameGenerator;
  
  /**
   * Compiles a guard composed of or terms
   */
  protected CharSequence _compileRelation(final OrTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    Guard _left = term.getLeft();
    CharSequence _compileRelation = this.compileRelation(_left);
    _builder.append(_compileRelation, "");
    _builder.append(" || ");
    Guard _right = term.getRight();
    CharSequence _compileRelation_1 = this.compileRelation(_right);
    _builder.append(_compileRelation_1, "");
    return _builder;
  }
  
  /**
   * Compiles a guard composed of and terms
   */
  protected CharSequence _compileRelation(final AndTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    Guard _left = term.getLeft();
    CharSequence _compileRelation = this.compileRelation(_left);
    _builder.append(_compileRelation, "");
    _builder.append(" && ");
    Guard _right = term.getRight();
    CharSequence _compileRelation_1 = this.compileRelation(_right);
    _builder.append(_compileRelation_1, "");
    return _builder;
  }
  
  /**
   * Compiles a guard composed of a equality term
   */
  protected CharSequence _compileRelation(final EqualityTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    Guard _left = term.getLeft();
    CharSequence _compileRelation = this.compileRelation(_left);
    _builder.append(_compileRelation, "");
    _builder.append(" ");
    String _operator = term.getOperator();
    _builder.append(_operator, "");
    _builder.append(" ");
    Guard _right = term.getRight();
    CharSequence _compileRelation_1 = this.compileRelation(_right);
    _builder.append(_compileRelation_1, "");
    return _builder;
  }
  
  /**
   * Compiles a guard composed of a not term
   */
  protected CharSequence _compileRelation(final NotTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _not = term.getNot();
      boolean _notEquals = (!Objects.equal(_not, null));
      if (_notEquals) {
        _builder.append("!");
      }
    }
    Atom _atom = term.getAtom();
    CharSequence _compileAtom = this.compileAtom(_atom);
    _builder.append(_compileAtom, "");
    return _builder;
  }
  
  /**
   * Compiles single atoms in guard
   * - expressions (formal data params, role attributes, component attributes, data values)
   * - plays queries
   * - relations
   * - guard in parentheses
   */
  private CharSequence _compileAtom(final DataExpression term) {
    StringConcatenation _builder = new StringConcatenation();
    String _dataValue = this.nameGenerator.getDataValue(term);
    _builder.append(_dataValue, "");
    return _builder;
  }
  
  private CharSequence _compileAtom(final PlaysQuery term) {
    StringConcatenation _builder = new StringConcatenation();
    String _variableName = NameGenerator.getVariableName(term);
    _builder.append(_variableName, "");
    return _builder;
  }
  
  private CharSequence _compileAtom(final Relation term) {
    StringConcatenation _builder = new StringConcatenation();
    DataExpression _left = term.getLeft();
    String _dataValue = this.nameGenerator.getDataValue(_left);
    _builder.append(_dataValue, "");
    _builder.append(" ");
    String _operator = term.getOperator();
    _builder.append(_operator, "");
    _builder.append(" ");
    DataExpression _right = term.getRight();
    String _dataValue_1 = this.nameGenerator.getDataValue(_right);
    _builder.append(_dataValue_1, "");
    return _builder;
  }
  
  private CharSequence _compileAtom(final GuardInParentheses term) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Guard _guard = term.getGuard();
    CharSequence _compileRelation = this.compileRelation(_guard);
    _builder.append(_compileRelation, "");
    _builder.append(")");
    return _builder;
  }
  
  public static CharSequence compileOperationCallForComponentAttributeQuery(final PlaysQuery query, final ComponentType owner) {
    StringConcatenation _builder = new StringConcatenation();
    ComponentInstance _compInstance = query.getCompInstance();
    ComponentType _componentType = ExtensionMethods_Param.getComponentType(_compInstance);
    CharSequence _compileOperationCall = OperationCallGenerator.compileOperationCall(_componentType, query);
    _builder.append(_compileOperationCall, "");
    return _builder;
  }
  
  public CharSequence compileRelation(final Guard term) {
    if (term instanceof AndTerm) {
      return _compileRelation((AndTerm)term);
    } else if (term instanceof EqualityTerm) {
      return _compileRelation((EqualityTerm)term);
    } else if (term instanceof NotTerm) {
      return _compileRelation((NotTerm)term);
    } else if (term instanceof OrTerm) {
      return _compileRelation((OrTerm)term);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term).toString());
    }
  }
  
  private CharSequence compileAtom(final Atom term) {
    if (term instanceof DataExpression) {
      return _compileAtom((DataExpression)term);
    } else if (term instanceof GuardInParentheses) {
      return _compileAtom((GuardInParentheses)term);
    } else if (term instanceof PlaysQuery) {
      return _compileAtom((PlaysQuery)term);
    } else if (term instanceof Relation) {
      return _compileAtom((Relation)term);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term).toString());
    }
  }
}
