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

/**
 * This class represents the quit process expression which advises to give up
 * the role and terminates the behavior.
 *
 * @author Annabelle Klarl
 */
public class Quit extends ProcessExpression {

	private static Quit singleton;

	private Quit() {
	}

	public static Quit getInstance() {
		if (singleton == null) {
			singleton = new Quit();
		}
		return singleton;
	}

	/**
	 * This method quits the role by advising the owning component to give up
	 * the role and closes its input channel.
	 *
	 * @param source the role executing the process expression
	 * @return an empty process expression (not null)
	 */
	@Override
	ProcessExpression step(Role source) {
		source.quit();
		return Bottom.getInstance();
	}

}
