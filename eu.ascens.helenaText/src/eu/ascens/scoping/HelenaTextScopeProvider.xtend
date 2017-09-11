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
package eu.ascens.scoping

import eu.ascens.helenaText.RoleBehavior
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider

import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import eu.ascens.helenaText.AbstractDataVariable

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it 
 *
 */
public class HelenaTextScopeProvider extends AbstractDeclarativeScopeProvider {

	/** 
	 * Only role instances declared in the same role behavior are visible 
	 */
	def IScope scope_AbstractRoleInstanceReference_ref(RoleBehavior rb, EReference ref) {
		return Scopes::scopeFor(rb.abstractRoleInstances);
	}
	/** 
	 * Only data instances declared in the same role behavior are visible 
	 */
	def IScope scope_AbstractDataVariableReference_ref(RoleBehavior rb, EReference ref) {
		return Scopes::scopeFor(
			rb.eAllContents.toIterable.filter[elem | elem instanceof AbstractDataVariable].toList
		) ;
	}
	
	/**
	 * Only role attribute types from the corresponding role type can be referenced
	 */
	def IScope scope_RoleAttributeTypeReference_ref(RoleBehavior rb, EReference ref) {
		return Scopes::scopeFor(rb.roleTypeRef.roleattrs);
	}
	/**
	 * Only component attribute types from the corresponding component type can be referenced
	 */
	def IScope scope_ComponentAttributeTypeReference_ref(RoleBehavior rb, EReference ref) {
		return Scopes::scopeFor(rb.roleTypeRef.compTypes.map[ct | ct.attrs].flatten);
	}
	/**
	 * Only component association types from the corresponding component type can be referenced
	 */
	def IScope scope_ComponentAssociationTypeReference_ref(RoleBehavior rb, EReference ref) {
		return Scopes::scopeFor(rb.roleTypeRef.compTypes.map[ct | ct.assocs].flatten);
	}
	  
}