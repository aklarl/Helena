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

import eu.ascens.helenaText.AbstractHelenaEntity
import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.EnsembleStructure
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.MsgDirection
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.RoleType
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer

import static extension eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_EnsembleStructure.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

class SysManagerGenerator extends AbstractHelenaTextGenerator {
	
	protected new (TypeReferenceSerializer serializer, ImportManager im, GeneratorHelper genHelper){
		super(serializer, im, genHelper);
	}
	
	
	def compile(Model it){
		'''
		«««package	
		package «sysMgrPackageName»;
				
		«««imports (standard java classes (e.g. java.util.List) and Helena classes)		
		«ImportGenerator.compileImports(it, im)»
		
			
		«««body	
		«var allEnsembleStructures = it.eResource.allContents.toIterable.filter(EnsembleStructure).toList»
		public abstract class «sysManagerClassName» extends SysManager {

			@Override
			protected void configureTypes() throws ConfigurationFinishedException,
				TypeAlreadyExistsException, PropertyNotDeclaredInClassException {
				
				«««iterate over componentTypes				
				«FOR ct: it.eResource.allContents.toIterable.filter(ComponentType)»
					
					«««prepare data params for creating the operation type
					«FOR op : ct.ops»
						«var params = op.formalDataParamsBlock.params»
						«IF params.size > 0»
							List<DataFieldType> «getDataParamVariableName(op)» = new ArrayList<>();
							«FOR param : params»
								«getDataParamVariableName(op)».add(
									DataFieldType.createType("«param.name»", «genHelper.getWrappedClassAsString(param.type)»));
							«ENDFOR»
						«ENDIF»
					«ENDFOR»


					«««create component type					
					ComponentType «getCompTypeVariableName(ct)» = ComponentType.createType(
						«ct.classname».class,

					«««attribute types
						«IF ct.attrs.length == 0» new HashSet<DataFieldType>(),
						«ELSE»	
							Auxiliaries.getAsSet(
							«FOR attr : ct.attrs SEPARATOR ","»
								«var attrClass = genHelper.getWrappedClassAsString(attr.type)»
								DataFieldType.createType("«attr.name»", «attrClass»)
							«ENDFOR»
							),
						«ENDIF»
					«««assoc types
						«IF ct.assocs.length == 0» new HashSet<ComponentAssociationType>(), 
						«ELSE»	
							Auxiliaries.getAsSet(
							«FOR assoc : ct.assocs SEPARATOR ","»
								ComponentAssociationType.createType("«assoc.name»", «assoc.type.classname».«CLASS_EXTENSION»)
							«ENDFOR» 
							),
						«ENDIF»
						
					«««operation types
						«IF ct.ops.length == 0» new HashSet<OperationType>()
						«ELSE»	
							Auxiliaries.getAsSet(
							«FOR op : ct.ops SEPARATOR ","»
								«var retClass = genHelper.getWrappedClassAsString(op.returnType)»
								OperationType.createType(
									«op.classname».«CLASS_EXTENSION»,
									«IF op.formalDataParamsBlock.params.size == 0» new ArrayList<DataFieldType>()
									«ELSE» «getDataParamVariableName(op)» 
									«ENDIF»,
									«retClass»
								)
							«ENDFOR»
							)
						«ENDIF»
					);
					this.addCompType(«getCompTypeVariableName(ct)»);
				«ENDFOR»
				
				«FOR es: allEnsembleStructures»
					this.addEnsembleStructure(
						EnsembleStructure.createType(
							«es.classname».class, «getRolesFctName(es, allEnsembleStructures)»()
						)
					);
				«ENDFOR»
			}
			
			«FOR es: allEnsembleStructures»
			private static Map<RoleType, MultiplicityCapacityPair> «getRolesFctName(es, allEnsembleStructures)»() 
				throws ConfigurationFinishedException, TypeAlreadyExistsException,
				PropertyNotDeclaredInClassException {
				Map<RoleType, MultiplicityCapacityPair> roles = new HashMap<>();
				
				«var msgs = it.allMessagesInModel»
				«FOR msg: msgs»
				MessageType «getMsgVariableName(msg)» = 
					MessageType.createType(«msg.classname».«CLASS_EXTENSION»,
						«IF msg.formalRoleParamsBlock.params.size > 0»
						Auxiliaries.getAsList(
							«FOR param: msg.formalRoleParamsBlock.params SEPARATOR ','»
							RoleFieldType.createType("«param.name»", «param.type.classname».«CLASS_EXTENSION»)
							«ENDFOR»
						)
						«ELSE»
						new ArrayList<RoleFieldType>()
						«ENDIF»
						,
						«IF msg.formalDataParamsBlock.params.size > 0»
						Auxiliaries.getAsList(
							«FOR param: msg.formalDataParamsBlock.params SEPARATOR ','»
							DataFieldType.createType("«param.name»", «genHelper.getWrappedClassAsString(param.type)»)
							«ENDFOR»
						)
						«ELSE»
						new ArrayList<DataFieldType>()
						«ENDIF»
					);
				«ENDFOR»
				
				«var roleTypesForCurEns = es.rtWithMult.map[rtWithMult| rtWithMult.roleType]»
				«FOR role: roleTypesForCurEns»
					«val role_name = role.name.toFirstLower»
					// «role_name»
					Set<ComponentType> «getCompTypesVariableName(role)» = Auxiliaries.getAsSet(
							«FOR ct : role.compTypes SEPARATOR ","»
							ComponentType.getType(«ct.classname».class)
							«ENDFOR»
					);
					
					««« attributes				
					Set<DataFieldType> «getAttrTypesVariableName(role)» = new HashSet<>();
						«FOR roleAttr : role.roleattrs»
							«getAttrTypesVariableName(role)».add(
								DataFieldType.createType("«roleAttr.name»", «genHelper.getWrappedClassAsString(roleAttr.type)»)
							);
						«ENDFOR»
						
					««« outgoing msgs
					Set<MessageType> «getMsgsOutVariableName(role)» = Auxiliaries.getAsSet(
						«FOR msg :  role.getAllMessagesOfDirection(MsgDirection.OUT) SEPARATOR ","»
							«getMsgVariableName(msg)»
						«ENDFOR»
					);
					
					««« incoming msgs
					Set<MessageType> «getMsgsInVariableName(role)» = Auxiliaries.getAsSet(
						«FOR msg : role.getAllMessagesOfDirection(MsgDirection.IN) SEPARATOR ","»
							«getMsgVariableName(msg)»
						«ENDFOR»
						);
			
					roles.put(
							RoleType.createType(
								«role.classname».«CLASS_EXTENSION», 
								«getCompTypesVariableName(role)»,
								«getAttrTypesVariableName(role)», 
								«getMsgsOutVariableName(role)», 
								«getMsgsInVariableName(role)»
							), 
							new MultiplicityCapacityPair(«es.getMaxMultiplicityForRoleType(role)», «es.getCapacityForRoleType(role)»)
					);
				«ENDFOR»				
				return roles;
			}
			«ENDFOR»

			
		}	
		
		'''
	}
	
	def String compileImpl(Model it){
	'''
	«««package	
	package «sysMgrPackageName»;
	
	«««imports
	«ImportGenerator.compileImplImports(it, im)»
		
	
	public class «getSysManagerImplClassName» extends «getSysManagerClassName()» {
		public «getSysManagerImplClassName»(){
			super();
		}
		
		public static void main(String[] args) {
			SysManager sys = new «getSysManagerImplClassName»();
			sys.start();
		}
		
		protected void createComponents() {
			//«METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER»
			throw new UnsupportedOperationException("«METHOD_NOT_IMPLEMENTED»: «USER_INPUT_REQUIRED»");
			
		}
		
		protected void startEnsembles() 
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
	
	
	private def getCompTypeVariableName(ComponentType ct){
		return getVarName(ct, "Type");
	}
	
	private def getDataParamVariableName(OperationType op){
		return "dataparams_"+op.name+"Operation";
	}
	
	private def getAttrTypesVariableName(RoleType rt){
		return getVarName(rt, "AttrTypes");
	}
	
	private def getCompTypesVariableName(RoleType rt){
		return getVarName(rt, "CompTypes");
	}
	
	private def getMsgVariableName(MessageType msg) {
		return msg.name.toFirstLower + "Msg";
	}
	
	private def getMsgsOutVariableName(RoleType rt){
		return getVarName(rt, "MsgsOut");
	}
	
	private def getMsgsInVariableName(RoleType rt){
		return getVarName(rt, "MsgsIn");
	}
	private def getVarName(AbstractHelenaEntity entitiy, String addon){
		return entitiy.name.toFirstLower + addon;
	}
	/**
	 * Calculates the name of the getRoles Function
	 * @return If one ensemble structure exists: "getRoles"
	 * @return if more than one ensemble structure exist: get«ensStruct.name»Roles 
	 */
	private def static String getRolesFctName(EnsembleStructure es, Iterable<EnsembleStructure> ensStructs){
		if(ensStructs.size == 1){
			return "getRoles";
		}
		else{
			return "get"+es.name.toFirstUpper+"Roles";
		}
	}
}