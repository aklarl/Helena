
package p2p;

import eu.ascens.helena.dev.ActionPrefix;
import eu.ascens.helena.dev.AndGuard;
import eu.ascens.helena.dev.Atom;
import eu.ascens.helena.dev.CreateRoleAction;
import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.CompAssociationGetter;
import eu.ascens.helena.dev.CompAttrGetter;
import eu.ascens.helena.dev.CompAttrSetterAction;
import eu.ascens.helena.dev.ComposedExpression;
import eu.ascens.helena.dev.ComposedExpression.ExpressionOperator;
import eu.ascens.helena.dev.GetRoleAction;
import eu.ascens.helena.dev.IfThenElse;
import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.NondeterministicChoice;
import eu.ascens.helena.dev.NotGuard;
import eu.ascens.helena.dev.OperationCallAction;
import eu.ascens.helena.dev.OrGuard;
import eu.ascens.helena.dev.PlaysQuery;
import eu.ascens.helena.dev.ProcessInvocation;
import eu.ascens.helena.dev.ProcessExpression;
import eu.ascens.helena.dev.Quit;
import eu.ascens.helena.dev.ReceiveMessageAction;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.RoleAttrGetter;
import eu.ascens.helena.dev.RoleAttrSetterAction;
import eu.ascens.helena.dev.SendMessageAction;
import eu.ascens.helena.dev.Variable;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;

import p2p.messages.ReqAddrMessage;
import p2p.messages.SndAddrMessage;

public class Router extends Role {

	// role attributes

	// self variable
	protected final Variable<Router> self = new Variable<>(Router.class);

	// global variables for behavior

	protected final Variable<Router> router = new Variable<>(Router.class);
	protected final Variable<Requester> req = new Variable<>(Requester.class);
	protected final Variable<Provider> provider = new Variable<>(Provider.class);

	public Router(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		ProcessInvocation invoc1396411732 = new ProcessInvocation();
		ProcessInvocation invoc159325278 = new ProcessInvocation();

		ProcessExpression routerProc = new ActionPrefix(new ReceiveMessageAction(new ReqAddrMessage(req)),
				new IfThenElse(new CompAttrGetter<>("hasFile", Boolean.class), new ActionPrefix(
						new CreateRoleAction<>(provider, Provider.class, this.getOwner()), new ActionPrefix(

								new SendMessageAction(this.req, new SndAddrMessage(this.provider)),
								Quit.getInstance())),
						new IfThenElse(
								new NotGuard(new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
										Router.class)),
								new ActionPrefix(
										new CreateRoleAction<>(router, Router.class,
												new CompAssociationGetter("neighbor").getValue(this)),
										new ActionPrefix(

												new SendMessageAction(this.router, new ReqAddrMessage(this.req)),
												invoc159325278)),
								Quit.getInstance())));

		invoc1396411732.setInvocatedProcess(routerProc);
		invoc159325278.setInvocatedProcess(routerProc);

		return routerProc;
	}
}
