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
package eu.ascens.helena.p2p;

import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.CompAttrGetter;
import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.ProcessExpression;
import eu.ascens.helena.dev.Quit;
import eu.ascens.helena.dev.ReceiveMessageAction;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.SendMessageAction;
import eu.ascens.helena.dev.Variable;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.p2p.messages.ReqFileMessage;
import eu.ascens.helena.p2p.messages.SndFileMessage;

public class Provider extends Role {

	// global variables for behavior
	protected final Variable<Provider> self = new Variable<>(Provider.class);
	protected final Variable<Requester> req = new Variable<>(Requester.class);

	public Provider(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return Auxiliaries.buildActionPrefix(Quit.getInstance(),
				new ReceiveMessageAction(new ReqFileMessage(this.req)),
				new SendMessageAction(this.req,
						new SndFileMessage(new Variable<>(
								new CompAttrGetter<>("content",
										Integer.class).getValue(this),
								Integer.class))));
	}
}