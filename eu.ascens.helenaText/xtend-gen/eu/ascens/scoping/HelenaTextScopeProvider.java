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
package eu.ascens.scoping;

import com.google.common.collect.Iterables;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it
 */
@SuppressWarnings("all")
public class HelenaTextScopeProvider extends AbstractDeclarativeScopeProvider {
  /**
   * Only role instances declared in the same role behavior are visible
   */
  public IScope scope_AbstractRoleInstanceReference_ref(final RoleBehavior rb, final EReference ref) {
    Collection<AbstractRoleInstance> _abstractRoleInstances = ExtensionMethods_RoleBehavior.getAbstractRoleInstances(rb);
    return Scopes.scopeFor(_abstractRoleInstances);
  }
  
  /**
   * Only data instances declared in the same role behavior are visible
   */
  public IScope scope_AbstractDataVariableReference_ref(final RoleBehavior rb, final EReference ref) {
    TreeIterator<EObject> _eAllContents = rb.eAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      @Override
      public Boolean apply(final EObject elem) {
        return Boolean.valueOf((elem instanceof AbstractDataVariable));
      }
    };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_iterable, _function);
    List<EObject> _list = IterableExtensions.<EObject>toList(_filter);
    return Scopes.scopeFor(_list);
  }
  
  /**
   * Only role attribute types from the corresponding role type can be referenced
   */
  public IScope scope_RoleAttributeTypeReference_ref(final RoleBehavior rb, final EReference ref) {
    RoleType _roleTypeRef = rb.getRoleTypeRef();
    EList<RoleAttributeType> _roleattrs = _roleTypeRef.getRoleattrs();
    return Scopes.scopeFor(_roleattrs);
  }
  
  /**
   * Only component attribute types from the corresponding component type can be referenced
   */
  public IScope scope_ComponentAttributeTypeReference_ref(final RoleBehavior rb, final EReference ref) {
    RoleType _roleTypeRef = rb.getRoleTypeRef();
    EList<ComponentType> _compTypes = _roleTypeRef.getCompTypes();
    final Function1<ComponentType, EList<ComponentAttributeType>> _function = new Function1<ComponentType, EList<ComponentAttributeType>>() {
      @Override
      public EList<ComponentAttributeType> apply(final ComponentType ct) {
        return ct.getAttrs();
      }
    };
    List<EList<ComponentAttributeType>> _map = ListExtensions.<ComponentType, EList<ComponentAttributeType>>map(_compTypes, _function);
    Iterable<ComponentAttributeType> _flatten = Iterables.<ComponentAttributeType>concat(_map);
    return Scopes.scopeFor(_flatten);
  }
  
  /**
   * Only component association types from the corresponding component type can be referenced
   */
  public IScope scope_ComponentAssociationTypeReference_ref(final RoleBehavior rb, final EReference ref) {
    RoleType _roleTypeRef = rb.getRoleTypeRef();
    EList<ComponentType> _compTypes = _roleTypeRef.getCompTypes();
    final Function1<ComponentType, EList<ComponentAssociationType>> _function = new Function1<ComponentType, EList<ComponentAssociationType>>() {
      @Override
      public EList<ComponentAssociationType> apply(final ComponentType ct) {
        return ct.getAssocs();
      }
    };
    List<EList<ComponentAssociationType>> _map = ListExtensions.<ComponentType, EList<ComponentAssociationType>>map(_compTypes, _function);
    Iterable<ComponentAssociationType> _flatten = Iterables.<ComponentAssociationType>concat(_map);
    return Scopes.scopeFor(_flatten);
  }
}
