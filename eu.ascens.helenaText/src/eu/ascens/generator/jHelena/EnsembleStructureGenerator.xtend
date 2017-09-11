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

import eu.ascens.helenaText.EnsembleStructure
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

import static extension eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator.*

class EnsembleStructureGenerator extends AbstractHelenaTextGenerator {
	
	protected new (TypeReferenceSerializer serializer, ImportManager im, GeneratorHelper genHelper){
		super(serializer, im, genHelper);
	}
	
	def String compile(EnsembleStructure it){
	'''
	
	«««package    
	package «packageName»;
    
    «««imports
	«ImportGenerator.compileImports(it, im)»
	
	«««body	
	public abstract class «classname» extends Ensemble {

		public «classname»(String ensembleID, Set<Component> comps) {
			super(ensembleID, comps);
		}
	
		public abstract void startEnsemble(Component initialComponent) 
			throws RoleTypeNotAllowedForEnsembleException,
	        RoleTypeNotAllowedForComponentTypeException,
	        ComponentNotInEnsembleException, 
	        ComponentAlreadyAdoptsRoleException, 
	        TooManyRoleInstancesException,
	        ReflectionException, PropertyNotDeclaredInClassException;

	}

	
	'''
	} 
	
	def String compileImpl(EnsembleStructure it){
	'''
	«««package    
	package «packageName»;

	 «««imports
	«ImportGenerator.compileImplImports(it, im)»
	
	
	public class «implClassname» extends «classname» {

		public «implClassname»(String ensembleID, Set<Component> comps) {
			super(ensembleID, comps);
		}

	@Override
	public void startEnsemble(Component initialComponent)
			throws RoleTypeNotAllowedForEnsembleException,
	        RoleTypeNotAllowedForComponentTypeException,
	        ComponentNotInEnsembleException, 
	        ComponentAlreadyAdoptsRoleException,
	        TooManyRoleInstancesException,
	        ReflectionException, PropertyNotDeclaredInClassException {
			//«METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER»
			throw new UnsupportedOperationException("«METHOD_NOT_IMPLEMENTED»: «USER_INPUT_REQUIRED»");
		}
	}
	
	'''
	}

}