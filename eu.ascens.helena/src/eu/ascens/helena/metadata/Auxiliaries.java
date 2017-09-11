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

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import eu.ascens.helena.dev.Variable;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;

/**
 * This class holds all auxiliaries to check that fields and operations are
 * declared in base classes.
 *
 * @author Annabelle Klarl
 */
class Auxiliaries {

	/**
	 * This methods checks that all abstract field types given are declared as
	 * fields in the given class.
	 *
	 * @param fieldTypes
	 * @param clazz
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             an abstract field type is not declared as attribute in the
	 *             given class.
	 */
	static void checkThatAllFieldsAreDeclared(
			Collection<? extends AbstractFieldType<?>> fieldTypes,
			Class<?> clazz) throws PropertyNotDeclaredInClassException {

		for (AbstractFieldType<?> fieldType : fieldTypes) {
			if (FieldUtils.getField(clazz, fieldType.getName(), true) == null) {
				throw new PropertyNotDeclaredInClassException(
						fieldType.getName(), clazz);
			}
		}
	}

	/**
	 * This method checks that there is a constructor in the given class which
	 * declares all field types as variables.
	 *
	 * @param fieldTypes
	 * @param clazz
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             all field types are not declared as parameters in the
	 *             constructor of the given class.
	 */
	static void checkThatAllParametersAreDeclared(
			List<? extends AbstractFieldType<?>> fieldTypes, Class<?> clazz)
					throws PropertyNotDeclaredInClassException {

		Class<?>[] params = new Class<?>[fieldTypes.size()];
		for (int i = 0; i < fieldTypes.size(); i++) {
			params[i] = Variable.class;
		}

		try {
			clazz.getConstructor(params);
		}
		catch (NoSuchMethodException | SecurityException e) {
			throw new PropertyNotDeclaredInClassException("constructor", clazz);
		}
	}

	/**
	 * This methods checks that all operation types given are declared as
	 * methods in the given class.
	 *
	 * @param operationTypes
	 * @param clazz
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             an operation type is not declared as method in the given
	 *             class.
	 */
	static void checkThatAllMethodsAreDeclared(
			Collection<? extends OperationType> operationTypes, Class<?> clazz)
					throws PropertyNotDeclaredInClassException {

		for (OperationType operationType : operationTypes) {
			Method method = MethodUtils
					.getAccessibleMethod(clazz,
							Character
									.toLowerCase(operationType.getSimpleName()
											.charAt(0))
							+ operationType.getSimpleName().substring(1),
					operationType.getAllFormalParamTypes());
			if ((method == null) || (method.getReturnType() != operationType
					.getReturnType())) {
				throw new PropertyNotDeclaredInClassException(
						operationType.getSimpleName(), clazz);
			}
		}
	}
}
