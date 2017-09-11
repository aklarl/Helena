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
package eu.ascens.generator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.generator.AbstractFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

public class HelenaTextOutputConfigurationProvider implements
IOutputConfigurationProvider {

	public static final String JHELENA_GEN_OUTPUT = AbstractFileSystemAccess.DEFAULT_OUTPUT;
	public static final String JHELENA_GEN_ONCE_OUTPUT = "jHelena gen-once";
	public static final String PROMELA_GEN_OUTPUT = "Promela gen";

	/**
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	public Set<OutputConfiguration> getOutputConfigurations() {
		OutputConfiguration jHelenaDefaultOutput = new OutputConfiguration(
				JHELENA_GEN_OUTPUT);
		jHelenaDefaultOutput.setDescription("jHelena Output Folder");
		jHelenaDefaultOutput.setOutputDirectory("./src-gen");
		jHelenaDefaultOutput.setOverrideExistingResources(true);
		jHelenaDefaultOutput.setCreateOutputDirectory(true);
		jHelenaDefaultOutput.setCleanUpDerivedResources(true);
		jHelenaDefaultOutput.setSetDerivedProperty(true);

		OutputConfiguration jHelenaReadonlyOutput = new OutputConfiguration(
				JHELENA_GEN_ONCE_OUTPUT);
		jHelenaReadonlyOutput.setDescription("jHelena Read-only Output Folder");
		jHelenaReadonlyOutput.setOutputDirectory("./src-user");
		jHelenaReadonlyOutput.setOverrideExistingResources(false);
		jHelenaReadonlyOutput.setCreateOutputDirectory(true);
		jHelenaReadonlyOutput.setCleanUpDerivedResources(false);
		jHelenaReadonlyOutput.setSetDerivedProperty(false);

		OutputConfiguration promelaDefaultOutput = new OutputConfiguration(
				PROMELA_GEN_OUTPUT);
		promelaDefaultOutput.setDescription("Promela Output Folder");
		promelaDefaultOutput.setOutputDirectory("./promela-gen");
		promelaDefaultOutput.setOverrideExistingResources(true);
		promelaDefaultOutput.setCreateOutputDirectory(true);
		promelaDefaultOutput.setCleanUpDerivedResources(true);
		promelaDefaultOutput.setSetDerivedProperty(true);

		Set<OutputConfiguration> config = new HashSet<OutputConfiguration>();
		config.add(jHelenaDefaultOutput);
		config.add(jHelenaReadonlyOutput);
		config.add(promelaDefaultOutput);
		return config;
	}
}
