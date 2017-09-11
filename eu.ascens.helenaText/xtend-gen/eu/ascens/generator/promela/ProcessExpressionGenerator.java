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

import com.google.inject.Inject;
import eu.ascens.generator.promela.ActionGenerator;
import eu.ascens.generator.promela.GuardGenerator;
import eu.ascens.generator.promela.NameGenerator;
import eu.ascens.generator.promela.OperationCallGenerator;
import eu.ascens.helenaText.Action;
import eu.ascens.helenaText.ActionPrefix;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.NondeterministicChoice;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.ProcessExpression;
import eu.ascens.helenaText.ProcessInvocation;
import eu.ascens.helenaText.QuitTerm;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_Logic;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ProcessExpressionGenerator {
  @Inject
  private GuardGenerator guardGenerator;
  
  @Inject
  private ActionGenerator actionGenerator;
  
  /**
   * Compiles a process term:
   * - action prefix is realized with sequential composition
   * - conditional selection is realized with if-selection
   * - process invocation is realized with labels and gotos since we cannot use inline method with interlaced recursive processes
   */
  protected CharSequence _compileProcExpr(final QuitTerm term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    CharSequence _xblockexpression = null;
    {
      RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(term);
      RoleType rt = _parentRoleBehavior.getRoleTypeRef();
      RoleBehavior _parentRoleBehavior_1 = ExtensionMethods_RoleBehavior.getParentRoleBehavior(term);
      RoleType _roleTypeRef = _parentRoleBehavior_1.getRoleTypeRef();
      ComponentType owner = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// quit");
      _builder.newLine();
      String _quitRole = NameGenerator.getQuitRole(owner);
      _builder.append(_quitRole, "");
      _builder.append("(");
      String _compOperationNameForQuit = NameGenerator.getCompOperationNameForQuit(rt);
      _builder.append(_compOperationNameForQuit, "");
      _builder.append(",owner);");
      _builder.newLineIfNotEmpty();
      _builder.append("goto ");
      String _endLabelName = NameGenerator.getEndLabelName(rt);
      _builder.append(_endLabelName, "");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _compileProcExpr(final ActionPrefix term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    Action _action = term.getAction();
    CharSequence _compileAction = this.actionGenerator.compileAction(_action);
    _builder.append(_compileAction, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    ProcessExpression _processExpr = term.getProcessExpr();
    CharSequence _compileProcExpr = this.compileProcExpr(_processExpr, alreadyTraversedProcesses);
    _builder.append(_compileProcExpr, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _compileProcExpr(final NondeterministicChoice term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("// nondeterministic choice");
    _builder.newLine();
    _builder.append("if");
    _builder.newLine();
    _builder.append(":: // first branch");
    _builder.newLine();
    _builder.append("\t");
    ProcessExpression _first = term.getFirst();
    CharSequence _compileProcExpr = this.compileProcExpr(_first, alreadyTraversedProcesses);
    _builder.append(_compileProcExpr, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(":: // second branch");
    _builder.newLine();
    _builder.append("\t");
    ProcessExpression _second = term.getSecond();
    CharSequence _compileProcExpr_1 = this.compileProcExpr(_second, alreadyTraversedProcesses);
    _builder.append(_compileProcExpr_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("fi");
    return _builder;
  }
  
  protected CharSequence _compileProcExpr(final IfThenElse term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    CharSequence _xblockexpression = null;
    {
      RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(term);
      RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
      ComponentType owner = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
      Guard _guard = term.getGuard();
      Collection<PlaysQuery> playsQueries = ExtensionMethods_Logic.getPlaysQueries(_guard);
      Guard _guard_1 = term.getGuard();
      Collection<ComponentAttributeType> compAttributes = ExtensionMethods_Logic.getComponentAttributes(_guard_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// if-then-else");
      _builder.newLine();
      _builder.append("atomic {\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// retrieve values for guards in guarded choice");
      _builder.newLine();
      {
        for(final PlaysQuery query : playsQueries) {
          _builder.append("\t");
          ComponentInstance _compInstance = query.getCompInstance();
          CharSequence _retrieveCompInstanceFromOwner = OperationCallGenerator.retrieveCompInstanceFromOwner(_compInstance);
          _builder.append(_retrieveCompInstanceFromOwner, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          ComponentInstance _compInstance_1 = query.getCompInstance();
          ComponentType _componentType = ExtensionMethods_Param.getComponentType(_compInstance_1);
          CharSequence _compileOperationCall = OperationCallGenerator.compileOperationCall(_componentType, query);
          _builder.append(_compileOperationCall, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        for(final ComponentAttributeType attr : compAttributes) {
          _builder.append("\t");
          CharSequence _compileGetterOperationCall = OperationCallGenerator.compileGetterOperationCall(owner, attr);
          _builder.append(_compileGetterOperationCall, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("::(");
      Guard _guard_2 = term.getGuard();
      CharSequence _compileRelation = this.guardGenerator.compileRelation(_guard_2);
      _builder.append(_compileRelation, "\t");
      _builder.append(") ->");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
      CharSequence _compileFirstActionForIf = this.compileFirstActionForIf(_ifProcessExpr, alreadyTraversedProcesses);
      _builder.append(_compileFirstActionForIf, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(":: else ->");
      _builder.newLine();
      _builder.append("\t\t");
      ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
      CharSequence _compileFirstActionForIf_1 = this.compileFirstActionForIf(_elseProcessExpr, alreadyTraversedProcesses);
      _builder.append(_compileFirstActionForIf_1, "\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("fi");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      ProcessExpression _ifProcessExpr_1 = term.getIfProcessExpr();
      CharSequence _compileRemainingProcExprForIf = this.compileRemainingProcExprForIf(_ifProcessExpr_1, alreadyTraversedProcesses);
      _builder.append(_compileRemainingProcExprForIf, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      ProcessExpression _elseProcessExpr_1 = term.getElseProcessExpr();
      CharSequence _compileRemainingProcExprForIf_1 = this.compileRemainingProcExprForIf(_elseProcessExpr_1, alreadyTraversedProcesses);
      _builder.append(_compileRemainingProcExprForIf_1, "");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _compileProcExpr(final ProcessInvocation term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    eu.ascens.helenaText.Process _process = term.getProcess();
    boolean _contains = alreadyTraversedProcesses.contains(_process);
    if (_contains) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// process invocation by goto label");
      _builder.newLine();
      _builder.append("goto ");
      eu.ascens.helenaText.Process _process_1 = term.getProcess();
      String _label = NameGenerator.getLabel(_process_1);
      _builder.append(_label, "");
      return _builder;
    } else {
      eu.ascens.helenaText.Process _process_2 = term.getProcess();
      alreadyTraversedProcesses.add(_process_2);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.newLine();
      _builder_1.append("// declare local process by label");
      _builder_1.newLine();
      eu.ascens.helenaText.Process _process_3 = term.getProcess();
      String _label_1 = NameGenerator.getLabel(_process_3);
      _builder_1.append(_label_1, "");
      _builder_1.append(": true;");
      _builder_1.newLineIfNotEmpty();
      eu.ascens.helenaText.Process _process_4 = term.getProcess();
      ProcessExpression _processExpr = _process_4.getProcessExpr();
      CharSequence _compileProcExpr = this.compileProcExpr(_processExpr, alreadyTraversedProcesses);
      _builder_1.append(_compileProcExpr, "");
      return _builder_1;
    }
  }
  
  /**
   * compiles the first action of a process term (recursively!) and a jump to the remaining process term
   */
  private CharSequence _compileFirstActionForIf(final QuitTerm term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    return this.compileProcExpr(term, alreadyTraversedProcesses);
  }
  
  private CharSequence _compileFirstActionForIf(final ActionPrefix term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    Action _action = term.getAction();
    CharSequence _compileAction = this.actionGenerator.compileAction(_action);
    _builder.append(_compileAction, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("goto ");
    String _ifGotoLabel = NameGenerator.getIfGotoLabel(term);
    _builder.append(_ifGotoLabel, "");
    return _builder;
  }
  
  private CharSequence _compileFirstActionForIf(final NondeterministicChoice term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("// nondeterministic choice");
    _builder.newLine();
    _builder.append("if");
    _builder.newLine();
    _builder.append(":: // first branch");
    _builder.newLine();
    _builder.append("\t");
    ProcessExpression _first = term.getFirst();
    CharSequence _compileFirstActionForIf = this.compileFirstActionForIf(_first, alreadyTraversedProcesses);
    _builder.append(_compileFirstActionForIf, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(":: // second branch");
    _builder.newLine();
    _builder.append("\t");
    ProcessExpression _second = term.getSecond();
    CharSequence _compileFirstActionForIf_1 = this.compileFirstActionForIf(_second, alreadyTraversedProcesses);
    _builder.append(_compileFirstActionForIf_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("fi");
    return _builder;
  }
  
  private CharSequence _compileFirstActionForIf(final IfThenElse term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    CharSequence _xblockexpression = null;
    {
      RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(term);
      RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
      ComponentType owner = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
      Guard _guard = term.getGuard();
      Collection<PlaysQuery> playsQueries = ExtensionMethods_Logic.getPlaysQueries(_guard);
      Guard _guard_1 = term.getGuard();
      Collection<ComponentAttributeType> compAttributes = ExtensionMethods_Logic.getComponentAttributes(_guard_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// if-then-else");
      _builder.newLine();
      _builder.append("// retrieve values for guards in if-then-else");
      _builder.newLine();
      {
        for(final PlaysQuery query : playsQueries) {
          ComponentInstance _compInstance = query.getCompInstance();
          CharSequence _retrieveCompInstanceFromOwner = OperationCallGenerator.retrieveCompInstanceFromOwner(_compInstance);
          _builder.append(_retrieveCompInstanceFromOwner, "");
          _builder.newLineIfNotEmpty();
          ComponentInstance _compInstance_1 = query.getCompInstance();
          ComponentType _componentType = ExtensionMethods_Param.getComponentType(_compInstance_1);
          CharSequence _compileOperationCall = OperationCallGenerator.compileOperationCall(_componentType, query);
          _builder.append(_compileOperationCall, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        for(final ComponentAttributeType attr : compAttributes) {
          CharSequence _compileGetterOperationCall = OperationCallGenerator.compileGetterOperationCall(owner, attr);
          _builder.append(_compileGetterOperationCall, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("if");
      _builder.newLine();
      _builder.append("::(");
      Guard _guard_2 = term.getGuard();
      CharSequence _compileRelation = this.guardGenerator.compileRelation(_guard_2);
      _builder.append(_compileRelation, "");
      _builder.append(") ->");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
      CharSequence _compileFirstActionForIf = this.compileFirstActionForIf(_ifProcessExpr, alreadyTraversedProcesses);
      _builder.append(_compileFirstActionForIf, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append(":: else ->");
      _builder.newLine();
      _builder.append("\t");
      ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
      CharSequence _compileFirstActionForIf_1 = this.compileFirstActionForIf(_elseProcessExpr, alreadyTraversedProcesses);
      _builder.append(_compileFirstActionForIf_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("fi");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * compiles the remaining process term after an if-then-else
   */
  private CharSequence _compileRemainingProcExprForIf(final QuitTerm term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  private CharSequence _compileRemainingProcExprForIf(final ActionPrefix term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    String _ifGotoLabel = NameGenerator.getIfGotoLabel(term);
    _builder.append(_ifGotoLabel, "");
    _builder.append(": true;");
    _builder.newLineIfNotEmpty();
    ProcessExpression _processExpr = term.getProcessExpr();
    CharSequence _compileProcExpr = this.compileProcExpr(_processExpr, alreadyTraversedProcesses);
    _builder.append(_compileProcExpr, "");
    return _builder;
  }
  
  private CharSequence _compileRemainingProcExprForIf(final NondeterministicChoice term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    ProcessExpression _first = term.getFirst();
    CharSequence _compileRemainingProcExprForIf = this.compileRemainingProcExprForIf(_first, alreadyTraversedProcesses);
    _builder.append(_compileRemainingProcExprForIf, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    ProcessExpression _second = term.getSecond();
    CharSequence _compileRemainingProcExprForIf_1 = this.compileRemainingProcExprForIf(_second, alreadyTraversedProcesses);
    _builder.append(_compileRemainingProcExprForIf_1, "");
    return _builder;
  }
  
  private CharSequence _compileRemainingProcExprForIf(final IfThenElse term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    StringConcatenation _builder = new StringConcatenation();
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    CharSequence _compileRemainingProcExprForIf = this.compileRemainingProcExprForIf(_ifProcessExpr, alreadyTraversedProcesses);
    _builder.append(_compileRemainingProcExprForIf, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    CharSequence _compileRemainingProcExprForIf_1 = this.compileRemainingProcExprForIf(_elseProcessExpr, alreadyTraversedProcesses);
    _builder.append(_compileRemainingProcExprForIf_1, "");
    return _builder;
  }
  
  public CharSequence compileProcExpr(final ProcessExpression term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    if (term instanceof ActionPrefix) {
      return _compileProcExpr((ActionPrefix)term, alreadyTraversedProcesses);
    } else if (term instanceof IfThenElse) {
      return _compileProcExpr((IfThenElse)term, alreadyTraversedProcesses);
    } else if (term instanceof NondeterministicChoice) {
      return _compileProcExpr((NondeterministicChoice)term, alreadyTraversedProcesses);
    } else if (term instanceof ProcessInvocation) {
      return _compileProcExpr((ProcessInvocation)term, alreadyTraversedProcesses);
    } else if (term instanceof QuitTerm) {
      return _compileProcExpr((QuitTerm)term, alreadyTraversedProcesses);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term, alreadyTraversedProcesses).toString());
    }
  }
  
  private CharSequence compileFirstActionForIf(final ProcessExpression term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    if (term instanceof ActionPrefix) {
      return _compileFirstActionForIf((ActionPrefix)term, alreadyTraversedProcesses);
    } else if (term instanceof IfThenElse) {
      return _compileFirstActionForIf((IfThenElse)term, alreadyTraversedProcesses);
    } else if (term instanceof NondeterministicChoice) {
      return _compileFirstActionForIf((NondeterministicChoice)term, alreadyTraversedProcesses);
    } else if (term instanceof QuitTerm) {
      return _compileFirstActionForIf((QuitTerm)term, alreadyTraversedProcesses);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term, alreadyTraversedProcesses).toString());
    }
  }
  
  private CharSequence compileRemainingProcExprForIf(final ProcessExpression term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    if (term instanceof ActionPrefix) {
      return _compileRemainingProcExprForIf((ActionPrefix)term, alreadyTraversedProcesses);
    } else if (term instanceof IfThenElse) {
      return _compileRemainingProcExprForIf((IfThenElse)term, alreadyTraversedProcesses);
    } else if (term instanceof NondeterministicChoice) {
      return _compileRemainingProcExprForIf((NondeterministicChoice)term, alreadyTraversedProcesses);
    } else if (term instanceof QuitTerm) {
      return _compileRemainingProcExprForIf((QuitTerm)term, alreadyTraversedProcesses);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term, alreadyTraversedProcesses).toString());
    }
  }
}
