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

import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.OperationType;

/**
 * This class represents the action of calling an operation on a component in
 * Helena.
 *
 * @author Annabelle Klarl
 */
public class OperationCallAction<T> extends Action {

	private final Variable<T> returnValue;
	private final Operation op;
	private final Class<T> returnType;

	public OperationCallAction(Variable<T> returnValue, Operation op,
			Class<T> returnType) {
		this.returnValue = returnValue;
		this.op = op;
		this.returnType = returnType;
	}

	/**
	 * This methods calls the given operation on the owning component of the
	 * source role. The actual values for the parameters are given in the
	 * operation. It set the return value in the given return variable of this
	 * class.
	 *
	 * @param source the role issuing the action
	 * @throws PropertyNotDeclaredInClassException This exception is thrown when
	 *             the operation is not declared in the owning component
	 * @throws ReflectionException This exception is thrown if the operation
	 *             could not be called via reflection.
	 */
	@Override
	void execute(Role source)
			throws PropertyNotDeclaredInClassException, ReflectionException {

		OperationType opType = this.op.getType();
		ComponentType compType = source.getOwner().getType();

		if (!compType.isAllowed(opType)
				|| (opType.getReturnType() != this.returnType)) {
			throw new PropertyNotDeclaredInClassException(
					opType.getSimpleName(), compType.getType());

		}

		T value = source.getOwner().callOperation(this.op, this.returnType);
		this.returnValue.setValue(value);

		this.log.info(
				"Role " + source.getType() + " called operation " + opType);
	}

}
