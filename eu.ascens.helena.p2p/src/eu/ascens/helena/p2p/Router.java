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

import eu.ascens.helena.dev.ActionPrefix;
import eu.ascens.helena.dev.CompAssociationGetter;
import eu.ascens.helena.dev.CompAttrGetter;
import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.CreateRoleAction;
import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.IfThenElse;
import eu.ascens.helena.dev.PlaysQuery;
import eu.ascens.helena.dev.ProcessExpression;
import eu.ascens.helena.dev.ProcessInvocation;
import eu.ascens.helena.dev.Quit;
import eu.ascens.helena.dev.ReceiveMessageAction;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.SendMessageAction;
import eu.ascens.helena.dev.Variable;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.p2p.messages.ReqAddrMessage;
import eu.ascens.helena.p2p.messages.SndAddrMessage;

public class Router extends Role {

	// global variables for behavior
	protected final Variable<Router> self = new Variable<>(Router.class);
	protected final Variable<Requester> req = new Variable<>(Requester.class);
	protected final Variable<Provider> prov = new Variable<>(Provider.class);
	protected final Variable<Router> rout = new Variable<>(Router.class);

	public Router(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		ProcessInvocation createInvocation = new ProcessInvocation();
		ProcessInvocation provideInvocation = new ProcessInvocation();
		ProcessInvocation fwdInvocation = new ProcessInvocation();
		ProcessInvocation recursion = new ProcessInvocation();

		ProcessExpression routerProc = new ActionPrefix(
				new ReceiveMessageAction(new ReqAddrMessage(this.req)),
				new IfThenElse(new CompAttrGetter<>("hasFile", Boolean.class),
						provideInvocation, fwdInvocation));

		ProcessExpression provide = new ActionPrefix(
				new CreateRoleAction<>(this.prov, Provider.class,
						this.getOwner()),
				new ActionPrefix(
						new SendMessageAction(this.req,
								new SndAddrMessage(this.prov)),
						Quit.getInstance()));

		ProcessExpression fwd = new IfThenElse(new PlaysQuery(
				new CompAssociationGetter("neighbor").getValue(this),
				Router.class), Quit.getInstance(), createInvocation);

		ProcessExpression create = new ActionPrefix(
				new CreateRoleAction<>(this.rout, Router.class,
						new CompAssociationGetter("neighbor").getValue(this)),
				new ActionPrefix(new SendMessageAction(this.rout,
						new ReqAddrMessage(this.req)), recursion));

		provideInvocation.setInvocatedProcess(provide);
		fwdInvocation.setInvocatedProcess(fwd);
		createInvocation.setInvocatedProcess(create);
		recursion.setInvocatedProcess(routerProc);

		return routerProc;
	}
}
