
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

import scp.messages.ReqServiceMessage;
import scp.operations.PrintResultOperation;
import scp.messages.InformMessage;
import scp.messages.AckInformationMessage;
import scp.messages.SndServiceMessage;

public class Requester extends Role {

	// role attributes
	protected Boolean hasResult;

	// self variable
	protected final Variable<Requester> self = new Variable<>(Requester.class);

	// global variables for behavior

	protected final Variable<Executor> e = new Variable<>(Executor.class);
	protected final Variable<PotRequester> pr = new Variable<>(PotRequester.class);

	public Requester(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return new ActionPrefix(new ReceiveMessageAction(new InformMessage(e, pr)), new ActionPrefix(

				new SendMessageAction(this.pr, new AckInformationMessage()), new ActionPrefix(

						new SendMessageAction(this.e,
								new ReqServiceMessage(
										this.self)),
						new ActionPrefix(new ReceiveMessageAction(new SndServiceMessage()),
								new ActionPrefix(
										new RoleAttrSetterAction("hasResult",
												new Variable<Boolean>(new Boolean(true), Boolean.class)),
										new ActionPrefix(
												new OperationCallAction<>(new Variable<>(Void.class),
														new PrintResultOperation(), Void.class),
												Quit.getInstance()))))));
	}
}
