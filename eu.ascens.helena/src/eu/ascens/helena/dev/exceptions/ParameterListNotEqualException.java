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
package eu.ascens.helena.dev.exceptions;

/**
 * This exception is thrown if two messages were compared/traversed and their
 * parameter lists were not equal (e.g., one was shorter).
 * 
 * @author Annabelle Klarl
 *
 */
public class ParameterListNotEqualException extends RuntimeException {

	private static final long serialVersionUID = -3146770857545138201L;

	private ParamListType listType;
	private int desiredListSize;
	private int actualListSize;

	public ParameterListNotEqualException(ParamListType listType,
	        int desiredSize, int actualSize) {
		this.desiredListSize = desiredSize;
		this.actualListSize = actualSize;
	}

	public enum ParamListType {
		ROLE_PARAMS("roleparams"), DATA_PARAMS("dataparams");

		private String type;

		private ParamListType(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return this.type;
		}
	}

	@Override
	public String toString() {
		return "Size of list of " + this.listType + " not equal. Desired size: "
		        + this.desiredListSize + ", actual size: " + this.actualListSize;
	}
}
