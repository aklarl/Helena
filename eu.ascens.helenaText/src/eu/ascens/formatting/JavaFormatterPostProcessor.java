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
package eu.ascens.formatting;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.FileHandleImpl;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtext.generator.IFilePostProcessor;

import com.google.inject.Inject;

public class JavaFormatterPostProcessor implements IFilePostProcessor{

	@Inject
	JavaBeautifier beautifier;
	
	public CharSequence postProcess(URI fileURI, CharSequence content) {
		
		if ("java".equalsIgnoreCase(fileURI.fileExtension())) {
			FileHandle handle = new FileHandleImpl(new Outlet(), new File(fileURI.toPlatformString(true)));
			handle.setBuffer(content);
			beautifier.beforeWriteAndClose(handle);
			
			return handle.getBuffer();
		}
		return content;
	}

}
