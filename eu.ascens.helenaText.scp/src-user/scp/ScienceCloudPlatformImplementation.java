package scp;

import java.util.Set;
import eu.ascens.helena.dev.Component;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;

public class ScienceCloudPlatformImplementation extends ScienceCloudPlatform {

	public ScienceCloudPlatformImplementation(String ensembleID, Set<Component> comps) {
		super(ensembleID, comps);
	}

	@Override
	public void startEnsemble(Component initialComponent) throws RoleTypeNotAllowedForEnsembleException,
			RoleTypeNotAllowedForComponentTypeException, ComponentNotInEnsembleException, TooManyRoleInstancesException,
			ReflectionException, PropertyNotDeclaredInClassException {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");
	}
}
