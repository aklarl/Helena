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
import eu.ascens.helena.metadata.DataFieldType;
import eu.ascens.helena.metadata.RoleType;

/**
 * This class represents the action of setting the attribute of a role in
 * Helena.
 *
 * @author Annabelle Klarl
 */
public class RoleAttrSetterAction extends Action {

	private final String fieldName;
	private final Variable<?> fieldValue;

	/**
	 * Constructor
	 *
	 * @param fieldName the name of the field to be set
	 * @param fieldValue a variable representing the value to be set
	 */
	public RoleAttrSetterAction(String fieldName, Variable<?> fieldValue) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	/**
	 * Constructor
	 *
	 * @param fieldName the name of the field to be set
	 * @param fieldValue the value to be set
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> RoleAttrSetterAction(String fieldName, T value) {
		this(fieldName, new Variable(value, value.getClass()));
	}

	/**
	 * This methods sets the value of the role attribute (given by name) of the
	 * source role.
	 *
	 * @param source the role issuing the action
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the source role does not declared the attribute or the type
	 *             of the attribute and the value do not match.
	 * @throws ReflectionException This exception is thrown if the component
	 *             attribute could not be accessed via reflection.
	 */
	@Override
	void execute(Role source)
			throws PropertyNotDeclaredInClassException, ReflectionException {

		DataFieldType attrType = DataFieldType.getType(this.fieldName);
		RoleType roleType = source.getType();

		if (!roleType.isAllowed(attrType)
				|| (attrType.getType() != this.fieldValue.getType())) {
			throw new PropertyNotDeclaredInClassException(this.fieldName,
					roleType.getType());
		}

		source.setRoleAttr(this.fieldName, this.fieldValue.getValue());

		this.log.info(
				"Role " + roleType + " set role attribute " + this.fieldName);
	}

}
