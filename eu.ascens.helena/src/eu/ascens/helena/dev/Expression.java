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

import eu.ascens.helena.dev.exceptions.NoBooleanValueException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;

/**
 * This class represents abstract expressions which can serve as guards.
 *
 * @author Annabelle Klarl
 */
public abstract class Expression extends Guard {

	@Override
	boolean isTrue(Role source) throws PropertyNotDeclaredInClassException,
			ReflectionException, NoBooleanValueException {
		Object value = this.getValue(source);

		if (!(value instanceof Boolean)) {
			throw new NoBooleanValueException(this);
		}

		return (Boolean) value;
	}

	abstract Object getValue(Role source)
			throws PropertyNotDeclaredInClassException, ReflectionException;

}
