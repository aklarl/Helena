package p2p;

import java.util.Set;
import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;

public class TransferEnsembleImplementation extends TransferEnsemble {

	public TransferEnsembleImplementation(String ensembleID, Set<Component> comps) {
		super(ensembleID, comps);
	}

	@Override
	public void startEnsemble(Component initialComponent)
	        throws RoleTypeNotAllowedForEnsembleException,
	        RoleTypeNotAllowedForComponentTypeException,
	        ComponentNotInEnsembleException, ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
	        ReflectionException, PropertyNotDeclaredInClassException {
		this.createRole(Requester.class, initialComponent);
	}
}
