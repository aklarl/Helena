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

import com.google.common.collect.Sets;
import eu.ascens.generator.jHelena.AbstractHelenaTextGenerator;
import eu.ascens.helenaText.AbstractComponentFieldType;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractFieldType;
import eu.ascens.helenaText.AbstractInstance;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.JvmTypesHelper;
import java.util.Arrays;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class GeneratorHelper {
  private XbaseCompiler xbase;
  
  private ImportManager im;
  
  private TypeReferenceSerializer serializer;
  
  private IQualifiedNameProvider qualifiedNameProvider;
  
  private final static Set<String> FORBIDDEN_GETTER_SETTER_NAMES = Sets.<String>newHashSet("name");
  
  public GeneratorHelper(final XbaseCompiler xbase, final TypeReferenceSerializer serializer, final ImportManager im) {
    this.xbase = xbase;
    this.serializer = serializer;
    this.qualifiedNameProvider = this.qualifiedNameProvider;
    this.im = im;
  }
  
  /**
   * Returns the shortName of a JvmTypeReference
   * This function uses a type reference serializer and
   * can handle complex data Types like ArrayList<String>
   */
  public String shortName(final JvmTypeReference ref) {
    String _xblockexpression = null;
    {
      final StringBuilderBasedAppendable result = new StringBuilderBasedAppendable(this.im);
      EObject _eContainer = ref.eContainer();
      this.serializer.serialize(ref, _eContainer, result);
      _xblockexpression = result.toString();
    }
    return _xblockexpression;
  }
  
  public String getJvmTypeAsString(final JvmTypeReference jvmTypeRef) {
    return this.shortName(jvmTypeRef);
  }
  
  protected String _getFieldTypeAsString(final ComponentAttributeType attr) {
    JvmTypeReference _type = attr.getType();
    return this.getJvmTypeAsString(_type);
  }
  
  protected String _getFieldTypeAsString(final ComponentAssociationType attr) {
    ComponentType _type = attr.getType();
    return _type.getName();
  }
  
  protected String _getFieldTypeAsString(final RoleAttributeType attr) {
    JvmTypeReference _type = attr.getType();
    return this.getJvmTypeAsString(_type);
  }
  
  public String getInstTypeAsString(final AbstractInstance inst) {
    return this.getInstTypeAsString_(inst);
  }
  
  private String _getInstTypeAsString_(final AbstractDataVariable dataVar) {
    JvmTypeReference _jvmTypeRefFromAbstrDataVar = ExtensionMethods_Param.getJvmTypeRefFromAbstrDataVar(dataVar);
    return this.shortName(_jvmTypeRefFromAbstrDataVar);
  }
  
  private String _getInstTypeAsString_(final AbstractRoleInstance roleInst) {
    RoleType _roleType = ExtensionMethods_Param.getRoleType(roleInst);
    return _roleType.getName();
  }
  
  /**
   * Returns the wrapped name of the abstract field type as string
   */
  public String getWrappedTypeAsString(final AbstractFieldType field) {
    String _fieldTypeAsString = this.getFieldTypeAsString(field);
    return JvmTypesHelper.getWrappedTypeAsString(_fieldTypeAsString);
  }
  
  /**
   * Returns the wrapped name of the abstract instance type as string
   */
  public String getWrappedTypeAsString(final AbstractInstance inst) {
    String _instTypeAsString = this.getInstTypeAsString(inst);
    return JvmTypesHelper.getWrappedTypeAsString(_instTypeAsString);
  }
  
  /**
   * Returns the wrapped shortName of the jvm type reference as string
   */
  public String getWrappedTypeAsString(final JvmTypeReference jvmTypeRef) {
    String _jvmTypeAsString = this.getJvmTypeAsString(jvmTypeRef);
    return JvmTypesHelper.getWrappedTypeAsString(_jvmTypeAsString);
  }
  
  /**
   * Returns the wrapped name of the abstract field type + .class extension as String
   */
  public String getWrappedClassAsString(final AbstractFieldType field) {
    String _fieldTypeAsString = this.getFieldTypeAsString(field);
    return GeneratorHelper.getWrappedClassAsString(_fieldTypeAsString);
  }
  
  /**
   * Returns the wrapped name of the abstract instance type + .class extension as String
   */
  public String getWrappedClassAsString(final AbstractInstance inst) {
    String _instTypeAsString = this.getInstTypeAsString(inst);
    return GeneratorHelper.getWrappedClassAsString(_instTypeAsString);
  }
  
  /**
   * Returns the simple name of the jvm type reference + .class extension as String
   * e.g. jvm type List<Integer> will return List
   */
  public String getWrappedClassAsString(final JvmTypeReference jvmTypeRef) {
    JvmType _type = jvmTypeRef.getType();
    String simpleName = _type.getSimpleName();
    return GeneratorHelper.getWrappedClassAsString(simpleName);
  }
  
  /**
   * Return the wrapper classname for a primitive datatype (like e.g. int) + .class extension
   * e.g. if dataType is "int" -> the function returns Integer.class
   * Complex data types like int[] are simplified to List.class
   */
  private static String getWrappedClassAsString(final String typeName) {
    String wrappedType = JvmTypesHelper.getWrappedTypeAsString(typeName);
    boolean _contains = typeName.contains("<");
    if (_contains) {
      int _indexOf = typeName.indexOf("<");
      String _substring = typeName.substring(0, _indexOf);
      wrappedType = _substring;
    }
    return ((wrappedType + ".") + AbstractHelenaTextGenerator.CLASS_EXTENSION);
  }
  
  /**
   * Returns the getter name of a field type
   */
  protected static String _getFieldGetterName(final RoleAttributeType f) {
    String _name = f.getName();
    return GeneratorHelper.getGetterNameFromString(_name);
  }
  
  protected static String _getFieldGetterName(final AbstractComponentFieldType f) {
    String _name = f.getName();
    String _getterNameFromString = GeneratorHelper.getGetterNameFromString(_name);
    return (_getterNameFromString + "OfOwner");
  }
  
  protected static String _getFieldSetterName(final RoleAttributeType f) {
    String _name = f.getName();
    return GeneratorHelper.getSetterNameFromString(_name);
  }
  
  protected static String _getFieldSetterName(final AbstractComponentFieldType f) {
    String _name = f.getName();
    String _setterNameFromString = GeneratorHelper.getSetterNameFromString(_name);
    return (_setterNameFromString + "OfOwner");
  }
  
  public static String getAbstrInstGetterName(final AbstractInstance abstrInst) {
    String _instName = ExtensionMethods.getInstName(abstrInst);
    return GeneratorHelper.getGetterNameFromString(_instName);
  }
  
  public static String getAbstrInstSetterName(final AbstractInstance abstrInst) {
    String _instName = ExtensionMethods.getInstName(abstrInst);
    return GeneratorHelper.getSetterNameFromString(_instName);
  }
  
  private static String getSetterNameFromString(final String variable) {
    String _escapedNameForGetterSetter = GeneratorHelper.getEscapedNameForGetterSetter(variable);
    String _firstUpper = StringExtensions.toFirstUpper(_escapedNameForGetterSetter);
    return ("set" + _firstUpper);
  }
  
  private static String getGetterNameFromString(final String variable) {
    String _escapedNameForGetterSetter = GeneratorHelper.getEscapedNameForGetterSetter(variable);
    String _firstUpper = StringExtensions.toFirstUpper(_escapedNameForGetterSetter);
    return ("get" + _firstUpper);
  }
  
  /**
   * Adds an underscore to a name if it is contained in the list of forbidden names
   * Escaping of a getter/setter name can be needed if a superclass declared a method with the same name
   * (e.g. getName is declared by class Thread and cannot be used in the subclass)
   */
  private static String getEscapedNameForGetterSetter(final String name) {
    String _xifexpression = null;
    boolean _contains = GeneratorHelper.FORBIDDEN_GETTER_SETTER_NAMES.contains(name);
    if (_contains) {
      _xifexpression = (name + "_");
    } else {
      _xifexpression = name;
    }
    return _xifexpression;
  }
  
  public String getFieldTypeAsString(final AbstractFieldType attr) {
    if (attr instanceof ComponentAssociationType) {
      return _getFieldTypeAsString((ComponentAssociationType)attr);
    } else if (attr instanceof ComponentAttributeType) {
      return _getFieldTypeAsString((ComponentAttributeType)attr);
    } else if (attr instanceof RoleAttributeType) {
      return _getFieldTypeAsString((RoleAttributeType)attr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(attr).toString());
    }
  }
  
  private String getInstTypeAsString_(final EObject dataVar) {
    if (dataVar instanceof AbstractDataVariable) {
      return _getInstTypeAsString_((AbstractDataVariable)dataVar);
    } else if (dataVar instanceof AbstractRoleInstance) {
      return _getInstTypeAsString_((AbstractRoleInstance)dataVar);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dataVar).toString());
    }
  }
  
  public static String getFieldGetterName(final AbstractFieldType f) {
    if (f instanceof AbstractComponentFieldType) {
      return _getFieldGetterName((AbstractComponentFieldType)f);
    } else if (f instanceof RoleAttributeType) {
      return _getFieldGetterName((RoleAttributeType)f);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(f).toString());
    }
  }
  
  public static String getFieldSetterName(final AbstractFieldType f) {
    if (f instanceof AbstractComponentFieldType) {
      return _getFieldSetterName((AbstractComponentFieldType)f);
    } else if (f instanceof RoleAttributeType) {
      return _getFieldSetterName((RoleAttributeType)f);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(f).toString());
    }
  }
}
