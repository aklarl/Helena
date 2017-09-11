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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;

/**
 * This class represents message types in Helena.
 *
 * @author Annabelle Klarl
 */
public class MessageType extends AbstractHelenaType<Message> {

	private static Map<Class<? extends Message>, MessageType> types = new HashMap<>();

	/**
	 * This method creates a message type for the given implementing class, the
	 * set of role instance parameter types and the set of data parameter types.
	 * 
	 * If there is none, a new one is created. If there exists already one, an
	 * {@link TypeAlreadyExistsException} is thrown.
	 *
	 * @param name the name of the implementing class
	 * @param roleParamTypes the role instance parameter types for this message
	 *            type
	 * @param dataParamTypes the data parameter types for this message type
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if a
	 *             parameter was not declared as parameter in the constructor of
	 *             this message type.
	 */
	public static MessageType createType(Class<? extends Message> name,
	        List<RoleFieldType> roleParamTypes,
	        List<DataFieldType> dataParamTypes)
	                throws ConfigurationFinishedException,
	                TypeAlreadyExistsException,
	                PropertyNotDeclaredInClassException {
		MessageType newMessageType = new MessageType(name, roleParamTypes,
		        dataParamTypes);
		AbstractHelenaType.checkAndAddType(newMessageType, types);
		return newMessageType;
	}

	/**
	 * This method retrieves a message type for the given implementing class.
	 *
	 * @param name the name of the implementing class
	 * @return
	 * @throws TypeDoesNotExistException This exception is thrown if there
	 *             exists not type for the given class.
	 */
	public static MessageType getType(Class<? extends Message> name) {
		return AbstractHelenaType.getType(name, types);
	}

	// //////////// Message Type Declaration ///////////////////////

	private final List<RoleFieldType> roleParamTypes;
	private final List<DataFieldType> dataParamTypes;

	private MessageType(Class<? extends Message> name,
	        List<RoleFieldType> roleParamTypes,
	        List<DataFieldType> dataParamTypes)
	                throws PropertyNotDeclaredInClassException {

		super(name);

		List<AbstractFieldType<?>> list = new ArrayList<>();
		list.addAll(roleParamTypes);
		list.addAll(dataParamTypes);
		Auxiliaries.checkThatAllParametersAreDeclared(list, name);

		this.roleParamTypes = roleParamTypes;
		this.dataParamTypes = dataParamTypes;
	}

}
