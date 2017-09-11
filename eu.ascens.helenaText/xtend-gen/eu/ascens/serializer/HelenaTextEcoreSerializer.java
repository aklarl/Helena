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
package eu.ascens.serializer;

import com.google.common.base.Objects;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class HelenaTextEcoreSerializer extends Serializer {
  /**
   * @param modelURI model that shall be serialized
   * @param targetURI URI of the target XMI file that shall be generated
   */
  public void serializeXtext(final Resource model) {
    try {
      URI modelURI = model.getURI();
      URI _trimSegments = modelURI.trimSegments(2);
      URI destinationURI = _trimSegments.appendSegment("model");
      URI _trimFileExtension = modelURI.trimFileExtension();
      String _lastSegment = _trimFileExtension.lastSegment();
      String fileName = (_lastSegment + "_helena");
      URI _appendSegment = destinationURI.appendSegment(fileName);
      URI targetURI = _appendSegment.appendFileExtension("xmi");
      XtextResourceSet xrs = new XtextResourceSet();
      xrs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
      Resource xtextResource = model;
      xtextResource.load(null);
      EcoreUtil2.resolveAll(xtextResource);
      EList<EObject> _contents = xtextResource.getContents();
      EObject newMod = _contents.get(0);
      Resource xmiResource = xrs.createResource(targetURI);
      EList<EObject> _contents_1 = xmiResource.getContents();
      _contents_1.add(newMod);
      try {
        Map options = ((XMIResource) xmiResource).getDefaultLoadOptions();
        options.put(XMIResource.OPTION_PROXY_ATTRIBUTES, Boolean.TRUE);
        xmiResource.save(options);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  void XMItoXtext(final URI src_xmi_uri, final URI trg_uri) {
    try {
      XtextResourceSet xrs = new XtextResourceSet();
      xrs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
      Resource xmiResource = xrs.getResource(src_xmi_uri, true);
      xmiResource.load(null);
      EcoreUtil2.resolveAll(xmiResource);
      EList<EObject> _contents = xmiResource.getContents();
      EObject model = _contents.get(0);
      TreeIterator<EObject> _eAllContents = model.eAllContents();
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_eAllContents);
      List<EObject> _list = IterableExtensions.<EObject>toList(_iterable);
      final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
        @Override
        public Boolean apply(final EObject elem) {
          return Boolean.valueOf((elem instanceof JvmParameterizedTypeReference));
        }
      };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(_list, _function);
      final Function1<EObject, JvmParameterizedTypeReference> _function_1 = new Function1<EObject, JvmParameterizedTypeReference>() {
        @Override
        public JvmParameterizedTypeReference apply(final EObject elem) {
          return ((JvmParameterizedTypeReference) elem);
        }
      };
      Iterable<JvmParameterizedTypeReference> _map = IterableExtensions.<EObject, JvmParameterizedTypeReference>map(_filter, _function_1);
      List<JvmParameterizedTypeReference> jvmTypes = IterableExtensions.<JvmParameterizedTypeReference>toList(_map);
      for (final JvmParameterizedTypeReference type : jvmTypes) {
        {
          JvmType subType = type.getType();
          boolean _notEquals = (!Objects.equal(subType, null));
          if (_notEquals) {
            this.calculateAndSetSimpleName(subType);
          }
        }
      }
      Resource _createResource = xrs.createResource(trg_uri);
      XtextResource a = ((XtextResource) _createResource);
      EList<EObject> _contents_1 = a.getContents();
      _contents_1.add(model);
      try {
        a.save(null);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void _calculateAndSetSimpleName(final JvmPrimitiveType primitive) {
    URI ref = EcoreUtil.getURI(primitive);
    String _fragment = ref.fragment();
    primitive.setSimpleName(_fragment);
  }
  
  private void _calculateAndSetSimpleName(final JvmGenericType it) {
    String shortName = "";
    String pkgName = null;
    URI ref = EcoreUtil.getURI(it);
    String qualifiedName = ref.fragment();
    boolean _isPlatformResource = ref.isPlatformResource();
    boolean _not = (!_isPlatformResource);
    if (_not) {
      int lastDotPos = qualifiedName.lastIndexOf(".");
      String _substring = qualifiedName.substring((lastDotPos + 1));
      shortName = _substring;
      int _lastIndexOf = qualifiedName.lastIndexOf(".");
      String _substring_1 = qualifiedName.substring(0, _lastIndexOf);
      pkgName = _substring_1;
    }
    it.setSimpleName(shortName);
    it.setPackageName("");
    it.setVisibility(JvmVisibility.PUBLIC);
    it.setDeprecated(false);
    it.setFinal(true);
  }
  
  private void _calculateAndSetSimpleName(final JvmVoid voidType) {
  }
  
  private void calculateAndSetSimpleName(final JvmType it) {
    if (it instanceof JvmGenericType) {
      _calculateAndSetSimpleName((JvmGenericType)it);
      return;
    } else if (it instanceof JvmPrimitiveType) {
      _calculateAndSetSimpleName((JvmPrimitiveType)it);
      return;
    } else if (it instanceof JvmVoid) {
      _calculateAndSetSimpleName((JvmVoid)it);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
