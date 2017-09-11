
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

import p2ptest.messages.SndAddrMessage;
import p2ptest.operations.ComputeOperation;
import p2ptest.messages.ReqFileMessage;
import p2ptest.messages.SndFileMessage;
import p2ptest.operations.RandomStepOperation;
import p2ptest.messages.ReqAddrMessage;

public class Requester extends Role {

	// role attributes
	protected Integer fileName;

	// self variable
	protected final Variable<Requester> self = new Variable<>(Requester.class);

	// global variables for behavior

	protected final Variable<Router> router = new Variable<>(Router.class);
	protected final Variable<Provider> prov = new Variable<>(Provider.class);
	protected final Variable<Integer> cont2 = new Variable<>(Integer.class);

	protected final Variable<Integer> cont3 = new Variable<>(Integer.class);

	public Requester(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return new ActionPrefix(
				new CreateRoleAction<>(router, Router.class, new CompAssociationGetter("neighbor").getValue(this)),
				new ActionPrefix(

						new SendMessageAction(this.router, new ReqAddrMessage(this.self)),
						new ActionPrefix(new ReceiveMessageAction(new SndAddrMessage(prov)), new ActionPrefix(

								new SendMessageAction(this.prov, new ReqFileMessage(this.self)),
								new ActionPrefix(new ReceiveMessageAction(new SndFileMessage(cont2)), new ActionPrefix(
										new OperationCallAction<>(new Variable<>(Void.class),
												new RandomStepOperation(), Void.class),
										new ActionPrefix(
												new OperationCallAction<>(
														new Variable<>(
																Integer.class),
														new ComputeOperation(
																new Variable<>(
																		new CompAttrGetter<>("content", Integer.class)
																				.getValue(this),
																		Integer.class),
																new Variable<>(
																		new CompAttrGetter<>("hasFile", Boolean.class)
																				.getValue(this),
																		Boolean.class)),
														Integer.class),
												new ActionPrefix(new CompAttrSetterAction("content", this.cont3),
														new ActionPrefix(
																new CompAttrSetterAction("content", this.cont2),
																Quit.getInstance())))))))));
	}
}
