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

import eu.ascens.helenaText.DataExpression
import org.eclipse.xtext.common.types.JvmType

import static eu.ascens.helenaText.util.JvmTypesHelper.*

import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*

class ExtensionMethods_JvmType {
	
	def static boolean isBool(DataExpression expression) {
		var type = expression.wrappedJvmType.simpleName;
		return type == 'Boolean';
	}
	
	def static isNumber(DataExpression expression){
		var type = expression.wrappedJvmType.simpleName;
		return type == 'Integer' || type == 'Double'
	}
	
	
	def static boolean isBoolean(JvmType jvmType){
		return getWrappedTypeAsString(jvmType.simpleName) == 'Boolean';
	}
	def static boolean isNumber(JvmType jvmType){
		var typeAsString = getWrappedTypeAsString(jvmType.simpleName);
		return typeAsString == "Integer" || typeAsString == "Double"  
	}
	
	def static boolean isVoid(JvmType jvmType) {
		return getWrappedTypeAsString(jvmType.simpleName) == 'Void';
	}
	
	def static boolean isOfPromelaType(JvmType type) {
		var simpleType = getWrappedTypeAsString(type.simpleName);
		return simpleType == 'Byte' || simpleType == 'Short' || 
			simpleType == 'Integer' || simpleType == 'Boolean';
	}
	
	def static boolean isInt(JvmType type) {
		return getWrappedTypeAsString(type.simpleName) == "Integer";
	}
}