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
import com.google.common.collect.Iterables;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.validation.HelenaTextValidator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class RoleTypeValidator extends AbstractDeclarativeValidator {
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  /**
   * Checks if a role behavior exists for every role type
   */
  @Check
  public void check_roleType_roleBehaviorExists(final RoleType rt) {
    Resource _eResource = rt.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<RoleBehavior> allRBs = Iterables.<RoleBehavior>filter(_iterable, RoleBehavior.class);
    for (final RoleBehavior rb : allRBs) {
      RoleType _roleTypeRef = rb.getRoleTypeRef();
      String _name = _roleTypeRef.getName();
      String _name_1 = rt.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      if (_equals) {
        return;
      }
    }
    String _name_2 = rt.getName();
    String _plus = ("No role behavior exists for role type " + _name_2);
    this.error(_plus, 
      HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME, 
      HelenaTextValidator.MISSING_CONNECTION);
  }
}
