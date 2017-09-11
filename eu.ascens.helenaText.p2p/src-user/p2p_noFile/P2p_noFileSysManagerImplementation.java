package p2p_noFile;

import eu.ascens.helena.SysManager;
import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;

public class P2p_noFileSysManagerImplementation extends P2p_noFileSysManager {
	public P2p_noFileSysManagerImplementation() {
		super();
	}

	public static void main(String[] args) {
		SysManager sys = new P2p_noFileSysManagerImplementation();
		sys.start();
	}

	protected void createComponents() {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");

	}

	protected void startEnsembles()
			throws RoleTypeNotAllowedForEnsembleException, RoleTypeNotAllowedForComponentTypeException,
			ComponentNotInEnsembleException, ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
			ReflectionException, PropertyNotDeclaredInClassException {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");
	}
}
