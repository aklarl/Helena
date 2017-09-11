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
package eu.ascens.ui.contentassist;

import com.google.common.base.Objects;
import eu.ascens.helenaText.AbstractRoleInstanceReference;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.MsgDirection;
import eu.ascens.helenaText.OutgoingMessageCall;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import eu.ascens.ui.contentassist.AbstractHelenaTextProposalProvider;
import eu.ascens.ui.util.UiHelper;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class HelenaTextProposalProvider extends AbstractHelenaTextProposalProvider {
  public void completeIncomingMessageCall_MsgName(final IncomingMessageCall incMsgCall, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.completeIncomingMessageCall_MsgName(incMsgCall, assignment, context, acceptor);
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(incMsgCall);
    RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
    Iterable<MessageType> inRoleMsgs = ExtensionMethods_RoleType.getAllMessagesOfDirection(_roleTypeRef, MsgDirection.IN);
    for (final MessageType msg : inRoleMsgs) {
      {
        FormalRoleParamsBlock _formalRoleParamsBlock = msg.getFormalRoleParamsBlock();
        EList<FormalRoleParam> roleParams = _formalRoleParamsBlock.getParams();
        FormalDataParamsBlock _formalDataParamsBlock = msg.getFormalDataParamsBlock();
        EList<FormalDataParam> dataParams = _formalDataParamsBlock.getParams();
        final Function1<FormalRoleParam, String> _function = new Function1<FormalRoleParam, String>() {
          @Override
          public String apply(final FormalRoleParam p) {
            return p.getName();
          }
        };
        List<String> rpNames = ListExtensions.<FormalRoleParam, String>map(roleParams, _function);
        final Function1<FormalDataParam, String> _function_1 = new Function1<FormalDataParam, String>() {
          @Override
          public String apply(final FormalDataParam p) {
            return p.getName();
          }
        };
        List<String> dpNames = ListExtensions.<FormalDataParam, String>map(dataParams, _function_1);
        final Function1<FormalRoleParam, String> _function_2 = new Function1<FormalRoleParam, String>() {
          @Override
          public String apply(final FormalRoleParam p) {
            RoleType _type = p.getType();
            return _type.getName();
          }
        };
        List<String> rpTypes = ListExtensions.<FormalRoleParam, String>map(roleParams, _function_2);
        final Function1<FormalDataParam, String> _function_3 = new Function1<FormalDataParam, String>() {
          @Override
          public String apply(final FormalDataParam p) {
            JvmTypeReference _type = p.getType();
            JvmType _type_1 = _type.getType();
            return _type_1.getSimpleName();
          }
        };
        List<String> dpTypes = ListExtensions.<FormalDataParam, String>map(dataParams, _function_3);
        StringConcatenation _builder = new StringConcatenation();
        String _name = msg.getName();
        _builder.append(_name, "");
        _builder.append("(");
        String _formalParamsAsString = UiHelper.getFormalParamsAsString(rpTypes, rpNames, ",");
        _builder.append(_formalParamsAsString, "");
        _builder.append(")(");
        String _formalParamsAsString_1 = UiHelper.getFormalParamsAsString(dpTypes, dpNames, ",");
        _builder.append(_formalParamsAsString_1, "");
        _builder.append(")");
        String proposal = _builder.toString();
        ICompletionProposal _createCompletionProposal = this.createCompletionProposal(proposal, context);
        acceptor.accept(_createCompletionProposal);
      }
    }
  }
  
  public void completeOutgoingMessageCall_MsgName(final OutgoingMessageCall outMsgCall, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    super.completeOutgoingMessageCall_MsgName(outMsgCall, assignment, context, acceptor);
    RoleBehavior _parentRoleBehavior = ExtensionMethods_RoleBehavior.getParentRoleBehavior(outMsgCall);
    RoleType _roleTypeRef = _parentRoleBehavior.getRoleTypeRef();
    Iterable<MessageType> outRoleMsgs = ExtensionMethods_RoleType.getAllMessagesOfDirection(_roleTypeRef, MsgDirection.OUT);
    AbstractRoleInstanceReference _receiver = outMsgCall.getReceiver();
    RoleType _roleTypeForRef = ExtensionMethods_Param.getRoleTypeForRef(_receiver);
    Iterable<MessageType> _allMessagesOfDirection = ExtensionMethods_RoleType.getAllMessagesOfDirection(_roleTypeForRef, MsgDirection.IN);
    List<MessageType> outMsgsOfReceiver = IterableExtensions.<MessageType>toList(_allMessagesOfDirection);
    for (final MessageType msg : outRoleMsgs) {
      final Function1<MessageType, Boolean> _function = new Function1<MessageType, Boolean>() {
        @Override
        public Boolean apply(final MessageType receiverMsg) {
          String _name = receiverMsg.getName();
          String _name_1 = msg.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        }
      };
      boolean _exists = IterableExtensions.<MessageType>exists(outMsgsOfReceiver, _function);
      if (_exists) {
        FormalRoleParamsBlock _formalRoleParamsBlock = msg.getFormalRoleParamsBlock();
        EList<FormalRoleParam> _params = _formalRoleParamsBlock.getParams();
        final Function1<FormalRoleParam, String> _function_1 = new Function1<FormalRoleParam, String>() {
          @Override
          public String apply(final FormalRoleParam p) {
            return p.getName();
          }
        };
        final List<String> rpNames = ListExtensions.<FormalRoleParam, String>map(_params, _function_1);
        FormalDataParamsBlock _formalDataParamsBlock = msg.getFormalDataParamsBlock();
        EList<FormalDataParam> _params_1 = _formalDataParamsBlock.getParams();
        final Function1<FormalDataParam, String> _function_2 = new Function1<FormalDataParam, String>() {
          @Override
          public String apply(final FormalDataParam p) {
            return p.getName();
          }
        };
        final List<String> dpNames = ListExtensions.<FormalDataParam, String>map(_params_1, _function_2);
        StringConcatenation _builder = new StringConcatenation();
        String _name = msg.getName();
        _builder.append(_name, "");
        _builder.append("(");
        String _formalParamNamesAsString = UiHelper.getFormalParamNamesAsString(rpNames, ",");
        _builder.append(_formalParamNamesAsString, "");
        _builder.append(")(");
        String _formalParamNamesAsString_1 = UiHelper.getFormalParamNamesAsString(dpNames, ",");
        _builder.append(_formalParamNamesAsString_1, "");
        _builder.append(")");
        String proposal = _builder.toString();
        ICompletionProposal _createCompletionProposal = this.createCompletionProposal(proposal, context);
        acceptor.accept(_createCompletionProposal);
      }
    }
  }
}
