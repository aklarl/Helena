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
package eu.ascens.helena.metadata;

import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;

/**
 * This class represents field types of role types in Helena
 * 
 * @author Annabelle Klarl
 */
public class RoleFieldType extends AbstractFieldType<Role> {

	/**
	 * This method creates a field type for a role type for the given name and
	 * type.
	 * 
	 * If there is none for the name and type, a new one is created. If
	 * there exists already one, an {@link TypeAlreadyExistsException} is
	 * thrown.
	 * 
	 * @param name the name of the field
	 * @param type the type of the field
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 */
	public static RoleFieldType createType(String name,
	        Class<? extends Role> type) throws ConfigurationFinishedException,
	                TypeAlreadyExistsException {

		RoleFieldType newRoleFieldType = new RoleFieldType(name, type);
		AbstractFieldType.checkAndAddType(newRoleFieldType);
		return newRoleFieldType;
	}

	/**
	 * This method retrieves an field type for a role type for the given name.
	 * 
	 * @return
	 * @throws TypeDoesNotExistException This exception is thrown if there
	 *             exists not type for the given class.
	 */
	public static RoleFieldType getType(String name)
	        throws TypeDoesNotExistException {
		return AbstractFieldType.getType(name, RoleFieldType.class);
	}

	// //////////// Role Field Type Declaration ///////////////////////

	private RoleFieldType(String name, Class<? extends Role> type) {
		super(name, type);
	}
}
