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
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.util.ExtensionMethods_Param;
import eu.ascens.helenaText.util.JvmTypesHelper;
import org.eclipse.xtext.common.types.JvmType;

@SuppressWarnings("all")
public class ExtensionMethods_JvmType {
  public static boolean isBool(final DataExpression expression) {
    JvmType _wrappedJvmType = ExtensionMethods_Param.getWrappedJvmType(expression);
    String type = _wrappedJvmType.getSimpleName();
    return Objects.equal(type, "Boolean");
  }
  
  public static boolean isNumber(final DataExpression expression) {
    JvmType _wrappedJvmType = ExtensionMethods_Param.getWrappedJvmType(expression);
    String type = _wrappedJvmType.getSimpleName();
    return (Objects.equal(type, "Integer") || Objects.equal(type, "Double"));
  }
  
  public static boolean isBoolean(final JvmType jvmType) {
    String _simpleName = jvmType.getSimpleName();
    String _wrappedTypeAsString = JvmTypesHelper.getWrappedTypeAsString(_simpleName);
    return Objects.equal(_wrappedTypeAsString, "Boolean");
  }
  
  public static boolean isNumber(final JvmType jvmType) {
    String _simpleName = jvmType.getSimpleName();
    String typeAsString = JvmTypesHelper.getWrappedTypeAsString(_simpleName);
    return (Objects.equal(typeAsString, "Integer") || Objects.equal(typeAsString, "Double"));
  }
  
  public static boolean isVoid(final JvmType jvmType) {
    String _simpleName = jvmType.getSimpleName();
    String _wrappedTypeAsString = JvmTypesHelper.getWrappedTypeAsString(_simpleName);
    return Objects.equal(_wrappedTypeAsString, "Void");
  }
  
  public static boolean isOfPromelaType(final JvmType type) {
    String _simpleName = type.getSimpleName();
    String simpleType = JvmTypesHelper.getWrappedTypeAsString(_simpleName);
    return (((Objects.equal(simpleType, "Byte") || Objects.equal(simpleType, "Short")) || 
      Objects.equal(simpleType, "Integer")) || Objects.equal(simpleType, "Boolean"));
  }
  
  public static boolean isInt(final JvmType type) {
    String _simpleName = type.getSimpleName();
    String _wrappedTypeAsString = JvmTypesHelper.getWrappedTypeAsString(_simpleName);
    return Objects.equal(_wrappedTypeAsString, "Integer");
  }
}
