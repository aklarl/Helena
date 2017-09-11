/**
 */
package eu.ascens.helenaText.util;

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
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.IncomingMessageCall;
import eu.ascens.helenaText.InvokingRoleBehavior;
import eu.ascens.helenaText.Label;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.ascens.helenaText.HelenaTextPackage
 * @generated
 */
public class HelenaTextSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HelenaTextPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HelenaTextSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = HelenaTextPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case HelenaTextPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.PACKAGE_DECLARATION:
      {
        PackageDeclaration packageDeclaration = (PackageDeclaration)theEObject;
        T result = casePackageDeclaration(packageDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.COMPONENT_TYPE:
      {
        ComponentType componentType = (ComponentType)theEObject;
        T result = caseComponentType(componentType);
        if (result == null) result = caseAbstractHelenaEntity(componentType);
        if (result == null) result = caseAbstractDuplicateFreeObject(componentType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_COMPONENT_FIELD_TYPE:
      {
        AbstractComponentFieldType abstractComponentFieldType = (AbstractComponentFieldType)theEObject;
        T result = caseAbstractComponentFieldType(abstractComponentFieldType);
        if (result == null) result = caseAbstractFieldType(abstractComponentFieldType);
        if (result == null) result = caseAbstractDuplicateFreeObject(abstractComponentFieldType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.COMPONENT_ATTRIBUTE_TYPE:
      {
        ComponentAttributeType componentAttributeType = (ComponentAttributeType)theEObject;
        T result = caseComponentAttributeType(componentAttributeType);
        if (result == null) result = caseAbstractComponentFieldType(componentAttributeType);
        if (result == null) result = caseAbstractFieldType(componentAttributeType);
        if (result == null) result = caseAbstractDuplicateFreeObject(componentAttributeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.COMPONENT_ASSOCIATION_TYPE:
      {
        ComponentAssociationType componentAssociationType = (ComponentAssociationType)theEObject;
        T result = caseComponentAssociationType(componentAssociationType);
        if (result == null) result = caseAbstractComponentFieldType(componentAssociationType);
        if (result == null) result = caseAbstractFieldType(componentAssociationType);
        if (result == null) result = caseAbstractDuplicateFreeObject(componentAssociationType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.OPERATION_TYPE:
      {
        OperationType operationType = (OperationType)theEObject;
        T result = caseOperationType(operationType);
        if (result == null) result = caseAbstractDuplicateFreeObject(operationType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_TYPE:
      {
        RoleType roleType = (RoleType)theEObject;
        T result = caseRoleType(roleType);
        if (result == null) result = caseAbstractHelenaEntity(roleType);
        if (result == null) result = caseAbstractDuplicateFreeObject(roleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_ATTRIBUTE_TYPE:
      {
        RoleAttributeType roleAttributeType = (RoleAttributeType)theEObject;
        T result = caseRoleAttributeType(roleAttributeType);
        if (result == null) result = caseAbstractFieldType(roleAttributeType);
        if (result == null) result = caseAbstractDuplicateFreeObject(roleAttributeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.MESSAGE_TYPE:
      {
        MessageType messageType = (MessageType)theEObject;
        T result = caseMessageType(messageType);
        if (result == null) result = caseAbstractDuplicateFreeObject(messageType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ENSEMBLE_STRUCTURE:
      {
        EnsembleStructure ensembleStructure = (EnsembleStructure)theEObject;
        T result = caseEnsembleStructure(ensembleStructure);
        if (result == null) result = caseAbstractHelenaEntity(ensembleStructure);
        if (result == null) result = caseAbstractDuplicateFreeObject(ensembleStructure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY:
      {
        RoleTypeWithMultiplicity roleTypeWithMultiplicity = (RoleTypeWithMultiplicity)theEObject;
        T result = caseRoleTypeWithMultiplicity(roleTypeWithMultiplicity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_BEHAVIOR:
      {
        RoleBehavior roleBehavior = (RoleBehavior)theEObject;
        T result = caseRoleBehavior(roleBehavior);
        if (result == null) result = caseAbstractDuplicateFreeObject(roleBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.PROCESS:
      {
        eu.ascens.helenaText.Process process = (eu.ascens.helenaText.Process)theEObject;
        T result = caseProcess(process);
        if (result == null) result = caseAbstractDuplicateFreeObject(process);
        if (result == null) result = caseAbstractRoleBehaviorEntity(process);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.PROCESS_EXPRESSION:
      {
        ProcessExpression processExpression = (ProcessExpression)theEObject;
        T result = caseProcessExpression(processExpression);
        if (result == null) result = caseAbstractRoleBehaviorEntity(processExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ACTION_PREFIX:
      {
        ActionPrefix actionPrefix = (ActionPrefix)theEObject;
        T result = caseActionPrefix(actionPrefix);
        if (result == null) result = caseProcessExpression(actionPrefix);
        if (result == null) result = caseAbstractRoleBehaviorEntity(actionPrefix);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.NONDETERMINISTIC_CHOICE:
      {
        NondeterministicChoice nondeterministicChoice = (NondeterministicChoice)theEObject;
        T result = caseNondeterministicChoice(nondeterministicChoice);
        if (result == null) result = caseProcessExpression(nondeterministicChoice);
        if (result == null) result = caseAbstractRoleBehaviorEntity(nondeterministicChoice);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.IF_THEN_ELSE:
      {
        IfThenElse ifThenElse = (IfThenElse)theEObject;
        T result = caseIfThenElse(ifThenElse);
        if (result == null) result = caseProcessExpression(ifThenElse);
        if (result == null) result = caseAbstractRoleBehaviorEntity(ifThenElse);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.PROCESS_INVOCATION:
      {
        ProcessInvocation processInvocation = (ProcessInvocation)theEObject;
        T result = caseProcessInvocation(processInvocation);
        if (result == null) result = caseProcessExpression(processInvocation);
        if (result == null) result = caseAbstractRoleBehaviorEntity(processInvocation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ACTION:
      {
        Action action = (Action)theEObject;
        T result = caseAction(action);
        if (result == null) result = caseAbstractRoleBehaviorEntity(action);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT:
      {
        AbstractAssignment abstractAssignment = (AbstractAssignment)theEObject;
        T result = caseAbstractAssignment(abstractAssignment);
        if (result == null) result = caseAction(abstractAssignment);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_MESSAGE_CALL:
      {
        AbstractMessageCall abstractMessageCall = (AbstractMessageCall)theEObject;
        T result = caseAbstractMessageCall(abstractMessageCall);
        if (result == null) result = caseAction(abstractMessageCall);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractMessageCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL:
      {
        OutgoingMessageCall outgoingMessageCall = (OutgoingMessageCall)theEObject;
        T result = caseOutgoingMessageCall(outgoingMessageCall);
        if (result == null) result = caseAbstractMessageCall(outgoingMessageCall);
        if (result == null) result = caseAction(outgoingMessageCall);
        if (result == null) result = caseAbstractRoleBehaviorEntity(outgoingMessageCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.INCOMING_MESSAGE_CALL:
      {
        IncomingMessageCall incomingMessageCall = (IncomingMessageCall)theEObject;
        T result = caseIncomingMessageCall(incomingMessageCall);
        if (result == null) result = caseAbstractMessageCall(incomingMessageCall);
        if (result == null) result = caseAction(incomingMessageCall);
        if (result == null) result = caseAbstractRoleBehaviorEntity(incomingMessageCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.OPERATION_CALL:
      {
        OperationCall operationCall = (OperationCall)theEObject;
        T result = caseOperationCall(operationCall);
        if (result == null) result = caseAction(operationCall);
        if (result == null) result = caseAbstractRoleBehaviorEntity(operationCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.COMPONENT_ATTRIBUTE_SETTER:
      {
        ComponentAttributeSetter componentAttributeSetter = (ComponentAttributeSetter)theEObject;
        T result = caseComponentAttributeSetter(componentAttributeSetter);
        if (result == null) result = caseAction(componentAttributeSetter);
        if (result == null) result = caseAbstractRoleBehaviorEntity(componentAttributeSetter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_ATTRIBUTE_SETTER:
      {
        RoleAttributeSetter roleAttributeSetter = (RoleAttributeSetter)theEObject;
        T result = caseRoleAttributeSetter(roleAttributeSetter);
        if (result == null) result = caseAction(roleAttributeSetter);
        if (result == null) result = caseAbstractRoleBehaviorEntity(roleAttributeSetter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.LABEL:
      {
        Label label = (Label)theEObject;
        T result = caseLabel(label);
        if (result == null) result = caseAction(label);
        if (result == null) result = caseAbstractDuplicateFreeObject(label);
        if (result == null) result = caseAbstractRoleBehaviorEntity(label);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.GUARD:
      {
        Guard guard = (Guard)theEObject;
        T result = caseGuard(guard);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ATOM:
      {
        Atom atom = (Atom)theEObject;
        T result = caseAtom(atom);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.PLAYS_QUERY:
      {
        PlaysQuery playsQuery = (PlaysQuery)theEObject;
        T result = casePlaysQuery(playsQuery);
        if (result == null) result = caseAtom(playsQuery);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.RELATION:
      {
        Relation relation = (Relation)theEObject;
        T result = caseRelation(relation);
        if (result == null) result = caseAtom(relation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.GUARD_IN_PARENTHESES:
      {
        GuardInParentheses guardInParentheses = (GuardInParentheses)theEObject;
        T result = caseGuardInParentheses(guardInParentheses);
        if (result == null) result = caseAtom(guardInParentheses);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_DATA_VALUE:
      {
        AbstractDataValue abstractDataValue = (AbstractDataValue)theEObject;
        T result = caseAbstractDataValue(abstractDataValue);
        if (result == null) result = caseDataExpression(abstractDataValue);
        if (result == null) result = caseAtom(abstractDataValue);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractDataValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.BOOLEAN_VALUE:
      {
        BooleanValue booleanValue = (BooleanValue)theEObject;
        T result = caseBooleanValue(booleanValue);
        if (result == null) result = caseAbstractDataValue(booleanValue);
        if (result == null) result = caseDataExpression(booleanValue);
        if (result == null) result = caseAtom(booleanValue);
        if (result == null) result = caseAbstractRoleBehaviorEntity(booleanValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.NUMBER_VALUE:
      {
        NumberValue numberValue = (NumberValue)theEObject;
        T result = caseNumberValue(numberValue);
        if (result == null) result = caseAbstractDataValue(numberValue);
        if (result == null) result = caseDataExpression(numberValue);
        if (result == null) result = caseAtom(numberValue);
        if (result == null) result = caseAbstractRoleBehaviorEntity(numberValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.STRING_VALUE:
      {
        StringValue stringValue = (StringValue)theEObject;
        T result = caseStringValue(stringValue);
        if (result == null) result = caseAbstractDataValue(stringValue);
        if (result == null) result = caseDataExpression(stringValue);
        if (result == null) result = caseAtom(stringValue);
        if (result == null) result = caseAbstractRoleBehaviorEntity(stringValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.COMPONENT_INSTANCE:
      {
        ComponentInstance componentInstance = (ComponentInstance)theEObject;
        T result = caseComponentInstance(componentInstance);
        if (result == null) result = caseAbstractRoleBehaviorEntity(componentInstance);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.COMPONENT_ASSOCIATION_TYPE_REFERENCE:
      {
        ComponentAssociationTypeReference componentAssociationTypeReference = (ComponentAssociationTypeReference)theEObject;
        T result = caseComponentAssociationTypeReference(componentAssociationTypeReference);
        if (result == null) result = caseComponentInstance(componentAssociationTypeReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(componentAssociationTypeReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.OWNER_REFERENCE:
      {
        OwnerReference ownerReference = (OwnerReference)theEObject;
        T result = caseOwnerReference(ownerReference);
        if (result == null) result = caseComponentInstance(ownerReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(ownerReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_ROLE_INSTANCE:
      {
        AbstractRoleInstance abstractRoleInstance = (AbstractRoleInstance)theEObject;
        T result = caseAbstractRoleInstance(abstractRoleInstance);
        if (result == null) result = caseAbstractDuplicateFreeObject(abstractRoleInstance);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractRoleInstance);
        if (result == null) result = caseAbstractInstance(abstractRoleInstance);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_INSTANCE_VARIABLE:
      {
        RoleInstanceVariable roleInstanceVariable = (RoleInstanceVariable)theEObject;
        T result = caseRoleInstanceVariable(roleInstanceVariable);
        if (result == null) result = caseAbstractRoleInstance(roleInstanceVariable);
        if (result == null) result = caseAbstractDuplicateFreeObject(roleInstanceVariable);
        if (result == null) result = caseAbstractRoleBehaviorEntity(roleInstanceVariable);
        if (result == null) result = caseAbstractInstance(roleInstanceVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.FORMAL_ROLE_PARAM:
      {
        FormalRoleParam formalRoleParam = (FormalRoleParam)theEObject;
        T result = caseFormalRoleParam(formalRoleParam);
        if (result == null) result = caseAbstractRoleInstance(formalRoleParam);
        if (result == null) result = caseAbstractDuplicateFreeObject(formalRoleParam);
        if (result == null) result = caseAbstractRoleBehaviorEntity(formalRoleParam);
        if (result == null) result = caseAbstractInstance(formalRoleParam);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.FORMAL_ROLE_PARAMS_BLOCK:
      {
        FormalRoleParamsBlock formalRoleParamsBlock = (FormalRoleParamsBlock)theEObject;
        T result = caseFormalRoleParamsBlock(formalRoleParamsBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_INSTANCE_REFERENCE:
      {
        RoleInstanceReference roleInstanceReference = (RoleInstanceReference)theEObject;
        T result = caseRoleInstanceReference(roleInstanceReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(roleInstanceReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_ROLE_INSTANCE_REFERENCE:
      {
        AbstractRoleInstanceReference abstractRoleInstanceReference = (AbstractRoleInstanceReference)theEObject;
        T result = caseAbstractRoleInstanceReference(abstractRoleInstanceReference);
        if (result == null) result = caseRoleInstanceReference(abstractRoleInstanceReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractRoleInstanceReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ACTUAL_ROLE_PARAMS_BLOCK:
      {
        ActualRoleParamsBlock actualRoleParamsBlock = (ActualRoleParamsBlock)theEObject;
        T result = caseActualRoleParamsBlock(actualRoleParamsBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_DATA_VARIABLE:
      {
        AbstractDataVariable abstractDataVariable = (AbstractDataVariable)theEObject;
        T result = caseAbstractDataVariable(abstractDataVariable);
        if (result == null) result = caseAbstractDuplicateFreeObject(abstractDataVariable);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractDataVariable);
        if (result == null) result = caseAbstractInstance(abstractDataVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.DATA_VARIABLE:
      {
        DataVariable dataVariable = (DataVariable)theEObject;
        T result = caseDataVariable(dataVariable);
        if (result == null) result = caseAbstractDataVariable(dataVariable);
        if (result == null) result = caseAbstractDuplicateFreeObject(dataVariable);
        if (result == null) result = caseAbstractRoleBehaviorEntity(dataVariable);
        if (result == null) result = caseAbstractInstance(dataVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.FORMAL_DATA_PARAM:
      {
        FormalDataParam formalDataParam = (FormalDataParam)theEObject;
        T result = caseFormalDataParam(formalDataParam);
        if (result == null) result = caseAbstractDataVariable(formalDataParam);
        if (result == null) result = caseAbstractDuplicateFreeObject(formalDataParam);
        if (result == null) result = caseAbstractRoleBehaviorEntity(formalDataParam);
        if (result == null) result = caseAbstractInstance(formalDataParam);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.FORMAL_DATA_PARAMS_BLOCK:
      {
        FormalDataParamsBlock formalDataParamsBlock = (FormalDataParamsBlock)theEObject;
        T result = caseFormalDataParamsBlock(formalDataParamsBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.DATA_EXPRESSION:
      {
        DataExpression dataExpression = (DataExpression)theEObject;
        T result = caseDataExpression(dataExpression);
        if (result == null) result = caseAtom(dataExpression);
        if (result == null) result = caseAbstractRoleBehaviorEntity(dataExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_DATA_REFERENCE:
      {
        AbstractDataReference abstractDataReference = (AbstractDataReference)theEObject;
        T result = caseAbstractDataReference(abstractDataReference);
        if (result == null) result = caseDataExpression(abstractDataReference);
        if (result == null) result = caseAtom(abstractDataReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractDataReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_DATA_VARIABLE_REFERENCE:
      {
        AbstractDataVariableReference abstractDataVariableReference = (AbstractDataVariableReference)theEObject;
        T result = caseAbstractDataVariableReference(abstractDataVariableReference);
        if (result == null) result = caseAbstractDataReference(abstractDataVariableReference);
        if (result == null) result = caseDataExpression(abstractDataVariableReference);
        if (result == null) result = caseAtom(abstractDataVariableReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(abstractDataVariableReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ROLE_ATTRIBUTE_TYPE_REFERENCE:
      {
        RoleAttributeTypeReference roleAttributeTypeReference = (RoleAttributeTypeReference)theEObject;
        T result = caseRoleAttributeTypeReference(roleAttributeTypeReference);
        if (result == null) result = caseAbstractDataReference(roleAttributeTypeReference);
        if (result == null) result = caseDataExpression(roleAttributeTypeReference);
        if (result == null) result = caseAtom(roleAttributeTypeReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(roleAttributeTypeReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.COMPONENT_ATTRIBUTE_TYPE_REFERENCE:
      {
        ComponentAttributeTypeReference componentAttributeTypeReference = (ComponentAttributeTypeReference)theEObject;
        T result = caseComponentAttributeTypeReference(componentAttributeTypeReference);
        if (result == null) result = caseAbstractDataReference(componentAttributeTypeReference);
        if (result == null) result = caseDataExpression(componentAttributeTypeReference);
        if (result == null) result = caseAtom(componentAttributeTypeReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(componentAttributeTypeReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ACTUAL_DATA_PARAMS_BLOCK:
      {
        ActualDataParamsBlock actualDataParamsBlock = (ActualDataParamsBlock)theEObject;
        T result = caseActualDataParamsBlock(actualDataParamsBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_DUPLICATE_FREE_OBJECT:
      {
        AbstractDuplicateFreeObject abstractDuplicateFreeObject = (AbstractDuplicateFreeObject)theEObject;
        T result = caseAbstractDuplicateFreeObject(abstractDuplicateFreeObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_HELENA_ENTITY:
      {
        AbstractHelenaEntity abstractHelenaEntity = (AbstractHelenaEntity)theEObject;
        T result = caseAbstractHelenaEntity(abstractHelenaEntity);
        if (result == null) result = caseAbstractDuplicateFreeObject(abstractHelenaEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_FIELD_TYPE:
      {
        AbstractFieldType abstractFieldType = (AbstractFieldType)theEObject;
        T result = caseAbstractFieldType(abstractFieldType);
        if (result == null) result = caseAbstractDuplicateFreeObject(abstractFieldType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_ROLE_BEHAVIOR_ENTITY:
      {
        AbstractRoleBehaviorEntity abstractRoleBehaviorEntity = (AbstractRoleBehaviorEntity)theEObject;
        T result = caseAbstractRoleBehaviorEntity(abstractRoleBehaviorEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ABSTRACT_INSTANCE:
      {
        AbstractInstance abstractInstance = (AbstractInstance)theEObject;
        T result = caseAbstractInstance(abstractInstance);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.DECLARING_ROLE_BEHAVIOR:
      {
        DeclaringRoleBehavior declaringRoleBehavior = (DeclaringRoleBehavior)theEObject;
        T result = caseDeclaringRoleBehavior(declaringRoleBehavior);
        if (result == null) result = caseRoleBehavior(declaringRoleBehavior);
        if (result == null) result = caseAbstractDuplicateFreeObject(declaringRoleBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR:
      {
        InvokingRoleBehavior invokingRoleBehavior = (InvokingRoleBehavior)theEObject;
        T result = caseInvokingRoleBehavior(invokingRoleBehavior);
        if (result == null) result = caseRoleBehavior(invokingRoleBehavior);
        if (result == null) result = caseAbstractDuplicateFreeObject(invokingRoleBehavior);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.QUIT_TERM:
      {
        QuitTerm quitTerm = (QuitTerm)theEObject;
        T result = caseQuitTerm(quitTerm);
        if (result == null) result = caseProcessExpression(quitTerm);
        if (result == null) result = caseAbstractRoleBehaviorEntity(quitTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.GET_ASSIGNMENT:
      {
        GetAssignment getAssignment = (GetAssignment)theEObject;
        T result = caseGetAssignment(getAssignment);
        if (result == null) result = caseAbstractAssignment(getAssignment);
        if (result == null) result = caseAction(getAssignment);
        if (result == null) result = caseAbstractRoleBehaviorEntity(getAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.CREATE_ASSIGNMENT:
      {
        CreateAssignment createAssignment = (CreateAssignment)theEObject;
        T result = caseCreateAssignment(createAssignment);
        if (result == null) result = caseAbstractAssignment(createAssignment);
        if (result == null) result = caseAction(createAssignment);
        if (result == null) result = caseAbstractRoleBehaviorEntity(createAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.OR_TERM:
      {
        OrTerm orTerm = (OrTerm)theEObject;
        T result = caseOrTerm(orTerm);
        if (result == null) result = caseGuard(orTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.AND_TERM:
      {
        AndTerm andTerm = (AndTerm)theEObject;
        T result = caseAndTerm(andTerm);
        if (result == null) result = caseGuard(andTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.EQUALITY_TERM:
      {
        EqualityTerm equalityTerm = (EqualityTerm)theEObject;
        T result = caseEqualityTerm(equalityTerm);
        if (result == null) result = caseGuard(equalityTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.NOT_TERM:
      {
        NotTerm notTerm = (NotTerm)theEObject;
        T result = caseNotTerm(notTerm);
        if (result == null) result = caseGuard(notTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.SELF_REFERENCE:
      {
        SelfReference selfReference = (SelfReference)theEObject;
        T result = caseSelfReference(selfReference);
        if (result == null) result = caseRoleInstanceReference(selfReference);
        if (result == null) result = caseAbstractRoleBehaviorEntity(selfReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.ADDITION:
      {
        Addition addition = (Addition)theEObject;
        T result = caseAddition(addition);
        if (result == null) result = caseDataExpression(addition);
        if (result == null) result = caseAtom(addition);
        if (result == null) result = caseAbstractRoleBehaviorEntity(addition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HelenaTextPackage.SUBTRACTION:
      {
        Subtraction subtraction = (Subtraction)theEObject;
        T result = caseSubtraction(subtraction);
        if (result == null) result = caseDataExpression(subtraction);
        if (result == null) result = caseAtom(subtraction);
        if (result == null) result = caseAbstractRoleBehaviorEntity(subtraction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDeclaration(PackageDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentType(ComponentType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Component Field Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Component Field Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractComponentFieldType(AbstractComponentFieldType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Attribute Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Attribute Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentAttributeType(ComponentAttributeType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Association Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Association Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentAssociationType(ComponentAssociationType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationType(OperationType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleType(RoleType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Attribute Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Attribute Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleAttributeType(RoleAttributeType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Message Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Message Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMessageType(MessageType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ensemble Structure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ensemble Structure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnsembleStructure(EnsembleStructure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Type With Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Type With Multiplicity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleTypeWithMultiplicity(RoleTypeWithMultiplicity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleBehavior(RoleBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Process</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcess(eu.ascens.helenaText.Process object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Process Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Process Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcessExpression(ProcessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action Prefix</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action Prefix</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActionPrefix(ActionPrefix object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nondeterministic Choice</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nondeterministic Choice</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNondeterministicChoice(NondeterministicChoice object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Then Else</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Then Else</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfThenElse(IfThenElse object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Process Invocation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Process Invocation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcessInvocation(ProcessInvocation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction(Action object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractAssignment(AbstractAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Message Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Message Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractMessageCall(AbstractMessageCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Outgoing Message Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Outgoing Message Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutgoingMessageCall(OutgoingMessageCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Incoming Message Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Incoming Message Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIncomingMessageCall(IncomingMessageCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationCall(OperationCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Attribute Setter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Attribute Setter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentAttributeSetter(ComponentAttributeSetter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Attribute Setter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Attribute Setter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleAttributeSetter(RoleAttributeSetter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Label</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLabel(Label object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuard(Guard object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtom(Atom object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plays Query</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plays Query</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlaysQuery(PlaysQuery object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelation(Relation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard In Parentheses</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard In Parentheses</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuardInParentheses(GuardInParentheses object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Data Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Data Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractDataValue(AbstractDataValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanValue(BooleanValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberValue(NumberValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringValue(StringValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentInstance(ComponentInstance object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Association Type Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Association Type Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentAssociationTypeReference(ComponentAssociationTypeReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Owner Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Owner Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOwnerReference(OwnerReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Role Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Role Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractRoleInstance(AbstractRoleInstance object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Instance Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Instance Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleInstanceVariable(RoleInstanceVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Role Param</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Role Param</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalRoleParam(FormalRoleParam object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Role Params Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Role Params Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalRoleParamsBlock(FormalRoleParamsBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Instance Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Instance Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleInstanceReference(RoleInstanceReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Role Instance Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Role Instance Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractRoleInstanceReference(AbstractRoleInstanceReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actual Role Params Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actual Role Params Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActualRoleParamsBlock(ActualRoleParamsBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Data Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Data Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractDataVariable(AbstractDataVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataVariable(DataVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Data Param</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Data Param</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalDataParam(FormalDataParam object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formal Data Params Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formal Data Params Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormalDataParamsBlock(FormalDataParamsBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataExpression(DataExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Data Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Data Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractDataReference(AbstractDataReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Data Variable Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Data Variable Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractDataVariableReference(AbstractDataVariableReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Role Attribute Type Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Role Attribute Type Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoleAttributeTypeReference(RoleAttributeTypeReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Attribute Type Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Attribute Type Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentAttributeTypeReference(ComponentAttributeTypeReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Actual Data Params Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Actual Data Params Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActualDataParamsBlock(ActualDataParamsBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Duplicate Free Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Duplicate Free Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractDuplicateFreeObject(AbstractDuplicateFreeObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Helena Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Helena Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractHelenaEntity(AbstractHelenaEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Field Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Field Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractFieldType(AbstractFieldType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Role Behavior Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Role Behavior Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractRoleBehaviorEntity(AbstractRoleBehaviorEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractInstance(AbstractInstance object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declaring Role Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declaring Role Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclaringRoleBehavior(DeclaringRoleBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invoking Role Behavior</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invoking Role Behavior</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvokingRoleBehavior(InvokingRoleBehavior object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quit Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quit Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuitTerm(QuitTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Get Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Get Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGetAssignment(GetAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Create Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Create Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCreateAssignment(CreateAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrTerm(OrTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndTerm(AndTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityTerm(EqualityTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotTerm(NotTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Self Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Self Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelfReference(SelfReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Addition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Addition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAddition(Addition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subtraction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subtraction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubtraction(Subtraction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //HelenaTextSwitch
