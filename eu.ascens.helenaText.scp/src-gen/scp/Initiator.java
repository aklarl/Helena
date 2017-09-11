
package scp;

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

import scp.messages.InitiateMessage;
import scp.messages.ExecuteMessage;
import scp.messages.FindExecutorMessage;
import scp.messages.FoundExecutorMessage;
import scp.messages.ExecutingMessage;
import scp.messages.FindRequesterMessage;

public class Initiator extends Role {

	// role attributes

	// self variable
	protected final Variable<Initiator> self = new Variable<>(Initiator.class);

	// global variables for behavior

	protected final Variable<PotRequester> pr = new Variable<>(PotRequester.class);
	protected final Variable<PotExecutor> pe = new Variable<>(PotExecutor.class);
	protected final Variable<Storage> s = new Variable<>(Storage.class);
	protected final Variable<Executor> e = new Variable<>(Executor.class);
	protected final Variable<Integer> appReqs = new Variable<>(Integer.class);
	protected final Variable<Integer> appID = new Variable<>(Integer.class);

	public Initiator(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return new ActionPrefix(new ReceiveMessageAction(new InitiateMessage(s, appID, appReqs)),
				new ActionPrefix(new CreateRoleAction<>(pe, PotExecutor.class, this.getOwner()), new ActionPrefix(

						new SendMessageAction(this.pe, new FindExecutorMessage(this.self, this.appReqs)),
						new ActionPrefix(new ReceiveMessageAction(new FoundExecutorMessage(e)), new ActionPrefix(

								new SendMessageAction(this.e,
										new ExecuteMessage(this.self, this.s,
												this.appID)),
								new ActionPrefix(new ReceiveMessageAction(new ExecutingMessage()),
										new ActionPrefix(
												new CreateRoleAction<>(pr, PotRequester.class,
														new CompAssociationGetter("neighbor").getValue(this)),
												new ActionPrefix(

														new SendMessageAction(this.pr, new FindRequesterMessage(this.e,
																new Variable<>(new CompAttrGetter<>("id", Integer.class)
																		.getValue(this), Integer.class))),
														Quit.getInstance()))))))));
	}
}
