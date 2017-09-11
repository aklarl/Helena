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

import eu.ascens.generator.promela.NameGenerator;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.util.ExtensionMethods_Model;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class MessageTypeGenerator {
  /**
   * Compiles a user defined type declaration for every message which can be sent in the model
   */
  public static CharSequence compileMsgs(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("///////////// message definitions //////////////////////");
    _builder.newLine();
    _builder.append("mtype {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("setOffInitialRole, ");
    _builder.newLine();
    {
      Iterable<MessageType> _allMessagesInModel = ExtensionMethods_RoleType.getAllMessagesInModel(model);
      boolean _hasElements = false;
      for(final MessageType msg : _allMessagesInModel) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "\t");
        }
        _builder.append("\t");
        String _msgName = NameGenerator.getMsgName(msg);
        _builder.append(_msgName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Compiles helpers to send messages between roles
   */
  public static CharSequence compileMsgCallHelpers(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//////// helper for setting up initial state /////////");
    _builder.newLine();
    _builder.append("inline send_setOffInitialRole(receiver) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("receiver!setOffInitialRole");
    {
      int _maxNumberOfRoleParamsInModel = ExtensionMethods_Model.maxNumberOfRoleParamsInModel(model);
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _maxNumberOfRoleParamsInModel, true);
      boolean _hasElements = false;
      for(final Integer i : _doubleDotLessThan) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(",", "\t");
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("1");
      }
    }
    {
      int _maxNumberOfDataParamsInModel = ExtensionMethods_Model.maxNumberOfDataParamsInModel(model);
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _maxNumberOfDataParamsInModel, true);
      boolean _hasElements_1 = false;
      for(final Integer i_1 : _doubleDotLessThan_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
          _builder.append(",", "\t");
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("1");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("inline receive_setOffInitialRole() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("self?setOffInitialRole");
    {
      int _maxNumberOfRoleParamsInModel_1 = ExtensionMethods_Model.maxNumberOfRoleParamsInModel(model);
      ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _maxNumberOfRoleParamsInModel_1, true);
      boolean _hasElements_2 = false;
      for(final Integer i_2 : _doubleDotLessThan_2) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
          _builder.append(",", "\t");
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("1");
      }
    }
    {
      int _maxNumberOfDataParamsInModel_1 = ExtensionMethods_Model.maxNumberOfDataParamsInModel(model);
      ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _maxNumberOfDataParamsInModel_1, true);
      boolean _hasElements_3 = false;
      for(final Integer i_3 : _doubleDotLessThan_3) {
        if (!_hasElements_3) {
          _hasElements_3 = true;
          _builder.append(",", "\t");
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("1");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//////// helper for communication between roles /////////");
    _builder.newLine();
    {
      Iterable<MessageType> _allMessagesInModel = ExtensionMethods_RoleType.getAllMessagesInModel(model);
      boolean _hasElements_4 = false;
      for(final MessageType msg : _allMessagesInModel) {
        if (!_hasElements_4) {
          _hasElements_4 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        FormalRoleParamsBlock _formalRoleParamsBlock = msg.getFormalRoleParamsBlock();
        EList<FormalRoleParam> roleparams = _formalRoleParamsBlock.getParams();
        _builder.newLineIfNotEmpty();
        FormalDataParamsBlock _formalDataParamsBlock = msg.getFormalDataParamsBlock();
        EList<FormalDataParam> dataparams = _formalDataParamsBlock.getParams();
        _builder.newLineIfNotEmpty();
        _builder.append("inline ");
        String _sndMsgHelperName = NameGenerator.getSndMsgHelperName(msg);
        _builder.append(_sndMsgHelperName, "");
        _builder.append("(receiver");
        {
          boolean _hasElements_5 = false;
          for(final FormalRoleParam param : roleparams) {
            if (!_hasElements_5) {
              _hasElements_5 = true;
              _builder.append(",", "");
            } else {
              _builder.appendImmediate(",", "");
            }
            String _variableName = NameGenerator.getVariableName(param);
            _builder.append(_variableName, "");
          }
        }
        {
          boolean _hasElements_6 = false;
          for(final FormalDataParam param_1 : dataparams) {
            if (!_hasElements_6) {
              _hasElements_6 = true;
              _builder.append(",", "");
            } else {
              _builder.appendImmediate(",", "");
            }
            String _varName = NameGenerator.getVarName(param_1);
            _builder.append(_varName, "");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("receiver!");
        String _msgName = NameGenerator.getMsgName(msg);
        _builder.append(_msgName, "\t");
        {
          int _maxNumberOfRoleParamsInModel_2 = ExtensionMethods_Model.maxNumberOfRoleParamsInModel(model);
          ExclusiveRange _doubleDotLessThan_4 = new ExclusiveRange(0, _maxNumberOfRoleParamsInModel_2, true);
          boolean _hasElements_7 = false;
          for(final Integer i_4 : _doubleDotLessThan_4) {
            if (!_hasElements_7) {
              _hasElements_7 = true;
              _builder.append(",", "\t");
            } else {
              _builder.appendImmediate(",", "\t");
            }
            {
              int _size = roleparams.size();
              boolean _lessThan = ((i_4).intValue() < _size);
              if (_lessThan) {
                FormalRoleParam _get = roleparams.get((i_4).intValue());
                String _variableName_1 = NameGenerator.getVariableName(_get);
                _builder.append(_variableName_1, "\t");
              } else {
                _builder.append("1");
              }
            }
          }
        }
        {
          int _maxNumberOfDataParamsInModel_2 = ExtensionMethods_Model.maxNumberOfDataParamsInModel(model);
          ExclusiveRange _doubleDotLessThan_5 = new ExclusiveRange(0, _maxNumberOfDataParamsInModel_2, true);
          boolean _hasElements_8 = false;
          for(final Integer i_5 : _doubleDotLessThan_5) {
            if (!_hasElements_8) {
              _hasElements_8 = true;
              _builder.append(",", "\t");
            } else {
              _builder.appendImmediate(",", "\t");
            }
            {
              int _size_1 = dataparams.size();
              boolean _lessThan_1 = ((i_5).intValue() < _size_1);
              if (_lessThan_1) {
                FormalDataParam _get_1 = dataparams.get((i_5).intValue());
                String _varName_1 = NameGenerator.getVarName(_get_1);
                _builder.append(_varName_1, "\t");
              } else {
                _builder.append("1");
              }
            }
          }
        }
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("inline ");
        String _rcvMsgHelperName = NameGenerator.getRcvMsgHelperName(msg);
        _builder.append(_rcvMsgHelperName, "");
        _builder.append("(");
        {
          boolean _hasElements_9 = false;
          for(final FormalRoleParam param_2 : roleparams) {
            if (!_hasElements_9) {
              _hasElements_9 = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _variableName_2 = NameGenerator.getVariableName(param_2);
            _builder.append(_variableName_2, "");
          }
        }
        {
          if (((!roleparams.isEmpty()) && (!dataparams.isEmpty()))) {
            _builder.append(",");
          }
        }
        {
          boolean _hasElements_10 = false;
          for(final FormalDataParam param_3 : dataparams) {
            if (!_hasElements_10) {
              _hasElements_10 = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _varName_2 = NameGenerator.getVarName(param_3);
            _builder.append(_varName_2, "");
          }
        }
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("self?");
        String _msgName_1 = NameGenerator.getMsgName(msg);
        _builder.append(_msgName_1, "\t");
        {
          int _maxNumberOfRoleParamsInModel_3 = ExtensionMethods_Model.maxNumberOfRoleParamsInModel(model);
          ExclusiveRange _doubleDotLessThan_6 = new ExclusiveRange(0, _maxNumberOfRoleParamsInModel_3, true);
          boolean _hasElements_11 = false;
          for(final Integer i_6 : _doubleDotLessThan_6) {
            if (!_hasElements_11) {
              _hasElements_11 = true;
              _builder.append(",", "\t");
            } else {
              _builder.appendImmediate(",", "\t");
            }
            {
              int _size_2 = roleparams.size();
              boolean _lessThan_2 = ((i_6).intValue() < _size_2);
              if (_lessThan_2) {
                FormalRoleParam _get_2 = roleparams.get((i_6).intValue());
                String _variableName_3 = NameGenerator.getVariableName(_get_2);
                _builder.append(_variableName_3, "\t");
              } else {
                _builder.append("1");
              }
            }
          }
        }
        {
          int _maxNumberOfDataParamsInModel_3 = ExtensionMethods_Model.maxNumberOfDataParamsInModel(model);
          ExclusiveRange _doubleDotLessThan_7 = new ExclusiveRange(0, _maxNumberOfDataParamsInModel_3, true);
          boolean _hasElements_12 = false;
          for(final Integer i_7 : _doubleDotLessThan_7) {
            if (!_hasElements_12) {
              _hasElements_12 = true;
              _builder.append(",", "\t");
            } else {
              _builder.appendImmediate(",", "\t");
            }
            {
              int _size_3 = dataparams.size();
              boolean _lessThan_3 = ((i_7).intValue() < _size_3);
              if (_lessThan_3) {
                FormalDataParam _get_3 = dataparams.get((i_7).intValue());
                String _varName_3 = NameGenerator.getVarName(_get_3);
                _builder.append(_varName_3, "\t");
              } else {
                _builder.append("1");
              }
            }
          }
        }
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
