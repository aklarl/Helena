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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.ascens.helenaText.HelenaTextPackage
 * @generated
 */
public class HelenaTextAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HelenaTextPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HelenaTextAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = HelenaTextPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HelenaTextSwitch<Adapter> modelSwitch =
    new HelenaTextSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter casePackageDeclaration(PackageDeclaration object)
      {
        return createPackageDeclarationAdapter();
      }
      @Override
      public Adapter caseComponentType(ComponentType object)
      {
        return createComponentTypeAdapter();
      }
      @Override
      public Adapter caseAbstractComponentFieldType(AbstractComponentFieldType object)
      {
        return createAbstractComponentFieldTypeAdapter();
      }
      @Override
      public Adapter caseComponentAttributeType(ComponentAttributeType object)
      {
        return createComponentAttributeTypeAdapter();
      }
      @Override
      public Adapter caseComponentAssociationType(ComponentAssociationType object)
      {
        return createComponentAssociationTypeAdapter();
      }
      @Override
      public Adapter caseOperationType(OperationType object)
      {
        return createOperationTypeAdapter();
      }
      @Override
      public Adapter caseRoleType(RoleType object)
      {
        return createRoleTypeAdapter();
      }
      @Override
      public Adapter caseRoleAttributeType(RoleAttributeType object)
      {
        return createRoleAttributeTypeAdapter();
      }
      @Override
      public Adapter caseMessageType(MessageType object)
      {
        return createMessageTypeAdapter();
      }
      @Override
      public Adapter caseEnsembleStructure(EnsembleStructure object)
      {
        return createEnsembleStructureAdapter();
      }
      @Override
      public Adapter caseRoleTypeWithMultiplicity(RoleTypeWithMultiplicity object)
      {
        return createRoleTypeWithMultiplicityAdapter();
      }
      @Override
      public Adapter caseRoleBehavior(RoleBehavior object)
      {
        return createRoleBehaviorAdapter();
      }
      @Override
      public Adapter caseProcess(eu.ascens.helenaText.Process object)
      {
        return createProcessAdapter();
      }
      @Override
      public Adapter caseProcessExpression(ProcessExpression object)
      {
        return createProcessExpressionAdapter();
      }
      @Override
      public Adapter caseActionPrefix(ActionPrefix object)
      {
        return createActionPrefixAdapter();
      }
      @Override
      public Adapter caseNondeterministicChoice(NondeterministicChoice object)
      {
        return createNondeterministicChoiceAdapter();
      }
      @Override
      public Adapter caseIfThenElse(IfThenElse object)
      {
        return createIfThenElseAdapter();
      }
      @Override
      public Adapter caseProcessInvocation(ProcessInvocation object)
      {
        return createProcessInvocationAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseAbstractAssignment(AbstractAssignment object)
      {
        return createAbstractAssignmentAdapter();
      }
      @Override
      public Adapter caseAbstractMessageCall(AbstractMessageCall object)
      {
        return createAbstractMessageCallAdapter();
      }
      @Override
      public Adapter caseOutgoingMessageCall(OutgoingMessageCall object)
      {
        return createOutgoingMessageCallAdapter();
      }
      @Override
      public Adapter caseIncomingMessageCall(IncomingMessageCall object)
      {
        return createIncomingMessageCallAdapter();
      }
      @Override
      public Adapter caseOperationCall(OperationCall object)
      {
        return createOperationCallAdapter();
      }
      @Override
      public Adapter caseComponentAttributeSetter(ComponentAttributeSetter object)
      {
        return createComponentAttributeSetterAdapter();
      }
      @Override
      public Adapter caseRoleAttributeSetter(RoleAttributeSetter object)
      {
        return createRoleAttributeSetterAdapter();
      }
      @Override
      public Adapter caseLabel(Label object)
      {
        return createLabelAdapter();
      }
      @Override
      public Adapter caseGuard(Guard object)
      {
        return createGuardAdapter();
      }
      @Override
      public Adapter caseAtom(Atom object)
      {
        return createAtomAdapter();
      }
      @Override
      public Adapter casePlaysQuery(PlaysQuery object)
      {
        return createPlaysQueryAdapter();
      }
      @Override
      public Adapter caseRelation(Relation object)
      {
        return createRelationAdapter();
      }
      @Override
      public Adapter caseGuardInParentheses(GuardInParentheses object)
      {
        return createGuardInParenthesesAdapter();
      }
      @Override
      public Adapter caseAbstractDataValue(AbstractDataValue object)
      {
        return createAbstractDataValueAdapter();
      }
      @Override
      public Adapter caseBooleanValue(BooleanValue object)
      {
        return createBooleanValueAdapter();
      }
      @Override
      public Adapter caseNumberValue(NumberValue object)
      {
        return createNumberValueAdapter();
      }
      @Override
      public Adapter caseStringValue(StringValue object)
      {
        return createStringValueAdapter();
      }
      @Override
      public Adapter caseComponentInstance(ComponentInstance object)
      {
        return createComponentInstanceAdapter();
      }
      @Override
      public Adapter caseComponentAssociationTypeReference(ComponentAssociationTypeReference object)
      {
        return createComponentAssociationTypeReferenceAdapter();
      }
      @Override
      public Adapter caseOwnerReference(OwnerReference object)
      {
        return createOwnerReferenceAdapter();
      }
      @Override
      public Adapter caseAbstractRoleInstance(AbstractRoleInstance object)
      {
        return createAbstractRoleInstanceAdapter();
      }
      @Override
      public Adapter caseRoleInstanceVariable(RoleInstanceVariable object)
      {
        return createRoleInstanceVariableAdapter();
      }
      @Override
      public Adapter caseFormalRoleParam(FormalRoleParam object)
      {
        return createFormalRoleParamAdapter();
      }
      @Override
      public Adapter caseFormalRoleParamsBlock(FormalRoleParamsBlock object)
      {
        return createFormalRoleParamsBlockAdapter();
      }
      @Override
      public Adapter caseRoleInstanceReference(RoleInstanceReference object)
      {
        return createRoleInstanceReferenceAdapter();
      }
      @Override
      public Adapter caseAbstractRoleInstanceReference(AbstractRoleInstanceReference object)
      {
        return createAbstractRoleInstanceReferenceAdapter();
      }
      @Override
      public Adapter caseActualRoleParamsBlock(ActualRoleParamsBlock object)
      {
        return createActualRoleParamsBlockAdapter();
      }
      @Override
      public Adapter caseAbstractDataVariable(AbstractDataVariable object)
      {
        return createAbstractDataVariableAdapter();
      }
      @Override
      public Adapter caseDataVariable(DataVariable object)
      {
        return createDataVariableAdapter();
      }
      @Override
      public Adapter caseFormalDataParam(FormalDataParam object)
      {
        return createFormalDataParamAdapter();
      }
      @Override
      public Adapter caseFormalDataParamsBlock(FormalDataParamsBlock object)
      {
        return createFormalDataParamsBlockAdapter();
      }
      @Override
      public Adapter caseDataExpression(DataExpression object)
      {
        return createDataExpressionAdapter();
      }
      @Override
      public Adapter caseAbstractDataReference(AbstractDataReference object)
      {
        return createAbstractDataReferenceAdapter();
      }
      @Override
      public Adapter caseAbstractDataVariableReference(AbstractDataVariableReference object)
      {
        return createAbstractDataVariableReferenceAdapter();
      }
      @Override
      public Adapter caseRoleAttributeTypeReference(RoleAttributeTypeReference object)
      {
        return createRoleAttributeTypeReferenceAdapter();
      }
      @Override
      public Adapter caseComponentAttributeTypeReference(ComponentAttributeTypeReference object)
      {
        return createComponentAttributeTypeReferenceAdapter();
      }
      @Override
      public Adapter caseActualDataParamsBlock(ActualDataParamsBlock object)
      {
        return createActualDataParamsBlockAdapter();
      }
      @Override
      public Adapter caseAbstractDuplicateFreeObject(AbstractDuplicateFreeObject object)
      {
        return createAbstractDuplicateFreeObjectAdapter();
      }
      @Override
      public Adapter caseAbstractHelenaEntity(AbstractHelenaEntity object)
      {
        return createAbstractHelenaEntityAdapter();
      }
      @Override
      public Adapter caseAbstractFieldType(AbstractFieldType object)
      {
        return createAbstractFieldTypeAdapter();
      }
      @Override
      public Adapter caseAbstractRoleBehaviorEntity(AbstractRoleBehaviorEntity object)
      {
        return createAbstractRoleBehaviorEntityAdapter();
      }
      @Override
      public Adapter caseAbstractInstance(AbstractInstance object)
      {
        return createAbstractInstanceAdapter();
      }
      @Override
      public Adapter caseDeclaringRoleBehavior(DeclaringRoleBehavior object)
      {
        return createDeclaringRoleBehaviorAdapter();
      }
      @Override
      public Adapter caseInvokingRoleBehavior(InvokingRoleBehavior object)
      {
        return createInvokingRoleBehaviorAdapter();
      }
      @Override
      public Adapter caseQuitTerm(QuitTerm object)
      {
        return createQuitTermAdapter();
      }
      @Override
      public Adapter caseGetAssignment(GetAssignment object)
      {
        return createGetAssignmentAdapter();
      }
      @Override
      public Adapter caseCreateAssignment(CreateAssignment object)
      {
        return createCreateAssignmentAdapter();
      }
      @Override
      public Adapter caseOrTerm(OrTerm object)
      {
        return createOrTermAdapter();
      }
      @Override
      public Adapter caseAndTerm(AndTerm object)
      {
        return createAndTermAdapter();
      }
      @Override
      public Adapter caseEqualityTerm(EqualityTerm object)
      {
        return createEqualityTermAdapter();
      }
      @Override
      public Adapter caseNotTerm(NotTerm object)
      {
        return createNotTermAdapter();
      }
      @Override
      public Adapter caseSelfReference(SelfReference object)
      {
        return createSelfReferenceAdapter();
      }
      @Override
      public Adapter caseAddition(Addition object)
      {
        return createAdditionAdapter();
      }
      @Override
      public Adapter caseSubtraction(Subtraction object)
      {
        return createSubtractionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.PackageDeclaration
   * @generated
   */
  public Adapter createPackageDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ComponentType <em>Component Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ComponentType
   * @generated
   */
  public Adapter createComponentTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractComponentFieldType <em>Abstract Component Field Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractComponentFieldType
   * @generated
   */
  public Adapter createAbstractComponentFieldTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ComponentAttributeType <em>Component Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ComponentAttributeType
   * @generated
   */
  public Adapter createComponentAttributeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ComponentAssociationType <em>Component Association Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ComponentAssociationType
   * @generated
   */
  public Adapter createComponentAssociationTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.OperationType <em>Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.OperationType
   * @generated
   */
  public Adapter createOperationTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleType <em>Role Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleType
   * @generated
   */
  public Adapter createRoleTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleAttributeType <em>Role Attribute Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleAttributeType
   * @generated
   */
  public Adapter createRoleAttributeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.MessageType <em>Message Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.MessageType
   * @generated
   */
  public Adapter createMessageTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.EnsembleStructure <em>Ensemble Structure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.EnsembleStructure
   * @generated
   */
  public Adapter createEnsembleStructureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity <em>Role Type With Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleTypeWithMultiplicity
   * @generated
   */
  public Adapter createRoleTypeWithMultiplicityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleBehavior <em>Role Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleBehavior
   * @generated
   */
  public Adapter createRoleBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Process <em>Process</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Process
   * @generated
   */
  public Adapter createProcessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ProcessExpression <em>Process Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ProcessExpression
   * @generated
   */
  public Adapter createProcessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ActionPrefix <em>Action Prefix</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ActionPrefix
   * @generated
   */
  public Adapter createActionPrefixAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.NondeterministicChoice <em>Nondeterministic Choice</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.NondeterministicChoice
   * @generated
   */
  public Adapter createNondeterministicChoiceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.IfThenElse <em>If Then Else</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.IfThenElse
   * @generated
   */
  public Adapter createIfThenElseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ProcessInvocation <em>Process Invocation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ProcessInvocation
   * @generated
   */
  public Adapter createProcessInvocationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractAssignment <em>Abstract Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractAssignment
   * @generated
   */
  public Adapter createAbstractAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractMessageCall <em>Abstract Message Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractMessageCall
   * @generated
   */
  public Adapter createAbstractMessageCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.OutgoingMessageCall <em>Outgoing Message Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.OutgoingMessageCall
   * @generated
   */
  public Adapter createOutgoingMessageCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.IncomingMessageCall <em>Incoming Message Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.IncomingMessageCall
   * @generated
   */
  public Adapter createIncomingMessageCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.OperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.OperationCall
   * @generated
   */
  public Adapter createOperationCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ComponentAttributeSetter <em>Component Attribute Setter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ComponentAttributeSetter
   * @generated
   */
  public Adapter createComponentAttributeSetterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleAttributeSetter <em>Role Attribute Setter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleAttributeSetter
   * @generated
   */
  public Adapter createRoleAttributeSetterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Label
   * @generated
   */
  public Adapter createLabelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Guard
   * @generated
   */
  public Adapter createGuardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Atom
   * @generated
   */
  public Adapter createAtomAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.PlaysQuery <em>Plays Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.PlaysQuery
   * @generated
   */
  public Adapter createPlaysQueryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Relation <em>Relation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Relation
   * @generated
   */
  public Adapter createRelationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.GuardInParentheses <em>Guard In Parentheses</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.GuardInParentheses
   * @generated
   */
  public Adapter createGuardInParenthesesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractDataValue <em>Abstract Data Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractDataValue
   * @generated
   */
  public Adapter createAbstractDataValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.BooleanValue <em>Boolean Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.BooleanValue
   * @generated
   */
  public Adapter createBooleanValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.NumberValue <em>Number Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.NumberValue
   * @generated
   */
  public Adapter createNumberValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.StringValue
   * @generated
   */
  public Adapter createStringValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ComponentInstance <em>Component Instance</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ComponentInstance
   * @generated
   */
  public Adapter createComponentInstanceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ComponentAssociationTypeReference <em>Component Association Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ComponentAssociationTypeReference
   * @generated
   */
  public Adapter createComponentAssociationTypeReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.OwnerReference <em>Owner Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.OwnerReference
   * @generated
   */
  public Adapter createOwnerReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractRoleInstance <em>Abstract Role Instance</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractRoleInstance
   * @generated
   */
  public Adapter createAbstractRoleInstanceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleInstanceVariable <em>Role Instance Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleInstanceVariable
   * @generated
   */
  public Adapter createRoleInstanceVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.FormalRoleParam <em>Formal Role Param</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.FormalRoleParam
   * @generated
   */
  public Adapter createFormalRoleParamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.FormalRoleParamsBlock <em>Formal Role Params Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.FormalRoleParamsBlock
   * @generated
   */
  public Adapter createFormalRoleParamsBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleInstanceReference <em>Role Instance Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleInstanceReference
   * @generated
   */
  public Adapter createRoleInstanceReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractRoleInstanceReference <em>Abstract Role Instance Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractRoleInstanceReference
   * @generated
   */
  public Adapter createAbstractRoleInstanceReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ActualRoleParamsBlock <em>Actual Role Params Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ActualRoleParamsBlock
   * @generated
   */
  public Adapter createActualRoleParamsBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractDataVariable <em>Abstract Data Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractDataVariable
   * @generated
   */
  public Adapter createAbstractDataVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.DataVariable <em>Data Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.DataVariable
   * @generated
   */
  public Adapter createDataVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.FormalDataParam <em>Formal Data Param</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.FormalDataParam
   * @generated
   */
  public Adapter createFormalDataParamAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.FormalDataParamsBlock <em>Formal Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.FormalDataParamsBlock
   * @generated
   */
  public Adapter createFormalDataParamsBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.DataExpression <em>Data Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.DataExpression
   * @generated
   */
  public Adapter createDataExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractDataReference <em>Abstract Data Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractDataReference
   * @generated
   */
  public Adapter createAbstractDataReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractDataVariableReference <em>Abstract Data Variable Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractDataVariableReference
   * @generated
   */
  public Adapter createAbstractDataVariableReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.RoleAttributeTypeReference <em>Role Attribute Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.RoleAttributeTypeReference
   * @generated
   */
  public Adapter createRoleAttributeTypeReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ComponentAttributeTypeReference <em>Component Attribute Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ComponentAttributeTypeReference
   * @generated
   */
  public Adapter createComponentAttributeTypeReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.ActualDataParamsBlock <em>Actual Data Params Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.ActualDataParamsBlock
   * @generated
   */
  public Adapter createActualDataParamsBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractDuplicateFreeObject <em>Abstract Duplicate Free Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractDuplicateFreeObject
   * @generated
   */
  public Adapter createAbstractDuplicateFreeObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractHelenaEntity <em>Abstract Helena Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractHelenaEntity
   * @generated
   */
  public Adapter createAbstractHelenaEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractFieldType <em>Abstract Field Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractFieldType
   * @generated
   */
  public Adapter createAbstractFieldTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractRoleBehaviorEntity <em>Abstract Role Behavior Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractRoleBehaviorEntity
   * @generated
   */
  public Adapter createAbstractRoleBehaviorEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AbstractInstance <em>Abstract Instance</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AbstractInstance
   * @generated
   */
  public Adapter createAbstractInstanceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.DeclaringRoleBehavior <em>Declaring Role Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.DeclaringRoleBehavior
   * @generated
   */
  public Adapter createDeclaringRoleBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.InvokingRoleBehavior <em>Invoking Role Behavior</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.InvokingRoleBehavior
   * @generated
   */
  public Adapter createInvokingRoleBehaviorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.QuitTerm <em>Quit Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.QuitTerm
   * @generated
   */
  public Adapter createQuitTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.GetAssignment <em>Get Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.GetAssignment
   * @generated
   */
  public Adapter createGetAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.CreateAssignment <em>Create Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.CreateAssignment
   * @generated
   */
  public Adapter createCreateAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.OrTerm <em>Or Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.OrTerm
   * @generated
   */
  public Adapter createOrTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.AndTerm <em>And Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.AndTerm
   * @generated
   */
  public Adapter createAndTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.EqualityTerm <em>Equality Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.EqualityTerm
   * @generated
   */
  public Adapter createEqualityTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.NotTerm <em>Not Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.NotTerm
   * @generated
   */
  public Adapter createNotTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.SelfReference <em>Self Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.SelfReference
   * @generated
   */
  public Adapter createSelfReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Addition <em>Addition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Addition
   * @generated
   */
  public Adapter createAdditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.ascens.helenaText.Subtraction <em>Subtraction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.ascens.helenaText.Subtraction
   * @generated
   */
  public Adapter createSubtractionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //HelenaTextAdapterFactory
