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

import com.google.common.collect.Iterables;
import eu.ascens.generator.jHelena.AbstractHelenaTextGenerator;
import eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator;
import eu.ascens.generator.jHelena.GeneratorHelper;
import eu.ascens.generator.jHelena.ImportGenerator;
import eu.ascens.helenaText.AbstractHelenaEntity;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.MsgDirection;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import eu.ascens.helenaText.util.ExtensionMethods_EnsembleStructure;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class SysManagerGenerator extends AbstractHelenaTextGenerator {
  protected SysManagerGenerator(final TypeReferenceSerializer serializer, final ImportManager im, final GeneratorHelper genHelper) {
    super(serializer, im, genHelper);
  }
  
  public CharSequence compile(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t");
    _builder.append("package ");
    String _sysMgrPackageName = ExtensionMethods_jHelenaGenerator.getSysMgrPackageName(it);
    _builder.append(_sysMgrPackageName, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _compileImports = ImportGenerator.compileImports(it, this.im);
    _builder.append(_compileImports, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    Resource _eResource = it.eResource();
    TreeIterator<EObject> _allContents = _eResource.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<EnsembleStructure> _filter = Iterables.<EnsembleStructure>filter(_iterable, EnsembleStructure.class);
    List<EnsembleStructure> allEnsembleStructures = IterableExtensions.<EnsembleStructure>toList(_filter);
    _builder.newLineIfNotEmpty();
    _builder.append("public abstract class ");
    String _sysManagerClassName = ExtensionMethods_jHelenaGenerator.getSysManagerClassName(it);
    _builder.append(_sysManagerClassName, "");
    _builder.append(" extends SysManager {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void configureTypes() throws ConfigurationFinishedException,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TypeAlreadyExistsException, PropertyNotDeclaredInClassException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    {
      Resource _eResource_1 = it.eResource();
      TreeIterator<EObject> _allContents_1 = _eResource_1.getAllContents();
      Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(_allContents_1);
      Iterable<ComponentType> _filter_1 = Iterables.<ComponentType>filter(_iterable_1, ComponentType.class);
      for(final ComponentType ct : _filter_1) {
        _builder.newLine();
        {
          EList<OperationType> _ops = ct.getOps();
          for(final OperationType op : _ops) {
            FormalDataParamsBlock _formalDataParamsBlock = op.getFormalDataParamsBlock();
            EList<FormalDataParam> params = _formalDataParamsBlock.getParams();
            _builder.newLineIfNotEmpty();
            {
              int _size = params.size();
              boolean _greaterThan = (_size > 0);
              if (_greaterThan) {
                _builder.append("List<DataFieldType> ");
                String _dataParamVariableName = this.getDataParamVariableName(op);
                _builder.append(_dataParamVariableName, "");
                _builder.append(" = new ArrayList<>();");
                _builder.newLineIfNotEmpty();
                {
                  for(final FormalDataParam param : params) {
                    String _dataParamVariableName_1 = this.getDataParamVariableName(op);
                    _builder.append(_dataParamVariableName_1, "");
                    _builder.append(".add(");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("DataFieldType.createType(\"");
                    String _name = param.getName();
                    _builder.append(_name, "\t");
                    _builder.append("\", ");
                    JvmTypeReference _type = param.getType();
                    String _wrappedClassAsString = this.genHelper.getWrappedClassAsString(_type);
                    _builder.append(_wrappedClassAsString, "\t");
                    _builder.append("));");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("ComponentType ");
        String _compTypeVariableName = this.getCompTypeVariableName(ct);
        _builder.append(_compTypeVariableName, "\t\t\t\t\t");
        _builder.append(" = ComponentType.createType(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _classname = ExtensionMethods_jHelenaGenerator.getClassname(ct);
        _builder.append(_classname, "\t");
        _builder.append(".class,");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        {
          EList<ComponentAttributeType> _attrs = ct.getAttrs();
          int _length = ((Object[])Conversions.unwrapArray(_attrs, Object.class)).length;
          boolean _equals = (_length == 0);
          if (_equals) {
            _builder.append(" new HashSet<DataFieldType>(),");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("Auxiliaries.getAsSet(");
            _builder.newLine();
            {
              EList<ComponentAttributeType> _attrs_1 = ct.getAttrs();
              boolean _hasElements = false;
              for(final ComponentAttributeType attr : _attrs_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(",", "");
                }
                JvmTypeReference _type_1 = attr.getType();
                String attrClass = this.genHelper.getWrappedClassAsString(_type_1);
                _builder.newLineIfNotEmpty();
                _builder.append("DataFieldType.createType(\"");
                String _name_1 = attr.getName();
                _builder.append(_name_1, "");
                _builder.append("\", ");
                _builder.append(attrClass, "");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("),");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t\t\t\t");
        {
          EList<ComponentAssociationType> _assocs = ct.getAssocs();
          int _length_1 = ((Object[])Conversions.unwrapArray(_assocs, Object.class)).length;
          boolean _equals_1 = (_length_1 == 0);
          if (_equals_1) {
            _builder.append(" new HashSet<ComponentAssociationType>(), ");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("Auxiliaries.getAsSet(");
            _builder.newLine();
            {
              EList<ComponentAssociationType> _assocs_1 = ct.getAssocs();
              boolean _hasElements_1 = false;
              for(final ComponentAssociationType assoc : _assocs_1) {
                if (!_hasElements_1) {
                  _hasElements_1 = true;
                } else {
                  _builder.appendImmediate(",", "");
                }
                _builder.append("ComponentAssociationType.createType(\"");
                String _name_2 = assoc.getName();
                _builder.append(_name_2, "");
                _builder.append("\", ");
                ComponentType _type_2 = assoc.getType();
                String _classname_1 = ExtensionMethods_jHelenaGenerator.getClassname(_type_2);
                _builder.append(_classname_1, "");
                _builder.append(".");
                _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("),");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t\t\t\t\t\t");
        {
          EList<OperationType> _ops_1 = ct.getOps();
          int _length_2 = ((Object[])Conversions.unwrapArray(_ops_1, Object.class)).length;
          boolean _equals_2 = (_length_2 == 0);
          if (_equals_2) {
            _builder.append(" new HashSet<OperationType>()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("Auxiliaries.getAsSet(");
            _builder.newLine();
            {
              EList<OperationType> _ops_2 = ct.getOps();
              boolean _hasElements_2 = false;
              for(final OperationType op_1 : _ops_2) {
                if (!_hasElements_2) {
                  _hasElements_2 = true;
                } else {
                  _builder.appendImmediate(",", "");
                }
                JvmTypeReference _returnType = op_1.getReturnType();
                String retClass = this.genHelper.getWrappedClassAsString(_returnType);
                _builder.newLineIfNotEmpty();
                _builder.append("OperationType.createType(");
                _builder.newLine();
                _builder.append("\t");
                String _classname_2 = ExtensionMethods_jHelenaGenerator.getClassname(op_1);
                _builder.append(_classname_2, "\t");
                _builder.append(".");
                _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
                _builder.append(",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                {
                  FormalDataParamsBlock _formalDataParamsBlock_1 = op_1.getFormalDataParamsBlock();
                  EList<FormalDataParam> _params = _formalDataParamsBlock_1.getParams();
                  int _size_1 = _params.size();
                  boolean _equals_3 = (_size_1 == 0);
                  if (_equals_3) {
                    _builder.append(" new ArrayList<DataFieldType>()");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                  } else {
                    _builder.append(" ");
                    String _dataParamVariableName_2 = this.getDataParamVariableName(op_1);
                    _builder.append(_dataParamVariableName_2, "\t");
                    _builder.append(" ");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                  }
                }
                _builder.append(",");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(retClass, "\t");
                _builder.newLineIfNotEmpty();
                _builder.append(")");
                _builder.newLine();
              }
            }
            _builder.append(")");
            _builder.newLine();
          }
        }
        _builder.append(");");
        _builder.newLine();
        _builder.append("this.addCompType(");
        String _compTypeVariableName_1 = this.getCompTypeVariableName(ct);
        _builder.append(_compTypeVariableName_1, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      for(final EnsembleStructure es : allEnsembleStructures) {
        _builder.append("\t\t");
        _builder.append("this.addEnsembleStructure(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("EnsembleStructure.createType(");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        String _classname_3 = ExtensionMethods_jHelenaGenerator.getClassname(es);
        _builder.append(_classname_3, "\t\t\t\t");
        _builder.append(".class, ");
        String _rolesFctName = SysManagerGenerator.getRolesFctName(es, allEnsembleStructures);
        _builder.append(_rolesFctName, "\t\t\t\t");
        _builder.append("()");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append(")");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append(");");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final EnsembleStructure es_1 : allEnsembleStructures) {
        _builder.append("\t");
        _builder.append("private static Map<RoleType, MultiplicityCapacityPair> ");
        String _rolesFctName_1 = SysManagerGenerator.getRolesFctName(es_1, allEnsembleStructures);
        _builder.append(_rolesFctName_1, "\t");
        _builder.append("() ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throws ConfigurationFinishedException, TypeAlreadyExistsException,");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("PropertyNotDeclaredInClassException {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Map<RoleType, MultiplicityCapacityPair> roles = new HashMap<>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        Iterable<MessageType> msgs = ExtensionMethods_RoleType.getAllMessagesInModel(it);
        _builder.newLineIfNotEmpty();
        {
          for(final MessageType msg : msgs) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("MessageType ");
            String _msgVariableName = this.getMsgVariableName(msg);
            _builder.append(_msgVariableName, "\t\t");
            _builder.append(" = ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("MessageType.createType(");
            String _classname_4 = ExtensionMethods_jHelenaGenerator.getClassname(msg);
            _builder.append(_classname_4, "\t\t\t");
            _builder.append(".");
            _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t\t");
            _builder.append(",");
            _builder.newLineIfNotEmpty();
            {
              FormalRoleParamsBlock _formalRoleParamsBlock = msg.getFormalRoleParamsBlock();
              EList<FormalRoleParam> _params_1 = _formalRoleParamsBlock.getParams();
              int _size_2 = _params_1.size();
              boolean _greaterThan_1 = (_size_2 > 0);
              if (_greaterThan_1) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("Auxiliaries.getAsList(");
                _builder.newLine();
                {
                  FormalRoleParamsBlock _formalRoleParamsBlock_1 = msg.getFormalRoleParamsBlock();
                  EList<FormalRoleParam> _params_2 = _formalRoleParamsBlock_1.getParams();
                  boolean _hasElements_3 = false;
                  for(final FormalRoleParam param_1 : _params_2) {
                    if (!_hasElements_3) {
                      _hasElements_3 = true;
                    } else {
                      _builder.appendImmediate(",", "\t\t\t\t\t");
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("RoleFieldType.createType(\"");
                    String _name_3 = param_1.getName();
                    _builder.append(_name_3, "\t\t\t\t\t");
                    _builder.append("\", ");
                    RoleType _type_3 = param_1.getType();
                    String _classname_5 = ExtensionMethods_jHelenaGenerator.getClassname(_type_3);
                    _builder.append(_classname_5, "\t\t\t\t\t");
                    _builder.append(".");
                    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t\t\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append(")");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("new ArrayList<RoleFieldType>()");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append(",");
            _builder.newLine();
            {
              FormalDataParamsBlock _formalDataParamsBlock_2 = msg.getFormalDataParamsBlock();
              EList<FormalDataParam> _params_3 = _formalDataParamsBlock_2.getParams();
              int _size_3 = _params_3.size();
              boolean _greaterThan_2 = (_size_3 > 0);
              if (_greaterThan_2) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("Auxiliaries.getAsList(");
                _builder.newLine();
                {
                  FormalDataParamsBlock _formalDataParamsBlock_3 = msg.getFormalDataParamsBlock();
                  EList<FormalDataParam> _params_4 = _formalDataParamsBlock_3.getParams();
                  boolean _hasElements_4 = false;
                  for(final FormalDataParam param_2 : _params_4) {
                    if (!_hasElements_4) {
                      _hasElements_4 = true;
                    } else {
                      _builder.appendImmediate(",", "\t\t\t\t\t");
                    }
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("DataFieldType.createType(\"");
                    String _name_4 = param_2.getName();
                    _builder.append(_name_4, "\t\t\t\t\t");
                    _builder.append("\", ");
                    JvmTypeReference _type_4 = param_2.getType();
                    String _wrappedClassAsString_1 = this.genHelper.getWrappedClassAsString(_type_4);
                    _builder.append(_wrappedClassAsString_1, "\t\t\t\t\t");
                    _builder.append(")");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append(")");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("new ArrayList<DataFieldType>()");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("\t");
            _builder.append(");");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        EList<RoleTypeWithMultiplicity> _rtWithMult = es_1.getRtWithMult();
        final Function1<RoleTypeWithMultiplicity, RoleType> _function = new Function1<RoleTypeWithMultiplicity, RoleType>() {
          @Override
          public RoleType apply(final RoleTypeWithMultiplicity rtWithMult) {
            return rtWithMult.getRoleType();
          }
        };
        List<RoleType> roleTypesForCurEns = ListExtensions.<RoleTypeWithMultiplicity, RoleType>map(_rtWithMult, _function);
        _builder.newLineIfNotEmpty();
        {
          for(final RoleType role : roleTypesForCurEns) {
            _builder.append("\t\t");
            String _name_5 = role.getName();
            final String role_name = StringExtensions.toFirstLower(_name_5);
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("// ");
            _builder.append(role_name, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("Set<ComponentType> ");
            String _compTypesVariableName = this.getCompTypesVariableName(role);
            _builder.append(_compTypesVariableName, "\t\t");
            _builder.append(" = Auxiliaries.getAsSet(");
            _builder.newLineIfNotEmpty();
            {
              EList<ComponentType> _compTypes = role.getCompTypes();
              boolean _hasElements_5 = false;
              for(final ComponentType ct_1 : _compTypes) {
                if (!_hasElements_5) {
                  _hasElements_5 = true;
                } else {
                  _builder.appendImmediate(",", "\t\t\t\t");
                }
                _builder.append("\t\t\t\t");
                _builder.append("ComponentType.getType(");
                String _classname_6 = ExtensionMethods_jHelenaGenerator.getClassname(ct_1);
                _builder.append(_classname_6, "\t\t\t\t");
                _builder.append(".class)");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append(");");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("Set<DataFieldType> ");
            String _attrTypesVariableName = this.getAttrTypesVariableName(role);
            _builder.append(_attrTypesVariableName, "\t\t\t\t\t\t\t");
            _builder.append(" = new HashSet<>();");
            _builder.newLineIfNotEmpty();
            {
              EList<RoleAttributeType> _roleattrs = role.getRoleattrs();
              for(final RoleAttributeType roleAttr : _roleattrs) {
                _builder.append("\t\t\t");
                String _attrTypesVariableName_1 = this.getAttrTypesVariableName(role);
                _builder.append(_attrTypesVariableName_1, "\t\t\t");
                _builder.append(".add(");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append("\t");
                _builder.append("DataFieldType.createType(\"");
                String _name_6 = roleAttr.getName();
                _builder.append(_name_6, "\t\t\t\t");
                _builder.append("\", ");
                JvmTypeReference _type_5 = roleAttr.getType();
                String _wrappedClassAsString_2 = this.genHelper.getWrappedClassAsString(_type_5);
                _builder.append(_wrappedClassAsString_2, "\t\t\t\t");
                _builder.append(")");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t");
                _builder.append(");");
                _builder.newLine();
              }
            }
            _builder.append("\t\t\t");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("Set<MessageType> ");
            String _msgsOutVariableName = this.getMsgsOutVariableName(role);
            _builder.append(_msgsOutVariableName, "\t\t\t\t\t\t\t");
            _builder.append(" = Auxiliaries.getAsSet(");
            _builder.newLineIfNotEmpty();
            {
              Iterable<MessageType> _allMessagesOfDirection = ExtensionMethods_RoleType.getAllMessagesOfDirection(role, MsgDirection.OUT);
              boolean _hasElements_6 = false;
              for(final MessageType msg_1 : _allMessagesOfDirection) {
                if (!_hasElements_6) {
                  _hasElements_6 = true;
                } else {
                  _builder.appendImmediate(",", "\t\t\t");
                }
                _builder.append("\t\t\t");
                String _msgVariableName_1 = this.getMsgVariableName(msg_1);
                _builder.append(_msgVariableName_1, "\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append(");");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.newLine();
            _builder.append("\t\t\t\t\t\t\t");
            _builder.append("Set<MessageType> ");
            String _msgsInVariableName = this.getMsgsInVariableName(role);
            _builder.append(_msgsInVariableName, "\t\t\t\t\t\t\t");
            _builder.append(" = Auxiliaries.getAsSet(");
            _builder.newLineIfNotEmpty();
            {
              Iterable<MessageType> _allMessagesOfDirection_1 = ExtensionMethods_RoleType.getAllMessagesOfDirection(role, MsgDirection.IN);
              boolean _hasElements_7 = false;
              for(final MessageType msg_2 : _allMessagesOfDirection_1) {
                if (!_hasElements_7) {
                  _hasElements_7 = true;
                } else {
                  _builder.appendImmediate(",", "\t\t\t");
                }
                _builder.append("\t\t\t");
                String _msgVariableName_2 = this.getMsgVariableName(msg_2);
                _builder.append(_msgVariableName_2, "\t\t\t");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t\t");
            _builder.append(");");
            _builder.newLine();
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("roles.put(");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("RoleType.createType(");
            _builder.newLine();
            _builder.append("\t\t\t\t\t");
            String _classname_7 = ExtensionMethods_jHelenaGenerator.getClassname(role);
            _builder.append(_classname_7, "\t\t\t\t\t");
            _builder.append(".");
            _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t\t\t\t");
            _builder.append(", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            String _compTypesVariableName_1 = this.getCompTypesVariableName(role);
            _builder.append(_compTypesVariableName_1, "\t\t\t\t\t");
            _builder.append(",");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            String _attrTypesVariableName_2 = this.getAttrTypesVariableName(role);
            _builder.append(_attrTypesVariableName_2, "\t\t\t\t\t");
            _builder.append(", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            String _msgsOutVariableName_1 = this.getMsgsOutVariableName(role);
            _builder.append(_msgsOutVariableName_1, "\t\t\t\t\t");
            _builder.append(", ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t\t");
            String _msgsInVariableName_1 = this.getMsgsInVariableName(role);
            _builder.append(_msgsInVariableName_1, "\t\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t");
            _builder.append("), ");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("new MultiplicityCapacityPair(");
            String _maxMultiplicityForRoleType = ExtensionMethods_EnsembleStructure.getMaxMultiplicityForRoleType(es_1, role);
            _builder.append(_maxMultiplicityForRoleType, "\t\t\t\t");
            _builder.append(", ");
            Integer _capacityForRoleType = ExtensionMethods_EnsembleStructure.getCapacityForRoleType(es_1, role);
            _builder.append(_capacityForRoleType, "\t\t\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append(");");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return roles;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}\t");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public String compileImpl(final Model it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("package ");
    String _sysMgrPackageName = ExtensionMethods_jHelenaGenerator.getSysMgrPackageName(it);
    _builder.append(_sysMgrPackageName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    String _compileImplImports = ImportGenerator.compileImplImports(it, this.im);
    _builder.append(_compileImplImports, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _sysManagerImplClassName = ExtensionMethods_jHelenaGenerator.getSysManagerImplClassName(it);
    _builder.append(_sysManagerImplClassName, "");
    _builder.append(" extends ");
    String _sysManagerClassName = ExtensionMethods_jHelenaGenerator.getSysManagerClassName(it);
    _builder.append(_sysManagerClassName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public ");
    String _sysManagerImplClassName_1 = ExtensionMethods_jHelenaGenerator.getSysManagerImplClassName(it);
    _builder.append(_sysManagerImplClassName_1, "\t");
    _builder.append("(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("SysManager sys = new ");
    String _sysManagerImplClassName_2 = ExtensionMethods_jHelenaGenerator.getSysManagerImplClassName(it);
    _builder.append(_sysManagerImplClassName_2, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("sys.start();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void createComponents() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//");
    _builder.append(this.METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("throw new UnsupportedOperationException(\"");
    _builder.append(this.METHOD_NOT_IMPLEMENTED, "\t\t");
    _builder.append(": ");
    _builder.append(this.USER_INPUT_REQUIRED, "\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void startEnsembles() ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throws RoleTypeNotAllowedForEnsembleException,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("RoleTypeNotAllowedForComponentTypeException,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ComponentNotInEnsembleException, ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ComponentAlreadyAdoptsRoleException, ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("TooManyRoleInstancesException,");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ReflectionException, PropertyNotDeclaredInClassException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//");
    _builder.append(this.METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("throw new UnsupportedOperationException(\"");
    _builder.append(this.METHOD_NOT_IMPLEMENTED, "\t\t");
    _builder.append(": ");
    _builder.append(this.USER_INPUT_REQUIRED, "\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String getCompTypeVariableName(final ComponentType ct) {
    return this.getVarName(ct, "Type");
  }
  
  private String getDataParamVariableName(final OperationType op) {
    String _name = op.getName();
    String _plus = ("dataparams_" + _name);
    return (_plus + "Operation");
  }
  
  private String getAttrTypesVariableName(final RoleType rt) {
    return this.getVarName(rt, "AttrTypes");
  }
  
  private String getCompTypesVariableName(final RoleType rt) {
    return this.getVarName(rt, "CompTypes");
  }
  
  private String getMsgVariableName(final MessageType msg) {
    String _name = msg.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return (_firstLower + "Msg");
  }
  
  private String getMsgsOutVariableName(final RoleType rt) {
    return this.getVarName(rt, "MsgsOut");
  }
  
  private String getMsgsInVariableName(final RoleType rt) {
    return this.getVarName(rt, "MsgsIn");
  }
  
  private String getVarName(final AbstractHelenaEntity entitiy, final String addon) {
    String _name = entitiy.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return (_firstLower + addon);
  }
  
  /**
   * Calculates the name of the getRoles Function
   * @return If one ensemble structure exists: "getRoles"
   * @return if more than one ensemble structure exist: get«ensStruct.name»Roles
   */
  private static String getRolesFctName(final EnsembleStructure es, final Iterable<EnsembleStructure> ensStructs) {
    int _size = IterableExtensions.size(ensStructs);
    boolean _equals = (_size == 1);
    if (_equals) {
      return "getRoles";
    } else {
      String _name = es.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      String _plus = ("get" + _firstUpper);
      return (_plus + "Roles");
    }
  }
}
