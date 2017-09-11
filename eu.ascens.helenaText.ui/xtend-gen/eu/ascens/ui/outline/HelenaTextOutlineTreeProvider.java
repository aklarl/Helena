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
package eu.ascens.ui.outline;

import com.google.common.base.Objects;
import eu.ascens.helenaText.AbstractFieldType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DeclaringRoleBehavior;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;

/**
 * Customization of the default outline structure.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
@SuppressWarnings("all")
public class HelenaTextOutlineTreeProvider extends DefaultOutlineTreeProvider {
  protected void _createChildren(final DocumentRootNode parentNode, final Model model) {
    if (((!Objects.equal(model, null)) && (!Objects.equal(model.getHeadPkg(), null)))) {
      PackageDeclaration _headPkg = model.getHeadPkg();
      this.createNode(parentNode, _headPkg);
    }
  }
  
  protected void _createChildren(final IOutlineNode parentNode, final PackageDeclaration pkg) {
    EList<ComponentType> _compTypes = pkg.getCompTypes();
    for (final ComponentType compType : _compTypes) {
      this.createNode(parentNode, compType);
    }
    EList<RoleType> _roleTypes = pkg.getRoleTypes();
    for (final RoleType roleType : _roleTypes) {
      this.createNode(parentNode, roleType);
    }
    EList<EnsembleStructure> _ensStructs = pkg.getEnsStructs();
    for (final EnsembleStructure es : _ensStructs) {
      this.createNode(parentNode, es);
    }
    EList<RoleBehavior> _roleBehaviors = pkg.getRoleBehaviors();
    for (final RoleBehavior rb : _roleBehaviors) {
      this.createNode(parentNode, rb);
    }
  }
  
  protected boolean _isLeaf(final MessageType feature) {
    return true;
  }
  
  protected boolean _isLeaf(final AbstractFieldType feature) {
    return true;
  }
  
  protected boolean _isLeaf(final FormalDataParam feature) {
    return true;
  }
  
  protected boolean _isLeaf(final FormalRoleParam feature) {
    return true;
  }
  
  protected boolean _isLeaf(final EnsembleStructure feature) {
    return true;
  }
  
  protected boolean _isLeaf(final DeclaringRoleBehavior procInvocation) {
    return true;
  }
  
  protected boolean _isLeaf(final eu.ascens.helenaText.Process proc) {
    return true;
  }
}
