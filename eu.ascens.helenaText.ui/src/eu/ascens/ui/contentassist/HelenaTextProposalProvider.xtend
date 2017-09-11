/*
 *  The Helena workbench is an Eclipse plugin for the development of ensemble-based systems
 *  according to the Helena approach. It is fully documented in the PhD 
 *  thesis "Helena - Handling massively distributed systems with ELaborate 
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 
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
 * 
 */
package eu.ascens.ui.contentassist

import eu.ascens.helenaText.IncomingMessageCall
import eu.ascens.helenaText.MsgDirection
import eu.ascens.helenaText.OutgoingMessageCall
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor

import static eu.ascens.ui.util.UiHelper.*

import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*
/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
class HelenaTextProposalProvider extends AbstractHelenaTextProposalProvider {

	public def void completeIncomingMessageCall_MsgName(IncomingMessageCall incMsgCall, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {

		// call implementation of superclass
		super.completeIncomingMessageCall_MsgName(incMsgCall, assignment, context, acceptor);

		var inRoleMsgs = incMsgCall.parentRoleBehavior.roleTypeRef.getAllMessagesOfDirection(MsgDirection.IN);
		for(msg : inRoleMsgs){
			var roleParams = msg.formalRoleParamsBlock.params;
			var dataParams = msg.formalDataParamsBlock.params;
			var rpNames = roleParams.map[p | p.name];
			var dpNames = dataParams.map[p | p.name];
			var rpTypes = roleParams.map[p | p.type.name];
			var dpTypes = dataParams.map[p | p.type.type.simpleName];
			
			
			var proposal = '''«msg.name»(«getFormalParamsAsString(rpTypes, rpNames, ",")»)(«getFormalParamsAsString(dpTypes, dpNames, ",")»)''';
			acceptor.accept(createCompletionProposal(proposal, context));
		}
	}
	
	
	

	public def void completeOutgoingMessageCall_MsgName(OutgoingMessageCall outMsgCall, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {

		// call implementation of superclass
		super.completeOutgoingMessageCall_MsgName(outMsgCall, assignment, context, acceptor);

		var outRoleMsgs = outMsgCall.parentRoleBehavior.roleTypeRef.getAllMessagesOfDirection(MsgDirection.OUT);
		var outMsgsOfReceiver = outMsgCall.receiver.roleTypeForRef.getAllMessagesOfDirection(MsgDirection.IN).toList;
		for(msg : outRoleMsgs){
			if(outMsgsOfReceiver.exists[receiverMsg | receiverMsg.name == msg.name]){
				val rpNames = msg.formalRoleParamsBlock.params.map[p | p.name];
				val dpNames = msg.formalDataParamsBlock.params.map[p | p.name];
				var proposal = '''«msg.name»(«getFormalParamNamesAsString(rpNames, ",")»)(«getFormalParamNamesAsString(dpNames, ",")»)''';
				acceptor.accept(createCompletionProposal(proposal, context));
			}
		}

	}
}
