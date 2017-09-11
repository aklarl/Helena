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
package eu.ascens.helenaText.util;

import com.google.common.base.Objects;
import eu.ascens.helenaText.AbstractInstance;
import eu.ascens.helenaText.AbstractMessageCall;
import eu.ascens.helenaText.AbstractRoleBehaviorEntity;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.Action;
import eu.ascens.helenaText.ActionPrefix;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.DeclaringRoleBehavior;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.InvokingRoleBehavior;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.NondeterministicChoice;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.ProcessExpression;
import eu.ascens.helenaText.ProcessInvocation;
import eu.ascens.helenaText.QuitTerm;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_Action;
import eu.ascens.helenaText.util.ExtensionMethods_Logic;
import eu.ascens.helenaText.util.Helper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class ExtensionMethods_RoleBehavior {
  /**
   * Returns the role behavior where the entity is used
   */
  public static RoleBehavior getParentRoleBehavior(final AbstractRoleBehaviorEntity entity) {
    EObject current = entity.eContainer();
    while ((!(current instanceof RoleBehavior))) {
      EObject _eContainer = current.eContainer();
      current = _eContainer;
    }
    return ((RoleBehavior) current);
  }
  
  /**
   * Returns all processes declared in a role behavior
   */
  protected static Collection<eu.ascens.helenaText.Process> _getProcesses(final DeclaringRoleBehavior rb) {
    return new ArrayList<eu.ascens.helenaText.Process>();
  }
  
  protected static Collection<eu.ascens.helenaText.Process> _getProcesses(final InvokingRoleBehavior rb) {
    return rb.getProcesses();
  }
  
  public static Collection<ProcessInvocation> getProcessInvocations(final RoleBehavior rb) {
    TreeIterator<EObject> _eAllContents = rb.eAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      @Override
      public Boolean apply(final EObject elem) {
        return Boolean.valueOf((elem instanceof ProcessInvocation));
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_iterable, _function);
    final Function1<EObject, ProcessInvocation> _function_1 = new Function1<EObject, ProcessInvocation>() {
      @Override
      public ProcessInvocation apply(final EObject elem) {
        return ((ProcessInvocation) elem);
      }
    };
    Iterable<ProcessInvocation> invocs = IterableExtensions.<EObject, ProcessInvocation>map(_filter, _function_1);
    return IterableExtensions.<ProcessInvocation>toList(invocs);
  }
  
  public static Collection<AbstractMessageCall> getAbstractMessageCalls(final RoleBehavior rb) {
    TreeIterator<EObject> _eAllContents = rb.eAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      @Override
      public Boolean apply(final EObject elem) {
        return Boolean.valueOf((elem instanceof AbstractMessageCall));
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_iterable, _function);
    final Function1<EObject, AbstractMessageCall> _function_1 = new Function1<EObject, AbstractMessageCall>() {
      @Override
      public AbstractMessageCall apply(final EObject elem) {
        return ((AbstractMessageCall) elem);
      }
    };
    Iterable<AbstractMessageCall> abstrMsgCalls = IterableExtensions.<EObject, AbstractMessageCall>map(_filter, _function_1);
    return IterableExtensions.<AbstractMessageCall>toList(abstrMsgCalls);
  }
  
  public static Collection<OperationCall> getOperationCalls(final RoleBehavior rb) {
    TreeIterator<EObject> _eAllContents = rb.eAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      @Override
      public Boolean apply(final EObject elem) {
        return Boolean.valueOf((elem instanceof OperationCall));
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_iterable, _function);
    final Function1<EObject, OperationCall> _function_1 = new Function1<EObject, OperationCall>() {
      @Override
      public OperationCall apply(final EObject elem) {
        return ((OperationCall) elem);
      }
    };
    Iterable<OperationCall> opCalls = IterableExtensions.<EObject, OperationCall>map(_filter, _function_1);
    return IterableExtensions.<OperationCall>toList(opCalls);
  }
  
  public static Collection<Action> getFirstActions(final ProcessExpression term) {
    HashSet<eu.ascens.helenaText.Process> _hashSet = new HashSet<eu.ascens.helenaText.Process>();
    return ExtensionMethods_RoleBehavior.getFirstActions_(term, _hashSet);
  }
  
  /**
   * Returns the first action(s) of a process term
   * (there might be several if it is if-then-else or nondeterministic choice)
   */
  protected static Collection<Action> _getFirstActions_(final QuitTerm term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    return new ArrayList<Action>();
  }
  
  protected static Collection<Action> _getFirstActions_(final ActionPrefix term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    Action _action = term.getAction();
    return Helper.<Action>asList(_action);
  }
  
  protected static Collection<Action> _getFirstActions_(final IfThenElse term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    ArrayList<Action> actions = new ArrayList<Action>();
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    boolean _notEquals = (!Objects.equal(_ifProcessExpr, null));
    if (_notEquals) {
      ProcessExpression _ifProcessExpr_1 = term.getIfProcessExpr();
      Collection<Action> _firstActions_ = ExtensionMethods_RoleBehavior.getFirstActions_(_ifProcessExpr_1, alreadyTraversedProcesses);
      actions.addAll(_firstActions_);
    }
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    boolean _notEquals_1 = (!Objects.equal(_elseProcessExpr, null));
    if (_notEquals_1) {
      ProcessExpression _elseProcessExpr_1 = term.getElseProcessExpr();
      Collection<Action> _firstActions__1 = ExtensionMethods_RoleBehavior.getFirstActions_(_elseProcessExpr_1, alreadyTraversedProcesses);
      actions.addAll(_firstActions__1);
    }
    return actions;
  }
  
  protected static Collection<Action> _getFirstActions_(final NondeterministicChoice term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    ArrayList<Action> actions = new ArrayList<Action>();
    ProcessExpression _first = term.getFirst();
    boolean _notEquals = (!Objects.equal(_first, null));
    if (_notEquals) {
      ProcessExpression _first_1 = term.getFirst();
      Collection<Action> _firstActions_ = ExtensionMethods_RoleBehavior.getFirstActions_(_first_1, alreadyTraversedProcesses);
      actions.addAll(_firstActions_);
    }
    ProcessExpression _second = term.getSecond();
    boolean _notEquals_1 = (!Objects.equal(_second, null));
    if (_notEquals_1) {
      ProcessExpression _second_1 = term.getSecond();
      Collection<Action> _firstActions__1 = ExtensionMethods_RoleBehavior.getFirstActions_(_second_1, alreadyTraversedProcesses);
      actions.addAll(_firstActions__1);
    }
    return actions;
  }
  
  protected static Collection<Action> _getFirstActions_(final ProcessInvocation term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    if ((((!Objects.equal(term.getProcess(), null)) && (!Objects.equal(term.getProcess().getProcessExpr(), null))) && (!alreadyTraversedProcesses.contains(term.getProcess())))) {
      eu.ascens.helenaText.Process _process = term.getProcess();
      alreadyTraversedProcesses.add(_process);
      eu.ascens.helenaText.Process _process_1 = term.getProcess();
      ProcessExpression _processExpr = _process_1.getProcessExpr();
      return ExtensionMethods_RoleBehavior.getFirstActions_(_processExpr, alreadyTraversedProcesses);
    } else {
      return new HashSet<Action>();
    }
  }
  
  /**
   * Returns all plays queries without duplicates contained in the role behavior
   */
  public static Collection<PlaysQuery> getPlaysQueries(final RoleBehavior rb) {
    final Function1<Guard, Collection<PlaysQuery>> _function = new Function1<Guard, Collection<PlaysQuery>>() {
      @Override
      public Collection<PlaysQuery> apply(final Guard it) {
        return ExtensionMethods_Logic.getPlaysQueries(it);
      }
    };
    final Function2<PlaysQuery, PlaysQuery, Boolean> _function_1 = new Function2<PlaysQuery, PlaysQuery, Boolean>() {
      @Override
      public Boolean apply(final PlaysQuery query1, final PlaysQuery query2) {
        return Boolean.valueOf(ExtensionMethods_Logic.equal(query1, query2));
      }
    };
    return ExtensionMethods_RoleBehavior.<PlaysQuery>getCollectionFromGuards(rb, _function, _function_1);
  }
  
  /**
   * Returns all abstract role instances in a role behavior
   * (this set is *not* duplicate-free referring to names!)
   */
  public static Collection<AbstractRoleInstance> getAbstractRoleInstances(final RoleBehavior rb) {
    final Function1<Action, Collection<AbstractRoleInstance>> _function = new Function1<Action, Collection<AbstractRoleInstance>>() {
      @Override
      public Collection<AbstractRoleInstance> apply(final Action it) {
        return ExtensionMethods_Action.getAbstractRoleInstances(it);
      }
    };
    final Function2<AbstractRoleInstance, AbstractRoleInstance, Boolean> _function_1 = new Function2<AbstractRoleInstance, AbstractRoleInstance, Boolean>() {
      @Override
      public Boolean apply(final AbstractRoleInstance ri1, final AbstractRoleInstance ri2) {
        return Boolean.valueOf(ri1.equals(ri2));
      }
    };
    return ExtensionMethods_RoleBehavior.<AbstractRoleInstance>getCollectionFromActions(rb, _function, _function_1);
  }
  
  /**
   * Returns all formal data params in a role behavior
   * (this set is *not* duplicate-free referring to names!)
   */
  public static Collection<FormalDataParam> getFormalDataParams(final RoleBehavior rb) {
    final Function1<Action, Collection<FormalDataParam>> _function = new Function1<Action, Collection<FormalDataParam>>() {
      @Override
      public Collection<FormalDataParam> apply(final Action it) {
        return ExtensionMethods_Action.getFormalDataParams(it);
      }
    };
    final Function2<FormalDataParam, FormalDataParam, Boolean> _function_1 = new Function2<FormalDataParam, FormalDataParam, Boolean>() {
      @Override
      public Boolean apply(final FormalDataParam ri1, final FormalDataParam ri2) {
        return Boolean.valueOf(ri1.equals(ri2));
      }
    };
    return ExtensionMethods_RoleBehavior.<FormalDataParam>getCollectionFromActions(rb, _function, _function_1);
  }
  
  /**
   * Returns all data variables from operations calls in a role behavior
   * (this set is *not* duplicate-free referring to names!)
   */
  public static Collection<DataVariable> getOpDataVariables(final RoleBehavior rb) {
    final Function1<Action, Collection<DataVariable>> _function = new Function1<Action, Collection<DataVariable>>() {
      @Override
      public Collection<DataVariable> apply(final Action it) {
        return ExtensionMethods_Action.getOpDataVariables(it);
      }
    };
    final Function2<DataVariable, DataVariable, Boolean> _function_1 = new Function2<DataVariable, DataVariable, Boolean>() {
      @Override
      public Boolean apply(final DataVariable ri1, final DataVariable ri2) {
        return Boolean.valueOf(ri1.equals(ri2));
      }
    };
    return ExtensionMethods_RoleBehavior.<DataVariable>getCollectionFromActions(rb, _function, _function_1);
  }
  
  /**
   * Returns all abstract instances from incoming messages and get/create actions in a role behavior
   * (this set is *not* duplicate-free referring to names!)
   */
  public static Collection<AbstractInstance> getParams(final RoleBehavior rb) {
    Collection<AbstractRoleInstance> abstractRoleInsts = ExtensionMethods_RoleBehavior.getAbstractRoleInstances(rb);
    Collection<FormalDataParam> formalDataParams = ExtensionMethods_RoleBehavior.getFormalDataParams(rb);
    Collection<AbstractInstance> abstractInsts = new ArrayList<AbstractInstance>();
    abstractInsts.addAll(abstractRoleInsts);
    abstractInsts.addAll(formalDataParams);
    return abstractInsts;
  }
  
  /**
   * Returns all labels declared in a role behavior
   * (this set is *not* duplicate-free referring to names)
   */
  public static Collection<Label> getLabels(final RoleBehavior rb) {
    final Function1<Action, Collection<Label>> _function = new Function1<Action, Collection<Label>>() {
      @Override
      public Collection<Label> apply(final Action it) {
        return ExtensionMethods_Action.getLabels(it);
      }
    };
    final Function2<Label, Label, Boolean> _function_1 = new Function2<Label, Label, Boolean>() {
      @Override
      public Boolean apply(final Label l1, final Label l2) {
        return Boolean.valueOf(l1.equals(l2));
      }
    };
    return ExtensionMethods_RoleBehavior.<Label>getCollectionFromActions(rb, _function, _function_1);
  }
  
  /**
   * Get a (duplicate free) collection where the elements are contained in guards
   */
  private static <T extends Object> Collection<T> getCollectionFromGuards(final RoleBehavior rb, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    Collection<T> _switchResult = null;
    boolean _matched = false;
    if (rb instanceof DeclaringRoleBehavior) {
      _matched=true;
      DeclaringRoleBehavior rb2 = ((DeclaringRoleBehavior) rb);
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsForDeclaringRB(rb2, toRetrieve, equals);
    }
    if (!_matched) {
      if (rb instanceof InvokingRoleBehavior) {
        _matched=true;
        Collection<T> _xblockexpression = null;
        {
          InvokingRoleBehavior rb2 = ((InvokingRoleBehavior) rb);
          _xblockexpression = ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsForInvokingRB(rb2, toRetrieve, equals);
        }
        _switchResult = _xblockexpression;
      }
    }
    return _switchResult;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsForDeclaringRB(final DeclaringRoleBehavior rb, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    ProcessExpression _processExpr = rb.getProcessExpr();
    boolean _notEquals = (!Objects.equal(_processExpr, null));
    if (_notEquals) {
      ProcessExpression _processExpr_1 = rb.getProcessExpr();
      ArrayList<eu.ascens.helenaText.Process> _arrayList = new ArrayList<eu.ascens.helenaText.Process>();
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_processExpr_1, _arrayList, toRetrieve, equals);
    }
    return null;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsForInvokingRB(final InvokingRoleBehavior rb, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    if ((((!Objects.equal(rb.getProcessInvocation(), null)) && (!Objects.equal(rb.getProcessInvocation().getProcess(), null))) && (!Objects.equal(rb.getProcessInvocation().getProcess().getProcessExpr(), null)))) {
      ProcessInvocation _processInvocation = rb.getProcessInvocation();
      eu.ascens.helenaText.Process _process = _processInvocation.getProcess();
      ProcessExpression _processExpr = _process.getProcessExpr();
      ProcessInvocation _processInvocation_1 = rb.getProcessInvocation();
      eu.ascens.helenaText.Process _process_1 = _processInvocation_1.getProcess();
      Collection<eu.ascens.helenaText.Process> _asList = Helper.<eu.ascens.helenaText.Process>asList(_process_1);
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_processExpr, _asList, toRetrieve, equals);
    }
    return null;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsInProcessTerm(final ProcessExpression term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    boolean _matched = false;
    if (term instanceof QuitTerm) {
      _matched=true;
      QuitTerm term2 = ((QuitTerm) term);
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInQuitTerm(term2, alreadyTraversedProcesses, toRetrieve, equals);
    }
    if (!_matched) {
      if (term instanceof ActionPrefix) {
        _matched=true;
        ActionPrefix term2 = ((ActionPrefix) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInActionPrefix(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    if (!_matched) {
      if (term instanceof IfThenElse) {
        _matched=true;
        IfThenElse term2 = ((IfThenElse) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInIfThenElse(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    if (!_matched) {
      if (term instanceof NondeterministicChoice) {
        _matched=true;
        NondeterministicChoice term2 = ((NondeterministicChoice) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInNondeterministicChoice(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    if (!_matched) {
      if (term instanceof ProcessInvocation) {
        _matched=true;
        ProcessInvocation term2 = ((ProcessInvocation) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessInvocation(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    return null;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsInQuitTerm(final QuitTerm term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    return new HashSet<T>();
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsInActionPrefix(final ActionPrefix term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    ProcessExpression _processExpr = term.getProcessExpr();
    boolean _notEquals = (!Objects.equal(_processExpr, null));
    if (_notEquals) {
      ProcessExpression _processExpr_1 = term.getProcessExpr();
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_processExpr_1, alreadyTraversedProcesses, toRetrieve, equals);
    }
    return null;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsInIfThenElse(final IfThenElse term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    HashSet<T> list = new HashSet<T>();
    Guard _guard = term.getGuard();
    boolean _notEquals = (!Objects.equal(_guard, null));
    if (_notEquals) {
      Guard _guard_1 = term.getGuard();
      Collection<T> _apply = toRetrieve.apply(_guard_1);
      Helper.<T>addAllDuplicateFree(list, _apply, ((Function2<T, T, Boolean>)equals));
    }
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    boolean _notEquals_1 = (!Objects.equal(_ifProcessExpr, null));
    if (_notEquals_1) {
      ProcessExpression _ifProcessExpr_1 = term.getIfProcessExpr();
      Collection<T> _collectionFromGuardsInProcessTerm = ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_ifProcessExpr_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromGuardsInProcessTerm, ((Function2<T, T, Boolean>)equals));
    }
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    boolean _notEquals_2 = (!Objects.equal(_elseProcessExpr, null));
    if (_notEquals_2) {
      ProcessExpression _elseProcessExpr_1 = term.getElseProcessExpr();
      Collection<T> _collectionFromGuardsInProcessTerm_1 = ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_elseProcessExpr_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromGuardsInProcessTerm_1, ((Function2<T, T, Boolean>)equals));
    }
    return list;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsInNondeterministicChoice(final NondeterministicChoice term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    HashSet<T> list = new HashSet<T>();
    ProcessExpression _first = term.getFirst();
    boolean _notEquals = (!Objects.equal(_first, null));
    if (_notEquals) {
      ProcessExpression _first_1 = term.getFirst();
      Collection<T> _collectionFromGuardsInProcessTerm = ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_first_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromGuardsInProcessTerm, ((Function2<T, T, Boolean>)equals));
    }
    ProcessExpression _second = term.getSecond();
    boolean _notEquals_1 = (!Objects.equal(_second, null));
    if (_notEquals_1) {
      ProcessExpression _second_1 = term.getSecond();
      Collection<T> _collectionFromGuardsInProcessTerm_1 = ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_second_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromGuardsInProcessTerm_1, ((Function2<T, T, Boolean>)equals));
    }
    return list;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromGuardsInProcessInvocation(final ProcessInvocation term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Guard, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    HashSet<T> list = new HashSet<T>();
    if ((((!alreadyTraversedProcesses.contains(term.getProcess())) && (!Objects.equal(term.getProcess(), null))) && (!Objects.equal(term.getProcess().getProcessExpr(), null)))) {
      eu.ascens.helenaText.Process _process = term.getProcess();
      alreadyTraversedProcesses.add(_process);
      eu.ascens.helenaText.Process _process_1 = term.getProcess();
      ProcessExpression _processExpr = _process_1.getProcessExpr();
      Collection<T> _collectionFromGuardsInProcessTerm = ExtensionMethods_RoleBehavior.<T>getCollectionFromGuardsInProcessTerm(_processExpr, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromGuardsInProcessTerm, ((Function2<T, T, Boolean>)equals));
    }
    return list;
  }
  
  /**
   * Get a (duplicate free) collection where the elements are contained in actions
   */
  private static <T extends Object> Collection<T> getCollectionFromActions(final RoleBehavior rb, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    Collection<T> _switchResult = null;
    boolean _matched = false;
    if (rb instanceof DeclaringRoleBehavior) {
      _matched=true;
      DeclaringRoleBehavior rb2 = ((DeclaringRoleBehavior) rb);
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsForDeclaringRB(rb2, toRetrieve, equals);
    }
    if (!_matched) {
      if (rb instanceof InvokingRoleBehavior) {
        _matched=true;
        Collection<T> _xblockexpression = null;
        {
          InvokingRoleBehavior rb2 = ((InvokingRoleBehavior) rb);
          _xblockexpression = ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsForInvokingRB(rb2, toRetrieve, equals);
        }
        _switchResult = _xblockexpression;
      }
    }
    return _switchResult;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsForDeclaringRB(final DeclaringRoleBehavior rb, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    ProcessExpression _processExpr = rb.getProcessExpr();
    boolean _notEquals = (!Objects.equal(_processExpr, null));
    if (_notEquals) {
      ProcessExpression _processExpr_1 = rb.getProcessExpr();
      ArrayList<eu.ascens.helenaText.Process> _arrayList = new ArrayList<eu.ascens.helenaText.Process>();
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_processExpr_1, _arrayList, toRetrieve, equals);
    }
    return null;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsForInvokingRB(final InvokingRoleBehavior rb, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    if ((((!Objects.equal(rb.getProcessInvocation(), null)) && (!Objects.equal(rb.getProcessInvocation().getProcess(), null))) && (!Objects.equal(rb.getProcessInvocation().getProcess().getProcessExpr(), null)))) {
      ProcessInvocation _processInvocation = rb.getProcessInvocation();
      eu.ascens.helenaText.Process _process = _processInvocation.getProcess();
      ProcessExpression _processExpr = _process.getProcessExpr();
      ProcessInvocation _processInvocation_1 = rb.getProcessInvocation();
      eu.ascens.helenaText.Process _process_1 = _processInvocation_1.getProcess();
      Collection<eu.ascens.helenaText.Process> _asList = Helper.<eu.ascens.helenaText.Process>asList(_process_1);
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_processExpr, _asList, toRetrieve, equals);
    }
    return null;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsInProcessExpressions(final ProcessExpression term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    boolean _matched = false;
    if (term instanceof QuitTerm) {
      _matched=true;
      QuitTerm term2 = ((QuitTerm) term);
      return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInQuitTerm(term2, alreadyTraversedProcesses, toRetrieve, equals);
    }
    if (!_matched) {
      if (term instanceof ActionPrefix) {
        _matched=true;
        ActionPrefix term2 = ((ActionPrefix) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInActionPrefix(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    if (!_matched) {
      if (term instanceof IfThenElse) {
        _matched=true;
        IfThenElse term2 = ((IfThenElse) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInIfThenElse(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    if (!_matched) {
      if (term instanceof NondeterministicChoice) {
        _matched=true;
        NondeterministicChoice term2 = ((NondeterministicChoice) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInNondeterministicChoice(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    if (!_matched) {
      if (term instanceof ProcessInvocation) {
        _matched=true;
        ProcessInvocation term2 = ((ProcessInvocation) term);
        return ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessInvocation(term2, alreadyTraversedProcesses, toRetrieve, equals);
      }
    }
    return null;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsInQuitTerm(final QuitTerm term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    return new HashSet<T>();
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsInActionPrefix(final ActionPrefix term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    HashSet<T> list = new HashSet<T>();
    Action _action = term.getAction();
    boolean _notEquals = (!Objects.equal(_action, null));
    if (_notEquals) {
      Action _action_1 = term.getAction();
      Collection<T> _apply = toRetrieve.apply(_action_1);
      Helper.<T>addAllDuplicateFree(list, _apply, ((Function2<T, T, Boolean>)equals));
    }
    ProcessExpression _processExpr = term.getProcessExpr();
    boolean _notEquals_1 = (!Objects.equal(_processExpr, null));
    if (_notEquals_1) {
      ProcessExpression _processExpr_1 = term.getProcessExpr();
      Collection<T> _collectionFromActionsInProcessExpressions = ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_processExpr_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromActionsInProcessExpressions, ((Function2<T, T, Boolean>)equals));
    }
    return list;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsInIfThenElse(final IfThenElse term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    HashSet<T> list = new HashSet<T>();
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    boolean _notEquals = (!Objects.equal(_ifProcessExpr, null));
    if (_notEquals) {
      ProcessExpression _ifProcessExpr_1 = term.getIfProcessExpr();
      Collection<T> _collectionFromActionsInProcessExpressions = ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_ifProcessExpr_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromActionsInProcessExpressions, ((Function2<T, T, Boolean>)equals));
    }
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    boolean _notEquals_1 = (!Objects.equal(_elseProcessExpr, null));
    if (_notEquals_1) {
      ProcessExpression _elseProcessExpr_1 = term.getElseProcessExpr();
      Collection<T> _collectionFromActionsInProcessExpressions_1 = ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_elseProcessExpr_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromActionsInProcessExpressions_1, ((Function2<T, T, Boolean>)equals));
    }
    return list;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsInNondeterministicChoice(final NondeterministicChoice term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    HashSet<T> list = new HashSet<T>();
    ProcessExpression _first = term.getFirst();
    boolean _notEquals = (!Objects.equal(_first, null));
    if (_notEquals) {
      ProcessExpression _first_1 = term.getFirst();
      Collection<T> _collectionFromActionsInProcessExpressions = ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_first_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromActionsInProcessExpressions, ((Function2<T, T, Boolean>)equals));
    }
    ProcessExpression _second = term.getSecond();
    boolean _notEquals_1 = (!Objects.equal(_second, null));
    if (_notEquals_1) {
      ProcessExpression _second_1 = term.getSecond();
      Collection<T> _collectionFromActionsInProcessExpressions_1 = ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_second_1, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromActionsInProcessExpressions_1, ((Function2<T, T, Boolean>)equals));
    }
    return list;
  }
  
  private static <T extends Object> Collection<T> getCollectionFromActionsInProcessInvocation(final ProcessInvocation term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses, final Function1<? super Action, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    HashSet<T> list = new HashSet<T>();
    if ((((!alreadyTraversedProcesses.contains(term.getProcess())) && (!Objects.equal(term.getProcess(), null))) && (!Objects.equal(term.getProcess().getProcessExpr(), null)))) {
      eu.ascens.helenaText.Process _process = term.getProcess();
      alreadyTraversedProcesses.add(_process);
      eu.ascens.helenaText.Process _process_1 = term.getProcess();
      ProcessExpression _processExpr = _process_1.getProcessExpr();
      Collection<T> _collectionFromActionsInProcessExpressions = ExtensionMethods_RoleBehavior.<T>getCollectionFromActionsInProcessExpressions(_processExpr, alreadyTraversedProcesses, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(list, _collectionFromActionsInProcessExpressions, ((Function2<T, T, Boolean>)equals));
    }
    return list;
  }
  
  public static Collection<eu.ascens.helenaText.Process> getProcesses(final RoleBehavior rb) {
    if (rb instanceof DeclaringRoleBehavior) {
      return _getProcesses((DeclaringRoleBehavior)rb);
    } else if (rb instanceof InvokingRoleBehavior) {
      return _getProcesses((InvokingRoleBehavior)rb);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(rb).toString());
    }
  }
  
  public static Collection<Action> getFirstActions_(final ProcessExpression term, final Collection<eu.ascens.helenaText.Process> alreadyTraversedProcesses) {
    if (term instanceof ActionPrefix) {
      return _getFirstActions_((ActionPrefix)term, alreadyTraversedProcesses);
    } else if (term instanceof IfThenElse) {
      return _getFirstActions_((IfThenElse)term, alreadyTraversedProcesses);
    } else if (term instanceof NondeterministicChoice) {
      return _getFirstActions_((NondeterministicChoice)term, alreadyTraversedProcesses);
    } else if (term instanceof ProcessInvocation) {
      return _getFirstActions_((ProcessInvocation)term, alreadyTraversedProcesses);
    } else if (term instanceof QuitTerm) {
      return _getFirstActions_((QuitTerm)term, alreadyTraversedProcesses);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term, alreadyTraversedProcesses).toString());
    }
  }
}
