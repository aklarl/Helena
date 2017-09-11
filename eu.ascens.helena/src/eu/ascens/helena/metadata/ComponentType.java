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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;

/**
 * This class represents component types in Helena.
 * 
 * @author Annabelle Klarl
 * 
 */
public class ComponentType extends AbstractHelenaType<Component> {

	private static Map<Class<? extends Component>, ComponentType> types = new HashMap<>();

	/**
	 * This method creates a component type for the given implementing class,
	 * the set of attribute types of this component type, a set of component
	 * types to which this component type is associated to, and a set of
	 * operations which are allowed to call on this component type.
	 * 
	 * If there is none for the implementing class, a new one is created. If
	 * there exists already one, an {@link TypeAlreadyExistsException} is
	 * thrown.
	 * 
	 * @param name
	 *            the name of the implementing class
	 * @param attrTypes
	 *            the attribute types for this component type
	 * @param assocTypes
	 *            the component association types to which this component type
	 *            is associated to
	 * @param opTypes
	 *            the operations types which are allowed to call on this
	 *            component type
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             an attribute or method was not declared in the base class of
	 *             this component type.
	 */
	public static ComponentType createType(Class<? extends Component> name,
	        Set<DataFieldType> attrTypes,
	        Set<ComponentAssociationType> assocTypes,
	        Set<OperationType> opTypes) throws ConfigurationFinishedException,
	                TypeAlreadyExistsException,
	                PropertyNotDeclaredInClassException {
		ComponentType compType = new ComponentType(name, attrTypes, assocTypes,
		        opTypes);
		AbstractHelenaType.checkAndAddType(compType, types);
		return compType;
	}

	/**
	 * This method creates a component type for the given implementing class,
	 * the set of attribute types of this component type, and a set of
	 * operations which are allowed to call on this component type. The set of
	 * associated component types will be empty.
	 * 
	 * If there is none, a new one is created. If there exists already one, an
	 * {@link TypeAlreadyExistsException} is thrown.
	 * 
	 * @param name
	 *            the name of the implementing class
	 * @param attrTypes
	 *            the attribute types for this component type to
	 * @param opTypes
	 *            the operations types which are allowed to call on this
	 *            component type
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             an attribute or method was not declared in the base class of
	 *             this component type.
	 */
	public static ComponentType createType(Class<? extends Component> name,
	        Set<DataFieldType> attrTypes, Set<OperationType> opTypes)
	                throws ConfigurationFinishedException,
	                TypeAlreadyExistsException,
	                PropertyNotDeclaredInClassException {
		return createType(name, attrTypes,
		        new HashSet<ComponentAssociationType>(), opTypes);
	}

	/**
	 * This method retrieves a component type for the given implementing class.
	 * 
	 * 
	 * @param name
	 *            the name of the implementing class
	 * @return
	 * @throws TypeDoesNotExistException This exception is thrown if there
	 *             exists not type for the given class.
	 */
	public static ComponentType getType(Class<? extends Component> name)
	        throws TypeDoesNotExistException {
		return AbstractHelenaType.getType(name, types);
	}

	// //////////// Component Type Declaration ///////////////////////

	private final Set<DataFieldType> attrTypes;
	private final Set<ComponentAssociationType> assocTypes;
	private final Set<OperationType> opTypes;

	private ComponentType(Class<? extends Component> name,
	        Set<DataFieldType> attrTypes,
	        Set<ComponentAssociationType> assocTypes,
	        Set<OperationType> opTypes)
	                throws PropertyNotDeclaredInClassException {

		super(name);

		Auxiliaries.checkThatAllFieldsAreDeclared(attrTypes, name);
		Auxiliaries.checkThatAllFieldsAreDeclared(assocTypes, name);

		Auxiliaries.checkThatAllMethodsAreDeclared(opTypes, name);

		this.attrTypes = attrTypes;
		this.assocTypes = assocTypes;
		this.opTypes = opTypes;
	}

	/**
	 * This method checks whether an attribute type is allowed for this
	 * component type.
	 * 
	 * @param attrType
	 * @return
	 */
	public boolean isAllowed(DataFieldType attrType) {
		return this.attrTypes.contains(attrType);
	}

	/**
	 * This method checks whether a component association type is allowed this
	 * component type.
	 * 
	 * @param compType
	 * @return
	 */
	public boolean isAllowed(ComponentAssociationType compType) {
		return this.assocTypes.contains(compType);
	}

	/**
	 * This method checks whether an operation type is allowed for this
	 * component type.
	 * 
	 * @param opType
	 * @return
	 */
	public boolean isAllowed(OperationType opType) {
		return this.opTypes.contains(opType);
	}
}
