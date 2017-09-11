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
package eu.ascens.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class HelenaTextJvmModelInferrer extends AbstractModelInferrer {
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  /**
   * The dispatch method {@code infer} is called for each instance of the
   * given element's type that is contained in a resource.
   * 
   * @param element
   *            the model to create one or more
   *            {@link JvmDeclaredType declared
   *            types} from.
   * @param acceptor
   *            each created
   *            {@link JvmDeclaredType type}
   *            without a container should be passed to the acceptor in order
   *            get attached to the current resource. The acceptor's
   *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
   *            accept(..)} method takes the constructed empty type for the
   *            pre-indexing phase. This one is further initialized in the
   *            indexing phase using the closure you pass to the returned
   *            {@link IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
   *            initializeLater(..)}.
   * @param isPreIndexingPhase
   *            whether the method is called in a pre-indexing phase, i.e.
   *            when the global index is not yet fully updated. You must not
   *            rely on linking using the index if isPreIndexingPhase is
   *            <code>true</code>.
   */
  protected void _infer(final Model model, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    List<RoleBehavior> _eAllOfType = EcoreUtil2.<RoleBehavior>eAllOfType(model, RoleBehavior.class);
    for (final RoleBehavior rb : _eAllOfType) {
      RoleType _roleTypeRef = rb.getRoleTypeRef();
      String _classname = ExtensionMethods_jHelenaGenerator.getClassname(_roleTypeRef);
      JvmGenericType _class = this._jvmTypesBuilder.toClass(rb, _classname);
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        @Override
        public void apply(final JvmGenericType it) {
          String _documentation = HelenaTextJvmModelInferrer.this._jvmTypesBuilder.getDocumentation(rb);
          HelenaTextJvmModelInferrer.this._jvmTypesBuilder.setDocumentation(it, _documentation);
          Resource _eResource = model.eResource();
          TreeIterator<EObject> _allContents = _eResource.getAllContents();
          Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
          Iterable<XExpression> expressions = Iterables.<XExpression>filter(_iterable, XExpression.class);
          for (final XExpression expr : expressions) {
            {
              JvmTypeReference _elvis = null;
              JvmTypeReference _inferredType = null;
              if (expr!=null) {
                _inferredType=HelenaTextJvmModelInferrer.this._jvmTypesBuilder.inferredType(expr);
              }
              if (_inferredType != null) {
                _elvis = _inferredType;
              } else {
                JvmTypeReference _typeRef = HelenaTextJvmModelInferrer.this._typeReferenceBuilder.typeRef(String.class);
                _elvis = _typeRef;
              }
              final JvmTypeReference type = _elvis;
              EList<JvmMember> _members = it.getMembers();
              String _name = ExtensionMethods.getName(rb);
              final Procedure1<JvmField> _function = new Procedure1<JvmField>() {
                @Override
                public void apply(final JvmField it) {
                  it.setVisibility(JvmVisibility.PROTECTED);
                  HelenaTextJvmModelInferrer.this._jvmTypesBuilder.setInitializer(it, expr);
                }
              };
              JvmField _field = HelenaTextJvmModelInferrer.this._jvmTypesBuilder.toField(rb, _name, type, _function);
              HelenaTextJvmModelInferrer.this._jvmTypesBuilder.<JvmField>operator_add(_members, _field);
            }
          }
        }
      };
      acceptor.<JvmGenericType>accept(_class, _function);
    }
  }
  
  public void infer(final EObject model, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (model instanceof Model) {
      _infer((Model)model, acceptor, isPreIndexingPhase);
      return;
    } else if (model != null) {
      _infer(model, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(model, acceptor, isPreIndexingPhase).toString());
    }
  }
}
