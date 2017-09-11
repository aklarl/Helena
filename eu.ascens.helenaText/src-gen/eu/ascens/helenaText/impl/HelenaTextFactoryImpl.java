/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.AbstractComponentFieldType;
import eu.ascens.helenaText.AbstractDataReference;
import eu.ascens.helenaText.AbstractDataValue;
import eu.ascens.helenaText.AbstractDataVariable;
import eu.ascens.helenaText.AbstractDataVariableReference;
import eu.ascens.helenaText.AbstractDuplicateFreeObject;
import eu.ascens.helenaText.AbstractFieldType;
import eu.ascens.helenaText.AbstractHelenaEntity;
import eu.ascens.helenaText.AbstractInstance;
import eu.ascens.helenaText.AbstractMessageCall;
import eu.ascens.helenaText.AbstractRoleBehaviorEntity;
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
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.CreateAssignment;
import eu.ascens.helenaText.DataExpression;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.DeclaringRoleBehavior;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.EqualityTerm;
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.GetAssignment;
import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.GuardInParentheses;
import eu.ascens.helenaText.HelenaTextFactory;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.InvokingRoleBehavior;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.MsgDirection;
import eu.ascens.helenaText.NondeterministicChoice;
import eu.ascens.helenaText.NotTerm;
import eu.ascens.helenaText.NumberValue;
import eu.ascens.helenaText.OperationCall;
import eu.ascens.helenaText.OperationType;
import eu.ascens.helenaText.OrTerm;
import eu.ascens.helenaText.OutgoingMessageCall;
import eu.ascens.helenaText.OwnerReference;
import eu.ascens.helenaText.PackageDeclaration;
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
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import eu.ascens.helenaText.SelfReference;
import eu.ascens.helenaText.StringValue;
import eu.ascens.helenaText.Subtraction;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HelenaTextFactoryImpl extends EFactoryImpl implements HelenaTextFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HelenaTextFactory init()
  {
    try
    {
      HelenaTextFactory theHelenaTextFactory = (HelenaTextFactory)EPackage.Registry.INSTANCE.getEFactory(HelenaTextPackage.eNS_URI);
      if (theHelenaTextFactory != null)
      {
        return theHelenaTextFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new HelenaTextFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HelenaTextFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case HelenaTextPackage.MODEL: return createModel();
      case HelenaTextPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case HelenaTextPackage.COMPONENT_TYPE: return createComponentType();
      case HelenaTextPackage.ABSTRACT_COMPONENT_FIELD_TYPE: return createAbstractComponentFieldType();
      case HelenaTextPackage.COMPONENT_ATTRIBUTE_TYPE: return createComponentAttributeType();
      case HelenaTextPackage.COMPONENT_ASSOCIATION_TYPE: return createComponentAssociationType();
      case HelenaTextPackage.OPERATION_TYPE: return createOperationType();
      case HelenaTextPackage.ROLE_TYPE: return createRoleType();
      case HelenaTextPackage.ROLE_ATTRIBUTE_TYPE: return createRoleAttributeType();
      case HelenaTextPackage.MESSAGE_TYPE: return createMessageType();
      case HelenaTextPackage.ENSEMBLE_STRUCTURE: return createEnsembleStructure();
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY: return createRoleTypeWithMultiplicity();
      case HelenaTextPackage.ROLE_BEHAVIOR: return createRoleBehavior();
      case HelenaTextPackage.PROCESS: return createProcess();
      case HelenaTextPackage.PROCESS_EXPRESSION: return createProcessExpression();
      case HelenaTextPackage.ACTION_PREFIX: return createActionPrefix();
      case HelenaTextPackage.NONDETERMINISTIC_CHOICE: return createNondeterministicChoice();
      case HelenaTextPackage.IF_THEN_ELSE: return createIfThenElse();
      case HelenaTextPackage.PROCESS_INVOCATION: return createProcessInvocation();
      case HelenaTextPackage.ACTION: return createAction();
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT: return createAbstractAssignment();
      case HelenaTextPackage.ABSTRACT_MESSAGE_CALL: return createAbstractMessageCall();
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL: return createOutgoingMessageCall();
      case HelenaTextPackage.INCOMING_MESSAGE_CALL: return createIncomingMessageCall();
      case HelenaTextPackage.OPERATION_CALL: return createOperationCall();
      case HelenaTextPackage.COMPONENT_ATTRIBUTE_SETTER: return createComponentAttributeSetter();
      case HelenaTextPackage.ROLE_ATTRIBUTE_SETTER: return createRoleAttributeSetter();
      case HelenaTextPackage.LABEL: return createLabel();
      case HelenaTextPackage.GUARD: return createGuard();
      case HelenaTextPackage.ATOM: return createAtom();
      case HelenaTextPackage.PLAYS_QUERY: return createPlaysQuery();
      case HelenaTextPackage.RELATION: return createRelation();
      case HelenaTextPackage.GUARD_IN_PARENTHESES: return createGuardInParentheses();
      case HelenaTextPackage.ABSTRACT_DATA_VALUE: return createAbstractDataValue();
      case HelenaTextPackage.BOOLEAN_VALUE: return createBooleanValue();
      case HelenaTextPackage.NUMBER_VALUE: return createNumberValue();
      case HelenaTextPackage.STRING_VALUE: return createStringValue();
      case HelenaTextPackage.COMPONENT_INSTANCE: return createComponentInstance();
      case HelenaTextPackage.COMPONENT_ASSOCIATION_TYPE_REFERENCE: return createComponentAssociationTypeReference();
      case HelenaTextPackage.OWNER_REFERENCE: return createOwnerReference();
      case HelenaTextPackage.ABSTRACT_ROLE_INSTANCE: return createAbstractRoleInstance();
      case HelenaTextPackage.ROLE_INSTANCE_VARIABLE: return createRoleInstanceVariable();
      case HelenaTextPackage.FORMAL_ROLE_PARAM: return createFormalRoleParam();
      case HelenaTextPackage.FORMAL_ROLE_PARAMS_BLOCK: return createFormalRoleParamsBlock();
      case HelenaTextPackage.ROLE_INSTANCE_REFERENCE: return createRoleInstanceReference();
      case HelenaTextPackage.ABSTRACT_ROLE_INSTANCE_REFERENCE: return createAbstractRoleInstanceReference();
      case HelenaTextPackage.ACTUAL_ROLE_PARAMS_BLOCK: return createActualRoleParamsBlock();
      case HelenaTextPackage.ABSTRACT_DATA_VARIABLE: return createAbstractDataVariable();
      case HelenaTextPackage.DATA_VARIABLE: return createDataVariable();
      case HelenaTextPackage.FORMAL_DATA_PARAM: return createFormalDataParam();
      case HelenaTextPackage.FORMAL_DATA_PARAMS_BLOCK: return createFormalDataParamsBlock();
      case HelenaTextPackage.DATA_EXPRESSION: return createDataExpression();
      case HelenaTextPackage.ABSTRACT_DATA_REFERENCE: return createAbstractDataReference();
      case HelenaTextPackage.ABSTRACT_DATA_VARIABLE_REFERENCE: return createAbstractDataVariableReference();
      case HelenaTextPackage.ROLE_ATTRIBUTE_TYPE_REFERENCE: return createRoleAttributeTypeReference();
      case HelenaTextPackage.COMPONENT_ATTRIBUTE_TYPE_REFERENCE: return createComponentAttributeTypeReference();
      case HelenaTextPackage.ACTUAL_DATA_PARAMS_BLOCK: return createActualDataParamsBlock();
      case HelenaTextPackage.ABSTRACT_DUPLICATE_FREE_OBJECT: return createAbstractDuplicateFreeObject();
      case HelenaTextPackage.ABSTRACT_HELENA_ENTITY: return createAbstractHelenaEntity();
      case HelenaTextPackage.ABSTRACT_FIELD_TYPE: return createAbstractFieldType();
      case HelenaTextPackage.ABSTRACT_ROLE_BEHAVIOR_ENTITY: return createAbstractRoleBehaviorEntity();
      case HelenaTextPackage.ABSTRACT_INSTANCE: return createAbstractInstance();
      case HelenaTextPackage.DECLARING_ROLE_BEHAVIOR: return createDeclaringRoleBehavior();
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR: return createInvokingRoleBehavior();
      case HelenaTextPackage.QUIT_TERM: return createQuitTerm();
      case HelenaTextPackage.GET_ASSIGNMENT: return createGetAssignment();
      case HelenaTextPackage.CREATE_ASSIGNMENT: return createCreateAssignment();
      case HelenaTextPackage.OR_TERM: return createOrTerm();
      case HelenaTextPackage.AND_TERM: return createAndTerm();
      case HelenaTextPackage.EQUALITY_TERM: return createEqualityTerm();
      case HelenaTextPackage.NOT_TERM: return createNotTerm();
      case HelenaTextPackage.SELF_REFERENCE: return createSelfReference();
      case HelenaTextPackage.ADDITION: return createAddition();
      case HelenaTextPackage.SUBTRACTION: return createSubtraction();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case HelenaTextPackage.MSG_DIRECTION:
        return createMsgDirectionFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case HelenaTextPackage.MSG_DIRECTION:
        return convertMsgDirectionToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentType createComponentType()
  {
    ComponentTypeImpl componentType = new ComponentTypeImpl();
    return componentType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractComponentFieldType createAbstractComponentFieldType()
  {
    AbstractComponentFieldTypeImpl abstractComponentFieldType = new AbstractComponentFieldTypeImpl();
    return abstractComponentFieldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentAttributeType createComponentAttributeType()
  {
    ComponentAttributeTypeImpl componentAttributeType = new ComponentAttributeTypeImpl();
    return componentAttributeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentAssociationType createComponentAssociationType()
  {
    ComponentAssociationTypeImpl componentAssociationType = new ComponentAssociationTypeImpl();
    return componentAssociationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationType createOperationType()
  {
    OperationTypeImpl operationType = new OperationTypeImpl();
    return operationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleType createRoleType()
  {
    RoleTypeImpl roleType = new RoleTypeImpl();
    return roleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleAttributeType createRoleAttributeType()
  {
    RoleAttributeTypeImpl roleAttributeType = new RoleAttributeTypeImpl();
    return roleAttributeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessageType createMessageType()
  {
    MessageTypeImpl messageType = new MessageTypeImpl();
    return messageType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnsembleStructure createEnsembleStructure()
  {
    EnsembleStructureImpl ensembleStructure = new EnsembleStructureImpl();
    return ensembleStructure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleTypeWithMultiplicity createRoleTypeWithMultiplicity()
  {
    RoleTypeWithMultiplicityImpl roleTypeWithMultiplicity = new RoleTypeWithMultiplicityImpl();
    return roleTypeWithMultiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleBehavior createRoleBehavior()
  {
    RoleBehaviorImpl roleBehavior = new RoleBehaviorImpl();
    return roleBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public eu.ascens.helenaText.Process createProcess()
  {
    ProcessImpl process = new ProcessImpl();
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessExpression createProcessExpression()
  {
    ProcessExpressionImpl processExpression = new ProcessExpressionImpl();
    return processExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionPrefix createActionPrefix()
  {
    ActionPrefixImpl actionPrefix = new ActionPrefixImpl();
    return actionPrefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NondeterministicChoice createNondeterministicChoice()
  {
    NondeterministicChoiceImpl nondeterministicChoice = new NondeterministicChoiceImpl();
    return nondeterministicChoice;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfThenElse createIfThenElse()
  {
    IfThenElseImpl ifThenElse = new IfThenElseImpl();
    return ifThenElse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessInvocation createProcessInvocation()
  {
    ProcessInvocationImpl processInvocation = new ProcessInvocationImpl();
    return processInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractAssignment createAbstractAssignment()
  {
    AbstractAssignmentImpl abstractAssignment = new AbstractAssignmentImpl();
    return abstractAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMessageCall createAbstractMessageCall()
  {
    AbstractMessageCallImpl abstractMessageCall = new AbstractMessageCallImpl();
    return abstractMessageCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutgoingMessageCall createOutgoingMessageCall()
  {
    OutgoingMessageCallImpl outgoingMessageCall = new OutgoingMessageCallImpl();
    return outgoingMessageCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncomingMessageCall createIncomingMessageCall()
  {
    IncomingMessageCallImpl incomingMessageCall = new IncomingMessageCallImpl();
    return incomingMessageCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCall createOperationCall()
  {
    OperationCallImpl operationCall = new OperationCallImpl();
    return operationCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentAttributeSetter createComponentAttributeSetter()
  {
    ComponentAttributeSetterImpl componentAttributeSetter = new ComponentAttributeSetterImpl();
    return componentAttributeSetter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleAttributeSetter createRoleAttributeSetter()
  {
    RoleAttributeSetterImpl roleAttributeSetter = new RoleAttributeSetterImpl();
    return roleAttributeSetter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Label createLabel()
  {
    LabelImpl label = new LabelImpl();
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Atom createAtom()
  {
    AtomImpl atom = new AtomImpl();
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PlaysQuery createPlaysQuery()
  {
    PlaysQueryImpl playsQuery = new PlaysQueryImpl();
    return playsQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relation createRelation()
  {
    RelationImpl relation = new RelationImpl();
    return relation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardInParentheses createGuardInParentheses()
  {
    GuardInParenthesesImpl guardInParentheses = new GuardInParenthesesImpl();
    return guardInParentheses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDataValue createAbstractDataValue()
  {
    AbstractDataValueImpl abstractDataValue = new AbstractDataValueImpl();
    return abstractDataValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanValue createBooleanValue()
  {
    BooleanValueImpl booleanValue = new BooleanValueImpl();
    return booleanValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberValue createNumberValue()
  {
    NumberValueImpl numberValue = new NumberValueImpl();
    return numberValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringValue createStringValue()
  {
    StringValueImpl stringValue = new StringValueImpl();
    return stringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentInstance createComponentInstance()
  {
    ComponentInstanceImpl componentInstance = new ComponentInstanceImpl();
    return componentInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentAssociationTypeReference createComponentAssociationTypeReference()
  {
    ComponentAssociationTypeReferenceImpl componentAssociationTypeReference = new ComponentAssociationTypeReferenceImpl();
    return componentAssociationTypeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OwnerReference createOwnerReference()
  {
    OwnerReferenceImpl ownerReference = new OwnerReferenceImpl();
    return ownerReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractRoleInstance createAbstractRoleInstance()
  {
    AbstractRoleInstanceImpl abstractRoleInstance = new AbstractRoleInstanceImpl();
    return abstractRoleInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleInstanceVariable createRoleInstanceVariable()
  {
    RoleInstanceVariableImpl roleInstanceVariable = new RoleInstanceVariableImpl();
    return roleInstanceVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalRoleParam createFormalRoleParam()
  {
    FormalRoleParamImpl formalRoleParam = new FormalRoleParamImpl();
    return formalRoleParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalRoleParamsBlock createFormalRoleParamsBlock()
  {
    FormalRoleParamsBlockImpl formalRoleParamsBlock = new FormalRoleParamsBlockImpl();
    return formalRoleParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleInstanceReference createRoleInstanceReference()
  {
    RoleInstanceReferenceImpl roleInstanceReference = new RoleInstanceReferenceImpl();
    return roleInstanceReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractRoleInstanceReference createAbstractRoleInstanceReference()
  {
    AbstractRoleInstanceReferenceImpl abstractRoleInstanceReference = new AbstractRoleInstanceReferenceImpl();
    return abstractRoleInstanceReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualRoleParamsBlock createActualRoleParamsBlock()
  {
    ActualRoleParamsBlockImpl actualRoleParamsBlock = new ActualRoleParamsBlockImpl();
    return actualRoleParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDataVariable createAbstractDataVariable()
  {
    AbstractDataVariableImpl abstractDataVariable = new AbstractDataVariableImpl();
    return abstractDataVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataVariable createDataVariable()
  {
    DataVariableImpl dataVariable = new DataVariableImpl();
    return dataVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalDataParam createFormalDataParam()
  {
    FormalDataParamImpl formalDataParam = new FormalDataParamImpl();
    return formalDataParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalDataParamsBlock createFormalDataParamsBlock()
  {
    FormalDataParamsBlockImpl formalDataParamsBlock = new FormalDataParamsBlockImpl();
    return formalDataParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataExpression createDataExpression()
  {
    DataExpressionImpl dataExpression = new DataExpressionImpl();
    return dataExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDataReference createAbstractDataReference()
  {
    AbstractDataReferenceImpl abstractDataReference = new AbstractDataReferenceImpl();
    return abstractDataReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDataVariableReference createAbstractDataVariableReference()
  {
    AbstractDataVariableReferenceImpl abstractDataVariableReference = new AbstractDataVariableReferenceImpl();
    return abstractDataVariableReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleAttributeTypeReference createRoleAttributeTypeReference()
  {
    RoleAttributeTypeReferenceImpl roleAttributeTypeReference = new RoleAttributeTypeReferenceImpl();
    return roleAttributeTypeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentAttributeTypeReference createComponentAttributeTypeReference()
  {
    ComponentAttributeTypeReferenceImpl componentAttributeTypeReference = new ComponentAttributeTypeReferenceImpl();
    return componentAttributeTypeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualDataParamsBlock createActualDataParamsBlock()
  {
    ActualDataParamsBlockImpl actualDataParamsBlock = new ActualDataParamsBlockImpl();
    return actualDataParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDuplicateFreeObject createAbstractDuplicateFreeObject()
  {
    AbstractDuplicateFreeObjectImpl abstractDuplicateFreeObject = new AbstractDuplicateFreeObjectImpl();
    return abstractDuplicateFreeObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractHelenaEntity createAbstractHelenaEntity()
  {
    AbstractHelenaEntityImpl abstractHelenaEntity = new AbstractHelenaEntityImpl();
    return abstractHelenaEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractFieldType createAbstractFieldType()
  {
    AbstractFieldTypeImpl abstractFieldType = new AbstractFieldTypeImpl();
    return abstractFieldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractRoleBehaviorEntity createAbstractRoleBehaviorEntity()
  {
    AbstractRoleBehaviorEntityImpl abstractRoleBehaviorEntity = new AbstractRoleBehaviorEntityImpl();
    return abstractRoleBehaviorEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractInstance createAbstractInstance()
  {
    AbstractInstanceImpl abstractInstance = new AbstractInstanceImpl();
    return abstractInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeclaringRoleBehavior createDeclaringRoleBehavior()
  {
    DeclaringRoleBehaviorImpl declaringRoleBehavior = new DeclaringRoleBehaviorImpl();
    return declaringRoleBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvokingRoleBehavior createInvokingRoleBehavior()
  {
    InvokingRoleBehaviorImpl invokingRoleBehavior = new InvokingRoleBehaviorImpl();
    return invokingRoleBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuitTerm createQuitTerm()
  {
    QuitTermImpl quitTerm = new QuitTermImpl();
    return quitTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GetAssignment createGetAssignment()
  {
    GetAssignmentImpl getAssignment = new GetAssignmentImpl();
    return getAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreateAssignment createCreateAssignment()
  {
    CreateAssignmentImpl createAssignment = new CreateAssignmentImpl();
    return createAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrTerm createOrTerm()
  {
    OrTermImpl orTerm = new OrTermImpl();
    return orTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndTerm createAndTerm()
  {
    AndTermImpl andTerm = new AndTermImpl();
    return andTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityTerm createEqualityTerm()
  {
    EqualityTermImpl equalityTerm = new EqualityTermImpl();
    return equalityTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotTerm createNotTerm()
  {
    NotTermImpl notTerm = new NotTermImpl();
    return notTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelfReference createSelfReference()
  {
    SelfReferenceImpl selfReference = new SelfReferenceImpl();
    return selfReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Addition createAddition()
  {
    AdditionImpl addition = new AdditionImpl();
    return addition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Subtraction createSubtraction()
  {
    SubtractionImpl subtraction = new SubtractionImpl();
    return subtraction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MsgDirection createMsgDirectionFromString(EDataType eDataType, String initialValue)
  {
    MsgDirection result = MsgDirection.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMsgDirectionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HelenaTextPackage getHelenaTextPackage()
  {
    return (HelenaTextPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static HelenaTextPackage getPackage()
  {
    return HelenaTextPackage.eINSTANCE;
  }

} //HelenaTextFactoryImpl
