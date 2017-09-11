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

import com.google.common.collect.Sets
import eu.ascens.helenaText.AbstractComponentFieldType
import eu.ascens.helenaText.AbstractDataVariable
import eu.ascens.helenaText.AbstractFieldType
import eu.ascens.helenaText.AbstractInstance
import eu.ascens.helenaText.AbstractRoleInstance
import eu.ascens.helenaText.ComponentAssociationType
import eu.ascens.helenaText.ComponentAttributeType
import eu.ascens.helenaText.RoleAttributeType
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer
import org.eclipse.xtext.xbase.compiler.XbaseCompiler

import static eu.ascens.helenaText.util.JvmTypesHelper.*

import static extension eu.ascens.helenaText.util.ExtensionMethods.*
import static extension eu.ascens.helenaText.util.ExtensionMethods_Param.*

class GeneratorHelper{
	private XbaseCompiler xbase;
	private ImportManager im; 
	private TypeReferenceSerializer serializer;
	private IQualifiedNameProvider qualifiedNameProvider;
	private final static Set<String> FORBIDDEN_GETTER_SETTER_NAMES = Sets.newHashSet("name") 
	

	new (XbaseCompiler xbase, TypeReferenceSerializer serializer, ImportManager im){
		this.xbase = xbase; 
		this.serializer = serializer;
		this.qualifiedNameProvider = qualifiedNameProvider;
		this.im = im;
	}
	

	/**
	 * Returns the shortName of a JvmTypeReference
	 * This function uses a type reference serializer and 
	 * can handle complex data Types like ArrayList<String> 
	 */
	def String shortName(JvmTypeReference ref) {
	    val result = new StringBuilderBasedAppendable(im)
	    serializer.serialize(ref, ref.eContainer, result);
	    result.toString
   	}
   
    def String getJvmTypeAsString(JvmTypeReference jvmTypeRef){
		return shortName(jvmTypeRef);
	}
	
   	/////// Field type as string ////////
	def dispatch String getFieldTypeAsString(ComponentAttributeType attr){
		return attr.type.jvmTypeAsString
	}
	def dispatch String getFieldTypeAsString(ComponentAssociationType attr){
		return attr.type.name;
	}
	def dispatch String getFieldTypeAsString(RoleAttributeType attr){
		return attr.type.jvmTypeAsString
	}
	
   	/////// Instance type as string ////////
	def String getInstTypeAsString(AbstractInstance inst){
		return inst.getInstTypeAsString_
	}
	
	private def dispatch String getInstTypeAsString_(AbstractDataVariable dataVar){
		return dataVar.jvmTypeRefFromAbstrDataVar.shortName;
	}
	private def dispatch String getInstTypeAsString_(AbstractRoleInstance roleInst){
		return roleInst.roleType.name
	}
	
   
   	/////// Get wrapped type ////////
   	/**
	 * Returns the wrapped name of the abstract field type as string
	 */
   	def String getWrappedTypeAsString(AbstractFieldType field){
   		return getWrappedTypeAsString(field.fieldTypeAsString);
   	}
   	/**
	 * Returns the wrapped name of the abstract instance type as string
	 */   	
   	def String getWrappedTypeAsString(AbstractInstance inst){
   		return getWrappedTypeAsString(inst.instTypeAsString);
   	}
   	/**
	 * Returns the wrapped shortName of the jvm type reference as string
	 */
	def String getWrappedTypeAsString(JvmTypeReference jvmTypeRef) {
		return getWrappedTypeAsString(jvmTypeRef.jvmTypeAsString);
	}

	
	
	
	/////// Get wrapped class including .class extension ////////
	/**
	 * Returns the wrapped name of the abstract field type + .class extension as String
	 */
	def String getWrappedClassAsString(AbstractFieldType field){
   		return getWrappedClassAsString(field.fieldTypeAsString);
   	}
   	/**
   	 * Returns the wrapped name of the abstract instance type + .class extension as String
   	 */
   	def String getWrappedClassAsString(AbstractInstance inst){
   		return getWrappedClassAsString(inst.instTypeAsString);
   	}
   	/**
   	 * Returns the simple name of the jvm type reference + .class extension as String
   	 * e.g. jvm type List<Integer> will return List 
   	 */
	def getWrappedClassAsString(JvmTypeReference jvmTypeRef) {
		var simpleName = jvmTypeRef.type.simpleName;
		return getWrappedClassAsString(simpleName);
	}
	
	/**
	 * Return the wrapper classname for a primitive datatype (like e.g. int) + .class extension
	 * e.g. if dataType is "int" -> the function returns Integer.class
	 * Complex data types like int[] are simplified to List.class
	 */
	private def static String getWrappedClassAsString(String typeName) {
		var wrappedType = getWrappedTypeAsString(typeName);
		if(typeName.contains("<")){
			wrappedType = typeName.substring(0, typeName.indexOf("<"));
 		}
		return wrappedType + "." + AbstractHelenaTextGenerator.CLASS_EXTENSION;
	}

	/**
	 * Returns the getter name of a field type
	 */
	def static dispatch String getFieldGetterName(RoleAttributeType f){
		return getGetterNameFromString(f.name);
	}
	def static dispatch String getFieldGetterName(AbstractComponentFieldType f){
		return getGetterNameFromString(f.name) + "OfOwner";
	}
	
	def static dispatch String getFieldSetterName(RoleAttributeType f){
		return getSetterNameFromString(f.name);
	}
	def static dispatch String getFieldSetterName(AbstractComponentFieldType f){
		return getSetterNameFromString(f.name) + "OfOwner";
	}
	
	def static String getAbstrInstGetterName(AbstractInstance abstrInst){
		return getGetterNameFromString(abstrInst.instName);
	}
	def static String getAbstrInstSetterName(AbstractInstance abstrInst){
		return getSetterNameFromString(abstrInst.instName);
	}
		
	private def static String getSetterNameFromString(String variable){
		return "set" + variable.getEscapedNameForGetterSetter.toFirstUpper
	}
	private def static String getGetterNameFromString(String variable){
		return "get" + variable.getEscapedNameForGetterSetter.toFirstUpper
	}

	/**
	 * Adds an underscore to a name if it is contained in the list of forbidden names
	 * Escaping of a getter/setter name can be needed if a superclass declared a method with the same name
	 * (e.g. getName is declared by class Thread and cannot be used in the subclass)
	 */
	private def static String getEscapedNameForGetterSetter(String name){
		return if(FORBIDDEN_GETTER_SETTER_NAMES.contains(name)) name + "_" else name;
	}
}

/**
 * Helper class for setting string variables in template expressions
 * with void as return value
 * <p>For the example <br>
 * <code>
 * (1) «var someString = "First"»	//Prints nothing <br>
 * (2) «someString = "Second"»		//Prints "Second"<br>
 * </code>
 * the code in line 2 prints/returns the value "Second", as in Xtend template 
 * expressions "everything is a value".
 * </p>
 * <p> 
 * If the StringValue class is used instead, this behavior can be prevented: <br>
 * <code>
 * (1) «var StringValue someString = new StringValue("First");	//Prints nothing <br>
 * (2) «someString.setValue("Second")							//Prints nothing <br>
 * (3) «someString.value»										//Prints "Second" <br>
 * </code>
 * </p>
 */
class StringValueContainer {
    @Accessors
    private var String stringValue

    new(String stringValue){
        this.stringValue = stringValue
    }
    def void setValue(String newVal){
    	this.stringValue = newVal;
    }
    def String getValue(){
    	return this.stringValue;
    }
}
