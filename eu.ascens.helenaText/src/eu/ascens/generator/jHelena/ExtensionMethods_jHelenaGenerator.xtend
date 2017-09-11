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
import eu.ascens.helenaText.InvokingRoleBehavior
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.PackageDeclaration
import eu.ascens.helenaText.Process
import eu.ascens.helenaText.RoleType

import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*

class ExtensionMethods_jHelenaGenerator {
	
	
	/**
	 * Returns the name of the Java File for an MessageType
	 */
	def static String getClassname(MessageType m) {
		if (m != null) {
			return m.name.toFirstUpper + AbstractHelenaTextGenerator.MESSAGE;
		}
		return "";
	}
	
	
	/**
	 * Returns the name of the Java File for an MessageType
	 */
	def static String getClassname(OperationType op) {
		if (op != null) {
			return op.name.toFirstUpper + AbstractHelenaTextGenerator.OPERATION;
		}
		return "";
	}
	

	/**
	 * Returns the class name of any Helena entity (component type, role type, ensemble structure)
	 */
	def static String getClassname(AbstractHelenaEntity obj) {
		return obj.name.toFirstUpper;
	}


	/**
	 * Returns the implementation class name of any Helena entity (component type, role type, ensemble structure)
	 */
	def static String getImplClassname(AbstractHelenaEntity obj) {
		return getClassname(obj) + AbstractHelenaTextGenerator.IMPL
	}
	
	
	/**
	 * Returns the name of the Java File of the SysManager
	 */
	def static String getSysManagerClassName(Model m) {
		var pkgName = m.headPkg.name;
		var baseName = "";
		if(pkgName.contains(".")){
			baseName = pkgName.split(".").last.toFirstUpper; 
		}else{
			baseName = pkgName.toFirstUpper;
		}
		return baseName + AbstractHelenaTextGenerator.SYSMANAGER;
	}
	
	/**
	  * Returns the name of the Java File of the SysManager Impl File
	  */
	def static String getSysManagerImplClassName(Model m) {
		return m.getSysManagerClassName() + AbstractHelenaTextGenerator.IMPL;
	}
	
	def static String getSysMgrPackageName(Model model) {
		return model.headPkg.name;
	}
	
	def static String getSysMgrFullName(Model model, String separator){
		var pkgName = model.sysMgrPackageName.replace(".", separator);
		var baseName = model.sysManagerClassName;
		
		return pkgName + separator + baseName;
	}
	
	/**
	 * Calculates the package String for an AbstractHelenaEntity via the headPackage
	 * @return packageName with the package elements separated by a dot
	 */
	def static String getPackageName(AbstractHelenaEntity helenaEntity) {
		var entity = helenaEntity.eContainer;
		while(!(entity instanceof PackageDeclaration)){
			entity = entity.eContainer;			
		}
		
		var pkg = entity as PackageDeclaration;
		var packageName = pkg.name.toString;
		
		return packageName;
	}

	/**
	 * Calculates the package String for a message type via its parent roleType
	 * @return packageName with the package elements separated by a dot
	 */
	def static String getPackageName(MessageType msgType) {
		var RoleType roleType = msgType.eContainer as RoleType;
		return getPackageName(roleType) + "." + AbstractHelenaTextGenerator.MESSAGES;
	}
	
	/**
	 * Calculates the package String for a message type via its parent roleType
	 * @return packageName with the package elements separated by a dot
	 */
	def static String getPackageName(OperationType opType) {
		var ComponentType roleType = opType.eContainer as ComponentType;
		return getPackageName(roleType) + "." + AbstractHelenaTextGenerator.OPERATIONS;
	}
	
	/**
	 * @return Returns a String with the package name of the entity, followed by the capital name of the entity
	 * The elements of the returned name are separated with the string passed as parameter separator
	 * @param separator char by which the path elements shall be separated
	 */
	def static String getFullName(AbstractHelenaEntity helenaEntity, String separator) {
		var packageName = getPackageName(helenaEntity).replace(".", separator);
		var entityName = helenaEntity.name.toFirstUpper;
		
		return packageName + separator + entityName;
	}	
	/**
	 * @return Returns a String with the package name of the entity, followed by the capital name of the entity
	 * The elements of the returned name are separated with the string passed as parameter separator
	 * @param separator char by which the path elements shall be separated
	 */
	def static String getFullName(MessageType msgType, String separator) {
		var packageName = getPackageName(msgType).replace(".", separator);
		var entityName = msgType.classname;
		
		return packageName + separator + entityName;
	}
	/**
	 * @return Returns a String with the package name of the entity, followed by the capital name of the entity
	 * The elements of the returned name are separated with the string passed as parameter separator
	 * @param separator char by which the path elements shall be separated
	 */
	def static String getFullName(OperationType opType, String separator) {
		var packageName = getPackageName(opType).replace(".", separator);
		var entityName = opType.classname;
		
		return packageName + separator + entityName;
	}
	
	
	/**
	 * Returns the name of a declared process (with first letter lowercase) 
	 * If a process name is "Get" or "Create" this functions appends the processInvocationName
	 * If a process name is the same as the processInvocationName the process name roleBehavior is returned
	 */
	def static String getProcessFunctionName(Process proc){
		var parentRb = proc.parentRoleBehavior;
		var processInvocName = ""; 
		var processFctName = "";
		
		if(parentRb instanceof InvokingRoleBehavior){
			var invokingRb = parentRb as InvokingRoleBehavior;
			processInvocName = invokingRb.processInvocation.process.name;
		}
		if(proc.name == processInvocName){
			processFctName = AbstractHelenaTextGenerator.ROLEBEHAVIOR_FUNCTION;
		}else if(proc.name == "Get" || proc.name == "Create"){
			processFctName =  proc.name + processInvocName;
		}
		else{
			processFctName =  proc.name;
		}
		return processFctName.toFirstLower;
	}
	
	def static String getOperationFunctionName(OperationType op){
		return op.name.toFirstLower + AbstractHelenaTextGenerator.OPERATION;
	}
	
	
}