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
package eu.ascens.helena.dev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class holds some auxiliaries.
 *
 * @author Annabelle Klarl
 */
public class Auxiliaries {

	/**
	 * Helper method for getting items as set.
	 *
	 * @param items
	 * @return
	 */
	public static <T> Set<T> getAsSet(
			@SuppressWarnings("unchecked") T... items) {
		Set<T> set = new HashSet<>();
		for (T item : items) {
			set.add(item);
		}
		return set;
	}

	/**
	 * Helper method for getting items as list.
	 *
	 * @param items
	 * @return
	 */
	public static <T> List<T> getAsList(
			@SuppressWarnings("unchecked") T... items) {
		List<T> list = new ArrayList<>(items.length);
		for (T item : items) {
			list.add(item);
		}
		return list;
	}

	/**
	 * Helper method to unify two sets into one set
	 *
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> Set<T> unify(Set<T> first, Set<T> second) {
		HashSet<T> union = new HashSet<>();
		union.addAll(first);
		union.addAll(second);
		return union;
	}

	/**
	 * Helper method to build a process term from a list of actions and a
	 * process term. This method will recursively built action prefixes from the
	 * actions given in the list and finally the given process term.
	 *
	 * @param p the process term to be executed after the sequence of actions
	 * @param actions a list of actions in sequential ordering
	 * @return
	 */
	public static ProcessExpression buildActionPrefix(ProcessExpression p,
			Action... actions) {
		ProcessExpression pt = p;
		for (int i = actions.length - 1; i >= 0; i--) {
			pt = new ActionPrefix(actions[i], pt);
		}
		return pt;
	}
}
