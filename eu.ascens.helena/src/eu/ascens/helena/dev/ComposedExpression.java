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

import java.util.Set;

import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;

/**
 * This class represents an expression which is composed from two expressions
 * and a binary operator.
 *
 * @author Annabelle Klarl
 */
public class ComposedExpression extends Expression {

	public enum ExpressionOperator {
		EQUAL, UNEQUAL;
	}

	private final Expression left;
	private final ExpressionOperator operator;
	private final Expression right;

	public ComposedExpression(Expression left, ExpressionOperator operator,
			Expression right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

	@Override
	Set<Component> lockObjects(Role source) {
		return Auxiliaries.unify(this.left.lockObjects(source),
				this.right.lockObjects(source));
	}

	/**
	 * This method evaluates the value of the two expressions under the operator
	 * for the source role.
	 *
	 * @param source the role for which the two expressions are evaluated
	 * @return
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the guard evaluates a property which is not defined in its
	 *             base class.
	 * @throws ReflectionException This exception is thrown if the guard
	 *             evaluates a property which could not be retrieved via
	 *             reflection.
	 */
	@Override
	Object getValue(Role source)
			throws PropertyNotDeclaredInClassException, ReflectionException {
		switch (this.operator) {
		case EQUAL:
			return this.left.getValue(source)
					.equals(this.right.getValue(source));
		case UNEQUAL:
			return !this.left.getValue(source)
					.equals(this.right.getValue(source));
		default:
			return null;
		}
	}

}
