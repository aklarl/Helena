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
import com.google.inject.Inject;
import eu.ascens.generator.HelenaTextOutputConfigurationProvider;
import eu.ascens.generator.jHelena.AbstractHelenaTextGenerator;
import eu.ascens.generator.jHelena.ComponentTypeGenerator;
import eu.ascens.generator.jHelena.EnsembleStructureGenerator;
import eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator;
import eu.ascens.generator.jHelena.GeneratorHelper;
import eu.ascens.generator.jHelena.MessageTypeGenerator;
import eu.ascens.generator.jHelena.OperationTypeGenerator;
import eu.ascens.generator.jHelena.RoleTypeGenerator;
import eu.ascens.generator.jHelena.SysManagerGenerator;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.RoleType;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
@SuppressWarnings("all")
public class JHelenaGenerator implements IGenerator {
  @Inject
  protected XbaseCompiler xbaseCompiler;
  
  @Inject
  protected TypeReferenceSerializer serializer;
  
  private ImportManager im = new ImportManager(true);
  
  private GeneratorHelper genHelper;
  
  private EnsembleStructureGenerator ensembleGenerator;
  
  private SysManagerGenerator sysManagerGenerator;
  
  private RoleTypeGenerator roleTypeGenerator;
  
  private MessageTypeGenerator msgTypeGenerator;
  
  private OperationTypeGenerator opTypeGenerator;
  
  private ComponentTypeGenerator componentTypeGenerator;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    GeneratorHelper _generatorHelper = new GeneratorHelper(this.xbaseCompiler, this.serializer, this.im);
    this.genHelper = _generatorHelper;
    ComponentTypeGenerator _componentTypeGenerator = new ComponentTypeGenerator(this.serializer, this.im, this.genHelper);
    this.componentTypeGenerator = _componentTypeGenerator;
    EnsembleStructureGenerator _ensembleStructureGenerator = new EnsembleStructureGenerator(this.serializer, this.im, this.genHelper);
    this.ensembleGenerator = _ensembleStructureGenerator;
    SysManagerGenerator _sysManagerGenerator = new SysManagerGenerator(this.serializer, this.im, this.genHelper);
    this.sysManagerGenerator = _sysManagerGenerator;
    MessageTypeGenerator _messageTypeGenerator = new MessageTypeGenerator(this.serializer, this.im, this.genHelper);
    this.msgTypeGenerator = _messageTypeGenerator;
    OperationTypeGenerator _operationTypeGenerator = new OperationTypeGenerator(this.serializer, this.im, this.genHelper);
    this.opTypeGenerator = _operationTypeGenerator;
    RoleTypeGenerator _roleTypeGenerator = new RoleTypeGenerator(this.xbaseCompiler, this.serializer, this.im, this.genHelper);
    this.roleTypeGenerator = _roleTypeGenerator;
    TreeIterator<EObject> _allContents = resource.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<ComponentType> _filter = Iterables.<ComponentType>filter(_iterable, ComponentType.class);
    for (final ComponentType e : _filter) {
      {
        String fullName = ExtensionMethods_jHelenaGenerator.getFullName(e, "/");
        String _compile = this.componentTypeGenerator.compile(e);
        fsa.generateFile(
          (fullName + ".java"), 
          HelenaTextOutputConfigurationProvider.JHELENA_GEN_OUTPUT, _compile);
        String _compileImpl = this.componentTypeGenerator.compileImpl(e);
        fsa.generateFile(
          ((fullName + AbstractHelenaTextGenerator.IMPL) + ".java"), 
          HelenaTextOutputConfigurationProvider.JHELENA_GEN_ONCE_OUTPUT, _compileImpl);
      }
    }
    TreeIterator<EObject> _allContents_1 = resource.getAllContents();
    Iterable<EObject> _iterable_1 = IteratorExtensions.<EObject>toIterable(_allContents_1);
    Iterable<RoleType> _filter_1 = Iterables.<RoleType>filter(_iterable_1, RoleType.class);
    for (final RoleType e_1 : _filter_1) {
      {
        String fullName = ExtensionMethods_jHelenaGenerator.getFullName(e_1, "/");
        String _compile = this.roleTypeGenerator.compile(e_1);
        fsa.generateFile(
          (fullName + ".java"), 
          HelenaTextOutputConfigurationProvider.JHELENA_GEN_OUTPUT, _compile);
      }
    }
    TreeIterator<EObject> _allContents_2 = resource.getAllContents();
    Iterable<EObject> _iterable_2 = IteratorExtensions.<EObject>toIterable(_allContents_2);
    Iterable<MessageType> _filter_2 = Iterables.<MessageType>filter(_iterable_2, MessageType.class);
    for (final MessageType e_2 : _filter_2) {
      {
        String fn = ExtensionMethods_jHelenaGenerator.getFullName(e_2, "/");
        String _compile = this.msgTypeGenerator.compile(e_2);
        fsa.generateFile(
          (fn + ".java"), _compile);
      }
    }
    TreeIterator<EObject> _allContents_3 = resource.getAllContents();
    Iterable<EObject> _iterable_3 = IteratorExtensions.<EObject>toIterable(_allContents_3);
    Iterable<OperationType> _filter_3 = Iterables.<OperationType>filter(_iterable_3, OperationType.class);
    for (final OperationType e_3 : _filter_3) {
      {
        String fn = ExtensionMethods_jHelenaGenerator.getFullName(e_3, "/");
        String _compile = this.opTypeGenerator.compile(e_3);
        fsa.generateFile(
          (fn + ".java"), _compile);
      }
    }
    TreeIterator<EObject> _allContents_4 = resource.getAllContents();
    Iterable<EObject> _iterable_4 = IteratorExtensions.<EObject>toIterable(_allContents_4);
    Iterable<EnsembleStructure> _filter_4 = Iterables.<EnsembleStructure>filter(_iterable_4, EnsembleStructure.class);
    for (final EnsembleStructure e_4 : _filter_4) {
      {
        String fullName = ExtensionMethods_jHelenaGenerator.getFullName(e_4, "/");
        String _compile = this.ensembleGenerator.compile(e_4);
        fsa.generateFile(
          (fullName + ".java"), 
          HelenaTextOutputConfigurationProvider.JHELENA_GEN_OUTPUT, _compile);
        String _compileImpl = this.ensembleGenerator.compileImpl(e_4);
        fsa.generateFile(
          ((fullName + AbstractHelenaTextGenerator.IMPL) + ".java"), 
          HelenaTextOutputConfigurationProvider.JHELENA_GEN_ONCE_OUTPUT, _compileImpl);
      }
    }
    TreeIterator<EObject> _allContents_5 = resource.getAllContents();
    Iterable<EObject> _iterable_5 = IteratorExtensions.<EObject>toIterable(_allContents_5);
    Iterable<Model> _filter_5 = Iterables.<Model>filter(_iterable_5, Model.class);
    for (final Model e_5 : _filter_5) {
      {
        String fullName = ExtensionMethods_jHelenaGenerator.getSysMgrFullName(e_5, "/");
        CharSequence _compile = this.sysManagerGenerator.compile(e_5);
        fsa.generateFile(
          (fullName + ".java"), 
          HelenaTextOutputConfigurationProvider.JHELENA_GEN_OUTPUT, _compile);
        String _compileImpl = this.sysManagerGenerator.compileImpl(e_5);
        fsa.generateFile(
          ((fullName + AbstractHelenaTextGenerator.IMPL) + ".java"), 
          HelenaTextOutputConfigurationProvider.JHELENA_GEN_ONCE_OUTPUT, _compileImpl);
      }
    }
  }
}
