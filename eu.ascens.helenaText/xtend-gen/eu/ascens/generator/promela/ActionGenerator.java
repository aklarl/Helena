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
import eu.ascens.generator.promela.NameGenerator;
import eu.ascens.generator.promela.OperationCallGenerator;
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.AbstractRoleInstanceReference;
import eu.ascens.helenaText.Action;
import eu.ascens.helenaText.ActualDataParamsBlock;
import eu.ascens.helenaText.ActualRoleParamsBlock;
import eu.ascens.helenaText.ComponentAttributeSetter;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentAttributeTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OutgoingMessageCall;
import eu.ascens.helenaText.RoleAttributeSetter;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleAttributeTypeReference;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleInstanceReference;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_Action;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class ActionGenerator {
  @Inject
  private NameGenerator nameGenerator;
  
  @Inject
  private OperationCallGenerator opCallGenerator;
  
  public CharSequence compileAction(final Action action) {
    return this.compileAction_(action);
  }
  
  /**
   * Compiles an incoming call action:
   * - for each (role or data) param, a local variable is declared
   * - the corresponding incoming msg is received via the own channel via a msg helper
   */
  protected CharSequence _compileAction_(final IncomingMessageCall call) {
    CharSequence _xblockexpression = null;
    {
      FormalRoleParamsBlock _formalRoleParamsBlock = call.getFormalRoleParamsBlock();
      EList<FormalRoleParam> roleparams = _formalRoleParamsBlock.getParams();
      FormalDataParamsBlock _formalDataParamsBlock = call.getFormalDataParamsBlock();
      EList<FormalDataParam> dataparams = _formalDataParamsBlock.getParams();
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// incoming message");
      _builder.newLine();
      MessageType _messageType = ExtensionMethods_Action.getMessageType(call);
      String _rcvMsgHelperName = NameGenerator.getRcvMsgHelperName(_messageType);
      _builder.append(_rcvMsgHelperName, "");
      _builder.append("(");
      {
        boolean _hasElements = false;
        for(final FormalRoleParam param : roleparams) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          String _variableName = NameGenerator.getVariableName(param);
          _builder.append(_variableName, "");
        }
      }
      {
        if (((roleparams.size() != 0) && (dataparams.size() != 0))) {
          _builder.append(",");
        }
      }
      {
        boolean _hasElements_1 = false;
        for(final FormalDataParam param_1 : dataparams) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          String _varName = NameGenerator.getVarName(param_1);
          _builder.append(_varName, "");
        }
      }
      _builder.append(")");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Compiles an outgoing call action:
   * - for each data param, the value is retrieved from the component (only necessary if it is a component attribute)
   * - the corresponding outgoing msg is sent via a msg helper
   */
  protected CharSequence _compileAction_(final OutgoingMessageCall call) {
    CharSequence _xblockexpression = null;
    {
      ActualRoleParamsBlock _actualRoleParamsBlock = call.getActualRoleParamsBlock();
      EList<RoleInstanceReference> roleparams = _actualRoleParamsBlock.getParams();
      ActualDataParamsBlock _actualDataParamsBlock = call.getActualDataParamsBlock();
      EList<DataExpression> dataparams = _actualDataParamsBlock.getParams();
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// outgoing message");
      _builder.newLine();
      {
        for(final DataExpression param : dataparams) {
          CharSequence _retrieveDataValueFromOwner = OperationCallGenerator.retrieveDataValueFromOwner(param);
          _builder.append(_retrieveDataValueFromOwner, "");
        }
      }
      _builder.newLineIfNotEmpty();
      MessageType _messageType = ExtensionMethods_Action.getMessageType(call);
      String _sndMsgHelperName = NameGenerator.getSndMsgHelperName(_messageType);
      _builder.append(_sndMsgHelperName, "");
      _builder.append("(");
      AbstractRoleInstanceReference _receiver = call.getReceiver();
      String _roleInstance = NameGenerator.getRoleInstance(_receiver);
      _builder.append(_roleInstance, "");
      {
        boolean _hasElements = false;
        for(final RoleInstanceReference param_1 : roleparams) {
          if (!_hasElements) {
            _hasElements = true;
            _builder.append(",", "");
          } else {
            _builder.appendImmediate(",", "");
          }
          String _roleInstance_1 = NameGenerator.getRoleInstance(param_1);
          _builder.append(_roleInstance_1, "");
        }
      }
      {
        boolean _hasElements_1 = false;
        for(final DataExpression param_2 : dataparams) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
            _builder.append(",", "");
          } else {
            _builder.appendImmediate(",", "");
          }
          String _dataValue = this.nameGenerator.getDataValue(param_2);
          _builder.append(_dataValue, "");
        }
      }
      _builder.append(")");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Compiles a create or get action:
   * - the component instance where to create or get the role is retrieved from the owner
   * - a local variable for the channel to the new role instance is declared
   * - the retrieval is issued by calling an operation on the target component
   */
  protected CharSequence _compileAction_(final AbstractAssignment call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("// retrieve reference to component instance");
    _builder.newLine();
    ComponentInstance _compInstance = call.getCompInstance();
    CharSequence _retrieveCompInstanceFromOwner = OperationCallGenerator.retrieveCompInstanceFromOwner(_compInstance);
    _builder.append(_retrieveCompInstanceFromOwner, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// create/get role instance");
    _builder.newLine();
    ComponentInstance _compInstance_1 = call.getCompInstance();
    ComponentType _componentType = ExtensionMethods_Param.getComponentType(_compInstance_1);
    CharSequence _compileOperationCall = OperationCallGenerator.compileOperationCall(_componentType, call);
    _builder.append(_compileOperationCall, "");
    return _builder;
  }
  
  /**
   * Compiles a setter of a role attribute
   */
  protected CharSequence _compileAction_(final RoleAttributeSetter setter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("// set role attr");
    _builder.newLine();
    DataExpression _value = setter.getValue();
    CharSequence _retrieveDataValueFromOwner = OperationCallGenerator.retrieveDataValueFromOwner(_value);
    _builder.append(_retrieveDataValueFromOwner, "");
    _builder.newLineIfNotEmpty();
    RoleAttributeTypeReference _attr = setter.getAttr();
    RoleAttributeType _ref = _attr.getRef();
    String _variableName = NameGenerator.getVariableName(_ref);
    _builder.append(_variableName, "");
    _builder.append(" = ");
    DataExpression _value_1 = setter.getValue();
    String _dataValue = this.nameGenerator.getDataValue(_value_1);
    _builder.append(_dataValue, "");
    return _builder;
  }
  
  /**
   * Compiles a setter of a component attribute
   */
  protected CharSequence _compileAction_(final ComponentAttributeSetter setter) {
    CharSequence _xblockexpression = null;
    {
      RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(setter);
      RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
      ComponentType owner = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// set comp attr");
      _builder.newLine();
      DataExpression _value = setter.getValue();
      CharSequence _retrieveDataValueFromOwner = OperationCallGenerator.retrieveDataValueFromOwner(_value);
      _builder.append(_retrieveDataValueFromOwner, "");
      _builder.newLineIfNotEmpty();
      ComponentAttributeTypeReference _attr = setter.getAttr();
      ComponentAttributeType _ref = _attr.getRef();
      DataExpression _value_1 = setter.getValue();
      CharSequence _compileSetterOperationCall = this.opCallGenerator.compileSetterOperationCall(owner, _ref, _value_1);
      _builder.append(_compileSetterOperationCall, "");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _compileAction_(final OperationCall call) {
    CharSequence _xblockexpression = null;
    {
      RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(call);
      RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
      ComponentType owner = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
      OperationType op = ExtensionMethods_Action.getOperationType(call);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("// call operation at component");
      _builder.newLine();
      {
        ActualDataParamsBlock _actualDataParamsBlock = call.getActualDataParamsBlock();
        EList<DataExpression> _params = _actualDataParamsBlock.getParams();
        for(final DataExpression param : _params) {
          CharSequence _retrieveDataValueFromOwner = OperationCallGenerator.retrieveDataValueFromOwner(param);
          _builder.append(_retrieveDataValueFromOwner, "");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        JvmTypeReference _returnType = op.getReturnType();
        JvmType _type = _returnType.getType();
        boolean _isVoid = ExtensionMethods_JvmType.isVoid(_type);
        if (_isVoid) {
          OperationType _operationType = ExtensionMethods_Action.getOperationType(call);
          ActualDataParamsBlock _actualDataParamsBlock_1 = call.getActualDataParamsBlock();
          EList<DataExpression> _params_1 = _actualDataParamsBlock_1.getParams();
          CharSequence _compileOperationCall = this.opCallGenerator.compileOperationCall(owner, _operationType, ((DataExpression[])Conversions.unwrapArray(_params_1, DataExpression.class)));
          _builder.append(_compileOperationCall, "");
        } else {
          OperationType _operationType_1 = ExtensionMethods_Action.getOperationType(call);
          DataVariable _variable = call.getVariable();
          ActualDataParamsBlock _actualDataParamsBlock_2 = call.getActualDataParamsBlock();
          EList<DataExpression> _params_2 = _actualDataParamsBlock_2.getParams();
          CharSequence _compileOperationCall_1 = this.opCallGenerator.compileOperationCall(owner, _operationType_1, _variable, ((DataExpression[])Conversions.unwrapArray(_params_2, DataExpression.class)));
          _builder.append(_compileOperationCall_1, "");
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _compileAction_(final Label label) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("// state label");
    _builder.newLine();
    String _labelName = NameGenerator.getLabelName(label);
    _builder.append(_labelName, "");
    _builder.append(": true");
    return _builder;
  }
  
  public CharSequence compileAction_(final Action call) {
    if (call instanceof IncomingMessageCall) {
      return _compileAction_((IncomingMessageCall)call);
    } else if (call instanceof OutgoingMessageCall) {
      return _compileAction_((OutgoingMessageCall)call);
    } else if (call instanceof AbstractAssignment) {
      return _compileAction_((AbstractAssignment)call);
    } else if (call instanceof ComponentAttributeSetter) {
      return _compileAction_((ComponentAttributeSetter)call);
    } else if (call instanceof Label) {
      return _compileAction_((Label)call);
    } else if (call instanceof OperationCall) {
      return _compileAction_((OperationCall)call);
    } else if (call instanceof RoleAttributeSetter) {
      return _compileAction_((RoleAttributeSetter)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
}
