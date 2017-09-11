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

import eu.ascens.helenaText.ComponentAttributeType
import eu.ascens.helenaText.ComponentType
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

import static extension eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods.*

class ComponentTypeGenerator extends AbstractHelenaTextGenerator {
	
	private AbstractFieldTypeGenerator fieldTypeGenerator;
//	private final List<String> FORBIDDEN_VAR_NAMES = Arrays.asList("log");
	
	protected new(TypeReferenceSerializer serializer, ImportManager im, GeneratorHelper genHelper) {
		super(serializer, im, genHelper)
		
		//Generate AttrTypeGenerator
		this.fieldTypeGenerator = new AbstractFieldTypeGenerator(this.serializer, this.im, this.genHelper)
	}
	
	def String compile(ComponentType it){
	'''
	
	«««package    
	package «packageName»;
    
    «««imports
	«ImportGenerator.compileImports(it, im)»
	
	«««body	
	public abstract class «classname» extends Component{
		
		«««Attributes and assocs
		«FOR a:it.getFields»
			«fieldTypeGenerator.compile(a, im)»
	    «ENDFOR»

		«««Constructor
		public «classname»(«FOR f: it.fields SEPARATOR ","»«genHelper.getWrappedTypeAsString(f)» «f.name»«ENDFOR»){
			«FOR a:it.fields»
				this.«a.name» = «a.name»;
			«ENDFOR»
		}
		
		«««abstract operations
		«FOR op: it.ops»
			«var retType = genHelper.getWrappedTypeAsString(op.returnType)»
			«var params = op.formalDataParamsBlock.params»
			public abstract «retType» «op.operationFunctionName»(
			«FOR p: params SEPARATOR ","»«genHelper.getWrappedTypeAsString(p.type)» «p.name»«ENDFOR»
			) throws InstantiationException;
		«ENDFOR»
		
		
		«««Setter functions for assocs
		«FOR a:it.assocs»
			public void set«a.name.toFirstUpper»(«genHelper.getWrappedTypeAsString(a)» «a.name»){
				this.«a.name» = «a.name»;	
			}
		«ENDFOR»
	}
	
	'''
	}
	
	
	def String compileImpl(ComponentType it){
	'''
	
	«««package    
	package «packageName»;
    
    «««imports
	«ImportGenerator.compileImplImports(it, im)»
	
	«««body	
	public class «implClassname» extends «classname»{
		«««Constructor
		public «implClassname»(«FOR f : it.fields SEPARATOR ","»«genHelper.getWrappedTypeAsString(f)» «f.name»«ENDFOR»){
			super(
				«FOR f : it.fields SEPARATOR ","»
					«f.name»
				«ENDFOR»
			);
		}
		
		«««Constructor without assoc (only if there are assocs!)
		«IF !it.assocs.empty»
		public «implClassname»(«FOR a: it.attrs SEPARATOR ","»«genHelper.getWrappedTypeAsString(a)» «a.name»«ENDFOR»){
			this(			
				«FOR a:it.fields SEPARATOR ","»
					«IF a instanceof ComponentAttributeType»
						«a.name»
					«ELSE»	null
					«ENDIF»
				«ENDFOR»
			);
		}
		«ENDIF»
	
		«««Operations
		«FOR op: it.ops»
			«var retType = genHelper.getWrappedTypeAsString(op.returnType)»
			«var params = op.formalDataParamsBlock.params»
			@Override
			public «retType» «op.operationFunctionName» (
			«FOR p: params SEPARATOR ","» «genHelper.getWrappedTypeAsString(p.type)» «p.name»«ENDFOR») throws InstantiationException {
				//«METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER»
				throw new UnsupportedOperationException("«METHOD_NOT_IMPLEMENTED»: «USER_INPUT_REQUIRED»");
			}
		«ENDFOR»
	
	
	}
	
	'''
	}
}