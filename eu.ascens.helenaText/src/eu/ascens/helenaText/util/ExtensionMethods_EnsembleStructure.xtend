/*
 *  The Helena workbench is an Eclipse plugin for the development of ensemble-based systems
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
package eu.ascens.helenaText.util

import eu.ascens.helenaText.EnsembleStructure
import eu.ascens.helenaText.RoleType

class ExtensionMethods_EnsembleStructure {
	
	
	/**
	 * Calculates the multiplicity from an ensemble structure for a role type as 
	 * value (if only one value was set) or the maximum from the range
	 * If maximum is "*" Integer.MAX_VALUE is returned 
	 * @return maximum multiplicity for a role type
	 */
	def static String getMaxMultiplicityForRoleType(EnsembleStructure es, RoleType rt) {
		for (rtWithMult : es.rtWithMult){
			if (rtWithMult.roleType == rt) {
				return rtWithMult.max.calculateMultiplicityJava;
			}
		}
		
		return null;
	}
	
	/**
	 * @return capacity for a role type
	 */
	def static Integer getCapacityForRoleType(EnsembleStructure es, RoleType rt) {
		for (rtWithMult : es.rtWithMult){
			if (rtWithMult.roleType == rt) {
				return rtWithMult.capacity;
			}
		}
		
		return null;
	}
	
	private def static String calculateMultiplicityJava(String multiplicity){
		if (multiplicity == "*" ){
			return "Integer.MAX_VALUE"
		}
		else {
			return multiplicity;
		}
	}
	
	public def static String calculateMultiplicityPromela(String multiplicity){
		if (multiplicity == "*" ){
			return "(2^31)-1"
		}
		else {
			return multiplicity;
		}
	}
}