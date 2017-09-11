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
import eu.ascens.helenaText.AndTerm;
import eu.ascens.helenaText.Atom;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.EqualityTerm;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.GuardInParentheses;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.NotTerm;
import eu.ascens.helenaText.OrTerm;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.Relation;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_Logic;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import eu.ascens.helenaText.util.Helper;
import eu.ascens.helenaText.util.JvmTypesHelper;
import eu.ascens.validation.HelenaTextValidator;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class LogicValidator extends AbstractDeclarativeValidator {
  private final static JvmGenericType BOOLEAN_JVM_TYPE = JvmTypesHelper.createJvmType(Boolean.class.getSimpleName());
  
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  /**
   * Checks whether plays is called for a component instance
   * which can actually play the given role type
   */
  @Check
  public void check_roleBehavior_playsForCorrectCompTypeInvoked(final PlaysQuery plays) {
    if (((!Objects.equal(plays.getCompInstance(), null)) && 
      (!ExtensionMethods_RoleType.isAllowedAsOwnerType(plays.getCompInstance(), plays.getRoleTypeRef())))) {
      RoleType _roleTypeRef = plays.getRoleTypeRef();
      String _name = _roleTypeRef.getName();
      String _plus = ("A role instance of type " + _name);
      String _plus_1 = (_plus + 
        " cannot be owned by the given component instance. Allowed component types are ");
      RoleType _roleTypeRef_1 = plays.getRoleTypeRef();
      EList<ComponentType> _compTypes = _roleTypeRef_1.getCompTypes();
      final Function1<ComponentType, String> _function = new Function1<ComponentType, String>() {
        @Override
        public String apply(final ComponentType it) {
          return it.getName();
        }
      };
      List<String> _map = ListExtensions.<ComponentType, String>map(_compTypes, _function);
      String _joinToString = Helper.joinToString(",", _map);
      String _plus_2 = (_plus_1 + _joinToString);
      this.error(_plus_2, 
        HelenaTextPackage.Literals.PLAYS_QUERY__COMP_INSTANCE, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks for ConditionalSelection with a unary guard that only
   * a boolean is allowed (as guard)
   */
  @Check
  public void check_roleBehavior_unaryRelationIsBool(final IfThenElse ifThenElse) {
    final String errorText = "Only boolean is allowed for a unary guard";
    if ((LogicValidator.isUnaryExpression(ifThenElse.getGuard()) && (!ExtensionMethods_JvmType.isBoolean(this.getType(ifThenElse.getGuard()))))) {
      this.error(errorText, 
        HelenaTextPackage.Literals.IF_THEN_ELSE__GUARD, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks if the operands of a guard do have matching types
   */
  @Check
  public void check_roleBehavior_operandsMatch(final Guard guard) {
    boolean _isBinaryRelation = ExtensionMethods_Logic.isBinaryRelation(guard);
    if (_isBinaryRelation) {
      boolean typesMatch = this.typesMatch(guard);
      if ((!typesMatch)) {
        EStructuralFeature _structuralFeature = this.getStructuralFeature(guard);
        this.error(
          "Operands do not match", _structuralFeature, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  /**
   * Checks if for different types of relations (e.g. AndTerm) that operands have an allowed type
   * 
   * An Guard/OrTerm and an AndTerm should only have operands of type boolean.
   * A RelationalTerm (e.g. 1 < 3) should only have operands of type number
   */
  @Check
  public void check_roleBehavior_operandTypesBoolean(final AndTerm guard) {
    boolean _not = (!(ExtensionMethods_JvmType.isBoolean(this.getType(guard.getLeft())) && ExtensionMethods_JvmType.isBoolean(this.getType(guard.getRight()))));
    if (_not) {
      EStructuralFeature _structuralFeature = this.getStructuralFeature(guard);
      this.error(
        "Only boolean operands are allowed for this type of relation", _structuralFeature, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  @Check
  public void check_roleBehavior_operandTypesBoolean(final OrTerm guard) {
    boolean _not = (!(ExtensionMethods_JvmType.isBoolean(this.getType(guard.getLeft())) && ExtensionMethods_JvmType.isBoolean(this.getType(guard.getRight()))));
    if (_not) {
      EStructuralFeature _structuralFeature = this.getStructuralFeature(guard);
      this.error(
        "Only boolean operands are allowed for this type of relation", _structuralFeature, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  @Check
  public void check_roleBehavior_operandTypesNumbers(final Relation relation) {
    boolean _not = (!(ExtensionMethods_JvmType.isNumber(relation.getLeft()) && ExtensionMethods_JvmType.isNumber(relation.getRight())));
    if (_not) {
      this.error(
        "Only number operands are allowed for this type of relation", 
        HelenaTextPackage.Literals.RELATION__RIGHT, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks if a NotTerm that has the not operator set (e.g. !(true) )
   * contains a boolean value
   */
  @Check
  public void check_roleBehavior_notTermCorrect(final NotTerm term) {
    if (((!Objects.equal(term.getNot(), null)) && (!ExtensionMethods_JvmType.isBoolean(this.getType(term))))) {
      this.error(
        "Only a boolean expression is allowed", 
        HelenaTextPackage.Literals.NOT_TERM__ATOM, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Calculates if both operands of a relation do have the same type
   */
  private boolean typesMatch(final Guard guard) {
    if (((ExtensionMethods_Logic.isBinaryRelation(guard) && (!Objects.equal(ExtensionMethods_Logic.getRight(guard), null))) && (!Objects.equal(ExtensionMethods_Logic.getLeft(guard), null)))) {
      Guard _left = ExtensionMethods_Logic.getLeft(guard);
      JvmType left = this.getType(_left);
      Guard _right = ExtensionMethods_Logic.getRight(guard);
      JvmType right = this.getType(_right);
      return JvmTypesHelper.typesEqual(left, right);
    } else {
      boolean _isBinaryRelation = ExtensionMethods_Logic.isBinaryRelation(guard);
      boolean _not = (!_isBinaryRelation);
      if (_not) {
        JvmType _type = this.getType(guard);
        return ExtensionMethods_JvmType.isBoolean(_type);
      }
    }
    return false;
  }
  
  /**
   * Calculates the jvmType of a guard
   */
  protected JvmType _getType(final OrTerm term) {
    return LogicValidator.BOOLEAN_JVM_TYPE;
  }
  
  protected JvmType _getType(final AndTerm term) {
    return LogicValidator.BOOLEAN_JVM_TYPE;
  }
  
  protected JvmType _getType(final EqualityTerm term) {
    return LogicValidator.BOOLEAN_JVM_TYPE;
  }
  
  protected JvmType _getType(final NotTerm term) {
    Atom atom = term.getAtom();
    boolean _notEquals = (!Objects.equal(atom, null));
    if (_notEquals) {
      return this.getTypeFromAtom(atom);
    } else {
      return null;
    }
  }
  
  /**
   * Get jvm type from an atom
   */
  protected JvmType _getTypeFromAtom(final DataExpression atom) {
    return ExtensionMethods_Param.getWrappedJvmType(atom);
  }
  
  protected JvmType _getTypeFromAtom(final PlaysQuery atom) {
    return LogicValidator.BOOLEAN_JVM_TYPE;
  }
  
  protected JvmType _getTypeFromAtom(final Relation atom) {
    return LogicValidator.BOOLEAN_JVM_TYPE;
  }
  
  protected JvmType _getTypeFromAtom(final GuardInParentheses atom) {
    Guard _guard = atom.getGuard();
    return this.getType(_guard);
  }
  
  /**
   * Returns true if a guard is a not Term and consists of a DataExpression
   * false otherwise
   */
  public static boolean isUnaryExpression(final Guard guard) {
    if ((guard instanceof NotTerm)) {
      NotTerm term = ((NotTerm) guard);
      Atom _atom = term.getAtom();
      if ((_atom instanceof DataExpression)) {
        return true;
      }
      Atom _atom_1 = term.getAtom();
      if ((_atom_1 instanceof GuardInParentheses)) {
        Atom _atom_2 = term.getAtom();
        Guard _guard = ((GuardInParentheses) _atom_2).getGuard();
        return LogicValidator.isUnaryExpression(_guard);
      }
    }
    return false;
  }
  
  private EStructuralFeature _getStructuralFeature(final AndTerm term) {
    return HelenaTextPackage.Literals.AND_TERM__RIGHT;
  }
  
  private EStructuralFeature _getStructuralFeature(final OrTerm term) {
    return HelenaTextPackage.Literals.OR_TERM__RIGHT;
  }
  
  private EStructuralFeature _getStructuralFeature(final EqualityTerm term) {
    return HelenaTextPackage.Literals.EQUALITY_TERM__RIGHT;
  }
  
  private EStructuralFeature _getStructuralFeature(final NotTerm term) {
    return HelenaTextPackage.Literals.NOT_TERM__ATOM;
  }
  
  public JvmType getType(final Guard term) {
    if (term instanceof AndTerm) {
      return _getType((AndTerm)term);
    } else if (term instanceof EqualityTerm) {
      return _getType((EqualityTerm)term);
    } else if (term instanceof NotTerm) {
      return _getType((NotTerm)term);
    } else if (term instanceof OrTerm) {
      return _getType((OrTerm)term);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term).toString());
    }
  }
  
  public JvmType getTypeFromAtom(final Atom atom) {
    if (atom instanceof DataExpression) {
      return _getTypeFromAtom((DataExpression)atom);
    } else if (atom instanceof GuardInParentheses) {
      return _getTypeFromAtom((GuardInParentheses)atom);
    } else if (atom instanceof PlaysQuery) {
      return _getTypeFromAtom((PlaysQuery)atom);
    } else if (atom instanceof Relation) {
      return _getTypeFromAtom((Relation)atom);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(atom).toString());
    }
  }
  
  private EStructuralFeature getStructuralFeature(final Guard term) {
    if (term instanceof AndTerm) {
      return _getStructuralFeature((AndTerm)term);
    } else if (term instanceof EqualityTerm) {
      return _getStructuralFeature((EqualityTerm)term);
    } else if (term instanceof NotTerm) {
      return _getStructuralFeature((NotTerm)term);
    } else if (term instanceof OrTerm) {
      return _getStructuralFeature((OrTerm)term);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term).toString());
    }
  }
}
