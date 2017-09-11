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
import java.util.List;
import java.util.Map;

import eu.ascens.helena.dev.Operation;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;

/**
 * This class represents operation types in Helena.
 * 
 * @author Annabelle Klarl
 * 
 */
public class OperationType extends AbstractHelenaType<Operation> {

	private static Map<Class<? extends Operation>, OperationType> types = new HashMap<>();

	/**
	 * This method creates an operation type for the given implementing class,
	 * the data parameters, and the return type.
	 * 
	 * If there is none, a new one is created. If there exists already one, an
	 * {@link TypeAlreadyExistsException} is thrown.
	 * 
	 * @param name
	 *            the name of the implementing class
	 * @param dataparams the data parameter types for this message type
	 * @param returnType the type of the return value
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 */
	public static OperationType createType(Class<? extends Operation> name,
	        List<DataFieldType> dataparams, Class<?> returnType)
	                throws ConfigurationFinishedException,
	                TypeAlreadyExistsException {
		OperationType newOperationType = new OperationType(name, dataparams,
		        returnType);
		AbstractHelenaType.checkAndAddType(newOperationType, types);
		return newOperationType;
	}

	/**
	 * This method retrieves a message type for the given implementing class.
	 * 
	 * 
	 * @param name
	 *            the name of the implementing class
	 * @return
	 * @throws TypeDoesNotExistException This exception is thrown if there
	 *             exists not type for the given class.
	 */
	public static OperationType getType(Class<? extends Operation> name) {
		return AbstractHelenaType.getType(name, types);
	}

	// //////////// Operation Type Declaration ///////////////////////

	private final List<DataFieldType> dataParams;
	private final Class<?> returnType;

	private OperationType(Class<? extends Operation> name,
	        List<DataFieldType> dataparams, Class<?> returnType) {
		super(name);
		// we do not have to check that the parameters are defined as parameters
		// of the operation since this is already done in the corresponding
		// component type
		this.dataParams = dataparams;
		this.returnType = returnType;
	}

	public List<DataFieldType> getDataParams() {
		return this.dataParams;
	}

	public Class<?>[] getAllFormalParamTypes() {
		Class<?>[] allFormalParamTypes = new Class<?>[this.dataParams.size()];
		for (int i = 0; i < this.dataParams.size(); i++) {
			allFormalParamTypes[i] = this.dataParams.get(i).getType();
		}
		return allFormalParamTypes;
	}

	public Class<?> getReturnType() {
		return this.returnType;
	}
}
