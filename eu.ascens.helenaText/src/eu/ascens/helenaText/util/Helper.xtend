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
package eu.ascens.helenaText.util;

import com.google.common.base.Joiner
import java.util.ArrayList
import java.util.Collection
import java.util.List
import org.eclipse.xtext.xbase.lib.Functions.Function2

public enum ParamStyle {
	BINDING,
	NORMAL
}

class Helper {
	
	/**
	 * Return the iterable without duplicate entries
	 */
	def static <T> Iterable<T> removeDuplicates(Iterable<T> iter){
		return iter.toSet;
	}

	/**
	 * Returns a String, containing all elements of list and s, separated by separator
	 */
	def static String joinToString(String separator, List<String> list, String... s) {
		val List<String> allElements = new ArrayList<String>(list);
		allElements.addAll(s.toList);

		return Joiner.on(separator).join(allElements);
	}

	def static String getFirstPartOfPath(String path, String separator) {
		if (separator == ".") {
			return path.split("\\.").head;
		} else {
			return path.split(separator).head;
		}
	}

	/**
	  * Takes a list as a string, that contains separators;
	  * Returns the string with last element (regarding to separator) with first letter uppercase
	  * e.g. example.com.test --> example.com.Test
	  */
	def static String lastElemToFirstUpper(String list, String separator) {
		var resultString = "";
		val elemList = list.split(separator).toList;
		for (i : 0 ..< elemList.length) {
			if (i == elemList.length - 1) {
				resultString = resultString + elemList.get(i).toFirstUpper;
			} else {
				resultString = resultString + elemList.get(i) + separator;
			}
		}

		return resultString;
	}
	



	/**
	 * compares two lists
	 */
	def static <C> boolean equals(List<C> list1, List<C> list2) {
		if ( (list1 == null && list2 == null) ||
			(list1.size == 0 && list2.size == 0) ) {
			return true;
		}
		
		if (list1.size != list2.size) {
			return false;
		} 
		
		for (i : 0 ..< list1.size) {
			var first = list1.get(i);
			var second = list2.get(i);
			if (first != second) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Adds the element to the collection if it is not already contained according to the given equals function
	 */
	def static <T> Collection<T> addAllDuplicateFree(Collection<T> list, Collection<T> toBeAdded, Function2<T,T,Boolean> equals) {
		for(elem1:toBeAdded)
			if (list.forall[!equals.apply(elem1, it)]) list.add(elem1);
		return list;
	}
	
	/**
	 * Adds all elements of the second collection to the first one if it is not already contained according to the given equals function
	 */
	def static <T> Collection<T> addDuplicateFree(Collection<T> list, T elem, Function2<T,T,Boolean> equals) {
		if (list.forall[!equals.apply(elem, it)]) list.add(elem);
		return list;
	}
	
	/**
	 * Returns an element as a List
	 */
	def static <T> Collection<T> asList(T elem) {
		var list = new ArrayList;
		list.add(elem);
		return list;
	}
	
}
