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

import com.google.common.base.Objects;
import eu.ascens.generator.jHelena.AbstractHelenaTextGenerator;
import eu.ascens.helenaText.AbstractHelenaEntity;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.InvokingRoleBehavior;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.ProcessInvocation;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ExtensionMethods_jHelenaGenerator {
  /**
   * Returns the name of the Java File for an MessageType
   */
  public static String getClassname(final MessageType m) {
    boolean _notEquals = (!Objects.equal(m, null));
    if (_notEquals) {
      String _name = m.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      return (_firstUpper + AbstractHelenaTextGenerator.MESSAGE);
    }
    return "";
  }
  
  /**
   * Returns the name of the Java File for an MessageType
   */
  public static String getClassname(final OperationType op) {
    boolean _notEquals = (!Objects.equal(op, null));
    if (_notEquals) {
      String _name = op.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      return (_firstUpper + AbstractHelenaTextGenerator.OPERATION);
    }
    return "";
  }
  
  /**
   * Returns the class name of any Helena entity (component type, role type, ensemble structure)
   */
  public static String getClassname(final AbstractHelenaEntity obj) {
    String _name = obj.getName();
    return StringExtensions.toFirstUpper(_name);
  }
  
  /**
   * Returns the implementation class name of any Helena entity (component type, role type, ensemble structure)
   */
  public static String getImplClassname(final AbstractHelenaEntity obj) {
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(obj);
    return (_classname + AbstractHelenaTextGenerator.IMPL);
  }
  
  /**
   * Returns the name of the Java File of the SysManager
   */
  public static String getSysManagerClassName(final Model m) {
    PackageDeclaration _headPkg = m.getHeadPkg();
    String pkgName = _headPkg.getName();
    String baseName = "";
    boolean _contains = pkgName.contains(".");
    if (_contains) {
      String[] _split = pkgName.split(".");
      String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(_split)));
      String _firstUpper = StringExtensions.toFirstUpper(_last);
      baseName = _firstUpper;
    } else {
      String _firstUpper_1 = StringExtensions.toFirstUpper(pkgName);
      baseName = _firstUpper_1;
    }
    return (baseName + AbstractHelenaTextGenerator.SYSMANAGER);
  }
  
  /**
   * Returns the name of the Java File of the SysManager Impl File
   */
  public static String getSysManagerImplClassName(final Model m) {
    String _sysManagerClassName = ExtensionMethods_jHelenaGenerator.getSysManagerClassName(m);
    return (_sysManagerClassName + AbstractHelenaTextGenerator.IMPL);
  }
  
  public static String getSysMgrPackageName(final Model model) {
    PackageDeclaration _headPkg = model.getHeadPkg();
    return _headPkg.getName();
  }
  
  public static String getSysMgrFullName(final Model model, final String separator) {
    String _sysMgrPackageName = ExtensionMethods_jHelenaGenerator.getSysMgrPackageName(model);
    String pkgName = _sysMgrPackageName.replace(".", separator);
    String baseName = ExtensionMethods_jHelenaGenerator.getSysManagerClassName(model);
    return ((pkgName + separator) + baseName);
  }
  
  /**
   * Calculates the package String for an AbstractHelenaEntity via the headPackage
   * @return packageName with the package elements separated by a dot
   */
  public static String getPackageName(final AbstractHelenaEntity helenaEntity) {
    EObject entity = helenaEntity.eContainer();
    while ((!(entity instanceof PackageDeclaration))) {
      EObject _eContainer = entity.eContainer();
      entity = _eContainer;
    }
    PackageDeclaration pkg = ((PackageDeclaration) entity);
    String _name = pkg.getName();
    String packageName = _name.toString();
    return packageName;
  }
  
  /**
   * Calculates the package String for a message type via its parent roleType
   * @return packageName with the package elements separated by a dot
   */
  public static String getPackageName(final MessageType msgType) {
    EObject _eContainer = msgType.eContainer();
    RoleType roleType = ((RoleType) _eContainer);
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(roleType);
    String _plus = (_packageName + ".");
    return (_plus + AbstractHelenaTextGenerator.MESSAGES);
  }
  
  /**
   * Calculates the package String for a message type via its parent roleType
   * @return packageName with the package elements separated by a dot
   */
  public static String getPackageName(final OperationType opType) {
    EObject _eContainer = opType.eContainer();
    ComponentType roleType = ((ComponentType) _eContainer);
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(roleType);
    String _plus = (_packageName + ".");
    return (_plus + AbstractHelenaTextGenerator.OPERATIONS);
  }
  
  /**
   * @return Returns a String with the package name of the entity, followed by the capital name of the entity
   * The elements of the returned name are separated with the string passed as parameter separator
   * @param separator char by which the path elements shall be separated
   */
  public static String getFullName(final AbstractHelenaEntity helenaEntity, final String separator) {
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(helenaEntity);
    String packageName = _packageName.replace(".", separator);
    String _name = helenaEntity.getName();
    String entityName = StringExtensions.toFirstUpper(_name);
    return ((packageName + separator) + entityName);
  }
  
  /**
   * @return Returns a String with the package name of the entity, followed by the capital name of the entity
   * The elements of the returned name are separated with the string passed as parameter separator
   * @param separator char by which the path elements shall be separated
   */
  public static String getFullName(final MessageType msgType, final String separator) {
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(msgType);
    String packageName = _packageName.replace(".", separator);
    String entityName = ExtensionMethods_jHelenaGenerator.getClassname(msgType);
    return ((packageName + separator) + entityName);
  }
  
  /**
   * @return Returns a String with the package name of the entity, followed by the capital name of the entity
   * The elements of the returned name are separated with the string passed as parameter separator
   * @param separator char by which the path elements shall be separated
   */
  public static String getFullName(final OperationType opType, final String separator) {
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(opType);
    String packageName = _packageName.replace(".", separator);
    String entityName = ExtensionMethods_jHelenaGenerator.getClassname(opType);
    return ((packageName + separator) + entityName);
  }
  
  /**
   * Returns the name of a declared process (with first letter lowercase)
   * If a process name is "Get" or "Create" this functions appends the processInvocationName
   * If a process name is the same as the processInvocationName the process name roleBehavior is returned
   */
  public static String getProcessFunctionName(final eu.ascens.helenaText.Process proc) {
    RoleBehavior parentRb = ExtensionMethods_RoleBehavior.getParentRoleBehavior(proc);
    String processInvocName = "";
    String processFctName = "";
    if ((parentRb instanceof InvokingRoleBehavior)) {
      InvokingRoleBehavior invokingRb = ((InvokingRoleBehavior) parentRb);
      ProcessInvocation _processInvocation = invokingRb.getProcessInvocation();
      eu.ascens.helenaText.Process _process = _processInvocation.getProcess();
      String _name = _process.getName();
      processInvocName = _name;
    }
    String _name_1 = proc.getName();
    boolean _equals = Objects.equal(_name_1, processInvocName);
    if (_equals) {
      processFctName = AbstractHelenaTextGenerator.ROLEBEHAVIOR_FUNCTION;
    } else {
      if ((Objects.equal(proc.getName(), "Get") || Objects.equal(proc.getName(), "Create"))) {
        String _name_2 = proc.getName();
        String _plus = (_name_2 + processInvocName);
        processFctName = _plus;
      } else {
        String _name_3 = proc.getName();
        processFctName = _name_3;
      }
    }
    return StringExtensions.toFirstLower(processFctName);
  }
  
  public static String getOperationFunctionName(final OperationType op) {
    String _name = op.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return (_firstLower + AbstractHelenaTextGenerator.OPERATION);
  }
}
