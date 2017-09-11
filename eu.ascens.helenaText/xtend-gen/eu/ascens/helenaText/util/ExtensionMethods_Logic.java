package eu.ascens.helenaText.util;

import com.google.common.base.Objects;
import eu.ascens.helenaText.Addition;
import eu.ascens.helenaText.AndTerm;
import eu.ascens.helenaText.Atom;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAssociationTypeReference;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentAttributeTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.EqualityTerm;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.GuardInParentheses;
import eu.ascens.helenaText.NotTerm;
import eu.ascens.helenaText.OrTerm;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.Relation;
import eu.ascens.helenaText.Subtraction;
import eu.ascens.helenaText.util.Helper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

@SuppressWarnings("all")
public class ExtensionMethods_Logic {
  /**
   * Returns the list of component attribute types contained in a guard
   */
  public static Collection<ComponentAttributeType> getComponentAttributes(final Guard guard) {
    final Function1<Atom, Collection<ComponentAttributeType>> _function = new Function1<Atom, Collection<ComponentAttributeType>>() {
      @Override
      public Collection<ComponentAttributeType> apply(final Atom it) {
        return ExtensionMethods_Logic.getAtomComponentAttributes(it);
      }
    };
    final Function2<ComponentAttributeType, ComponentAttributeType, Boolean> _function_1 = new Function2<ComponentAttributeType, ComponentAttributeType, Boolean>() {
      @Override
      public Boolean apply(final ComponentAttributeType attr1, final ComponentAttributeType attr2) {
        return Boolean.valueOf(attr1.equals(attr2));
      }
    };
    return ExtensionMethods_Logic.<ComponentAttributeType>getCollection(guard, _function, _function_1);
  }
  
  /**
   * Returns the list of component attribute types reference contained in an atom
   */
  private static Collection<ComponentAttributeType> _getAtomComponentAttributes(final Atom expression) {
    return new ArrayList<ComponentAttributeType>();
  }
  
  private static Collection<ComponentAttributeType> _getAtomComponentAttributes(final ComponentAttributeTypeReference expression) {
    ComponentAttributeType _ref = expression.getRef();
    return Helper.<ComponentAttributeType>asList(_ref);
  }
  
  private static Collection<ComponentAttributeType> _getAtomComponentAttributes(final Addition expression) {
    ArrayList<ComponentAttributeType> list = new ArrayList<ComponentAttributeType>();
    DataExpression _left = expression.getLeft();
    Collection<ComponentAttributeType> _atomComponentAttributes = ExtensionMethods_Logic.getAtomComponentAttributes(_left);
    list.addAll(_atomComponentAttributes);
    DataExpression _right = expression.getRight();
    Collection<ComponentAttributeType> _atomComponentAttributes_1 = ExtensionMethods_Logic.getAtomComponentAttributes(_right);
    list.addAll(_atomComponentAttributes_1);
    return list;
  }
  
  private static Collection<ComponentAttributeType> _getAtomComponentAttributes(final Subtraction expression) {
    ArrayList<ComponentAttributeType> list = new ArrayList<ComponentAttributeType>();
    DataExpression _left = expression.getLeft();
    Collection<ComponentAttributeType> _atomComponentAttributes = ExtensionMethods_Logic.getAtomComponentAttributes(_left);
    list.addAll(_atomComponentAttributes);
    DataExpression _right = expression.getRight();
    Collection<ComponentAttributeType> _atomComponentAttributes_1 = ExtensionMethods_Logic.getAtomComponentAttributes(_right);
    list.addAll(_atomComponentAttributes_1);
    return list;
  }
  
  private static Collection<ComponentAttributeType> _getAtomComponentAttributes(final Relation expression) {
    ArrayList<ComponentAttributeType> list = new ArrayList<ComponentAttributeType>();
    DataExpression _left = expression.getLeft();
    Collection<ComponentAttributeType> _atomComponentAttributes = ExtensionMethods_Logic.getAtomComponentAttributes(_left);
    list.addAll(_atomComponentAttributes);
    DataExpression _right = expression.getRight();
    Collection<ComponentAttributeType> _atomComponentAttributes_1 = ExtensionMethods_Logic.getAtomComponentAttributes(_right);
    list.addAll(_atomComponentAttributes_1);
    return list;
  }
  
  private static Collection<ComponentAttributeType> _getAtomComponentAttributes(final GuardInParentheses expression) {
    Guard _guard = expression.getGuard();
    return ExtensionMethods_Logic.getComponentAttributes(_guard);
  }
  
  /**
   * Returns a list of (duplicate free) play queries for a guard
   */
  public static Collection<PlaysQuery> getPlaysQueries(final Guard guard) {
    final Function1<Atom, Collection<PlaysQuery>> _function = new Function1<Atom, Collection<PlaysQuery>>() {
      @Override
      public Collection<PlaysQuery> apply(final Atom it) {
        return ExtensionMethods_Logic.getAtomPlaysQueries(it);
      }
    };
    final Function2<PlaysQuery, PlaysQuery, Boolean> _function_1 = new Function2<PlaysQuery, PlaysQuery, Boolean>() {
      @Override
      public Boolean apply(final PlaysQuery query1, final PlaysQuery query2) {
        return Boolean.valueOf(ExtensionMethods_Logic.equal(query1, query2));
      }
    };
    return ExtensionMethods_Logic.<PlaysQuery>getCollection(guard, _function, _function_1);
  }
  
  /**
   * Returns a list of (duplicate free) play queries for an atom
   */
  private static Collection<PlaysQuery> _getAtomPlaysQueries(final Atom term) {
    return new ArrayList<PlaysQuery>();
  }
  
  private static Collection<PlaysQuery> _getAtomPlaysQueries(final PlaysQuery term) {
    return Helper.<PlaysQuery>asList(term);
  }
  
  private static Collection<PlaysQuery> _getAtomPlaysQueries(final GuardInParentheses term) {
    Guard _guard = term.getGuard();
    return ExtensionMethods_Logic.getPlaysQueries(_guard);
  }
  
  public static boolean equal(final PlaysQuery query1, final PlaysQuery query2) {
    if ((Objects.equal(query1, null) || Objects.equal(query2, null))) {
      return false;
    }
    return (ExtensionMethods_Logic.equalCompInstances(query1.getCompInstance(), query2.getCompInstance()) && Objects.equal(query1.getRoleTypeRef(), query2.getRoleTypeRef()));
  }
  
  private static boolean _equalCompInstances(final ComponentAssociationTypeReference component1, final ComponentAssociationTypeReference component2) {
    ComponentAssociationType _ref = component1.getRef();
    ComponentAssociationType _ref_1 = component2.getRef();
    return Objects.equal(_ref, _ref_1);
  }
  
  private static boolean _equalCompInstances(final ComponentAssociationTypeReference component1, final OwnerReference component2) {
    return false;
  }
  
  private static boolean _equalCompInstances(final OwnerReference component1, final ComponentAssociationTypeReference component2) {
    return false;
  }
  
  private static boolean _equalCompInstances(final OwnerReference component1, final OwnerReference component2) {
    return true;
  }
  
  /**
   * Get a (duplicate free) collection where the elements are contained in atoms
   */
  private static <T extends Object> Collection<T> getCollection(final Guard guard, final Function1<? super Atom, ? extends Collection<T>> toRetrieve, final Function2<? super T, ? super T, ? extends Boolean> equals) {
    ArrayList<T> collection = new ArrayList<T>();
    boolean _isBinaryRelation = ExtensionMethods_Logic.isBinaryRelation(guard);
    boolean _not = (!_isBinaryRelation);
    if (_not) {
      Atom _atom = ExtensionMethods_Logic.getAtom(guard);
      boolean _notEquals = (!Objects.equal(_atom, null));
      if (_notEquals) {
        Atom _atom_1 = ExtensionMethods_Logic.getAtom(guard);
        Collection<T> _apply = toRetrieve.apply(_atom_1);
        Helper.<T>addAllDuplicateFree(collection, _apply, ((Function2<T, T, Boolean>)equals));
      }
      return collection;
    }
    Guard _left = ExtensionMethods_Logic.getLeft(guard);
    boolean _notEquals_1 = (!Objects.equal(_left, null));
    if (_notEquals_1) {
      Guard _left_1 = ExtensionMethods_Logic.getLeft(guard);
      Collection<T> _collection = ExtensionMethods_Logic.<T>getCollection(_left_1, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(collection, _collection, ((Function2<T, T, Boolean>)equals));
    }
    Guard _right = ExtensionMethods_Logic.getRight(guard);
    boolean _notEquals_2 = (!Objects.equal(_right, null));
    if (_notEquals_2) {
      Guard _right_1 = ExtensionMethods_Logic.getRight(guard);
      Collection<T> _collection_1 = ExtensionMethods_Logic.<T>getCollection(_right_1, toRetrieve, equals);
      Helper.<T>addAllDuplicateFree(collection, _collection_1, ((Function2<T, T, Boolean>)equals));
    }
    return collection;
  }
  
  public static boolean _isBinaryRelation(final OrTerm guard) {
    return true;
  }
  
  public static boolean _isBinaryRelation(final AndTerm guard) {
    return true;
  }
  
  public static boolean _isBinaryRelation(final EqualityTerm guard) {
    return true;
  }
  
  public static boolean _isBinaryRelation(final NotTerm guard) {
    return false;
  }
  
  /**
   * Get left term of a relation.
   * If function is called for a NotTerm, null is returned
   */
  public static Guard _getLeft(final OrTerm guard) {
    return guard.getLeft();
  }
  
  public static Guard _getLeft(final AndTerm guard) {
    return guard.getLeft();
  }
  
  public static Guard _getLeft(final EqualityTerm guard) {
    return guard.getLeft();
  }
  
  public static Guard _getLeft(final NotTerm guard) {
    return null;
  }
  
  /**
   * Get rigth term of a relation.
   * If function is called for a NotTerm, null is returned
   */
  public static Guard _getRight(final OrTerm guard) {
    return guard.getRight();
  }
  
  public static Guard _getRight(final AndTerm guard) {
    return guard.getRight();
  }
  
  public static Guard _getRight(final EqualityTerm guard) {
    return guard.getRight();
  }
  
  public static Guard _getRight(final NotTerm guard) {
    return null;
  }
  
  public static Atom _getAtom(final NotTerm guard) {
    return guard.getAtom();
  }
  
  public static Atom _getAtom(final OrTerm guard) {
    return null;
  }
  
  public static Atom _getAtom(final AndTerm guard) {
    return null;
  }
  
  public static Atom _getAtom(final EqualityTerm guard) {
    return null;
  }
  
  private static Collection<ComponentAttributeType> getAtomComponentAttributes(final Atom expression) {
    if (expression instanceof ComponentAttributeTypeReference) {
      return _getAtomComponentAttributes((ComponentAttributeTypeReference)expression);
    } else if (expression instanceof Addition) {
      return _getAtomComponentAttributes((Addition)expression);
    } else if (expression instanceof Subtraction) {
      return _getAtomComponentAttributes((Subtraction)expression);
    } else if (expression instanceof GuardInParentheses) {
      return _getAtomComponentAttributes((GuardInParentheses)expression);
    } else if (expression instanceof Relation) {
      return _getAtomComponentAttributes((Relation)expression);
    } else if (expression != null) {
      return _getAtomComponentAttributes(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
  
  private static Collection<PlaysQuery> getAtomPlaysQueries(final Atom term) {
    if (term instanceof GuardInParentheses) {
      return _getAtomPlaysQueries((GuardInParentheses)term);
    } else if (term instanceof PlaysQuery) {
      return _getAtomPlaysQueries((PlaysQuery)term);
    } else if (term != null) {
      return _getAtomPlaysQueries(term);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term).toString());
    }
  }
  
  private static boolean equalCompInstances(final ComponentInstance component1, final ComponentInstance component2) {
    if (component1 instanceof ComponentAssociationTypeReference
         && component2 instanceof ComponentAssociationTypeReference) {
      return _equalCompInstances((ComponentAssociationTypeReference)component1, (ComponentAssociationTypeReference)component2);
    } else if (component1 instanceof ComponentAssociationTypeReference
         && component2 instanceof OwnerReference) {
      return _equalCompInstances((ComponentAssociationTypeReference)component1, (OwnerReference)component2);
    } else if (component1 instanceof OwnerReference
         && component2 instanceof ComponentAssociationTypeReference) {
      return _equalCompInstances((OwnerReference)component1, (ComponentAssociationTypeReference)component2);
    } else if (component1 instanceof OwnerReference
         && component2 instanceof OwnerReference) {
      return _equalCompInstances((OwnerReference)component1, (OwnerReference)component2);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(component1, component2).toString());
    }
  }
  
  public static boolean isBinaryRelation(final Guard guard) {
    if (guard instanceof AndTerm) {
      return _isBinaryRelation((AndTerm)guard);
    } else if (guard instanceof EqualityTerm) {
      return _isBinaryRelation((EqualityTerm)guard);
    } else if (guard instanceof NotTerm) {
      return _isBinaryRelation((NotTerm)guard);
    } else if (guard instanceof OrTerm) {
      return _isBinaryRelation((OrTerm)guard);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(guard).toString());
    }
  }
  
  public static Guard getLeft(final Guard guard) {
    if (guard instanceof AndTerm) {
      return _getLeft((AndTerm)guard);
    } else if (guard instanceof EqualityTerm) {
      return _getLeft((EqualityTerm)guard);
    } else if (guard instanceof NotTerm) {
      return _getLeft((NotTerm)guard);
    } else if (guard instanceof OrTerm) {
      return _getLeft((OrTerm)guard);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(guard).toString());
    }
  }
  
  public static Guard getRight(final Guard guard) {
    if (guard instanceof AndTerm) {
      return _getRight((AndTerm)guard);
    } else if (guard instanceof EqualityTerm) {
      return _getRight((EqualityTerm)guard);
    } else if (guard instanceof NotTerm) {
      return _getRight((NotTerm)guard);
    } else if (guard instanceof OrTerm) {
      return _getRight((OrTerm)guard);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(guard).toString());
    }
  }
  
  public static Atom getAtom(final Guard guard) {
    if (guard instanceof AndTerm) {
      return _getAtom((AndTerm)guard);
    } else if (guard instanceof EqualityTerm) {
      return _getAtom((EqualityTerm)guard);
    } else if (guard instanceof NotTerm) {
      return _getAtom((NotTerm)guard);
    } else if (guard instanceof OrTerm) {
      return _getAtom((OrTerm)guard);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(guard).toString());
    }
  }
}
