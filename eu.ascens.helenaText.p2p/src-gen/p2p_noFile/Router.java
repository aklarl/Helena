
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

import p2p_noFile.messages.ReqAddrMessage;
import p2p_noFile.messages.TaskDoneMessage;
import p2p_noFile.messages.NoFileMessage;
import p2p_noFile.messages.SndAddrMessage;

public class Router extends Role {

	// role attributes

	// self variable
	protected final Variable<Router> self = new Variable<>(Router.class);

	// global variables for behavior

	protected final Variable<Router> routerDone = new Variable<>(Router.class);
	protected final Variable<Router> routerFwd = new Variable<>(Router.class);
	protected final Variable<Router> routerDone2 = new Variable<>(Router.class);
	protected final Variable<Requester> req = new Variable<>(Requester.class);
	protected final Variable<Provider> prov = new Variable<>(Provider.class);

	public Router(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		ProcessInvocation invoc1954090373 = new ProcessInvocation();

		ProcessExpression routerProc = new ActionPrefix(new ReceiveMessageAction(new ReqAddrMessage(req)),
				new IfThenElse(new CompAttrGetter<>("hasFile", Boolean.class), new ActionPrefix(
						new CreateRoleAction<>(prov, Provider.class, this.getOwner()), new ActionPrefix(

								new SendMessageAction(this.req, new SndAddrMessage(this.prov)), Quit.getInstance())),
						new IfThenElse(
								new NotGuard(new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
										Router.class)),
								new ActionPrefix(
										new CreateRoleAction<>(routerFwd, Router.class,
												new CompAssociationGetter("neighbor").getValue(this)),
										new ActionPrefix(

												new SendMessageAction(this.routerFwd, new ReqAddrMessage(this.req)),
												new ActionPrefix(new ReceiveMessageAction(new TaskDoneMessage()),
														new IfThenElse(
																new PlaysQuery(new CompAssociationGetter("neighbor")
																		.getValue(this), Router.class),
																new ActionPrefix(
																		new CreateRoleAction<>(routerDone, Router.class,
																				new CompAssociationGetter("neighbor")
																						.getValue(this)),
																		new ActionPrefix(

																				new SendMessageAction(this.routerDone,
																						new TaskDoneMessage()),
																				Quit.getInstance())),
																Quit.getInstance())))),
								new ActionPrefix(

										new SendMessageAction(this.req, new NoFileMessage()),
										new IfThenElse(
												new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
														Router.class),
												new ActionPrefix(
														new CreateRoleAction<>(routerDone2, Router.class,
																new CompAssociationGetter("neighbor").getValue(this)),
														new ActionPrefix(

																new SendMessageAction(this.routerDone2,
																		new TaskDoneMessage()),
																Quit.getInstance())),
												Quit.getInstance())))));

		invoc1954090373.setInvocatedProcess(routerProc);

		return routerProc;
	}
}
