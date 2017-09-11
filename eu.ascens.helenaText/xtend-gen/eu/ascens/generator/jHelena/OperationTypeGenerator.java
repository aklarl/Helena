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

import eu.ascens.generator.jHelena.AbstractHelenaTextGenerator;
import eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator;
import eu.ascens.generator.jHelena.GeneratorHelper;
import eu.ascens.generator.jHelena.ImportGenerator;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.OperationType;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class OperationTypeGenerator extends AbstractHelenaTextGenerator {
  protected OperationTypeGenerator(final TypeReferenceSerializer serializer, final ImportManager im, final GeneratorHelper genHelper) {
    super(serializer, im, genHelper);
  }
  
  public String compile(final OperationType it) {
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
    _builder.append("public class ");
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname, "\t");
    _builder.append(" extends Operation{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    FormalDataParamsBlock _formalDataParamsBlock = it.getFormalDataParamsBlock();
    EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
    Iterable<FormalDataParam> _filterNull = IterableExtensions.<FormalDataParam>filterNull(_params);
    List<FormalDataParam> allParams = IterableExtensions.<FormalDataParam>toList(_filterNull);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public ");
    String _classname_1 = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname_1, "\t\t\t");
    _builder.append("(");
    {
      boolean _hasElements = false;
      for(final FormalDataParam p : allParams) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t\t\t");
        }
        _builder.append("Variable<");
        String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(p);
        _builder.append(_wrappedTypeAsString, "\t\t\t");
        _builder.append("> ");
        String _name = p.getName();
        _builder.append(_name, "\t\t\t");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      int _size = allParams.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append("\t\t");
        _builder.append("super(toList(");
        {
          boolean _hasElements_1 = false;
          for(final FormalDataParam p_1 : allParams) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(", ", "\t\t");
            }
            String _name_1 = p_1.getName();
            _builder.append(_name_1, "\t\t");
          }
        }
        _builder.append("));");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("super(new ArrayList<Variable<? extends Object>>());");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      int _size_1 = allParams.size();
      boolean _greaterThan_1 = (_size_1 > 0);
      if (_greaterThan_1) {
        _builder.append("\t");
        _builder.append("private static List<Variable<?>> toList(Variable<?>... objects) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return Arrays.asList(objects);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
