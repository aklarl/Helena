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

import java.lang.reflect.Field;
import java.util.Observable;
import java.util.logging.Logger;

import org.apache.commons.lang3.reflect.FieldUtils;

import eu.ascens.helena.dev.exceptions.ActionCurrentlyNotExecutableException;
import eu.ascens.helena.dev.exceptions.ActionNeverExecutableException;
import eu.ascens.helena.dev.exceptions.GuardNeverEvaluableException;
import eu.ascens.helena.dev.exceptions.InvokedProcessNotSetException;
import eu.ascens.helena.dev.exceptions.MessageNotAllowedBetweenRolesException;
import eu.ascens.helena.dev.exceptions.MessageNotExpectedException;
import eu.ascens.helena.dev.exceptions.NoFreeMessageSpotsException;
import eu.ascens.helena.dev.exceptions.NoMessageException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleInputChannelClosed;
import eu.ascens.helena.dev.exceptions.WellFormednessViolatedException;
import eu.ascens.helena.metadata.RoleType;

/**
 * This is the abstract class for role instances in the Helena approach. Each
 * role instance is adopted by a particular component given by the attribute
 * {@code owner} and is part of an ensemble. Messages are sent between roles and
 * retrieved via ONE input channel at the target.
 *
 * @author Annabelle Klarl
 */
public abstract class Role extends Observable
        implements Runnable, AbstractHelenaInstance {

	protected final Logger log = Logger
	        .getLogger("eu.ascens.helena.RoleLogger");

	private final RoleType type;

	private final Ensemble ens;
	private final Component owner;
	private final RoleInputChannel input;

	private ProcessExpression p;
	private Thread thread;

	/**
	 * Constructor: An implementing class should not offer this constructor, but
	 * rather fix the value for the input channel
	 *
	 * @param owner
	 * @param ens
	 * @param input
	 * @throws ReflectionException
	 */
	protected Role(Component owner, Ensemble ens, Integer capacity) {
		this.type = RoleType.getType(this.getClass());

		this.owner = owner;
		this.ens = ens;
		if (capacity == 0) {
			this.input = new SynchronousInputChannel();
		}
		else {
			this.input = new AsynchronousInputChannel(capacity);
		}
	}

	public RoleType getType() {
		return this.type;
	}

	public Ensemble getEnsemble() {
		return this.ens;
	}

	public Component getOwner() {
		return this.owner;
	}

	void start()
	        throws ReflectionException, PropertyNotDeclaredInClassException {
		this.p = this.initializeRoleBehavior();
		this.thread = new Thread(this);
		this.thread.start();
	}

	/**
	 * This method initializes the process expression representing the role
	 * behavior
	 *
	 * @throws ReflectionException This exception is thrown if a property or
	 *             class could not be accessed via reflection.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if a
	 *             property was not declared in its Java representation.
	 */
	protected abstract ProcessExpression initializeRoleBehavior()
	        throws ReflectionException, PropertyNotDeclaredInClassException;

	@Override
	public final void run() {
		if (this.owner == null) {
			this.log.severe("The role " + this.type
			        + " has not been adopted yet and therefore its behavior cannot be executed.");
		}

		else {
			// we implement busy waiting if the next action is not executable
			try {
				while (!(this.p instanceof Bottom)) {
					try {
						this.p = this.p.step(this);
					}
					catch (ActionCurrentlyNotExecutableException e) {
						this.log.fine(e.toString());
						Thread.sleep(10);
					}
				}
			}
			catch (ActionNeverExecutableException
			        | WellFormednessViolatedException
			        | GuardNeverEvaluableException
			        | InvokedProcessNotSetException | InterruptedException e) {
				this.log.severe(e.toString());
				this.quit();
			}
		}
	}

	/**
	 * This methods terminate the behavior of a role. It advises the ensemble to
	 * give up the role and closes the role's input channel.
	 */
	final void quit() {
		this.input.close();
		this.ens.quitRole(this);
	}

	/**
	 * This method sends a message to the target.
	 *
	 * @param target the target role where to send the message to
	 * @param msg the message to be sent
	 * @throws MessageNotAllowedBetweenRolesException This exception is thrown
	 *             if the message is exchanged between two roles which are not
	 *             in the same ensemble.
	 * @throws RoleInputChannelClosed This exception is thrown if the method is
	 *             called while the channel of the receiver is already closed
	 *             (e.g., because the target left the ensemble).
	 * @throws NoFreeMessageSpotsException This exception is thrown if the
	 *             method is called, but the input channel of the receiver does
	 *             not have any free message spots.
	 * @throws InterruptedException This exception is thrown if the process of
	 *             writing the message was interrupted.
	 */
	final void sendMessage(Role target, Message msg)
	        throws MessageNotAllowedBetweenRolesException,
	        RoleInputChannelClosed, NoFreeMessageSpotsException,
	        InterruptedException {
		// are source and target in the same ensemble?
		if (!this.getEnsemble().equals(target.getEnsemble())) {
			throw new MessageNotAllowedBetweenRolesException(msg.getType(),
			        this.getType(), target.getType());
		}
		target.input.write(msg);
	}

	/**
	 * This method receives a message on the role's input channel (ordering of
	 * messages depends on the implementing classes) which fits to the parameter
	 * {@code expectedMsgType}.
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
	final <T extends Message> T receiveMessage(Class<T> expectedMsgType)
	        throws RoleInputChannelClosed, NoMessageException,
	        MessageNotExpectedException, InterruptedException {
		return this.input.read(expectedMsgType);
	}

	/**
	 * This method sets the role attribute with the given name to the given
	 * value. We assume that the role attribute exists and the type of the value
	 * fits to the role attribute.
	 *
	 * @param name the name of the role attribute to be set
	 * @param value the value to be set
	 * @throws ReflectionException This exception is thrown if the value could
	 *             not be set via reflection.
	 */
	final void setRoleAttr(String name, Object value)
	        throws ReflectionException {
		try {
			Field field = FieldUtils.getField(this.type.getType(), name, true);
			field.set(this, value);
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionException(this.type.getType());
		}
	}

	/**
	 * With this method the attribute of a role is retrieved.
	 *
	 * @param name the name of the role attribute to be retrieved
	 * @return
	 * @throws ReflectionException This exception is thrown if the attribute
	 *             could not be accessed via reflection.
	 */
	final Object getRoleAttr(String name)
	        throws PropertyNotDeclaredInClassException, ReflectionException {
		try {
			Field field = FieldUtils.getField(this.type.getType(), name, true);
			return field.get(this);
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionException(this.getType().getClass());
		}
	}
}
