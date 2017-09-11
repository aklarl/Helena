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
package eu.ascens.helenaText.util;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class JvmTypesHelper {
  /**
   * Creats a JvmGenericType with simpleName set to className
   */
  public static JvmGenericType createJvmType(final String className) {
    JvmGenericType _xblockexpression = null;
    {
      final JvmGenericType declaredType = TypesFactory.eINSTANCE.createJvmGenericType();
      declaredType.setSimpleName(className);
      _xblockexpression = declaredType;
    }
    return _xblockexpression;
  }
  
  /**
   * Return the wrapped JvmType (e.g. Integer for int)
   */
  public static JvmType getWrappedType(final JvmType type) {
    JvmGenericType _xblockexpression = null;
    {
      String _simpleName = type.getSimpleName();
      String wrapperName = JvmTypesHelper.getWrappedTypeAsString(_simpleName);
      _xblockexpression = JvmTypesHelper.createJvmType(wrapperName);
    }
    return _xblockexpression;
  }
  
  /**
   * Return the wrapper classname for a primitive datatype (like e.g. int);
   * e.g. if dataType is "int" -> the function returns Integer
   */
  public static String getWrappedTypeAsString(final String typeName) {
    boolean _matched = false;
    if (Objects.equal(typeName, "byte")) {
      _matched=true;
      return "Byte";
    }
    if (!_matched) {
      if (Objects.equal(typeName, "short")) {
        _matched=true;
        return "Short";
      }
    }
    if (!_matched) {
      if (Objects.equal(typeName, "int")) {
        _matched=true;
        return "Integer";
      }
    }
    if (!_matched) {
      if (Objects.equal(typeName, "double")) {
        _matched=true;
        return "Double";
      }
    }
    if (!_matched) {
      if (Objects.equal(typeName, "boolean")) {
        _matched=true;
        return "Boolean";
      }
    }
    if (!_matched) {
      if (Objects.equal(typeName, "char")) {
        _matched=true;
        return "Character";
      }
    }
    if (!_matched) {
      if (Objects.equal(typeName, "void")) {
        _matched=true;
        return "Void";
      }
    }
    if (!_matched) {
      boolean _contains = typeName.contains("[");
      if (_contains) {
        _matched=true;
        int _indexOf = typeName.indexOf("[");
        String _substring = typeName.substring(0, _indexOf);
        String _wrappedTypeAsString = JvmTypesHelper.getWrappedTypeAsString(_substring);
        int _indexOf_1 = typeName.indexOf("[");
        String _substring_1 = typeName.substring(_indexOf_1);
        return (_wrappedTypeAsString + _substring_1);
      }
    }
    return typeName;
  }
  
  public static String getUnwrapperAsString(final JvmType type) {
    String _simpleName = type.getSimpleName();
    switch (_simpleName) {
      case "byte":
        return ".byteValue()";
      case "Byte":
        return ".byteValue()";
      case "short":
        return ".shortValue()";
      case "Short":
        return ".shortValue()";
      case "int":
        return ".intValue()";
      case "Integer":
        return ".intValue()";
      case "double":
        return ".doubleValue()";
      case "Double":
        return ".doubleValue()";
      case "boolean":
        return ".booleanValue()";
      case "Boolean":
        return ".booleanValue()";
      case "char":
        return ".charValue()";
      case "Character":
        return ".charValue()";
      default:
        return "";
    }
  }
  
  /**
   * Compares two JvmTypes
   * @returns true if both JvmTypes do have the same simpleName <br>
   * false otherwise
   */
  public static boolean typesEqual(final JvmType first, final JvmType second) {
    String _simpleName = first.getSimpleName();
    String _simpleName_1 = second.getSimpleName();
    return Objects.equal(_simpleName, _simpleName_1);
  }
  
  /**
   * Compares two Lists of JvmTypes
   * @returns true if the elements from both lists do have the same simpleName <br>
   * false otherwise
   */
  public static boolean typesEqual(final List<JvmType> list1, final List<JvmType> list2) {
    if (((Objects.equal(list1, null) && Objects.equal(list2, null)) || ((list1.size() == 0) && (list2.size() == 0)))) {
      return true;
    }
    int _size = list1.size();
    int _size_1 = list2.size();
    boolean _notEquals = (_size != _size_1);
    if (_notEquals) {
      return false;
    }
    int _size_2 = list1.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        JvmType first = list1.get((i).intValue());
        JvmType second = list2.get((i).intValue());
        String _simpleName = first.getSimpleName();
        String _simpleName_1 = second.getSimpleName();
        boolean _notEquals_1 = (!Objects.equal(_simpleName, _simpleName_1));
        if (_notEquals_1) {
          return false;
        }
      }
    }
    return true;
  }
}
