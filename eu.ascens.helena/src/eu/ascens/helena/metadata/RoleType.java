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
import java.util.Map;
import java.util.Set;

import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;

/**
 * This class represents role types in Helena.
 * 
 * @author Annabelle Klarl
 */
public class RoleType extends AbstractHelenaType<Role> {

	private static Map<Class<? extends Role>, RoleType> types = new HashMap<>();

	/**
	 * This method creates a role type for the given implementing class, the set
	 * of component types that are allowed for its owner, the set of attribute
	 * types of this role type, a set of messages which are allowed as outgoing
	 * messages and a set of messages which are allowed as incoming messages.
	 * 
	 * If there is none for the implementing class, a new one is created. If
	 * there exists already one, an {@link TypeAlreadyExistsException} is
	 * thrown.
	 * 
	 * @param name the name of the implementing class
	 * @param compTypes the component types which are allowed for owners
	 * @param attrTypes the attribute types for this role type
	 * @param msgTypesOut the message types which are allowed as outgoing
	 *            messages
	 * @param msgTypesIn the message types which are allowed as incoming
	 *            messages
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             an attribute was not declared in the base class of this role
	 *             type.
	 */
	public static RoleType createType(Class<? extends Role> name,
	        Set<ComponentType> compTypes, Set<DataFieldType> attrTypes,
	        Set<MessageType> msgTypesOut, Set<MessageType> msgTypesIn)
	                throws ConfigurationFinishedException,
	                TypeAlreadyExistsException,
	                PropertyNotDeclaredInClassException {
		RoleType roleType = new RoleType(name, compTypes, attrTypes,
		        msgTypesOut, msgTypesIn);
		AbstractHelenaType.checkAndAddType(roleType, types);
		return roleType;
	}

	/**
	 * This method retrieves a role type for the given implementing class.
	 * 
	 * @param name the name of the implementing class
	 * @return
	 * @throws TypeDoesNotExistException This exception is thrown if there
	 *             exists not type for the given class.
	 */
	public static RoleType getType(Class<? extends Role> name)
	        throws TypeDoesNotExistException {
		return AbstractHelenaType.getType(name, types);
	}

	// //////////// Role Type Declaration ///////////////////////

	private final Set<ComponentType> compTypes;
	private final Set<DataFieldType> attrTypes;
	private final Set<MessageType> msgTypesOut;
	private final Set<MessageType> msgTypesIn;

	private RoleType(Class<? extends Role> name, Set<ComponentType> compTypes,
	        Set<DataFieldType> attrTypes, Set<MessageType> msgTypesOut,
	        Set<MessageType> msgTypesIn)
	                throws PropertyNotDeclaredInClassException {

		super(name);

		Auxiliaries.checkThatAllFieldsAreDeclared(attrTypes, name);

		this.compTypes = compTypes;
		this.attrTypes = attrTypes;
		this.msgTypesOut = msgTypesOut;
		this.msgTypesIn = msgTypesIn;
	}

	/**
	 * This method checks whether an instance of the given role type can have an
	 * owner of the given component type.
	 * 
	 * @param compType
	 * @return
	 */
	public <T extends Component> boolean isAllowed(ComponentType compType) {
		return this.compTypes.contains(compType);
	}

	/**
	 * This method checks whether an attribute type is allowed for this role
	 * type.
	 * 
	 * @param attrType
	 * @return
	 */
	public boolean isAllowed(DataFieldType attrType) {
		return this.attrTypes.contains(attrType);
	}

	/**
	 * This method checks whether an instance of the given role type can receive
	 * a message of the given message type.
	 * 
	 * @param msgType
	 * @return
	 */
	public boolean isAllowedForInput(MessageType msgType) {
		return this.msgTypesIn.contains(msgType);
	}

	/**
	 * This method checks whether an instance of the given role type can send a
	 * message of the given message type.
	 * 
	 * @param msgType
	 * @return
	 */
	public boolean isAllowedForOutput(MessageType msgType) {
		return this.msgTypesOut.contains(msgType);
	}
}
