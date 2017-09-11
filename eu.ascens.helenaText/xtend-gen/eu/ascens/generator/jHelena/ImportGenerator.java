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
import com.google.common.collect.Iterables;
import eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator;
import eu.ascens.helenaText.AbstractMessageCall;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_Action;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class ImportGenerator {
  public final static String HELENA_PATH = "eu.ascens.helena";
  
  public static String compileImports(final ComponentType ct, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Component;");
    _builder.newLineIfNotEmpty();
    final String HELENA_IMPORTS = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.logging.Logger;");
    _builder_1.newLine();
    final String JAVA_IMPORTS = _builder_1.toString();
    final String DECLARED_IMPORTS = ImportGenerator.getDeclaredImports(im);
    return ((HELENA_IMPORTS + JAVA_IMPORTS) + DECLARED_IMPORTS);
  }
  
  public static String compileImports(final EnsembleStructure ens, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Component;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Ensemble;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ComponentAlreadyAdoptsRoleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ComponentNotInEnsembleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.PropertyNotDeclaredInClassException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ReflectionException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.RoleTypeNotAllowedForComponentTypeException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.RoleTypeNotAllowedForEnsembleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.TooManyRoleInstancesException;");
    _builder.newLineIfNotEmpty();
    final String HELENA_IMPORTS = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Set;");
    final String JAVA_IMPORTS = _builder_1.toString();
    return (JAVA_IMPORTS + HELENA_IMPORTS);
  }
  
  public static String compileImports(final MessageType msgType, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Auxiliaries;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Message;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Role;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Variable;");
    _builder.newLineIfNotEmpty();
    final String HELENA_IMPORTS = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    final String JAVA_IMPORTS = _builder_1.toString();
    final String DECLARED_IMPORTS = ImportGenerator.getDeclaredImports(im);
    final String DYNAMIC_IMPORTS = ImportGenerator.getDynamicImports(msgType, im);
    return (((JAVA_IMPORTS + HELENA_IMPORTS) + DECLARED_IMPORTS) + DYNAMIC_IMPORTS);
  }
  
  public static String compileImports(final OperationType opType, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Operation;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Variable;");
    _builder.newLineIfNotEmpty();
    final String HELENA_IMPORTS = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Arrays;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    final String JAVA_IMPORTS = _builder_1.toString();
    final String DECLARED_IMPORTS = ImportGenerator.getDeclaredImports(im);
    return ((JAVA_IMPORTS + HELENA_IMPORTS) + DECLARED_IMPORTS);
  }
  
  /**
   * Compile imports from model for SysManager classes
   */
  public static String compileImports(final Model model, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".SysManager;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.ComponentAssociationType;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.ComponentType;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.DataFieldType;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.EnsembleStructure;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.MessageType;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.MultiplicityCapacityPair;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.OperationType;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.RoleFieldType;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".metadata.RoleType;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Auxiliaries;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ConfigurationFinishedException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ComponentNotInEnsembleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.PropertyNotDeclaredInClassException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.TypeAlreadyExistsException;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final String HELENA_IMPORTS = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.HashMap;");
    _builder_1.newLine();
    _builder_1.append("import java.util.HashSet;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Map;");
    _builder_1.newLine();
    _builder_1.append("import java.util.Set;");
    _builder_1.newLine();
    final String JAVA_IMPORTS = _builder_1.toString();
    final String DECLARED_IMPORTS = ImportGenerator.getDeclaredImports(im);
    final String DYNAMIC_IMPORTS = ImportGenerator.getDynamicImports(model, im);
    return (((JAVA_IMPORTS + HELENA_IMPORTS) + DECLARED_IMPORTS) + DYNAMIC_IMPORTS);
  }
  
  public static String compileImports(final RoleType rt, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.ActionPrefix;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.AndGuard;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Atom;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.CreateRoleAction;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Component;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.CompAssociationGetter;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.CompAttrGetter;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.CompAttrSetterAction;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.ComposedExpression;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.ComposedExpression.ExpressionOperator;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.GetRoleAction;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.IfThenElse;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Ensemble;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.NondeterministicChoice;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.NotGuard;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.OperationCallAction;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.OrGuard;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.PlaysQuery;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.ProcessInvocation;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.ProcessExpression;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Quit;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.ReceiveMessageAction;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Role;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.RoleAttrGetter;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.RoleAttrSetterAction;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.SendMessageAction;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Variable;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.PropertyNotDeclaredInClassException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ReflectionException;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    final String HELENA_IMPORTS = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    final String JAVA_IMPORTS = _builder_1.toString();
    final String DECLARED_IMPORTS = ImportGenerator.getDeclaredImports(im);
    final String DYNAMIC_IMPORTS = ImportGenerator.getDynamicImports(rt, im);
    return (((JAVA_IMPORTS + HELENA_IMPORTS) + DECLARED_IMPORTS) + DYNAMIC_IMPORTS);
  }
  
  public static String compileImplImports(final ComponentType ct, final ImportManager im) {
    final String DECLARED_IMPORTS = ImportGenerator.getDeclaredImports(im);
    return DECLARED_IMPORTS;
  }
  
  public static String compileImplImports(final EnsembleStructure ens, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Component;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ComponentAlreadyAdoptsRoleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ComponentNotInEnsembleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.PropertyNotDeclaredInClassException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ReflectionException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.RoleTypeNotAllowedForComponentTypeException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.RoleTypeNotAllowedForEnsembleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.TooManyRoleInstancesException;");
    _builder.newLineIfNotEmpty();
    final String HELENA_IMPORTS = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.Set;");
    final String JAVA_IMPORTS = _builder_1.toString();
    return (JAVA_IMPORTS + HELENA_IMPORTS);
  }
  
  public static String compileImplImports(final Model model, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".SysManager;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ComponentAlreadyAdoptsRoleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ComponentNotInEnsembleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.PropertyNotDeclaredInClassException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.ReflectionException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.RoleTypeNotAllowedForComponentTypeException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.RoleTypeNotAllowedForEnsembleException;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.exceptions.TooManyRoleInstancesException;");
    _builder.newLineIfNotEmpty();
    final String HELENA_IMPORTS = _builder.toString();
    return HELENA_IMPORTS;
  }
  
  public static String compileImplImports(final RoleType rt, final ImportManager im) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(ImportGenerator.HELENA_PATH, "");
    _builder.append(".dev.Ensemble;");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private static String getDynamicImports(final MessageType msgType, final ImportManager im) {
    List<String> dynamic_imports = new ArrayList<String>();
    FormalRoleParamsBlock _formalRoleParamsBlock = msgType.getFormalRoleParamsBlock();
    EList<FormalRoleParam> _params = _formalRoleParamsBlock.getParams();
    for (final FormalRoleParam p : _params) {
      {
        RoleType _type = p.getType();
        String type = ExtensionMethods_jHelenaGenerator.getFullName(_type, ".");
        String _importString = ImportGenerator.getImportString(type);
        dynamic_imports.add(_importString);
      }
    }
    return IterableExtensions.join(dynamic_imports, "\n");
  }
  
  /**
   * Compile imports from model for SysManager classes
   */
  private static String getDynamicImports(final Model model, final ImportManager im) {
    Set<String> dynamic_imports = new TreeSet<String>();
    Resource _eResource = model.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<RoleType> _filter = Iterables.<RoleType>filter(_iterable, RoleType.class);
    for (final RoleType rt : _filter) {
      EList<MessageType> _rolemsgs = rt.getRolemsgs();
      for (final MessageType msg : _rolemsgs) {
        {
          String fullName = ExtensionMethods_jHelenaGenerator.getFullName(msg, ".");
          String importStr = ImportGenerator.getImportString(fullName);
          dynamic_imports.add(importStr);
        }
      }
    }
    Resource _eResource_1 = model.eResource();
    TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
    Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(_allContents_1);
    Iterable<ComponentType> _filter_1 = Iterables.<ComponentType>filter(_iterable_1, ComponentType.class);
    for (final ComponentType ct : _filter_1) {
      EList<OperationType> _ops = ct.getOps();
      for (final OperationType op : _ops) {
        {
          String fullName = ExtensionMethods_jHelenaGenerator.getFullName(op, ".");
          String importStr = ImportGenerator.getImportString(fullName);
          dynamic_imports.add(importStr);
        }
      }
    }
    return IterableExtensions.join(dynamic_imports, "\n");
  }
  
  private static String getDynamicImports(final RoleType rt, final ImportManager im) {
    Set<String> dynamic_imports = new HashSet<String>();
    String importString = "";
    RoleBehavior rb = ExtensionMethods_RoleType.getRoleBehavior(rt);
    boolean _equals = Objects.equal(rb, null);
    if (_equals) {
      return "";
    }
    Collection<AbstractMessageCall> msgs = ExtensionMethods_RoleBehavior.getAbstractMessageCalls(rb);
    for (final AbstractMessageCall msg : msgs) {
      {
        MessageType msgType = ExtensionMethods_Action.getMessageType(msg);
        boolean _equals_1 = Objects.equal(msgType, null);
        if (_equals_1) {
          return "";
        }
        String _fullName = ExtensionMethods_jHelenaGenerator.getFullName(msgType, ".");
        String _importString = ImportGenerator.getImportString(_fullName);
        importString = _importString;
        dynamic_imports.add(importString);
      }
    }
    RoleBehavior _roleBehavior = ExtensionMethods_RoleType.getRoleBehavior(rt);
    Collection<OperationCall> ops = ExtensionMethods_RoleBehavior.getOperationCalls(_roleBehavior);
    for (final OperationCall op : ops) {
      {
        OperationType opType = ExtensionMethods_Action.getOperationType(op);
        boolean _equals_1 = Objects.equal(opType, null);
        if (_equals_1) {
          return "";
        }
        String _fullName = ExtensionMethods_jHelenaGenerator.getFullName(opType, ".");
        String _importString = ImportGenerator.getImportString(_fullName);
        importString = _importString;
        dynamic_imports.add(importString);
      }
    }
    return IterableExtensions.join(dynamic_imports, "\n");
  }
  
  /**
   * @return String with imports: declared imports from .helena file
   */
  private static String getDeclaredImports(final ImportManager im) {
    String imports = "";
    List<String> _imports = im.getImports();
    for (final String i : _imports) {
      String _importString = ImportGenerator.getImportString(i);
      String _plus = (imports + _importString);
      imports = _plus;
    }
    return imports;
  }
  
  private static String getImportString(final String className) {
    return (("import " + className) + ";");
  }
}
