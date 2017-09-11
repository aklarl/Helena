
package p2ptest;

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

public class Router2 extends Role {

	// role attributes

	// self variable
	protected final Variable<Router2> self = new Variable<>(Router2.class);

	// global variables for behavior

	public Router2(Component comp, Ensemble ens, Integer capacity) {
		super(comp, ens, capacity);
		this.self.setValue(this);
	}

	@Override
	protected ProcessExpression initializeRoleBehavior()
			throws ReflectionException, PropertyNotDeclaredInClassException {
		return Quit.getInstance();
	}
}
