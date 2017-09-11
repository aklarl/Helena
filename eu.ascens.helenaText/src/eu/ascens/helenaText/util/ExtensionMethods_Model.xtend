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

import eu.ascens.helenaText.FormalDataParamsBlock
import eu.ascens.helenaText.FormalRoleParamsBlock
import eu.ascens.helenaText.Model

class ExtensionMethods_Model {
	
	/**
	 * Returns the maximal number of role params in any message in the model
	 */
	def static int maxNumberOfRoleParamsInModel(Model model) {
		return maxNumberOfAbstractParamsInModel(model, FormalRoleParamsBlock);
	}
	
	/**
	 * Returns the maximal number of data params in any message in the model
	 */
	def static int maxNumberOfDataParamsInModel(Model model) {
		return maxNumberOfAbstractParamsInModel(model, FormalDataParamsBlock);
	}
	
	private def static int maxNumberOfAbstractParamsInModel(Model model, Class<?> clazz) {
		//we need the max number to be at least 1 because arrays with size 0 cannot be initialized in Promela		
		var int maxNumber = 1;
		for (rt : model.headPkg.roleTypes) {
			for (msg : rt.rolemsgs) {
				var currentNumber = 0;
				switch clazz {
					case FormalRoleParamsBlock : currentNumber = msg.formalRoleParamsBlock.params.size
					case FormalDataParamsBlock : currentNumber = msg.formalDataParamsBlock.params.size
				}
				if (currentNumber > maxNumber) {
					maxNumber = currentNumber;
				}
			}
		}
		return maxNumber;
	}
}