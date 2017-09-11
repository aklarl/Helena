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

import java.util.Observable;

import eu.ascens.helena.dev.exceptions.MessageNotExpectedException;
import eu.ascens.helena.dev.exceptions.NoFreeMessageSpotsException;
import eu.ascens.helena.dev.exceptions.NoMessageException;
import eu.ascens.helena.dev.exceptions.RoleInputChannelClosed;

/**
 * This class represents the abstract input channel of a role. The input channel
 * gets all messages for a certain role and can be queried for sent messages.
 *
 * @author Annabelle Klarl
 */
public abstract class RoleInputChannel extends Observable {

	protected boolean closed = false;

	public void close() {
		this.closed = true;
	}

	/**
	 * This methods returns the number of free message spots in the input
	 * channel.
	 *
	 * @return
	 */
	protected abstract int getFreeMessageSpots();

	/**
	 * This method transmits a message to this input channel from the "outside".
	 * After writing the message to the channel, all observers of the input
	 * channel are notified about the change. This method raises an
	 * {@link NoFreeMessageSpotsException} if the input channel does not have
	 * any more free message spots.
	 *
	 * @param msg the message to be written
	 * @throws RoleInputChannelClosed This exception is thrown if the method is
	 *             called while the channel is already closed (e.g., because the
	 *             target left the ensemble).
	 * @throws NoFreeMessageSpotsException This exception is thrown if the
	 *             method is called, but the input channel does not have any
	 *             free message spots.
	 * @throws InterruptedException This exception is thrown if the process of
	 *             writing the message was interrupted.
	 */
	final synchronized void write(Message msg) throws RoleInputChannelClosed,
			NoFreeMessageSpotsException, InterruptedException {
		if (this.closed) {
			throw new RoleInputChannelClosed();
		}

		if (this.getFreeMessageSpots() <= 0) {
			throw new NoFreeMessageSpotsException();
		}

		this.writeToChannel(msg);

		this.setChanged();
		this.notifyObservers();

		this.waitUntilMessageWasWritten(msg);
	}

	/**
	 * This method actually transmits a message (cf.
	 * {@link RoleInputChannel#write(Message)}). It does not check whether there
	 * are free message spots before!
	 *
	 * @param msg
	 */
	protected abstract void writeToChannel(Message msg);

	/**
	 * This method checks whether the given message was successfully written to
	 * the input channel. It depends on the implementing class what success
	 * means.
	 *
	 * @param msg
	 * @throws InterruptedException
	 */
	protected abstract void waitUntilMessageWasWritten(Message msg)
			throws InterruptedException;

	/**
	 * This method peeks a look at a message (cf.
	 * {@link RoleInputChannel#read(Class)}). The retrieved message might be
	 * null.
	 *
	 * @return
	 */
	protected abstract Message peekAtChannel();

	/**
	 * This methods retrieves a message from the input channel (ordering of
	 * messages depends on the implementing classes) which fits to the parameter
	 * {@code expectedMsgType}. After writing the message to the channel, all
	 * observers of the input channel are notified about the change. This method
	 * raises an {@link MessageNotExpectedException} if no fitting message is
	 * available.
	 *
	 * @return a message fitting to the parameter {@code
	 * expectedMsgType} from the input channel
	 * @throws RoleInputChannelClosed This exception is thrown if the method is
	 *             called while the channel is already closed (e.g., because the
	 *             target left the ensemble).
	 * @throws NoMessageException This exception is thrown if the method is
	 *             called, but the input channel does not contain any elements.
	 * @throws MessageNotExpectedException This exception is thrown if the
	 *             method is called, but the input channel did not receive a
	 *             message which fits to the message type given in the
	 *             parameter.
	 * @throws InterruptedException This exception is thrown when the reception
	 *             process was interrupted.
	 */
	final synchronized <T extends Message> T read(Class<T> expectedMsgType)
			throws RoleInputChannelClosed, NoMessageException,
			MessageNotExpectedException, InterruptedException {
		if (this.closed) {
			throw new RoleInputChannelClosed();
		}

		// peeking is necessary because if the first message is not the expected
		// message, we do not remove it from the input channel.
		Message testMsg = this.peekAtChannel();
		if (testMsg == null) {
			throw new NoMessageException();
		}
		if (!this.isMessageExpected(testMsg, expectedMsgType)) {
			throw new MessageNotExpectedException(testMsg.getClass());
		}

		@SuppressWarnings("unchecked") T msg = (T) this.takeFromChannel();

		this.setChanged();
		this.notifyObservers();

		return msg;
	}

	/**
	 * This methods actually takes the message from the channel (cf.
	 * {@link RoleInputChannel#read(Class)})
	 *
	 * @throws InterruptedException This exception is thrown when the reception
	 *             process was interrupted.
	 * @return
	 */
	protected abstract Message takeFromChannel() throws InterruptedException;

	/**
	 * This methods checks whether a message was expected (cf.
	 * {@link RoleInputChannel#read(Class)} .
	 *
	 * @param msg
	 * @param expectedMsgType
	 * @return
	 */
	protected boolean isMessageExpected(Message msg,
			Class<? extends Message> expectedMsgType) {
		return expectedMsgType.isInstance(msg);
	}
}
