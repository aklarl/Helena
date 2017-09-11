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
import eu.ascens.helena.dev.exceptions.MessageNotExpectedException;
import eu.ascens.helena.dev.exceptions.NoMessageException;
import eu.ascens.helena.dev.exceptions.RoleInputChannelClosed;
import eu.ascens.helena.metadata.MessageType;
import eu.ascens.helena.metadata.RoleType;

/**
 * This class represents the action of receiving a message in Helena.
 *
 * @author Annabelle Klarl
 */
public class ReceiveMessageAction extends Action {

	private final Message msg;

	/**
	 * Constructor
	 *
	 * @param msg a placeholder for the message to be received (its parameters
	 *            will be filled with the received values)
	 */
	public ReceiveMessageAction(Message msg) {
		this.msg = msg;
	}

	/**
	 * This methods receives a message fitting to the type given in this action
	 * by the role given as parameter. This method raises an
	 * {@link MessageNotExpectedException} if no fitting message is available.
	 * The effect of this method is that the message of this action if filled
	 * with the received values.
	 *
	 * @param source the role issuing the action
	 * @throws MessageNotAllowedAsInputException This exception is thrown if a
	 *             message should be received which is not allowed as input for
	 *             the receiving role.
	 * @throws RoleInputChannelClosed This exception is thrown if the input
	 *             channel of the receiving role was already closed (e.g.,
	 *             because it left the ensemble).
	 * @throws NoMessageException This exception is thrown if the input channel
	 *             of the receiving role does not contain any elements.
	 * @throws MessageNotExpectedException This exception is thrown if a message
	 *             was received which was not expected.
	 * @throws InterruptedException This exception is thrown if the process of
	 *             receiving the message was interrupted.
	 */
	@Override
	void execute(Role source) throws MessageNotAllowedAsInputException,
	        RoleInputChannelClosed, NoMessageException,
	        MessageNotExpectedException, InterruptedException {

		RoleType sourceType = source.getType();
		MessageType msgType = this.msg.getType();

		// is message allowed for input?
		if (!sourceType.isAllowedForInput(msgType)) {
			throw new MessageNotAllowedAsInputException(msgType, sourceType);
		}

		Message receivedMsg = source.receiveMessage(msgType.getType());
		this.msg.setParamsFrom(receivedMsg);

		this.log.info("Role " + sourceType + " received message "
		        + receivedMsg.getType());
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " for message type "
		        + this.msg.getType().getSimpleName();
	}
}
