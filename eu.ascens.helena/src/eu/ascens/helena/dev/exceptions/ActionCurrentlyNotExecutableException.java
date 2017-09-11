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

import eu.ascens.helena.dev.Action;
import eu.ascens.helena.dev.Role;

/**
 * This class represents all exceptions which are caused by an action which is
 * syntactically allowed (fulfills Helena process term grammar and is
 * well-formed), but is currently not executable. This action might become
 * executable again at a later point in the execution.
 *
 * @author Annabelle Klarl
 */
public class ActionCurrentlyNotExecutableException
		extends HelenaRuntimeException {

	private static final long serialVersionUID = 6011599886418487621L;

	public ActionCurrentlyNotExecutableException(Action action, Role role,
			Exception cause) {
		super(action, role, cause);
	}
}