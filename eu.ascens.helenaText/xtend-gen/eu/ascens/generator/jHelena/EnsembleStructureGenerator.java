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
import eu.ascens.helenaText.EnsembleStructure;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;

@SuppressWarnings("all")
public class EnsembleStructureGenerator extends AbstractHelenaTextGenerator {
  protected EnsembleStructureGenerator(final TypeReferenceSerializer serializer, final ImportManager im, final GeneratorHelper genHelper) {
    super(serializer, im, genHelper);
  }
  
  public String compile(final EnsembleStructure it) {
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
    _builder.append(" extends Ensemble {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _classname_1 = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname_1, "\t");
    _builder.append("(String ensembleID, Set<Component> comps) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(ensembleID, comps);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract void startEnsemble(Component initialComponent) ");
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
    _builder.append("ReflectionException, PropertyNotDeclaredInClassException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  public String compileImpl(final EnsembleStructure it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("package ");
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(it);
    _builder.append(_packageName, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append(" \t");
    String _compileImplImports = ImportGenerator.compileImplImports(it, this.im);
    _builder.append(_compileImplImports, " \t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _implClassname = ExtensionMethods_jHelenaGenerator.getImplClassname(it);
    _builder.append(_implClassname, "");
    _builder.append(" extends ");
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _implClassname_1 = ExtensionMethods_jHelenaGenerator.getImplClassname(it);
    _builder.append(_implClassname_1, "\t");
    _builder.append("(String ensembleID, Set<Component> comps) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("super(ensembleID, comps);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("public void startEnsemble(Component initialComponent)");
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
    _builder.append("ComponentAlreadyAdoptsRoleException,");
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
    _builder.newLine();
    return _builder.toString();
  }
}
