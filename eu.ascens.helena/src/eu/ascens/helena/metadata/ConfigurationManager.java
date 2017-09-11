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
package eu.ascens.helena.metadata;

/**
 * This class controls configuration of all Helena entities.
 *
 * @author Annabelle Klarl
 */
public final class ConfigurationManager {

	private static boolean configurationDone = false;

	/**
	 * This method finishes the configuration of all types of the Helena
	 * specification.
	 */
	public static void configurationDone() {
		configurationDone = true;
	}

	/**
	 * This method returns whether configuration of the Helena specification has
	 * already been finished such that no more new types can be added.
	 *
	 * @return
	 */
	static boolean isConfigurationDone() {
		return configurationDone;
	}

}
