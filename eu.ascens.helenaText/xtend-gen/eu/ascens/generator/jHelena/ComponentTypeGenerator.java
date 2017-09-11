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

import eu.ascens.generator.jHelena.AbstractFieldTypeGenerator;
import eu.ascens.generator.jHelena.AbstractHelenaTextGenerator;
import eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator;
import eu.ascens.generator.jHelena.GeneratorHelper;
import eu.ascens.generator.jHelena.ImportGenerator;
import eu.ascens.helenaText.AbstractFieldType;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.util.ExtensionMethods;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ComponentTypeGenerator extends AbstractHelenaTextGenerator {
  private AbstractFieldTypeGenerator fieldTypeGenerator;
  
  protected ComponentTypeGenerator(final TypeReferenceSerializer serializer, final ImportManager im, final GeneratorHelper genHelper) {
    super(serializer, im, genHelper);
    AbstractFieldTypeGenerator _abstractFieldTypeGenerator = new AbstractFieldTypeGenerator(this.serializer, this.im, this.genHelper);
    this.fieldTypeGenerator = _abstractFieldTypeGenerator;
  }
  
  public String compile(final ComponentType it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("package ");
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(it);
    _builder.append(_packageName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    \t");
    String _compileImports = ImportGenerator.compileImports(it, this.im);
    _builder.append(_compileImports, "    \t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract class ");
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname, "\t");
    _builder.append(" extends Component{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      List<AbstractFieldType> _fields = ExtensionMethods.getFields(it);
      for(final AbstractFieldType a : _fields) {
        String _compile = this.fieldTypeGenerator.compile(a, this.im);
        _builder.append(_compile, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public ");
    String _classname_1 = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname_1, "\t\t\t");
    _builder.append("(");
    {
      List<AbstractFieldType> _fields_1 = ExtensionMethods.getFields(it);
      boolean _hasElements = false;
      for(final AbstractFieldType f : _fields_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(f);
        _builder.append(_wrappedTypeAsString, "\t\t\t");
        _builder.append(" ");
        String _name = f.getName();
        _builder.append(_name, "\t\t\t");
      }
    }
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    {
      List<AbstractFieldType> _fields_2 = ExtensionMethods.getFields(it);
      for(final AbstractFieldType a_1 : _fields_2) {
        _builder.append("\t\t");
        _builder.append("this.");
        String _name_1 = a_1.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(" = ");
        String _name_2 = a_1.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<OperationType> _ops = it.getOps();
      for(final OperationType op : _ops) {
        JvmTypeReference _returnType = op.getReturnType();
        String retType = this.genHelper.getWrappedTypeAsString(_returnType);
        _builder.newLineIfNotEmpty();
        FormalDataParamsBlock _formalDataParamsBlock = op.getFormalDataParamsBlock();
        EList<FormalDataParam> params = _formalDataParamsBlock.getParams();
        _builder.newLineIfNotEmpty();
        _builder.append("public abstract ");
        _builder.append(retType, "");
        _builder.append(" ");
        String _operationFunctionName = ExtensionMethods_jHelenaGenerator.getOperationFunctionName(op);
        _builder.append(_operationFunctionName, "");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        {
          boolean _hasElements_1 = false;
          for(final FormalDataParam p : params) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            JvmTypeReference _type = p.getType();
            String _wrappedTypeAsString_1 = this.genHelper.getWrappedTypeAsString(_type);
            _builder.append(_wrappedTypeAsString_1, "");
            _builder.append(" ");
            String _name_3 = p.getName();
            _builder.append(_name_3, "");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append(") throws InstantiationException;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<ComponentAssociationType> _assocs = it.getAssocs();
      for(final ComponentAssociationType a_2 : _assocs) {
        _builder.append("public void set");
        String _name_4 = a_2.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_4);
        _builder.append(_firstUpper, "");
        _builder.append("(");
        String _wrappedTypeAsString_2 = this.genHelper.getWrappedTypeAsString(a_2);
        _builder.append(_wrappedTypeAsString_2, "");
        _builder.append(" ");
        String _name_5 = a_2.getName();
        _builder.append(_name_5, "");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("this.");
        String _name_6 = a_2.getName();
        _builder.append(_name_6, "\t");
        _builder.append(" = ");
        String _name_7 = a_2.getName();
        _builder.append(_name_7, "\t");
        _builder.append(";\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  public String compileImpl(final ComponentType it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("package ");
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(it);
    _builder.append(_packageName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    \t");
    String _compileImplImports = ImportGenerator.compileImplImports(it, this.im);
    _builder.append(_compileImplImports, "    \t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public class ");
    String _implClassname = ExtensionMethods_jHelenaGenerator.getImplClassname(it);
    _builder.append(_implClassname, "\t");
    _builder.append(" extends ");
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname, "\t");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("public ");
    String _implClassname_1 = ExtensionMethods_jHelenaGenerator.getImplClassname(it);
    _builder.append(_implClassname_1, "\t\t\t");
    _builder.append("(");
    {
      List<AbstractFieldType> _fields = ExtensionMethods.getFields(it);
      boolean _hasElements = false;
      for(final AbstractFieldType f : _fields) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(f);
        _builder.append(_wrappedTypeAsString, "\t\t\t");
        _builder.append(" ");
        String _name = f.getName();
        _builder.append(_name, "\t\t\t");
      }
    }
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(");
    _builder.newLine();
    {
      List<AbstractFieldType> _fields_1 = ExtensionMethods.getFields(it);
      boolean _hasElements_1 = false;
      for(final AbstractFieldType f_1 : _fields_1) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        _builder.append("\t\t\t");
        String _name_1 = f_1.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<ComponentAssociationType> _assocs = it.getAssocs();
      boolean _isEmpty = _assocs.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("public ");
        String _implClassname_2 = ExtensionMethods_jHelenaGenerator.getImplClassname(it);
        _builder.append(_implClassname_2, "");
        _builder.append("(");
        {
          EList<ComponentAttributeType> _attrs = it.getAttrs();
          boolean _hasElements_2 = false;
          for(final ComponentAttributeType a : _attrs) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _wrappedTypeAsString_1 = this.genHelper.getWrappedTypeAsString(a);
            _builder.append(_wrappedTypeAsString_1, "");
            _builder.append(" ");
            String _name_2 = a.getName();
            _builder.append(_name_2, "");
          }
        }
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("this(\t\t\t");
        _builder.newLine();
        {
          List<AbstractFieldType> _fields_2 = ExtensionMethods.getFields(it);
          boolean _hasElements_3 = false;
          for(final AbstractFieldType a_1 : _fields_2) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate(",", "\t\t");
            }
            {
              if ((a_1 instanceof ComponentAttributeType)) {
                _builder.append("\t\t");
                String _name_3 = ((ComponentAttributeType)a_1).getName();
                _builder.append(_name_3, "\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t");
              } else {
                _builder.append("\tnull");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t");
        _builder.append(");");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      EList<OperationType> _ops = it.getOps();
      for(final OperationType op : _ops) {
        JvmTypeReference _returnType = op.getReturnType();
        String retType = this.genHelper.getWrappedTypeAsString(_returnType);
        _builder.newLineIfNotEmpty();
        FormalDataParamsBlock _formalDataParamsBlock = op.getFormalDataParamsBlock();
        EList<FormalDataParam> params = _formalDataParamsBlock.getParams();
        _builder.newLineIfNotEmpty();
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("public ");
        _builder.append(retType, "");
        _builder.append(" ");
        String _operationFunctionName = ExtensionMethods_jHelenaGenerator.getOperationFunctionName(op);
        _builder.append(_operationFunctionName, "");
        _builder.append(" (");
        _builder.newLineIfNotEmpty();
        {
          boolean _hasElements_4 = false;
          for(final FormalDataParam p : params) {
            if (!_hasElements_4) {
              _hasElements_4 = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            _builder.append(" ");
            JvmTypeReference _type = p.getType();
            String _wrappedTypeAsString_2 = this.genHelper.getWrappedTypeAsString(_type);
            _builder.append(_wrappedTypeAsString_2, "");
            _builder.append(" ");
            String _name_4 = p.getName();
            _builder.append(_name_4, "");
          }
        }
        _builder.append(") throws InstantiationException {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//");
        _builder.append(this.METHOD_HAS_TO_BE_IMPLEMENTED_BY_USER, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("throw new UnsupportedOperationException(\"");
        _builder.append(this.METHOD_NOT_IMPLEMENTED, "\t");
        _builder.append(": ");
        _builder.append(this.USER_INPUT_REQUIRED, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
}
