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

import java.util.logging.Logger;

import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.metadata.ComponentAssociationType;
import eu.ascens.helena.metadata.ComponentType;

/**
 * This class represents a getter for a component association of a component.
 *
 * @author Annabelle Klarl
 */
public class CompAssociationGetter {

	protected final Logger log = Logger
			.getLogger("eu.ascens.helena.CompAssocGetterLogger");

	private final String assocName;

	public CompAssociationGetter(String assocName) {
		this.assocName = assocName;
	}

	/**
	 * This method evaluates the value of the component association of the owner
	 * of the source role.
	 *
	 * @param source the role for which the component association of its owner
	 *            should be evaluated
	 * @return
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the getter tries to retrieve an association which is not
	 *             declared in the owner.
	 * @throws ReflectionException This exception is thrown if the association
	 *             could not be retrieved via reflection.
	 */
	public Component getValue(Role source)
			throws PropertyNotDeclaredInClassException, ReflectionException {

		ComponentAssociationType assocType = ComponentAssociationType
				.getType(this.assocName);
		ComponentType compType = source.getOwner().getType();

		if (!compType.isAllowed(assocType)) {
			throw new PropertyNotDeclaredInClassException(this.assocName,
					source.getOwner().getClass());

		}

		Object value = source.getOwner().getCompAttr(this.assocName);

		this.log.fine("Role " + source.getType()
				+ " retrieved component association " + this.assocName);

		return (Component) value;
	}

}
