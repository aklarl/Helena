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
import eu.ascens.generator.promela.TypesGenerator;
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.AbstractDataValue;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractDataVariableReference;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.AbstractRoleInstanceReference;
import eu.ascens.helenaText.Addition;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAssociationTypeReference;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentAttributeTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.CreateAssignment;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.GetAssignment;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.ProcessExpression;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleAttributeTypeReference;
import eu.ascens.helenaText.RoleInstanceReference;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.SelfReference;
import eu.ascens.helenaText.Subtraction;
import java.util.Arrays;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class NameGenerator {
  @Inject
  private TypesGenerator typeGen;
  
  public static String getIfGotoLabel(final ProcessExpression term) {
    int _hashCode = term.hashCode();
    return ("label" + Integer.valueOf(_hashCode));
  }
  
  public static String getOperationTypeName(final ComponentType ct) {
    String _name = ct.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return (_firstUpper + "Operation");
  }
  
  public static String getProctypeName(final ComponentType ct) {
    String _name = ct.getName();
    return StringExtensions.toFirstUpper(_name);
  }
  
  public static String getStartLabelName(final ComponentType ct) {
    String _name = ct.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return ("start" + _firstUpper);
  }
  
  private static String getInlinePrefix(final ComponentType ct) {
    String _name = ct.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return (_firstLower + "_");
  }
  
  public static String getRetrieveRole(final ComponentType ct) {
    String _inlinePrefix = NameGenerator.getInlinePrefix(ct);
    return (_inlinePrefix + "retrieveRole");
  }
  
  public static String getQuitRole(final ComponentType ct) {
    String _inlinePrefix = NameGenerator.getInlinePrefix(ct);
    return (_inlinePrefix + "quitRole");
  }
  
  public static String getIsPlaying(final ComponentType ct) {
    String _inlinePrefix = NameGenerator.getInlinePrefix(ct);
    return (_inlinePrefix + "isPlaying");
  }
  
  public static String getRetrieveAssociation(final ComponentType ct) {
    String _inlinePrefix = NameGenerator.getInlinePrefix(ct);
    return (_inlinePrefix + "retrieveAssociation");
  }
  
  public static String getOperationCall(final ComponentType ct, final OperationType op) {
    String _inlinePrefix = NameGenerator.getInlinePrefix(ct);
    String _plus = (_inlinePrefix + "call");
    String _name = op.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return (_plus + _firstUpper);
  }
  
  public static String getGetterCompOperationName(final ComponentAttributeType at) {
    String _name = at.getName();
    String _upperCase = _name.toUpperCase();
    return ("GET_" + _upperCase);
  }
  
  public static String getSetterCompOperationName(final ComponentAttributeType at) {
    String _name = at.getName();
    String _upperCase = _name.toUpperCase();
    return ("SET_" + _upperCase);
  }
  
  public static String getGetterName(final ComponentType ct, final ComponentAttributeType at) {
    String _inlinePrefix = NameGenerator.getInlinePrefix(ct);
    String _plus = (_inlinePrefix + "get");
    String _name = at.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return (_plus + _firstUpper);
  }
  
  public static String getSetterName(final ComponentType ct, final ComponentAttributeType at) {
    String _inlinePrefix = NameGenerator.getInlinePrefix(ct);
    String _plus = (_inlinePrefix + "set");
    String _name = at.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return (_plus + _firstUpper);
  }
  
  public static String getCompProctypeParamName(final ComponentAttributeType at) {
    String _name = at.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  public static String getVariableName(final ComponentAttributeType at) {
    String _name = at.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return ("compAttr_" + _firstLower);
  }
  
  public static String getGetterCompOperationName(final ComponentAssociationType at) {
    String _name = at.getName();
    String _upperCase = _name.toUpperCase();
    return ("GET_" + _upperCase);
  }
  
  public static String getCompProctypeParamName(final ComponentAssociationType at) {
    String _name = at.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  public static String getVariableName(final ComponentAssociationType assoc) {
    String _name = assoc.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return ("compAssoc_" + _firstLower);
  }
  
  public static String getOperationCompOperationName(final OperationType op) {
    String _name = op.getName();
    String _upperCase = _name.toUpperCase();
    return ("OP_" + _upperCase);
  }
  
  protected static String _getCompOperationNameForAssignment(final GetAssignment call) {
    RoleType _roleTypeRef = call.getRoleTypeRef();
    return NameGenerator.getCompOperationNameForGet(_roleTypeRef);
  }
  
  protected static String _getCompOperationNameForAssignment(final CreateAssignment call) {
    RoleType _roleTypeRef = call.getRoleTypeRef();
    return NameGenerator.getCompOperationNameForCreate(_roleTypeRef);
  }
  
  public static String getVariableName(final RoleAttributeType at) {
    String _name = at.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return ("roleAttr_" + _firstLower);
  }
  
  public static String getMinName(final RoleType rt) {
    String _name = rt.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return ("min" + _firstUpper);
  }
  
  public static String getMaxName(final RoleType rt) {
    String _name = rt.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return ("max" + _firstUpper);
  }
  
  public static String getCurrentName(final RoleType rt) {
    String _name = rt.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return ("current" + _firstUpper);
  }
  
  public static String getChanName(final RoleType rt) {
    String _name = rt.getName();
    return _name.toLowerCase();
  }
  
  public static String getCompOperationNameForCreate(final RoleType rt) {
    String _name = rt.getName();
    String _upperCase = _name.toUpperCase();
    return ("CREATE_" + _upperCase);
  }
  
  public static String getCompOperationNameForGet(final RoleType rt) {
    String _name = rt.getName();
    String _upperCase = _name.toUpperCase();
    return ("GET_" + _upperCase);
  }
  
  public static String getCompOperationNameForQuit(final RoleType rt) {
    String _name = rt.getName();
    String _upperCase = _name.toUpperCase();
    return ("QUIT_" + _upperCase);
  }
  
  public static String getCompOperationNameForPlays(final RoleType rt) {
    String _name = rt.getName();
    String _upperCase = _name.toUpperCase();
    return ("PLAYS_" + _upperCase);
  }
  
  public static String getVariableNameForPlays(final RoleType rt) {
    String _name = rt.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return ("plays" + _firstUpper);
  }
  
  public static String getProctypeName(final RoleType ct) {
    String _name = ct.getName();
    return StringExtensions.toFirstUpper(_name);
  }
  
  public static String getStartLabelName(final RoleType ct) {
    String _name = ct.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return ("start" + _firstUpper);
  }
  
  public static String getEndLabelName(final RoleType ct) {
    String _name = ct.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return ("end" + _firstUpper);
  }
  
  public static String getPromelaType(final JvmTypeReference type) {
    JvmType _type = type.getType();
    String _simpleName = _type.getSimpleName();
    switch (_simpleName) {
      case "byte":
        return "byte";
      case "short":
        return "short";
      case "int":
        return "int";
      case "boolean":
        return "bool";
      default:
        JvmType _type_1 = type.getType();
        return _type_1.getSimpleName();
    }
  }
  
  public static String getMsgName(final MessageType msg) {
    String _name = msg.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  public static String getVariableName(final MessageType msg) {
    String _name = msg.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return (_firstLower + "Msg");
  }
  
  public static String getSndMsgHelperName(final MessageType msg) {
    String _name = msg.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return ("send_" + _firstLower);
  }
  
  public static String getRcvMsgHelperName(final MessageType msg) {
    String _name = msg.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return ("receive_" + _firstLower);
  }
  
  public static String getLabel(final eu.ascens.helenaText.Process process) {
    String _name = process.getName();
    return ("process" + _name);
  }
  
  protected static String _getCompInstanceName(final OwnerReference reference) {
    return "owner";
  }
  
  protected static String _getCompInstanceName(final ComponentAssociationTypeReference reference) {
    ComponentAssociationType _ref = reference.getRef();
    return NameGenerator.getVariableName(_ref);
  }
  
  public static String getVariableName(final PlaysQuery query) {
    ComponentInstance _compInstance = query.getCompInstance();
    String _compInstanceName = NameGenerator.getCompInstanceName(_compInstance);
    String _plus = (_compInstanceName + "Plays");
    RoleType _roleTypeRef = query.getRoleTypeRef();
    String _name = _roleTypeRef.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return (_plus + _firstUpper);
  }
  
  public static String getVariableName(final AbstractRoleInstance param) {
    String _name = param.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  protected static String _getVarName(final FormalDataParam param) {
    String _name = param.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  protected static String _getVarName(final DataVariable param) {
    String _name = param.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  protected static String _getRoleInstance(final SelfReference param) {
    return "self";
  }
  
  protected static String _getRoleInstance(final AbstractRoleInstanceReference param) {
    AbstractRoleInstance _ref = param.getRef();
    return NameGenerator.getVariableName(_ref);
  }
  
  protected String _getDataValue(final Addition exp) {
    DataExpression _left = exp.getLeft();
    String _dataValue = this.getDataValue(_left);
    String _operator = exp.getOperator();
    String _plus = (_dataValue + _operator);
    DataExpression _right = exp.getRight();
    String _dataValue_1 = this.getDataValue(_right);
    return (_plus + _dataValue_1);
  }
  
  protected String _getDataValue(final Subtraction exp) {
    DataExpression _left = exp.getLeft();
    String _dataValue = this.getDataValue(_left);
    String _operator = exp.getOperator();
    String _plus = (_dataValue + _operator);
    DataExpression _right = exp.getRight();
    String _dataValue_1 = this.getDataValue(_right);
    return (_plus + _dataValue_1);
  }
  
  protected String _getDataValue(final AbstractDataVariableReference param) {
    AbstractDataVariable _ref = param.getRef();
    return NameGenerator.getVarName(_ref);
  }
  
  protected String _getDataValue(final RoleAttributeTypeReference param) {
    RoleAttributeType _ref = param.getRef();
    return NameGenerator.getVariableName(_ref);
  }
  
  protected String _getDataValue(final ComponentAttributeTypeReference param) {
    ComponentAttributeType _ref = param.getRef();
    return NameGenerator.getVariableName(_ref);
  }
  
  protected String _getDataValue(final AbstractDataValue param) {
    XExpression _value = param.getValue();
    return this.typeGen.getValueFromXExpression(_value);
  }
  
  public static String getLabelName(final Label label) {
    String _name = label.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  public static String getCompOperationNameForAssignment(final AbstractAssignment call) {
    if (call instanceof CreateAssignment) {
      return _getCompOperationNameForAssignment((CreateAssignment)call);
    } else if (call instanceof GetAssignment) {
      return _getCompOperationNameForAssignment((GetAssignment)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
  
  public static String getCompInstanceName(final ComponentInstance reference) {
    if (reference instanceof ComponentAssociationTypeReference) {
      return _getCompInstanceName((ComponentAssociationTypeReference)reference);
    } else if (reference instanceof OwnerReference) {
      return _getCompInstanceName((OwnerReference)reference);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference).toString());
    }
  }
  
  public static String getVarName(final AbstractDataVariable param) {
    if (param instanceof DataVariable) {
      return _getVarName((DataVariable)param);
    } else if (param instanceof FormalDataParam) {
      return _getVarName((FormalDataParam)param);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(param).toString());
    }
  }
  
  public static String getRoleInstance(final RoleInstanceReference param) {
    if (param instanceof AbstractRoleInstanceReference) {
      return _getRoleInstance((AbstractRoleInstanceReference)param);
    } else if (param instanceof SelfReference) {
      return _getRoleInstance((SelfReference)param);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(param).toString());
    }
  }
  
  public String getDataValue(final DataExpression param) {
    if (param instanceof AbstractDataVariableReference) {
      return _getDataValue((AbstractDataVariableReference)param);
    } else if (param instanceof ComponentAttributeTypeReference) {
      return _getDataValue((ComponentAttributeTypeReference)param);
    } else if (param instanceof RoleAttributeTypeReference) {
      return _getDataValue((RoleAttributeTypeReference)param);
    } else if (param instanceof AbstractDataValue) {
      return _getDataValue((AbstractDataValue)param);
    } else if (param instanceof Addition) {
      return _getDataValue((Addition)param);
    } else if (param instanceof Subtraction) {
      return _getDataValue((Subtraction)param);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(param).toString());
    }
  }
}
