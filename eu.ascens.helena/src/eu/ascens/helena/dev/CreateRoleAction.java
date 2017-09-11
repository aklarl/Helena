/*
 *  jHelena is a Java library for the execution of ensemble specification
 *  according to the Helena approach. It is fully documented in the PhD 
 *  thesis "Helena - Handling massively distributed systems with ELaborate 
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 
 *  Website: http://www.pst.ifi.lmu.de/Personen/team/klarl/helena.html
 *  PhD thesis: https://edoc.ub.uni-muenchen.de/20087/
 *
 *  Copyright (C) 2013-2017  Annabelle Klarl
 *  All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 */
package eu.ascens.helena.dev;

import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentIsNullException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.EnsembleStructure;
import eu.ascens.helena.metadata.RoleType;

/**
 * This class represents the action of creating a role in Helena. The Generics
 * parameter of the action determines the type of the role to be created.
 *
 * @author Annabelle Klarl
 */
public class CreateRoleAction<T extends Role> extends Action {

	private final Variable<T> roleVar;
	private final Class<T> roleType;
	private final Component owner;

	/**
	 * Constructor
	 *
	 * @param roleVar the variable which should later hold the reference to the
	 *            newly created role
	 * @param roleType the type of the role to be created
	 * @param owner the owner of the role to be created
	 */
	public CreateRoleAction(Variable<T> roleVar, Class<T> roleType,
			Component owner) {
		this.roleVar = roleVar;
		this.roleType = roleType;
		this.owner = owner;
	}

	/**
	 * This method creates a new instance of the role type given as attribute of
	 * this action on the component given as attribute for this action and
	 * stores a reference to the created role instance in the variable given as
	 * attribute of this action.
	 *
	 * @param source the role which executes the action
	 * @throws RoleTypeNotAllowedForEnsembleException This exception is thrown
	 *             if the given role type is not part of the ensemble structure
	 *             of the issuing role.
	 * @throws ComponentIsNullException This exception is thrown if a component
	 *             should be accessed which is null (e.g. during a create or get
	 *             action).
	 * @throws RoleTypeNotAllowedForComponentTypeException This exception is
	 *             thrown if the given role type cannot be adopted by the type
	 *             of the given component.
	 * @throws ComponentNotInEnsembleException This exception is thrown if a
	 *             role should be created on a component which does not
	 *             contribute to the desired ensemble.
	 * @throws ComponentAlreadyAdoptsRoleException This exception is thrown if
	 *             the role should be created on a component which already
	 *             adopts it.
	 * @throws TooManyRoleInstancesException This exception is thrown if the
	 *             role type cannot be instantiated in the ensemble of the
	 *             issuing role since multiplicity limits were reached.
	 * @throws ReflectionException This exception is thrown if some error
	 *             occurred during trying to create a role via reflection.
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the process term of the role could not be initialized since
	 *             some used properties were not defined in their Java
	 *             representations.
	 */
	@Override
	void execute(Role source) throws RoleTypeNotAllowedForEnsembleException,
			ComponentIsNullException,
			RoleTypeNotAllowedForComponentTypeException,
			ComponentNotInEnsembleException,
			ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
			ReflectionException, PropertyNotDeclaredInClassException {

		Ensemble sourceEnsemble = source.getEnsemble();
		EnsembleStructure sourceES = sourceEnsemble.getType();
		RoleType creationRoleType = RoleType.getType(this.roleType);

		// is role type allowed in ensemble structure?
		if (!sourceES.isAllowed(creationRoleType)) {
			throw new RoleTypeNotAllowedForEnsembleException(creationRoleType,
					sourceES);
		}

		// is owning component instance null?
		if (this.owner == null) {
			throw new ComponentIsNullException();
		}

		ComponentType ownerCompType = this.owner.getType();
		// is component allowed as owner of role type?
		if (!creationRoleType.isAllowed(ownerCompType)) {
			throw new RoleTypeNotAllowedForComponentTypeException(
					creationRoleType, ownerCompType);
		}

		T role = source.getEnsemble().createRole(this.roleType, this.owner);
		this.roleVar.setValue(role);

		this.log.info("Role " + creationRoleType + " was created");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " for role type "
				+ this.roleType.getSimpleName();
	}
}
