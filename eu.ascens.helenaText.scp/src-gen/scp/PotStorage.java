
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

import scp.messages.CreateStorageMessage;
import scp.messages.FoundStorageMessage;
import scp.messages.FindStorageMessage;

public class PotStorage extends Role {

	// role attributes

	// self variable
	protected final Variable<PotStorage> self = new Variable<>(PotStorage.class);

	// global variables for behavior

	protected final Variable<Storage> s = new Variable<>(Storage.class);
	protected final Variable<PotStorage> psFwd1 = new Variable<>(PotStorage.class);
	protected final Variable<PotStorage> psFwd2 = new Variable<>(PotStorage.class);
	protected final Variable<Deployer> depl = new Variable<>(Deployer.class);
	protected final Variable<PotStorage> psNotSmallest1 = new Variable<>(PotStorage.class);
	protected final Variable<PotStorage> psNotSmallest2 = new Variable<>(PotStorage.class);
	protected final Variable<Deployer> depl2 = new Variable<>(Deployer.class);
	protected final Variable<PotStorage> psSmallest1 = new Variable<>(PotStorage.class);
	protected final Variable<PotStorage> psSmallest2 = new Variable<>(PotStorage.class);
	protected final Variable<Integer> foundID2 = new Variable<>(Integer.class);
	protected final Variable<Integer> appID = new Variable<>(Integer.class);
	protected final Variable<Integer> startID = new Variable<>(Integer.class);
	protected final Variable<Integer> foundID = new Variable<>(Integer.class);

	public PotStorage(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		ProcessInvocation invoc1263521415 = new ProcessInvocation();
		ProcessInvocation invoc1712860115 = new ProcessInvocation();
		ProcessInvocation invoc1269530417 = new ProcessInvocation();
		ProcessInvocation invoc673494991 = new ProcessInvocation();
		ProcessInvocation invoc1249878885 = new ProcessInvocation();

		ProcessExpression potStorageProcess = new ActionPrefix(
				new ReceiveMessageAction(
						new FindStorageMessage(depl, appID, foundID)),
				new IfThenElse(
						new OrGuard(
								new OrGuard(
										new OrGuard(
												new AndGuard(
														new AndGuard(
																new Atom(new CompAttrGetter<>("id", Integer.class)
																		.getValue(this) - this.appID.getValue() < 0),
																new Atom(this.foundID.getValue()
																		- this.appID.getValue() < 0)),
														new Atom(this.appID.getValue()
																- new CompAttrGetter<>("id", Integer.class)
																		.getValue(this) < this.appID.getValue()
																				- this.foundID.getValue())),
												new AndGuard(
														new AndGuard(
																new Atom(new CompAttrGetter<>("id", Integer.class)
																		.getValue(this) - this.appID.getValue() >= 0),
																new Atom(this.foundID.getValue()
																		- this.appID.getValue() >= 0)),
														new Atom(
																new CompAttrGetter<>("id", Integer.class).getValue(this)
																		- this.appID.getValue() < this.foundID
																				.getValue() - this.appID.getValue()))),
										new AndGuard(
												new AndGuard(
														new Atom(
																new CompAttrGetter<>("id", Integer.class).getValue(this)
																		- this.appID.getValue() < 0),
														new Atom(this.foundID.getValue() - this.appID.getValue() >= 0)),
												new Atom(this.appID.getValue()
														- new CompAttrGetter<>("id", Integer.class)
																.getValue(this) < this.foundID.getValue()
																		- this.appID.getValue()))),
								new AndGuard(
										new AndGuard(
												new Atom(new CompAttrGetter<>("id", Integer.class).getValue(this)
														- this.appID.getValue() >= 0),
												new Atom(this.foundID.getValue() - this.appID.getValue() < 0)),
										new Atom(new CompAttrGetter<>("id", Integer.class).getValue(this)
												- this.appID.getValue() < this.appID.getValue()
														- this.foundID.getValue()))),
						new IfThenElse(
								new NotGuard(new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
										PotStorage.class)),
								new ActionPrefix(
										new CreateRoleAction<>(psSmallest1, PotStorage.class,
												new CompAssociationGetter("neighbor").getValue(this)),
										new ActionPrefix(

												new SendMessageAction(this.psSmallest1,
														new FindStorageMessage(this.depl, this.appID,
																new Variable<>(new CompAttrGetter<>("id", Integer.class)
																		.getValue(this), Integer.class))),
												invoc1712860115)),
								new ActionPrefix(
										new CreateRoleAction<>(psSmallest2, PotStorage.class,
												new CompAssociationGetter("neighbor").getValue(this)),
										new ActionPrefix(

												new SendMessageAction(this.psSmallest2,
														new CreateStorageMessage(this.depl,
																new Variable<>(new CompAttrGetter<>("id", Integer.class)
																		.getValue(this), Integer.class),
																new Variable<>(new CompAttrGetter<>("id", Integer.class)
																		.getValue(this), Integer.class))),
												invoc1269530417))),
						new IfThenElse(
								new NotGuard(new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
										PotStorage.class)),
								new ActionPrefix(
										new CreateRoleAction<>(psNotSmallest1, PotStorage.class,
												new CompAssociationGetter("neighbor").getValue(this)),
										new ActionPrefix(

												new SendMessageAction(this.psNotSmallest1,
														new FindStorageMessage(this.depl, this.appID, this.foundID)),
												invoc673494991)),
								new ActionPrefix(
										new CreateRoleAction<>(psNotSmallest2, PotStorage.class,
												new CompAssociationGetter("neighbor").getValue(this)),
										new ActionPrefix(

												new SendMessageAction(this.psNotSmallest2,
														new CreateStorageMessage(this.depl, this.foundID,
																new Variable<>(new CompAttrGetter<>("id", Integer.class)
																		.getValue(this), Integer.class))),
												invoc1249878885)))));
		ProcessExpression secondRoundTrip = new ActionPrefix(
				new ReceiveMessageAction(new CreateStorageMessage(depl2, foundID2, startID)),
				new IfThenElse(
						new ComposedExpression(new CompAttrGetter<>("id", Integer.class), ExpressionOperator.EQUAL,
								new Atom(this.foundID2.getValue())),
						new IfThenElse(new NotGuard(new PlaysQuery(this.getOwner(), Storage.class)), new ActionPrefix(
								new CreateRoleAction<>(s, Storage.class, this.getOwner()), new ActionPrefix(

										new SendMessageAction(this.depl2, new FoundStorageMessage(this.s)),
										new IfThenElse(new ComposedExpression(new CompAttrGetter<>("id", Integer.class),
												ExpressionOperator.UNEQUAL, new Atom(this.startID.getValue())),
												new IfThenElse(
														new PlaysQuery(
																new CompAssociationGetter("neighbor").getValue(this),
																PotStorage.class),
														new ActionPrefix(
																new CreateRoleAction<>(psFwd1, PotStorage.class,
																		new CompAssociationGetter("neighbor")
																				.getValue(this)),
																new ActionPrefix(

																		new SendMessageAction(this.psFwd1,
																				new CreateStorageMessage(this.depl2,
																						this.foundID2, this.startID)),
																		Quit.getInstance())),
														Quit.getInstance()),
												Quit.getInstance()))),
								Quit.getInstance()),
						new IfThenElse(
								new ComposedExpression(new CompAttrGetter<>("id", Integer.class),
										ExpressionOperator.UNEQUAL, new Atom(this.startID.getValue())),
								new IfThenElse(
										new PlaysQuery(new CompAssociationGetter("neighbor").getValue(this),
												PotStorage.class),
										new ActionPrefix(
												new CreateRoleAction<>(psFwd2, PotStorage.class,
														new CompAssociationGetter("neighbor").getValue(this)),
												new ActionPrefix(

														new SendMessageAction(this.psFwd2,
																new CreateStorageMessage(this.depl2, this.foundID2,
																		this.startID)),
														Quit.getInstance())),
										Quit.getInstance()),
								Quit.getInstance())));

		invoc1263521415.setInvocatedProcess(potStorageProcess);
		invoc1712860115.setInvocatedProcess(secondRoundTrip);
		invoc1269530417.setInvocatedProcess(secondRoundTrip);
		invoc673494991.setInvocatedProcess(secondRoundTrip);
		invoc1249878885.setInvocatedProcess(secondRoundTrip);

		return potStorageProcess;
	}
}
