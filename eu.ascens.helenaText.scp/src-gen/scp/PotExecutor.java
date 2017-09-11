
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

import scp.messages.FindExecutorMessage;
import scp.messages.FoundExecutorMessage;

public class PotExecutor extends Role {

	// role attributes

	// self variable
	protected final Variable<PotExecutor> self = new Variable<>(PotExecutor.class);

	// global variables for behavior

	protected final Variable<PotExecutor> pe = new Variable<>(PotExecutor.class);
	protected final Variable<Initiator> i = new Variable<>(Initiator.class);
	protected final Variable<Executor> e = new Variable<>(Executor.class);
	protected final Variable<Integer> appReqs = new Variable<>(Integer.class);

	public PotExecutor(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return new ActionPrefix(new ReceiveMessageAction(new FindExecutorMessage(i, appReqs)), new IfThenElse(
				new ComposedExpression(new CompAttrGetter<>("reqs", Integer.class), ExpressionOperator.EQUAL,
						new Atom(this.appReqs.getValue())),
				new IfThenElse(new NotGuard(new PlaysQuery(this.getOwner(), Executor.class)),
						new ActionPrefix(new CreateRoleAction<>(e, Executor.class, this.getOwner()), new ActionPrefix(

								new SendMessageAction(this.i, new FoundExecutorMessage(this.e)), Quit.getInstance())),
						Quit.getInstance()),
				new IfThenElse(
						new NotGuard(new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
								PotExecutor.class)),
						new ActionPrefix(
								new CreateRoleAction<>(pe, PotExecutor.class,
										new CompAssociationGetter("neighbor").getValue(this)),
								new ActionPrefix(

										new SendMessageAction(this.pe, new FindExecutorMessage(this.i, this.appReqs)),
										Quit.getInstance())),
						Quit.getInstance())));
	}
}
