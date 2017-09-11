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
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.AbstractDataValue;
import eu.ascens.helenaText.AbstractDataVariableReference;
import eu.ascens.helenaText.Addition;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAssociationTypeReference;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentAttributeTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.RoleAttributeTypeReference;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleInstanceVariable;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.Subtraction;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class OperationCallGenerator {
  @Inject
  private NameGenerator nameGenerator;
  
  /**
   * Retrieves the value for a given expression from the owner (if necessary)
   */
  protected static CharSequence _retrieveDataValueFromOwner(final Addition param) {
    CharSequence _xblockexpression = null;
    {
      DataExpression _left = param.getLeft();
      OperationCallGenerator.retrieveDataValueFromOwner(_left);
      DataExpression _right = param.getRight();
      _xblockexpression = OperationCallGenerator.retrieveDataValueFromOwner(_right);
    }
    return _xblockexpression;
  }
  
  protected static CharSequence _retrieveDataValueFromOwner(final Subtraction param) {
    CharSequence _xblockexpression = null;
    {
      DataExpression _left = param.getLeft();
      OperationCallGenerator.retrieveDataValueFromOwner(_left);
      DataExpression _right = param.getRight();
      _xblockexpression = OperationCallGenerator.retrieveDataValueFromOwner(_right);
    }
    return _xblockexpression;
  }
  
  protected static CharSequence _retrieveDataValueFromOwner(final AbstractDataVariableReference param) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected static CharSequence _retrieveDataValueFromOwner(final RoleAttributeTypeReference param) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected static CharSequence _retrieveDataValueFromOwner(final ComponentAttributeTypeReference param) {
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(param);
    RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
    ComponentType _ownerComponentType = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
    ComponentAttributeType _ref = param.getRef();
    return OperationCallGenerator.compileGetterOperationCall(_ownerComponentType, _ref);
  }
  
  protected static CharSequence _retrieveDataValueFromOwner(final AbstractDataValue value) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  /**
   * Retrieves the channel to a component instance from the owner (if necessary)
   */
  protected static CharSequence _retrieveCompInstanceFromOwner(final OwnerReference ref) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected static CharSequence _retrieveCompInstanceFromOwner(final ComponentAssociationTypeReference association) {
    StringConcatenation _builder = new StringConcatenation();
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(association);
    RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
    ComponentType _ownerComponentType = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
    CharSequence _compileGetterOperationCall = OperationCallGenerator.compileGetterOperationCall(_ownerComponentType, association);
    _builder.append(_compileGetterOperationCall, "");
    _builder.append(";");
    return _builder;
  }
  
  /**
   * Compiles the operation call to the owner to retrieve the owner's attribute value
   */
  public static CharSequence compileGetterOperationCall(final ComponentType owner, final ComponentAttributeType attr) {
    StringConcatenation _builder = new StringConcatenation();
    String _getterName = NameGenerator.getGetterName(owner, attr);
    _builder.append(_getterName, "");
    _builder.append("(owner,");
    String _variableName = NameGenerator.getVariableName(attr);
    _builder.append(_variableName, "");
    _builder.append(");");
    return _builder;
  }
  
  /**
   * Compiles the operation call to the owner to retrieve the owner's attribute value
   */
  public CharSequence compileSetterOperationCall(final ComponentType owner, final ComponentAttributeType attr, final DataExpression value) {
    StringConcatenation _builder = new StringConcatenation();
    String _setterName = NameGenerator.getSetterName(owner, attr);
    _builder.append(_setterName, "");
    _builder.append("(owner,");
    String _dataValue = this.nameGenerator.getDataValue(value);
    _builder.append(_dataValue, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * Compiles the operation call to call the given operation of the owner (with result type)
   */
  public CharSequence compileOperationCall(final ComponentType owner, final OperationType op, final DataVariable result, final DataExpression... params) {
    StringConcatenation _builder = new StringConcatenation();
    String _operationCall = NameGenerator.getOperationCall(owner, op);
    _builder.append(_operationCall, "");
    _builder.append("(owner");
    {
      boolean _hasElements = false;
      for(final DataExpression param : params) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(",", "");
        } else {
          _builder.appendImmediate(",", "");
        }
        String _dataValue = this.nameGenerator.getDataValue(param);
        _builder.append(_dataValue, "");
      }
    }
    {
      boolean _notEquals = (!Objects.equal(result, null));
      if (_notEquals) {
        _builder.append(",");
        String _varName = NameGenerator.getVarName(result);
        _builder.append(_varName, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  /**
   * Compiles the operation call to call the given operation of the owner
   */
  public CharSequence compileOperationCall(final ComponentType owner, final OperationType op, final DataExpression... params) {
    return this.compileOperationCall(owner, op, null, params);
  }
  
  /**
   * Compiles the operation call to the owner to retrieve the owner's association value
   */
  public static CharSequence compileGetterOperationCall(final ComponentType owner, final ComponentAssociationTypeReference association) {
    StringConcatenation _builder = new StringConcatenation();
    String _retrieveAssociation = NameGenerator.getRetrieveAssociation(owner);
    _builder.append(_retrieveAssociation, "");
    _builder.append("(");
    ComponentAssociationType _ref = association.getRef();
    String _getterCompOperationName = NameGenerator.getGetterCompOperationName(_ref);
    _builder.append(_getterCompOperationName, "");
    _builder.append(",owner,");
    String _compInstanceName = NameGenerator.getCompInstanceName(association);
    _builder.append(_compInstanceName, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * Compiles the operation call whether a given target component is playing a given role
   */
  public static CharSequence compileOperationCall(final ComponentType target, final PlaysQuery query) {
    StringConcatenation _builder = new StringConcatenation();
    String _isPlaying = NameGenerator.getIsPlaying(target);
    _builder.append(_isPlaying, "");
    _builder.append("(");
    RoleType _roleTypeRef = query.getRoleTypeRef();
    String _compOperationNameForPlays = NameGenerator.getCompOperationNameForPlays(_roleTypeRef);
    _builder.append(_compOperationNameForPlays, "");
    _builder.append(",");
    ComponentInstance _compInstance = query.getCompInstance();
    String _compInstanceName = NameGenerator.getCompInstanceName(_compInstance);
    _builder.append(_compInstanceName, "");
    _builder.append(",");
    String _variableName = NameGenerator.getVariableName(query);
    _builder.append(_variableName, "");
    _builder.append(")");
    return _builder;
  }
  
  /**
   * Compiles the operation call to create or get the given role from the given target component
   */
  public static CharSequence compileOperationCall(final ComponentType target, final AbstractAssignment call) {
    StringConcatenation _builder = new StringConcatenation();
    String _retrieveRole = NameGenerator.getRetrieveRole(target);
    _builder.append(_retrieveRole, "");
    _builder.append("(");
    String _compOperationNameForAssignment = NameGenerator.getCompOperationNameForAssignment(call);
    _builder.append(_compOperationNameForAssignment, "");
    _builder.append(",");
    ComponentInstance _compInstance = call.getCompInstance();
    String _compInstanceName = NameGenerator.getCompInstanceName(_compInstance);
    _builder.append(_compInstanceName, "");
    _builder.append(",");
    RoleInstanceVariable _roleInst = call.getRoleInst();
    String _variableName = NameGenerator.getVariableName(_roleInst);
    _builder.append(_variableName, "");
    _builder.append(")");
    return _builder;
  }
  
  public static CharSequence retrieveDataValueFromOwner(final DataExpression param) {
    if (param instanceof AbstractDataVariableReference) {
      return _retrieveDataValueFromOwner((AbstractDataVariableReference)param);
    } else if (param instanceof ComponentAttributeTypeReference) {
      return _retrieveDataValueFromOwner((ComponentAttributeTypeReference)param);
    } else if (param instanceof RoleAttributeTypeReference) {
      return _retrieveDataValueFromOwner((RoleAttributeTypeReference)param);
    } else if (param instanceof AbstractDataValue) {
      return _retrieveDataValueFromOwner((AbstractDataValue)param);
    } else if (param instanceof Addition) {
      return _retrieveDataValueFromOwner((Addition)param);
    } else if (param instanceof Subtraction) {
      return _retrieveDataValueFromOwner((Subtraction)param);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(param).toString());
    }
  }
  
  public static CharSequence retrieveCompInstanceFromOwner(final ComponentInstance association) {
    if (association instanceof ComponentAssociationTypeReference) {
      return _retrieveCompInstanceFromOwner((ComponentAssociationTypeReference)association);
    } else if (association instanceof OwnerReference) {
      return _retrieveCompInstanceFromOwner((OwnerReference)association);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(association).toString());
    }
  }
}
