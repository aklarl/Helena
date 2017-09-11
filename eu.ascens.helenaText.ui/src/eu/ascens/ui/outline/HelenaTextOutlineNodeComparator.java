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
package eu.ascens.ui.outline;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution.DefaultComparator;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

import eu.ascens.helenaText.HelenaTextPackage;

public class HelenaTextOutlineNodeComparator extends DefaultComparator {

	/**
	 * Method for sorting the Helena elements in the Outline according to
	 * categories (instead of alphabetically) First all componentTypes are
	 * shown. Afterwards follow the roleTypes, roleConnectorTypes,
	 * ensembleStructures, roleBehaviors
	 */
	@Override
	public int getCategory(IOutlineNode node) {
		int classID = ((EObjectNode) node).getEClass().getClassifierID();
		if (node instanceof EObjectNode) {
			switch (classID) {
			case HelenaTextPackage.ROLE_BEHAVIOR:
				return -10;
			case HelenaTextPackage.ENSEMBLE_STRUCTURE:
				return -20;
				// case HelenaTextPackage.ROLE_CONNECTOR_TYPE:
				// return -30;
			case HelenaTextPackage.ROLE_TYPE:
				return -40;
			case HelenaTextPackage.COMPONENT_TYPE:
				return -50;
			}
		}
		return Integer.MIN_VALUE;
	}
}
