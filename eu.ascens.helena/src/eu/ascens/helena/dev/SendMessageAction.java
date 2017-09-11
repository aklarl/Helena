/*
 *  jHelena is a Java library for the execution of ensemble specification
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
package eu.ascens.helena.dev;

import eu.ascens.helena.dev.exceptions.MessageNotAllowedAsInputException;
import eu.ascens.helena.dev.exceptions.MessageNotAllowedAsOutputException;
import eu.ascens.helena.dev.exceptions.MessageNotAllowedBetweenRolesException;
import eu.ascens.helena.dev.exceptions.NoFreeMessageSpotsException;
import eu.ascens.helena.dev.exceptions.RoleInputChannelClosed;
import eu.ascens.helena.metadata.MessageType;
import eu.ascens.helena.metadata.RoleType;

/**
 * This class represents the action of sending a message in Helena.
 *
 * @author Annabelle Klarl
 */
public class SendMessageAction extends Action {

	private final Variable<? extends Role> targetVariable;
	private final Message msg;

	/**
	 * Constructor
	 *
	 * @param target the role to which to send the message
	 * @param msg the message to be sent
	 */
	public SendMessageAction(Variable<? extends Role> target, Message msg) {
		this.targetVariable = target;
		this.msg = msg;
	}

	/**
	 * This methods sends the message of this action to the target of this
	 * action from the role given as parameter. It depends on the implementation
	 * of the input channel of the target whether this method blocks until the
	 * message is received at the target.
	 *
	 * @param source the role issuing the action
	 * @throws MessageNotAllowedAsInputException This exception is thrown if the
	 *             message is not allowed as input for the receiving role.
	 * @throws MessageNotAllowedAsOutputException This exception is thrown if
	 *             the message is not allowed as output for the sending role.
	 * @throws MessageNotAllowedBetweenRolesException This exception is thrown
	 *             if the message is exchanged between two roles which are not
	 *             in the same ensemble.
	 * @throws RoleInputChannelClosed This exception is thrown if the input
	 *             channel of the target role was already closed (e.g., because
	 *             the target left the ensemble).
	 * @throws NoFreeMessageSpotsException This exception is thrown if the input
	 *             channel of the target role does not have any free message
	 *             spots.
	 * @throws InterruptedException This exception is thrown if the process of
	 *             writing the message was interrupted.
	 */
	@Override
	void execute(Role source) throws MessageNotAllowedAsInputException,
	        MessageNotAllowedAsOutputException,
	        MessageNotAllowedBetweenRolesException, RoleInputChannelClosed,
	        NoFreeMessageSpotsException, InterruptedException {

		Role target = this.targetVariable.getValue();

		RoleType sourceType = source.getType();
		RoleType targetType = target.getType();
		MessageType msgType = this.msg.getType();

		// is message allowed for output?
		if (!sourceType.isAllowedForOutput(msgType)) {
			throw new MessageNotAllowedAsOutputException(msgType, sourceType);
		}

		// is message allowed for input?
		if (!targetType.isAllowedForInput(msgType)) {
			throw new MessageNotAllowedAsInputException(msgType, targetType);
		}

		source.sendMessage(target, this.msg);

		this.log.info("Role " + sourceType + " sent message " + msgType);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " for message type "
		        + this.msg.getType().getSimpleName();
	}
}
