/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.ascens.helenaText.HelenaTextPackage
 * @generated
 */
public interface HelenaTextFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HelenaTextFactory eINSTANCE = eu.ascens.helenaText.impl.HelenaTextFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Declaration</em>'.
   * @generated
   */
  PackageDeclaration createPackageDeclaration();

  /**
   * Returns a new object of class '<em>Component Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Type</em>'.
   * @generated
   */
  ComponentType createComponentType();

  /**
   * Returns a new object of class '<em>Abstract Component Field Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Component Field Type</em>'.
   * @generated
   */
  AbstractComponentFieldType createAbstractComponentFieldType();

  /**
   * Returns a new object of class '<em>Component Attribute Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Attribute Type</em>'.
   * @generated
   */
  ComponentAttributeType createComponentAttributeType();

  /**
   * Returns a new object of class '<em>Component Association Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Association Type</em>'.
   * @generated
   */
  ComponentAssociationType createComponentAssociationType();

  /**
   * Returns a new object of class '<em>Operation Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Type</em>'.
   * @generated
   */
  OperationType createOperationType();

  /**
   * Returns a new object of class '<em>Role Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Type</em>'.
   * @generated
   */
  RoleType createRoleType();

  /**
   * Returns a new object of class '<em>Role Attribute Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Attribute Type</em>'.
   * @generated
   */
  RoleAttributeType createRoleAttributeType();

  /**
   * Returns a new object of class '<em>Message Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Message Type</em>'.
   * @generated
   */
  MessageType createMessageType();

  /**
   * Returns a new object of class '<em>Ensemble Structure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ensemble Structure</em>'.
   * @generated
   */
  EnsembleStructure createEnsembleStructure();

  /**
   * Returns a new object of class '<em>Role Type With Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Type With Multiplicity</em>'.
   * @generated
   */
  RoleTypeWithMultiplicity createRoleTypeWithMultiplicity();

  /**
   * Returns a new object of class '<em>Role Behavior</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Behavior</em>'.
   * @generated
   */
  RoleBehavior createRoleBehavior();

  /**
   * Returns a new object of class '<em>Process</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process</em>'.
   * @generated
   */
  Process createProcess();

  /**
   * Returns a new object of class '<em>Process Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Expression</em>'.
   * @generated
   */
  ProcessExpression createProcessExpression();

  /**
   * Returns a new object of class '<em>Action Prefix</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action Prefix</em>'.
   * @generated
   */
  ActionPrefix createActionPrefix();

  /**
   * Returns a new object of class '<em>Nondeterministic Choice</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nondeterministic Choice</em>'.
   * @generated
   */
  NondeterministicChoice createNondeterministicChoice();

  /**
   * Returns a new object of class '<em>If Then Else</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Then Else</em>'.
   * @generated
   */
  IfThenElse createIfThenElse();

  /**
   * Returns a new object of class '<em>Process Invocation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Invocation</em>'.
   * @generated
   */
  ProcessInvocation createProcessInvocation();

  /**
   * Returns a new object of class '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action</em>'.
   * @generated
   */
  Action createAction();

  /**
   * Returns a new object of class '<em>Abstract Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Assignment</em>'.
   * @generated
   */
  AbstractAssignment createAbstractAssignment();

  /**
   * Returns a new object of class '<em>Abstract Message Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Message Call</em>'.
   * @generated
   */
  AbstractMessageCall createAbstractMessageCall();

  /**
   * Returns a new object of class '<em>Outgoing Message Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Outgoing Message Call</em>'.
   * @generated
   */
  OutgoingMessageCall createOutgoingMessageCall();

  /**
   * Returns a new object of class '<em>Incoming Message Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Incoming Message Call</em>'.
   * @generated
   */
  IncomingMessageCall createIncomingMessageCall();

  /**
   * Returns a new object of class '<em>Operation Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Call</em>'.
   * @generated
   */
  OperationCall createOperationCall();

  /**
   * Returns a new object of class '<em>Component Attribute Setter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Attribute Setter</em>'.
   * @generated
   */
  ComponentAttributeSetter createComponentAttributeSetter();

  /**
   * Returns a new object of class '<em>Role Attribute Setter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Attribute Setter</em>'.
   * @generated
   */
  RoleAttributeSetter createRoleAttributeSetter();

  /**
   * Returns a new object of class '<em>Label</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Label</em>'.
   * @generated
   */
  Label createLabel();

  /**
   * Returns a new object of class '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard</em>'.
   * @generated
   */
  Guard createGuard();

  /**
   * Returns a new object of class '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atom</em>'.
   * @generated
   */
  Atom createAtom();

  /**
   * Returns a new object of class '<em>Plays Query</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plays Query</em>'.
   * @generated
   */
  PlaysQuery createPlaysQuery();

  /**
   * Returns a new object of class '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relation</em>'.
   * @generated
   */
  Relation createRelation();

  /**
   * Returns a new object of class '<em>Guard In Parentheses</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard In Parentheses</em>'.
   * @generated
   */
  GuardInParentheses createGuardInParentheses();

  /**
   * Returns a new object of class '<em>Abstract Data Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Data Value</em>'.
   * @generated
   */
  AbstractDataValue createAbstractDataValue();

  /**
   * Returns a new object of class '<em>Boolean Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Value</em>'.
   * @generated
   */
  BooleanValue createBooleanValue();

  /**
   * Returns a new object of class '<em>Number Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Value</em>'.
   * @generated
   */
  NumberValue createNumberValue();

  /**
   * Returns a new object of class '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Value</em>'.
   * @generated
   */
  StringValue createStringValue();

  /**
   * Returns a new object of class '<em>Component Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Instance</em>'.
   * @generated
   */
  ComponentInstance createComponentInstance();

  /**
   * Returns a new object of class '<em>Component Association Type Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Association Type Reference</em>'.
   * @generated
   */
  ComponentAssociationTypeReference createComponentAssociationTypeReference();

  /**
   * Returns a new object of class '<em>Owner Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Owner Reference</em>'.
   * @generated
   */
  OwnerReference createOwnerReference();

  /**
   * Returns a new object of class '<em>Abstract Role Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Role Instance</em>'.
   * @generated
   */
  AbstractRoleInstance createAbstractRoleInstance();

  /**
   * Returns a new object of class '<em>Role Instance Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Instance Variable</em>'.
   * @generated
   */
  RoleInstanceVariable createRoleInstanceVariable();

  /**
   * Returns a new object of class '<em>Formal Role Param</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Role Param</em>'.
   * @generated
   */
  FormalRoleParam createFormalRoleParam();

  /**
   * Returns a new object of class '<em>Formal Role Params Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Role Params Block</em>'.
   * @generated
   */
  FormalRoleParamsBlock createFormalRoleParamsBlock();

  /**
   * Returns a new object of class '<em>Role Instance Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Instance Reference</em>'.
   * @generated
   */
  RoleInstanceReference createRoleInstanceReference();

  /**
   * Returns a new object of class '<em>Abstract Role Instance Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Role Instance Reference</em>'.
   * @generated
   */
  AbstractRoleInstanceReference createAbstractRoleInstanceReference();

  /**
   * Returns a new object of class '<em>Actual Role Params Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actual Role Params Block</em>'.
   * @generated
   */
  ActualRoleParamsBlock createActualRoleParamsBlock();

  /**
   * Returns a new object of class '<em>Abstract Data Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Data Variable</em>'.
   * @generated
   */
  AbstractDataVariable createAbstractDataVariable();

  /**
   * Returns a new object of class '<em>Data Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Variable</em>'.
   * @generated
   */
  DataVariable createDataVariable();

  /**
   * Returns a new object of class '<em>Formal Data Param</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Data Param</em>'.
   * @generated
   */
  FormalDataParam createFormalDataParam();

  /**
   * Returns a new object of class '<em>Formal Data Params Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Data Params Block</em>'.
   * @generated
   */
  FormalDataParamsBlock createFormalDataParamsBlock();

  /**
   * Returns a new object of class '<em>Data Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Expression</em>'.
   * @generated
   */
  DataExpression createDataExpression();

  /**
   * Returns a new object of class '<em>Abstract Data Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Data Reference</em>'.
   * @generated
   */
  AbstractDataReference createAbstractDataReference();

  /**
   * Returns a new object of class '<em>Abstract Data Variable Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Data Variable Reference</em>'.
   * @generated
   */
  AbstractDataVariableReference createAbstractDataVariableReference();

  /**
   * Returns a new object of class '<em>Role Attribute Type Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Attribute Type Reference</em>'.
   * @generated
   */
  RoleAttributeTypeReference createRoleAttributeTypeReference();

  /**
   * Returns a new object of class '<em>Component Attribute Type Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Attribute Type Reference</em>'.
   * @generated
   */
  ComponentAttributeTypeReference createComponentAttributeTypeReference();

  /**
   * Returns a new object of class '<em>Actual Data Params Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actual Data Params Block</em>'.
   * @generated
   */
  ActualDataParamsBlock createActualDataParamsBlock();

  /**
   * Returns a new object of class '<em>Abstract Duplicate Free Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Duplicate Free Object</em>'.
   * @generated
   */
  AbstractDuplicateFreeObject createAbstractDuplicateFreeObject();

  /**
   * Returns a new object of class '<em>Abstract Helena Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Helena Entity</em>'.
   * @generated
   */
  AbstractHelenaEntity createAbstractHelenaEntity();

  /**
   * Returns a new object of class '<em>Abstract Field Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Field Type</em>'.
   * @generated
   */
  AbstractFieldType createAbstractFieldType();

  /**
   * Returns a new object of class '<em>Abstract Role Behavior Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Role Behavior Entity</em>'.
   * @generated
   */
  AbstractRoleBehaviorEntity createAbstractRoleBehaviorEntity();

  /**
   * Returns a new object of class '<em>Abstract Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Instance</em>'.
   * @generated
   */
  AbstractInstance createAbstractInstance();

  /**
   * Returns a new object of class '<em>Declaring Role Behavior</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaring Role Behavior</em>'.
   * @generated
   */
  DeclaringRoleBehavior createDeclaringRoleBehavior();

  /**
   * Returns a new object of class '<em>Invoking Role Behavior</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invoking Role Behavior</em>'.
   * @generated
   */
  InvokingRoleBehavior createInvokingRoleBehavior();

  /**
   * Returns a new object of class '<em>Quit Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quit Term</em>'.
   * @generated
   */
  QuitTerm createQuitTerm();

  /**
   * Returns a new object of class '<em>Get Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Get Assignment</em>'.
   * @generated
   */
  GetAssignment createGetAssignment();

  /**
   * Returns a new object of class '<em>Create Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Create Assignment</em>'.
   * @generated
   */
  CreateAssignment createCreateAssignment();

  /**
   * Returns a new object of class '<em>Or Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Term</em>'.
   * @generated
   */
  OrTerm createOrTerm();

  /**
   * Returns a new object of class '<em>And Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Term</em>'.
   * @generated
   */
  AndTerm createAndTerm();

  /**
   * Returns a new object of class '<em>Equality Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Term</em>'.
   * @generated
   */
  EqualityTerm createEqualityTerm();

  /**
   * Returns a new object of class '<em>Not Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not Term</em>'.
   * @generated
   */
  NotTerm createNotTerm();

  /**
   * Returns a new object of class '<em>Self Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Self Reference</em>'.
   * @generated
   */
  SelfReference createSelfReference();

  /**
   * Returns a new object of class '<em>Addition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Addition</em>'.
   * @generated
   */
  Addition createAddition();

  /**
   * Returns a new object of class '<em>Subtraction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subtraction</em>'.
   * @generated
   */
  Subtraction createSubtraction();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  HelenaTextPackage getHelenaTextPackage();

} //HelenaTextFactory
