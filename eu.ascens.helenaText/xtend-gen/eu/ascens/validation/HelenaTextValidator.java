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
package eu.ascens.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractDuplicateFreeObject;
import eu.ascens.helenaText.AbstractFieldType;
import eu.ascens.helenaText.AbstractHelenaEntity;
import eu.ascens.helenaText.AbstractRoleInstance;
import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.MsgDirection;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import eu.ascens.helenaText.util.ExtensionMethods;
import eu.ascens.helenaText.util.ExtensionMethods_JvmType;
import eu.ascens.helenaText.util.ExtensionMethods_RoleBehavior;
import eu.ascens.validation.AbstractHelenaTextValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class HelenaTextValidator extends AbstractHelenaTextValidator {
  @Inject
  protected TypeReferenceSerializer serializer;
  
  public final static String HAS_TO_START_LOWERCASE = "lower case";
  
  public final static String HAS_TO_START_UPPERCASE = "upper case";
  
  public final static String NOT_ALLOWED = "not allowed";
  
  public final static String NOT_DISJOINT = "not disjoint";
  
  public final static String MISSING_CONNECTION = "missing connection";
  
  public final static String KEYWORD_NOT_ALLOWED = "keyword is not allowed in this context";
  
  public final static String DUPLICATE = "duplicate";
  
  public final static String MULT_RANGE_WRONG = "multiplicity range wrong";
  
  /**
   * Checks if duplicate elements (component types, role types, ensemble structures, role behaviors) were defined
   */
  @Check
  public void check_model_hasDuplicateModelElements(final Model m) {
    PackageDeclaration _headPkg = m.getHeadPkg();
    EList<ComponentType> _compTypes = _headPkg.getCompTypes();
    this.findDuplicates(_compTypes);
    PackageDeclaration _headPkg_1 = m.getHeadPkg();
    EList<RoleType> _roleTypes = _headPkg_1.getRoleTypes();
    this.findDuplicates(_roleTypes);
    PackageDeclaration _headPkg_2 = m.getHeadPkg();
    EList<EnsembleStructure> _ensStructs = _headPkg_2.getEnsStructs();
    this.findDuplicates(_ensStructs);
    PackageDeclaration _headPkg_3 = m.getHeadPkg();
    EList<RoleBehavior> _roleBehaviors = _headPkg_3.getRoleBehaviors();
    this.findDuplicates(_roleBehaviors);
    PackageDeclaration _headPkg_4 = m.getHeadPkg();
    EList<ComponentType> _compTypes_1 = _headPkg_4.getCompTypes();
    for (final ComponentType ct : _compTypes_1) {
      {
        EList<ComponentAttributeType> _attrs = ct.getAttrs();
        this.findDuplicates(_attrs);
        EList<ComponentAssociationType> _assocs = ct.getAssocs();
        this.findDuplicates(_assocs);
        EList<OperationType> _ops = ct.getOps();
        this.findDuplicates(_ops);
      }
    }
    PackageDeclaration _headPkg_5 = m.getHeadPkg();
    EList<RoleType> _roleTypes_1 = _headPkg_5.getRoleTypes();
    for (final RoleType rt : _roleTypes_1) {
      {
        EList<ComponentType> _compTypes_2 = rt.getCompTypes();
        this.findDuplicates(_compTypes_2, HelenaTextPackage.Literals.ROLE_TYPE__COMP_TYPES);
        EList<RoleAttributeType> _roleattrs = rt.getRoleattrs();
        this.findDuplicates(_roleattrs);
        EList<MessageType> _rolemsgs = rt.getRolemsgs();
        final Function1<MessageType, Boolean> _function = new Function1<MessageType, Boolean>() {
          @Override
          public Boolean apply(final MessageType it) {
            return Boolean.valueOf((Objects.equal(it.getDirection(), MsgDirection.OUT) || Objects.equal(it.getDirection(), MsgDirection.INOUT)));
          }
        };
        Iterable<MessageType> _filter = IterableExtensions.<MessageType>filter(_rolemsgs, _function);
        this.findDuplicates(_filter);
        EList<MessageType> _rolemsgs_1 = rt.getRolemsgs();
        final Function1<MessageType, Boolean> _function_1 = new Function1<MessageType, Boolean>() {
          @Override
          public Boolean apply(final MessageType it) {
            return Boolean.valueOf((Objects.equal(it.getDirection(), MsgDirection.IN) || Objects.equal(it.getDirection(), MsgDirection.INOUT)));
          }
        };
        Iterable<MessageType> _filter_1 = IterableExtensions.<MessageType>filter(_rolemsgs_1, _function_1);
        this.findDuplicates(_filter_1);
      }
    }
    PackageDeclaration _headPkg_6 = m.getHeadPkg();
    EList<EnsembleStructure> _ensStructs_1 = _headPkg_6.getEnsStructs();
    for (final EnsembleStructure es : _ensStructs_1) {
      EList<RoleTypeWithMultiplicity> _rtWithMult = es.getRtWithMult();
      final Function1<RoleTypeWithMultiplicity, RoleType> _function = new Function1<RoleTypeWithMultiplicity, RoleType>() {
        @Override
        public RoleType apply(final RoleTypeWithMultiplicity it) {
          return it.getRoleType();
        }
      };
      List<RoleType> _map = ListExtensions.<RoleTypeWithMultiplicity, RoleType>map(_rtWithMult, _function);
      this.findDuplicates(_map);
    }
    PackageDeclaration _headPkg_7 = m.getHeadPkg();
    EList<RoleBehavior> _roleBehaviors_1 = _headPkg_7.getRoleBehaviors();
    for (final RoleBehavior rb : _roleBehaviors_1) {
      {
        Collection<eu.ascens.helenaText.Process> _processes = ExtensionMethods_RoleBehavior.getProcesses(rb);
        this.findDuplicates(_processes);
        Collection<Label> _labels = ExtensionMethods_RoleBehavior.getLabels(rb);
        this.findDuplicates(_labels);
        List<AbstractDuplicateFreeObject> allVariables = new ArrayList<AbstractDuplicateFreeObject>();
        RoleType _roleTypeRef = rb.getRoleTypeRef();
        EList<RoleAttributeType> _roleattrs = _roleTypeRef.getRoleattrs();
        allVariables.addAll(_roleattrs);
        Collection<AbstractRoleInstance> _abstractRoleInstances = ExtensionMethods_RoleBehavior.getAbstractRoleInstances(rb);
        allVariables.addAll(_abstractRoleInstances);
        Collection<FormalDataParam> _formalDataParams = ExtensionMethods_RoleBehavior.getFormalDataParams(rb);
        allVariables.addAll(_formalDataParams);
        Collection<DataVariable> _opDataVariables = ExtensionMethods_RoleBehavior.getOpDataVariables(rb);
        allVariables.addAll(_opDataVariables);
        this.findDuplicates(allVariables);
      }
    }
  }
  
  /**
   * Checks for duplicates in list. If the method finds a duplicate, an error is raised
   */
  private void findDuplicates(final Iterable<? extends AbstractDuplicateFreeObject> list) {
    this.findDuplicates(list, null);
  }
  
  /**
   * @param list List that is checked for duplicates
   * @param optionalFeature optional structural feature; if this parameter is null the function calculates the corresponding name feature for each list element
   */
  private void findDuplicates(final Iterable<? extends AbstractDuplicateFreeObject> list, final EStructuralFeature optionalFeature) {
    EStructuralFeature feature = optionalFeature;
    Set<String> nameSet = new TreeSet<String>();
    Iterable<? extends AbstractDuplicateFreeObject> _filterNull = IterableExtensions.filterNull(list);
    for (final AbstractDuplicateFreeObject elem : _filterNull) {
      String _name = ExtensionMethods.getName(elem);
      boolean _add = nameSet.add(_name);
      boolean _not = (!_add);
      if (_not) {
        boolean _equals = Objects.equal(feature, null);
        if (_equals) {
          EStructuralFeature _duplicateFreeObjectFeature = HelenaTextValidator.getDuplicateFreeObjectFeature(elem);
          feature = _duplicateFreeObjectFeature;
        }
        String _name_1 = ExtensionMethods.getName(elem);
        String _plus = ("Duplicate declaration of " + _name_1);
        this.error(_plus, elem, feature, 
          HelenaTextValidator.DUPLICATE);
      }
    }
  }
  
  @Check
  public void check_helenaEntity_startsWithUppercase(final AbstractHelenaEntity elem) {
    String _name = elem.getName();
    char _charAt = _name.charAt(0);
    boolean _isUpperCase = Character.isUpperCase(_charAt);
    boolean _not = (!_isUpperCase);
    if (_not) {
      this.warning(
        "Names of declared types should start with a capital letter", 
        HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME, 
        HelenaTextValidator.HAS_TO_START_UPPERCASE);
    }
  }
  
  @Check
  public void check_attrType_startsWithLowercase(final AbstractFieldType attr) {
    String _name = attr.getName();
    char _charAt = _name.charAt(0);
    boolean _isLowerCase = Character.isLowerCase(_charAt);
    boolean _not = (!_isLowerCase);
    if (_not) {
      this.warning(
        "Attribute names should start with a lower-case letter", 
        HelenaTextPackage.Literals.ABSTRACT_FIELD_TYPE__NAME, 
        HelenaTextValidator.HAS_TO_START_LOWERCASE);
    }
  }
  
  @Check
  public void check_messageType_startsWithLowercase(final MessageType mt) {
    String _name = mt.getName();
    char _charAt = _name.charAt(0);
    boolean _isLowerCase = Character.isLowerCase(_charAt);
    boolean _not = (!_isLowerCase);
    if (_not) {
      this.warning(
        "Message or RoleMessage names should start with a lower-case letter", mt, 
        HelenaTextPackage.Literals.MESSAGE_TYPE__NAME, 
        HelenaTextValidator.HAS_TO_START_LOWERCASE);
    }
  }
  
  @Check
  public void check_attrType_ofPromelaType(final RoleAttributeType attr) {
    JvmTypeReference _type = attr.getType();
    JvmType _type_1 = _type.getType();
    boolean _isOfPromelaType = ExtensionMethods_JvmType.isOfPromelaType(_type_1);
    boolean _not = (!_isOfPromelaType);
    if (_not) {
      this.warning(
        "Only attributes of type byte, short, int or boolean can be checked with Promela", 
        HelenaTextPackage.Literals.ROLE_ATTRIBUTE_TYPE__TYPE, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  @Check
  public void check_attrType_ofPromelaType(final ComponentAttributeType attr) {
    JvmTypeReference _type = attr.getType();
    JvmType _type_1 = _type.getType();
    boolean _isOfPromelaType = ExtensionMethods_JvmType.isOfPromelaType(_type_1);
    boolean _not = (!_isOfPromelaType);
    if (_not) {
      this.warning(
        "Only attributes of type byte, short, int or boolean can be checked with Promela", 
        HelenaTextPackage.Literals.COMPONENT_ATTRIBUTE_TYPE__TYPE, 
        HelenaTextValidator.NOT_ALLOWED);
    }
  }
  
  @Check
  public void check_compop_ofPromelaType(final OperationType op) {
    FormalDataParamsBlock _formalDataParamsBlock = op.getFormalDataParamsBlock();
    EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
    for (final FormalDataParam param : _params) {
      JvmTypeReference _type = param.getType();
      JvmType _type_1 = _type.getType();
      boolean _isOfPromelaType = ExtensionMethods_JvmType.isOfPromelaType(_type_1);
      boolean _not = (!_isOfPromelaType);
      if (_not) {
        this.warning(
          "Only parameters of type byte, short, int or boolean can be checked with Promela", 
          HelenaTextPackage.Literals.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  @Check
  public void check_rolemsg_ofPromelaType(final MessageType msg) {
    FormalDataParamsBlock _formalDataParamsBlock = msg.getFormalDataParamsBlock();
    EList<FormalDataParam> _params = _formalDataParamsBlock.getParams();
    for (final FormalDataParam param : _params) {
      JvmTypeReference _type = param.getType();
      JvmType _type_1 = _type.getType();
      boolean _isInt = ExtensionMethods_JvmType.isInt(_type_1);
      boolean _not = (!_isInt);
      if (_not) {
        this.warning(
          "Only parameters of type int can be checked with Promela", 
          HelenaTextPackage.Literals.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  @Check
  public void check_moreThanOneEnsembleStructure(final Model model) {
    if (((!Objects.equal(model.getHeadPkg(), null)) && (((Object[])Conversions.unwrapArray(model.getHeadPkg().getEnsStructs(), Object.class)).length > 1))) {
      PackageDeclaration _headPkg = model.getHeadPkg();
      EList<EnsembleStructure> _ensStructs = _headPkg.getEnsStructs();
      Iterable<EnsembleStructure> _tail = IterableExtensions.<EnsembleStructure>tail(_ensStructs);
      for (final EnsembleStructure es : _tail) {
        this.warning(
          "Only first ensemble structure is used for Promela", es, 
          HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  /**
   * Check if first declared ensemble structure (which is used for Promela)
   * contains all declared role types
   * If not a warning is raised, as Promela cannot handle that
   */
  @Check
  public void check_allRoleTypesInEnsembleStructure(final Model model) {
    if ((((!Objects.equal(model, null)) && (!Objects.equal(model.getHeadPkg(), null))) && (((Object[])Conversions.unwrapArray(model.getHeadPkg().getEnsStructs(), Object.class)).length > 0))) {
      PackageDeclaration _headPkg = model.getHeadPkg();
      EList<EnsembleStructure> _ensStructs = _headPkg.getEnsStructs();
      EnsembleStructure es = IterableExtensions.<EnsembleStructure>head(_ensStructs);
      EList<RoleTypeWithMultiplicity> _rtWithMult = es.getRtWithMult();
      final Function1<RoleTypeWithMultiplicity, RoleType> _function = new Function1<RoleTypeWithMultiplicity, RoleType>() {
        @Override
        public RoleType apply(final RoleTypeWithMultiplicity it) {
          return it.getRoleType();
        }
      };
      final List<RoleType> roleTypesFromEs = ListExtensions.<RoleTypeWithMultiplicity, RoleType>map(_rtWithMult, _function);
      PackageDeclaration _headPkg_1 = model.getHeadPkg();
      final EList<RoleType> declaredRoleTypes = _headPkg_1.getRoleTypes();
      boolean _containsAll = roleTypesFromEs.containsAll(declaredRoleTypes);
      boolean _not = (!_containsAll);
      if (_not) {
        this.error(
          "Promela needs all declared role types to be listed in the first ensemble structure.", es, 
          HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  @Check
  public void check_roleTypeOverMoreThanOneComponentType(final RoleType rt) {
    EList<ComponentType> _compTypes = rt.getCompTypes();
    int _length = ((Object[])Conversions.unwrapArray(_compTypes, Object.class)).length;
    boolean _greaterThan = (_length > 1);
    if (_greaterThan) {
      for (int counter = 1; (counter < ((Object[])Conversions.unwrapArray(rt.getCompTypes(), Object.class)).length); counter++) {
        this.warning(
          "Promela can only handle role types over one component type", 
          HelenaTextPackage.Literals.ROLE_TYPE__COMP_TYPES, counter, 
          HelenaTextValidator.NOT_ALLOWED);
      }
    }
  }
  
  /**
   * Return the EStructuralFeature of an AbstractDuplicateFreeObject
   */
  private static EStructuralFeature getDuplicateFreeObjectFeature(final AbstractDuplicateFreeObject obj) {
    return HelenaTextValidator.getDuplicateFreeObjectFeature_(obj);
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final AbstractFieldType obj) {
    return HelenaTextPackage.Literals.ABSTRACT_FIELD_TYPE__NAME;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final AbstractHelenaEntity obj) {
    return HelenaTextPackage.Literals.ABSTRACT_HELENA_ENTITY__NAME;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final AbstractRoleInstance obj) {
    return HelenaTextPackage.Literals.ABSTRACT_ROLE_INSTANCE__NAME;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final AbstractDataVariable obj) {
    return HelenaTextPackage.Literals.ABSTRACT_DATA_VARIABLE__NAME;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final MessageType obj) {
    return HelenaTextPackage.Literals.MESSAGE_TYPE__NAME;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final OperationType obj) {
    return HelenaTextPackage.Literals.OPERATION_TYPE__NAME;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final RoleBehavior obj) {
    return HelenaTextPackage.Literals.ROLE_BEHAVIOR__ROLE_TYPE_REF;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final Process obj) {
    return HelenaTextPackage.Literals.PROCESS__NAME;
  }
  
  private static EStructuralFeature _getDuplicateFreeObjectFeature_(final Label obj) {
    return HelenaTextPackage.Literals.LABEL__NAME;
  }
  
  private static EStructuralFeature getDuplicateFreeObjectFeature_(final Object obj) {
    if (obj instanceof Label) {
      return _getDuplicateFreeObjectFeature_((Label)obj);
    } else if (obj instanceof AbstractDataVariable) {
      return _getDuplicateFreeObjectFeature_((AbstractDataVariable)obj);
    } else if (obj instanceof AbstractFieldType) {
      return _getDuplicateFreeObjectFeature_((AbstractFieldType)obj);
    } else if (obj instanceof AbstractHelenaEntity) {
      return _getDuplicateFreeObjectFeature_((AbstractHelenaEntity)obj);
    } else if (obj instanceof AbstractRoleInstance) {
      return _getDuplicateFreeObjectFeature_((AbstractRoleInstance)obj);
    } else if (obj instanceof MessageType) {
      return _getDuplicateFreeObjectFeature_((MessageType)obj);
    } else if (obj instanceof OperationType) {
      return _getDuplicateFreeObjectFeature_((OperationType)obj);
    } else if (obj instanceof RoleBehavior) {
      return _getDuplicateFreeObjectFeature_((RoleBehavior)obj);
    } else if (obj instanceof Process) {
      return _getDuplicateFreeObjectFeature_((Process)obj);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj).toString());
    }
  }
}
