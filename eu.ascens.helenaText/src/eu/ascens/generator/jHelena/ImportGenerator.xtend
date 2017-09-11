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

import eu.ascens.helenaText.ComponentType
import eu.ascens.helenaText.EnsembleStructure
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.OperationType
import eu.ascens.helenaText.RoleType
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import java.util.TreeSet
import org.eclipse.xtext.xbase.compiler.ImportManager

import static extension eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Action.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_RoleType.*

class ImportGenerator {
	
	public static val HELENA_PATH = "eu.ascens.helena"
	
	/////////// Imports ////////////
	
	def static String compileImports(ComponentType ct, ImportManager im){
		val HELENA_IMPORTS = '''
			import «HELENA_PATH».dev.Component;
		'''
		
		val JAVA_IMPORTS = '''
			import java.util.logging.Logger;
		'''
	
		val DECLARED_IMPORTS = getDeclaredImports(im);
		
		return HELENA_IMPORTS + JAVA_IMPORTS + DECLARED_IMPORTS; 
	}
	
	def static String compileImports(EnsembleStructure ens, ImportManager im){
		val HELENA_IMPORTS = '''
			import «HELENA_PATH».dev.Component;
			import «HELENA_PATH».dev.Ensemble;
			import «HELENA_PATH».dev.exceptions.ComponentAlreadyAdoptsRoleException;
			import «HELENA_PATH».dev.exceptions.ComponentNotInEnsembleException;
			import «HELENA_PATH».dev.exceptions.PropertyNotDeclaredInClassException;
			import «HELENA_PATH».dev.exceptions.ReflectionException;
			import «HELENA_PATH».dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
			import «HELENA_PATH».dev.exceptions.RoleTypeNotAllowedForEnsembleException;
			import «HELENA_PATH».dev.exceptions.TooManyRoleInstancesException;
		'''

		val JAVA_IMPORTS = '''import java.util.Set;'''
		
		return JAVA_IMPORTS + HELENA_IMPORTS;
	}
	
	def static String compileImports(MessageType msgType, ImportManager im){
		val HELENA_IMPORTS = 
			'''
				import «HELENA_PATH».dev.Auxiliaries;
				import «HELENA_PATH».dev.Message;
				import «HELENA_PATH».dev.Role;
				import «HELENA_PATH».dev.Variable;
			'''
		val JAVA_IMPORTS = '''import java.util.ArrayList;'''
		val DECLARED_IMPORTS = getDeclaredImports(im);
		val DYNAMIC_IMPORTS = getDynamicImports(msgType, im)
		
		return 	JAVA_IMPORTS + 
				HELENA_IMPORTS + 
				DECLARED_IMPORTS + 
				DYNAMIC_IMPORTS;
	}
	
	def static String compileImports(OperationType opType, ImportManager im){
		val HELENA_IMPORTS = 
			'''
		    	import «HELENA_PATH».dev.Operation;
		    	import «HELENA_PATH».dev.Variable;
			'''
		val JAVA_IMPORTS = 
			'''
				import java.util.ArrayList;
				import java.util.Arrays;
				import java.util.List;
			'''
		val DECLARED_IMPORTS = getDeclaredImports(im);

		
		return 	JAVA_IMPORTS + 
				HELENA_IMPORTS + 
				DECLARED_IMPORTS;
	}
	
	/**
	 * Compile imports from model for SysManager classes
	 */
	def static String compileImports(Model model, ImportManager im){
		val HELENA_IMPORTS = '''
			import «HELENA_PATH».SysManager;
			import «HELENA_PATH».metadata.ComponentAssociationType;
			import «HELENA_PATH».metadata.ComponentType;
			import «HELENA_PATH».metadata.DataFieldType;
			import «HELENA_PATH».metadata.EnsembleStructure;
			import «HELENA_PATH».metadata.MessageType;
			import «HELENA_PATH».metadata.MultiplicityCapacityPair;
			import «HELENA_PATH».metadata.OperationType;
			import «HELENA_PATH».metadata.RoleFieldType;
			import «HELENA_PATH».metadata.RoleType;
			import «HELENA_PATH».dev.Auxiliaries;
			import «HELENA_PATH».dev.exceptions.ConfigurationFinishedException;
			import «HELENA_PATH».dev.exceptions.ComponentNotInEnsembleException;
			import «HELENA_PATH».dev.exceptions.PropertyNotDeclaredInClassException;
			import «HELENA_PATH».dev.exceptions.TypeAlreadyExistsException;
			
		'''

		val JAVA_IMPORTS = '''
			import java.util.ArrayList;
			import java.util.HashMap;
			import java.util.HashSet;
			import java.util.List;
			import java.util.Map;
			import java.util.Set;
		'''
		
		val DECLARED_IMPORTS = getDeclaredImports(im);
		val DYNAMIC_IMPORTS = getDynamicImports(model, im); 
				
		return 	JAVA_IMPORTS + HELENA_IMPORTS + 
				DECLARED_IMPORTS + DYNAMIC_IMPORTS;
	}
	
	def static String compileImports(RoleType rt, ImportManager im){
		val HELENA_IMPORTS = '''
			import «HELENA_PATH».dev.ActionPrefix;
			import «HELENA_PATH».dev.AndGuard;
			import «HELENA_PATH».dev.Atom;
			import «HELENA_PATH».dev.CreateRoleAction;
			import «HELENA_PATH».dev.Component;
			import «HELENA_PATH».dev.CompAssociationGetter;
			import «HELENA_PATH».dev.CompAttrGetter;
			import «HELENA_PATH».dev.CompAttrSetterAction;
			import «HELENA_PATH».dev.ComposedExpression;
			import «HELENA_PATH».dev.ComposedExpression.ExpressionOperator;
			import «HELENA_PATH».dev.GetRoleAction;
			import «HELENA_PATH».dev.IfThenElse;
			import «HELENA_PATH».dev.Ensemble;
			import «HELENA_PATH».dev.NondeterministicChoice;
			import «HELENA_PATH».dev.NotGuard;
			import «HELENA_PATH».dev.OperationCallAction;
			import «HELENA_PATH».dev.OrGuard;
			import «HELENA_PATH».dev.PlaysQuery;
			import «HELENA_PATH».dev.ProcessInvocation;
			import «HELENA_PATH».dev.ProcessExpression;
			import «HELENA_PATH».dev.Quit;
			import «HELENA_PATH».dev.ReceiveMessageAction;
			import «HELENA_PATH».dev.Role;
			import «HELENA_PATH».dev.RoleAttrGetter;
			import «HELENA_PATH».dev.RoleAttrSetterAction;
			import «HELENA_PATH».dev.SendMessageAction;
			import «HELENA_PATH».dev.Variable;
			import «HELENA_PATH».dev.exceptions.PropertyNotDeclaredInClassException;
			import «HELENA_PATH».dev.exceptions.ReflectionException;
			
		'''
		
		val JAVA_IMPORTS = ''''''
		
		val DECLARED_IMPORTS = getDeclaredImports(im);
		val DYNAMIC_IMPORTS = getDynamicImports(rt, im);
		
		return JAVA_IMPORTS + HELENA_IMPORTS + DECLARED_IMPORTS + DYNAMIC_IMPORTS;
	}
	
	
	
	
	/////////// Imports for impl files ////////////
	
	def static String compileImplImports(ComponentType ct, ImportManager im){
		
		val DECLARED_IMPORTS = getDeclaredImports(im)
		
		return DECLARED_IMPORTS; 
	}
	
	def static String compileImplImports(EnsembleStructure ens, ImportManager im){
		val HELENA_IMPORTS = '''
			import «HELENA_PATH».dev.Component;
			import «HELENA_PATH».dev.exceptions.ComponentAlreadyAdoptsRoleException;
			import «HELENA_PATH».dev.exceptions.ComponentNotInEnsembleException;
			import «HELENA_PATH».dev.exceptions.PropertyNotDeclaredInClassException;
			import «HELENA_PATH».dev.exceptions.ReflectionException;
			import «HELENA_PATH».dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
			import «HELENA_PATH».dev.exceptions.RoleTypeNotAllowedForEnsembleException;
			import «HELENA_PATH».dev.exceptions.TooManyRoleInstancesException;
		'''
		
		val JAVA_IMPORTS = '''import java.util.Set;'''
		
		return JAVA_IMPORTS + HELENA_IMPORTS;
	}
	
		
	def static String compileImplImports(Model model, ImportManager im){
		val HELENA_IMPORTS = '''
			import «HELENA_PATH».SysManager;
			import «HELENA_PATH».dev.exceptions.ComponentAlreadyAdoptsRoleException;
			import «HELENA_PATH».dev.exceptions.ComponentNotInEnsembleException;
			import «HELENA_PATH».dev.exceptions.PropertyNotDeclaredInClassException;
			import «HELENA_PATH».dev.exceptions.ReflectionException;
			import «HELENA_PATH».dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
			import «HELENA_PATH».dev.exceptions.RoleTypeNotAllowedForEnsembleException;
			import «HELENA_PATH».dev.exceptions.TooManyRoleInstancesException;
		'''
		return HELENA_IMPORTS; 
	}
	
	def static String compileImplImports(RoleType rt, ImportManager im){ 
		'''
			import «HELENA_PATH».dev.Ensemble;
		'''; 
	}
	
	
	
	
		/////////// Dynamic imports ////////////
	
	private def static String getDynamicImports(MessageType msgType, ImportManager im){
		
		var List<String> dynamic_imports = new ArrayList<String>();
		for (p : msgType.formalRoleParamsBlock.params) {
			var type = p.type.getFullName(".");
			dynamic_imports.add(getImportString(type))

		}
		return dynamic_imports.join("\n");
		
	}
	
	
	/**
	 * Compile imports from model for SysManager classes
	 */
	private def static String getDynamicImports(Model model, ImportManager im){
		var Set<String> dynamic_imports = new TreeSet<String>();
		//Import messages from all role types	
		for (rt : model.eResource.allContents.toIterable.filter(RoleType)) {
			for (msg : rt.rolemsgs) {
				var fullName = msg.getFullName(".");
				var importStr = getImportString(fullName);
				dynamic_imports.add(importStr);
			}
		}
		
		//Import operations from all component types
		for (ct : model.eResource.allContents.toIterable.filter(ComponentType)) {
			for (op : ct.ops) {
				var fullName = op.getFullName(".");
				var importStr = getImportString(fullName);
				dynamic_imports.add(importStr);
			}
		}
		
		return dynamic_imports.join("\n");
	}
	
	private def static String getDynamicImports(RoleType rt, ImportManager im){
		
		var Set<String> dynamic_imports = new HashSet<String>();
		var importString = "";
		//Import messageType Classes for abstract message calls
		var rb = rt.roleBehavior; 
		if(rb == null){
			return "";
		}
		var msgs = rb.abstractMessageCalls;
		for(msg: msgs){
			var msgType = msg.messageType;
			if(msgType == null)	return "";
			
			importString = getImportString(msgType.getFullName("."))
			dynamic_imports.add(importString);
		}

		//Import operationType Classes for operation calls
		var ops = rt.roleBehavior.operationCalls;
		for(op: ops){
			var opType = op.operationType;
			if(opType == null) return "";
			
			importString = getImportString(opType.getFullName("."));
			dynamic_imports.add(importString);
			
		}
		
		return dynamic_imports.join("\n"); 
	}
	
	
	/**
	 * @return String with imports: declared imports from .helena file
	 */
	private static def String getDeclaredImports(ImportManager im) {
		var String imports = '';
		for (i : im.imports) {
			imports = imports + getImportString(i)
		}
		return imports;
	}
	
	private def static String getImportString(String className) {
		return "import " + className + ";"
	}
}