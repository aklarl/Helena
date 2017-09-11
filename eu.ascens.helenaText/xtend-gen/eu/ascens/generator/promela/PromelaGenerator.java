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

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import eu.ascens.generator.HelenaTextOutputConfigurationProvider;
import eu.ascens.generator.promela.ComponentTypeGenerator;
import eu.ascens.generator.promela.MessageTypeGenerator;
import eu.ascens.generator.promela.NameGenerator;
import eu.ascens.generator.promela.RoleTypeGenerator;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import eu.ascens.helenaText.util.ExtensionMethods_EnsembleStructure;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates the Promela code from a HelenaText file on save.
 */
@SuppressWarnings("all")
public class PromelaGenerator implements IGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    TreeIterator<EObject> _allContents = resource.getAllContents();
    Iterator<Model> _filter = Iterators.<Model>filter(_allContents, Model.class);
    Model model = IteratorExtensions.<Model>head(_filter);
    PackageDeclaration _headPkg = model.getHeadPkg();
    String _name = _headPkg.getName();
    String _plus = (_name + ".pml");
    CharSequence _compile = this.compile(model);
    fsa.generateFile(_plus, 
      HelenaTextOutputConfigurationProvider.PROMELA_GEN_OUTPUT, _compile);
  }
  
  /**
   * Compiles the whole model
   */
  @Inject
  private RoleTypeGenerator rtGenerator;
  
  public CharSequence compile(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _compileMultiplicities = PromelaGenerator.compileMultiplicities(model);
    _builder.append(_compileMultiplicities, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      PackageDeclaration _headPkg = model.getHeadPkg();
      EList<ComponentType> _compTypes = _headPkg.getCompTypes();
      for(final ComponentType ct : _compTypes) {
        PackageDeclaration _headPkg_1 = model.getHeadPkg();
        EList<EnsembleStructure> _ensStructs = _headPkg_1.getEnsStructs();
        EnsembleStructure _head = IterableExtensions.<EnsembleStructure>head(_ensStructs);
        CharSequence _compileOperations = ComponentTypeGenerator.compileOperations(ct, _head);
        _builder.append(_compileOperations, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      PackageDeclaration _headPkg_2 = model.getHeadPkg();
      EList<ComponentType> _compTypes_1 = _headPkg_2.getCompTypes();
      boolean _hasElements = false;
      for(final ComponentType ct_1 : _compTypes_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        CharSequence _compileOperationCallHelpers = ComponentTypeGenerator.compileOperationCallHelpers(ct_1);
        _builder.append(_compileOperationCallHelpers, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _compileMsgs = MessageTypeGenerator.compileMsgs(model);
    _builder.append(_compileMsgs, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _compileMsgCallHelpers = MessageTypeGenerator.compileMsgCallHelpers(model);
    _builder.append(_compileMsgCallHelpers, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      PackageDeclaration _headPkg_3 = model.getHeadPkg();
      EList<ComponentType> _compTypes_2 = _headPkg_3.getCompTypes();
      boolean _hasElements_1 = false;
      for(final ComponentType ct_2 : _compTypes_2) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        PackageDeclaration _headPkg_4 = model.getHeadPkg();
        EList<EnsembleStructure> _ensStructs_1 = _headPkg_4.getEnsStructs();
        EnsembleStructure _head_1 = IterableExtensions.<EnsembleStructure>head(_ensStructs_1);
        CharSequence _compileProctype = ComponentTypeGenerator.compileProctype(ct_2, _head_1, model);
        _builder.append(_compileProctype, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      PackageDeclaration _headPkg_5 = model.getHeadPkg();
      EList<RoleType> _roleTypes = _headPkg_5.getRoleTypes();
      boolean _hasElements_2 = false;
      for(final RoleType rt : _roleTypes) {
        if (!_hasElements_2) {
          _hasElements_2 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        CharSequence _compileProctype_1 = this.rtGenerator.compileProctype(rt, model);
        _builder.append(_compileProctype_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public static CharSequence compileMultiplicities(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("///////////// ensemble structure multiplicities //////////////////////");
    _builder.newLine();
    {
      PackageDeclaration _headPkg = model.getHeadPkg();
      EList<EnsembleStructure> _ensStructs = _headPkg.getEnsStructs();
      EnsembleStructure _head = IterableExtensions.<EnsembleStructure>head(_ensStructs);
      EList<RoleTypeWithMultiplicity> _rtWithMult = _head.getRtWithMult();
      boolean _hasElements = false;
      for(final RoleTypeWithMultiplicity rtWithMult : _rtWithMult) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        _builder.append("int ");
        RoleType _roleType = rtWithMult.getRoleType();
        String _minName = NameGenerator.getMinName(_roleType);
        _builder.append(_minName, "");
        _builder.append(" = ");
        String _min = rtWithMult.getMin();
        String _calculateMultiplicityPromela = ExtensionMethods_EnsembleStructure.calculateMultiplicityPromela(_min);
        _builder.append(_calculateMultiplicityPromela, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("int ");
        RoleType _roleType_1 = rtWithMult.getRoleType();
        String _maxName = NameGenerator.getMaxName(_roleType_1);
        _builder.append(_maxName, "");
        _builder.append(" = ");
        String _max = rtWithMult.getMax();
        String _calculateMultiplicityPromela_1 = ExtensionMethods_EnsembleStructure.calculateMultiplicityPromela(_max);
        _builder.append(_calculateMultiplicityPromela_1, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("int ");
        RoleType _roleType_2 = rtWithMult.getRoleType();
        String _currentName = NameGenerator.getCurrentName(_roleType_2);
        _builder.append(_currentName, "");
        _builder.append(" = 0;");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
