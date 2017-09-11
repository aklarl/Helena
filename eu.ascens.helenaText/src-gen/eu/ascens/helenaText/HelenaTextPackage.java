/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.ascens.helenaText.HelenaTextFactory
 * @model kind="package"
 * @generated
 */
public interface HelenaTextPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "helenaText";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.ascens.eu/HelenaText";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "helenaText";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HelenaTextPackage eINSTANCE = eu.ascens.helenaText.impl.HelenaTextPackageImpl.init();

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ModelImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Head Pkg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__HEAD_PKG = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.PackageDeclarationImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getPackageDeclaration()
   * @generated
   */
  int PACKAGE_DECLARATION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Comp Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__COMP_TYPES = 1;

  /**
   * The feature id for the '<em><b>Role Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__ROLE_TYPES = 2;

  /**
   * The feature id for the '<em><b>Ens Structs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__ENS_STRUCTS = 3;

  /**
   * The feature id for the '<em><b>Role Behaviors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__ROLE_BEHAVIORS = 4;

  /**
   * The number of structural features of the '<em>Package Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractDuplicateFreeObjectImpl <em>Abstract Duplicate Free Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractDuplicateFreeObjectImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDuplicateFreeObject()
   * @generated
   */
  int ABSTRACT_DUPLICATE_FREE_OBJECT = 57;

  /**
   * The number of structural features of the '<em>Abstract Duplicate Free Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractHelenaEntityImpl <em>Abstract Helena Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractHelenaEntityImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractHelenaEntity()
   * @generated
   */
  int ABSTRACT_HELENA_ENTITY = 58;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_HELENA_ENTITY__NAME = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Helena Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_HELENA_ENTITY_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ComponentTypeImpl <em>Component Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ComponentTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentType()
   * @generated
   */
  int COMPONENT_TYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_TYPE__NAME = ABSTRACT_HELENA_ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Attrs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_TYPE__ATTRS = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Assocs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_TYPE__ASSOCS = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ops</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_TYPE__OPS = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Component Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_TYPE_FEATURE_COUNT = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractFieldTypeImpl <em>Abstract Field Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractFieldTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractFieldType()
   * @generated
   */
  int ABSTRACT_FIELD_TYPE = 59;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FIELD_TYPE__NAME = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FIELD_TYPE_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractComponentFieldTypeImpl <em>Abstract Component Field Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractComponentFieldTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractComponentFieldType()
   * @generated
   */
  int ABSTRACT_COMPONENT_FIELD_TYPE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT_FIELD_TYPE__NAME = ABSTRACT_FIELD_TYPE__NAME;

  /**
   * The number of structural features of the '<em>Abstract Component Field Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT_FIELD_TYPE_FEATURE_COUNT = ABSTRACT_FIELD_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ComponentAttributeTypeImpl <em>Component Attribute Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ComponentAttributeTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAttributeType()
   * @generated
   */
  int COMPONENT_ATTRIBUTE_TYPE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_TYPE__NAME = ABSTRACT_COMPONENT_FIELD_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_TYPE__TYPE = ABSTRACT_COMPONENT_FIELD_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Component Attribute Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_TYPE_FEATURE_COUNT = ABSTRACT_COMPONENT_FIELD_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ComponentAssociationTypeImpl <em>Component Association Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ComponentAssociationTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAssociationType()
   * @generated
   */
  int COMPONENT_ASSOCIATION_TYPE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ASSOCIATION_TYPE__NAME = ABSTRACT_COMPONENT_FIELD_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ASSOCIATION_TYPE__TYPE = ABSTRACT_COMPONENT_FIELD_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Component Association Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ASSOCIATION_TYPE_FEATURE_COUNT = ABSTRACT_COMPONENT_FIELD_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.OperationTypeImpl <em>Operation Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.OperationTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOperationType()
   * @generated
   */
  int OPERATION_TYPE = 6;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_TYPE__RETURN_TYPE = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_TYPE__NAME = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Formal Data Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Operation Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_TYPE_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleTypeImpl <em>Role Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleType()
   * @generated
   */
  int ROLE_TYPE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE__NAME = ABSTRACT_HELENA_ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Comp Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE__COMP_TYPES = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Roleattrs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE__ROLEATTRS = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rolemsgs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE__ROLEMSGS = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Role Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE_FEATURE_COUNT = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleAttributeTypeImpl <em>Role Attribute Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleAttributeTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleAttributeType()
   * @generated
   */
  int ROLE_ATTRIBUTE_TYPE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_TYPE__NAME = ABSTRACT_FIELD_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_TYPE__TYPE = ABSTRACT_FIELD_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Role Attribute Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_TYPE_FEATURE_COUNT = ABSTRACT_FIELD_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.MessageTypeImpl <em>Message Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.MessageTypeImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getMessageType()
   * @generated
   */
  int MESSAGE_TYPE = 9;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_TYPE__DIRECTION = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_TYPE__NAME = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Formal Role Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Formal Data Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Message Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MESSAGE_TYPE_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.EnsembleStructureImpl <em>Ensemble Structure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.EnsembleStructureImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getEnsembleStructure()
   * @generated
   */
  int ENSEMBLE_STRUCTURE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENSEMBLE_STRUCTURE__NAME = ABSTRACT_HELENA_ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Rt With Mult</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENSEMBLE_STRUCTURE__RT_WITH_MULT = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Ensemble Structure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENSEMBLE_STRUCTURE_FEATURE_COUNT = ABSTRACT_HELENA_ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl <em>Role Type With Multiplicity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleTypeWithMultiplicity()
   * @generated
   */
  int ROLE_TYPE_WITH_MULTIPLICITY = 11;

  /**
   * The feature id for the '<em><b>Role Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Min</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE_WITH_MULTIPLICITY__MIN = 1;

  /**
   * The feature id for the '<em><b>Max</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE_WITH_MULTIPLICITY__MAX = 2;

  /**
   * The feature id for the '<em><b>Capacity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY = 3;

  /**
   * The number of structural features of the '<em>Role Type With Multiplicity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_TYPE_WITH_MULTIPLICITY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleBehaviorImpl <em>Role Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleBehaviorImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleBehavior()
   * @generated
   */
  int ROLE_BEHAVIOR = 12;

  /**
   * The feature id for the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_BEHAVIOR__ROLE_TYPE_REF = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Role Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_BEHAVIOR_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ProcessImpl <em>Process</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ProcessImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getProcess()
   * @generated
   */
  int PROCESS = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS__NAME = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS__PROCESS_EXPR = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Process</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractRoleBehaviorEntityImpl <em>Abstract Role Behavior Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractRoleBehaviorEntityImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractRoleBehaviorEntity()
   * @generated
   */
  int ABSTRACT_ROLE_BEHAVIOR_ENTITY = 60;

  /**
   * The number of structural features of the '<em>Abstract Role Behavior Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ROLE_BEHAVIOR_ENTITY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ProcessExpressionImpl <em>Process Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ProcessExpressionImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getProcessExpression()
   * @generated
   */
  int PROCESS_EXPRESSION = 14;

  /**
   * The number of structural features of the '<em>Process Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS_EXPRESSION_FEATURE_COUNT = ABSTRACT_ROLE_BEHAVIOR_ENTITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ActionPrefixImpl <em>Action Prefix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ActionPrefixImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getActionPrefix()
   * @generated
   */
  int ACTION_PREFIX = 15;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_PREFIX__ACTION = PROCESS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_PREFIX__PROCESS_EXPR = PROCESS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Action Prefix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_PREFIX_FEATURE_COUNT = PROCESS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.NondeterministicChoiceImpl <em>Nondeterministic Choice</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.NondeterministicChoiceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getNondeterministicChoice()
   * @generated
   */
  int NONDETERMINISTIC_CHOICE = 16;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NONDETERMINISTIC_CHOICE__FIRST = PROCESS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NONDETERMINISTIC_CHOICE__SECOND = PROCESS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Nondeterministic Choice</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NONDETERMINISTIC_CHOICE_FEATURE_COUNT = PROCESS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.IfThenElseImpl <em>If Then Else</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.IfThenElseImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getIfThenElse()
   * @generated
   */
  int IF_THEN_ELSE = 17;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE__GUARD = PROCESS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>If Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE__IF_PROCESS_EXPR = PROCESS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE__ELSE_PROCESS_EXPR = PROCESS_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Then Else</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_FEATURE_COUNT = PROCESS_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ProcessInvocationImpl <em>Process Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ProcessInvocationImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getProcessInvocation()
   * @generated
   */
  int PROCESS_INVOCATION = 18;

  /**
   * The feature id for the '<em><b>Process</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS_INVOCATION__PROCESS = PROCESS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Process Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS_INVOCATION_FEATURE_COUNT = PROCESS_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ActionImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAction()
   * @generated
   */
  int ACTION = 19;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = ABSTRACT_ROLE_BEHAVIOR_ENTITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractAssignmentImpl <em>Abstract Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractAssignmentImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractAssignment()
   * @generated
   */
  int ABSTRACT_ASSIGNMENT = 20;

  /**
   * The feature id for the '<em><b>Role Inst</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ASSIGNMENT__ROLE_INST = ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF = ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comp Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ASSIGNMENT__COMP_INSTANCE = ACTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Abstract Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ASSIGNMENT_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractMessageCallImpl <em>Abstract Message Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractMessageCallImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractMessageCall()
   * @generated
   */
  int ABSTRACT_MESSAGE_CALL = 21;

  /**
   * The feature id for the '<em><b>Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MESSAGE_CALL__MSG_NAME = ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Message Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_MESSAGE_CALL_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.OutgoingMessageCallImpl <em>Outgoing Message Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.OutgoingMessageCallImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOutgoingMessageCall()
   * @generated
   */
  int OUTGOING_MESSAGE_CALL = 22;

  /**
   * The feature id for the '<em><b>Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTGOING_MESSAGE_CALL__MSG_NAME = ABSTRACT_MESSAGE_CALL__MSG_NAME;

  /**
   * The feature id for the '<em><b>Receiver</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTGOING_MESSAGE_CALL__RECEIVER = ABSTRACT_MESSAGE_CALL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Actual Role Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK = ABSTRACT_MESSAGE_CALL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Actual Data Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK = ABSTRACT_MESSAGE_CALL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Outgoing Message Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTGOING_MESSAGE_CALL_FEATURE_COUNT = ABSTRACT_MESSAGE_CALL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.IncomingMessageCallImpl <em>Incoming Message Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.IncomingMessageCallImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getIncomingMessageCall()
   * @generated
   */
  int INCOMING_MESSAGE_CALL = 23;

  /**
   * The feature id for the '<em><b>Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_MESSAGE_CALL__MSG_NAME = ABSTRACT_MESSAGE_CALL__MSG_NAME;

  /**
   * The feature id for the '<em><b>Formal Role Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK = ABSTRACT_MESSAGE_CALL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Formal Data Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK = ABSTRACT_MESSAGE_CALL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Incoming Message Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCOMING_MESSAGE_CALL_FEATURE_COUNT = ABSTRACT_MESSAGE_CALL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.OperationCallImpl <em>Operation Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.OperationCallImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOperationCall()
   * @generated
   */
  int OPERATION_CALL = 24;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL__VARIABLE = ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL__OP_NAME = ACTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Actual Data Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK = ACTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Operation Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ComponentAttributeSetterImpl <em>Component Attribute Setter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ComponentAttributeSetterImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAttributeSetter()
   * @generated
   */
  int COMPONENT_ATTRIBUTE_SETTER = 25;

  /**
   * The feature id for the '<em><b>Attr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_SETTER__ATTR = ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_SETTER__VALUE = ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Component Attribute Setter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_SETTER_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleAttributeSetterImpl <em>Role Attribute Setter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleAttributeSetterImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleAttributeSetter()
   * @generated
   */
  int ROLE_ATTRIBUTE_SETTER = 26;

  /**
   * The feature id for the '<em><b>Attr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_SETTER__ATTR = ACTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_SETTER__VALUE = ACTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Role Attribute Setter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_SETTER_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.LabelImpl <em>Label</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.LabelImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getLabel()
   * @generated
   */
  int LABEL = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL__NAME = ACTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Label</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.GuardImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 28;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AtomImpl <em>Atom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AtomImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAtom()
   * @generated
   */
  int ATOM = 29;

  /**
   * The number of structural features of the '<em>Atom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.PlaysQueryImpl <em>Plays Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.PlaysQueryImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getPlaysQuery()
   * @generated
   */
  int PLAYS_QUERY = 30;

  /**
   * The feature id for the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAYS_QUERY__ROLE_TYPE_REF = ATOM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Comp Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAYS_QUERY__COMP_INSTANCE = ATOM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Plays Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAYS_QUERY_FEATURE_COUNT = ATOM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RelationImpl <em>Relation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RelationImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRelation()
   * @generated
   */
  int RELATION = 31;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__LEFT = ATOM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__OPERATOR = ATOM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION__RIGHT = ATOM_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Relation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATION_FEATURE_COUNT = ATOM_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.GuardInParenthesesImpl <em>Guard In Parentheses</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.GuardInParenthesesImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getGuardInParentheses()
   * @generated
   */
  int GUARD_IN_PARENTHESES = 32;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_IN_PARENTHESES__GUARD = ATOM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Guard In Parentheses</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_IN_PARENTHESES_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.DataExpressionImpl <em>Data Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.DataExpressionImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getDataExpression()
   * @generated
   */
  int DATA_EXPRESSION = 51;

  /**
   * The number of structural features of the '<em>Data Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_EXPRESSION_FEATURE_COUNT = ATOM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractDataValueImpl <em>Abstract Data Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractDataValueImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataValue()
   * @generated
   */
  int ABSTRACT_DATA_VALUE = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DATA_VALUE__VALUE = DATA_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Data Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DATA_VALUE_FEATURE_COUNT = DATA_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.BooleanValueImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getBooleanValue()
   * @generated
   */
  int BOOLEAN_VALUE = 34;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_VALUE__VALUE = ABSTRACT_DATA_VALUE__VALUE;

  /**
   * The number of structural features of the '<em>Boolean Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_VALUE_FEATURE_COUNT = ABSTRACT_DATA_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.NumberValueImpl <em>Number Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.NumberValueImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getNumberValue()
   * @generated
   */
  int NUMBER_VALUE = 35;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_VALUE__VALUE = ABSTRACT_DATA_VALUE__VALUE;

  /**
   * The number of structural features of the '<em>Number Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_VALUE_FEATURE_COUNT = ABSTRACT_DATA_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.StringValueImpl <em>String Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.StringValueImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getStringValue()
   * @generated
   */
  int STRING_VALUE = 36;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE__VALUE = ABSTRACT_DATA_VALUE__VALUE;

  /**
   * The number of structural features of the '<em>String Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE_FEATURE_COUNT = ABSTRACT_DATA_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ComponentInstanceImpl <em>Component Instance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ComponentInstanceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentInstance()
   * @generated
   */
  int COMPONENT_INSTANCE = 37;

  /**
   * The number of structural features of the '<em>Component Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_INSTANCE_FEATURE_COUNT = ABSTRACT_ROLE_BEHAVIOR_ENTITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ComponentAssociationTypeReferenceImpl <em>Component Association Type Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ComponentAssociationTypeReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAssociationTypeReference()
   * @generated
   */
  int COMPONENT_ASSOCIATION_TYPE_REFERENCE = 38;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ASSOCIATION_TYPE_REFERENCE__REF = COMPONENT_INSTANCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Component Association Type Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ASSOCIATION_TYPE_REFERENCE_FEATURE_COUNT = COMPONENT_INSTANCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.OwnerReferenceImpl <em>Owner Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.OwnerReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOwnerReference()
   * @generated
   */
  int OWNER_REFERENCE = 39;

  /**
   * The number of structural features of the '<em>Owner Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OWNER_REFERENCE_FEATURE_COUNT = COMPONENT_INSTANCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractRoleInstanceImpl <em>Abstract Role Instance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractRoleInstanceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractRoleInstance()
   * @generated
   */
  int ABSTRACT_ROLE_INSTANCE = 40;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ROLE_INSTANCE__NAME = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Role Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ROLE_INSTANCE_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleInstanceVariableImpl <em>Role Instance Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleInstanceVariableImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleInstanceVariable()
   * @generated
   */
  int ROLE_INSTANCE_VARIABLE = 41;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_INSTANCE_VARIABLE__NAME = ABSTRACT_ROLE_INSTANCE__NAME;

  /**
   * The number of structural features of the '<em>Role Instance Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_INSTANCE_VARIABLE_FEATURE_COUNT = ABSTRACT_ROLE_INSTANCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.FormalRoleParamImpl <em>Formal Role Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.FormalRoleParamImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalRoleParam()
   * @generated
   */
  int FORMAL_ROLE_PARAM = 42;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_ROLE_PARAM__NAME = ABSTRACT_ROLE_INSTANCE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_ROLE_PARAM__TYPE = ABSTRACT_ROLE_INSTANCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Formal Role Param</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_ROLE_PARAM_FEATURE_COUNT = ABSTRACT_ROLE_INSTANCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.FormalRoleParamsBlockImpl <em>Formal Role Params Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.FormalRoleParamsBlockImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalRoleParamsBlock()
   * @generated
   */
  int FORMAL_ROLE_PARAMS_BLOCK = 43;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_ROLE_PARAMS_BLOCK__PARAMS = 0;

  /**
   * The number of structural features of the '<em>Formal Role Params Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_ROLE_PARAMS_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleInstanceReferenceImpl <em>Role Instance Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleInstanceReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleInstanceReference()
   * @generated
   */
  int ROLE_INSTANCE_REFERENCE = 44;

  /**
   * The number of structural features of the '<em>Role Instance Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_INSTANCE_REFERENCE_FEATURE_COUNT = ABSTRACT_ROLE_BEHAVIOR_ENTITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractRoleInstanceReferenceImpl <em>Abstract Role Instance Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractRoleInstanceReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractRoleInstanceReference()
   * @generated
   */
  int ABSTRACT_ROLE_INSTANCE_REFERENCE = 45;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ROLE_INSTANCE_REFERENCE__REF = ROLE_INSTANCE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Role Instance Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ROLE_INSTANCE_REFERENCE_FEATURE_COUNT = ROLE_INSTANCE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ActualRoleParamsBlockImpl <em>Actual Role Params Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ActualRoleParamsBlockImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getActualRoleParamsBlock()
   * @generated
   */
  int ACTUAL_ROLE_PARAMS_BLOCK = 46;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_ROLE_PARAMS_BLOCK__PARAMS = 0;

  /**
   * The number of structural features of the '<em>Actual Role Params Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_ROLE_PARAMS_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractDataVariableImpl <em>Abstract Data Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractDataVariableImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataVariable()
   * @generated
   */
  int ABSTRACT_DATA_VARIABLE = 47;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DATA_VARIABLE__NAME = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Data Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DATA_VARIABLE_FEATURE_COUNT = ABSTRACT_DUPLICATE_FREE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.DataVariableImpl <em>Data Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.DataVariableImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getDataVariable()
   * @generated
   */
  int DATA_VARIABLE = 48;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_VARIABLE__NAME = ABSTRACT_DATA_VARIABLE__NAME;

  /**
   * The number of structural features of the '<em>Data Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_VARIABLE_FEATURE_COUNT = ABSTRACT_DATA_VARIABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.FormalDataParamImpl <em>Formal Data Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.FormalDataParamImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalDataParam()
   * @generated
   */
  int FORMAL_DATA_PARAM = 49;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_DATA_PARAM__NAME = ABSTRACT_DATA_VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_DATA_PARAM__TYPE = ABSTRACT_DATA_VARIABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Formal Data Param</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_DATA_PARAM_FEATURE_COUNT = ABSTRACT_DATA_VARIABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.FormalDataParamsBlockImpl <em>Formal Data Params Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.FormalDataParamsBlockImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalDataParamsBlock()
   * @generated
   */
  int FORMAL_DATA_PARAMS_BLOCK = 50;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_DATA_PARAMS_BLOCK__PARAMS = 0;

  /**
   * The number of structural features of the '<em>Formal Data Params Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMAL_DATA_PARAMS_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractDataReferenceImpl <em>Abstract Data Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractDataReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataReference()
   * @generated
   */
  int ABSTRACT_DATA_REFERENCE = 52;

  /**
   * The number of structural features of the '<em>Abstract Data Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DATA_REFERENCE_FEATURE_COUNT = DATA_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractDataVariableReferenceImpl <em>Abstract Data Variable Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractDataVariableReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataVariableReference()
   * @generated
   */
  int ABSTRACT_DATA_VARIABLE_REFERENCE = 53;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DATA_VARIABLE_REFERENCE__REF = ABSTRACT_DATA_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Data Variable Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DATA_VARIABLE_REFERENCE_FEATURE_COUNT = ABSTRACT_DATA_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.RoleAttributeTypeReferenceImpl <em>Role Attribute Type Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.RoleAttributeTypeReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleAttributeTypeReference()
   * @generated
   */
  int ROLE_ATTRIBUTE_TYPE_REFERENCE = 54;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_TYPE_REFERENCE__REF = ABSTRACT_DATA_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Role Attribute Type Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROLE_ATTRIBUTE_TYPE_REFERENCE_FEATURE_COUNT = ABSTRACT_DATA_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ComponentAttributeTypeReferenceImpl <em>Component Attribute Type Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ComponentAttributeTypeReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAttributeTypeReference()
   * @generated
   */
  int COMPONENT_ATTRIBUTE_TYPE_REFERENCE = 55;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_TYPE_REFERENCE__REF = ABSTRACT_DATA_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Component Attribute Type Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_ATTRIBUTE_TYPE_REFERENCE_FEATURE_COUNT = ABSTRACT_DATA_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.ActualDataParamsBlockImpl <em>Actual Data Params Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.ActualDataParamsBlockImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getActualDataParamsBlock()
   * @generated
   */
  int ACTUAL_DATA_PARAMS_BLOCK = 56;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_DATA_PARAMS_BLOCK__PARAMS = 0;

  /**
   * The number of structural features of the '<em>Actual Data Params Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTUAL_DATA_PARAMS_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AbstractInstanceImpl <em>Abstract Instance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AbstractInstanceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractInstance()
   * @generated
   */
  int ABSTRACT_INSTANCE = 61;

  /**
   * The number of structural features of the '<em>Abstract Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_INSTANCE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.DeclaringRoleBehaviorImpl <em>Declaring Role Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.DeclaringRoleBehaviorImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getDeclaringRoleBehavior()
   * @generated
   */
  int DECLARING_ROLE_BEHAVIOR = 62;

  /**
   * The feature id for the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARING_ROLE_BEHAVIOR__ROLE_TYPE_REF = ROLE_BEHAVIOR__ROLE_TYPE_REF;

  /**
   * The feature id for the '<em><b>Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR = ROLE_BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Declaring Role Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECLARING_ROLE_BEHAVIOR_FEATURE_COUNT = ROLE_BEHAVIOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.InvokingRoleBehaviorImpl <em>Invoking Role Behavior</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.InvokingRoleBehaviorImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getInvokingRoleBehavior()
   * @generated
   */
  int INVOKING_ROLE_BEHAVIOR = 63;

  /**
   * The feature id for the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOKING_ROLE_BEHAVIOR__ROLE_TYPE_REF = ROLE_BEHAVIOR__ROLE_TYPE_REF;

  /**
   * The feature id for the '<em><b>Process Invocation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION = ROLE_BEHAVIOR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Processes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOKING_ROLE_BEHAVIOR__PROCESSES = ROLE_BEHAVIOR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Invoking Role Behavior</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOKING_ROLE_BEHAVIOR_FEATURE_COUNT = ROLE_BEHAVIOR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.QuitTermImpl <em>Quit Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.QuitTermImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getQuitTerm()
   * @generated
   */
  int QUIT_TERM = 64;

  /**
   * The number of structural features of the '<em>Quit Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUIT_TERM_FEATURE_COUNT = PROCESS_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.GetAssignmentImpl <em>Get Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.GetAssignmentImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getGetAssignment()
   * @generated
   */
  int GET_ASSIGNMENT = 65;

  /**
   * The feature id for the '<em><b>Role Inst</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GET_ASSIGNMENT__ROLE_INST = ABSTRACT_ASSIGNMENT__ROLE_INST;

  /**
   * The feature id for the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GET_ASSIGNMENT__ROLE_TYPE_REF = ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF;

  /**
   * The feature id for the '<em><b>Comp Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GET_ASSIGNMENT__COMP_INSTANCE = ABSTRACT_ASSIGNMENT__COMP_INSTANCE;

  /**
   * The number of structural features of the '<em>Get Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GET_ASSIGNMENT_FEATURE_COUNT = ABSTRACT_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.CreateAssignmentImpl <em>Create Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.CreateAssignmentImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getCreateAssignment()
   * @generated
   */
  int CREATE_ASSIGNMENT = 66;

  /**
   * The feature id for the '<em><b>Role Inst</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE_ASSIGNMENT__ROLE_INST = ABSTRACT_ASSIGNMENT__ROLE_INST;

  /**
   * The feature id for the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE_ASSIGNMENT__ROLE_TYPE_REF = ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF;

  /**
   * The feature id for the '<em><b>Comp Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE_ASSIGNMENT__COMP_INSTANCE = ABSTRACT_ASSIGNMENT__COMP_INSTANCE;

  /**
   * The number of structural features of the '<em>Create Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATE_ASSIGNMENT_FEATURE_COUNT = ABSTRACT_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.OrTermImpl <em>Or Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.OrTermImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOrTerm()
   * @generated
   */
  int OR_TERM = 67;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_TERM__LEFT = GUARD_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_TERM__RIGHT = GUARD_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_TERM_FEATURE_COUNT = GUARD_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AndTermImpl <em>And Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AndTermImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAndTerm()
   * @generated
   */
  int AND_TERM = 68;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_TERM__LEFT = GUARD_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_TERM__RIGHT = GUARD_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_TERM_FEATURE_COUNT = GUARD_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.EqualityTermImpl <em>Equality Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.EqualityTermImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getEqualityTerm()
   * @generated
   */
  int EQUALITY_TERM = 69;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_TERM__LEFT = GUARD_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_TERM__OPERATOR = GUARD_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_TERM__RIGHT = GUARD_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Equality Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_TERM_FEATURE_COUNT = GUARD_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.NotTermImpl <em>Not Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.NotTermImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getNotTerm()
   * @generated
   */
  int NOT_TERM = 70;

  /**
   * The feature id for the '<em><b>Not</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_TERM__NOT = GUARD_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Atom</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_TERM__ATOM = GUARD_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Not Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_TERM_FEATURE_COUNT = GUARD_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.SelfReferenceImpl <em>Self Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.SelfReferenceImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getSelfReference()
   * @generated
   */
  int SELF_REFERENCE = 71;

  /**
   * The number of structural features of the '<em>Self Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELF_REFERENCE_FEATURE_COUNT = ROLE_INSTANCE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.AdditionImpl <em>Addition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.AdditionImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAddition()
   * @generated
   */
  int ADDITION = 72;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION__LEFT = DATA_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION__OPERATOR = DATA_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION__RIGHT = DATA_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Addition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITION_FEATURE_COUNT = DATA_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.impl.SubtractionImpl <em>Subtraction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.impl.SubtractionImpl
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getSubtraction()
   * @generated
   */
  int SUBTRACTION = 73;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION__LEFT = DATA_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION__OPERATOR = DATA_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION__RIGHT = DATA_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Subtraction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBTRACTION_FEATURE_COUNT = DATA_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link eu.ascens.helenaText.MsgDirection <em>Msg Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see eu.ascens.helenaText.MsgDirection
   * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getMsgDirection()
   * @generated
   */
  int MSG_DIRECTION = 74;


  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see eu.ascens.helenaText.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Model#getHeadPkg <em>Head Pkg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Head Pkg</em>'.
   * @see eu.ascens.helenaText.Model#getHeadPkg()
   * @see #getModel()
   * @generated
   */
  EReference getModel_HeadPkg();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Declaration</em>'.
   * @see eu.ascens.helenaText.PackageDeclaration
   * @generated
   */
  EClass getPackageDeclaration();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.PackageDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.PackageDeclaration#getName()
   * @see #getPackageDeclaration()
   * @generated
   */
  EAttribute getPackageDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.PackageDeclaration#getCompTypes <em>Comp Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comp Types</em>'.
   * @see eu.ascens.helenaText.PackageDeclaration#getCompTypes()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_CompTypes();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.PackageDeclaration#getRoleTypes <em>Role Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Role Types</em>'.
   * @see eu.ascens.helenaText.PackageDeclaration#getRoleTypes()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_RoleTypes();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.PackageDeclaration#getEnsStructs <em>Ens Structs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ens Structs</em>'.
   * @see eu.ascens.helenaText.PackageDeclaration#getEnsStructs()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_EnsStructs();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.PackageDeclaration#getRoleBehaviors <em>Role Behaviors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Role Behaviors</em>'.
   * @see eu.ascens.helenaText.PackageDeclaration#getRoleBehaviors()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_RoleBehaviors();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ComponentType <em>Component Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Type</em>'.
   * @see eu.ascens.helenaText.ComponentType
   * @generated
   */
  EClass getComponentType();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.ComponentType#getAttrs <em>Attrs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attrs</em>'.
   * @see eu.ascens.helenaText.ComponentType#getAttrs()
   * @see #getComponentType()
   * @generated
   */
  EReference getComponentType_Attrs();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.ComponentType#getAssocs <em>Assocs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assocs</em>'.
   * @see eu.ascens.helenaText.ComponentType#getAssocs()
   * @see #getComponentType()
   * @generated
   */
  EReference getComponentType_Assocs();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.ComponentType#getOps <em>Ops</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ops</em>'.
   * @see eu.ascens.helenaText.ComponentType#getOps()
   * @see #getComponentType()
   * @generated
   */
  EReference getComponentType_Ops();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractComponentFieldType <em>Abstract Component Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Component Field Type</em>'.
   * @see eu.ascens.helenaText.AbstractComponentFieldType
   * @generated
   */
  EClass getAbstractComponentFieldType();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ComponentAttributeType <em>Component Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Attribute Type</em>'.
   * @see eu.ascens.helenaText.ComponentAttributeType
   * @generated
   */
  EClass getComponentAttributeType();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.ComponentAttributeType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see eu.ascens.helenaText.ComponentAttributeType#getType()
   * @see #getComponentAttributeType()
   * @generated
   */
  EReference getComponentAttributeType_Type();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ComponentAssociationType <em>Component Association Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Association Type</em>'.
   * @see eu.ascens.helenaText.ComponentAssociationType
   * @generated
   */
  EClass getComponentAssociationType();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.ComponentAssociationType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see eu.ascens.helenaText.ComponentAssociationType#getType()
   * @see #getComponentAssociationType()
   * @generated
   */
  EReference getComponentAssociationType_Type();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.OperationType <em>Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Type</em>'.
   * @see eu.ascens.helenaText.OperationType
   * @generated
   */
  EClass getOperationType();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OperationType#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see eu.ascens.helenaText.OperationType#getReturnType()
   * @see #getOperationType()
   * @generated
   */
  EReference getOperationType_ReturnType();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.OperationType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.OperationType#getName()
   * @see #getOperationType()
   * @generated
   */
  EAttribute getOperationType_Name();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OperationType#getFormalDataParamsBlock <em>Formal Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Data Params Block</em>'.
   * @see eu.ascens.helenaText.OperationType#getFormalDataParamsBlock()
   * @see #getOperationType()
   * @generated
   */
  EReference getOperationType_FormalDataParamsBlock();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleType <em>Role Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Type</em>'.
   * @see eu.ascens.helenaText.RoleType
   * @generated
   */
  EClass getRoleType();

  /**
   * Returns the meta object for the reference list '{@link eu.ascens.helenaText.RoleType#getCompTypes <em>Comp Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Comp Types</em>'.
   * @see eu.ascens.helenaText.RoleType#getCompTypes()
   * @see #getRoleType()
   * @generated
   */
  EReference getRoleType_CompTypes();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.RoleType#getRoleattrs <em>Roleattrs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Roleattrs</em>'.
   * @see eu.ascens.helenaText.RoleType#getRoleattrs()
   * @see #getRoleType()
   * @generated
   */
  EReference getRoleType_Roleattrs();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.RoleType#getRolemsgs <em>Rolemsgs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rolemsgs</em>'.
   * @see eu.ascens.helenaText.RoleType#getRolemsgs()
   * @see #getRoleType()
   * @generated
   */
  EReference getRoleType_Rolemsgs();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleAttributeType <em>Role Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Attribute Type</em>'.
   * @see eu.ascens.helenaText.RoleAttributeType
   * @generated
   */
  EClass getRoleAttributeType();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.RoleAttributeType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see eu.ascens.helenaText.RoleAttributeType#getType()
   * @see #getRoleAttributeType()
   * @generated
   */
  EReference getRoleAttributeType_Type();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.MessageType <em>Message Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Message Type</em>'.
   * @see eu.ascens.helenaText.MessageType
   * @generated
   */
  EClass getMessageType();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.MessageType#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see eu.ascens.helenaText.MessageType#getDirection()
   * @see #getMessageType()
   * @generated
   */
  EAttribute getMessageType_Direction();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.MessageType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.MessageType#getName()
   * @see #getMessageType()
   * @generated
   */
  EAttribute getMessageType_Name();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.MessageType#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Role Params Block</em>'.
   * @see eu.ascens.helenaText.MessageType#getFormalRoleParamsBlock()
   * @see #getMessageType()
   * @generated
   */
  EReference getMessageType_FormalRoleParamsBlock();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.MessageType#getFormalDataParamsBlock <em>Formal Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Data Params Block</em>'.
   * @see eu.ascens.helenaText.MessageType#getFormalDataParamsBlock()
   * @see #getMessageType()
   * @generated
   */
  EReference getMessageType_FormalDataParamsBlock();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.EnsembleStructure <em>Ensemble Structure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ensemble Structure</em>'.
   * @see eu.ascens.helenaText.EnsembleStructure
   * @generated
   */
  EClass getEnsembleStructure();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.EnsembleStructure#getRtWithMult <em>Rt With Mult</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rt With Mult</em>'.
   * @see eu.ascens.helenaText.EnsembleStructure#getRtWithMult()
   * @see #getEnsembleStructure()
   * @generated
   */
  EReference getEnsembleStructure_RtWithMult();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity <em>Role Type With Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Type With Multiplicity</em>'.
   * @see eu.ascens.helenaText.RoleTypeWithMultiplicity
   * @generated
   */
  EClass getRoleTypeWithMultiplicity();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getRoleType <em>Role Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Role Type</em>'.
   * @see eu.ascens.helenaText.RoleTypeWithMultiplicity#getRoleType()
   * @see #getRoleTypeWithMultiplicity()
   * @generated
   */
  EReference getRoleTypeWithMultiplicity_RoleType();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getMin <em>Min</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Min</em>'.
   * @see eu.ascens.helenaText.RoleTypeWithMultiplicity#getMin()
   * @see #getRoleTypeWithMultiplicity()
   * @generated
   */
  EAttribute getRoleTypeWithMultiplicity_Min();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getMax <em>Max</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max</em>'.
   * @see eu.ascens.helenaText.RoleTypeWithMultiplicity#getMax()
   * @see #getRoleTypeWithMultiplicity()
   * @generated
   */
  EAttribute getRoleTypeWithMultiplicity_Max();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getCapacity <em>Capacity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Capacity</em>'.
   * @see eu.ascens.helenaText.RoleTypeWithMultiplicity#getCapacity()
   * @see #getRoleTypeWithMultiplicity()
   * @generated
   */
  EAttribute getRoleTypeWithMultiplicity_Capacity();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleBehavior <em>Role Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Behavior</em>'.
   * @see eu.ascens.helenaText.RoleBehavior
   * @generated
   */
  EClass getRoleBehavior();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.RoleBehavior#getRoleTypeRef <em>Role Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Role Type Ref</em>'.
   * @see eu.ascens.helenaText.RoleBehavior#getRoleTypeRef()
   * @see #getRoleBehavior()
   * @generated
   */
  EReference getRoleBehavior_RoleTypeRef();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Process <em>Process</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Process</em>'.
   * @see eu.ascens.helenaText.Process
   * @generated
   */
  EClass getProcess();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.Process#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.Process#getName()
   * @see #getProcess()
   * @generated
   */
  EAttribute getProcess_Name();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Process#getProcessExpr <em>Process Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Process Expr</em>'.
   * @see eu.ascens.helenaText.Process#getProcessExpr()
   * @see #getProcess()
   * @generated
   */
  EReference getProcess_ProcessExpr();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ProcessExpression <em>Process Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Process Expression</em>'.
   * @see eu.ascens.helenaText.ProcessExpression
   * @generated
   */
  EClass getProcessExpression();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ActionPrefix <em>Action Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Prefix</em>'.
   * @see eu.ascens.helenaText.ActionPrefix
   * @generated
   */
  EClass getActionPrefix();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.ActionPrefix#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see eu.ascens.helenaText.ActionPrefix#getAction()
   * @see #getActionPrefix()
   * @generated
   */
  EReference getActionPrefix_Action();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.ActionPrefix#getProcessExpr <em>Process Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Process Expr</em>'.
   * @see eu.ascens.helenaText.ActionPrefix#getProcessExpr()
   * @see #getActionPrefix()
   * @generated
   */
  EReference getActionPrefix_ProcessExpr();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.NondeterministicChoice <em>Nondeterministic Choice</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nondeterministic Choice</em>'.
   * @see eu.ascens.helenaText.NondeterministicChoice
   * @generated
   */
  EClass getNondeterministicChoice();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.NondeterministicChoice#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First</em>'.
   * @see eu.ascens.helenaText.NondeterministicChoice#getFirst()
   * @see #getNondeterministicChoice()
   * @generated
   */
  EReference getNondeterministicChoice_First();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.NondeterministicChoice#getSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Second</em>'.
   * @see eu.ascens.helenaText.NondeterministicChoice#getSecond()
   * @see #getNondeterministicChoice()
   * @generated
   */
  EReference getNondeterministicChoice_Second();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.IfThenElse <em>If Then Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Then Else</em>'.
   * @see eu.ascens.helenaText.IfThenElse
   * @generated
   */
  EClass getIfThenElse();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.IfThenElse#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see eu.ascens.helenaText.IfThenElse#getGuard()
   * @see #getIfThenElse()
   * @generated
   */
  EReference getIfThenElse_Guard();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.IfThenElse#getIfProcessExpr <em>If Process Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Process Expr</em>'.
   * @see eu.ascens.helenaText.IfThenElse#getIfProcessExpr()
   * @see #getIfThenElse()
   * @generated
   */
  EReference getIfThenElse_IfProcessExpr();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.IfThenElse#getElseProcessExpr <em>Else Process Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Process Expr</em>'.
   * @see eu.ascens.helenaText.IfThenElse#getElseProcessExpr()
   * @see #getIfThenElse()
   * @generated
   */
  EReference getIfThenElse_ElseProcessExpr();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ProcessInvocation <em>Process Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Process Invocation</em>'.
   * @see eu.ascens.helenaText.ProcessInvocation
   * @generated
   */
  EClass getProcessInvocation();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.ProcessInvocation#getProcess <em>Process</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Process</em>'.
   * @see eu.ascens.helenaText.ProcessInvocation#getProcess()
   * @see #getProcessInvocation()
   * @generated
   */
  EReference getProcessInvocation_Process();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see eu.ascens.helenaText.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractAssignment <em>Abstract Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Assignment</em>'.
   * @see eu.ascens.helenaText.AbstractAssignment
   * @generated
   */
  EClass getAbstractAssignment();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.AbstractAssignment#getRoleInst <em>Role Inst</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Role Inst</em>'.
   * @see eu.ascens.helenaText.AbstractAssignment#getRoleInst()
   * @see #getAbstractAssignment()
   * @generated
   */
  EReference getAbstractAssignment_RoleInst();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.AbstractAssignment#getRoleTypeRef <em>Role Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Role Type Ref</em>'.
   * @see eu.ascens.helenaText.AbstractAssignment#getRoleTypeRef()
   * @see #getAbstractAssignment()
   * @generated
   */
  EReference getAbstractAssignment_RoleTypeRef();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.AbstractAssignment#getCompInstance <em>Comp Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Comp Instance</em>'.
   * @see eu.ascens.helenaText.AbstractAssignment#getCompInstance()
   * @see #getAbstractAssignment()
   * @generated
   */
  EReference getAbstractAssignment_CompInstance();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractMessageCall <em>Abstract Message Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Message Call</em>'.
   * @see eu.ascens.helenaText.AbstractMessageCall
   * @generated
   */
  EClass getAbstractMessageCall();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.AbstractMessageCall#getMsgName <em>Msg Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Msg Name</em>'.
   * @see eu.ascens.helenaText.AbstractMessageCall#getMsgName()
   * @see #getAbstractMessageCall()
   * @generated
   */
  EAttribute getAbstractMessageCall_MsgName();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.OutgoingMessageCall <em>Outgoing Message Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Outgoing Message Call</em>'.
   * @see eu.ascens.helenaText.OutgoingMessageCall
   * @generated
   */
  EClass getOutgoingMessageCall();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OutgoingMessageCall#getReceiver <em>Receiver</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Receiver</em>'.
   * @see eu.ascens.helenaText.OutgoingMessageCall#getReceiver()
   * @see #getOutgoingMessageCall()
   * @generated
   */
  EReference getOutgoingMessageCall_Receiver();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OutgoingMessageCall#getActualRoleParamsBlock <em>Actual Role Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actual Role Params Block</em>'.
   * @see eu.ascens.helenaText.OutgoingMessageCall#getActualRoleParamsBlock()
   * @see #getOutgoingMessageCall()
   * @generated
   */
  EReference getOutgoingMessageCall_ActualRoleParamsBlock();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OutgoingMessageCall#getActualDataParamsBlock <em>Actual Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actual Data Params Block</em>'.
   * @see eu.ascens.helenaText.OutgoingMessageCall#getActualDataParamsBlock()
   * @see #getOutgoingMessageCall()
   * @generated
   */
  EReference getOutgoingMessageCall_ActualDataParamsBlock();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.IncomingMessageCall <em>Incoming Message Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Incoming Message Call</em>'.
   * @see eu.ascens.helenaText.IncomingMessageCall
   * @generated
   */
  EClass getIncomingMessageCall();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.IncomingMessageCall#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Role Params Block</em>'.
   * @see eu.ascens.helenaText.IncomingMessageCall#getFormalRoleParamsBlock()
   * @see #getIncomingMessageCall()
   * @generated
   */
  EReference getIncomingMessageCall_FormalRoleParamsBlock();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.IncomingMessageCall#getFormalDataParamsBlock <em>Formal Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formal Data Params Block</em>'.
   * @see eu.ascens.helenaText.IncomingMessageCall#getFormalDataParamsBlock()
   * @see #getIncomingMessageCall()
   * @generated
   */
  EReference getIncomingMessageCall_FormalDataParamsBlock();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.OperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Call</em>'.
   * @see eu.ascens.helenaText.OperationCall
   * @generated
   */
  EClass getOperationCall();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OperationCall#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see eu.ascens.helenaText.OperationCall#getVariable()
   * @see #getOperationCall()
   * @generated
   */
  EReference getOperationCall_Variable();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.OperationCall#getOpName <em>Op Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op Name</em>'.
   * @see eu.ascens.helenaText.OperationCall#getOpName()
   * @see #getOperationCall()
   * @generated
   */
  EAttribute getOperationCall_OpName();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OperationCall#getActualDataParamsBlock <em>Actual Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actual Data Params Block</em>'.
   * @see eu.ascens.helenaText.OperationCall#getActualDataParamsBlock()
   * @see #getOperationCall()
   * @generated
   */
  EReference getOperationCall_ActualDataParamsBlock();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ComponentAttributeSetter <em>Component Attribute Setter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Attribute Setter</em>'.
   * @see eu.ascens.helenaText.ComponentAttributeSetter
   * @generated
   */
  EClass getComponentAttributeSetter();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.ComponentAttributeSetter#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attr</em>'.
   * @see eu.ascens.helenaText.ComponentAttributeSetter#getAttr()
   * @see #getComponentAttributeSetter()
   * @generated
   */
  EReference getComponentAttributeSetter_Attr();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.ComponentAttributeSetter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see eu.ascens.helenaText.ComponentAttributeSetter#getValue()
   * @see #getComponentAttributeSetter()
   * @generated
   */
  EReference getComponentAttributeSetter_Value();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleAttributeSetter <em>Role Attribute Setter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Attribute Setter</em>'.
   * @see eu.ascens.helenaText.RoleAttributeSetter
   * @generated
   */
  EClass getRoleAttributeSetter();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.RoleAttributeSetter#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attr</em>'.
   * @see eu.ascens.helenaText.RoleAttributeSetter#getAttr()
   * @see #getRoleAttributeSetter()
   * @generated
   */
  EReference getRoleAttributeSetter_Attr();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.RoleAttributeSetter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see eu.ascens.helenaText.RoleAttributeSetter#getValue()
   * @see #getRoleAttributeSetter()
   * @generated
   */
  EReference getRoleAttributeSetter_Value();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Label</em>'.
   * @see eu.ascens.helenaText.Label
   * @generated
   */
  EClass getLabel();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.Label#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.Label#getName()
   * @see #getLabel()
   * @generated
   */
  EAttribute getLabel_Name();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see eu.ascens.helenaText.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom</em>'.
   * @see eu.ascens.helenaText.Atom
   * @generated
   */
  EClass getAtom();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.PlaysQuery <em>Plays Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plays Query</em>'.
   * @see eu.ascens.helenaText.PlaysQuery
   * @generated
   */
  EClass getPlaysQuery();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.PlaysQuery#getRoleTypeRef <em>Role Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Role Type Ref</em>'.
   * @see eu.ascens.helenaText.PlaysQuery#getRoleTypeRef()
   * @see #getPlaysQuery()
   * @generated
   */
  EReference getPlaysQuery_RoleTypeRef();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.PlaysQuery#getCompInstance <em>Comp Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Comp Instance</em>'.
   * @see eu.ascens.helenaText.PlaysQuery#getCompInstance()
   * @see #getPlaysQuery()
   * @generated
   */
  EReference getPlaysQuery_CompInstance();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relation</em>'.
   * @see eu.ascens.helenaText.Relation
   * @generated
   */
  EClass getRelation();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Relation#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see eu.ascens.helenaText.Relation#getLeft()
   * @see #getRelation()
   * @generated
   */
  EReference getRelation_Left();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.Relation#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see eu.ascens.helenaText.Relation#getOperator()
   * @see #getRelation()
   * @generated
   */
  EAttribute getRelation_Operator();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Relation#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see eu.ascens.helenaText.Relation#getRight()
   * @see #getRelation()
   * @generated
   */
  EReference getRelation_Right();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.GuardInParentheses <em>Guard In Parentheses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard In Parentheses</em>'.
   * @see eu.ascens.helenaText.GuardInParentheses
   * @generated
   */
  EClass getGuardInParentheses();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.GuardInParentheses#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see eu.ascens.helenaText.GuardInParentheses#getGuard()
   * @see #getGuardInParentheses()
   * @generated
   */
  EReference getGuardInParentheses_Guard();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractDataValue <em>Abstract Data Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Data Value</em>'.
   * @see eu.ascens.helenaText.AbstractDataValue
   * @generated
   */
  EClass getAbstractDataValue();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.AbstractDataValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see eu.ascens.helenaText.AbstractDataValue#getValue()
   * @see #getAbstractDataValue()
   * @generated
   */
  EReference getAbstractDataValue_Value();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.BooleanValue <em>Boolean Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Value</em>'.
   * @see eu.ascens.helenaText.BooleanValue
   * @generated
   */
  EClass getBooleanValue();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.NumberValue <em>Number Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Value</em>'.
   * @see eu.ascens.helenaText.NumberValue
   * @generated
   */
  EClass getNumberValue();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Value</em>'.
   * @see eu.ascens.helenaText.StringValue
   * @generated
   */
  EClass getStringValue();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ComponentInstance <em>Component Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Instance</em>'.
   * @see eu.ascens.helenaText.ComponentInstance
   * @generated
   */
  EClass getComponentInstance();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ComponentAssociationTypeReference <em>Component Association Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Association Type Reference</em>'.
   * @see eu.ascens.helenaText.ComponentAssociationTypeReference
   * @generated
   */
  EClass getComponentAssociationTypeReference();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.ComponentAssociationTypeReference#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see eu.ascens.helenaText.ComponentAssociationTypeReference#getRef()
   * @see #getComponentAssociationTypeReference()
   * @generated
   */
  EReference getComponentAssociationTypeReference_Ref();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.OwnerReference <em>Owner Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Owner Reference</em>'.
   * @see eu.ascens.helenaText.OwnerReference
   * @generated
   */
  EClass getOwnerReference();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractRoleInstance <em>Abstract Role Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Role Instance</em>'.
   * @see eu.ascens.helenaText.AbstractRoleInstance
   * @generated
   */
  EClass getAbstractRoleInstance();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.AbstractRoleInstance#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.AbstractRoleInstance#getName()
   * @see #getAbstractRoleInstance()
   * @generated
   */
  EAttribute getAbstractRoleInstance_Name();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleInstanceVariable <em>Role Instance Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Instance Variable</em>'.
   * @see eu.ascens.helenaText.RoleInstanceVariable
   * @generated
   */
  EClass getRoleInstanceVariable();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.FormalRoleParam <em>Formal Role Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Role Param</em>'.
   * @see eu.ascens.helenaText.FormalRoleParam
   * @generated
   */
  EClass getFormalRoleParam();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.FormalRoleParam#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see eu.ascens.helenaText.FormalRoleParam#getType()
   * @see #getFormalRoleParam()
   * @generated
   */
  EReference getFormalRoleParam_Type();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.FormalRoleParamsBlock <em>Formal Role Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Role Params Block</em>'.
   * @see eu.ascens.helenaText.FormalRoleParamsBlock
   * @generated
   */
  EClass getFormalRoleParamsBlock();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.FormalRoleParamsBlock#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see eu.ascens.helenaText.FormalRoleParamsBlock#getParams()
   * @see #getFormalRoleParamsBlock()
   * @generated
   */
  EReference getFormalRoleParamsBlock_Params();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleInstanceReference <em>Role Instance Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Instance Reference</em>'.
   * @see eu.ascens.helenaText.RoleInstanceReference
   * @generated
   */
  EClass getRoleInstanceReference();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractRoleInstanceReference <em>Abstract Role Instance Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Role Instance Reference</em>'.
   * @see eu.ascens.helenaText.AbstractRoleInstanceReference
   * @generated
   */
  EClass getAbstractRoleInstanceReference();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.AbstractRoleInstanceReference#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see eu.ascens.helenaText.AbstractRoleInstanceReference#getRef()
   * @see #getAbstractRoleInstanceReference()
   * @generated
   */
  EReference getAbstractRoleInstanceReference_Ref();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ActualRoleParamsBlock <em>Actual Role Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actual Role Params Block</em>'.
   * @see eu.ascens.helenaText.ActualRoleParamsBlock
   * @generated
   */
  EClass getActualRoleParamsBlock();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.ActualRoleParamsBlock#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see eu.ascens.helenaText.ActualRoleParamsBlock#getParams()
   * @see #getActualRoleParamsBlock()
   * @generated
   */
  EReference getActualRoleParamsBlock_Params();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractDataVariable <em>Abstract Data Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Data Variable</em>'.
   * @see eu.ascens.helenaText.AbstractDataVariable
   * @generated
   */
  EClass getAbstractDataVariable();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.AbstractDataVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.AbstractDataVariable#getName()
   * @see #getAbstractDataVariable()
   * @generated
   */
  EAttribute getAbstractDataVariable_Name();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.DataVariable <em>Data Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Variable</em>'.
   * @see eu.ascens.helenaText.DataVariable
   * @generated
   */
  EClass getDataVariable();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.FormalDataParam <em>Formal Data Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Data Param</em>'.
   * @see eu.ascens.helenaText.FormalDataParam
   * @generated
   */
  EClass getFormalDataParam();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.FormalDataParam#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see eu.ascens.helenaText.FormalDataParam#getType()
   * @see #getFormalDataParam()
   * @generated
   */
  EReference getFormalDataParam_Type();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.FormalDataParamsBlock <em>Formal Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formal Data Params Block</em>'.
   * @see eu.ascens.helenaText.FormalDataParamsBlock
   * @generated
   */
  EClass getFormalDataParamsBlock();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.FormalDataParamsBlock#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see eu.ascens.helenaText.FormalDataParamsBlock#getParams()
   * @see #getFormalDataParamsBlock()
   * @generated
   */
  EReference getFormalDataParamsBlock_Params();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.DataExpression <em>Data Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Expression</em>'.
   * @see eu.ascens.helenaText.DataExpression
   * @generated
   */
  EClass getDataExpression();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractDataReference <em>Abstract Data Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Data Reference</em>'.
   * @see eu.ascens.helenaText.AbstractDataReference
   * @generated
   */
  EClass getAbstractDataReference();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractDataVariableReference <em>Abstract Data Variable Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Data Variable Reference</em>'.
   * @see eu.ascens.helenaText.AbstractDataVariableReference
   * @generated
   */
  EClass getAbstractDataVariableReference();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.AbstractDataVariableReference#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see eu.ascens.helenaText.AbstractDataVariableReference#getRef()
   * @see #getAbstractDataVariableReference()
   * @generated
   */
  EReference getAbstractDataVariableReference_Ref();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.RoleAttributeTypeReference <em>Role Attribute Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Role Attribute Type Reference</em>'.
   * @see eu.ascens.helenaText.RoleAttributeTypeReference
   * @generated
   */
  EClass getRoleAttributeTypeReference();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.RoleAttributeTypeReference#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see eu.ascens.helenaText.RoleAttributeTypeReference#getRef()
   * @see #getRoleAttributeTypeReference()
   * @generated
   */
  EReference getRoleAttributeTypeReference_Ref();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ComponentAttributeTypeReference <em>Component Attribute Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Attribute Type Reference</em>'.
   * @see eu.ascens.helenaText.ComponentAttributeTypeReference
   * @generated
   */
  EClass getComponentAttributeTypeReference();

  /**
   * Returns the meta object for the reference '{@link eu.ascens.helenaText.ComponentAttributeTypeReference#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see eu.ascens.helenaText.ComponentAttributeTypeReference#getRef()
   * @see #getComponentAttributeTypeReference()
   * @generated
   */
  EReference getComponentAttributeTypeReference_Ref();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.ActualDataParamsBlock <em>Actual Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Actual Data Params Block</em>'.
   * @see eu.ascens.helenaText.ActualDataParamsBlock
   * @generated
   */
  EClass getActualDataParamsBlock();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.ActualDataParamsBlock#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see eu.ascens.helenaText.ActualDataParamsBlock#getParams()
   * @see #getActualDataParamsBlock()
   * @generated
   */
  EReference getActualDataParamsBlock_Params();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractDuplicateFreeObject <em>Abstract Duplicate Free Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Duplicate Free Object</em>'.
   * @see eu.ascens.helenaText.AbstractDuplicateFreeObject
   * @generated
   */
  EClass getAbstractDuplicateFreeObject();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractHelenaEntity <em>Abstract Helena Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Helena Entity</em>'.
   * @see eu.ascens.helenaText.AbstractHelenaEntity
   * @generated
   */
  EClass getAbstractHelenaEntity();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.AbstractHelenaEntity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.AbstractHelenaEntity#getName()
   * @see #getAbstractHelenaEntity()
   * @generated
   */
  EAttribute getAbstractHelenaEntity_Name();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractFieldType <em>Abstract Field Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Field Type</em>'.
   * @see eu.ascens.helenaText.AbstractFieldType
   * @generated
   */
  EClass getAbstractFieldType();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.AbstractFieldType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see eu.ascens.helenaText.AbstractFieldType#getName()
   * @see #getAbstractFieldType()
   * @generated
   */
  EAttribute getAbstractFieldType_Name();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractRoleBehaviorEntity <em>Abstract Role Behavior Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Role Behavior Entity</em>'.
   * @see eu.ascens.helenaText.AbstractRoleBehaviorEntity
   * @generated
   */
  EClass getAbstractRoleBehaviorEntity();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AbstractInstance <em>Abstract Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Instance</em>'.
   * @see eu.ascens.helenaText.AbstractInstance
   * @generated
   */
  EClass getAbstractInstance();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.DeclaringRoleBehavior <em>Declaring Role Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Declaring Role Behavior</em>'.
   * @see eu.ascens.helenaText.DeclaringRoleBehavior
   * @generated
   */
  EClass getDeclaringRoleBehavior();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.DeclaringRoleBehavior#getProcessExpr <em>Process Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Process Expr</em>'.
   * @see eu.ascens.helenaText.DeclaringRoleBehavior#getProcessExpr()
   * @see #getDeclaringRoleBehavior()
   * @generated
   */
  EReference getDeclaringRoleBehavior_ProcessExpr();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.InvokingRoleBehavior <em>Invoking Role Behavior</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invoking Role Behavior</em>'.
   * @see eu.ascens.helenaText.InvokingRoleBehavior
   * @generated
   */
  EClass getInvokingRoleBehavior();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.InvokingRoleBehavior#getProcessInvocation <em>Process Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Process Invocation</em>'.
   * @see eu.ascens.helenaText.InvokingRoleBehavior#getProcessInvocation()
   * @see #getInvokingRoleBehavior()
   * @generated
   */
  EReference getInvokingRoleBehavior_ProcessInvocation();

  /**
   * Returns the meta object for the containment reference list '{@link eu.ascens.helenaText.InvokingRoleBehavior#getProcesses <em>Processes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Processes</em>'.
   * @see eu.ascens.helenaText.InvokingRoleBehavior#getProcesses()
   * @see #getInvokingRoleBehavior()
   * @generated
   */
  EReference getInvokingRoleBehavior_Processes();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.QuitTerm <em>Quit Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quit Term</em>'.
   * @see eu.ascens.helenaText.QuitTerm
   * @generated
   */
  EClass getQuitTerm();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.GetAssignment <em>Get Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Get Assignment</em>'.
   * @see eu.ascens.helenaText.GetAssignment
   * @generated
   */
  EClass getGetAssignment();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.CreateAssignment <em>Create Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Create Assignment</em>'.
   * @see eu.ascens.helenaText.CreateAssignment
   * @generated
   */
  EClass getCreateAssignment();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.OrTerm <em>Or Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Term</em>'.
   * @see eu.ascens.helenaText.OrTerm
   * @generated
   */
  EClass getOrTerm();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OrTerm#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see eu.ascens.helenaText.OrTerm#getLeft()
   * @see #getOrTerm()
   * @generated
   */
  EReference getOrTerm_Left();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.OrTerm#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see eu.ascens.helenaText.OrTerm#getRight()
   * @see #getOrTerm()
   * @generated
   */
  EReference getOrTerm_Right();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.AndTerm <em>And Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Term</em>'.
   * @see eu.ascens.helenaText.AndTerm
   * @generated
   */
  EClass getAndTerm();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.AndTerm#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see eu.ascens.helenaText.AndTerm#getLeft()
   * @see #getAndTerm()
   * @generated
   */
  EReference getAndTerm_Left();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.AndTerm#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see eu.ascens.helenaText.AndTerm#getRight()
   * @see #getAndTerm()
   * @generated
   */
  EReference getAndTerm_Right();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.EqualityTerm <em>Equality Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Term</em>'.
   * @see eu.ascens.helenaText.EqualityTerm
   * @generated
   */
  EClass getEqualityTerm();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.EqualityTerm#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see eu.ascens.helenaText.EqualityTerm#getLeft()
   * @see #getEqualityTerm()
   * @generated
   */
  EReference getEqualityTerm_Left();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.EqualityTerm#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see eu.ascens.helenaText.EqualityTerm#getOperator()
   * @see #getEqualityTerm()
   * @generated
   */
  EAttribute getEqualityTerm_Operator();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.EqualityTerm#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see eu.ascens.helenaText.EqualityTerm#getRight()
   * @see #getEqualityTerm()
   * @generated
   */
  EReference getEqualityTerm_Right();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.NotTerm <em>Not Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Term</em>'.
   * @see eu.ascens.helenaText.NotTerm
   * @generated
   */
  EClass getNotTerm();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.NotTerm#getNot <em>Not</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Not</em>'.
   * @see eu.ascens.helenaText.NotTerm#getNot()
   * @see #getNotTerm()
   * @generated
   */
  EAttribute getNotTerm_Not();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.NotTerm#getAtom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Atom</em>'.
   * @see eu.ascens.helenaText.NotTerm#getAtom()
   * @see #getNotTerm()
   * @generated
   */
  EReference getNotTerm_Atom();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.SelfReference <em>Self Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Self Reference</em>'.
   * @see eu.ascens.helenaText.SelfReference
   * @generated
   */
  EClass getSelfReference();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Addition <em>Addition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Addition</em>'.
   * @see eu.ascens.helenaText.Addition
   * @generated
   */
  EClass getAddition();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Addition#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see eu.ascens.helenaText.Addition#getLeft()
   * @see #getAddition()
   * @generated
   */
  EReference getAddition_Left();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.Addition#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see eu.ascens.helenaText.Addition#getOperator()
   * @see #getAddition()
   * @generated
   */
  EAttribute getAddition_Operator();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Addition#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see eu.ascens.helenaText.Addition#getRight()
   * @see #getAddition()
   * @generated
   */
  EReference getAddition_Right();

  /**
   * Returns the meta object for class '{@link eu.ascens.helenaText.Subtraction <em>Subtraction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subtraction</em>'.
   * @see eu.ascens.helenaText.Subtraction
   * @generated
   */
  EClass getSubtraction();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Subtraction#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see eu.ascens.helenaText.Subtraction#getLeft()
   * @see #getSubtraction()
   * @generated
   */
  EReference getSubtraction_Left();

  /**
   * Returns the meta object for the attribute '{@link eu.ascens.helenaText.Subtraction#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see eu.ascens.helenaText.Subtraction#getOperator()
   * @see #getSubtraction()
   * @generated
   */
  EAttribute getSubtraction_Operator();

  /**
   * Returns the meta object for the containment reference '{@link eu.ascens.helenaText.Subtraction#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see eu.ascens.helenaText.Subtraction#getRight()
   * @see #getSubtraction()
   * @generated
   */
  EReference getSubtraction_Right();

  /**
   * Returns the meta object for enum '{@link eu.ascens.helenaText.MsgDirection <em>Msg Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Msg Direction</em>'.
   * @see eu.ascens.helenaText.MsgDirection
   * @generated
   */
  EEnum getMsgDirection();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  HelenaTextFactory getHelenaTextFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ModelImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Head Pkg</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__HEAD_PKG = eINSTANCE.getModel_HeadPkg();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.PackageDeclarationImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getPackageDeclaration()
     * @generated
     */
    EClass PACKAGE_DECLARATION = eINSTANCE.getPackageDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DECLARATION__NAME = eINSTANCE.getPackageDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Comp Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__COMP_TYPES = eINSTANCE.getPackageDeclaration_CompTypes();

    /**
     * The meta object literal for the '<em><b>Role Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__ROLE_TYPES = eINSTANCE.getPackageDeclaration_RoleTypes();

    /**
     * The meta object literal for the '<em><b>Ens Structs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__ENS_STRUCTS = eINSTANCE.getPackageDeclaration_EnsStructs();

    /**
     * The meta object literal for the '<em><b>Role Behaviors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__ROLE_BEHAVIORS = eINSTANCE.getPackageDeclaration_RoleBehaviors();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ComponentTypeImpl <em>Component Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ComponentTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentType()
     * @generated
     */
    EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

    /**
     * The meta object literal for the '<em><b>Attrs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_TYPE__ATTRS = eINSTANCE.getComponentType_Attrs();

    /**
     * The meta object literal for the '<em><b>Assocs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_TYPE__ASSOCS = eINSTANCE.getComponentType_Assocs();

    /**
     * The meta object literal for the '<em><b>Ops</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_TYPE__OPS = eINSTANCE.getComponentType_Ops();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractComponentFieldTypeImpl <em>Abstract Component Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractComponentFieldTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractComponentFieldType()
     * @generated
     */
    EClass ABSTRACT_COMPONENT_FIELD_TYPE = eINSTANCE.getAbstractComponentFieldType();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ComponentAttributeTypeImpl <em>Component Attribute Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ComponentAttributeTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAttributeType()
     * @generated
     */
    EClass COMPONENT_ATTRIBUTE_TYPE = eINSTANCE.getComponentAttributeType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ATTRIBUTE_TYPE__TYPE = eINSTANCE.getComponentAttributeType_Type();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ComponentAssociationTypeImpl <em>Component Association Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ComponentAssociationTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAssociationType()
     * @generated
     */
    EClass COMPONENT_ASSOCIATION_TYPE = eINSTANCE.getComponentAssociationType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ASSOCIATION_TYPE__TYPE = eINSTANCE.getComponentAssociationType_Type();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.OperationTypeImpl <em>Operation Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.OperationTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOperationType()
     * @generated
     */
    EClass OPERATION_TYPE = eINSTANCE.getOperationType();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_TYPE__RETURN_TYPE = eINSTANCE.getOperationType_ReturnType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_TYPE__NAME = eINSTANCE.getOperationType_Name();

    /**
     * The meta object literal for the '<em><b>Formal Data Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK = eINSTANCE.getOperationType_FormalDataParamsBlock();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleTypeImpl <em>Role Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleType()
     * @generated
     */
    EClass ROLE_TYPE = eINSTANCE.getRoleType();

    /**
     * The meta object literal for the '<em><b>Comp Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_TYPE__COMP_TYPES = eINSTANCE.getRoleType_CompTypes();

    /**
     * The meta object literal for the '<em><b>Roleattrs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_TYPE__ROLEATTRS = eINSTANCE.getRoleType_Roleattrs();

    /**
     * The meta object literal for the '<em><b>Rolemsgs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_TYPE__ROLEMSGS = eINSTANCE.getRoleType_Rolemsgs();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleAttributeTypeImpl <em>Role Attribute Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleAttributeTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleAttributeType()
     * @generated
     */
    EClass ROLE_ATTRIBUTE_TYPE = eINSTANCE.getRoleAttributeType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_ATTRIBUTE_TYPE__TYPE = eINSTANCE.getRoleAttributeType_Type();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.MessageTypeImpl <em>Message Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.MessageTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getMessageType()
     * @generated
     */
    EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MESSAGE_TYPE__DIRECTION = eINSTANCE.getMessageType_Direction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MESSAGE_TYPE__NAME = eINSTANCE.getMessageType_Name();

    /**
     * The meta object literal for the '<em><b>Formal Role Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK = eINSTANCE.getMessageType_FormalRoleParamsBlock();

    /**
     * The meta object literal for the '<em><b>Formal Data Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK = eINSTANCE.getMessageType_FormalDataParamsBlock();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.EnsembleStructureImpl <em>Ensemble Structure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.EnsembleStructureImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getEnsembleStructure()
     * @generated
     */
    EClass ENSEMBLE_STRUCTURE = eINSTANCE.getEnsembleStructure();

    /**
     * The meta object literal for the '<em><b>Rt With Mult</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENSEMBLE_STRUCTURE__RT_WITH_MULT = eINSTANCE.getEnsembleStructure_RtWithMult();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl <em>Role Type With Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleTypeWithMultiplicity()
     * @generated
     */
    EClass ROLE_TYPE_WITH_MULTIPLICITY = eINSTANCE.getRoleTypeWithMultiplicity();

    /**
     * The meta object literal for the '<em><b>Role Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE = eINSTANCE.getRoleTypeWithMultiplicity_RoleType();

    /**
     * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROLE_TYPE_WITH_MULTIPLICITY__MIN = eINSTANCE.getRoleTypeWithMultiplicity_Min();

    /**
     * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROLE_TYPE_WITH_MULTIPLICITY__MAX = eINSTANCE.getRoleTypeWithMultiplicity_Max();

    /**
     * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY = eINSTANCE.getRoleTypeWithMultiplicity_Capacity();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleBehaviorImpl <em>Role Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleBehaviorImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleBehavior()
     * @generated
     */
    EClass ROLE_BEHAVIOR = eINSTANCE.getRoleBehavior();

    /**
     * The meta object literal for the '<em><b>Role Type Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_BEHAVIOR__ROLE_TYPE_REF = eINSTANCE.getRoleBehavior_RoleTypeRef();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ProcessImpl <em>Process</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ProcessImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getProcess()
     * @generated
     */
    EClass PROCESS = eINSTANCE.getProcess();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROCESS__NAME = eINSTANCE.getProcess_Name();

    /**
     * The meta object literal for the '<em><b>Process Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROCESS__PROCESS_EXPR = eINSTANCE.getProcess_ProcessExpr();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ProcessExpressionImpl <em>Process Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ProcessExpressionImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getProcessExpression()
     * @generated
     */
    EClass PROCESS_EXPRESSION = eINSTANCE.getProcessExpression();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ActionPrefixImpl <em>Action Prefix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ActionPrefixImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getActionPrefix()
     * @generated
     */
    EClass ACTION_PREFIX = eINSTANCE.getActionPrefix();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_PREFIX__ACTION = eINSTANCE.getActionPrefix_Action();

    /**
     * The meta object literal for the '<em><b>Process Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_PREFIX__PROCESS_EXPR = eINSTANCE.getActionPrefix_ProcessExpr();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.NondeterministicChoiceImpl <em>Nondeterministic Choice</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.NondeterministicChoiceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getNondeterministicChoice()
     * @generated
     */
    EClass NONDETERMINISTIC_CHOICE = eINSTANCE.getNondeterministicChoice();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NONDETERMINISTIC_CHOICE__FIRST = eINSTANCE.getNondeterministicChoice_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NONDETERMINISTIC_CHOICE__SECOND = eINSTANCE.getNondeterministicChoice_Second();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.IfThenElseImpl <em>If Then Else</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.IfThenElseImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getIfThenElse()
     * @generated
     */
    EClass IF_THEN_ELSE = eINSTANCE.getIfThenElse();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE__GUARD = eINSTANCE.getIfThenElse_Guard();

    /**
     * The meta object literal for the '<em><b>If Process Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE__IF_PROCESS_EXPR = eINSTANCE.getIfThenElse_IfProcessExpr();

    /**
     * The meta object literal for the '<em><b>Else Process Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE__ELSE_PROCESS_EXPR = eINSTANCE.getIfThenElse_ElseProcessExpr();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ProcessInvocationImpl <em>Process Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ProcessInvocationImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getProcessInvocation()
     * @generated
     */
    EClass PROCESS_INVOCATION = eINSTANCE.getProcessInvocation();

    /**
     * The meta object literal for the '<em><b>Process</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROCESS_INVOCATION__PROCESS = eINSTANCE.getProcessInvocation_Process();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ActionImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractAssignmentImpl <em>Abstract Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractAssignmentImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractAssignment()
     * @generated
     */
    EClass ABSTRACT_ASSIGNMENT = eINSTANCE.getAbstractAssignment();

    /**
     * The meta object literal for the '<em><b>Role Inst</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ASSIGNMENT__ROLE_INST = eINSTANCE.getAbstractAssignment_RoleInst();

    /**
     * The meta object literal for the '<em><b>Role Type Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF = eINSTANCE.getAbstractAssignment_RoleTypeRef();

    /**
     * The meta object literal for the '<em><b>Comp Instance</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ASSIGNMENT__COMP_INSTANCE = eINSTANCE.getAbstractAssignment_CompInstance();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractMessageCallImpl <em>Abstract Message Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractMessageCallImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractMessageCall()
     * @generated
     */
    EClass ABSTRACT_MESSAGE_CALL = eINSTANCE.getAbstractMessageCall();

    /**
     * The meta object literal for the '<em><b>Msg Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_MESSAGE_CALL__MSG_NAME = eINSTANCE.getAbstractMessageCall_MsgName();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.OutgoingMessageCallImpl <em>Outgoing Message Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.OutgoingMessageCallImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOutgoingMessageCall()
     * @generated
     */
    EClass OUTGOING_MESSAGE_CALL = eINSTANCE.getOutgoingMessageCall();

    /**
     * The meta object literal for the '<em><b>Receiver</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTGOING_MESSAGE_CALL__RECEIVER = eINSTANCE.getOutgoingMessageCall_Receiver();

    /**
     * The meta object literal for the '<em><b>Actual Role Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK = eINSTANCE.getOutgoingMessageCall_ActualRoleParamsBlock();

    /**
     * The meta object literal for the '<em><b>Actual Data Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK = eINSTANCE.getOutgoingMessageCall_ActualDataParamsBlock();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.IncomingMessageCallImpl <em>Incoming Message Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.IncomingMessageCallImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getIncomingMessageCall()
     * @generated
     */
    EClass INCOMING_MESSAGE_CALL = eINSTANCE.getIncomingMessageCall();

    /**
     * The meta object literal for the '<em><b>Formal Role Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK = eINSTANCE.getIncomingMessageCall_FormalRoleParamsBlock();

    /**
     * The meta object literal for the '<em><b>Formal Data Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK = eINSTANCE.getIncomingMessageCall_FormalDataParamsBlock();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.OperationCallImpl <em>Operation Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.OperationCallImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOperationCall()
     * @generated
     */
    EClass OPERATION_CALL = eINSTANCE.getOperationCall();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL__VARIABLE = eINSTANCE.getOperationCall_Variable();

    /**
     * The meta object literal for the '<em><b>Op Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_CALL__OP_NAME = eINSTANCE.getOperationCall_OpName();

    /**
     * The meta object literal for the '<em><b>Actual Data Params Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK = eINSTANCE.getOperationCall_ActualDataParamsBlock();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ComponentAttributeSetterImpl <em>Component Attribute Setter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ComponentAttributeSetterImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAttributeSetter()
     * @generated
     */
    EClass COMPONENT_ATTRIBUTE_SETTER = eINSTANCE.getComponentAttributeSetter();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ATTRIBUTE_SETTER__ATTR = eINSTANCE.getComponentAttributeSetter_Attr();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ATTRIBUTE_SETTER__VALUE = eINSTANCE.getComponentAttributeSetter_Value();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleAttributeSetterImpl <em>Role Attribute Setter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleAttributeSetterImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleAttributeSetter()
     * @generated
     */
    EClass ROLE_ATTRIBUTE_SETTER = eINSTANCE.getRoleAttributeSetter();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_ATTRIBUTE_SETTER__ATTR = eINSTANCE.getRoleAttributeSetter_Attr();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_ATTRIBUTE_SETTER__VALUE = eINSTANCE.getRoleAttributeSetter_Value();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.LabelImpl <em>Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.LabelImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getLabel()
     * @generated
     */
    EClass LABEL = eINSTANCE.getLabel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.GuardImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AtomImpl <em>Atom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AtomImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAtom()
     * @generated
     */
    EClass ATOM = eINSTANCE.getAtom();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.PlaysQueryImpl <em>Plays Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.PlaysQueryImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getPlaysQuery()
     * @generated
     */
    EClass PLAYS_QUERY = eINSTANCE.getPlaysQuery();

    /**
     * The meta object literal for the '<em><b>Role Type Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLAYS_QUERY__ROLE_TYPE_REF = eINSTANCE.getPlaysQuery_RoleTypeRef();

    /**
     * The meta object literal for the '<em><b>Comp Instance</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLAYS_QUERY__COMP_INSTANCE = eINSTANCE.getPlaysQuery_CompInstance();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RelationImpl <em>Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RelationImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRelation()
     * @generated
     */
    EClass RELATION = eINSTANCE.getRelation();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATION__LEFT = eINSTANCE.getRelation_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATION__OPERATOR = eINSTANCE.getRelation_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATION__RIGHT = eINSTANCE.getRelation_Right();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.GuardInParenthesesImpl <em>Guard In Parentheses</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.GuardInParenthesesImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getGuardInParentheses()
     * @generated
     */
    EClass GUARD_IN_PARENTHESES = eINSTANCE.getGuardInParentheses();

    /**
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD_IN_PARENTHESES__GUARD = eINSTANCE.getGuardInParentheses_Guard();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractDataValueImpl <em>Abstract Data Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractDataValueImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataValue()
     * @generated
     */
    EClass ABSTRACT_DATA_VALUE = eINSTANCE.getAbstractDataValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_DATA_VALUE__VALUE = eINSTANCE.getAbstractDataValue_Value();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.BooleanValueImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getBooleanValue()
     * @generated
     */
    EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.NumberValueImpl <em>Number Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.NumberValueImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getNumberValue()
     * @generated
     */
    EClass NUMBER_VALUE = eINSTANCE.getNumberValue();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.StringValueImpl <em>String Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.StringValueImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getStringValue()
     * @generated
     */
    EClass STRING_VALUE = eINSTANCE.getStringValue();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ComponentInstanceImpl <em>Component Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ComponentInstanceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentInstance()
     * @generated
     */
    EClass COMPONENT_INSTANCE = eINSTANCE.getComponentInstance();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ComponentAssociationTypeReferenceImpl <em>Component Association Type Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ComponentAssociationTypeReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAssociationTypeReference()
     * @generated
     */
    EClass COMPONENT_ASSOCIATION_TYPE_REFERENCE = eINSTANCE.getComponentAssociationTypeReference();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ASSOCIATION_TYPE_REFERENCE__REF = eINSTANCE.getComponentAssociationTypeReference_Ref();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.OwnerReferenceImpl <em>Owner Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.OwnerReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOwnerReference()
     * @generated
     */
    EClass OWNER_REFERENCE = eINSTANCE.getOwnerReference();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractRoleInstanceImpl <em>Abstract Role Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractRoleInstanceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractRoleInstance()
     * @generated
     */
    EClass ABSTRACT_ROLE_INSTANCE = eINSTANCE.getAbstractRoleInstance();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_ROLE_INSTANCE__NAME = eINSTANCE.getAbstractRoleInstance_Name();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleInstanceVariableImpl <em>Role Instance Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleInstanceVariableImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleInstanceVariable()
     * @generated
     */
    EClass ROLE_INSTANCE_VARIABLE = eINSTANCE.getRoleInstanceVariable();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.FormalRoleParamImpl <em>Formal Role Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.FormalRoleParamImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalRoleParam()
     * @generated
     */
    EClass FORMAL_ROLE_PARAM = eINSTANCE.getFormalRoleParam();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_ROLE_PARAM__TYPE = eINSTANCE.getFormalRoleParam_Type();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.FormalRoleParamsBlockImpl <em>Formal Role Params Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.FormalRoleParamsBlockImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalRoleParamsBlock()
     * @generated
     */
    EClass FORMAL_ROLE_PARAMS_BLOCK = eINSTANCE.getFormalRoleParamsBlock();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_ROLE_PARAMS_BLOCK__PARAMS = eINSTANCE.getFormalRoleParamsBlock_Params();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleInstanceReferenceImpl <em>Role Instance Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleInstanceReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleInstanceReference()
     * @generated
     */
    EClass ROLE_INSTANCE_REFERENCE = eINSTANCE.getRoleInstanceReference();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractRoleInstanceReferenceImpl <em>Abstract Role Instance Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractRoleInstanceReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractRoleInstanceReference()
     * @generated
     */
    EClass ABSTRACT_ROLE_INSTANCE_REFERENCE = eINSTANCE.getAbstractRoleInstanceReference();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ROLE_INSTANCE_REFERENCE__REF = eINSTANCE.getAbstractRoleInstanceReference_Ref();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ActualRoleParamsBlockImpl <em>Actual Role Params Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ActualRoleParamsBlockImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getActualRoleParamsBlock()
     * @generated
     */
    EClass ACTUAL_ROLE_PARAMS_BLOCK = eINSTANCE.getActualRoleParamsBlock();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTUAL_ROLE_PARAMS_BLOCK__PARAMS = eINSTANCE.getActualRoleParamsBlock_Params();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractDataVariableImpl <em>Abstract Data Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractDataVariableImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataVariable()
     * @generated
     */
    EClass ABSTRACT_DATA_VARIABLE = eINSTANCE.getAbstractDataVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_DATA_VARIABLE__NAME = eINSTANCE.getAbstractDataVariable_Name();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.DataVariableImpl <em>Data Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.DataVariableImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getDataVariable()
     * @generated
     */
    EClass DATA_VARIABLE = eINSTANCE.getDataVariable();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.FormalDataParamImpl <em>Formal Data Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.FormalDataParamImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalDataParam()
     * @generated
     */
    EClass FORMAL_DATA_PARAM = eINSTANCE.getFormalDataParam();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_DATA_PARAM__TYPE = eINSTANCE.getFormalDataParam_Type();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.FormalDataParamsBlockImpl <em>Formal Data Params Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.FormalDataParamsBlockImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getFormalDataParamsBlock()
     * @generated
     */
    EClass FORMAL_DATA_PARAMS_BLOCK = eINSTANCE.getFormalDataParamsBlock();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMAL_DATA_PARAMS_BLOCK__PARAMS = eINSTANCE.getFormalDataParamsBlock_Params();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.DataExpressionImpl <em>Data Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.DataExpressionImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getDataExpression()
     * @generated
     */
    EClass DATA_EXPRESSION = eINSTANCE.getDataExpression();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractDataReferenceImpl <em>Abstract Data Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractDataReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataReference()
     * @generated
     */
    EClass ABSTRACT_DATA_REFERENCE = eINSTANCE.getAbstractDataReference();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractDataVariableReferenceImpl <em>Abstract Data Variable Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractDataVariableReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDataVariableReference()
     * @generated
     */
    EClass ABSTRACT_DATA_VARIABLE_REFERENCE = eINSTANCE.getAbstractDataVariableReference();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_DATA_VARIABLE_REFERENCE__REF = eINSTANCE.getAbstractDataVariableReference_Ref();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.RoleAttributeTypeReferenceImpl <em>Role Attribute Type Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.RoleAttributeTypeReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getRoleAttributeTypeReference()
     * @generated
     */
    EClass ROLE_ATTRIBUTE_TYPE_REFERENCE = eINSTANCE.getRoleAttributeTypeReference();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROLE_ATTRIBUTE_TYPE_REFERENCE__REF = eINSTANCE.getRoleAttributeTypeReference_Ref();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ComponentAttributeTypeReferenceImpl <em>Component Attribute Type Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ComponentAttributeTypeReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getComponentAttributeTypeReference()
     * @generated
     */
    EClass COMPONENT_ATTRIBUTE_TYPE_REFERENCE = eINSTANCE.getComponentAttributeTypeReference();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_ATTRIBUTE_TYPE_REFERENCE__REF = eINSTANCE.getComponentAttributeTypeReference_Ref();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.ActualDataParamsBlockImpl <em>Actual Data Params Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.ActualDataParamsBlockImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getActualDataParamsBlock()
     * @generated
     */
    EClass ACTUAL_DATA_PARAMS_BLOCK = eINSTANCE.getActualDataParamsBlock();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTUAL_DATA_PARAMS_BLOCK__PARAMS = eINSTANCE.getActualDataParamsBlock_Params();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractDuplicateFreeObjectImpl <em>Abstract Duplicate Free Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractDuplicateFreeObjectImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractDuplicateFreeObject()
     * @generated
     */
    EClass ABSTRACT_DUPLICATE_FREE_OBJECT = eINSTANCE.getAbstractDuplicateFreeObject();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractHelenaEntityImpl <em>Abstract Helena Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractHelenaEntityImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractHelenaEntity()
     * @generated
     */
    EClass ABSTRACT_HELENA_ENTITY = eINSTANCE.getAbstractHelenaEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_HELENA_ENTITY__NAME = eINSTANCE.getAbstractHelenaEntity_Name();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractFieldTypeImpl <em>Abstract Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractFieldTypeImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractFieldType()
     * @generated
     */
    EClass ABSTRACT_FIELD_TYPE = eINSTANCE.getAbstractFieldType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_FIELD_TYPE__NAME = eINSTANCE.getAbstractFieldType_Name();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractRoleBehaviorEntityImpl <em>Abstract Role Behavior Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractRoleBehaviorEntityImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractRoleBehaviorEntity()
     * @generated
     */
    EClass ABSTRACT_ROLE_BEHAVIOR_ENTITY = eINSTANCE.getAbstractRoleBehaviorEntity();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AbstractInstanceImpl <em>Abstract Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AbstractInstanceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAbstractInstance()
     * @generated
     */
    EClass ABSTRACT_INSTANCE = eINSTANCE.getAbstractInstance();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.DeclaringRoleBehaviorImpl <em>Declaring Role Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.DeclaringRoleBehaviorImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getDeclaringRoleBehavior()
     * @generated
     */
    EClass DECLARING_ROLE_BEHAVIOR = eINSTANCE.getDeclaringRoleBehavior();

    /**
     * The meta object literal for the '<em><b>Process Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR = eINSTANCE.getDeclaringRoleBehavior_ProcessExpr();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.InvokingRoleBehaviorImpl <em>Invoking Role Behavior</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.InvokingRoleBehaviorImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getInvokingRoleBehavior()
     * @generated
     */
    EClass INVOKING_ROLE_BEHAVIOR = eINSTANCE.getInvokingRoleBehavior();

    /**
     * The meta object literal for the '<em><b>Process Invocation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION = eINSTANCE.getInvokingRoleBehavior_ProcessInvocation();

    /**
     * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOKING_ROLE_BEHAVIOR__PROCESSES = eINSTANCE.getInvokingRoleBehavior_Processes();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.QuitTermImpl <em>Quit Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.QuitTermImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getQuitTerm()
     * @generated
     */
    EClass QUIT_TERM = eINSTANCE.getQuitTerm();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.GetAssignmentImpl <em>Get Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.GetAssignmentImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getGetAssignment()
     * @generated
     */
    EClass GET_ASSIGNMENT = eINSTANCE.getGetAssignment();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.CreateAssignmentImpl <em>Create Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.CreateAssignmentImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getCreateAssignment()
     * @generated
     */
    EClass CREATE_ASSIGNMENT = eINSTANCE.getCreateAssignment();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.OrTermImpl <em>Or Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.OrTermImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getOrTerm()
     * @generated
     */
    EClass OR_TERM = eINSTANCE.getOrTerm();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_TERM__LEFT = eINSTANCE.getOrTerm_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_TERM__RIGHT = eINSTANCE.getOrTerm_Right();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AndTermImpl <em>And Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AndTermImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAndTerm()
     * @generated
     */
    EClass AND_TERM = eINSTANCE.getAndTerm();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_TERM__LEFT = eINSTANCE.getAndTerm_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_TERM__RIGHT = eINSTANCE.getAndTerm_Right();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.EqualityTermImpl <em>Equality Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.EqualityTermImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getEqualityTerm()
     * @generated
     */
    EClass EQUALITY_TERM = eINSTANCE.getEqualityTerm();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_TERM__LEFT = eINSTANCE.getEqualityTerm_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_TERM__OPERATOR = eINSTANCE.getEqualityTerm_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_TERM__RIGHT = eINSTANCE.getEqualityTerm_Right();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.NotTermImpl <em>Not Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.NotTermImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getNotTerm()
     * @generated
     */
    EClass NOT_TERM = eINSTANCE.getNotTerm();

    /**
     * The meta object literal for the '<em><b>Not</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NOT_TERM__NOT = eINSTANCE.getNotTerm_Not();

    /**
     * The meta object literal for the '<em><b>Atom</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_TERM__ATOM = eINSTANCE.getNotTerm_Atom();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.SelfReferenceImpl <em>Self Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.SelfReferenceImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getSelfReference()
     * @generated
     */
    EClass SELF_REFERENCE = eINSTANCE.getSelfReference();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.AdditionImpl <em>Addition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.AdditionImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getAddition()
     * @generated
     */
    EClass ADDITION = eINSTANCE.getAddition();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITION__LEFT = eINSTANCE.getAddition_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITION__OPERATOR = eINSTANCE.getAddition_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITION__RIGHT = eINSTANCE.getAddition_Right();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.impl.SubtractionImpl <em>Subtraction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.impl.SubtractionImpl
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getSubtraction()
     * @generated
     */
    EClass SUBTRACTION = eINSTANCE.getSubtraction();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTRACTION__LEFT = eINSTANCE.getSubtraction_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBTRACTION__OPERATOR = eINSTANCE.getSubtraction_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBTRACTION__RIGHT = eINSTANCE.getSubtraction_Right();

    /**
     * The meta object literal for the '{@link eu.ascens.helenaText.MsgDirection <em>Msg Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see eu.ascens.helenaText.MsgDirection
     * @see eu.ascens.helenaText.impl.HelenaTextPackageImpl#getMsgDirection()
     * @generated
     */
    EEnum MSG_DIRECTION = eINSTANCE.getMsgDirection();

  }

} //HelenaTextPackage
