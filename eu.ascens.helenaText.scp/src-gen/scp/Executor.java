
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
import scp.messages.ExecuteMessage;
import scp.messages.ReqCodeMessage;
import scp.messages.SndCodeMessage;
import scp.messages.ExecutingMessage;
import scp.messages.SndServiceMessage;

public class Executor extends Role {

	// role attributes

	// self variable
	protected final Variable<Executor> self = new Variable<>(Executor.class);

	// global variables for behavior

	protected final Variable<Initiator> i = new Variable<>(Initiator.class);
	protected final Variable<Storage> s = new Variable<>(Storage.class);
	protected final Variable<Requester> r = new Variable<>(Requester.class);
	protected final Variable<Integer> appCode = new Variable<>(Integer.class);
	protected final Variable<Integer> appID = new Variable<>(Integer.class);

	public Executor(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		ProcessInvocation invoc2068226486 = new ProcessInvocation();
		ProcessInvocation invoc1338733353 = new ProcessInvocation();
		ProcessInvocation invoc881561231 = new ProcessInvocation();

		ProcessExpression executorProcess = new ActionPrefix(new ReceiveMessageAction(new ExecuteMessage(i, s, appID)),
				new ActionPrefix(

						new SendMessageAction(this.s,
								new ReqCodeMessage(
										this.self)),
						new ActionPrefix(new ReceiveMessageAction(new SndCodeMessage(appCode)),
								new ActionPrefix(
										new CompAttrSetterAction("isExecuting",
												new Variable<Boolean>(new Boolean(true), Boolean.class)),
										new ActionPrefix(

												new SendMessageAction(this.i, new ExecutingMessage()),
												invoc1338733353)))));
		ProcessExpression executorRunning = new ActionPrefix(new ReceiveMessageAction(new ReqServiceMessage(r)),
				new ActionPrefix(

						new SendMessageAction(this.r, new SndServiceMessage()), invoc881561231));

		invoc2068226486.setInvocatedProcess(executorProcess);
		invoc1338733353.setInvocatedProcess(executorRunning);
		invoc881561231.setInvocatedProcess(executorRunning);

		return executorProcess;
	}
}
