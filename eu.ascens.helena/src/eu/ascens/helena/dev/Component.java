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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.OperationType;

/**
 * This is the abstract class for components in the Helena approach. A component
 * has a set of kernel attributes (which can be shared with its roles) and
 * manages a set of role instances which the component currently adopts. It can
 * adopt and give up roles, and can retrieve currently adopted roles.
 *
 * @author Annabelle Klarl
 */
public abstract class Component implements AbstractHelenaInstance {

	protected final ComponentType type;

	private final Lock lock;

	public Component() {
		this.type = ComponentType.getType(this.getClass());
		this.lock = new ReentrantLock();
	}

	public ComponentType getType() {
		return this.type;
	}

	/**
	 * This method locks the component.
	 */
	void lock() {
		this.lock.lock();
	}

	/**
	 * This method unlocks the component
	 */
	void unlock() {
		this.lock.unlock();
	}

	/**
	 * With this method the attribute of a component is retrieved.
	 *
	 * @param name the name of the component attribute to be retrieved
	 * @return
	 * @throws ReflectionException This exception is thrown if the attribute
	 *             could not be accessed via reflection.
	 */
	synchronized final Object getCompAttr(String name)
	        throws PropertyNotDeclaredInClassException, ReflectionException {
		try {
			Field field = FieldUtils.getField(this.type.getType(), name, true);
			Object value = field.get(this);
			return value;
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionException(this.getType().getClass());
		}
	}

	/**
	 * This method sets the role attribute with the given name to the given
	 * value. We assume that the role attribute exists and the type of the value
	 * fits to the role attribute.
	 *
	 * @param name the name of the role attribute to be set
	 * @param value the value to be set
	 * @throws ReflectionException This exception is thrown if the value could
	 *             not be set via reflection.
	 */
	synchronized final void setCompAttr(String name, Object value)
	        throws ReflectionException {
		try {
			this.lock.lock();
			Field field = FieldUtils.getField(this.type.getType(), name, true);
			field.set(this, value);
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ReflectionException(this.type.getType());
		}
		finally {
			this.lock.unlock();
		}
	}

	/**
	 * This method calls the given operation on this component. The actual
	 * values for the parameters are given in the operation. It returns the
	 * return value of executing the operation.
	 *
	 * @param op The operation with actual parameters to be called.
	 * @param returnType the return type of the operation
	 * @return
	 * @throws ReflectionException This exception is thrown if the operation
	 *             could not be called via reflection.
	 */
	synchronized final <T> T callOperation(Operation op, Class<T> returnType)
	        throws ReflectionException {
		OperationType opType = op.getType();
		try {
			List<? extends Variable<? extends Object>> actualDataParams = op
			        .getActualDataParams();
			Object[] actualDataParamsArray = new Object[actualDataParams
			        .size()];

			for (int i = 0; i < actualDataParams.size(); i++) {
				actualDataParamsArray[i] = actualDataParams.get(i).getValue();
			}

			return returnType
			        .cast(MethodUtils
			                .getAccessibleMethod(this.type.getType(),
			                        Character
			                                .toLowerCase(opType.getSimpleName()
			                                        .charAt(0))
			                        + opType.getSimpleName().substring(1),
			        opType.getAllFormalParamTypes())
			        .invoke(this, actualDataParamsArray));

		}
		catch (IllegalAccessException | IllegalArgumentException
		        | InvocationTargetException e) {
			throw new ReflectionException(this.type.getType());
		}
	}
}
