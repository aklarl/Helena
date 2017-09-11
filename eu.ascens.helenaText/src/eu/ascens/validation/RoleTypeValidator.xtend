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
import eu.ascens.helenaText.RoleBehavior
import eu.ascens.helenaText.RoleType
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

class RoleTypeValidator extends AbstractDeclarativeValidator {

	override register(EValidatorRegistrar registrar) {
       //not needed for classes used as ComposedCheck
    }

	/**
	 * Checks if a role behavior exists for every role type
	 */
	@Check
	def check_roleType_roleBehaviorExists(RoleType rt) {
		var Iterable<RoleBehavior> allRBs = rt.eResource.allContents.toIterable.filter(RoleBehavior);

		for (RoleBehavior rb : allRBs) {
			if (rb.roleTypeRef.name == rt.name) {
				return;
			}
		}

		error(
			'No role behavior exists for role type ' + rt.name,
			HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME,
			HelenaTextValidator.MISSING_CONNECTION
		)
	}
}