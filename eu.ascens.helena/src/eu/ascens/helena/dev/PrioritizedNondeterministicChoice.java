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
import eu.ascens.helena.dev.exceptions.GuardNeverEvaluableException;
import eu.ascens.helena.dev.exceptions.InvokedProcessNotSetException;
import eu.ascens.helena.dev.exceptions.WellFormednessViolatedException;

/**
 * This class represents nondeterministic choice in Helena where the first
 * branch can be prioritized over the second branch.
 *
 * @author Annabelle Klarl
 */
public class PrioritizedNondeterministicChoice extends ProcessExpression {

	private final ProcessExpression p1;
	private final ProcessExpression p2;
	private final boolean firstBranchPrioritized;

	public PrioritizedNondeterministicChoice(ProcessExpression p1,
	        ProcessExpression p2, boolean firstBranchPrioritized) {
		this.p1 = p1;
		this.p2 = p2;
		this.firstBranchPrioritized = firstBranchPrioritized;
	}

	/**
	 * This method nondeterministically chooses one of the branches to execute
	 * the first action of it. However, if the flag
	 * {@code firstBranchPrioritized} is set, the first branch is prioritized
	 * over the second branch. This method assumes that at least one branch is
	 * executable. Therefore, an exception is thrown if the first action is not
	 * executable.
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
		ProcessExpression choice1 = null;
		ProcessExpression choice2 = null;

		if (this.firstBranchPrioritized) {
			choice1 = this.p1;
			choice2 = this.p2;
		}
		else if (Math.random() < 0.5) {
			choice1 = this.p1;
			choice2 = this.p2;
		}
		else {
			choice1 = this.p2;
			choice2 = this.p1;
		}

		try {
			return choice1.step(source);
		}
		catch (ActionCurrentlyNotExecutableException
		        | ActionNeverExecutableException e) {
			return choice2.step(source);
		}
	}

}
