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
package eu.ascens.helenaText.util

import java.util.List
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.TypesFactory

class JvmTypesHelper {
	
	/**
	 * Creats a JvmGenericType with simpleName set to className
	 */
	def static createJvmType(String className) {
		val declaredType = TypesFactory::eINSTANCE.createJvmGenericType
		declaredType.setSimpleName(className)
		declaredType
	}
	
	/**
	 * Return the wrapped JvmType (e.g. Integer for int)
	 */
	public def static JvmType getWrappedType(JvmType type){
		var wrapperName = type.simpleName.wrappedTypeAsString;
		createJvmType(wrapperName);
	}
	
	
	/**
	 * Return the wrapper classname for a primitive datatype (like e.g. int);
	 * e.g. if dataType is "int" -> the function returns Integer
	 */
	public def static String getWrappedTypeAsString(String typeName) {
		switch typeName {
			case "byte": return "Byte"
			case "short": return "Short"
			case "int": return "Integer"
			case "double" : return "Double"
			case "boolean": return "Boolean"
			case "char": return "Character"
			case "void": return "Void"
			//checks for arrays: wrapps first type part of the array, appends array brackets afterwards
			case typeName.contains("["): return getWrappedTypeAsString(typeName.substring(0, typeName.indexOf("["))) + typeName.substring(typeName.indexOf("["))
			default: return typeName
		}
	}
	
	public def static String getUnwrapperAsString(JvmType type) {
		switch type.simpleName {
			case "byte" : return ".byteValue()"
			case "Byte" : return ".byteValue()"
			case "short": return ".shortValue()"
			case "Short": return ".shortValue()"
			case "int": return ".intValue()"
			case "Integer": return ".intValue()"
			case "double" : return ".doubleValue()"
			case "Double" : return ".doubleValue()"
			case "boolean": return ".booleanValue()"
			case "Boolean": return ".booleanValue()"
			case "char": return ".charValue()"
			case "Character": return ".charValue()"
			default: return ""
		}
	}
	
	/**
	 * Compares two JvmTypes
	 * @returns true if both JvmTypes do have the same simpleName <br>
	 * false otherwise
	 */
	def static boolean typesEqual(JvmType first, JvmType second){
		return first.simpleName == second.simpleName;
	}
	/**
	 * Compares two Lists of JvmTypes
	 * @returns true if the elements from both lists do have the same simpleName <br>
	 * false otherwise
	 */
	def static boolean typesEqual(List<JvmType> list1, List<JvmType> list2) {
		if ( (list1 == null && list2 == null) ||
			(list1.size == 0 && list2.size == 0) ) {
			return true;
		}
		
		if (list1.size != list2.size) {
			return false;
		} 
		
		for (i : 0 ..< list1.size) {
			var first = list1.get(i);
			var second = list2.get(i);
			if (first.simpleName != second.simpleName) {
				return false;
			}
		}
		return true;
	}
}