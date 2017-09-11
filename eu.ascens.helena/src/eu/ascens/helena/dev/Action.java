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

import java.util.logging.Logger;

import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentIsNullException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.MessageNotAllowedAsInputException;
import eu.ascens.helena.dev.exceptions.MessageNotAllowedAsOutputException;
import eu.ascens.helena.dev.exceptions.MessageNotAllowedBetweenRolesException;
import eu.ascens.helena.dev.exceptions.MessageNotExpectedException;
import eu.ascens.helena.dev.exceptions.NoFreeMessageSpotsException;
import eu.ascens.helena.dev.exceptions.NoMessageException;
import eu.ascens.helena.dev.exceptions.NoRoleInstancesException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleInputChannelClosed;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;

/**
 * This class represents an abstract action in Helena.
 *
 * @author Annabelle Klarl
 */
public abstract class Action {

	protected final Logger log = Logger
			.getLogger("eu.ascens.helena.ActionLogger");

	/**
	 * This methods executes the action for the role given as parameter.
	 *
	 * @param source the role which executes the action
	 * @throws MessageNotAllowedAsInputException This exception is thrown if a
	 *             message should be received which is not allowed as input for
	 *             the receiving role.
	 * @throws MessageNotAllowedAsOutputException This exception is thrown if a
	 *             message should be sent which is not allowed as output for the
	 *             sending role.
	 * @throws MessageNotAllowedBetweenRolesException This exception is thrown
	 *             if a message is exchanged between two roles which are not in
	 *             the same ensemble.
	 * @throws RoleInputChannelClosed This exception is thrown if the input
	 *             channel of the target role was already closed (e.g., because
	 *             the target left the ensemble).
	 * @throws NoMessageException This exception is thrown if the input channel
	 *             of the role issuing this action does not contain any
	 *             elements.
	 * @throws MessageNotExpectedException This exception is thrown if a message
	 *             was received which was not expected.
	 * @throws NoFreeMessageSpotsException This exception is thrown if the input
	 *             channel of the target role does not have any free message
	 *             spots.
	 * @throws InterruptedException This exception is thrown if the process of
	 *             writing the message was interrupted.
	 * @throws RoleTypeNotAllowedForEnsembleException This exception is thrown
	 *             if the given role type is not part of the ensemble structure
	 *             of the issuing role.
	 * @throws RoleTypeNotAllowedForComponentTypeException This exception is
	 *             thrown if the given role type cannot be adopted by the type
	 *             of the given component.
	 * @throws ComponentIsNullException This exception is thrown if a component
	 *             should be accessed which is null (e.g. during a create or get
	 *             action).
	 * @throws ComponentNotInEnsembleException This exception is thrown if a
	 *             role should be created on a component which does not
	 *             contribute to the desired ensemble.
	 * @throws ComponentAlreadyAdoptsRoleException This exception is thrown if a
	 *             role should be created on a component which already adopts
	 *             it.
	 * @throws TooManyRoleInstancesException This exception is thrown if the
	 *             role type cannot be instantiated in the ensemble of the
	 *             issuing role since multiplicity limits were reached.
	 * @throws NoRoleInstancesException This exception is thrown if the given
	 *             owner does currently not adopt an instance of the given role
	 *             type in the ensemble of the source role of this action.
	 * @throws ReflectionException This exception is thrown if some error
	 *             occurred during trying to create a role via reflection.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the owner of the source role does not declare the attribute
	 *             or the type of the attribute and the value do not match.
	 */
	abstract void execute(Role source) throws MessageNotAllowedAsInputException,
			MessageNotAllowedAsOutputException,
			MessageNotAllowedBetweenRolesException, RoleInputChannelClosed,
			NoMessageException, MessageNotExpectedException,
			NoFreeMessageSpotsException, InterruptedException,
			RoleTypeNotAllowedForEnsembleException,
			RoleTypeNotAllowedForComponentTypeException,
			ComponentNotInEnsembleException,
			ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
			NoRoleInstancesException, ReflectionException,
			PropertyNotDeclaredInClassException, ComponentIsNullException;

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
