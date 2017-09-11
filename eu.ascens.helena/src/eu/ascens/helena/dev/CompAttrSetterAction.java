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

import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.DataFieldType;

/**
 * This class represents the action of setting the attribute of a component in
 * Helena.
 *
 * @author Annabelle Klarl
 */
public class CompAttrSetterAction extends Action {

	private final String fieldName;
	private final Variable<?> fieldValue;

	/**
	 * Constructor
	 *
	 * @param fieldName the name of the field to be set
	 * @param fieldValue a variable representing the value to be set
	 */
	public CompAttrSetterAction(String fieldName, Variable<?> fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	/**
	 * Constructor
	 *
	 * @param fieldName the name of the field to be set
	 * @param fieldValue the value to be set
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> CompAttrSetterAction(String fieldName, T fieldValue) {
		this(fieldName, new Variable(fieldValue, fieldValue.getClass()));
	}

	/**
	 * This methods sets the value of the component attribute (given by name) of
	 * the owner of the source role.
	 *
	 * @param source the role issuing the action
	 * @throws TypeDoesNotExistException This exception is thrown if a data
	 *             field was requested which does not exist.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the owner of the source role does not declare the attribute
	 *             or the type of the attribute and the value do not match.
	 * @throws ReflectionException This exception is thrown if the component
	 *             attribute could not be accessed via reflection.
	 */
	@Override
	void execute(Role source) throws TypeDoesNotExistException,
			PropertyNotDeclaredInClassException, ReflectionException {

		DataFieldType attrType = DataFieldType.getType(this.fieldName);
		ComponentType compType = source.getOwner().getType();

		if (!compType.isAllowed(attrType)
				|| (attrType.getType() != this.fieldValue.getType())) {
			throw new PropertyNotDeclaredInClassException(this.fieldName,
					source.getOwner().getClass());

		}

		source.getOwner().setCompAttr(this.fieldName,
				this.fieldValue.getValue());

		this.log.info("Role " + source.getType() + " set component attribute "
				+ this.fieldName);
	}

}
