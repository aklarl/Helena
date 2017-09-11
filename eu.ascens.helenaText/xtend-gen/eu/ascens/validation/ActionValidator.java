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
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.AbstractMessageCall;
import eu.ascens.helenaText.ActualDataParamsBlock;
import eu.ascens.helenaText.ComponentAttributeSetter;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OutgoingMessageCall;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.RoleAttributeSetter;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import eu.ascens.helenaText.util.ExtensionMethods_Action;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import eu.ascens.helenaText.util.Helper;
import eu.ascens.helenaText.util.JvmTypesHelper;
import eu.ascens.validation.HelenaTextValidator;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ActionValidator extends AbstractDeclarativeValidator {
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  /**
   * Checks if the io call of a role behavior fit to the messages in the role type
   * 1) msg-name exists in messages of the role type
   * 2) direction is allowed in the message in the role type
   * 3) given role params fit to the types of the role params in the message of the role type
   * 4) given data params fit to the types of the data params in the message of the role type
   * 5) the communication partner also accepts the message in inverse direction
   * 
   * ! We do not have to check that actual params are references to previously declared variables
   * or params since they are defined as cross-references in Xtext
   */
  @Check
  public void check_action_messageCallsFitToRoleType(final AbstractMessageCall call) {
    RoleBehavior rb = ExtensionMethods_RoleBehavior.getParentRoleBehavior(call);
    RoleType _roleTypeRef = rb.getRoleTypeRef();
    EList<MessageType> _rolemsgs = _roleTypeRef.getRolemsgs();
    for (final MessageType roleMsg : _rolemsgs) {
      String _msgName = call.getMsgName();
      String _name = roleMsg.getName();
      boolean _equals = Objects.equal(_msgName, _name);
      if (_equals) {
        boolean _directionMatches = ExtensionMethods_Action.directionMatches(call, roleMsg);
        boolean _not = (!_directionMatches);
        if (_not) {
          String _msgName_1 = call.getMsgName();
          String _plus = ("The underlying role type has to allow sending/receiving the message " + _msgName_1);
          this.error(_plus, call, 
            HelenaTextPackage.Literals.ABSTRACT_MESSAGE_CALL__MSG_NAME, 
            HelenaTextValidator.NOT_ALLOWED);
          return;
        }
        boolean _roleParamsMatchInType = ExtensionMethods_Action.roleParamsMatchInType(call, roleMsg);
        boolean _not_1 = (!_roleParamsMatchInType);
        if (_not_1) {
          String _msgName_2 = call.getMsgName();
          String _plus_1 = ("The role parameters of the message " + _msgName_2);
          String _plus_2 = (_plus_1 + " do not fit to the ones of the message in the role type.");
          EStructuralFeature _roleParamsFeature = ActionValidator.getRoleParamsFeature(call);
          this.error(_plus_2, call, _roleParamsFeature, 
            HelenaTextValidator.NOT_ALLOWED);
          return;
        }
        boolean _dataParamsMatchInType = ExtensionMethods_Action.dataParamsMatchInType(call, roleMsg);
        boolean _not_2 = (!_dataParamsMatchInType);
        if (_not_2) {
          String _msgName_3 = call.getMsgName();
          String _plus_3 = ("The data parameters of the message " + _msgName_3);
          String _plus_4 = (_plus_3 + " do not fit to the ones of the message in the role type.");
          EStructuralFeature _dataParamsFeature = ActionValidator.getDataParamsFeature(call);
          this.error(_plus_4, call, _dataParamsFeature, 
            HelenaTextValidator.NOT_ALLOWED);
          return;
        }
        boolean _communicationPartnerHasMatchingMsg = ExtensionMethods_Action.communicationPartnerHasMatchingMsg(call);
        boolean _not_3 = (!_communicationPartnerHasMatchingMsg);
        if (_not_3) {
          String _msgName_4 = call.getMsgName();
          String _plus_5 = ("The message " + _msgName_4);
          String _plus_6 = (_plus_5 + " has to be allowed for the communication partner.");
          EStructuralFeature _communicationPartnerFeature = ActionValidator.getCommunicationPartnerFeature(call);
          this.error(_plus_6, call, _communicationPartnerFeature, 
            HelenaTextValidator.MISSING_CONNECTION);
          return;
        }
        return;
      }
    }
    String _msgName_5 = call.getMsgName();
    String _plus_7 = ("The message " + _msgName_5);
    String _plus_8 = (_plus_7 + " has to be a message of the role type ");
    RoleType _roleTypeRef_1 = rb.getRoleTypeRef();
    String _name_1 = _roleTypeRef_1.getName();
    String _plus_9 = (_plus_8 + _name_1);
    String _plus_10 = (_plus_9 + 
      "(possible msg[s]: ");
    RoleType _roleTypeRef_2 = rb.getRoleTypeRef();
    EList<MessageType> _rolemsgs_1 = _roleTypeRef_2.getRolemsgs();
    final Function1<MessageType, String> _function = new Function1<MessageType, String>() {
      @Override
      public String apply(final MessageType it) {
        return it.getName();
      }
    };
    List<String> _map = ListExtensions.<MessageType, String>map(_rolemsgs_1, _function);
    String _joinToString = Helper.joinToString(",", _map);
    String _plus_11 = (_plus_10 + _joinToString);
    String _plus_12 = (_plus_11 + ")");
    this.error(_plus_12, 
      HelenaTextPackage.Literals.ABSTRACT_MESSAGE_CALL__MSG_NAME, 
      HelenaTextValidator.MISSING_CONNECTION);
  }
  
  private static EStructuralFeature _getRoleParamsFeature(final IncomingMessageCall call) {
    return HelenaTextPackage.Literals.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK;
  }
  
  private static EStructuralFeature _getRoleParamsFeature(final OutgoingMessageCall call) {
    return HelenaTextPackage.Literals.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK;
  }
  
  private static EStructuralFeature _getDataParamsFeature(final IncomingMessageCall call) {
    return HelenaTextPackage.Literals.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK;
  }
  
  private static EStructuralFeature _getDataParamsFeature(final OutgoingMessageCall call) {
    return HelenaTextPackage.Literals.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK;
  }
  
  private static EStructuralFeature _getCommunicationPartnerFeature(final IncomingMessageCall call) {
    return HelenaTextPackage.Literals.ABSTRACT_MESSAGE_CALL__MSG_NAME;
  }
  
  private static EStructuralFeature _getCommunicationPartnerFeature(final OutgoingMessageCall call) {
    return HelenaTextPackage.Literals.OUTGOING_MESSAGE_CALL__RECEIVER;
  }
  
  /**
   * Checks whether an operation call fits to the operation in the component
   * 1) the operation exists for the owner of the role type of the role behavior
   * 2) the actual data params fit to the formal ones
   * 3) only a operation with a return type is assigned to a variable
   */
  @Check
  public void check_action_operationForCorrectCompTypeInvoked(final OperationCall call) {
    OperationType op = ExtensionMethods_Action.getOperationType(call);
    boolean _equals = Objects.equal(op, null);
    if (_equals) {
      RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(call);
      RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
      ComponentType _ownerComponentType = ExtensionMethods_RoleType.getOwnerComponentType(_roleTypeRef);
      EList<OperationType> _ops = _ownerComponentType.getOps();
      final Function1<OperationType, String> _function = new Function1<OperationType, String>() {
        @Override
        public String apply(final OperationType it) {
          return it.getName();
        }
      };
      List<String> _map = ListExtensions.<OperationType, String>map(_ops, _function);
      String _joinToString = Helper.joinToString(",", _map);
      String _plus = (("The operation call did not invoke any operation of the owning component. " + "Allowed operations are ") + _joinToString);
      this.error(_plus, 
        HelenaTextPackage.Literals.OPERATION_CALL__OP_NAME, 
        HelenaTextValidator.NOT_ALLOWED);
      return;
    }
    FormalDataParamsBlock _formalDataParamsBlock = op.getFormalDataParamsBlock();
    EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
    final Function1<FormalDataParam, JvmType> _function_1 = new Function1<FormalDataParam, JvmType>() {
      @Override
      public JvmType apply(final FormalDataParam it) {
        JvmTypeReference _type = it.getType();
        JvmType _type_1 = _type.getType();
        return JvmTypesHelper.getWrappedType(_type_1);
      }
    };
    List<JvmType> _map_1 = ListExtensions.<FormalDataParam, JvmType>map(_params, _function_1);
    ActualDataParamsBlock _actualDataParamsBlock = call.getActualDataParamsBlock();
    EList<DataExpression> _params_1 = _actualDataParamsBlock.getParams();
    final Function1<DataExpression, JvmType> _function_2 = new Function1<DataExpression, JvmType>() {
      @Override
      public JvmType apply(final DataExpression it) {
        return ExtensionMethods_Param.getWrappedJvmType(it);
      }
    };
    List<JvmType> _map_2 = ListExtensions.<DataExpression, JvmType>map(_params_1, _function_2);
    boolean _typesEqual = JvmTypesHelper.typesEqual(_map_1, _map_2);
    boolean _not = (!_typesEqual);
    if (_not) {
      String _opName = call.getOpName();
      String _plus_1 = ("The data parameters of the message " + _opName);
      String _plus_2 = (_plus_1 + " do not fit to the ones of the operation in the component type.");
      this.error(_plus_2, call, 
        HelenaTextPackage.Literals.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK, 
        HelenaTextValidator.NOT_ALLOWED);
      return;
    }
    if ((ExtensionMethods_JvmType.isVoid(op.getReturnType().getType()) && (!Objects.equal(call.getVariable(), null)))) {
      this.error(
        "An operation call of a void method cannot be assigned to a variable.", call, 
        HelenaTextPackage.Literals.OPERATION_CALL__VARIABLE, 
        HelenaTextValidator.NOT_ALLOWED);
      return;
    }
  }
  
  /**
   * Checks whether get or create is called for a component instance
   * which can actually play the given role type.
   */
  @Check
  public void check_action_compInstanceAllowedAsOwner(final AbstractAssignment assignment) {
    ComponentInstance _compInstance = assignment.getCompInstance();
    RoleType _roleTypeRef = assignment.getRoleTypeRef();
    boolean _isAllowedAsOwnerType = ExtensionMethods_RoleType.isAllowedAsOwnerType(_compInstance, _roleTypeRef);
    boolean _not = (!_isAllowedAsOwnerType);
    if (_not) {
      RoleType _roleTypeRef_1 = assignment.getRoleTypeRef();
      String _name = _roleTypeRef_1.getName();
      String _plus = ("A role instance of type " + _name);
      String _plus_1 = (_plus + 
        " cannot be owned by the given component instance. Allowed component types are ");
      RoleType _roleTypeRef_2 = assignment.getRoleTypeRef();
      EList<ComponentType> _compTypes = _roleTypeRef_2.getCompTypes();
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
        HelenaTextPackage.Literals.ABSTRACT_ASSIGNMENT__COMP_INSTANCE, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  /**
   * Checks if a setter is called with a value matching the type of the role attr
   */
  @Check
  public void check_action_setterValueMatches(final RoleAttributeSetter setter) {
    if ((((!Objects.equal(setter.getAttr(), null)) && (!Objects.equal(setter.getValue(), null))) && 
      (!JvmTypesHelper.typesEqual(JvmTypesHelper.getWrappedType(setter.getAttr().getRef().getType().getType()), ExtensionMethods_Param.getWrappedJvmType(setter.getValue()))))) {
      this.error(
        "The type of the value assigned to the attribute must match the attribute\'s type.", 
        HelenaTextPackage.Literals.ROLE_ATTRIBUTE_SETTER__VALUE, 
        HelenaTextValidator.MISSING_CONNECTION);
    }
  }
  
  /**
   * Checks if a setter is called with a value matching the type of the component attr
   */
  @Check
  public void check_action_setterValueMatches(final ComponentAttributeSetter setter) {
    if ((((!Objects.equal(setter.getAttr(), null)) && (!Objects.equal(setter.getValue(), null))) && 
      (!JvmTypesHelper.typesEqual(JvmTypesHelper.getWrappedType(setter.getAttr().getRef().getType().getType()), ExtensionMethods_Param.getWrappedJvmType(setter.getValue()))))) {
      this.error(
        "The type of the value assigned to the attribute must match the attribute\'s type.", 
        HelenaTextPackage.Literals.COMPONENT_ATTRIBUTE_SETTER__VALUE, 
        HelenaTextValidator.MISSING_CONNECTION);
    }
  }
  
  /**
   * Checks for valid use of abstract assignment. If an abstract assignment, like getRole or createRole, is used in a role behavior,
   * the role that shall be created or received has to be listed in all ensemble structure, where the role of the current
   * role behavior can participate.
   * If more than one ensemble structure exists that contains the role of the current role behavior, the role that shall be created/received
   * has to be in all of them.
   */
  @Check
  public void check_action_assignmentOfRoleTypeFromEnsembleStrucuture(final AbstractAssignment assignment) {
    final RoleType assignmentRT = assignment.getRoleTypeRef();
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(assignment);
    final RoleType parentRT = _parentRoleBehavior.getRoleTypeRef();
    EObject _eContainer = parentRT.eContainer();
    EList<EnsembleStructure> allEnsembleStructs = ((PackageDeclaration) _eContainer).getEnsStructs();
    for (final EnsembleStructure ens : allEnsembleStructs) {
      {
        EList<RoleTypeWithMultiplicity> _rtWithMult = ens.getRtWithMult();
        final Function1<RoleTypeWithMultiplicity, RoleType> _function = new Function1<RoleTypeWithMultiplicity, RoleType>() {
          @Override
          public RoleType apply(final RoleTypeWithMultiplicity it) {
            return it.getRoleType();
          }
        };
        List<RoleType> ensRoleTypes = ListExtensions.<RoleTypeWithMultiplicity, RoleType>map(_rtWithMult, _function);
        if ((ensRoleTypes.contains(parentRT) && (!ensRoleTypes.contains(assignmentRT)))) {
          String _name = assignmentRT.getName();
          String _plus = ("To create/get a " + _name);
          String _plus_1 = (_plus + 
            " here, the role type has to be listed in all ensemble structures where role type ");
          String _name_1 = parentRT.getName();
          String _plus_2 = (_plus_1 + _name_1);
          String _plus_3 = (_plus_2 + 
            " participates. (Currently missing in ensemble structure: ");
          String _name_2 = ens.getName();
          String _plus_4 = (_plus_3 + _name_2);
          String _plus_5 = (_plus_4 + ")");
          this.error(_plus_5, 
            HelenaTextPackage.Literals.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF, 
            HelenaTextValidator.MISSING_CONNECTION);
        }
      }
    }
  }
  
  private static EStructuralFeature getRoleParamsFeature(final AbstractMessageCall call) {
    if (call instanceof IncomingMessageCall) {
      return _getRoleParamsFeature((IncomingMessageCall)call);
    } else if (call instanceof OutgoingMessageCall) {
      return _getRoleParamsFeature((OutgoingMessageCall)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
  
  private static EStructuralFeature getDataParamsFeature(final AbstractMessageCall call) {
    if (call instanceof IncomingMessageCall) {
      return _getDataParamsFeature((IncomingMessageCall)call);
    } else if (call instanceof OutgoingMessageCall) {
      return _getDataParamsFeature((OutgoingMessageCall)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
  
  private static EStructuralFeature getCommunicationPartnerFeature(final AbstractMessageCall call) {
    if (call instanceof IncomingMessageCall) {
      return _getCommunicationPartnerFeature((IncomingMessageCall)call);
    } else if (call instanceof OutgoingMessageCall) {
      return _getCommunicationPartnerFeature((OutgoingMessageCall)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
}
