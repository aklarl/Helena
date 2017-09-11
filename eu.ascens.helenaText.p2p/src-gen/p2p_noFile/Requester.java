
package p2p_noFile;

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

import p2p_noFile.messages.ReqFileMessage;
import p2p_noFile.operations.PrintFileOperation;
import p2p_noFile.messages.ReqAddrMessage;
import p2p_noFile.messages.TaskDoneMessage;
import p2p_noFile.messages.NoFileMessage;
import p2p_noFile.messages.SndFileMessage;
import p2p_noFile.messages.SndAddrMessage;

public class Requester extends Role {

	// role attributes
	protected Boolean hasFile;

	// self variable
	protected final Variable<Requester> self = new Variable<>(Requester.class);

	// global variables for behavior

	protected final Variable<Provider> prov = new Variable<>(Provider.class);
	protected final Variable<Router> router = new Variable<>(Router.class);
	protected final Variable<Integer> content = new Variable<>(Integer.class);

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

						new SendMessageAction(this.router, new ReqAddrMessage(this.self)), new NondeterministicChoice(
								new ActionPrefix(new ReceiveMessageAction(new SndAddrMessage(prov)), new ActionPrefix(

										new SendMessageAction(this.prov,
												new ReqFileMessage(this.self)),
										new ActionPrefix(
												new ReceiveMessageAction(
														new SndFileMessage(content)),
												new ActionPrefix(
														new CompAttrSetterAction("content",
																this.content),
														new ActionPrefix(
																new CompAttrSetterAction("hasFile",
																		new Variable<Boolean>(new Boolean(true),
																				Boolean.class)),
																new ActionPrefix(
																		new RoleAttrSetterAction("hasFile",
																				new Variable<Boolean>(new Boolean(true),
																						Boolean.class)),
																		new ActionPrefix(new OperationCallAction<>(
																				new Variable<>(Void.class),
																				new PrintFileOperation(), Void.class),
																				new ActionPrefix(

																						new SendMessageAction(
																								this.router,
																								new TaskDoneMessage()),
																						Quit.getInstance())))))))),
								new ActionPrefix(new ReceiveMessageAction(new NoFileMessage()), Quit.getInstance()))));
	}
}
