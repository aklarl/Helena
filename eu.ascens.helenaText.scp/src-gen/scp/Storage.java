
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
import scp.messages.StoreMessage;
import scp.messages.ReqCodeMessage;
import scp.messages.SndCodeMessage;

public class Storage extends Role {

	// role attributes

	// self variable
	protected final Variable<Storage> self = new Variable<>(Storage.class);

	// global variables for behavior

	protected final Variable<Initiator> i = new Variable<>(Initiator.class);
	protected final Variable<Executor> e = new Variable<>(Executor.class);
	protected final Variable<Integer> appCode = new Variable<>(Integer.class);
	protected final Variable<Integer> appReqs = new Variable<>(Integer.class);
	protected final Variable<Integer> appID = new Variable<>(Integer.class);

	public Storage(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return new ActionPrefix(new ReceiveMessageAction(new StoreMessage(appID, appReqs, appCode)),
				new ActionPrefix(new CompAttrSetterAction("code", this.appCode),
						new ActionPrefix(new CreateRoleAction<>(i, Initiator.class, this.getOwner()), new ActionPrefix(

								new SendMessageAction(this.i, new InitiateMessage(this.self, this.appID, this.appReqs)),
								new ActionPrefix(new ReceiveMessageAction(new ReqCodeMessage(e)), new ActionPrefix(

										new SendMessageAction(this.e,
												new SndCodeMessage(new Variable<>(
														new CompAttrGetter<>("code", Integer.class).getValue(this),
														Integer.class))),
										Quit.getInstance()))))));
	}
}
