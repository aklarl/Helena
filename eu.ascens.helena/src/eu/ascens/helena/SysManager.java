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
package eu.ascens.helena;

import java.util.HashSet;
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
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.ConfigurationManager;
import eu.ascens.helena.metadata.EnsembleStructure;

/**
 * This class represents a system modeled with Helena. Statically, the system
 * can be embrace instances of component types given in the attribute
 * {@link SysManager#componentTypes} and instances of ensemble structures in the
 * attribute {@link SysManager#ensembleStructures}. Which components and
 * ensembles exist in the running system is stored in the attributes
 * {@link SysManager#currentComponents} and {@link SysManager#currentEnsembles}.
 *
 * @author Annabelle Klarl
 */
public abstract class SysManager {

	private Set<ComponentType> componentTypes;
	private Set<EnsembleStructure> ensembleStructures;

	private Set<Component> currentComponents;
	private Set<Ensemble> currentEnsembles;

	public SysManager() {
		this.componentTypes = new HashSet<>();
		this.ensembleStructures = new HashSet<>();
		this.currentComponents = new HashSet<>();
		this.currentEnsembles = new HashSet<>();
	}

	/**
	 * This method starts a system. It takes care that the system is configured
	 * (that means all allowed component types and ensemble structures are
	 * given), all components for the system are initialized, and all desired
	 * ensembles are started.
	 */
	public final void start() {
		try {
			this.configureTypes();
			ConfigurationManager.configurationDone();

			this.createComponents();
			this.startEnsembles();
		}
		catch (RoleTypeNotAllowedForEnsembleException
		        | RoleTypeNotAllowedForComponentTypeException
		        | ComponentNotInEnsembleException
		        | ComponentAlreadyAdoptsRoleException
		        | TooManyRoleInstancesException | ReflectionException
		        | TypeAlreadyExistsException
		        | PropertyNotDeclaredInClassException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method configures a system, i.e. all component types and ensemble
	 * structures which can be used in the system are initialized.
	 *
	 * @throws PropertyNotDeclaredInClassException This exception is thrown if a
	 *             property (e.g. attribute) is not declared in its Java
	 *             representation.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type was
	 *             created twice.
	 */
	protected abstract void configureTypes() throws TypeAlreadyExistsException,
	        PropertyNotDeclaredInClassException;

	/**
	 * This method creates all components which are part of the system
	 */
	protected abstract void createComponents();

	/**
	 * This method starts the ensembles which should run in the system.
	 *
	 * @throws RoleTypeNotAllowedForComponentTypeException
	 * @throws RoleTypeNotAllowedForEnsembleException
	 * @throws ComponentNotInEnsembleException
	 * @throws ComponentAlreadyAdoptsRoleException
	 * @throws TooManyRoleInstancesException
	 * @throws ReflectionException
	 * @throws PropertyNotDeclaredInClassException
	 */
	protected abstract void startEnsembles()
	        throws RoleTypeNotAllowedForEnsembleException,
	        RoleTypeNotAllowedForComponentTypeException,
	        ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
	        ReflectionException, PropertyNotDeclaredInClassException,
	        ComponentNotInEnsembleException;

	protected void addCompType(ComponentType compType) {
		this.componentTypes.add(compType);
	}

	protected void addEnsembleStructure(EnsembleStructure ensStruct) {
		this.ensembleStructures.add(ensStruct);
	}

	protected void addComponent(Component comp)
	        throws TypeAlreadyExistsException {
		if (!this.componentTypes.contains(comp.getType())) {
			throw new TypeAlreadyExistsException(comp.getType().getType());
		}
		this.currentComponents.add(comp);
	}

	protected Set<Component> getComponents() {
		return this.currentComponents;
	}

	protected Component getComponent() {
		return this.currentComponents.iterator().next();
	}

	protected void addEnsemble(Ensemble ens) {
		if (!this.ensembleStructures.contains(ens.getType())) {
			throw new TypeAlreadyExistsException(ens.getType().getType());
		}
		this.currentEnsembles.add(ens);
	}
}
