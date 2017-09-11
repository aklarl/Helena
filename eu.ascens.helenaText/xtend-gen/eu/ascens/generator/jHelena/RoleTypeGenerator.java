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

import com.google.common.base.Objects;
import eu.ascens.generator.jHelena.AbstractFieldTypeGenerator;
import eu.ascens.generator.jHelena.AbstractHelenaTextGenerator;
import eu.ascens.generator.jHelena.ExtensionMethods_jHelenaGenerator;
import eu.ascens.generator.jHelena.GeneratorHelper;
import eu.ascens.generator.jHelena.ImportGenerator;
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.AbstractDataReference;
import eu.ascens.helenaText.AbstractDataValue;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractDataVariableReference;
import eu.ascens.helenaText.AbstractInstance;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.AbstractRoleInstanceReference;
import eu.ascens.helenaText.Action;
import eu.ascens.helenaText.ActionPrefix;
import eu.ascens.helenaText.ActualDataParamsBlock;
import eu.ascens.helenaText.ActualRoleParamsBlock;
import eu.ascens.helenaText.Addition;
import eu.ascens.helenaText.AndTerm;
import eu.ascens.helenaText.Atom;
import eu.ascens.helenaText.BooleanValue;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAssociationTypeReference;
import eu.ascens.helenaText.ComponentAttributeSetter;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentAttributeTypeReference;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.DeclaringRoleBehavior;
import eu.ascens.helenaText.EqualityTerm;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.GuardInParentheses;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.InvokingRoleBehavior;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.NondeterministicChoice;
import eu.ascens.helenaText.NotTerm;
import eu.ascens.helenaText.NumberValue;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OrTerm;
import eu.ascens.helenaText.OutgoingMessageCall;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.PlaysQuery;
import eu.ascens.helenaText.ProcessExpression;
import eu.ascens.helenaText.ProcessInvocation;
import eu.ascens.helenaText.QuitTerm;
import eu.ascens.helenaText.Relation;
import eu.ascens.helenaText.RoleAttributeSetter;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleAttributeTypeReference;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleInstanceReference;
import eu.ascens.helenaText.RoleInstanceVariable;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.SelfReference;
import eu.ascens.helenaText.StringValue;
import eu.ascens.helenaText.Subtraction;
import eu.ascens.helenaText.util.ExtensionMethods;
import eu.ascens.helenaText.util.ExtensionMethods_Action;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.helenaText.util.ExtensionMethods_RoleType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generates Java Code for RoleTypes (abstract and concrete Implementation classes) and
 * returns it to the caller HelenaLanguageGenerator, who creates the Java Files
 */
@SuppressWarnings("all")
public class RoleTypeGenerator extends AbstractHelenaTextGenerator {
  private AbstractFieldTypeGenerator fieldTypeGenerator;
  
  private XbaseCompiler xbase;
  
  protected RoleTypeGenerator(final XbaseCompiler xbase, final TypeReferenceSerializer serializer, final ImportManager im, final GeneratorHelper genHelper) {
    super(serializer, im, genHelper);
    this.xbase = xbase;
    AbstractFieldTypeGenerator _abstractFieldTypeGenerator = new AbstractFieldTypeGenerator(this.serializer, this.im, this.genHelper);
    this.fieldTypeGenerator = _abstractFieldTypeGenerator;
  }
  
  public String compile(final RoleType it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("package ");
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(it);
    _builder.append(_packageName, "\t\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    \t\t");
    String _compileImports = ImportGenerator.compileImports(it, this.im);
    _builder.append(_compileImports, "    \t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public class ");
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname, "\t\t\t");
    _builder.append(" extends Role{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    RoleBehavior rb = ExtensionMethods_RoleType.getRoleBehavior(it);
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    Set<String> classVars = new TreeSet<String>();
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("// role attributes");
    _builder.newLine();
    {
      EList<RoleAttributeType> _roleattrs = it.getRoleattrs();
      for(final RoleAttributeType field : _roleattrs) {
        {
          String _name = field.getName();
          boolean _add = classVars.add(_name);
          if (_add) {
            String _compile = this.fieldTypeGenerator.compile(field, this.im);
            _builder.append(_compile, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t    ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("// self variable");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected final Variable<");
    String _classname_1 = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname_1, "\t\t");
    _builder.append("> self  = new Variable<>(");
    String _classname_2 = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname_2, "\t\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// global variables for behavior");
    _builder.newLine();
    {
      boolean _notEquals = (!Objects.equal(rb, null));
      if (_notEquals) {
        _builder.append("\t\t");
        _builder.newLine();
        {
          Collection<AbstractInstance> _params = ExtensionMethods_RoleBehavior.getParams(rb);
          for(final AbstractInstance inst : _params) {
            _builder.append("\t\t");
            _builder.append("\t");
            String name = ExtensionMethods.getInstName(inst);
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t");
            String type = this.genHelper.getWrappedTypeAsString(inst);
            _builder.newLineIfNotEmpty();
            {
              boolean _add_1 = classVars.add(name);
              if (_add_1) {
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("protected final Variable<");
                _builder.append(type, "\t\t\t");
                _builder.append("> ");
                _builder.append(name, "\t\t\t");
                _builder.append(" = new Variable<>(");
                _builder.append(type, "\t\t\t");
                _builder.append(".");
                _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.newLine();
        {
          Collection<OperationCall> _operationCalls = ExtensionMethods_RoleBehavior.getOperationCalls(rb);
          for(final OperationCall op : _operationCalls) {
            _builder.append("\t\t");
            _builder.append("\t");
            OperationType optype = ExtensionMethods_Action.getOperationType(op);
            _builder.newLineIfNotEmpty();
            {
              if (((!Objects.equal(optype.getReturnType(), null)) && (!ExtensionMethods_JvmType.isVoid(optype.getReturnType().getType())))) {
                _builder.append("\t\t");
                _builder.append("\t");
                JvmTypeReference _returnType = optype.getReturnType();
                String jvmtype = this.genHelper.getWrappedTypeAsString(_returnType);
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("protected final Variable<");
                _builder.append(jvmtype, "\t\t\t\t");
                _builder.append("> ");
                DataVariable _variable = op.getVariable();
                String _name_1 = _variable.getName();
                _builder.append(_name_1, "\t\t\t\t");
                _builder.append(" = new Variable<>(");
                _builder.append(jvmtype, "\t\t\t\t");
                _builder.append(".");
                _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t\t\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("public ");
    String _classname_3 = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname_3, "\t\t\t\t\t");
    _builder.append("(Component comp, Ensemble ens, Integer capacity) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("super(comp, ens, capacity);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.self.setValue(this);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected ProcessExpression initializeRoleBehavior() throws ReflectionException, PropertyNotDeclaredInClassException {");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _compileRoleBehavior = this.compileRoleBehavior(rb);
    _builder.append(_compileRoleBehavior, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String compileImpl(final RoleType it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = ExtensionMethods_jHelenaGenerator.getPackageName(it);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.newLine();
    _builder.append("\t    \t\t");
    String _compileImplImports = ImportGenerator.compileImplImports(it, this.im);
    _builder.append(_compileImplImports, "\t    \t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _implClassname = ExtensionMethods_jHelenaGenerator.getImplClassname(it);
    _builder.append(_implClassname, "");
    _builder.append(" extends ");
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(it);
    _builder.append(_classname, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public ");
    String _implClassname_1 = ExtensionMethods_jHelenaGenerator.getImplClassname(it);
    _builder.append(_implClassname_1, "\t\t");
    _builder.append("(Ensemble ens) {");
    _builder.newLineIfNotEmpty();
    _builder.append("super(ens);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * This compiles a role behavior
   */
  private String _compileRoleBehavior(final InvokingRoleBehavior rb) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Collection<ProcessInvocation> _processInvocations = ExtensionMethods_RoleBehavior.getProcessInvocations(rb);
      for(final ProcessInvocation invoc : _processInvocations) {
        _builder.append("ProcessInvocation invoc");
        int _hashCode = invoc.hashCode();
        _builder.append(_hashCode, "");
        _builder.append(" = new ProcessInvocation();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      EList<eu.ascens.helenaText.Process> _processes = rb.getProcesses();
      for(final eu.ascens.helenaText.Process proc : _processes) {
        _builder.append("ProcessExpression ");
        String _processVarName = this.getProcessVarName(proc);
        _builder.append(_processVarName, "");
        _builder.append(" = ");
        ProcessExpression _processExpr = proc.getProcessExpr();
        String _compileProcExpr = this.compileProcExpr(_processExpr);
        _builder.append(_compileProcExpr, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      Collection<ProcessInvocation> _processInvocations_1 = ExtensionMethods_RoleBehavior.getProcessInvocations(rb);
      for(final ProcessInvocation invoc_1 : _processInvocations_1) {
        _builder.append("invoc");
        int _hashCode_1 = invoc_1.hashCode();
        _builder.append(_hashCode_1, "");
        _builder.append(".setInvocatedProcess(");
        eu.ascens.helenaText.Process _process = invoc_1.getProcess();
        String _processVarName_1 = this.getProcessVarName(_process);
        _builder.append(_processVarName_1, "");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("return ");
    ProcessInvocation _processInvocation = rb.getProcessInvocation();
    eu.ascens.helenaText.Process _process_1 = _processInvocation.getProcess();
    String _processVarName_2 = this.getProcessVarName(_process_1);
    _builder.append(_processVarName_2, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _compileRoleBehavior(final DeclaringRoleBehavior rb) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return ");
    ProcessExpression _processExpr = rb.getProcessExpr();
    String _compileProcExpr = this.compileProcExpr(_processExpr);
    _builder.append(_compileProcExpr, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String getProcessVarName(final eu.ascens.helenaText.Process process) {
    String _name = process.getName();
    return StringExtensions.toFirstLower(_name);
  }
  
  /**
   * This compiles a process term
   */
  private String _compileProcExpr(final QuitTerm nil) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Quit.getInstance()");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileProcExpr(final ActionPrefix actionPrefix) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Action _action = actionPrefix.getAction();
      if ((_action instanceof Label)) {
        ProcessExpression _processExpr = actionPrefix.getProcessExpr();
        String _compileProcExpr = this.compileProcExpr(_processExpr);
        _builder.append(_compileProcExpr, "");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("new ActionPrefix(");
        _builder.newLine();
        _builder.append("\t");
        Action _action_1 = actionPrefix.getAction();
        String _compileAction = this.compileAction(_action_1);
        _builder.append(_compileAction, "\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        ProcessExpression _processExpr_1 = actionPrefix.getProcessExpr();
        String _compileProcExpr_1 = this.compileProcExpr(_processExpr_1);
        _builder.append(_compileProcExpr_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append(")");
        _builder.newLine();
      }
    }
    return _builder.toString();
  }
  
  private String _compileProcExpr(final IfThenElse condSel) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new IfThenElse(");
    _builder.newLine();
    _builder.append("\t");
    Guard _guard = condSel.getGuard();
    String _compileRelation = this.compileRelation(_guard);
    _builder.append(_compileRelation, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ProcessExpression _ifProcessExpr = condSel.getIfProcessExpr();
    String _compileProcExpr = this.compileProcExpr(_ifProcessExpr);
    _builder.append(_compileProcExpr, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ProcessExpression _elseProcessExpr = condSel.getElseProcessExpr();
    String _compileProcExpr_1 = this.compileProcExpr(_elseProcessExpr);
    _builder.append(_compileProcExpr_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileProcExpr(final NondeterministicChoice choice) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new NondeterministicChoice(");
    _builder.newLine();
    _builder.append("\t");
    ProcessExpression _first = choice.getFirst();
    String _compileProcExpr = this.compileProcExpr(_first);
    _builder.append(_compileProcExpr, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ProcessExpression _second = choice.getSecond();
    String _compileProcExpr_1 = this.compileProcExpr(_second);
    _builder.append(_compileProcExpr_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileProcExpr(final ProcessInvocation procInvocation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("invoc");
    int _hashCode = procInvocation.hashCode();
    _builder.append(_hashCode, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  /**
   * This compiles an action
   */
  private String _compileAction(final OutgoingMessageCall msgCall) {
    String _xblockexpression = null;
    {
      ActualRoleParamsBlock _actualRoleParamsBlock = msgCall.getActualRoleParamsBlock();
      EList<RoleInstanceReference> actualRoleParams = _actualRoleParamsBlock.getParams();
      ActualDataParamsBlock _actualDataParamsBlock = msgCall.getActualDataParamsBlock();
      EList<DataExpression> actualDataParams = _actualDataParamsBlock.getParams();
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("new SendMessageAction(");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("this.");
      AbstractRoleInstanceReference _receiver = msgCall.getReceiver();
      AbstractRoleInstance _ref = _receiver.getRef();
      String _instName = ExtensionMethods.getInstName(_ref);
      _builder.append(_instName, "\t");
      _builder.append(",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("new ");
      MessageType _messageType = ExtensionMethods_Action.getMessageType(msgCall);
      String _classname = ExtensionMethods_jHelenaGenerator.getClassname(_messageType);
      _builder.append(_classname, "\t");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      {
        boolean _hasElements = false;
        for(final RoleInstanceReference roleParam : actualRoleParams) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t\t");
          }
          _builder.append("\t\t");
          String _compileRoleInstance = this.compileRoleInstance(roleParam);
          _builder.append(_compileRoleInstance, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      {
        if (((actualRoleParams.size() > 0) && (actualDataParams.size() > 0))) {
          _builder.append(", ");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        boolean _hasElements_1 = false;
        for(final DataExpression dataParam : actualDataParams) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(",", "\t\t");
          }
          _builder.append("\t\t");
          String _compileDataExpressionVariable = this.compileDataExpressionVariable(dataParam);
          _builder.append(_compileDataExpressionVariable, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append(")");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  private String _compileAction(final IncomingMessageCall msgCall) {
    String _xblockexpression = null;
    {
      FormalRoleParamsBlock _formalRoleParamsBlock = msgCall.getFormalRoleParamsBlock();
      EList<FormalRoleParam> roleParams = _formalRoleParamsBlock.getParams();
      FormalDataParamsBlock _formalDataParamsBlock = msgCall.getFormalDataParamsBlock();
      EList<FormalDataParam> dataParams = _formalDataParamsBlock.getParams();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new ReceiveMessageAction(");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new ");
      MessageType _messageType = ExtensionMethods_Action.getMessageType(msgCall);
      String _classname = ExtensionMethods_jHelenaGenerator.getClassname(_messageType);
      _builder.append(_classname, "\t");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      {
        boolean _hasElements = false;
        for(final FormalRoleParam roleParam : roleParams) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t\t");
          }
          _builder.append("\t\t");
          String _instName = ExtensionMethods.getInstName(roleParam);
          _builder.append(_instName, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      {
        if (((roleParams.size() > 0) && (dataParams.size() > 0))) {
          _builder.append(", ");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        boolean _hasElements_1 = false;
        for(final FormalDataParam dataParam : dataParams) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate(",", "\t\t");
          }
          _builder.append("\t\t");
          String _instName_1 = ExtensionMethods.getInstName(dataParam);
          _builder.append(_instName_1, "\t\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append(")");
      _builder.newLine();
      _builder.append(")");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  private String _compileAction(final AbstractAssignment a) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new CreateRoleAction<>(");
    _builder.newLine();
    _builder.append("\t");
    RoleInstanceVariable _roleInst = a.getRoleInst();
    String _instName = ExtensionMethods.getInstName(_roleInst);
    _builder.append(_instName, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    RoleType _roleTypeRef = a.getRoleTypeRef();
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(_roleTypeRef);
    _builder.append(_classname, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ComponentInstance _compInstance = a.getCompInstance();
    String _compileComponentInstance = this.compileComponentInstance(_compInstance);
    _builder.append(_compileComponentInstance, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileAction(final OperationCall opCall) {
    String _xblockexpression = null;
    {
      OperationType optype = ExtensionMethods_Action.getOperationType(opCall);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new OperationCallAction<>(");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new Variable<>(");
      JvmTypeReference _returnType = optype.getReturnType();
      String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(_returnType);
      _builder.append(_wrappedTypeAsString, "\t");
      _builder.append(".");
      _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
      _builder.append("),");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("new ");
      String _classname = ExtensionMethods_jHelenaGenerator.getClassname(optype);
      _builder.append(_classname, "\t");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      {
        ActualDataParamsBlock _actualDataParamsBlock = opCall.getActualDataParamsBlock();
        EList<DataExpression> _params = _actualDataParamsBlock.getParams();
        boolean _hasElements = false;
        for(final DataExpression param : _params) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t");
          }
          _builder.append("\t");
          String _compileDataExpressionVariable = this.compileDataExpressionVariable(param);
          _builder.append(_compileDataExpressionVariable, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("), ");
      _builder.newLine();
      _builder.append("\t");
      JvmTypeReference _returnType_1 = optype.getReturnType();
      String _wrappedTypeAsString_1 = this.genHelper.getWrappedTypeAsString(_returnType_1);
      _builder.append(_wrappedTypeAsString_1, "\t");
      _builder.append(".");
      _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append(")");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  private String _compileAction(final RoleAttributeSetter roleAttrSetter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new RoleAttrSetterAction(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    RoleAttributeTypeReference _attr = roleAttrSetter.getAttr();
    RoleAttributeType _ref = _attr.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    DataExpression _value = roleAttrSetter.getValue();
    String _compileDataExpressionVariable = this.compileDataExpressionVariable(_value);
    _builder.append(_compileDataExpressionVariable, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileAction(final ComponentAttributeSetter compAttrSetter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new CompAttrSetterAction(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    ComponentAttributeTypeReference _attr = compAttrSetter.getAttr();
    ComponentAttributeType _ref = _attr.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    DataExpression _value = compAttrSetter.getValue();
    String _compileDataExpressionVariable = this.compileDataExpressionVariable(_value);
    _builder.append(_compileDataExpressionVariable, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileRelation(final OrTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Guard _right = term.getRight();
      boolean _notEquals = (!Objects.equal(_right, null));
      if (_notEquals) {
        _builder.append("new OrGuard(");
        Guard _left = term.getLeft();
        String _compileRelation = this.compileRelation(_left);
        _builder.append(_compileRelation, "");
        _builder.append(", ");
        Guard _right_1 = term.getRight();
        String _compileRelation_1 = this.compileRelation(_right_1);
        _builder.append(_compileRelation_1, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      } else {
        Guard _left_1 = term.getLeft();
        String _compileRelation_2 = this.compileRelation(_left_1);
        _builder.append(_compileRelation_2, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private String _compileRelation(final AndTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Guard _right = term.getRight();
      boolean _notEquals = (!Objects.equal(_right, null));
      if (_notEquals) {
        _builder.append("new AndGuard(");
        Guard _left = term.getLeft();
        String _compileRelation = this.compileRelation(_left);
        _builder.append(_compileRelation, "");
        _builder.append(", ");
        Guard _right_1 = term.getRight();
        String _compileRelation_1 = this.compileRelation(_right_1);
        _builder.append(_compileRelation_1, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      } else {
        Guard _left_1 = term.getLeft();
        String _compileRelation_2 = this.compileRelation(_left_1);
        _builder.append(_compileRelation_2, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private String _compileRelation(final EqualityTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Guard _right = term.getRight();
      boolean _notEquals = (!Objects.equal(_right, null));
      if (_notEquals) {
        _builder.append("new ComposedExpression(");
        _builder.newLine();
        _builder.append("\t");
        Guard _left = term.getLeft();
        String _compileRelation = this.compileRelation(_left);
        _builder.append(_compileRelation, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(",");
        _builder.newLine();
        {
          String _operator = term.getOperator();
          boolean _equals = Objects.equal(_operator, "==");
          if (_equals) {
            _builder.append("\t");
            _builder.append("ExpressionOperator.EQUAL");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("ExpressionOperator.UNEQUAL");
            _builder.newLine();
          }
        }
        _builder.append("\t");
        _builder.append(",");
        _builder.newLine();
        _builder.append("\t ");
        Guard _right_1 = term.getRight();
        String _compileRelation_1 = this.compileRelation(_right_1);
        _builder.append(_compileRelation_1, "\t ");
        _builder.newLineIfNotEmpty();
        _builder.append(")");
        _builder.newLine();
      } else {
        Guard _left_1 = term.getLeft();
        String _compileRelation_2 = this.compileRelation(_left_1);
        _builder.append(_compileRelation_2, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private String _compileRelation(final NotTerm term) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _not = term.getNot();
      boolean _notEquals = (!Objects.equal(_not, null));
      if (_notEquals) {
        _builder.append("new NotGuard(");
        Atom _atom = term.getAtom();
        String _compileAtom = this.compileAtom(_atom);
        _builder.append(_compileAtom, "");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      } else {
        Atom _atom_1 = term.getAtom();
        String _compileAtom_1 = this.compileAtom(_atom_1);
        _builder.append(_compileAtom_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  private String _compileAtom(final Addition atom) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Atom(");
    DataExpression _left = atom.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "");
    _builder.append(" + ");
    DataExpression _right = atom.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  private String _compileAtom(final Subtraction atom) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Atom(");
    DataExpression _left = atom.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "");
    _builder.append(" - ");
    DataExpression _right = atom.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  private String _compileAtom(final AbstractDataValue atom) {
    return this.compileDataExpressionAtom(atom);
  }
  
  private String _compileAtom(final AbstractDataReference atom) {
    return this.compileDataExpressionAtom(atom);
  }
  
  private String _compileAtom(final PlaysQuery atom) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new PlaysQuery(");
    _builder.newLine();
    _builder.append("\t");
    ComponentInstance _compInstance = atom.getCompInstance();
    String _compileComponentInstance = this.compileComponentInstance(_compInstance);
    _builder.append(_compileComponentInstance, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    RoleType _roleTypeRef = atom.getRoleTypeRef();
    String _classname = ExtensionMethods_jHelenaGenerator.getClassname(_roleTypeRef);
    _builder.append(_classname, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileAtom(final Relation term) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Atom(");
    _builder.newLine();
    _builder.append("\t");
    DataExpression _left = term.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "\t");
    _builder.append(" ");
    String _operator = term.getOperator();
    _builder.append(_operator, "\t");
    _builder.append(" ");
    DataExpression _right = term.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileAtom(final GuardInParentheses atom) {
    StringConcatenation _builder = new StringConcatenation();
    Guard _guard = atom.getGuard();
    String _compileRelation = this.compileRelation(_guard);
    _builder.append(_compileRelation, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _compileComponentInstance(final ComponentAssociationTypeReference compInst) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new CompAssociationGetter(\"");
    ComponentAssociationType _ref = compInst.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "");
    _builder.append("\").getValue(this)");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _compileComponentInstance(final OwnerReference compInst) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.getOwner()");
    return _builder.toString();
  }
  
  private String _compileRoleInstance(final AbstractRoleInstanceReference roleInstRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    AbstractRoleInstance _ref = roleInstRef.getRef();
    String _instName = ExtensionMethods.getInstName(_ref);
    _builder.append(_instName, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _compileRoleInstance(final SelfReference selfRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.self");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final AbstractDataVariableReference dataVarRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    AbstractDataVariable _ref = dataVarRef.getRef();
    String _instName = ExtensionMethods.getInstName(_ref);
    _builder.append(_instName, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final RoleAttributeTypeReference roleAttrTypeRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Variable<>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new RoleAttrGetter<>(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"");
    RoleAttributeType _ref = roleAttrTypeRef.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    RoleAttributeType _ref_1 = roleAttrTypeRef.getRef();
    String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(_ref_1);
    _builder.append(_wrappedTypeAsString, "\t\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(").getValue(this),");
    _builder.newLine();
    _builder.append("\t");
    RoleAttributeType _ref_2 = roleAttrTypeRef.getRef();
    String _wrappedTypeAsString_1 = this.genHelper.getWrappedTypeAsString(_ref_2);
    _builder.append(_wrappedTypeAsString_1, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final ComponentAttributeTypeReference compAttrTypeRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Variable<>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new CompAttrGetter<>(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\"");
    ComponentAttributeType _ref = compAttrTypeRef.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    ComponentAttributeType _ref_1 = compAttrTypeRef.getRef();
    String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(_ref_1);
    _builder.append(_wrappedTypeAsString, "\t\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(").getValue(this),");
    _builder.newLine();
    _builder.append("\t");
    ComponentAttributeType _ref_2 = compAttrTypeRef.getRef();
    String _wrappedTypeAsString_1 = this.genHelper.getWrappedTypeAsString(_ref_2);
    _builder.append(_wrappedTypeAsString_1, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final BooleanValue expr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Variable<Boolean>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new Boolean(");
    XExpression _value = expr.getValue();
    String _compile = this.compile(_value);
    _builder.append(_compile, "\t");
    _builder.append("),");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Boolean.");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final NumberValue expr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Variable<Double>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new Double(");
    XExpression _value = expr.getValue();
    String _compile = this.compile(_value);
    _builder.append(_compile, "\t");
    _builder.append("),");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Double.");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final StringValue expr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Variable<String>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new String(");
    XExpression _value = expr.getValue();
    String _compile = this.compile(_value);
    _builder.append(_compile, "\t");
    _builder.append("),");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("String.");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final Addition exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Variable<>(");
    _builder.newLine();
    _builder.append("\t");
    DataExpression _left = exp.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "\t");
    _builder.append(" + ");
    DataExpression _right = exp.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Double.");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionVariable(final Subtraction exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Variable<>(");
    _builder.newLine();
    _builder.append("\t");
    DataExpression _left = exp.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "\t");
    _builder.append(" - ");
    DataExpression _right = exp.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Double.");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpression(final AbstractDataVariableReference dataVarRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("this.");
    AbstractDataVariable _ref = dataVarRef.getRef();
    String _instName = ExtensionMethods.getInstName(_ref);
    _builder.append(_instName, "");
    _builder.append(".getValue()");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _compileDataExpression(final RoleAttributeTypeReference roleAttrTypeRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new RoleAttrGetter<>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    RoleAttributeType _ref = roleAttrTypeRef.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    RoleAttributeType _ref_1 = roleAttrTypeRef.getRef();
    String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(_ref_1);
    _builder.append(_wrappedTypeAsString, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(").getValue(this)");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpression(final ComponentAttributeTypeReference compAttrTypeRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new CompAttrGetter<>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    ComponentAttributeType _ref = compAttrTypeRef.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ComponentAttributeType _ref_1 = compAttrTypeRef.getRef();
    String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(_ref_1);
    _builder.append(_wrappedTypeAsString, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(").getValue(this)");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpression(final AbstractDataValue expr) {
    StringConcatenation _builder = new StringConcatenation();
    XExpression _value = expr.getValue();
    String _compile = this.compile(_value);
    _builder.append(_compile, "");
    return _builder.toString();
  }
  
  private String _compileDataExpression(final Addition exp) {
    StringConcatenation _builder = new StringConcatenation();
    DataExpression _left = exp.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "");
    _builder.append(" + ");
    DataExpression _right = exp.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "");
    return _builder.toString();
  }
  
  private String _compileDataExpression(final Subtraction exp) {
    StringConcatenation _builder = new StringConcatenation();
    DataExpression _left = exp.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "");
    _builder.append(" - ");
    DataExpression _right = exp.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "");
    return _builder.toString();
  }
  
  private String _compileDataExpressionAtom(final AbstractDataVariableReference dataVarRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Atom(this.");
    AbstractDataVariable _ref = dataVarRef.getRef();
    String _instName = ExtensionMethods.getInstName(_ref);
    _builder.append(_instName, "");
    _builder.append(".getValue())");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  private String _compileDataExpressionAtom(final RoleAttributeTypeReference roleAttrTypeRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new RoleAttrGetter<>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    RoleAttributeType _ref = roleAttrTypeRef.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    RoleAttributeType _ref_1 = roleAttrTypeRef.getRef();
    String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(_ref_1);
    _builder.append(_wrappedTypeAsString, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionAtom(final ComponentAttributeTypeReference compAttrTypeRef) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new CompAttrGetter<>(");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    ComponentAttributeType _ref = compAttrTypeRef.getRef();
    String _name = _ref.getName();
    _builder.append(_name, "\t");
    _builder.append("\", ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ComponentAttributeType _ref_1 = compAttrTypeRef.getRef();
    String _wrappedTypeAsString = this.genHelper.getWrappedTypeAsString(_ref_1);
    _builder.append(_wrappedTypeAsString, "\t");
    _builder.append(".");
    _builder.append(AbstractHelenaTextGenerator.CLASS_EXTENSION, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append(")");
    _builder.newLine();
    return _builder.toString();
  }
  
  private String _compileDataExpressionAtom(final AbstractDataValue expr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Atom(");
    XExpression _value = expr.getValue();
    String _compile = this.compile(_value);
    _builder.append(_compile, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  private String _compileDataExpressionAtom(final Addition exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Atom(");
    DataExpression _left = exp.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "");
    _builder.append(" + ");
    DataExpression _right = exp.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  private String _compileDataExpressionAtom(final Subtraction exp) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new Atom(");
    DataExpression _left = exp.getLeft();
    String _compileDataExpression = this.compileDataExpression(_left);
    _builder.append(_compileDataExpression, "");
    _builder.append(" - ");
    DataExpression _right = exp.getRight();
    String _compileDataExpression_1 = this.compileDataExpression(_right);
    _builder.append(_compileDataExpression_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  private String compile(final XExpression expr) {
    final FakeTreeAppendable result = new FakeTreeAppendable(this.im);
    try {
      this.xbase.toJavaExpression(expr, result);
    } catch (final Throwable _t) {
      if (_t instanceof NullPointerException) {
        final NullPointerException e = (NullPointerException)_t;
        System.err.println("Error in toJavaStatement");
        return "error";
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return result.toString();
  }
  
  private String compileRoleBehavior(final RoleBehavior rb) {
    if (rb instanceof DeclaringRoleBehavior) {
      return _compileRoleBehavior((DeclaringRoleBehavior)rb);
    } else if (rb instanceof InvokingRoleBehavior) {
      return _compileRoleBehavior((InvokingRoleBehavior)rb);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(rb).toString());
    }
  }
  
  private String compileProcExpr(final ProcessExpression actionPrefix) {
    if (actionPrefix instanceof ActionPrefix) {
      return _compileProcExpr((ActionPrefix)actionPrefix);
    } else if (actionPrefix instanceof IfThenElse) {
      return _compileProcExpr((IfThenElse)actionPrefix);
    } else if (actionPrefix instanceof NondeterministicChoice) {
      return _compileProcExpr((NondeterministicChoice)actionPrefix);
    } else if (actionPrefix instanceof ProcessInvocation) {
      return _compileProcExpr((ProcessInvocation)actionPrefix);
    } else if (actionPrefix instanceof QuitTerm) {
      return _compileProcExpr((QuitTerm)actionPrefix);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(actionPrefix).toString());
    }
  }
  
  private String compileAction(final Action msgCall) {
    if (msgCall instanceof IncomingMessageCall) {
      return _compileAction((IncomingMessageCall)msgCall);
    } else if (msgCall instanceof OutgoingMessageCall) {
      return _compileAction((OutgoingMessageCall)msgCall);
    } else if (msgCall instanceof AbstractAssignment) {
      return _compileAction((AbstractAssignment)msgCall);
    } else if (msgCall instanceof ComponentAttributeSetter) {
      return _compileAction((ComponentAttributeSetter)msgCall);
    } else if (msgCall instanceof OperationCall) {
      return _compileAction((OperationCall)msgCall);
    } else if (msgCall instanceof RoleAttributeSetter) {
      return _compileAction((RoleAttributeSetter)msgCall);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(msgCall).toString());
    }
  }
  
  private String compileRelation(final Guard term) {
    if (term instanceof AndTerm) {
      return _compileRelation((AndTerm)term);
    } else if (term instanceof EqualityTerm) {
      return _compileRelation((EqualityTerm)term);
    } else if (term instanceof NotTerm) {
      return _compileRelation((NotTerm)term);
    } else if (term instanceof OrTerm) {
      return _compileRelation((OrTerm)term);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(term).toString());
    }
  }
  
  private String compileAtom(final Atom atom) {
    if (atom instanceof AbstractDataReference) {
      return _compileAtom((AbstractDataReference)atom);
    } else if (atom instanceof AbstractDataValue) {
      return _compileAtom((AbstractDataValue)atom);
    } else if (atom instanceof Addition) {
      return _compileAtom((Addition)atom);
    } else if (atom instanceof Subtraction) {
      return _compileAtom((Subtraction)atom);
    } else if (atom instanceof GuardInParentheses) {
      return _compileAtom((GuardInParentheses)atom);
    } else if (atom instanceof PlaysQuery) {
      return _compileAtom((PlaysQuery)atom);
    } else if (atom instanceof Relation) {
      return _compileAtom((Relation)atom);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(atom).toString());
    }
  }
  
  private String compileComponentInstance(final ComponentInstance compInst) {
    if (compInst instanceof ComponentAssociationTypeReference) {
      return _compileComponentInstance((ComponentAssociationTypeReference)compInst);
    } else if (compInst instanceof OwnerReference) {
      return _compileComponentInstance((OwnerReference)compInst);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(compInst).toString());
    }
  }
  
  private String compileRoleInstance(final RoleInstanceReference roleInstRef) {
    if (roleInstRef instanceof AbstractRoleInstanceReference) {
      return _compileRoleInstance((AbstractRoleInstanceReference)roleInstRef);
    } else if (roleInstRef instanceof SelfReference) {
      return _compileRoleInstance((SelfReference)roleInstRef);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(roleInstRef).toString());
    }
  }
  
  private String compileDataExpressionVariable(final DataExpression dataVarRef) {
    if (dataVarRef instanceof AbstractDataVariableReference) {
      return _compileDataExpressionVariable((AbstractDataVariableReference)dataVarRef);
    } else if (dataVarRef instanceof BooleanValue) {
      return _compileDataExpressionVariable((BooleanValue)dataVarRef);
    } else if (dataVarRef instanceof ComponentAttributeTypeReference) {
      return _compileDataExpressionVariable((ComponentAttributeTypeReference)dataVarRef);
    } else if (dataVarRef instanceof NumberValue) {
      return _compileDataExpressionVariable((NumberValue)dataVarRef);
    } else if (dataVarRef instanceof RoleAttributeTypeReference) {
      return _compileDataExpressionVariable((RoleAttributeTypeReference)dataVarRef);
    } else if (dataVarRef instanceof StringValue) {
      return _compileDataExpressionVariable((StringValue)dataVarRef);
    } else if (dataVarRef instanceof Addition) {
      return _compileDataExpressionVariable((Addition)dataVarRef);
    } else if (dataVarRef instanceof Subtraction) {
      return _compileDataExpressionVariable((Subtraction)dataVarRef);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dataVarRef).toString());
    }
  }
  
  private String compileDataExpression(final DataExpression dataVarRef) {
    if (dataVarRef instanceof AbstractDataVariableReference) {
      return _compileDataExpression((AbstractDataVariableReference)dataVarRef);
    } else if (dataVarRef instanceof ComponentAttributeTypeReference) {
      return _compileDataExpression((ComponentAttributeTypeReference)dataVarRef);
    } else if (dataVarRef instanceof RoleAttributeTypeReference) {
      return _compileDataExpression((RoleAttributeTypeReference)dataVarRef);
    } else if (dataVarRef instanceof AbstractDataValue) {
      return _compileDataExpression((AbstractDataValue)dataVarRef);
    } else if (dataVarRef instanceof Addition) {
      return _compileDataExpression((Addition)dataVarRef);
    } else if (dataVarRef instanceof Subtraction) {
      return _compileDataExpression((Subtraction)dataVarRef);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dataVarRef).toString());
    }
  }
  
  private String compileDataExpressionAtom(final DataExpression dataVarRef) {
    if (dataVarRef instanceof AbstractDataVariableReference) {
      return _compileDataExpressionAtom((AbstractDataVariableReference)dataVarRef);
    } else if (dataVarRef instanceof ComponentAttributeTypeReference) {
      return _compileDataExpressionAtom((ComponentAttributeTypeReference)dataVarRef);
    } else if (dataVarRef instanceof RoleAttributeTypeReference) {
      return _compileDataExpressionAtom((RoleAttributeTypeReference)dataVarRef);
    } else if (dataVarRef instanceof AbstractDataValue) {
      return _compileDataExpressionAtom((AbstractDataValue)dataVarRef);
    } else if (dataVarRef instanceof Addition) {
      return _compileDataExpressionAtom((Addition)dataVarRef);
    } else if (dataVarRef instanceof Subtraction) {
      return _compileDataExpressionAtom((Subtraction)dataVarRef);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dataVarRef).toString());
    }
  }
}
