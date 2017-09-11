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
package eu.ascens.validation;

import com.google.common.base.Objects;
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.Action;
import eu.ascens.helenaText.ActionPrefix;
import eu.ascens.helenaText.Addition;
import eu.ascens.helenaText.ComponentAssociationTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.CreateAssignment;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.GetAssignment;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.NondeterministicChoice;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.ProcessExpression;
import eu.ascens.helenaText.ProcessInvocation;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.Subtraction;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_Logic;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.validation.HelenaTextValidator;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RoleBehaviorValidator extends AbstractDeclarativeValidator {
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  /**
   * Checks that a process does not immediately invoke itself
   * (if if-then-else and nondeterministic choice are the first process construct,
   * this is checked in another function).
   */
  @Check
  public void check_roleBehavior_processDoesNotImmediatelyInvokeItself(final ProcessInvocation invocation) {
    ProcessInvocation toCheck = invocation;
    while ((toCheck.getProcess().getProcessExpr() instanceof ProcessInvocation)) {
      {
        eu.ascens.helenaText.Process _process = toCheck.getProcess();
        ProcessExpression _processExpr = _process.getProcessExpr();
        toCheck = ((ProcessInvocation) _processExpr);
        eu.ascens.helenaText.Process _process_1 = invocation.getProcess();
        String _name = _process_1.getName();
        eu.ascens.helenaText.Process _process_2 = toCheck.getProcess();
        String _name_1 = _process_2.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        if (_equals) {
          this.error(
            (("A process invocation should not immediately invoke itself " + 
              "(also not through a chain of invocations). ") + 
              "This results in a infinite loop when executing the role behavior."), 
            HelenaTextPackage.Literals.PROCESS_INVOCATION__PROCESS, 
            HelenaTextValidator.NOT_ALLOWED);
          return;
        }
      }
    }
  }
  
  /**
   * Checks that in a role behavior only local processes which were declared inside the
   * role behavior are called
   */
  @Check
  public void check_roleBehavior_onlyProcessesOfTheRoleBehaviorInvoked(final ProcessInvocation invocation) {
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(invocation);
    eu.ascens.helenaText.Process _process = invocation.getProcess();
    RoleBehavior _parentRoleBehavior_1 = ExtensionMethods_RoleBehavior.getParentRoleBehavior(_process);
    boolean _notEquals = (!Objects.equal(_parentRoleBehavior, _parentRoleBehavior_1));
    if (_notEquals) {
      eu.ascens.helenaText.Process _process_1 = invocation.getProcess();
      String _name = _process_1.getName();
      String _plus = ("The process " + _name);
      String _plus_1 = (_plus + " can only be invoked inside the role behavior where it was defined.");
      this.error(_plus_1, 
        HelenaTextPackage.Literals.PROCESS_INVOCATION__PROCESS, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks there are no mixed actions in nondeterministic choice
   * i.e. either all actions are outgoing (and internal) or incoming
   */
  @Check
  public void check_roleBehavior_noMixedStates(final NondeterministicChoice term) {
    ProcessExpression _first = term.getFirst();
    Collection<Action> actions = ExtensionMethods_RoleBehavior.getFirstActions(_first);
    boolean _not = (!(IterableExtensions.<Action>forall(actions, new Function1<Action, Boolean>() {
      @Override
      public Boolean apply(final Action it) {
        return Boolean.valueOf((it instanceof IncomingMessageCall));
      }
    }) || 
      IterableExtensions.<Action>forall(actions, new Function1<Action, Boolean>() {
        @Override
        public Boolean apply(final Action it) {
          return Boolean.valueOf((!(it instanceof IncomingMessageCall)));
        }
      })));
    if (_not) {
      this.error(
        "In nondeterministic choice, mixed states are not allowed.", 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST, 
        HelenaTextValidator.NOT_ALLOWED);
    }
    ProcessExpression _second = term.getSecond();
    Collection<Action> actions2 = ExtensionMethods_RoleBehavior.getFirstActions(_second);
    boolean _not_1 = (!(IterableExtensions.<Action>forall(actions2, new Function1<Action, Boolean>() {
      @Override
      public Boolean apply(final Action it) {
        return Boolean.valueOf((it instanceof IncomingMessageCall));
      }
    }) || 
      IterableExtensions.<Action>forall(actions2, new Function1<Action, Boolean>() {
        @Override
        public Boolean apply(final Action it) {
          return Boolean.valueOf((!(it instanceof IncomingMessageCall)));
        }
      })));
    if (_not_1) {
      this.error(
        "In nondeterministic choice, mixed states are not allowed.", 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks no branch of nondeterministic choice is a direct process invocation
   */
  @Check
  public void check_roleBehavior_noProcInvocInNDC(final NondeterministicChoice term) {
    ProcessExpression _first = term.getFirst();
    if ((_first instanceof ProcessInvocation)) {
      this.warning(
        "In nondeterministic choice, direct process invocation should not be used.", 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST, 
        HelenaTextValidator.NOT_ALLOWED);
    }
    ProcessExpression _second = term.getSecond();
    if ((_second instanceof ProcessInvocation)) {
      this.warning(
        "In nondeterministic choice, direct process invocation should not be used.", 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks no branch of if-then-else is a direct process invocation
   */
  @Check
  public void check_roleBehavior_noProcInvocInIfThenElse(final IfThenElse term) {
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    if ((_ifProcessExpr instanceof ProcessInvocation)) {
      this.warning(
        "In if-then-else, direct process invocation should not be used.", 
        HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR, 
        HelenaTextValidator.NOT_ALLOWED);
    }
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    if ((_elseProcessExpr instanceof ProcessInvocation)) {
      this.warning(
        "In if-then-else, direct process invocation should not be used.", 
        HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks no branch of nondeterministic choice starts with a create/get action
   */
  @Check
  public void check_roleBehavior_noCreateGetInNDC(final NondeterministicChoice term) {
    ProcessExpression _first = term.getFirst();
    Collection<Action> actions = ExtensionMethods_RoleBehavior.getFirstActions(_first);
    final Function1<Action, Boolean> _function = new Function1<Action, Boolean>() {
      @Override
      public Boolean apply(final Action it) {
        return Boolean.valueOf((it instanceof CreateAssignment));
      }
    };
    boolean _exists = IterableExtensions.<Action>exists(actions, _function);
    if (_exists) {
      this.warning(
        ("In nondeterministic choice, create should only be used as first action of a branch" + 
          " if one can guarantee that a new role instance can be created."), 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST, 
        HelenaTextValidator.NOT_ALLOWED);
    }
    final Function1<Action, Boolean> _function_1 = new Function1<Action, Boolean>() {
      @Override
      public Boolean apply(final Action it) {
        return Boolean.valueOf((it instanceof GetAssignment));
      }
    };
    boolean _exists_1 = IterableExtensions.<Action>exists(actions, _function_1);
    if (_exists_1) {
      this.warning(
        ("In nondeterministic choice, get should only be used as first action of a branch" + 
          " if one can guarantee that there exists a corresponding role instance."), 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST, 
        HelenaTextValidator.NOT_ALLOWED);
    }
    ProcessExpression _second = term.getSecond();
    Collection<Action> _firstActions = ExtensionMethods_RoleBehavior.getFirstActions(_second);
    actions = _firstActions;
    final Function1<Action, Boolean> _function_2 = new Function1<Action, Boolean>() {
      @Override
      public Boolean apply(final Action it) {
        return Boolean.valueOf((it instanceof CreateAssignment));
      }
    };
    boolean _exists_2 = IterableExtensions.<Action>exists(actions, _function_2);
    if (_exists_2) {
      this.warning(
        ("In nondeterministic choice, create should only be used as first action of a branch" + 
          " if one can guarantee that a new role instance can be created."), 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND, 
        HelenaTextValidator.NOT_ALLOWED);
    }
    final Function1<Action, Boolean> _function_3 = new Function1<Action, Boolean>() {
      @Override
      public Boolean apply(final Action it) {
        return Boolean.valueOf((it instanceof GetAssignment));
      }
    };
    boolean _exists_3 = IterableExtensions.<Action>exists(actions, _function_3);
    if (_exists_3) {
      this.warning(
        ("In nondeterministic choice, get should only be used as first action of a branch" + 
          " if one can guarantee that there exists a corresponding role instance."), 
        HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__SECOND, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks no branch of if-then-else starts with a create/get action if not preceeded by a corresponding plays query
   */
  @Check
  public void check_roleBehavior_noCreateGetInIfThenElse(final IfThenElse term) {
    Guard _guard = term.getGuard();
    Collection<PlaysQuery> playsQueries = ExtensionMethods_Logic.getPlaysQueries(_guard);
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    if ((_ifProcessExpr instanceof ActionPrefix)) {
      ProcessExpression _ifProcessExpr_1 = term.getIfProcessExpr();
      ActionPrefix procTerm = ((ActionPrefix) _ifProcessExpr_1);
      Action _action = procTerm.getAction();
      if ((_action instanceof AbstractAssignment)) {
        Action _action_1 = procTerm.getAction();
        AbstractAssignment assignment = ((AbstractAssignment) _action_1);
        boolean found = false;
        for (final PlaysQuery playsQuery : playsQueries) {
          RoleType _roleTypeRef = playsQuery.getRoleTypeRef();
          RoleType _roleTypeRef_1 = assignment.getRoleTypeRef();
          ComponentInstance _compInstance = playsQuery.getCompInstance();
          ComponentInstance _compInstance_1 = assignment.getCompInstance();
          boolean _same = this.same(_roleTypeRef, _roleTypeRef_1, _compInstance, _compInstance_1);
          if (_same) {
            found = true;
          }
        }
        if ((!found)) {
          this.warning(
            ("In if-then-else, create/get should only be used as first action of a branch" + 
              " if they can be guaranteed to succeed."), 
            HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR, 
            HelenaTextValidator.NOT_ALLOWED);
        }
      }
    }
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    if ((_elseProcessExpr instanceof ActionPrefix)) {
      ProcessExpression _elseProcessExpr_1 = term.getElseProcessExpr();
      ActionPrefix procTerm_1 = ((ActionPrefix) _elseProcessExpr_1);
      Action _action_2 = procTerm_1.getAction();
      if ((_action_2 instanceof AbstractAssignment)) {
        Action _action_3 = procTerm_1.getAction();
        AbstractAssignment assignment_1 = ((AbstractAssignment) _action_3);
        boolean found_1 = false;
        for (final PlaysQuery playsQuery_1 : playsQueries) {
          RoleType _roleTypeRef_2 = playsQuery_1.getRoleTypeRef();
          RoleType _roleTypeRef_3 = assignment_1.getRoleTypeRef();
          ComponentInstance _compInstance_2 = playsQuery_1.getCompInstance();
          ComponentInstance _compInstance_3 = assignment_1.getCompInstance();
          boolean _same_1 = this.same(_roleTypeRef_2, _roleTypeRef_3, _compInstance_2, _compInstance_3);
          if (_same_1) {
            found_1 = true;
          }
        }
        if ((!found_1)) {
          this.warning(
            ("In if-then-else, create/get should only be used as first action of a branch" + 
              " if preceeded by a corresponding plays query."), 
            HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR, 
            HelenaTextValidator.NOT_ALLOWED);
        }
      }
    }
  }
  
  private boolean _same(final RoleType roleType, final RoleType roleType2, final ComponentInstance component, final ComponentInstance component2) {
    return false;
  }
  
  private boolean _same(final RoleType roleType, final RoleType roleType2, final OwnerReference component, final OwnerReference component2) {
    return Objects.equal(roleType, roleType2);
  }
  
  private boolean _same(final RoleType roleType, final RoleType roleType2, final ComponentAssociationTypeReference component, final ComponentAssociationTypeReference component2) {
    return (Objects.equal(roleType, roleType2) && Objects.equal(component.getRef(), component2.getRef()));
  }
  
  /**
   * Checks that message reception is not first action of any branch in if-then-else
   */
  @Check
  public void check_roleBehavior_noReceiveInIfThenElse(final IfThenElse term) {
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    if ((_ifProcessExpr instanceof ActionPrefix)) {
      ProcessExpression _ifProcessExpr_1 = term.getIfProcessExpr();
      ActionPrefix prefix = ((ActionPrefix) _ifProcessExpr_1);
      Action _action = prefix.getAction();
      if ((_action instanceof IncomingMessageCall)) {
        this.error(
          "In if-then-else, message reception should not be used as first action.", 
          HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    if ((_elseProcessExpr instanceof ActionPrefix)) {
      ProcessExpression _elseProcessExpr_1 = term.getElseProcessExpr();
      ActionPrefix prefix_1 = ((ActionPrefix) _elseProcessExpr_1);
      Action _action_1 = prefix_1.getAction();
      if ((_action_1 instanceof Label)) {
        this.error(
          "In if-then-else, message reception should not be used as first action.", 
          HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  /**
   * Checks that state labels are not first action of any branch in nondeterministic choice
   */
  @Check
  public void check_roleBehavior_noLabelsInNDC(final NondeterministicChoice term) {
    ProcessExpression _first = term.getFirst();
    if ((_first instanceof ActionPrefix)) {
      ProcessExpression _first_1 = term.getFirst();
      ActionPrefix prefix = ((ActionPrefix) _first_1);
      Action _action = prefix.getAction();
      if ((_action instanceof Label)) {
        this.error(
          "In nondeterministic choice, labels are not allowed as first action.", 
          HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
    ProcessExpression _second = term.getSecond();
    if ((_second instanceof ProcessInvocation)) {
      ProcessExpression _second_1 = term.getSecond();
      ActionPrefix prefix_1 = ((ActionPrefix) _second_1);
      Action _action_1 = prefix_1.getAction();
      if ((_action_1 instanceof Label)) {
        this.error(
          "In nondeterministic choice, labels are not allowed as first action.", 
          HelenaTextPackage.Literals.NONDETERMINISTIC_CHOICE__FIRST, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  /**
   * Checks that state labels are not first action of any branch in if-then-else
   */
  @Check
  public void check_roleBehavior_noLabelsInIfThenElse(final IfThenElse term) {
    ProcessExpression _ifProcessExpr = term.getIfProcessExpr();
    if ((_ifProcessExpr instanceof ActionPrefix)) {
      ProcessExpression _ifProcessExpr_1 = term.getIfProcessExpr();
      ActionPrefix prefix = ((ActionPrefix) _ifProcessExpr_1);
      Action _action = prefix.getAction();
      if ((_action instanceof Label)) {
        this.error(
          "In if-then-else, labels are not allowed as first action.", 
          HelenaTextPackage.Literals.IF_THEN_ELSE__IF_PROCESS_EXPR, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
    ProcessExpression _elseProcessExpr = term.getElseProcessExpr();
    if ((_elseProcessExpr instanceof ActionPrefix)) {
      ProcessExpression _elseProcessExpr_1 = term.getElseProcessExpr();
      ActionPrefix prefix_1 = ((ActionPrefix) _elseProcessExpr_1);
      Action _action_1 = prefix_1.getAction();
      if ((_action_1 instanceof Label)) {
        this.error(
          "In if-then-else, labels are not allowed as first action.", 
          HelenaTextPackage.Literals.IF_THEN_ELSE__ELSE_PROCESS_EXPR, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  /**
   * Checks that addition only use numbers
   */
  @Check
  public void check_addition_typesMatch(final Addition exp) {
    DataExpression _right = exp.getRight();
    boolean _notEquals = (!Objects.equal(_right, null));
    if (_notEquals) {
      DataExpression _left = exp.getLeft();
      boolean _isNumber = ExtensionMethods_JvmType.isNumber(_left);
      boolean _not = (!_isNumber);
      if (_not) {
        this.error(
          "Only numbers can be used in addition expressions", 
          HelenaTextPackage.Literals.ADDITION__LEFT, 
          HelenaTextValidator.NOT_ALLOWED);
      }
      DataExpression _right_1 = exp.getRight();
      boolean _isNumber_1 = ExtensionMethods_JvmType.isNumber(_right_1);
      boolean _not_1 = (!_isNumber_1);
      if (_not_1) {
        this.error(
          "Only numbers can be used in addition expressions", 
          HelenaTextPackage.Literals.ADDITION__RIGHT, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  /**
   * Checks that subtraction only use numbers
   */
  @Check
  public void check_subtraction_typesMatch(final Subtraction exp) {
    DataExpression _right = exp.getRight();
    boolean _notEquals = (!Objects.equal(_right, null));
    if (_notEquals) {
      DataExpression _left = exp.getLeft();
      boolean _isNumber = ExtensionMethods_JvmType.isNumber(_left);
      boolean _not = (!_isNumber);
      if (_not) {
        this.error(
          "Only numbers can be used in subtraction expressions", 
          HelenaTextPackage.Literals.SUBTRACTION__LEFT, 
          HelenaTextValidator.NOT_ALLOWED);
      }
      DataExpression _right_1 = exp.getRight();
      boolean _isNumber_1 = ExtensionMethods_JvmType.isNumber(_right_1);
      boolean _not_1 = (!_isNumber_1);
      if (_not_1) {
        this.error(
          "Only numbers can be used in subtraction expressions", 
          HelenaTextPackage.Literals.SUBTRACTION__RIGHT, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  private boolean same(final RoleType roleType, final RoleType roleType2, final ComponentInstance component, final ComponentInstance component2) {
    if (component instanceof ComponentAssociationTypeReference
         && component2 instanceof ComponentAssociationTypeReference) {
      return _same(roleType, roleType2, (ComponentAssociationTypeReference)component, (ComponentAssociationTypeReference)component2);
    } else if (component instanceof OwnerReference
         && component2 instanceof OwnerReference) {
      return _same(roleType, roleType2, (OwnerReference)component, (OwnerReference)component2);
    } else if (component != null
         && component2 != null) {
      return _same(roleType, roleType2, component, component2);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(roleType, roleType2, component, component2).toString());
    }
  }
}
