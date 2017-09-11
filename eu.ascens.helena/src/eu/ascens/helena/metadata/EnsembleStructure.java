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
package eu.ascens.helena.metadata;

import java.util.HashMap;
import java.util.Map;

import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;

/**
 * This class represents ensemble structures in Helena.
 *
 * @author Annabelle Klarl
 */
public class EnsembleStructure extends AbstractHelenaType<Ensemble> {

	private static Map<Class<? extends Ensemble>, EnsembleStructure> types = new HashMap<>();

	/**
	 * This method creates an ensemble structure for the given implementing
	 * class and the associated role types (together with their multiplicities
	 * and capacities).
	 * 
	 * If there is none for the implementing class, a new one is created. If
	 * there exists already one, an {@link TypeAlreadyExistsException} is
	 * thrown.
	 *
	 * @param name the name of the implementing class
	 * @param roleTypes the role types that are allowed in the ensemble
	 *            structure together with their associated multiplicities and
	 *            capacities
	 * @return
	 * @throws ConfigurationFinishedException This exception is thrown if this
	 *             method was called after the configuration of the
	 *             ensemble-based system was finished.
	 * @throws TypeAlreadyExistsException This exception is thrown if a type
	 *             with the same name already exists.
	 */
	public static EnsembleStructure createType(Class<? extends Ensemble> name,
	        Map<RoleType, MultiplicityCapacityPair> roleTypes) {
		EnsembleStructure es = new EnsembleStructure(name, roleTypes);
		AbstractHelenaType.checkAndAddType(es, types);
		return es;
	}

	/**
	 * This method retrieves an ensemble structure for the given implementing
	 * class.
	 *
	 * @param name the name of the implementing class
	 * @return
	 * @throws TypeAlreadyExistsException
	 */
	public static EnsembleStructure getType(Class<? extends Ensemble> name)
	        throws TypeAlreadyExistsException {
		return AbstractHelenaType.getType(name, types);
	}

	// //////////// Ensemble Structure Declaration ///////////////////////

	private final Map<RoleType, MultiplicityCapacityPair> roleTypes;

	private EnsembleStructure(Class<? extends Ensemble> name,
	        Map<RoleType, MultiplicityCapacityPair> roleTypes) {
		super(name);
		this.roleTypes = roleTypes;
	}

	/**
	 * This method checks whether an instance of the ensemble can host instance
	 * of the given role type.
	 *
	 * @param roleType
	 * @return
	 */
	public boolean isAllowed(RoleType roleType) {
		return this.roleTypes.containsKey(roleType);
	}

	/**
	 * This method returns the maximum number of role instances that are allowed
	 * for the given role type.
	 *
	 * @param roleType
	 * @return
	 */
	public int getMultiplicity(RoleType roleType) {
		MultiplicityCapacityPair pair = this.roleTypes.get(roleType);
		if (pair == null) {
			return 0;
		}
		else {
			return pair.getMultiplicity();
		}
	}

	/**
	 * This method returns the capacity for the given role type.
	 *
	 * @param roleType
	 * @return
	 */
	public int getCapacity(RoleType roleType) {
		MultiplicityCapacityPair pair = this.roleTypes.get(roleType);
		if (pair == null) {
			return 0;
		}
		else {
			return pair.getCapacity();
		}
	}
}
