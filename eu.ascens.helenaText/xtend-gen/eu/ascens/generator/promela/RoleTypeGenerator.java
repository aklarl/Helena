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

import com.google.common.base.Objects;
import com.google.inject.Inject;
import eu.ascens.generator.promela.NameGenerator;
import eu.ascens.generator.promela.ProcessExpressionGenerator;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.DeclaringRoleBehavior;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.InvokingRoleBehavior;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.ProcessExpression;
import eu.ascens.helenaText.ProcessInvocation;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.util.ExtensionMethods_Action;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RoleTypeGenerator {
  @Inject
  private ProcessExpressionGenerator procTermGenerator;
  
  /**
   * Compiles the process type for a role behavior:
   * - role type attributes, component type attributes, component type associations become local variables
   * - for all plays queries, local variable are generated (to avoid redeclaration)
   * - the role behavior is compiled
   */
  public CharSequence compileProctype(final RoleType rt, final Model model) {
    CharSequence _xblockexpression = null;
    {
      PackageDeclaration _headPkg = model.getHeadPkg();
      EList<RoleBehavior> _roleBehaviors = _headPkg.getRoleBehaviors();
      final Function1<RoleBehavior, Boolean> _function = new Function1<RoleBehavior, Boolean>() {
        @Override
        public Boolean apply(final RoleBehavior it) {
          RoleType _roleTypeRef = it.getRoleTypeRef();
          return Boolean.valueOf(Objects.equal(_roleTypeRef, rt));
        }
      };
      RoleBehavior rb = IterableExtensions.<RoleBehavior>findFirst(_roleBehaviors, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/////////////// process definition for role type ");
      RoleType _roleTypeRef = rb.getRoleTypeRef();
      String _proctypeName = NameGenerator.getProctypeName(_roleTypeRef);
      _builder.append(_proctypeName, "");
      _builder.append(" ////////////////////");
      _builder.newLineIfNotEmpty();
      _builder.append("proctype ");
      RoleType _roleTypeRef_1 = rb.getRoleTypeRef();
      String _proctypeName_1 = NameGenerator.getProctypeName(_roleTypeRef_1);
      _builder.append(_proctypeName_1, "");
      _builder.append("(chan owner, self) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("// role type attributes");
      _builder.newLine();
      {
        EList<RoleAttributeType> _roleattrs = rt.getRoleattrs();
        for(final RoleAttributeType attr : _roleattrs) {
          _builder.append("\t");
          JvmTypeReference _type = attr.getType();
          String _promelaType = NameGenerator.getPromelaType(_type);
          _builder.append(_promelaType, "\t");
          _builder.append(" ");
          String _variableName = NameGenerator.getVariableName(attr);
          _builder.append(_variableName, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// component type attributes");
      _builder.newLine();
      {
        ComponentType _ownerComponentType = ExtensionMethods_RoleType.getOwnerComponentType(rt);
        EList<ComponentAttributeType> _attrs = _ownerComponentType.getAttrs();
        for(final ComponentAttributeType attr_1 : _attrs) {
          _builder.append("\t");
          JvmTypeReference _type_1 = attr_1.getType();
          String _promelaType_1 = NameGenerator.getPromelaType(_type_1);
          _builder.append(_promelaType_1, "\t");
          _builder.append(" ");
          String _variableName_1 = NameGenerator.getVariableName(attr_1);
          _builder.append(_variableName_1, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// component type associations");
      _builder.newLine();
      {
        ComponentType _ownerComponentType_1 = ExtensionMethods_RoleType.getOwnerComponentType(rt);
        EList<ComponentAssociationType> _assocs = _ownerComponentType_1.getAssocs();
        for(final ComponentAssociationType assoc : _assocs) {
          _builder.append("\t");
          _builder.append("chan ");
          String _variableName_2 = NameGenerator.getVariableName(assoc);
          _builder.append(_variableName_2, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// local variables for all role instance variables (of create/get and incoming messages)");
      _builder.newLine();
      {
        Collection<AbstractRoleInstance> _abstractRoleInstances = ExtensionMethods_RoleBehavior.getAbstractRoleInstances(rb);
        for(final AbstractRoleInstance inst : _abstractRoleInstances) {
          _builder.append("\t");
          _builder.append("chan ");
          String _variableName_3 = NameGenerator.getVariableName(inst);
          _builder.append(_variableName_3, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// local variables for all formal data parameters (of incoming messages)");
      _builder.newLine();
      {
        Collection<FormalDataParam> _formalDataParams = ExtensionMethods_RoleBehavior.getFormalDataParams(rb);
        for(final FormalDataParam param : _formalDataParams) {
          _builder.append("\t");
          JvmTypeReference _type_2 = param.getType();
          String _promelaType_2 = NameGenerator.getPromelaType(_type_2);
          _builder.append(_promelaType_2, "\t");
          _builder.append(" ");
          String _varName = NameGenerator.getVarName(param);
          _builder.append(_varName, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// local variables for all return values of operations");
      _builder.newLine();
      {
        Collection<OperationCall> _operationCalls = ExtensionMethods_RoleBehavior.getOperationCalls(rb);
        for(final OperationCall op : _operationCalls) {
          _builder.append("\t");
          OperationType optype = ExtensionMethods_Action.getOperationType(op);
          _builder.newLineIfNotEmpty();
          {
            if (((!Objects.equal(optype.getReturnType(), null)) && (!ExtensionMethods_JvmType.isVoid(optype.getReturnType().getType())))) {
              _builder.append("\t");
              JvmTypeReference _returnType = optype.getReturnType();
              String _promelaType_3 = NameGenerator.getPromelaType(_returnType);
              _builder.append(_promelaType_3, "\t");
              _builder.append(" ");
              DataVariable _variable = op.getVariable();
              String _varName_1 = NameGenerator.getVarName(_variable);
              _builder.append(_varName_1, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// local variables for all plays queries");
      _builder.newLine();
      {
        Collection<PlaysQuery> _playsQueries = ExtensionMethods_RoleBehavior.getPlaysQueries(rb);
        for(final PlaysQuery query : _playsQueries) {
          _builder.append("\t");
          _builder.append("bool ");
          String _variableName_4 = NameGenerator.getVariableName(query);
          _builder.append(_variableName_4, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// start label");
      _builder.newLine();
      _builder.append("\t");
      String _startLabelName = NameGenerator.getStartLabelName(rt);
      _builder.append(_startLabelName, "\t");
      _builder.append(": true;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//////// role behavior //////////");
      _builder.newLine();
      _builder.append("\t");
      CharSequence _compileRoleBehavior = this.compileRoleBehavior(rb);
      _builder.append(_compileRoleBehavior, "\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      String _endLabelName = NameGenerator.getEndLabelName(rt);
      _builder.append(_endLabelName, "\t");
      _builder.append(": false");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  /**
   * Compiles a role behavior:
   * - action prefix is realized with sequential composition
   * - conditional selection is realized with if-selection
   * - process invocation is realized with labels and gotos since we cannot use inline method with interlaced recursive processes
   */
  private CharSequence _compileRoleBehavior(final DeclaringRoleBehavior rb) {
    StringConcatenation _builder = new StringConcatenation();
    ProcessExpression _processExpr = rb.getProcessExpr();
    ArrayList<eu.ascens.helenaText.Process> _arrayList = new ArrayList<eu.ascens.helenaText.Process>();
    CharSequence _compileProcExpr = this.procTermGenerator.compileProcExpr(_processExpr, _arrayList);
    _builder.append(_compileProcExpr, "");
    return _builder;
  }
  
  private CharSequence _compileRoleBehavior(final InvokingRoleBehavior rb) {
    StringConcatenation _builder = new StringConcatenation();
    ProcessInvocation _processInvocation = rb.getProcessInvocation();
    ArrayList<eu.ascens.helenaText.Process> _arrayList = new ArrayList<eu.ascens.helenaText.Process>();
    CharSequence _compileProcExpr = this.procTermGenerator.compileProcExpr(_processInvocation, _arrayList);
    _builder.append(_compileProcExpr, "");
    return _builder;
  }
  
  private CharSequence compileRoleBehavior(final RoleBehavior rb) {
    if (rb instanceof DeclaringRoleBehavior) {
      return _compileRoleBehavior((DeclaringRoleBehavior)rb);
    } else if (rb instanceof InvokingRoleBehavior) {
      return _compileRoleBehavior((InvokingRoleBehavior)rb);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(rb).toString());
    }
  }
}
