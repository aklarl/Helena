
package p2ptest;

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

import p2ptest.messages.SndAddr2Message;
import p2ptest.messages.SndFile2Message;

public class Requester2 extends Role {

	// role attributes
	protected Integer fileName;

	// self variable
	protected final Variable<Requester2> self = new Variable<>(Requester2.class);

	// global variables for behavior

	protected final Variable<Router2> router = new Variable<>(Router2.class);
	protected final Variable<Provider> prov = new Variable<>(Provider.class);
	protected final Variable<Router2> router2 = new Variable<>(Router2.class);
	protected final Variable<Integer> c = new Variable<>(Integer.class);

	public Requester2(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return new ActionPrefix(
				new CreateRoleAction<>(router, Router2.class, new CompAssociationGetter("neighbor").getValue(this)),
				new IfThenElse(new Atom(true), new ActionPrefix(
						new CreateRoleAction<>(router2, Router2.class,
								new CompAssociationGetter("neighbor").getValue(this)),
						new ActionPrefix(new ReceiveMessageAction(new SndAddr2Message(prov)), Quit.getInstance())),
						new ActionPrefix(new ReceiveMessageAction(new SndFile2Message(c)), Quit.getInstance())));
	}
}
