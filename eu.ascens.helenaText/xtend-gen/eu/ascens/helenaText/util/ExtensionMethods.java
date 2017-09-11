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
package eu.ascens.helenaText.util;

import com.google.common.base.Objects;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractDuplicateFreeObject;
import eu.ascens.helenaText.AbstractFieldType;
import eu.ascens.helenaText.AbstractHelenaEntity;
import eu.ascens.helenaText.AbstractInstance;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ExtensionMethods {
  protected static String _getName(final AbstractFieldType at) {
    return at.getName();
  }
  
  protected static String _getName(final MessageType mt) {
    return mt.getName();
  }
  
  protected static String _getName(final OperationType mt) {
    return mt.getName();
  }
  
  protected static String _getName(final AbstractHelenaEntity entity) {
    return entity.getName();
  }
  
  protected static String _getName(final RoleBehavior rb) {
    RoleType _roleTypeRef = rb.getRoleTypeRef();
    return _roleTypeRef.getName();
  }
  
  protected static String _getName(final eu.ascens.helenaText.Process process) {
    return process.getName();
  }
  
  protected static String _getName(final Label label) {
    return label.getName();
  }
  
  protected static String _getName(final AbstractRoleInstance inst) {
    return inst.getName();
  }
  
  protected static String _getName(final AbstractDataVariable variable) {
    return variable.getName();
  }
  
  public static String getInstName(final AbstractInstance inst) {
    return ExtensionMethods.getInstName_(inst);
  }
  
  private static String _getInstName_(final AbstractDataVariable dataVar) {
    return dataVar.getName();
  }
  
  private static String _getInstName_(final AbstractRoleInstance roleInst) {
    return roleInst.getName();
  }
  
  public static String getJavaIdentifier(final XExpression expr) {
    boolean _matched = false;
    if ((expr instanceof XStringLiteral)) {
      _matched=true;
      return "java.lang.String";
    }
    if (!_matched) {
      if ((expr instanceof XBooleanLiteral)) {
        _matched=true;
        return "java.lang.Boolean";
      }
    }
    if (!_matched) {
      if ((expr instanceof XNumberLiteral)) {
        _matched=true;
        return "java.lang.Double";
      }
    }
    if (!_matched) {
      if ((expr instanceof XListLiteral)) {
        _matched=true;
        return "java.util.List";
      }
    }
    if (!_matched) {
      if ((expr instanceof XSetLiteral)) {
        _matched=true;
        return "java.util.Set";
      }
    }
    return null;
  }
  
  /**
   * Checks whether all incoming call use the same message
   */
  public static boolean allMsgNamesEqual(final List<IncomingMessageCall> inCalls) {
    final Function1<IncomingMessageCall, Boolean> _function = new Function1<IncomingMessageCall, Boolean>() {
      @Override
      public Boolean apply(final IncomingMessageCall it) {
        String _msgName = it.getMsgName();
        IncomingMessageCall _head = IterableExtensions.<IncomingMessageCall>head(inCalls);
        String _msgName_1 = _head.getMsgName();
        return Boolean.valueOf(Objects.equal(_msgName, _msgName_1));
      }
    };
    return IterableExtensions.<IncomingMessageCall>forall(inCalls, _function);
  }
  
  /**
   * @return All attributes and assocs of a component type
   */
  public static List<AbstractFieldType> getFields(final ComponentType ct) {
    List<AbstractFieldType> fields = new ArrayList<AbstractFieldType>();
    EList<ComponentAttributeType> _attrs = ct.getAttrs();
    fields.addAll(_attrs);
    EList<ComponentAssociationType> _assocs = ct.getAssocs();
    fields.addAll(_assocs);
    return fields;
  }
  
  public static String getName(final AbstractDuplicateFreeObject label) {
    if (label instanceof Label) {
      return _getName((Label)label);
    } else if (label instanceof AbstractDataVariable) {
      return _getName((AbstractDataVariable)label);
    } else if (label instanceof AbstractFieldType) {
      return _getName((AbstractFieldType)label);
    } else if (label instanceof AbstractHelenaEntity) {
      return _getName((AbstractHelenaEntity)label);
    } else if (label instanceof AbstractRoleInstance) {
      return _getName((AbstractRoleInstance)label);
    } else if (label instanceof MessageType) {
      return _getName((MessageType)label);
    } else if (label instanceof OperationType) {
      return _getName((OperationType)label);
    } else if (label instanceof eu.ascens.helenaText.Process) {
      return _getName((eu.ascens.helenaText.Process)label);
    } else if (label instanceof RoleBehavior) {
      return _getName((RoleBehavior)label);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(label).toString());
    }
  }
  
  private static String getInstName_(final EObject dataVar) {
    if (dataVar instanceof AbstractDataVariable) {
      return _getInstName_((AbstractDataVariable)dataVar);
    } else if (dataVar instanceof AbstractRoleInstance) {
      return _getInstName_((AbstractRoleInstance)dataVar);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dataVar).toString());
    }
  }
}
