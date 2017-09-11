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
import eu.ascens.helenaText.AbstractMessageCall;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.AbstractRoleInstanceReference;
import eu.ascens.helenaText.Action;
import eu.ascens.helenaText.ActualDataParamsBlock;
import eu.ascens.helenaText.ActualRoleParamsBlock;
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
import eu.ascens.helenaText.MsgDirection;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OutgoingMessageCall;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleInstanceReference;
import eu.ascens.helenaText.RoleInstanceVariable;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import eu.ascens.helenaText.util.Helper;
import eu.ascens.helenaText.util.JvmTypesHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ExtensionMethods_Action {
  /**
   * Returns the operation type which corresponds to this call
   */
  public static OperationType getOperationType(final OperationCall call) {
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(call);
    RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
    ComponentType owner = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
    EList<OperationType> _ops = owner.getOps();
    for (final OperationType op : _ops) {
      String _opName = call.getOpName();
      String _name = op.getName();
      boolean _equals = _opName.equals(_name);
      if (_equals) {
        return op;
      }
    }
    return null;
  }
  
  /**
   * Returns the message type which corresponds to this call
   */
  public static MessageType getMessageType(final AbstractMessageCall call) {
    RoleBehavior rb = ExtensionMethods_RoleBehavior.getParentRoleBehavior(call);
    RoleType _roleTypeRef = rb.getRoleTypeRef();
    EList<MessageType> _rolemsgs = _roleTypeRef.getRolemsgs();
    for (final MessageType roleMsg : _rolemsgs) {
      String _msgName = call.getMsgName();
      String _name = roleMsg.getName();
      boolean _equals = Objects.equal(_msgName, _name);
      if (_equals) {
        return roleMsg;
      }
    }
    return null;
  }
  
  /**
   * Checks that the direction of the declared message type fits to the used direction in the io-call
   */
  protected static boolean _directionMatches(final IncomingMessageCall call, final MessageType msg) {
    return (Objects.equal(MsgDirection.IN, msg.getDirection()) || Objects.equal(MsgDirection.INOUT, msg.getDirection()));
  }
  
  protected static boolean _directionMatches(final OutgoingMessageCall call, final MessageType msg) {
    return (Objects.equal(MsgDirection.OUT, msg.getDirection()) || Objects.equal(MsgDirection.INOUT, msg.getDirection()));
  }
  
  /**
   * Checks that the direction of the declared message type is the inverse of the used direction in the io-call
   */
  protected static boolean _directionInverse(final IncomingMessageCall call, final MessageType msg) {
    return (Objects.equal(MsgDirection.OUT, msg.getDirection()) || Objects.equal(MsgDirection.INOUT, msg.getDirection()));
  }
  
  protected static boolean _directionInverse(final OutgoingMessageCall call, final MessageType msg) {
    return (Objects.equal(MsgDirection.IN, msg.getDirection()) || Objects.equal(MsgDirection.INOUT, msg.getDirection()));
  }
  
  /**
   * Checks that the given (formal or actual) role params fit in type to the formal role params
   * of the declared message type
   */
  protected static boolean _roleParamsMatchInType(final IncomingMessageCall call, final MessageType roleMsg) {
    FormalRoleParamsBlock _formalRoleParamsBlock = roleMsg.getFormalRoleParamsBlock();
    EList<FormalRoleParam> _params = _formalRoleParamsBlock.getParams();
    final Function1<FormalRoleParam, RoleType> _function = new Function1<FormalRoleParam, RoleType>() {
      @Override
      public RoleType apply(final FormalRoleParam it) {
        return it.getType();
      }
    };
    List<RoleType> _map = ListExtensions.<FormalRoleParam, RoleType>map(_params, _function);
    FormalRoleParamsBlock _formalRoleParamsBlock_1 = call.getFormalRoleParamsBlock();
    EList<FormalRoleParam> _params_1 = _formalRoleParamsBlock_1.getParams();
    final Function1<FormalRoleParam, RoleType> _function_1 = new Function1<FormalRoleParam, RoleType>() {
      @Override
      public RoleType apply(final FormalRoleParam it) {
        return it.getType();
      }
    };
    List<RoleType> _map_1 = ListExtensions.<FormalRoleParam, RoleType>map(_params_1, _function_1);
    return Helper.<RoleType>equals(_map, _map_1);
  }
  
  protected static boolean _roleParamsMatchInType(final OutgoingMessageCall call, final MessageType roleMsg) {
    FormalRoleParamsBlock _formalRoleParamsBlock = roleMsg.getFormalRoleParamsBlock();
    EList<FormalRoleParam> _params = _formalRoleParamsBlock.getParams();
    final Function1<FormalRoleParam, RoleType> _function = new Function1<FormalRoleParam, RoleType>() {
      @Override
      public RoleType apply(final FormalRoleParam it) {
        return it.getType();
      }
    };
    List<RoleType> _map = ListExtensions.<FormalRoleParam, RoleType>map(_params, _function);
    List<RoleType> _actualRoleParamsTypes = ExtensionMethods_Action.getActualRoleParamsTypes(call);
    return Helper.<RoleType>equals(_map, _actualRoleParamsTypes);
  }
  
  /**
   * Retrieves an ordered list of the  role types of all actual role params of the outgoing call
   */
  private static List<RoleType> getActualRoleParamsTypes(final OutgoingMessageCall call) {
    List<RoleType> roleTypes = new ArrayList<RoleType>();
    ActualRoleParamsBlock _actualRoleParamsBlock = call.getActualRoleParamsBlock();
    EList<RoleInstanceReference> _params = _actualRoleParamsBlock.getParams();
    for (final RoleInstanceReference actualRoleParam : _params) {
      RoleType _roleTypeForRef = ExtensionMethods_Param.getRoleTypeForRef(actualRoleParam);
      roleTypes.add(_roleTypeForRef);
    }
    return roleTypes;
  }
  
  /**
   * Checks that the given (formal or actual) data params fit in type to the formal data params
   * of the declared messsage type
   */
  protected static boolean _dataParamsMatchInType(final IncomingMessageCall call, final MessageType roleMsg) {
    FormalDataParamsBlock _formalDataParamsBlock = roleMsg.getFormalDataParamsBlock();
    EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
    final Function1<FormalDataParam, JvmType> _function = new Function1<FormalDataParam, JvmType>() {
      @Override
      public JvmType apply(final FormalDataParam it) {
        JvmTypeReference _type = it.getType();
        JvmType _type_1 = _type.getType();
        return JvmTypesHelper.getWrappedType(_type_1);
      }
    };
    List<JvmType> _map = ListExtensions.<FormalDataParam, JvmType>map(_params, _function);
    FormalDataParamsBlock _formalDataParamsBlock_1 = call.getFormalDataParamsBlock();
    EList<FormalDataParam> _params_1 = _formalDataParamsBlock_1.getParams();
    final Function1<FormalDataParam, JvmType> _function_1 = new Function1<FormalDataParam, JvmType>() {
      @Override
      public JvmType apply(final FormalDataParam it) {
        JvmTypeReference _type = it.getType();
        JvmType _type_1 = _type.getType();
        return JvmTypesHelper.getWrappedType(_type_1);
      }
    };
    List<JvmType> _map_1 = ListExtensions.<FormalDataParam, JvmType>map(_params_1, _function_1);
    return JvmTypesHelper.typesEqual(_map, _map_1);
  }
  
  protected static boolean _dataParamsMatchInType(final OutgoingMessageCall call, final MessageType roleMsg) {
    FormalDataParamsBlock _formalDataParamsBlock = roleMsg.getFormalDataParamsBlock();
    EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
    final Function1<FormalDataParam, JvmType> _function = new Function1<FormalDataParam, JvmType>() {
      @Override
      public JvmType apply(final FormalDataParam it) {
        JvmTypeReference _type = it.getType();
        JvmType _type_1 = _type.getType();
        return JvmTypesHelper.getWrappedType(_type_1);
      }
    };
    List<JvmType> _map = ListExtensions.<FormalDataParam, JvmType>map(_params, _function);
    List<JvmType> _actualDataParamsTypes = ExtensionMethods_Action.getActualDataParamsTypes(call);
    final Function1<JvmType, JvmType> _function_1 = new Function1<JvmType, JvmType>() {
      @Override
      public JvmType apply(final JvmType it) {
        return JvmTypesHelper.getWrappedType(it);
      }
    };
    List<JvmType> _map_1 = ListExtensions.<JvmType, JvmType>map(_actualDataParamsTypes, _function_1);
    return JvmTypesHelper.typesEqual(_map, _map_1);
  }
  
  /**
   * Retrieves an ordered list of the jvm types as strings of all actual data params of the outgoing call
   */
  private static List<JvmType> getActualDataParamsTypes(final OutgoingMessageCall call) {
    List<JvmType> dataTypes = new ArrayList<JvmType>();
    ActualDataParamsBlock _actualDataParamsBlock = call.getActualDataParamsBlock();
    EList<DataExpression> _params = _actualDataParamsBlock.getParams();
    for (final DataExpression actualDataParam : _params) {
      JvmType _wrappedJvmType = ExtensionMethods_Param.getWrappedJvmType(actualDataParam);
      dataTypes.add(_wrappedJvmType);
    }
    return dataTypes;
  }
  
  /**
   * Checks whether the role type of the communication partner also allows the
   * message with inverse message direction
   */
  protected static boolean _communicationPartnerHasMatchingMsg(final IncomingMessageCall call) {
    return true;
  }
  
  protected static boolean _communicationPartnerHasMatchingMsg(final OutgoingMessageCall call) {
    AbstractRoleInstanceReference _receiver = call.getReceiver();
    RoleType _roleTypeForRef = ExtensionMethods_Param.getRoleTypeForRef(_receiver);
    EList<MessageType> _rolemsgs = _roleTypeForRef.getRolemsgs();
    for (final MessageType roleMsg : _rolemsgs) {
      String _msgName = call.getMsgName();
      String _name = roleMsg.getName();
      boolean _equals = Objects.equal(_msgName, _name);
      if (_equals) {
        boolean _directionInverse = ExtensionMethods_Action.directionInverse(call, roleMsg);
        boolean _not = (!_directionInverse);
        if (_not) {
          return false;
        }
        boolean _roleParamsMatchInType = ExtensionMethods_Action.roleParamsMatchInType(call, roleMsg);
        boolean _not_1 = (!_roleParamsMatchInType);
        if (_not_1) {
          return false;
        }
        boolean _dataParamsMatchInType = ExtensionMethods_Action.dataParamsMatchInType(call, roleMsg);
        boolean _not_2 = (!_dataParamsMatchInType);
        if (_not_2) {
          return false;
        }
        return true;
      }
    }
    return false;
  }
  
  /**
   * Returns all abstract role instances in an action
   */
  protected static Collection<AbstractRoleInstance> _getAbstractRoleInstances(final Action action) {
    return new HashSet<AbstractRoleInstance>();
  }
  
  protected static Collection<AbstractRoleInstance> _getAbstractRoleInstances(final IncomingMessageCall action) {
    HashSet<AbstractRoleInstance> list = new HashSet<AbstractRoleInstance>();
    FormalRoleParamsBlock _formalRoleParamsBlock = action.getFormalRoleParamsBlock();
    EList<FormalRoleParam> _params = _formalRoleParamsBlock.getParams();
    list.addAll(_params);
    return list;
  }
  
  protected static Collection<AbstractRoleInstance> _getAbstractRoleInstances(final AbstractAssignment action) {
    RoleInstanceVariable _roleInst = action.getRoleInst();
    return Helper.<AbstractRoleInstance>asList(_roleInst);
  }
  
  /**
   * Returns all formal data params in an action
   */
  protected static Collection<FormalDataParam> _getFormalDataParams(final Action action) {
    return new HashSet<FormalDataParam>();
  }
  
  protected static Collection<FormalDataParam> _getFormalDataParams(final IncomingMessageCall action) {
    HashSet<FormalDataParam> list = new HashSet<FormalDataParam>();
    FormalDataParamsBlock _formalDataParamsBlock = action.getFormalDataParamsBlock();
    EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
    list.addAll(_params);
    return list;
  }
  
  /**
   * Returns all data variables in an action
   */
  protected static Collection<DataVariable> _getOpDataVariables(final Action action) {
    return new HashSet<DataVariable>();
  }
  
  protected static Collection<DataVariable> _getOpDataVariables(final OperationCall action) {
    HashSet<DataVariable> list = new HashSet<DataVariable>();
    OperationType _operationType = ExtensionMethods_Action.getOperationType(action);
    JvmTypeReference _returnType = _operationType.getReturnType();
    boolean _notEquals = (!Objects.equal(_returnType, null));
    if (_notEquals) {
      DataVariable _variable = action.getVariable();
      list.add(_variable);
    }
    return list;
  }
  
  /**
   * Returns all abstract data variables in an action
   */
  protected static Collection<Label> _getLabels(final Action action) {
    return new HashSet<Label>();
  }
  
  protected static Collection<Label> _getLabels(final Label action) {
    return Helper.<Label>asList(action);
  }
  
  public static boolean directionMatches(final AbstractMessageCall call, final MessageType msg) {
    if (call instanceof IncomingMessageCall) {
      return _directionMatches((IncomingMessageCall)call, msg);
    } else if (call instanceof OutgoingMessageCall) {
      return _directionMatches((OutgoingMessageCall)call, msg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call, msg).toString());
    }
  }
  
  public static boolean directionInverse(final AbstractMessageCall call, final MessageType msg) {
    if (call instanceof IncomingMessageCall) {
      return _directionInverse((IncomingMessageCall)call, msg);
    } else if (call instanceof OutgoingMessageCall) {
      return _directionInverse((OutgoingMessageCall)call, msg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call, msg).toString());
    }
  }
  
  public static boolean roleParamsMatchInType(final AbstractMessageCall call, final MessageType roleMsg) {
    if (call instanceof IncomingMessageCall) {
      return _roleParamsMatchInType((IncomingMessageCall)call, roleMsg);
    } else if (call instanceof OutgoingMessageCall) {
      return _roleParamsMatchInType((OutgoingMessageCall)call, roleMsg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call, roleMsg).toString());
    }
  }
  
  public static boolean dataParamsMatchInType(final AbstractMessageCall call, final MessageType roleMsg) {
    if (call instanceof IncomingMessageCall) {
      return _dataParamsMatchInType((IncomingMessageCall)call, roleMsg);
    } else if (call instanceof OutgoingMessageCall) {
      return _dataParamsMatchInType((OutgoingMessageCall)call, roleMsg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call, roleMsg).toString());
    }
  }
  
  public static boolean communicationPartnerHasMatchingMsg(final AbstractMessageCall call) {
    if (call instanceof IncomingMessageCall) {
      return _communicationPartnerHasMatchingMsg((IncomingMessageCall)call);
    } else if (call instanceof OutgoingMessageCall) {
      return _communicationPartnerHasMatchingMsg((OutgoingMessageCall)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
  
  public static Collection<AbstractRoleInstance> getAbstractRoleInstances(final Action action) {
    if (action instanceof IncomingMessageCall) {
      return _getAbstractRoleInstances((IncomingMessageCall)action);
    } else if (action instanceof AbstractAssignment) {
      return _getAbstractRoleInstances((AbstractAssignment)action);
    } else if (action != null) {
      return _getAbstractRoleInstances(action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action).toString());
    }
  }
  
  public static Collection<FormalDataParam> getFormalDataParams(final Action action) {
    if (action instanceof IncomingMessageCall) {
      return _getFormalDataParams((IncomingMessageCall)action);
    } else if (action != null) {
      return _getFormalDataParams(action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action).toString());
    }
  }
  
  public static Collection<DataVariable> getOpDataVariables(final Action action) {
    if (action instanceof OperationCall) {
      return _getOpDataVariables((OperationCall)action);
    } else if (action != null) {
      return _getOpDataVariables(action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action).toString());
    }
  }
  
  public static Collection<Label> getLabels(final Action action) {
    if (action instanceof Label) {
      return _getLabels((Label)action);
    } else if (action != null) {
      return _getLabels(action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action).toString());
    }
  }
}
