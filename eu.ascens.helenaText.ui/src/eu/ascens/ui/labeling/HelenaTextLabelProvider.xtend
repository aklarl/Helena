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

package eu.ascens.ui.labeling

import com.google.inject.Inject
import eu.ascens.helenaText.AbstractAssignment
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.RoleBehavior
import eu.ascens.helenaText.RoleTypeWithMultiplicity
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
class HelenaTextLabelProvider extends XbaseLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Adapt Labels:
	def text(AbstractAssignment a) {
		return a.roleTypeRef.name;
	}	
	
	def text(RoleTypeWithMultiplicity rtWithMult){
		'<'+ rtWithMult.roleType.name +','+ text(rtWithMult.min)+','+ text(rtWithMult.max)+','+ text(rtWithMult.capacity)+'>'
	}
	
	def text(RoleBehavior rb){
		return rb.roleTypeRef.name + " (role behavior)";
	}
	def text(MessageType msgType){
		return msgType.direction + " "+ msgType.name; 
	}

	//Adapts the Icons for the Helena Elements	
//	def image(ComponentType ct) {
//		'yellow2.png'
//	}
//
//	def image(RoleBehavior ele) {
//		'lightBlue2.png'
//	}
//	def image(RoleType rt) {
//		'pink2.png'
//	}
//	def image(EnsembleStructure es) {
//		'orange2.png'
//	}
//	def image(RoleConnectorType rct){
//		'green2.png'
//	}
}
