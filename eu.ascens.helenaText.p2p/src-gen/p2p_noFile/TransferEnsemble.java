
package p2p_noFile;

import java.util.Set;
import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;

public abstract class TransferEnsemble extends Ensemble {

	public TransferEnsemble(String ensembleID, Set<Component> comps) {
		super(ensembleID, comps);
	}

	public abstract void startEnsemble(Component initialComponent)
			throws RoleTypeNotAllowedForEnsembleException, RoleTypeNotAllowedForComponentTypeException,
			ComponentNotInEnsembleException, ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
			ReflectionException, PropertyNotDeclaredInClassException;

}
