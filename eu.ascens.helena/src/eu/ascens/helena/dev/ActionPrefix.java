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

import eu.ascens.helena.dev.exceptions.ActionCurrentlyNotExecutableException;
import eu.ascens.helena.dev.exceptions.ActionNeverExecutableException;
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
import eu.ascens.helena.dev.exceptions.ParameterListNotEqualException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleInputChannelClosed;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;
import eu.ascens.helena.dev.exceptions.ValueNotMatchingVariableTypeException;
import eu.ascens.helena.dev.exceptions.WellFormednessViolatedException;

/**
 * This class represents action prefix.
 *
 * @author Annabelle Klarl
 */
public class ActionPrefix extends ProcessExpression {

	private final Action a;
	private final ProcessExpression p;

	public ActionPrefix(Action a, ProcessExpression p) {
		this.a = a;
		this.p = p;
	}

	/**
	 * This methods executes the action of action prefix for the role given as
	 * parameter if possible.
	 *
	 * @param source the role executing the process expression
	 * @return the process expression remaining to be executed after this action
	 * @throws WellFormednessViolatedException This exception is thrown if the
	 *             action to be executed was not well-formed according to the
	 *             well-formedness conditions of Helena (e.g., message was not
	 *             allowed as output or input, message exchange between roles of
	 *             two roles in different ensembles).
	 * @throws ActionCurrentlyNotExecutableException This exception is thrown if
	 *             the action could currently not be executed, but at a later
	 *             point in time the action might become executable (e.g., a
	 *             message should have been received, but the input channel was
	 *             empty or a message should have been sent, but the input
	 *             channel was full).
	 * @throws ActionNeverExecutableException This exception is thrown if the
	 *             action which could not be executed and will never become
	 *             executable (e.g., a message should have been sent or received
	 *             on an input channel which was already closed, a message was
	 *             received which was not expected).
	 */
	@Override
	ProcessExpression step(Role source) throws WellFormednessViolatedException,
			ActionCurrentlyNotExecutableException,
			ActionNeverExecutableException {
		try {
			this.a.execute(source);
		}
		catch (MessageNotAllowedAsInputException
				| MessageNotAllowedAsOutputException
				| MessageNotAllowedBetweenRolesException
				| ValueNotMatchingVariableTypeException
				| ParameterListNotEqualException
				| RoleTypeNotAllowedForEnsembleException
				| RoleTypeNotAllowedForComponentTypeException
				| ComponentNotInEnsembleException
				| PropertyNotDeclaredInClassException e) {
			throw new WellFormednessViolatedException(this.a, source, e);
		}
		catch (NoMessageException | NoFreeMessageSpotsException
				| ComponentAlreadyAdoptsRoleException
				| TooManyRoleInstancesException | NoRoleInstancesException e) {
			throw new ActionCurrentlyNotExecutableException(this.a, source, e);
		}
		catch (ComponentIsNullException | RoleInputChannelClosed
				| MessageNotExpectedException | InterruptedException
				| ReflectionException e) {
			throw new ActionNeverExecutableException(this.a, source, e);
		}
		return this.p;
	}

}
