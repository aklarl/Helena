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

import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import eu.ascens.helena.dev.AbstractHelenaInstance;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;

/**
 * This class is the abstract super class for all types in Helena.
 *
 * @author Annabelle Klarl
 */
public class AbstractHelenaType<T extends AbstractHelenaInstance> {

	/**
	 * This method checks whether the given type can be added to the map of
	 * types and adds it if so.
	 *
	 * @param type
	 * @param types
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 */
	static <I extends AbstractHelenaInstance, T extends AbstractHelenaType<I>> void checkAndAddType(
			T type, Map<Class<? extends I>, T> types)
					throws ConfigurationFinishedException,
					TypeAlreadyExistsException {
		if (ConfigurationManager.isConfigurationDone()) {
			throw new ConfigurationFinishedException(type.getType());
		}
		if (types.containsKey(type.getType())) {
			throw new TypeAlreadyExistsException(type.getType());
		}
		types.put(type.getType(), type);
	}

	/**
	 * This method retrieve a type for the implementing class from the given map
	 * of types.
	 *
	 * @param name
	 * @param types
	 * @return
	 * @throws TypeDoesNotExistException This exception is thrown if there
	 *             exists not type for the given class.
	 */
	static <I extends AbstractHelenaInstance, T extends AbstractHelenaType<I>> T getType(
			Class<? extends I> name, Map<Class<? extends I>, T> types)
					throws TypeDoesNotExistException {
		Class<?> clazz = name;
		while (clazz != null) {
			if (types.containsKey(clazz)) {
				return types.get(clazz);
			}
			clazz = clazz.getSuperclass();
		}
		throw new TypeDoesNotExistException(name.getSimpleName());
	}

	// //// Abstract Helena Type Declaration //////////

	private final Class<? extends T> type;

	protected AbstractHelenaType(Class<? extends T> type) {
		this.type = type;
	}

	public Class<? extends T> getType() {
		return this.type;
	}

	public String getSimpleName() {
		return this.type.getSimpleName();
	}

	@Override
	public boolean equals(Object obj) {
		if (!this.getClass().isInstance(obj)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		@SuppressWarnings("unchecked") AbstractHelenaType<T> other = (AbstractHelenaType<T>) obj;
		return new EqualsBuilder().append(this.type, other.type).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(23, 17).append(this.type).toHashCode();
	}

	@Override
	public String toString() {
		return this.getSimpleName();
	}
}
