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

import eu.ascens.helena.dev.exceptions.ValueNotMatchingVariableTypeException;

/**
 * This class represents a variable in Helena.
 *
 * @author Annabelle Klarl
 * @param <T> the type of the value in the variable
 */
public class Variable<T> {

	private T value;
	private final Class<T> type;

	/**
	 * Constructor initializing the variable with the value null
	 *
	 * @param type
	 */
	public Variable(Class<T> type) {
		this(null, type);
	}

	/**
	 * Constructor
	 * 
	 * @param value
	 * @param type
	 */
	public Variable(T value, Class<T> type) {
		this.value = value;
		this.type = type;
	}

	public T getValue() {
		return this.value;
	}

	@SuppressWarnings("unchecked")
	public void setValue(Object value)
			throws ValueNotMatchingVariableTypeException {
		if ((value != null) && (value.getClass() != this.type)) {
			throw new ValueNotMatchingVariableTypeException(value.getClass(),
					this.type.getClass());
		}

		this.value = (T) value;
	}

	public Class<T> getType() {
		return this.type;
	}
}
