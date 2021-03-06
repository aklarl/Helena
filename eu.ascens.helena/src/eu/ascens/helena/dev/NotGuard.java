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

import eu.ascens.helena.dev.exceptions.NoBooleanValueException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;

/**
 * This class represents a negation of a guard.
 *
 * @author Annabelle Klarl
 */
public class NotGuard extends Guard {

	private final Guard guard;

	public NotGuard(Guard guard) {
		this.guard = guard;
	}

	@Override
	Set<Component> lockObjects(Role source) {
		return this.guard.lockObjects(source);
	}

	/**
	 * This method evaluates whether the negation of a guard is true.
	 *
	 * @param source the role for which the guard should be evaluated
	 * @return
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the guard evaluates a property which is not defined in its
	 *             base class.
	 * @throws ReflectionException This exception is thrown if the guard
	 *             evaluates a property which could not be retrieved via
	 *             reflection.
	 * @throws NoBooleanValueException This exception is thrown if the guard did
	 *             not return a boolean value.
	 */
	@Override
	boolean isTrue(Role source) throws PropertyNotDeclaredInClassException,
			ReflectionException, NoBooleanValueException {
		return !this.guard.isTrue(source);
	}
}
