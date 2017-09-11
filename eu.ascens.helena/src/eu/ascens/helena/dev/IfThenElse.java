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

import java.util.Set;

import eu.ascens.helena.dev.exceptions.ActionCurrentlyNotExecutableException;
import eu.ascens.helena.dev.exceptions.ActionNeverExecutableException;
import eu.ascens.helena.dev.exceptions.ComponentIsNullException;
import eu.ascens.helena.dev.exceptions.GuardNeverEvaluableException;
import eu.ascens.helena.dev.exceptions.InvokedProcessNotSetException;
import eu.ascens.helena.dev.exceptions.NoBooleanValueException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.WellFormednessViolatedException;

/**
 * This class represents a process expression consisting of an if-then-else
 * construct.
 *
 * @author Annabelle Klarl
 */
public class IfThenElse extends ProcessExpression {

	private final Guard guard;
	private final ProcessExpression p1;
	private final ProcessExpression p2;

	public IfThenElse(Guard guard, ProcessExpression p1, ProcessExpression p2) {
		this.guard = guard;
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * This method performs chooses based on the guard one of the branches to
	 * execute the first action of it.
	 *
	 * @param source the role executing the process expression
	 * @return the process expression remaining to be executed after this action
	 * @throws WellFormednessViolatedException This exception is thrown if the
	 *             action to be executed was not well-formed according to the
	 *             well-formedness conditions of Helena (e.g., message was not
	 *             allowed as output or input, message exchange between roles of
	 *             two roles in different ensembles).
	 * @throws ActionCurrentlyNotExecutableException This exception is thrown if
	 *             there is no action which could currently not be executed, but
	 *             at a later point in time the next action might become
	 *             executable (e.g., a message should have been received, but
	 *             the input channel was empty or a message should have been
	 *             sent, but the input channel was full).
	 * @throws ActionNeverExecutableException This exception is thrown if there
	 *             is no action which could be executed and the next action will
	 *             never become executable (e.g., a message should have been
	 *             sent or received on an input channel which was already
	 *             closed, a message was received which was not expected).
	 * @throws GuardNeverEvaluableException This exception is thrown if the
	 *             guard of if-then-else could not be evaluated since either it
	 *             referred to attributes of roles/components which cannot be
	 *             accessed or the guard did not evaluate to true.
	 * @throws InvokedProcessNotSetException This exception is thrown if a
	 *             process invocation was used, but the invoked process was not
	 *             set.
	 */
	@Override
	ProcessExpression step(Role source) throws WellFormednessViolatedException,
			ActionCurrentlyNotExecutableException,
			ActionNeverExecutableException, GuardNeverEvaluableException,
			InvokedProcessNotSetException {

		Set<Component> locks = this.guard.lockObjects(source);

		// we do not need atomicity of guard evaluation and action execution
		// since the semantics of Helena only requires that the guards stay the
		// same until the action is executed
		try {
			for (Component lock : locks) {
				if (lock == null) {
					throw new ComponentIsNullException();
				}
				lock.lock();
			}

			if (this.guard.isTrue(source)) {
				return this.p1.step(source);
			}
			else {
				return this.p2.step(source);
			}
		}
		catch (ComponentIsNullException | PropertyNotDeclaredInClassException
				| ReflectionException | NoBooleanValueException e) {
			throw new GuardNeverEvaluableException(this.guard, source, e);
		}
		finally {
			for (Component lock : locks) {
				if (lock != null) {
					lock.unlock();
				}
			}
		}
	}

}
