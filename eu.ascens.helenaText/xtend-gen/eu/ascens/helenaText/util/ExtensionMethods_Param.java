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

import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.AbstractDataReference;
import eu.ascens.helenaText.AbstractDataValue;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractDataVariableReference;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.AbstractRoleInstanceReference;
import eu.ascens.helenaText.Addition;
import eu.ascens.helenaText.BooleanValue;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAssociationTypeReference;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentAttributeTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.NumberValue;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleAttributeTypeReference;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleInstanceReference;
import eu.ascens.helenaText.RoleInstanceVariable;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.SelfReference;
import eu.ascens.helenaText.StringValue;
import eu.ascens.helenaText.Subtraction;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import eu.ascens.helenaText.util.JvmTypesHelper;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;

@SuppressWarnings("all")
public class ExtensionMethods_Param {
  /**
   * Returns the component type of a component instance
   */
  protected static ComponentType _getComponentType(final ComponentAssociationTypeReference association) {
    ComponentAssociationType _ref = association.getRef();
    return _ref.getType();
  }
  
  protected static ComponentType _getComponentType(final OwnerReference reference) {
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(reference);
    RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
    return ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
  }
  
  /**
   * Returns the type for a role instance reference via the parent role behavior
   * @null if type cannot be detected
   */
  protected static RoleType _getRoleTypeForRef(final AbstractRoleInstanceReference reference) {
    AbstractRoleInstance _ref = reference.getRef();
    return ExtensionMethods_Param.getRoleType(_ref);
  }
  
  protected static RoleType _getRoleTypeForRef(final SelfReference reference) {
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(reference);
    return _parentRoleBehavior.getRoleTypeRef();
  }
  
  /**
   * Returns the role type of a role instance variable
   */
  protected static RoleType _getRoleType(final RoleInstanceVariable variable) {
    EObject container = variable.eContainer();
    while ((!(container instanceof AbstractAssignment))) {
      EObject _eContainer = container.eContainer();
      container = _eContainer;
    }
    AbstractAssignment call = ((AbstractAssignment) container);
    return call.getRoleTypeRef();
  }
  
  protected static RoleType _getRoleType(final FormalRoleParam param) {
    return param.getType();
  }
  
  protected static RoleType _getRoleType(final AbstractRoleInstance param) {
    return null;
  }
  
  protected static JvmType _getWrappedJvmType(final Addition exp) {
    DataExpression _left = exp.getLeft();
    return ExtensionMethods_Param.getWrappedJvmType(_left);
  }
  
  protected static JvmType _getWrappedJvmType(final Subtraction exp) {
    DataExpression _left = exp.getLeft();
    return ExtensionMethods_Param.getWrappedJvmType(_left);
  }
  
  protected static JvmType _getWrappedJvmType(final AbstractDataReference dataRef) {
    JvmType _jvmTypeForAbstrDataRef = ExtensionMethods_Param.getJvmTypeForAbstrDataRef(dataRef);
    return JvmTypesHelper.getWrappedType(_jvmTypeForAbstrDataRef);
  }
  
  protected static JvmType _getWrappedJvmType(final AbstractDataValue dataValue) {
    return ExtensionMethods_Param.getWrappedJvmTypeFromValue(dataValue);
  }
  
  protected static JvmType _getWrappedJvmTypeFromValue(final StringValue stringValue) {
    String _simpleName = String.class.getSimpleName();
    return JvmTypesHelper.createJvmType(_simpleName);
  }
  
  protected static JvmType _getWrappedJvmTypeFromValue(final BooleanValue booleanValue) {
    String _simpleName = Boolean.class.getSimpleName();
    return JvmTypesHelper.createJvmType(_simpleName);
  }
  
  protected static JvmType _getWrappedJvmTypeFromValue(final NumberValue numberValue) {
    XExpression _value = numberValue.getValue();
    String value = ((XNumberLiteral) _value).getValue();
    boolean _contains = value.contains(".");
    if (_contains) {
      String _simpleName = Double.class.getSimpleName();
      return JvmTypesHelper.createJvmType(_simpleName);
    } else {
      String _simpleName_1 = Integer.class.getSimpleName();
      return JvmTypesHelper.createJvmType(_simpleName_1);
    }
  }
  
  /**
   * Returns the type for a data expression via the parent role behavior
   * @null if type cannot be detected
   */
  private static JvmType _getJvmTypeForAbstrDataRef(final AbstractDataVariableReference reference) {
    AbstractDataVariable _ref = reference.getRef();
    JvmTypeReference _jvmTypeRefFromAbstrDataVar = ExtensionMethods_Param.getJvmTypeRefFromAbstrDataVar(_ref);
    return _jvmTypeRefFromAbstrDataVar.getType();
  }
  
  private static JvmType _getJvmTypeForAbstrDataRef(final RoleAttributeTypeReference reference) {
    RoleAttributeType _ref = reference.getRef();
    JvmTypeReference _type = _ref.getType();
    return _type.getType();
  }
  
  private static JvmType _getJvmTypeForAbstrDataRef(final ComponentAttributeTypeReference reference) {
    ComponentAttributeType _ref = reference.getRef();
    JvmTypeReference _type = _ref.getType();
    return _type.getType();
  }
  
  /**
   * Returns the jvm type of a data variable
   */
  protected static JvmTypeReference _getJvmTypeRefFromAbstrDataVar(final DataVariable variable) {
    EObject container = variable.eContainer();
    while ((!(container instanceof OperationCall))) {
      EObject _eContainer = container.eContainer();
      container = _eContainer;
    }
    OperationCall call = ((OperationCall) container);
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(variable);
    RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
    ComponentType owner = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
    EList<OperationType> _ops = owner.getOps();
    for (final OperationType op : _ops) {
      String _name = op.getName();
      String _opName = call.getOpName();
      boolean _equals = _name.equals(_opName);
      if (_equals) {
        return op.getReturnType();
      }
    }
    return null;
  }
  
  protected static JvmTypeReference _getJvmTypeRefFromAbstrDataVar(final FormalDataParam param) {
    return param.getType();
  }
  
  protected static JvmTypeReference _getJvmTypeRefFromAbstrDataVar(final AbstractDataVariable dataVar) {
    return null;
  }
  
  public static ComponentType getComponentType(final ComponentInstance association) {
    if (association instanceof ComponentAssociationTypeReference) {
      return _getComponentType((ComponentAssociationTypeReference)association);
    } else if (association instanceof OwnerReference) {
      return _getComponentType((OwnerReference)association);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(association).toString());
    }
  }
  
  public static RoleType getRoleTypeForRef(final RoleInstanceReference reference) {
    if (reference instanceof AbstractRoleInstanceReference) {
      return _getRoleTypeForRef((AbstractRoleInstanceReference)reference);
    } else if (reference instanceof SelfReference) {
      return _getRoleTypeForRef((SelfReference)reference);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference).toString());
    }
  }
  
  public static RoleType getRoleType(final AbstractRoleInstance param) {
    if (param instanceof FormalRoleParam) {
      return _getRoleType((FormalRoleParam)param);
    } else if (param instanceof RoleInstanceVariable) {
      return _getRoleType((RoleInstanceVariable)param);
    } else if (param != null) {
      return _getRoleType(param);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(param).toString());
    }
  }
  
  public static JvmType getWrappedJvmType(final DataExpression dataRef) {
    if (dataRef instanceof AbstractDataReference) {
      return _getWrappedJvmType((AbstractDataReference)dataRef);
    } else if (dataRef instanceof AbstractDataValue) {
      return _getWrappedJvmType((AbstractDataValue)dataRef);
    } else if (dataRef instanceof Addition) {
      return _getWrappedJvmType((Addition)dataRef);
    } else if (dataRef instanceof Subtraction) {
      return _getWrappedJvmType((Subtraction)dataRef);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dataRef).toString());
    }
  }
  
  public static JvmType getWrappedJvmTypeFromValue(final AbstractDataValue booleanValue) {
    if (booleanValue instanceof BooleanValue) {
      return _getWrappedJvmTypeFromValue((BooleanValue)booleanValue);
    } else if (booleanValue instanceof NumberValue) {
      return _getWrappedJvmTypeFromValue((NumberValue)booleanValue);
    } else if (booleanValue instanceof StringValue) {
      return _getWrappedJvmTypeFromValue((StringValue)booleanValue);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(booleanValue).toString());
    }
  }
  
  private static JvmType getJvmTypeForAbstrDataRef(final AbstractDataReference reference) {
    if (reference instanceof AbstractDataVariableReference) {
      return _getJvmTypeForAbstrDataRef((AbstractDataVariableReference)reference);
    } else if (reference instanceof ComponentAttributeTypeReference) {
      return _getJvmTypeForAbstrDataRef((ComponentAttributeTypeReference)reference);
    } else if (reference instanceof RoleAttributeTypeReference) {
      return _getJvmTypeForAbstrDataRef((RoleAttributeTypeReference)reference);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference).toString());
    }
  }
  
  public static JvmTypeReference getJvmTypeRefFromAbstrDataVar(final AbstractDataVariable variable) {
    if (variable instanceof DataVariable) {
      return _getJvmTypeRefFromAbstrDataVar((DataVariable)variable);
    } else if (variable instanceof FormalDataParam) {
      return _getJvmTypeRefFromAbstrDataVar((FormalDataParam)variable);
    } else if (variable != null) {
      return _getJvmTypeRefFromAbstrDataVar(variable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(variable).toString());
    }
  }
}
