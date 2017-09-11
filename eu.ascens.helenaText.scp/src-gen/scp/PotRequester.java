
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

import scp.messages.InformMessage;
import scp.messages.AckInformationMessage;
import scp.messages.FindRequesterMessage;

public class PotRequester extends Role {

	// role attributes

	// self variable
	protected final Variable<PotRequester> self = new Variable<>(PotRequester.class);

	// global variables for behavior

	protected final Variable<Executor> e = new Variable<>(Executor.class);
	protected final Variable<PotRequester> pr1 = new Variable<>(PotRequester.class);
	protected final Variable<Requester> r = new Variable<>(Requester.class);
	protected final Variable<PotRequester> pr2 = new Variable<>(PotRequester.class);
	protected final Variable<Integer> startID = new Variable<>(Integer.class);

	public PotRequester(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		ProcessInvocation invoc646354768 = new ProcessInvocation();

		ProcessExpression potRequesterProcess = new ActionPrefix(
				new ReceiveMessageAction(new FindRequesterMessage(e, startID)),
				new IfThenElse(new PlaysQuery(this.getOwner(), Requester.class),
						new ActionPrefix(new CreateRoleAction<>(r, Requester.class, this.getOwner()), new ActionPrefix(

								new SendMessageAction(this.r, new InformMessage(this.e, this.self)),
								new ActionPrefix(new ReceiveMessageAction(new AckInformationMessage()),
										new IfThenElse(
												new ComposedExpression(new CompAttrGetter<>("id", Integer.class),
														ExpressionOperator.UNEQUAL, new Atom(this.startID.getValue())),
												new IfThenElse(
														new NotGuard(
																new PlaysQuery(new CompAssociationGetter("neighbor")
																		.getValue(this), PotRequester.class)),
														new ActionPrefix(
																new CreateRoleAction<>(pr1, PotRequester.class,
																		new CompAssociationGetter("neighbor")
																				.getValue(this)),
																new ActionPrefix(

																		new SendMessageAction(this.pr1,
																				new FindRequesterMessage(this.e,
																						this.startID)),
																		Quit.getInstance())),
														Quit.getInstance()),
												Quit.getInstance())))),
						new IfThenElse(
								new ComposedExpression(new CompAttrGetter<>("id", Integer.class),
										ExpressionOperator.UNEQUAL, new Atom(this.startID.getValue())),
								new IfThenElse(
										new NotGuard(
												new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
														PotRequester.class)),
										new ActionPrefix(
												new CreateRoleAction<>(pr2, PotRequester.class,
														new CompAssociationGetter("neighbor").getValue(this)),
												new ActionPrefix(

														new SendMessageAction(this.pr2,
																new FindRequesterMessage(this.e, this.startID)),
														Quit.getInstance())),
										Quit.getInstance()),
								Quit.getInstance())));

		invoc646354768.setInvocatedProcess(potRequesterProcess);

		return potRequesterProcess;
	}
}
