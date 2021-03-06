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
package eu.ascens.generator.jHelena

import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

abstract class AbstractHelenaTextGenerator {
	package final static val CLASS_EXTENSION = "class"
	package final static val String MESSAGE = "Message";
	package final static val String MESSAGES = "messages";
	package final static val String OPERATION = "Operation";
	package final static val String OPERATIONS = "operations";
	package final static val String SYSMANAGER = "SysManager"
	package final static val String IMPL = "Implementation"
	package final static val String ROLEBEHAVIOR_FUNCTION = "roleBehavior"
	package final val METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER = "TODO: This function has to be implemented by the user"
	package final val METHOD_NOT_IMPLEMENTED = "Method not implemented"
	package final val USER_INPUT_REQUIRED = "User Input required"
	package final val NO_ROLEBEHAVIOR_DEFINED = "No role behavior was defined in helenaText"
	
	
	protected TypeReferenceSerializer serializer;
	protected ImportManager im;
	protected GeneratorHelper genHelper;
	
	protected new (TypeReferenceSerializer serializer, ImportManager im, GeneratorHelper genHelper){
		this.serializer = serializer;
		this.im = im;
		this.genHelper = genHelper;
	}
}