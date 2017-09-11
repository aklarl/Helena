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

import eu.ascens.helenaText.Addition
import eu.ascens.helenaText.AndTerm
import eu.ascens.helenaText.Atom
import eu.ascens.helenaText.ComponentAssociationTypeReference
import eu.ascens.helenaText.ComponentAttributeType
import eu.ascens.helenaText.ComponentAttributeTypeReference
import eu.ascens.helenaText.EqualityTerm
import eu.ascens.helenaText.Guard
import eu.ascens.helenaText.GuardInParentheses
import eu.ascens.helenaText.NotTerm
import eu.ascens.helenaText.OrTerm
import eu.ascens.helenaText.OwnerReference
import eu.ascens.helenaText.PlaysQuery
import eu.ascens.helenaText.Subtraction
import java.util.ArrayList
import java.util.Collection

import static extension eu.ascens.helenaText.util.Helper.*
import eu.ascens.helenaText.Relation

class ExtensionMethods_Logic {

	/**
	 * Returns the list of component attribute types contained in a guard
	 */
	def static Collection<ComponentAttributeType> getComponentAttributes(Guard guard) {
		return guard.getCollection( [getAtomComponentAttributes], [attr1, attr2|attr1.equals(attr2)]);
	}

	/**
	 * Returns the list of component attribute types reference contained in an atom
	 */
	private dispatch def static Collection<ComponentAttributeType> getAtomComponentAttributes(Atom expression) {
		return new ArrayList;
	}
	private dispatch def static Collection<ComponentAttributeType> getAtomComponentAttributes(
		ComponentAttributeTypeReference expression) {
		return expression.ref.asList;
	}
	private dispatch def static Collection<ComponentAttributeType> getAtomComponentAttributes(Addition expression) {
		var list = new ArrayList<ComponentAttributeType>();
		list.addAll(expression.left.atomComponentAttributes);
		list.addAll(expression.right.atomComponentAttributes);
		return list;
	}
	private dispatch def static Collection<ComponentAttributeType> getAtomComponentAttributes(Subtraction expression) {
		var list = new ArrayList<ComponentAttributeType>();
		list.addAll(expression.left.atomComponentAttributes);
		list.addAll(expression.right.atomComponentAttributes);
		return list;
	}
	private dispatch def static Collection<ComponentAttributeType> getAtomComponentAttributes(
		Relation expression) {
		var list = new ArrayList<ComponentAttributeType>();
		list.addAll(expression.left.atomComponentAttributes);
		list.addAll(expression.right.atomComponentAttributes);
		return list;
	}
	private dispatch def static Collection<ComponentAttributeType> getAtomComponentAttributes(
		GuardInParentheses expression) {
		return expression.guard.componentAttributes;
	}

	/**
	 * Returns a list of (duplicate free) play queries for a guard
	 */
	def static Collection<PlaysQuery> getPlaysQueries(Guard guard) {
		return guard.getCollection([atomPlaysQueries], [query1, query2|query1.equal(query2)]);
	}

	/**
	 * Returns a list of (duplicate free) play queries for an atom
	 */
	private def dispatch static Collection<PlaysQuery> getAtomPlaysQueries(Atom term) {
		return new ArrayList;
	}

	private def dispatch static Collection<PlaysQuery> getAtomPlaysQueries(PlaysQuery term) {
		return term.asList;
	}

	private def dispatch static Collection<PlaysQuery> getAtomPlaysQueries(GuardInParentheses term) {
		return term.guard.playsQueries;
	}

	def static boolean equal(PlaysQuery query1, PlaysQuery query2) {
		if(query1 == null || query2 == null) return false;
		return query1.compInstance.equalCompInstances(query2.compInstance) && query1.roleTypeRef == query2.roleTypeRef;
	}

	private dispatch def static boolean equalCompInstances(ComponentAssociationTypeReference component1,
		ComponentAssociationTypeReference component2) {
		return component1.ref == component2.ref;
	}

	private dispatch def static boolean equalCompInstances(ComponentAssociationTypeReference component1,
		OwnerReference component2) {
		return false;
	}

	private dispatch def static boolean equalCompInstances(OwnerReference component1,
		ComponentAssociationTypeReference component2) {
		return false;
	}

	private dispatch def static boolean equalCompInstances(OwnerReference component1, OwnerReference component2) {
		return true;
	}

	/**
	 * Get a (duplicate free) collection where the elements are contained in atoms
	 */
	private def static <T> Collection<T> getCollection(Guard guard, (Atom)=>Collection<T> toRetrieve,
		(T, T)=>Boolean equals) {
		var collection = new ArrayList<T>();

		// unary relation (NotTerm)
		if (!guard.isBinaryRelation) {
			if(guard.atom != null) collection.addAllDuplicateFree(toRetrieve.apply(guard.atom), equals);
			return collection
		}

		// binary relation
		if(guard.left != null) collection.addAllDuplicateFree(guard.left.getCollection(toRetrieve, equals), equals);
		if(guard.right != null) collection.addAllDuplicateFree(guard.right.getCollection(toRetrieve, equals), equals);
		return collection
	}

	public def static dispatch boolean isBinaryRelation(OrTerm guard) {
		return true;
	}

	public def static dispatch boolean isBinaryRelation(AndTerm guard) {
		return true;
	}

	public def static dispatch boolean isBinaryRelation(EqualityTerm guard) {
		return true;
	}

	public def static dispatch boolean isBinaryRelation(NotTerm guard) {
		return false;
	}

	/**
	 * Get left term of a relation. 
	 * If function is called for a NotTerm, null is returned
	 */
	public def static dispatch Guard getLeft(OrTerm guard) {
		return guard.left;
	}

	public def static dispatch Guard getLeft(AndTerm guard) {
		return guard.left;
	}

	public def static dispatch Guard getLeft(EqualityTerm guard) {
		return guard.left;
	}

	public def static dispatch Guard getLeft(NotTerm guard) {
		return null
	}

	/**
	 * Get rigth term of a relation. 
	 * If function is called for a NotTerm, null is returned
	 */
	public def static dispatch Guard getRight(OrTerm guard) {
		return guard.right;
	}

	public def static dispatch Guard getRight(AndTerm guard) {
		return guard.right;
	}


	public def static dispatch Guard getRight(EqualityTerm guard) {
		return guard.right;
	}

	public def static dispatch Guard getRight(NotTerm guard) {
		return null
	}

	public def static dispatch Atom getAtom(NotTerm guard) {
		return guard.atom;
	}

	public def static dispatch Atom getAtom(OrTerm guard) {
		return null;
	}

	public def static dispatch Atom getAtom(AndTerm guard) {
		return null;
	}

	public def static dispatch Atom getAtom(EqualityTerm guard) {
		return null;
	}
}