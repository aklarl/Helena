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
package eu.ascens.generator.promela;

import com.google.common.base.Objects;
import eu.ascens.generator.promela.NameGenerator;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import eu.ascens.helenaText.util.ExtensionMethods_EnsembleStructure;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_Model;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ComponentTypeGenerator {
  /**
   * Compiles a user defined type declaration for every operation which can be called on a component type
   * - attribute getters
   * - association getters
   * - role creators, getters, and isPlaying-queries
   */
  public static CharSequence compileOperations(final ComponentType ct, final EnsembleStructure es) {
    CharSequence _xblockexpression = null;
    {
      EList<RoleTypeWithMultiplicity> _rtWithMult = es.getRtWithMult();
      final Function1<RoleTypeWithMultiplicity, RoleType> _function = new Function1<RoleTypeWithMultiplicity, RoleType>() {
        @Override
        public RoleType apply(final RoleTypeWithMultiplicity it) {
          return it.getRoleType();
        }
      };
      List<RoleType> _map = ListExtensions.<RoleTypeWithMultiplicity, RoleType>map(_rtWithMult, _function);
      final Function1<RoleType, Boolean> _function_1 = new Function1<RoleType, Boolean>() {
        @Override
        public Boolean apply(final RoleType it) {
          EList<ComponentType> _compTypes = it.getCompTypes();
          return Boolean.valueOf(_compTypes.contains(ct));
        }
      };
      Iterable<RoleType> roleTypesAdoptableByCT = IterableExtensions.<RoleType>filter(_map, _function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("///////////// component operation definitions //////////////////////");
      _builder.newLine();
      _builder.append("typedef ");
      String _name = ct.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      _builder.append(_firstUpper, "");
      _builder.append("Operation {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("mtype {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// operations to access attributes of component");
      _builder.newLine();
      _builder.append("\t\t");
      {
        EList<ComponentAttributeType> _attrs = ct.getAttrs();
        boolean _hasElements = false;
        for(final ComponentAttributeType attr : _attrs) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "\t\t");
          }
          String _getterCompOperationName = NameGenerator.getGetterCompOperationName(attr);
          _builder.append(_getterCompOperationName, "\t\t");
          _builder.append(", ");
          String _setterCompOperationName = NameGenerator.getSetterCompOperationName(attr);
          _builder.append(_setterCompOperationName, "\t\t");
        }
        if (_hasElements) {
          _builder.append(", ", "\t\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// operations to access associations to other components");
      _builder.newLine();
      _builder.append("\t\t");
      {
        EList<ComponentAssociationType> _assocs = ct.getAssocs();
        boolean _hasElements_1 = false;
        for(final ComponentAssociationType assoc : _assocs) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(", ", "\t\t");
          }
          String _getterCompOperationName_1 = NameGenerator.getGetterCompOperationName(assoc);
          _builder.append(_getterCompOperationName_1, "\t\t");
        }
        if (_hasElements_1) {
          _builder.append(", ", "\t\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// operations");
      _builder.newLine();
      _builder.append("\t\t");
      {
        EList<OperationType> _ops = ct.getOps();
        boolean _hasElements_2 = false;
        for(final OperationType op : _ops) {
          if (!_hasElements_2) {
            _hasElements_2 = true;
          } else {
            _builder.appendImmediate(", ", "\t\t");
          }
          String _operationCompOperationName = NameGenerator.getOperationCompOperationName(op);
          _builder.append(_operationCompOperationName, "\t\t");
        }
        if (_hasElements_2) {
          _builder.append(", ", "\t\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// operations to manage role playing");
      _builder.newLine();
      {
        boolean _hasElements_3 = false;
        for(final RoleType rt : roleTypesAdoptableByCT) {
          if (!_hasElements_3) {
            _hasElements_3 = true;
          } else {
            _builder.appendImmediate(", ", "\t\t");
          }
          _builder.append("\t\t");
          String _compOperationNameForCreate = NameGenerator.getCompOperationNameForCreate(rt);
          _builder.append(_compOperationNameForCreate, "\t\t");
          _builder.append(", ");
          String _compOperationNameForGet = NameGenerator.getCompOperationNameForGet(rt);
          _builder.append(_compOperationNameForGet, "\t\t");
          _builder.append(", ");
          String _compOperationNameForQuit = NameGenerator.getCompOperationNameForQuit(rt);
          _builder.append(_compOperationNameForQuit, "\t\t");
          _builder.append(", ");
          String _compOperationNameForPlays = NameGenerator.getCompOperationNameForPlays(rt);
          _builder.append(_compOperationNameForPlays, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("mtype optype;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("chan parameters;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("chan answer;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Compiles a process type for a given component which allows to receive operation
   * calls to this components. Operation calls are attributes getters, association getters,
   * and role creators, getters, and isPlaying-queries
   */
  public static CharSequence compileProctype(final ComponentType ct, final EnsembleStructure es, final Model model) {
    CharSequence _xblockexpression = null;
    {
      EList<RoleTypeWithMultiplicity> _rtWithMult = es.getRtWithMult();
      final Function1<RoleTypeWithMultiplicity, RoleType> _function = new Function1<RoleTypeWithMultiplicity, RoleType>() {
        @Override
        public RoleType apply(final RoleTypeWithMultiplicity it) {
          return it.getRoleType();
        }
      };
      List<RoleType> _map = ListExtensions.<RoleTypeWithMultiplicity, RoleType>map(_rtWithMult, _function);
      final Function1<RoleType, Boolean> _function_1 = new Function1<RoleType, Boolean>() {
        @Override
        public Boolean apply(final RoleType it) {
          EList<ComponentType> _compTypes = it.getCompTypes();
          return Boolean.valueOf(_compTypes.contains(ct));
        }
      };
      Iterable<RoleType> roleTypesAdoptableByCT = IterableExtensions.<RoleType>filter(_map, _function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("////////////// process definition of component type ");
      String _proctypeName = NameGenerator.getProctypeName(ct);
      _builder.append(_proctypeName, "");
      _builder.append(" /////////////");
      _builder.newLineIfNotEmpty();
      _builder.append("proctype ");
      String _proctypeName_1 = NameGenerator.getProctypeName(ct);
      _builder.append(_proctypeName_1, "");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      {
        EList<ComponentAttributeType> _attrs = ct.getAttrs();
        boolean _hasElements = false;
        for(final ComponentAttributeType attr : _attrs) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("; ", "\t\t");
          }
          JvmTypeReference _type = attr.getType();
          String _promelaType = NameGenerator.getPromelaType(_type);
          _builder.append(_promelaType, "\t\t");
          _builder.append(" ");
          String _compProctypeParamName = NameGenerator.getCompProctypeParamName(attr);
          _builder.append(_compProctypeParamName, "\t\t");
        }
        if (_hasElements) {
          _builder.append("; ", "\t\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      {
        EList<ComponentAssociationType> _assocs = ct.getAssocs();
        boolean _hasElements_1 = false;
        for(final ComponentAssociationType assoc : _assocs) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate("; ", "\t\t");
          }
          _builder.append("chan ");
          String _compProctypeParamName_1 = NameGenerator.getCompProctypeParamName(assoc);
          _builder.append(_compProctypeParamName_1, "\t\t");
        }
        if (_hasElements_1) {
          _builder.append("; ", "\t\t");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("chan self) {");
      _builder.newLine();
      _builder.newLine();
      {
        for(final RoleType rt : roleTypesAdoptableByCT) {
          _builder.append("\t");
          _builder.append("bool ");
          String _variableNameForPlays = NameGenerator.getVariableNameForPlays(rt);
          _builder.append(_variableNameForPlays, "\t");
          _builder.append(" = false;");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("chan ");
          String _chanName = NameGenerator.getChanName(rt);
          _builder.append(_chanName, "\t");
          _builder.append(" = [");
          Integer _capacityForRoleType = ExtensionMethods_EnsembleStructure.getCapacityForRoleType(es, rt);
          _builder.append(_capacityForRoleType, "\t");
          _builder.append("] of { mtype");
          {
            int _maxNumberOfRoleParamsInModel = ExtensionMethods_Model.maxNumberOfRoleParamsInModel(model);
            ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _maxNumberOfRoleParamsInModel, true);
            boolean _hasElements_2 = false;
            for(final Integer i : _doubleDotLessThan) {
              if (!_hasElements_2) {
                _hasElements_2 = true;
                _builder.append(",", "\t");
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("chan");
            }
          }
          {
            int _maxNumberOfDataParamsInModel = ExtensionMethods_Model.maxNumberOfDataParamsInModel(model);
            ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _maxNumberOfDataParamsInModel, true);
            boolean _hasElements_3 = false;
            for(final Integer i_1 : _doubleDotLessThan_1) {
              if (!_hasElements_3) {
                _hasElements_3 = true;
                _builder.append(",", "\t");
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("int");
            }
          }
          _builder.append(" };");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      String _startLabelName = NameGenerator.getStartLabelName(ct);
      _builder.append(_startLabelName, "\t");
      _builder.append(": true;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      String _operationTypeName = NameGenerator.getOperationTypeName(ct);
      _builder.append(_operationTypeName, "\t");
      _builder.append(" op;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("do");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("::atomic { ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("self?op ->");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if");
      _builder.newLine();
      {
        EList<ComponentAttributeType> _attrs_1 = ct.getAttrs();
        for(final ComponentAttributeType attr_1 : _attrs_1) {
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _getterCompOperationName = NameGenerator.getGetterCompOperationName(attr_1);
          _builder.append(_getterCompOperationName, "\t\t");
          _builder.append(" -> op.answer!");
          String _compProctypeParamName_2 = NameGenerator.getCompProctypeParamName(attr_1);
          _builder.append(_compProctypeParamName_2, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _setterCompOperationName = NameGenerator.getSetterCompOperationName(attr_1);
          _builder.append(_setterCompOperationName, "\t\t");
          _builder.append(" -> op.parameters?");
          String _compProctypeParamName_3 = NameGenerator.getCompProctypeParamName(attr_1);
          _builder.append(_compProctypeParamName_3, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      {
        EList<ComponentAssociationType> _assocs_1 = ct.getAssocs();
        for(final ComponentAssociationType assoc_1 : _assocs_1) {
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _getterCompOperationName_1 = NameGenerator.getGetterCompOperationName(assoc_1);
          _builder.append(_getterCompOperationName_1, "\t\t");
          _builder.append(" -> op.answer!");
          String _compProctypeParamName_4 = NameGenerator.getCompProctypeParamName(assoc_1);
          _builder.append(_compProctypeParamName_4, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      {
        EList<OperationType> _ops = ct.getOps();
        for(final OperationType op : _ops) {
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _operationCompOperationName = NameGenerator.getOperationCompOperationName(op);
          _builder.append(_operationCompOperationName, "\t\t");
          _builder.append(" -> ");
          _builder.newLineIfNotEmpty();
          {
            FormalDataParamsBlock _formalDataParamsBlock = op.getFormalDataParamsBlock();
            EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
            boolean _isEmpty = _params.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              _builder.append("\t\t");
              _builder.append("\t");
              {
                FormalDataParamsBlock _formalDataParamsBlock_1 = op.getFormalDataParamsBlock();
                EList<FormalDataParam> _params_1 = _formalDataParamsBlock_1.getParams();
                boolean _hasElements_4 = false;
                for(final FormalDataParam param : _params_1) {
                  if (!_hasElements_4) {
                    _hasElements_4 = true;
                  } else {
                    _builder.appendImmediate("\n", "\t\t\t");
                  }
                  JvmTypeReference _type_1 = param.getType();
                  String _promelaType_1 = NameGenerator.getPromelaType(_type_1);
                  _builder.append(_promelaType_1, "\t\t\t");
                  _builder.append(" ");
                  String _varName = NameGenerator.getVarName(param);
                  _builder.append(_varName, "\t\t\t");
                  _builder.append(";");
                }
              }
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("op.parameters?");
              {
                FormalDataParamsBlock _formalDataParamsBlock_2 = op.getFormalDataParamsBlock();
                EList<FormalDataParam> _params_2 = _formalDataParamsBlock_2.getParams();
                boolean _hasElements_5 = false;
                for(final FormalDataParam param_1 : _params_2) {
                  if (!_hasElements_5) {
                    _hasElements_5 = true;
                  } else {
                    _builder.appendImmediate(",", "\t\t\t");
                  }
                  String _varName_1 = NameGenerator.getVarName(param_1);
                  _builder.append(_varName_1, "\t\t\t");
                }
              }
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("// add intended behavior of this operation");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          {
            JvmTypeReference _returnType = op.getReturnType();
            JvmType _type_2 = _returnType.getType();
            String _simpleName = _type_2.getSimpleName();
            boolean _notEquals = (!Objects.equal(_simpleName, "void"));
            if (_notEquals) {
              _builder.append("op.answer!1;");
            }
          }
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.newLine();
      {
        for(final RoleType rt_1 : roleTypesAdoptableByCT) {
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _compOperationNameForCreate = NameGenerator.getCompOperationNameForCreate(rt_1);
          _builder.append(_compOperationNameForCreate, "\t\t");
          _builder.append(" ->");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("if");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("::!");
          String _variableNameForPlays_1 = NameGenerator.getVariableNameForPlays(rt_1);
          _builder.append(_variableNameForPlays_1, "\t\t\t");
          _builder.append(" && ");
          String _currentName = NameGenerator.getCurrentName(rt_1);
          _builder.append(_currentName, "\t\t\t");
          _builder.append(" < ");
          String _maxName = NameGenerator.getMaxName(rt_1);
          _builder.append(_maxName, "\t\t\t");
          _builder.append(" ->");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("run ");
          String _proctypeName_2 = NameGenerator.getProctypeName(rt_1);
          _builder.append(_proctypeName_2, "\t\t\t\t");
          _builder.append("(self, ");
          String _chanName_1 = NameGenerator.getChanName(rt_1);
          _builder.append(_chanName_1, "\t\t\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          String _variableNameForPlays_2 = NameGenerator.getVariableNameForPlays(rt_1);
          _builder.append(_variableNameForPlays_2, "\t\t\t\t");
          _builder.append(" = true;");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          String _currentName_1 = NameGenerator.getCurrentName(rt_1);
          _builder.append(_currentName_1, "\t\t\t\t");
          _builder.append("++;");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("op.answer!");
          String _chanName_2 = NameGenerator.getChanName(rt_1);
          _builder.append(_chanName_2, "\t\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("fi");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _compOperationNameForGet = NameGenerator.getCompOperationNameForGet(rt_1);
          _builder.append(_compOperationNameForGet, "\t\t");
          _builder.append(" ->");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("if");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("::");
          String _variableNameForPlays_3 = NameGenerator.getVariableNameForPlays(rt_1);
          _builder.append(_variableNameForPlays_3, "\t\t\t");
          _builder.append(" ->");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          _builder.append("op.answer!");
          String _chanName_3 = NameGenerator.getChanName(rt_1);
          _builder.append(_chanName_3, "\t\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("fi");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _compOperationNameForQuit = NameGenerator.getCompOperationNameForQuit(rt_1);
          _builder.append(_compOperationNameForQuit, "\t\t");
          _builder.append(" ->");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("if");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("::");
          String _variableNameForPlays_4 = NameGenerator.getVariableNameForPlays(rt_1);
          _builder.append(_variableNameForPlays_4, "\t\t\t");
          _builder.append(" && ");
          String _currentName_2 = NameGenerator.getCurrentName(rt_1);
          _builder.append(_currentName_2, "\t\t\t");
          _builder.append(" > ");
          String _minName = NameGenerator.getMinName(rt_1);
          _builder.append(_minName, "\t\t\t");
          _builder.append(" ->");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          String _variableNameForPlays_5 = NameGenerator.getVariableNameForPlays(rt_1);
          _builder.append(_variableNameForPlays_5, "\t\t\t\t");
          _builder.append(" = false;");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t\t");
          String _currentName_3 = NameGenerator.getCurrentName(rt_1);
          _builder.append(_currentName_3, "\t\t\t\t");
          _builder.append("--");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("fi");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("::op.optype == ");
          String _compOperationNameForPlays = NameGenerator.getCompOperationNameForPlays(rt_1);
          _builder.append(_compOperationNameForPlays, "\t\t");
          _builder.append(" ->");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("\t");
          _builder.append("op.answer!");
          String _variableNameForPlays_6 = NameGenerator.getVariableNameForPlays(rt_1);
          _builder.append(_variableNameForPlays_6, "\t\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append("fi");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("od");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Compiles helpers to call operations on the component
   */
  public static CharSequence compileOperationCallHelpers(final ComponentType ct) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//////// helpers for communication between roles and ");
    String _proctypeName = NameGenerator.getProctypeName(ct);
    _builder.append(_proctypeName, "");
    _builder.append(" components /////////");
    _builder.newLineIfNotEmpty();
    _builder.append("inline ");
    String _retrieveRole = NameGenerator.getRetrieveRole(ct);
    _builder.append(_retrieveRole, "");
    _builder.append("(rtOperation,component,role) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _operationTypeName = NameGenerator.getOperationTypeName(ct);
    _builder.append(_operationTypeName, "\t");
    _builder.append(" op;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("op.optype = rtOperation;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("chan answer = [0] of { chan };");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op.answer = answer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component!op;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("answer?role;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline ");
    String _quitRole = NameGenerator.getQuitRole(ct);
    _builder.append(_quitRole, "");
    _builder.append("(rtOperation,component) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _operationTypeName_1 = NameGenerator.getOperationTypeName(ct);
    _builder.append(_operationTypeName_1, "\t");
    _builder.append(" op;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("op.optype = rtOperation;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component!op;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline ");
    String _isPlaying = NameGenerator.getIsPlaying(ct);
    _builder.append(_isPlaying, "");
    _builder.append("(playsOperation,component,plays) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _operationTypeName_2 = NameGenerator.getOperationTypeName(ct);
    _builder.append(_operationTypeName_2, "\t");
    _builder.append(" op;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("op.optype = playsOperation;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("chan answer = [0] of { bool };");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op.answer = answer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component!op;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("answer?plays;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline ");
    String _retrieveAssociation = NameGenerator.getRetrieveAssociation(ct);
    _builder.append(_retrieveAssociation, "");
    _builder.append("(assocOperation,component,assoc) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _operationTypeName_3 = NameGenerator.getOperationTypeName(ct);
    _builder.append(_operationTypeName_3, "\t");
    _builder.append(" op;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("op.optype = assocOperation;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("chan answer = [0] of { chan };");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op.answer = answer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("component!op;\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("answer?assoc;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      EList<ComponentAttributeType> _attrs = ct.getAttrs();
      boolean _hasElements = false;
      for(final ComponentAttributeType attr : _attrs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        _builder.append("inline ");
        String _getterName = NameGenerator.getGetterName(ct, attr);
        _builder.append(_getterName, "");
        _builder.append("(component,");
        String _compProctypeParamName = NameGenerator.getCompProctypeParamName(attr);
        _builder.append(_compProctypeParamName, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _operationTypeName_4 = NameGenerator.getOperationTypeName(ct);
        _builder.append(_operationTypeName_4, "\t");
        _builder.append(" op;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("op.optype = ");
        String _getterCompOperationName = NameGenerator.getGetterCompOperationName(attr);
        _builder.append(_getterCompOperationName, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("chan answer = [0] of { ");
        JvmTypeReference _type = attr.getType();
        String _promelaType = NameGenerator.getPromelaType(_type);
        _builder.append(_promelaType, "\t\t");
        _builder.append(" };");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("op.answer = answer;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("component!op;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("answer?");
        String _compProctypeParamName_1 = NameGenerator.getCompProctypeParamName(attr);
        _builder.append(_compProctypeParamName_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("inline ");
        String _setterName = NameGenerator.getSetterName(ct, attr);
        _builder.append(_setterName, "");
        _builder.append("(component,value) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _operationTypeName_5 = NameGenerator.getOperationTypeName(ct);
        _builder.append(_operationTypeName_5, "\t");
        _builder.append(" op;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("op.optype = ");
        String _setterCompOperationName = NameGenerator.getSetterCompOperationName(attr);
        _builder.append(_setterCompOperationName, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("chan parameters = [0] of { ");
        JvmTypeReference _type_1 = attr.getType();
        String _promelaType_1 = NameGenerator.getPromelaType(_type_1);
        _builder.append(_promelaType_1, "\t\t");
        _builder.append(" };");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("op.parameters = parameters;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("component!op;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("parameters!value;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      EList<OperationType> _ops = ct.getOps();
      boolean _hasElements_1 = false;
      for(final OperationType op : _ops) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        _builder.append("inline ");
        String _operationCall = NameGenerator.getOperationCall(ct, op);
        _builder.append(_operationCall, "");
        _builder.append("(component");
        {
          FormalDataParamsBlock _formalDataParamsBlock = op.getFormalDataParamsBlock();
          EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
          boolean _hasElements_2 = false;
          for(final FormalDataParam param : _params) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
              _builder.append(",", "");
            } else {
              _builder.appendImmediate(",", "");
            }
            String _varName = NameGenerator.getVarName(param);
            _builder.append(_varName, "");
          }
        }
        {
          JvmTypeReference _returnType = op.getReturnType();
          JvmType _type_2 = _returnType.getType();
          boolean _isVoid = ExtensionMethods_JvmType.isVoid(_type_2);
          boolean _not = (!_isVoid);
          if (_not) {
            _builder.append(",re");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _operationTypeName_6 = NameGenerator.getOperationTypeName(ct);
        _builder.append(_operationTypeName_6, "\t");
        _builder.append(" op;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("op.optype = ");
        String _operationCompOperationName = NameGenerator.getOperationCompOperationName(op);
        _builder.append(_operationCompOperationName, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        {
          FormalDataParamsBlock _formalDataParamsBlock_1 = op.getFormalDataParamsBlock();
          EList<FormalDataParam> _params_1 = _formalDataParamsBlock_1.getParams();
          boolean _isEmpty = _params_1.isEmpty();
          boolean _not_1 = (!_isEmpty);
          if (_not_1) {
            _builder.append("\t");
            _builder.append("chan parameters = [0] of { ");
            {
              FormalDataParamsBlock _formalDataParamsBlock_2 = op.getFormalDataParamsBlock();
              EList<FormalDataParam> _params_2 = _formalDataParamsBlock_2.getParams();
              boolean _hasElements_3 = false;
              for(final FormalDataParam param_1 : _params_2) {
                if (!_hasElements_3) {
                  _hasElements_3 = true;
                } else {
                  _builder.appendImmediate(",", "\t");
                }
                JvmTypeReference _type_3 = param_1.getType();
                String _promelaType_2 = NameGenerator.getPromelaType(_type_3);
                _builder.append(_promelaType_2, "\t");
              }
            }
            _builder.append(" };");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("op.parameters = parameters;");
            _builder.newLine();
          }
        }
        {
          JvmTypeReference _returnType_1 = op.getReturnType();
          JvmType _type_4 = _returnType_1.getType();
          boolean _isVoid_1 = ExtensionMethods_JvmType.isVoid(_type_4);
          boolean _not_2 = (!_isVoid_1);
          if (_not_2) {
            _builder.append("\t");
            _builder.append("chan answer = [0] of { ");
            JvmTypeReference _returnType_2 = op.getReturnType();
            String _promelaType_3 = NameGenerator.getPromelaType(_returnType_2);
            _builder.append(_promelaType_3, "\t");
            _builder.append(" };");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("op.answer = answer;");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append("component!op;");
        _builder.newLine();
        {
          FormalDataParamsBlock _formalDataParamsBlock_3 = op.getFormalDataParamsBlock();
          EList<FormalDataParam> _params_3 = _formalDataParamsBlock_3.getParams();
          boolean _isEmpty_1 = _params_3.isEmpty();
          boolean _not_3 = (!_isEmpty_1);
          if (_not_3) {
            _builder.append("\t");
            _builder.append("parameters!");
            {
              FormalDataParamsBlock _formalDataParamsBlock_4 = op.getFormalDataParamsBlock();
              EList<FormalDataParam> _params_4 = _formalDataParamsBlock_4.getParams();
              boolean _hasElements_4 = false;
              for(final FormalDataParam param_2 : _params_4) {
                if (!_hasElements_4) {
                  _hasElements_4 = true;
                } else {
                  _builder.appendImmediate(",", "\t");
                }
                String _varName_1 = NameGenerator.getVarName(param_2);
                _builder.append(_varName_1, "\t");
              }
            }
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          JvmTypeReference _returnType_3 = op.getReturnType();
          JvmType _type_5 = _returnType_3.getType();
          boolean _isVoid_2 = ExtensionMethods_JvmType.isVoid(_type_5);
          boolean _not_4 = (!_isVoid_2);
          if (_not_4) {
            _builder.append("\t");
            _builder.append("answer?re;");
            _builder.newLine();
          }
        }
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
