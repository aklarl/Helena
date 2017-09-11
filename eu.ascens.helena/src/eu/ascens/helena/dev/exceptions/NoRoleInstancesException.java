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

import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.Role;

/**
 * This exception is thrown if a role instance should be retrieved from a
 * certain owner in a certain ensemble, but there is currently no such instance.
 *
 * @author Annabelle Klarl
 */
public class NoRoleInstancesException extends Exception {

	private static final long serialVersionUID = -7102116381526067973L;

	private Class<? extends Role> roleType;
	private Component owner;
	private Ensemble ensemble;

	public NoRoleInstancesException(Class<? extends Role> roleType,
			Component owner, Ensemble ensemble) {
		this.roleType = roleType;
		this.owner = owner;
		this.ensemble = ensemble;
	}

	@Override
	public String toString() {
		return "No role instances of type " + this.roleType + " on the owner "
				+ this.owner.getType() + " and ensemble "
				+ this.ensemble.getType() + " available.";
	}
}
