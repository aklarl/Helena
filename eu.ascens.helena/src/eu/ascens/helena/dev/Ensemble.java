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

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.reflect.ConstructorUtils;

import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentIsNullException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.NoRoleInstancesException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;
import eu.ascens.helena.metadata.EnsembleStructure;
import eu.ascens.helena.metadata.RoleType;

/**
 * This class represents the abstract class of an ensemble. An instance of an
 * ensemble keeps track how many roles of which type are currently participating
 * in the ensemble.
 *
 * @author Annabelle Klarl
 */
public abstract class Ensemble implements AbstractHelenaInstance {

	protected final EnsembleStructure type;

	private final Lock lock;

	protected final String ensembleID;
	protected final Set<Component> comps;
	protected final Map<RoleType, Set<Role>> roles;

	/**
	 * Constructor
	 *
	 * @param ensembleID the ID for this specific ensemble
	 */
	protected Ensemble(String ensembleID, Set<Component> comps) {
		this.type = EnsembleStructure.getType(this.getClass());
		this.lock = new ReentrantLock();
		this.ensembleID = ensembleID;
		this.comps = comps;
		this.roles = new ConcurrentHashMap<>();
	}

	public EnsembleStructure getType() {
		return this.type;
	}

	/**
	 * This method locks the component.
	 */
	void lock() {
		this.lock.lock();
	}

	/**
	 * This method unlocks the component
	 */
	void unlock() {
		this.lock.unlock();
	}

	/**
	 * With this method the ensemble advises the given component to adopt the
	 * given role and starts its behavior. (Static checks need to be performed
	 * before!)
	 *
	 * @param roleType the role to be adopted
	 * @param owner the component which should adopt the role
	 * @return the adopted role instance
	 * @throws ComponentNotInEnsembleException This exception is thrown if the
	 *             given component does not contribute to this ensemble.
	 * @throws ComponentAlreadyAdoptsRoleException This exception is thrown if
	 *             the role should be created on a component which already
	 *             adopts it.
	 * @throws TooManyRoleInstancesException This exception is thrown if the
	 *             role type cannot be instantiated in this ensemble since
	 *             multiplicity limits were reached.
	 * @throws ReflectionException This exception is thrown if the role could
	 *             not be instantiated because of reflection problems
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if
	 *             the process term of the role could not be initialized since
	 *             some used properties were not defined in their Java
	 *             representations.
	 */
	protected final <T extends Role> T createRole(Class<T> roleType,
			Component owner) throws ComponentNotInEnsembleException,
			ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
			ReflectionException, PropertyNotDeclaredInClassException {
		try {
			owner.lock();
			this.lock();

			RoleType rt = RoleType.getType(roleType);

			// is component in the ensemble?
			if (!this.comps.contains(owner)) {
				throw new ComponentNotInEnsembleException(owner, this);
			}

			// does component already adopt the role?
			if (this.ownerAlreadyAdoptsRole(owner, rt)) {
				throw new ComponentAlreadyAdoptsRoleException(owner, rt, this);
			}

			// are multiplicities respected?
			if (!this.isNewRoleInstanceAllowed(rt)) {
				throw new TooManyRoleInstancesException(rt, this);
			}

			// create role instance (without owner)
			T role = ConstructorUtils.invokeConstructor(roleType, owner, this,
					this.type.getCapacity(RoleType.getType(roleType)));

			// store adopted role
			Set<Role> rolesPerRoleType = this.roles.get(rt);
			if (rolesPerRoleType == null) {
				rolesPerRoleType = new HashSet<>();
			}
			rolesPerRoleType.add(role);
			this.roles.put(rt, rolesPerRoleType);

			// start role behavior
			role.start();

			return role;
		}
		catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException | InstantiationException e) {
			throw new ReflectionException(roleType);
		}
		finally {
			this.unlock();
			owner.unlock();
		}
	}

	/**
	 * With this method the ensemble retrieves an instance of the given role
	 * type adopted by the given component in the ensemble. If no such role
	 * instance could be found, null is returned.
	 *
	 * @param roleType the role to be retrieved
	 * @param owner the component which should adopt the role
	 * @return the adopted role instance
	 * @throws ComponentNotInEnsembleException This exception is thrown if the
	 *             given component does not contribute to this ensemble.
	 * @throws NoRoleInstancesException This exception is thrown if the given
	 *             owner does currently not adopt an instance of the given role
	 *             type in this ensemble.
	 */
	@SuppressWarnings("unchecked")
	final <T extends Role> T getRole(Class<T> roleType, Component owner)
			throws ComponentNotInEnsembleException, NoRoleInstancesException {
		try {
			owner.lock();

			// is component in the ensemble?
			if (!this.comps.contains(owner)) {
				throw new ComponentNotInEnsembleException(owner, this);
			}

			Set<Role> rolesPerRoleType = this.roles
					.get(RoleType.getType(roleType));
			if (rolesPerRoleType == null) {
				throw new NoRoleInstancesException(roleType, owner, this);
			}

			for (Role role : rolesPerRoleType) {
				if (role.getOwner() == owner) {
					return (T) role;
				}
			}
			throw new NoRoleInstancesException(roleType, owner, this);
		}
		finally {
			owner.unlock();
		}
	}

	/**
	 * This methods checks whether the given component currently adopts a role
	 * of the given type in this ensemble.
	 *
	 * @param roleType
	 * @param owner
	 * @return
	 * @throws ComponentIsNullException This exception is thrown if the given
	 *             component is null.
	 * @throws ComponentNotInEnsembleException This exception is thrown if the
	 *             given component does not contribute to this ensemble.
	 */
	final <T extends Role> boolean playsRole(Class<T> roleType, Component owner)
			throws ComponentIsNullException, ComponentNotInEnsembleException {
		if (owner == null) {
			throw new ComponentIsNullException();
		}

		try {
			owner.lock();
			this.getRole(roleType, owner);
			return true;
		}
		catch (NoRoleInstancesException e) {
			return false;
		}
		finally {
			owner.unlock();
		}
	}

	/**
	 * With this method the particular role instance given by {@code role} is
	 * given up.
	 *
	 * @param role the role instance to be given up
	 */
	final <T extends Role> void quitRole(T role) {
		Component owner = role.getOwner();
		owner.lock();
		this.lock();

		RoleType roleType = role.getType();
		Set<Role> rolesPerRoleType = this.roles.get(roleType);
		if (rolesPerRoleType != null) {
			rolesPerRoleType.remove(role);
		}

		this.unlock();
		owner.unlock();
	}

	private boolean ownerAlreadyAdoptsRole(Component owner, RoleType roleType) {
		Set<Role> rolesPerRoleType = this.roles.get(roleType);
		if (rolesPerRoleType != null) {
			for (Role role : rolesPerRoleType) {
				if (role.getOwner() == owner) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method checks whether another instance of this role type is allowed
	 * in the ensemble (because of multiplicities).
	 *
	 * @param roleType
	 * @return
	 */
	private boolean isNewRoleInstanceAllowed(RoleType roleType) {
		if (this.roles.get(roleType) == null) {
			return true;
		}
		else {
			return this.roles.get(roleType).size() < this.type
					.getMultiplicity(roleType);
		}
	}

	/**
	 * This method starts the ensemble by giving the specific task to an initial
	 * component. An implementing class should start in here the necessary roles
	 * to initialize the work on the given task.
	 *
	 * @param initialComponent
	 * @throws RoleTypeNotAllowedForComponentTypeException
	 * @throws RoleTypeNotAllowedForEnsembleException
	 * @throws ComponentNotInEnsembleException
	 * @throws ComponentAlreadyAdoptsRoleException
	 * @throws TooManyRoleInstancesException
	 * @throws ReflectionException
	 * @throws PropertyNotDeclaredInClassException
	 */
	public abstract void startEnsemble(Component initialComponent)
			throws RoleTypeNotAllowedForEnsembleException,
			RoleTypeNotAllowedForComponentTypeException,
			ComponentNotInEnsembleException,
			ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
			ReflectionException, PropertyNotDeclaredInClassException;

}