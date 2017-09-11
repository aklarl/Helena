/**
 * The Helena workbench is an Eclipse plugin for the development of ensemble-based systems
 *  according to the Helena approach. It is fully documented in the PhD
 *  thesis "Helena - Handling massively distributed systems with ELaborate
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 * 
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
 */
package eu.ascens.generator.jHelena;

import eu.ascens.generator.jHelena.GeneratorHelper;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public abstract class AbstractHelenaTextGenerator {
  final static String CLASS_EXTENSION = "class";
  
  final static String MESSAGE = "Message";
  
  final static String MESSAGES = "messages";
  
  final static String OPERATION = "Operation";
  
  final static String OPERATIONS = "operations";
  
  final static String SYSMANAGER = "SysManager";
  
  final static String IMPL = "Implementation";
  
  final static String ROLEBEHAVIOR_FUNCTION = "roleBehavior";
  
  final String METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER = "TODO: This function has to be implemented by the user";
  
  final String METHOD_NOT_IMPLEMENTED = "Method not implemented";
  
  final String USER_INPUT_REQUIRED = "User Input required";
  
  final String NO_ROLEBEHAVIOR_DEFINED = "No role behavior was defined in helenaText";
  
  protected TypeReferenceSerializer serializer;
  
  protected ImportManager im;
  
  protected GeneratorHelper genHelper;
  
  protected AbstractHelenaTextGenerator(final TypeReferenceSerializer serializer, final ImportManager im, final GeneratorHelper genHelper) {
    this.serializer = serializer;
    this.im = im;
    this.genHelper = genHelper;
  }
}
