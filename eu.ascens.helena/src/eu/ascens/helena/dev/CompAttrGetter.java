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
import java.util.logging.Logger;

import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.DataFieldType;

/**
 * This class represents a getter for a component attribute of the owner of a
 * source role.
 *
 * @author Annabelle Klarl
 */
public class CompAttrGetter<T> extends Expression {

	protected final Logger log = Logger
			.getLogger("eu.ascens.helena.CompAttrGetterLogger");

	private final String fieldName;
	private final Class<T> type;

	public CompAttrGetter(String fieldName, Class<T> type) {
		this.fieldName = fieldName;
		this.type = type;
	}

	@Override
	Set<Component> lockObjects(Role source) {
		return Auxiliaries.getAsSet(source.getOwner());
	}

	/**
	 * This method evaluates the value of the component attribute of the owner
	 * of the source role.
	 *
	 * @param source the role for which the component attribute of its owner
	 *            should be evaluated
	 * @return
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the guard evaluates a property which is not defined in its
	 *             base class.
	 * @throws ReflectionException This exception is thrown if the guard
	 *             evaluates a property which could not be retrieved via
	 *             reflection.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getValue(Role source)
			throws PropertyNotDeclaredInClassException, ReflectionException {

		DataFieldType attrType = DataFieldType.getType(this.fieldName);
		ComponentType compType = source.getOwner().getType();

		if (!compType.isAllowed(attrType)
				|| (attrType.getType() != this.type)) {
			throw new PropertyNotDeclaredInClassException(this.fieldName,
					source.getOwner().getClass());

		}

		Object value = source.getOwner().getCompAttr(this.fieldName);

		this.log.fine("Role " + source.getType()
				+ " retrieved component attribute " + this.fieldName);

		return (T) value;
	}
}
