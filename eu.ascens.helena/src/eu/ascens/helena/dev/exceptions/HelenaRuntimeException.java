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
package eu.ascens.helena.dev.exceptions;

import eu.ascens.helena.dev.Action;
import eu.ascens.helena.dev.Role;

/**
 * This class represents the super class of all exceptions which can occur
 * during execution of a Helena ensemble. This exception is always caused during
 * executing an action.
 *
 * @author Annabelle Klarl
 */
public abstract class HelenaRuntimeException extends Exception {

	private static final long serialVersionUID = 1486948472265855728L;

	protected Action action;
	protected Role role;
	protected Exception cause;

	public HelenaRuntimeException(Action action, Role role, Exception cause) {
		this.action = action;
		this.role = role;
		this.cause = cause;
	}

	public Action getAction() {
		return this.action;
	}

	@Override
	public Exception getCause() {
		return this.cause;
	}

	@Override
	public String toString() {
		if (this.action != null) {
			return "The exception " + this.getClass().getSimpleName()
					+ " occurred during executing the action " + this.action
					+ " for " + this.role.getType() + ". Cause: " + this.cause;
		}
		else {
			return "The exception " + this.getClass().getSimpleName()
					+ " occurred during executing an unknown action. Cause: "
					+ this.cause;
		}
	}
}
