
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

import scp.messages.StoreMessage;
import scp.messages.FoundStorageMessage;
import scp.messages.FindStorageMessage;

public class Deployer extends Role {

	// role attributes
	protected Integer appID;
	protected Integer appReqs;
	protected Integer appCode;

	// self variable
	protected final Variable<Deployer> self = new Variable<>(Deployer.class);

	// global variables for behavior

	protected final Variable<Storage> s = new Variable<>(Storage.class);
	protected final Variable<PotStorage> ps = new Variable<>(PotStorage.class);

	public Deployer(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return new ActionPrefix(
				new RoleAttrSetterAction("appID",
						new Variable<Double>(new Double(1234),
								Double.class)),
				new ActionPrefix(
						new RoleAttrSetterAction("appReqs", new Variable<Double>(new Double(1234), Double.class)),
						new ActionPrefix(
								new RoleAttrSetterAction("appCode",
										new Variable<Double>(new Double(1234), Double.class)),
								new ActionPrefix(
										new CreateRoleAction<>(ps, PotStorage.class,
												new CompAssociationGetter("neighbor").getValue(this)),
										new ActionPrefix(

												new SendMessageAction(this.ps, new FindStorageMessage(this.self,
														new Variable<>(new RoleAttrGetter<>("appID", Integer.class)
																.getValue(this), Integer.class),
														new Variable<>(new CompAttrGetter<>("id", Integer.class)
																.getValue(this), Integer.class))),
												new ActionPrefix(new ReceiveMessageAction(new FoundStorageMessage(s)),
														new ActionPrefix(

																new SendMessageAction(this.s, new StoreMessage(
																		new Variable<>(
																				new RoleAttrGetter<>("appID",
																						Integer.class).getValue(this),
																				Integer.class),
																		new Variable<>(
																				new RoleAttrGetter<>("appReqs",
																						Integer.class).getValue(this),
																				Integer.class),
																		new Variable<>(
																				new RoleAttrGetter<>("appCode",
																						Integer.class).getValue(this),
																				Integer.class))),
																Quit.getInstance())))))));
	}
}
