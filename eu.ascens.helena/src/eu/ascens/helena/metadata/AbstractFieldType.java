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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.dev.exceptions.TypeDoesNotExistException;

/**
 * This class represents formal parameters and attributes.
 * 
 * @author Annabelle Klarl
 * @param <T> the type of the value of this field
 */
public abstract class AbstractFieldType<T> {

	private static Map<String, AbstractFieldType<?>> types = new HashMap<>();

	/**
	 * This method creates a field type for the given name and type. If there is
	 * none for the name and type, a new one is created. If there exists already
	 * one, an {@link TypeAlreadyExistsException} is thrown.
	 *
	 * @param type the name of the field
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 */
	static <T extends AbstractFieldType<?>> void checkAndAddType(T type)
			throws ConfigurationFinishedException, TypeAlreadyExistsException {
		if (ConfigurationManager.isConfigurationDone()) {
			throw new ConfigurationFinishedException(type.getType());
		}
		if (types.containsKey(type)) {
			throw new TypeAlreadyExistsException(type.getType());
		}

		types.put(type.getName(), type);
	}

	/**
	 * This method retrieves a field type for the given name and the given field
	 * type.
	 *
	 * @return
	 * @throws TypeDoesNotExistException This exception is thrown if there
	 *             exists not type for the given class.
	 */
	static <T extends AbstractFieldType<?>> T getType(String name,
			Class<T> clazz) throws TypeDoesNotExistException {
		if (!types.containsKey(name)) {
			throw new TypeDoesNotExistException(name);
		}
		AbstractFieldType<?> field = types.get(name);
		if (clazz.isInstance(field)) {
			return clazz.cast(field);
		}
		else {
			throw new TypeDoesNotExistException(name);
		}
	}

	// //////////// Abstract Field Type Declaration ///////////////////////

	private final String name;
	private final Class<? extends T> type;

	protected AbstractFieldType(String name, Class<? extends T> type) {
		this.name = name;
		this.type = type;
	}

	public Class<? extends T> getType() {
		return this.type;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractFieldType<?>)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		AbstractFieldType<?> other = (AbstractFieldType<?>) obj;
		return new EqualsBuilder().append(this.name, other.name).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(this.name).append(this.type)
				.toHashCode();
	}

	@Override
	public String toString() {
		return this.getName();
	}
}