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

import eu.ascens.helena.metadata.MessageType;
import eu.ascens.helena.metadata.RoleType;

/**
 * This exception is thrown if a message is exchanged between two roles which
 * are not in the same ensemble.
 *
 * @author Annabelle Klarl
 */
public class MessageNotAllowedBetweenRolesException extends Exception {

	private static final long serialVersionUID = -7871473539092745541L;
	private MessageType msgType;
	private RoleType roleTypeOut;
	private RoleType roleTypeIn;

	public MessageNotAllowedBetweenRolesException(MessageType msgType,
	        RoleType roleTypeOut, RoleType roleTypeIn) {
		this.msgType = msgType;
		this.roleTypeOut = roleTypeOut;
		this.roleTypeIn = roleTypeIn;
	}

	@Override
	public String toString() {
		return this.msgType.getSimpleName() + " not allowed between "
		        + this.roleTypeOut.getSimpleName() + " and "
		        + this.roleTypeIn.getSimpleName()
		        + " since the roles are not in the same ensemble.";
	}
}
