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
package eu.ascens.validation

import eu.ascens.helenaText.HelenaTextPackage
import eu.ascens.helenaText.RoleTypeWithMultiplicity
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

class EnsembleStructureValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {
       //not needed for classes used as ComposedCheck
    }

	/**
	 * Checks for a multiplicity in an ensemble structure 
	 * if the first number in a range is smaller than the second
	 */
	@Check
	def check_ensembleStructure_multiplicity_firstRangeValSmallerThanSecond(RoleTypeWithMultiplicity rtMult) {
		var min = 0;
		var max = 0;
		
		try {
			min = Integer.parseInt(rtMult.min);
		}
		catch(NumberFormatException e){
			try {
				Integer.parseInt(rtMult.max);
				error(
					'First value in the range has to be smaller than the second one.',
					HelenaTextPackage.Literals.ROLE_TYPE_WITH_MULTIPLICITY__MAX,
					HelenaTextValidator.MULT_RANGE_WRONG
				)
			}
			catch(NumberFormatException e2){
				//no error, since min and max are * which is always ok	
			}
		}
		
		try {
			max = Integer.parseInt(rtMult.max);
			if(min > max){
				error(
					'First value in the range has to be smaller than the second one.',
					HelenaTextPackage.Literals.ROLE_TYPE_WITH_MULTIPLICITY__MAX,
					HelenaTextValidator.MULT_RANGE_WRONG
				)				}
			
		}
		catch(NumberFormatException e){
			//no error, because max is * which is always ok			
		}
	}
}