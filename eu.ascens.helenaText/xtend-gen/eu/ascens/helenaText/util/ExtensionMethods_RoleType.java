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
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAssociationTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.MsgDirection;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleInstanceVariable;
import eu.ascens.helenaText.RoleType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ExtensionMethods_RoleType {
  /**
   * Returns type of the owner
   */
  public static ComponentType getOwnerComponentType(final RoleType rt) {
    EList<ComponentType> _compTypes = rt.getCompTypes();
    return _compTypes.get(0);
  }
  
  /**
   * Returns whether the type of the given component instance is allowed as owner of the given role type
   */
  protected static boolean _isAllowedAsOwnerType(final ComponentAssociationTypeReference reference, final RoleType rt) {
    ComponentAssociationType _ref = reference.getRef();
    boolean _notEquals = (!Objects.equal(_ref, null));
    if (_notEquals) {
      EList<ComponentType> _compTypes = rt.getCompTypes();
      ComponentAssociationType _ref_1 = reference.getRef();
      ComponentType _type = _ref_1.getType();
      return _compTypes.contains(_type);
    } else {
      return false;
    }
  }
  
  protected static boolean _isAllowedAsOwnerType(final OwnerReference reference, final RoleType rt) {
    return true;
  }
  
  /**
   * Returns the state machine role behavior for a role type
   */
  public static RoleBehavior getRoleBehavior(final RoleType rt) {
    EObject container = rt.eContainer();
    while ((!(container instanceof Model))) {
      EObject _eContainer = container.eContainer();
      container = _eContainer;
    }
    Model model = ((Model) container);
    PackageDeclaration _headPkg = model.getHeadPkg();
    EList<RoleBehavior> _roleBehaviors = _headPkg.getRoleBehaviors();
    final Function1<RoleBehavior, Boolean> _function = new Function1<RoleBehavior, Boolean>() {
      @Override
      public Boolean apply(final RoleBehavior it) {
        RoleType _roleTypeRef = it.getRoleTypeRef();
        return Boolean.valueOf(Objects.equal(_roleTypeRef, rt));
      }
    };
    return IterableExtensions.<RoleBehavior>findFirst(_roleBehaviors, _function);
  }
  
  /**
   * Returns the role type of a role instance variable
   */
  public static RoleType getRoleType(final RoleInstanceVariable inst) {
    EObject container = inst.eContainer();
    while ((!(container instanceof AbstractAssignment))) {
      EObject _eContainer = container.eContainer();
      container = _eContainer;
    }
    AbstractAssignment assignment = ((AbstractAssignment) container);
    return assignment.getRoleTypeRef();
  }
  
  /**
   * Returns the role message of a role type with name 'name'; null otherwise
   */
  public static MessageType getRoleMsg(final RoleType rt, final String name) {
    EList<MessageType> _rolemsgs = rt.getRolemsgs();
    final Function1<MessageType, Boolean> _function = new Function1<MessageType, Boolean>() {
      @Override
      public Boolean apply(final MessageType it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<MessageType>findFirst(_rolemsgs, _function);
  }
  
  /**
   * Returns a list of all role messages of a role type
   * with the given msg direction (caution: in/out matches in resp. out)
   */
  public static Iterable<MessageType> getAllMessagesOfDirection(final RoleType rt, final MsgDirection msgDirection) {
    EList<MessageType> _rolemsgs = rt.getRolemsgs();
    final Function1<MessageType, Boolean> _function = new Function1<MessageType, Boolean>() {
      @Override
      public Boolean apply(final MessageType msg) {
        MsgDirection _direction = msg.getDirection();
        return Boolean.valueOf(ExtensionMethods_RoleType.ofSameMsgDirection(_direction, msgDirection));
      }
    };
    return IterableExtensions.<MessageType>filter(_rolemsgs, _function);
  }
  
  /**
   * Returns true if two messages are of the same type
   * (both in, both out, both in/out, one in/out and one in or out)
   */
  private static boolean ofSameMsgDirection(final MsgDirection msgType1, final MsgDirection msgType2) {
    return ((msgType1.equals(msgType2) || ((msgType1.equals(MsgDirection.IN) || msgType1.equals(MsgDirection.OUT)) && msgType2.equals(MsgDirection.INOUT))) || ((msgType2.equals(MsgDirection.IN) || msgType2.equals(MsgDirection.OUT)) && msgType1.equals(MsgDirection.INOUT)));
  }
  
  /**
   * Returns the set of all messages in the model
   * not taking care of parameters!! or direction!!
   */
  public static Iterable<MessageType> getAllMessagesInModel(final Model model) {
    Set<MessageType> messages = new HashSet<MessageType>();
    Set<String> names = new HashSet<String>();
    PackageDeclaration _headPkg = model.getHeadPkg();
    EList<RoleType> _roleTypes = _headPkg.getRoleTypes();
    for (final RoleType rt : _roleTypes) {
      EList<MessageType> _rolemsgs = rt.getRolemsgs();
      for (final MessageType msg : _rolemsgs) {
        String _name = msg.getName();
        boolean _contains = names.contains(_name);
        boolean _not = (!_contains);
        if (_not) {
          String _name_1 = msg.getName();
          names.add(_name_1);
          messages.add(msg);
        }
      }
    }
    return messages;
  }
  
  public static boolean isAllowedAsOwnerType(final ComponentInstance reference, final RoleType rt) {
    if (reference instanceof ComponentAssociationTypeReference) {
      return _isAllowedAsOwnerType((ComponentAssociationTypeReference)reference, rt);
    } else if (reference instanceof OwnerReference) {
      return _isAllowedAsOwnerType((OwnerReference)reference, rt);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference, rt).toString());
    }
  }
}
