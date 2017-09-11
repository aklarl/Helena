/*
 *  The Helena workbench is an Eclipse plugin for the development of ensemble-based systems
 *  according to the Helena approach. It is fully documented in the PhD 
 *  thesis "Helena - Handling massively distributed systems with ELaborate 
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 
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
 * 
 */
package eu.ascens.ui.outline

import eu.ascens.helenaText.AbstractFieldType
import eu.ascens.helenaText.DeclaringRoleBehavior
import eu.ascens.helenaText.EnsembleStructure
import eu.ascens.helenaText.FormalDataParam
import eu.ascens.helenaText.FormalRoleParam
import eu.ascens.helenaText.MessageType
import eu.ascens.helenaText.Model
import eu.ascens.helenaText.PackageDeclaration
import eu.ascens.helenaText.Process
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
class HelenaTextOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	//Adapt child nodes of Model
	def protected void _createChildren(DocumentRootNode parentNode, Model model) {
		if(model != null && model.headPkg != null)	
			createNode(parentNode, model.headPkg);
	}
	
	//Adapt child nodes of PackageDeclaration
	def protected void _createChildren(IOutlineNode parentNode, PackageDeclaration pkg) {
		for (compType : pkg.compTypes) {
			createNode(parentNode, compType);
		}

		for (roleType : pkg.roleTypes) {
			createNode(parentNode, roleType);
		}

		for (es : pkg.ensStructs) {
			createNode(parentNode, es);
		}

		for (rb : pkg.roleBehaviors) {
			createNode(parentNode, rb);
		}
	}
	
	
//	@Inject
//	var private StylerFactory stylerFactory;
//	def public Object _text(RoleBehavior entity) {
//	    return new StyledString(entity.getName(), stylerFactory.createXtextStyleAdapterStyler(getTypeTextStyle()))
//    }
//    def protected TextStyle getTypeTextStyle() {
//	    var TextStyle textStyle = new TextStyle();
////	    textStyle.setColor(new RGB(149, 125, 71));
//	    textStyle.setStyle(SWT.ITALIC);
//	    return textStyle;
//    }
	
	def protected boolean _isLeaf(MessageType feature){
		return true;
	}
	def protected boolean _isLeaf(AbstractFieldType feature) {
		return true;
	}

	def protected boolean _isLeaf(FormalDataParam feature) {
		return true;
	}

	def protected boolean _isLeaf(FormalRoleParam feature) {
		return true;
	}

	def protected boolean _isLeaf(EnsembleStructure feature) {
		return true;
	}
	
	def protected boolean _isLeaf(DeclaringRoleBehavior procInvocation){
		return true;
	}
	def protected boolean _isLeaf(Process proc){
		return true;
	}
}
