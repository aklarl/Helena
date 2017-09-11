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

import eu.ascens.helenaText.AbstractInstance
import eu.ascens.helenaText.MessageType
import java.util.ArrayList
import java.util.List
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

import static extension eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods.*

class MessageTypeGenerator extends AbstractHelenaTextGenerator {
	
	protected new(TypeReferenceSerializer serializer, ImportManager im, GeneratorHelper genHelper) {
		super(serializer, im, genHelper)
	}
	
	
	
	def String compile(MessageType it){
	'''
	
	«««package
	package «packageName»;
    
    «««imports
	«ImportGenerator.compileImports(it, im)»
	
	«««body	
	«val className = it.classname»
	public class «className» extends Message{
		
		«var roleParams = it.formalRoleParamsBlock.params.filterNull.toList»
		«var dataParams = it.formalDataParamsBlock.params.filterNull.toList»
		
		«var List<AbstractInstance> allParams = new ArrayList<AbstractInstance>(roleParams)»
		«var added = allParams.addAll(dataParams)»
		
		«««Constructor, params: first role params, then data params
		public «className»(«FOR p: allParams SEPARATOR ","»Variable<«genHelper.getWrappedTypeAsString(p)»> «p.instName»«ENDFOR»){
			super(
				«IF roleParams.size > 0»
				Auxiliaries.getAsList(
					«FOR p:roleParams SEPARATOR ', '»
					«p.instName»
		    		«ENDFOR»
	    		)
	    		«ELSE»
	    		new ArrayList<Variable<Role>>()
	    		«ENDIF»
	    		,
				«IF dataParams.size > 0»
				Auxiliaries.getAsList(
					«FOR p:dataParams SEPARATOR ', '»
					«p.instName»
		    		«ENDFOR»
	    		)
	    		«ELSE»
	    		new ArrayList<Variable<Object>>()
	    		«ENDIF»
    		);
		}
	}
	'''
	}
	
}