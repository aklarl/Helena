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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HelenaTextPackageImpl extends EPackageImpl implements HelenaTextPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractComponentFieldTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentAttributeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentAssociationTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleAttributeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass messageTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ensembleStructureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleTypeWithMultiplicityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass processEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass processExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionPrefixEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nondeterministicChoiceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifThenElseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass processInvocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractMessageCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outgoingMessageCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass incomingMessageCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentAttributeSetterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleAttributeSetterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass labelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass playsQueryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guardInParenthesesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDataValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numberValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentInstanceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentAssociationTypeReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ownerReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractRoleInstanceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleInstanceVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalRoleParamEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalRoleParamsBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleInstanceReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractRoleInstanceReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actualRoleParamsBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDataVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalDataParamEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalDataParamsBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDataReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDataVariableReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roleAttributeTypeReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentAttributeTypeReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actualDataParamsBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractDuplicateFreeObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractHelenaEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractFieldTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractRoleBehaviorEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractInstanceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declaringRoleBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invokingRoleBehaviorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass quitTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass getAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass createAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass notTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selfReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass additionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subtractionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum msgDirectionEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see eu.ascens.helenaText.HelenaTextPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private HelenaTextPackageImpl()
  {
    super(eNS_URI, HelenaTextFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link HelenaTextPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static HelenaTextPackage init()
  {
    if (isInited) return (HelenaTextPackage)EPackage.Registry.INSTANCE.getEPackage(HelenaTextPackage.eNS_URI);

    // Obtain or create and register package
    HelenaTextPackageImpl theHelenaTextPackage = (HelenaTextPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HelenaTextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HelenaTextPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XbasePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theHelenaTextPackage.createPackageContents();

    // Initialize created meta-data
    theHelenaTextPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theHelenaTextPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(HelenaTextPackage.eNS_URI, theHelenaTextPackage);
    return theHelenaTextPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_HeadPkg()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDeclaration()
  {
    return packageDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPackageDeclaration_Name()
  {
    return (EAttribute)packageDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_CompTypes()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_RoleTypes()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_EnsStructs()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_RoleBehaviors()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentType()
  {
    return componentTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentType_Attrs()
  {
    return (EReference)componentTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentType_Assocs()
  {
    return (EReference)componentTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentType_Ops()
  {
    return (EReference)componentTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractComponentFieldType()
  {
    return abstractComponentFieldTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentAttributeType()
  {
    return componentAttributeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentAttributeType_Type()
  {
    return (EReference)componentAttributeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentAssociationType()
  {
    return componentAssociationTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentAssociationType_Type()
  {
    return (EReference)componentAssociationTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationType()
  {
    return operationTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationType_ReturnType()
  {
    return (EReference)operationTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationType_Name()
  {
    return (EAttribute)operationTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationType_FormalDataParamsBlock()
  {
    return (EReference)operationTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleType()
  {
    return roleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleType_CompTypes()
  {
    return (EReference)roleTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleType_Roleattrs()
  {
    return (EReference)roleTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleType_Rolemsgs()
  {
    return (EReference)roleTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleAttributeType()
  {
    return roleAttributeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleAttributeType_Type()
  {
    return (EReference)roleAttributeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMessageType()
  {
    return messageTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessageType_Direction()
  {
    return (EAttribute)messageTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMessageType_Name()
  {
    return (EAttribute)messageTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageType_FormalRoleParamsBlock()
  {
    return (EReference)messageTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMessageType_FormalDataParamsBlock()
  {
    return (EReference)messageTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnsembleStructure()
  {
    return ensembleStructureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnsembleStructure_RtWithMult()
  {
    return (EReference)ensembleStructureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleTypeWithMultiplicity()
  {
    return roleTypeWithMultiplicityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleTypeWithMultiplicity_RoleType()
  {
    return (EReference)roleTypeWithMultiplicityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoleTypeWithMultiplicity_Min()
  {
    return (EAttribute)roleTypeWithMultiplicityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoleTypeWithMultiplicity_Max()
  {
    return (EAttribute)roleTypeWithMultiplicityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoleTypeWithMultiplicity_Capacity()
  {
    return (EAttribute)roleTypeWithMultiplicityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleBehavior()
  {
    return roleBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleBehavior_RoleTypeRef()
  {
    return (EReference)roleBehaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcess()
  {
    return processEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProcess_Name()
  {
    return (EAttribute)processEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcess_ProcessExpr()
  {
    return (EReference)processEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcessExpression()
  {
    return processExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActionPrefix()
  {
    return actionPrefixEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActionPrefix_Action()
  {
    return (EReference)actionPrefixEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActionPrefix_ProcessExpr()
  {
    return (EReference)actionPrefixEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNondeterministicChoice()
  {
    return nondeterministicChoiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNondeterministicChoice_First()
  {
    return (EReference)nondeterministicChoiceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNondeterministicChoice_Second()
  {
    return (EReference)nondeterministicChoiceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfThenElse()
  {
    return ifThenElseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElse_Guard()
  {
    return (EReference)ifThenElseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElse_IfProcessExpr()
  {
    return (EReference)ifThenElseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElse_ElseProcessExpr()
  {
    return (EReference)ifThenElseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcessInvocation()
  {
    return processInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProcessInvocation_Process()
  {
    return (EReference)processInvocationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAction()
  {
    return actionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractAssignment()
  {
    return abstractAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractAssignment_RoleInst()
  {
    return (EReference)abstractAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractAssignment_RoleTypeRef()
  {
    return (EReference)abstractAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractAssignment_CompInstance()
  {
    return (EReference)abstractAssignmentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractMessageCall()
  {
    return abstractMessageCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractMessageCall_MsgName()
  {
    return (EAttribute)abstractMessageCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutgoingMessageCall()
  {
    return outgoingMessageCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingMessageCall_Receiver()
  {
    return (EReference)outgoingMessageCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingMessageCall_ActualRoleParamsBlock()
  {
    return (EReference)outgoingMessageCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutgoingMessageCall_ActualDataParamsBlock()
  {
    return (EReference)outgoingMessageCallEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncomingMessageCall()
  {
    return incomingMessageCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIncomingMessageCall_FormalRoleParamsBlock()
  {
    return (EReference)incomingMessageCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIncomingMessageCall_FormalDataParamsBlock()
  {
    return (EReference)incomingMessageCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationCall()
  {
    return operationCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationCall_Variable()
  {
    return (EReference)operationCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationCall_OpName()
  {
    return (EAttribute)operationCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationCall_ActualDataParamsBlock()
  {
    return (EReference)operationCallEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentAttributeSetter()
  {
    return componentAttributeSetterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentAttributeSetter_Attr()
  {
    return (EReference)componentAttributeSetterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentAttributeSetter_Value()
  {
    return (EReference)componentAttributeSetterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleAttributeSetter()
  {
    return roleAttributeSetterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleAttributeSetter_Attr()
  {
    return (EReference)roleAttributeSetterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleAttributeSetter_Value()
  {
    return (EReference)roleAttributeSetterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLabel()
  {
    return labelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabel_Name()
  {
    return (EAttribute)labelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuard()
  {
    return guardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtom()
  {
    return atomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPlaysQuery()
  {
    return playsQueryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPlaysQuery_RoleTypeRef()
  {
    return (EReference)playsQueryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPlaysQuery_CompInstance()
  {
    return (EReference)playsQueryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelation()
  {
    return relationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelation_Left()
  {
    return (EReference)relationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelation_Operator()
  {
    return (EAttribute)relationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelation_Right()
  {
    return (EReference)relationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuardInParentheses()
  {
    return guardInParenthesesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuardInParentheses_Guard()
  {
    return (EReference)guardInParenthesesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDataValue()
  {
    return abstractDataValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDataValue_Value()
  {
    return (EReference)abstractDataValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanValue()
  {
    return booleanValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumberValue()
  {
    return numberValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringValue()
  {
    return stringValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentInstance()
  {
    return componentInstanceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentAssociationTypeReference()
  {
    return componentAssociationTypeReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentAssociationTypeReference_Ref()
  {
    return (EReference)componentAssociationTypeReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOwnerReference()
  {
    return ownerReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractRoleInstance()
  {
    return abstractRoleInstanceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractRoleInstance_Name()
  {
    return (EAttribute)abstractRoleInstanceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleInstanceVariable()
  {
    return roleInstanceVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalRoleParam()
  {
    return formalRoleParamEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalRoleParam_Type()
  {
    return (EReference)formalRoleParamEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalRoleParamsBlock()
  {
    return formalRoleParamsBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalRoleParamsBlock_Params()
  {
    return (EReference)formalRoleParamsBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleInstanceReference()
  {
    return roleInstanceReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractRoleInstanceReference()
  {
    return abstractRoleInstanceReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractRoleInstanceReference_Ref()
  {
    return (EReference)abstractRoleInstanceReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActualRoleParamsBlock()
  {
    return actualRoleParamsBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActualRoleParamsBlock_Params()
  {
    return (EReference)actualRoleParamsBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDataVariable()
  {
    return abstractDataVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractDataVariable_Name()
  {
    return (EAttribute)abstractDataVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataVariable()
  {
    return dataVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalDataParam()
  {
    return formalDataParamEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalDataParam_Type()
  {
    return (EReference)formalDataParamEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalDataParamsBlock()
  {
    return formalDataParamsBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalDataParamsBlock_Params()
  {
    return (EReference)formalDataParamsBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataExpression()
  {
    return dataExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDataReference()
  {
    return abstractDataReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDataVariableReference()
  {
    return abstractDataVariableReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractDataVariableReference_Ref()
  {
    return (EReference)abstractDataVariableReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoleAttributeTypeReference()
  {
    return roleAttributeTypeReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoleAttributeTypeReference_Ref()
  {
    return (EReference)roleAttributeTypeReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentAttributeTypeReference()
  {
    return componentAttributeTypeReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentAttributeTypeReference_Ref()
  {
    return (EReference)componentAttributeTypeReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActualDataParamsBlock()
  {
    return actualDataParamsBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActualDataParamsBlock_Params()
  {
    return (EReference)actualDataParamsBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractDuplicateFreeObject()
  {
    return abstractDuplicateFreeObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractHelenaEntity()
  {
    return abstractHelenaEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractHelenaEntity_Name()
  {
    return (EAttribute)abstractHelenaEntityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractFieldType()
  {
    return abstractFieldTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractFieldType_Name()
  {
    return (EAttribute)abstractFieldTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractRoleBehaviorEntity()
  {
    return abstractRoleBehaviorEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractInstance()
  {
    return abstractInstanceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclaringRoleBehavior()
  {
    return declaringRoleBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeclaringRoleBehavior_ProcessExpr()
  {
    return (EReference)declaringRoleBehaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvokingRoleBehavior()
  {
    return invokingRoleBehaviorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvokingRoleBehavior_ProcessInvocation()
  {
    return (EReference)invokingRoleBehaviorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvokingRoleBehavior_Processes()
  {
    return (EReference)invokingRoleBehaviorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQuitTerm()
  {
    return quitTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGetAssignment()
  {
    return getAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCreateAssignment()
  {
    return createAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrTerm()
  {
    return orTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrTerm_Left()
  {
    return (EReference)orTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrTerm_Right()
  {
    return (EReference)orTermEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndTerm()
  {
    return andTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndTerm_Left()
  {
    return (EReference)andTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndTerm_Right()
  {
    return (EReference)andTermEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityTerm()
  {
    return equalityTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityTerm_Left()
  {
    return (EReference)equalityTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityTerm_Operator()
  {
    return (EAttribute)equalityTermEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityTerm_Right()
  {
    return (EReference)equalityTermEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNotTerm()
  {
    return notTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNotTerm_Not()
  {
    return (EAttribute)notTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNotTerm_Atom()
  {
    return (EReference)notTermEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelfReference()
  {
    return selfReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddition()
  {
    return additionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddition_Left()
  {
    return (EReference)additionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAddition_Operator()
  {
    return (EAttribute)additionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddition_Right()
  {
    return (EReference)additionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubtraction()
  {
    return subtractionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtraction_Left()
  {
    return (EReference)subtractionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSubtraction_Operator()
  {
    return (EAttribute)subtractionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSubtraction_Right()
  {
    return (EReference)subtractionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMsgDirection()
  {
    return msgDirectionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HelenaTextFactory getHelenaTextFactory()
  {
    return (HelenaTextFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__HEAD_PKG);

    packageDeclarationEClass = createEClass(PACKAGE_DECLARATION);
    createEAttribute(packageDeclarationEClass, PACKAGE_DECLARATION__NAME);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__COMP_TYPES);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__ROLE_TYPES);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__ENS_STRUCTS);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__ROLE_BEHAVIORS);

    componentTypeEClass = createEClass(COMPONENT_TYPE);
    createEReference(componentTypeEClass, COMPONENT_TYPE__ATTRS);
    createEReference(componentTypeEClass, COMPONENT_TYPE__ASSOCS);
    createEReference(componentTypeEClass, COMPONENT_TYPE__OPS);

    abstractComponentFieldTypeEClass = createEClass(ABSTRACT_COMPONENT_FIELD_TYPE);

    componentAttributeTypeEClass = createEClass(COMPONENT_ATTRIBUTE_TYPE);
    createEReference(componentAttributeTypeEClass, COMPONENT_ATTRIBUTE_TYPE__TYPE);

    componentAssociationTypeEClass = createEClass(COMPONENT_ASSOCIATION_TYPE);
    createEReference(componentAssociationTypeEClass, COMPONENT_ASSOCIATION_TYPE__TYPE);

    operationTypeEClass = createEClass(OPERATION_TYPE);
    createEReference(operationTypeEClass, OPERATION_TYPE__RETURN_TYPE);
    createEAttribute(operationTypeEClass, OPERATION_TYPE__NAME);
    createEReference(operationTypeEClass, OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK);

    roleTypeEClass = createEClass(ROLE_TYPE);
    createEReference(roleTypeEClass, ROLE_TYPE__COMP_TYPES);
    createEReference(roleTypeEClass, ROLE_TYPE__ROLEATTRS);
    createEReference(roleTypeEClass, ROLE_TYPE__ROLEMSGS);

    roleAttributeTypeEClass = createEClass(ROLE_ATTRIBUTE_TYPE);
    createEReference(roleAttributeTypeEClass, ROLE_ATTRIBUTE_TYPE__TYPE);

    messageTypeEClass = createEClass(MESSAGE_TYPE);
    createEAttribute(messageTypeEClass, MESSAGE_TYPE__DIRECTION);
    createEAttribute(messageTypeEClass, MESSAGE_TYPE__NAME);
    createEReference(messageTypeEClass, MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK);
    createEReference(messageTypeEClass, MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK);

    ensembleStructureEClass = createEClass(ENSEMBLE_STRUCTURE);
    createEReference(ensembleStructureEClass, ENSEMBLE_STRUCTURE__RT_WITH_MULT);

    roleTypeWithMultiplicityEClass = createEClass(ROLE_TYPE_WITH_MULTIPLICITY);
    createEReference(roleTypeWithMultiplicityEClass, ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE);
    createEAttribute(roleTypeWithMultiplicityEClass, ROLE_TYPE_WITH_MULTIPLICITY__MIN);
    createEAttribute(roleTypeWithMultiplicityEClass, ROLE_TYPE_WITH_MULTIPLICITY__MAX);
    createEAttribute(roleTypeWithMultiplicityEClass, ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY);

    roleBehaviorEClass = createEClass(ROLE_BEHAVIOR);
    createEReference(roleBehaviorEClass, ROLE_BEHAVIOR__ROLE_TYPE_REF);

    processEClass = createEClass(PROCESS);
    createEAttribute(processEClass, PROCESS__NAME);
    createEReference(processEClass, PROCESS__PROCESS_EXPR);

    processExpressionEClass = createEClass(PROCESS_EXPRESSION);

    actionPrefixEClass = createEClass(ACTION_PREFIX);
    createEReference(actionPrefixEClass, ACTION_PREFIX__ACTION);
    createEReference(actionPrefixEClass, ACTION_PREFIX__PROCESS_EXPR);

    nondeterministicChoiceEClass = createEClass(NONDETERMINISTIC_CHOICE);
    createEReference(nondeterministicChoiceEClass, NONDETERMINISTIC_CHOICE__FIRST);
    createEReference(nondeterministicChoiceEClass, NONDETERMINISTIC_CHOICE__SECOND);

    ifThenElseEClass = createEClass(IF_THEN_ELSE);
    createEReference(ifThenElseEClass, IF_THEN_ELSE__GUARD);
    createEReference(ifThenElseEClass, IF_THEN_ELSE__IF_PROCESS_EXPR);
    createEReference(ifThenElseEClass, IF_THEN_ELSE__ELSE_PROCESS_EXPR);

    processInvocationEClass = createEClass(PROCESS_INVOCATION);
    createEReference(processInvocationEClass, PROCESS_INVOCATION__PROCESS);

    actionEClass = createEClass(ACTION);

    abstractAssignmentEClass = createEClass(ABSTRACT_ASSIGNMENT);
    createEReference(abstractAssignmentEClass, ABSTRACT_ASSIGNMENT__ROLE_INST);
    createEReference(abstractAssignmentEClass, ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF);
    createEReference(abstractAssignmentEClass, ABSTRACT_ASSIGNMENT__COMP_INSTANCE);

    abstractMessageCallEClass = createEClass(ABSTRACT_MESSAGE_CALL);
    createEAttribute(abstractMessageCallEClass, ABSTRACT_MESSAGE_CALL__MSG_NAME);

    outgoingMessageCallEClass = createEClass(OUTGOING_MESSAGE_CALL);
    createEReference(outgoingMessageCallEClass, OUTGOING_MESSAGE_CALL__RECEIVER);
    createEReference(outgoingMessageCallEClass, OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK);
    createEReference(outgoingMessageCallEClass, OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK);

    incomingMessageCallEClass = createEClass(INCOMING_MESSAGE_CALL);
    createEReference(incomingMessageCallEClass, INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK);
    createEReference(incomingMessageCallEClass, INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK);

    operationCallEClass = createEClass(OPERATION_CALL);
    createEReference(operationCallEClass, OPERATION_CALL__VARIABLE);
    createEAttribute(operationCallEClass, OPERATION_CALL__OP_NAME);
    createEReference(operationCallEClass, OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK);

    componentAttributeSetterEClass = createEClass(COMPONENT_ATTRIBUTE_SETTER);
    createEReference(componentAttributeSetterEClass, COMPONENT_ATTRIBUTE_SETTER__ATTR);
    createEReference(componentAttributeSetterEClass, COMPONENT_ATTRIBUTE_SETTER__VALUE);

    roleAttributeSetterEClass = createEClass(ROLE_ATTRIBUTE_SETTER);
    createEReference(roleAttributeSetterEClass, ROLE_ATTRIBUTE_SETTER__ATTR);
    createEReference(roleAttributeSetterEClass, ROLE_ATTRIBUTE_SETTER__VALUE);

    labelEClass = createEClass(LABEL);
    createEAttribute(labelEClass, LABEL__NAME);

    guardEClass = createEClass(GUARD);

    atomEClass = createEClass(ATOM);

    playsQueryEClass = createEClass(PLAYS_QUERY);
    createEReference(playsQueryEClass, PLAYS_QUERY__ROLE_TYPE_REF);
    createEReference(playsQueryEClass, PLAYS_QUERY__COMP_INSTANCE);

    relationEClass = createEClass(RELATION);
    createEReference(relationEClass, RELATION__LEFT);
    createEAttribute(relationEClass, RELATION__OPERATOR);
    createEReference(relationEClass, RELATION__RIGHT);

    guardInParenthesesEClass = createEClass(GUARD_IN_PARENTHESES);
    createEReference(guardInParenthesesEClass, GUARD_IN_PARENTHESES__GUARD);

    abstractDataValueEClass = createEClass(ABSTRACT_DATA_VALUE);
    createEReference(abstractDataValueEClass, ABSTRACT_DATA_VALUE__VALUE);

    booleanValueEClass = createEClass(BOOLEAN_VALUE);

    numberValueEClass = createEClass(NUMBER_VALUE);

    stringValueEClass = createEClass(STRING_VALUE);

    componentInstanceEClass = createEClass(COMPONENT_INSTANCE);

    componentAssociationTypeReferenceEClass = createEClass(COMPONENT_ASSOCIATION_TYPE_REFERENCE);
    createEReference(componentAssociationTypeReferenceEClass, COMPONENT_ASSOCIATION_TYPE_REFERENCE__REF);

    ownerReferenceEClass = createEClass(OWNER_REFERENCE);

    abstractRoleInstanceEClass = createEClass(ABSTRACT_ROLE_INSTANCE);
    createEAttribute(abstractRoleInstanceEClass, ABSTRACT_ROLE_INSTANCE__NAME);

    roleInstanceVariableEClass = createEClass(ROLE_INSTANCE_VARIABLE);

    formalRoleParamEClass = createEClass(FORMAL_ROLE_PARAM);
    createEReference(formalRoleParamEClass, FORMAL_ROLE_PARAM__TYPE);

    formalRoleParamsBlockEClass = createEClass(FORMAL_ROLE_PARAMS_BLOCK);
    createEReference(formalRoleParamsBlockEClass, FORMAL_ROLE_PARAMS_BLOCK__PARAMS);

    roleInstanceReferenceEClass = createEClass(ROLE_INSTANCE_REFERENCE);

    abstractRoleInstanceReferenceEClass = createEClass(ABSTRACT_ROLE_INSTANCE_REFERENCE);
    createEReference(abstractRoleInstanceReferenceEClass, ABSTRACT_ROLE_INSTANCE_REFERENCE__REF);

    actualRoleParamsBlockEClass = createEClass(ACTUAL_ROLE_PARAMS_BLOCK);
    createEReference(actualRoleParamsBlockEClass, ACTUAL_ROLE_PARAMS_BLOCK__PARAMS);

    abstractDataVariableEClass = createEClass(ABSTRACT_DATA_VARIABLE);
    createEAttribute(abstractDataVariableEClass, ABSTRACT_DATA_VARIABLE__NAME);

    dataVariableEClass = createEClass(DATA_VARIABLE);

    formalDataParamEClass = createEClass(FORMAL_DATA_PARAM);
    createEReference(formalDataParamEClass, FORMAL_DATA_PARAM__TYPE);

    formalDataParamsBlockEClass = createEClass(FORMAL_DATA_PARAMS_BLOCK);
    createEReference(formalDataParamsBlockEClass, FORMAL_DATA_PARAMS_BLOCK__PARAMS);

    dataExpressionEClass = createEClass(DATA_EXPRESSION);

    abstractDataReferenceEClass = createEClass(ABSTRACT_DATA_REFERENCE);

    abstractDataVariableReferenceEClass = createEClass(ABSTRACT_DATA_VARIABLE_REFERENCE);
    createEReference(abstractDataVariableReferenceEClass, ABSTRACT_DATA_VARIABLE_REFERENCE__REF);

    roleAttributeTypeReferenceEClass = createEClass(ROLE_ATTRIBUTE_TYPE_REFERENCE);
    createEReference(roleAttributeTypeReferenceEClass, ROLE_ATTRIBUTE_TYPE_REFERENCE__REF);

    componentAttributeTypeReferenceEClass = createEClass(COMPONENT_ATTRIBUTE_TYPE_REFERENCE);
    createEReference(componentAttributeTypeReferenceEClass, COMPONENT_ATTRIBUTE_TYPE_REFERENCE__REF);

    actualDataParamsBlockEClass = createEClass(ACTUAL_DATA_PARAMS_BLOCK);
    createEReference(actualDataParamsBlockEClass, ACTUAL_DATA_PARAMS_BLOCK__PARAMS);

    abstractDuplicateFreeObjectEClass = createEClass(ABSTRACT_DUPLICATE_FREE_OBJECT);

    abstractHelenaEntityEClass = createEClass(ABSTRACT_HELENA_ENTITY);
    createEAttribute(abstractHelenaEntityEClass, ABSTRACT_HELENA_ENTITY__NAME);

    abstractFieldTypeEClass = createEClass(ABSTRACT_FIELD_TYPE);
    createEAttribute(abstractFieldTypeEClass, ABSTRACT_FIELD_TYPE__NAME);

    abstractRoleBehaviorEntityEClass = createEClass(ABSTRACT_ROLE_BEHAVIOR_ENTITY);

    abstractInstanceEClass = createEClass(ABSTRACT_INSTANCE);

    declaringRoleBehaviorEClass = createEClass(DECLARING_ROLE_BEHAVIOR);
    createEReference(declaringRoleBehaviorEClass, DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR);

    invokingRoleBehaviorEClass = createEClass(INVOKING_ROLE_BEHAVIOR);
    createEReference(invokingRoleBehaviorEClass, INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION);
    createEReference(invokingRoleBehaviorEClass, INVOKING_ROLE_BEHAVIOR__PROCESSES);

    quitTermEClass = createEClass(QUIT_TERM);

    getAssignmentEClass = createEClass(GET_ASSIGNMENT);

    createAssignmentEClass = createEClass(CREATE_ASSIGNMENT);

    orTermEClass = createEClass(OR_TERM);
    createEReference(orTermEClass, OR_TERM__LEFT);
    createEReference(orTermEClass, OR_TERM__RIGHT);

    andTermEClass = createEClass(AND_TERM);
    createEReference(andTermEClass, AND_TERM__LEFT);
    createEReference(andTermEClass, AND_TERM__RIGHT);

    equalityTermEClass = createEClass(EQUALITY_TERM);
    createEReference(equalityTermEClass, EQUALITY_TERM__LEFT);
    createEAttribute(equalityTermEClass, EQUALITY_TERM__OPERATOR);
    createEReference(equalityTermEClass, EQUALITY_TERM__RIGHT);

    notTermEClass = createEClass(NOT_TERM);
    createEAttribute(notTermEClass, NOT_TERM__NOT);
    createEReference(notTermEClass, NOT_TERM__ATOM);

    selfReferenceEClass = createEClass(SELF_REFERENCE);

    additionEClass = createEClass(ADDITION);
    createEReference(additionEClass, ADDITION__LEFT);
    createEAttribute(additionEClass, ADDITION__OPERATOR);
    createEReference(additionEClass, ADDITION__RIGHT);

    subtractionEClass = createEClass(SUBTRACTION);
    createEReference(subtractionEClass, SUBTRACTION__LEFT);
    createEAttribute(subtractionEClass, SUBTRACTION__OPERATOR);
    createEReference(subtractionEClass, SUBTRACTION__RIGHT);

    // Create enums
    msgDirectionEEnum = createEEnum(MSG_DIRECTION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    componentTypeEClass.getESuperTypes().add(this.getAbstractHelenaEntity());
    abstractComponentFieldTypeEClass.getESuperTypes().add(this.getAbstractFieldType());
    componentAttributeTypeEClass.getESuperTypes().add(this.getAbstractComponentFieldType());
    componentAssociationTypeEClass.getESuperTypes().add(this.getAbstractComponentFieldType());
    operationTypeEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    roleTypeEClass.getESuperTypes().add(this.getAbstractHelenaEntity());
    roleAttributeTypeEClass.getESuperTypes().add(this.getAbstractFieldType());
    messageTypeEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    ensembleStructureEClass.getESuperTypes().add(this.getAbstractHelenaEntity());
    roleBehaviorEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    processEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    processEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    processExpressionEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    actionPrefixEClass.getESuperTypes().add(this.getProcessExpression());
    nondeterministicChoiceEClass.getESuperTypes().add(this.getProcessExpression());
    ifThenElseEClass.getESuperTypes().add(this.getProcessExpression());
    processInvocationEClass.getESuperTypes().add(this.getProcessExpression());
    actionEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    abstractAssignmentEClass.getESuperTypes().add(this.getAction());
    abstractMessageCallEClass.getESuperTypes().add(this.getAction());
    outgoingMessageCallEClass.getESuperTypes().add(this.getAbstractMessageCall());
    incomingMessageCallEClass.getESuperTypes().add(this.getAbstractMessageCall());
    operationCallEClass.getESuperTypes().add(this.getAction());
    componentAttributeSetterEClass.getESuperTypes().add(this.getAction());
    roleAttributeSetterEClass.getESuperTypes().add(this.getAction());
    labelEClass.getESuperTypes().add(this.getAction());
    labelEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    playsQueryEClass.getESuperTypes().add(this.getAtom());
    relationEClass.getESuperTypes().add(this.getAtom());
    guardInParenthesesEClass.getESuperTypes().add(this.getAtom());
    abstractDataValueEClass.getESuperTypes().add(this.getDataExpression());
    booleanValueEClass.getESuperTypes().add(this.getAbstractDataValue());
    numberValueEClass.getESuperTypes().add(this.getAbstractDataValue());
    stringValueEClass.getESuperTypes().add(this.getAbstractDataValue());
    componentInstanceEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    componentAssociationTypeReferenceEClass.getESuperTypes().add(this.getComponentInstance());
    ownerReferenceEClass.getESuperTypes().add(this.getComponentInstance());
    abstractRoleInstanceEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    abstractRoleInstanceEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    abstractRoleInstanceEClass.getESuperTypes().add(this.getAbstractInstance());
    roleInstanceVariableEClass.getESuperTypes().add(this.getAbstractRoleInstance());
    formalRoleParamEClass.getESuperTypes().add(this.getAbstractRoleInstance());
    roleInstanceReferenceEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    abstractRoleInstanceReferenceEClass.getESuperTypes().add(this.getRoleInstanceReference());
    abstractDataVariableEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    abstractDataVariableEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    abstractDataVariableEClass.getESuperTypes().add(this.getAbstractInstance());
    dataVariableEClass.getESuperTypes().add(this.getAbstractDataVariable());
    formalDataParamEClass.getESuperTypes().add(this.getAbstractDataVariable());
    dataExpressionEClass.getESuperTypes().add(this.getAtom());
    dataExpressionEClass.getESuperTypes().add(this.getAbstractRoleBehaviorEntity());
    abstractDataReferenceEClass.getESuperTypes().add(this.getDataExpression());
    abstractDataVariableReferenceEClass.getESuperTypes().add(this.getAbstractDataReference());
    roleAttributeTypeReferenceEClass.getESuperTypes().add(this.getAbstractDataReference());
    componentAttributeTypeReferenceEClass.getESuperTypes().add(this.getAbstractDataReference());
    abstractHelenaEntityEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    abstractFieldTypeEClass.getESuperTypes().add(this.getAbstractDuplicateFreeObject());
    declaringRoleBehaviorEClass.getESuperTypes().add(this.getRoleBehavior());
    invokingRoleBehaviorEClass.getESuperTypes().add(this.getRoleBehavior());
    quitTermEClass.getESuperTypes().add(this.getProcessExpression());
    getAssignmentEClass.getESuperTypes().add(this.getAbstractAssignment());
    createAssignmentEClass.getESuperTypes().add(this.getAbstractAssignment());
    orTermEClass.getESuperTypes().add(this.getGuard());
    andTermEClass.getESuperTypes().add(this.getGuard());
    equalityTermEClass.getESuperTypes().add(this.getGuard());
    notTermEClass.getESuperTypes().add(this.getGuard());
    selfReferenceEClass.getESuperTypes().add(this.getRoleInstanceReference());
    additionEClass.getESuperTypes().add(this.getDataExpression());
    subtractionEClass.getESuperTypes().add(this.getDataExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_HeadPkg(), this.getPackageDeclaration(), null, "headPkg", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageDeclarationEClass, PackageDeclaration.class, "PackageDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPackageDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDeclaration_CompTypes(), this.getComponentType(), null, "compTypes", null, 0, -1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDeclaration_RoleTypes(), this.getRoleType(), null, "roleTypes", null, 0, -1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDeclaration_EnsStructs(), this.getEnsembleStructure(), null, "ensStructs", null, 0, -1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDeclaration_RoleBehaviors(), this.getRoleBehavior(), null, "roleBehaviors", null, 0, -1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentTypeEClass, ComponentType.class, "ComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentType_Attrs(), this.getComponentAttributeType(), null, "attrs", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentType_Assocs(), this.getComponentAssociationType(), null, "assocs", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentType_Ops(), this.getOperationType(), null, "ops", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractComponentFieldTypeEClass, AbstractComponentFieldType.class, "AbstractComponentFieldType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(componentAttributeTypeEClass, ComponentAttributeType.class, "ComponentAttributeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentAttributeType_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, ComponentAttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentAssociationTypeEClass, ComponentAssociationType.class, "ComponentAssociationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentAssociationType_Type(), this.getComponentType(), null, "type", null, 0, 1, ComponentAssociationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationTypeEClass, OperationType.class, "OperationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationType_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, OperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperationType_Name(), ecorePackage.getEString(), "name", null, 0, 1, OperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationType_FormalDataParamsBlock(), this.getFormalDataParamsBlock(), null, "formalDataParamsBlock", null, 0, 1, OperationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleTypeEClass, RoleType.class, "RoleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleType_CompTypes(), this.getComponentType(), null, "compTypes", null, 0, -1, RoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoleType_Roleattrs(), this.getRoleAttributeType(), null, "roleattrs", null, 0, -1, RoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoleType_Rolemsgs(), this.getMessageType(), null, "rolemsgs", null, 0, -1, RoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleAttributeTypeEClass, RoleAttributeType.class, "RoleAttributeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleAttributeType_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, RoleAttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(messageTypeEClass, MessageType.class, "MessageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMessageType_Direction(), this.getMsgDirection(), "direction", null, 0, 1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMessageType_Name(), ecorePackage.getEString(), "name", null, 0, 1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageType_FormalRoleParamsBlock(), this.getFormalRoleParamsBlock(), null, "formalRoleParamsBlock", null, 0, 1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMessageType_FormalDataParamsBlock(), this.getFormalDataParamsBlock(), null, "formalDataParamsBlock", null, 0, 1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ensembleStructureEClass, EnsembleStructure.class, "EnsembleStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnsembleStructure_RtWithMult(), this.getRoleTypeWithMultiplicity(), null, "rtWithMult", null, 0, -1, EnsembleStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleTypeWithMultiplicityEClass, RoleTypeWithMultiplicity.class, "RoleTypeWithMultiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleTypeWithMultiplicity_RoleType(), this.getRoleType(), null, "roleType", null, 0, 1, RoleTypeWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRoleTypeWithMultiplicity_Min(), ecorePackage.getEString(), "min", null, 0, 1, RoleTypeWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRoleTypeWithMultiplicity_Max(), ecorePackage.getEString(), "max", null, 0, 1, RoleTypeWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRoleTypeWithMultiplicity_Capacity(), ecorePackage.getEInt(), "capacity", null, 0, 1, RoleTypeWithMultiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleBehaviorEClass, RoleBehavior.class, "RoleBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleBehavior_RoleTypeRef(), this.getRoleType(), null, "roleTypeRef", null, 0, 1, RoleBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(processEClass, eu.ascens.helenaText.Process.class, "Process", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProcess_Name(), ecorePackage.getEString(), "name", null, 0, 1, eu.ascens.helenaText.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProcess_ProcessExpr(), this.getProcessExpression(), null, "processExpr", null, 0, 1, eu.ascens.helenaText.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(processExpressionEClass, ProcessExpression.class, "ProcessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(actionPrefixEClass, ActionPrefix.class, "ActionPrefix", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActionPrefix_Action(), this.getAction(), null, "action", null, 0, 1, ActionPrefix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getActionPrefix_ProcessExpr(), this.getProcessExpression(), null, "processExpr", null, 0, 1, ActionPrefix.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nondeterministicChoiceEClass, NondeterministicChoice.class, "NondeterministicChoice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNondeterministicChoice_First(), this.getProcessExpression(), null, "first", null, 0, 1, NondeterministicChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNondeterministicChoice_Second(), this.getProcessExpression(), null, "second", null, 0, 1, NondeterministicChoice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifThenElseEClass, IfThenElse.class, "IfThenElse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfThenElse_Guard(), this.getGuard(), null, "guard", null, 0, 1, IfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElse_IfProcessExpr(), this.getProcessExpression(), null, "ifProcessExpr", null, 0, 1, IfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElse_ElseProcessExpr(), this.getProcessExpression(), null, "elseProcessExpr", null, 0, 1, IfThenElse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(processInvocationEClass, ProcessInvocation.class, "ProcessInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProcessInvocation_Process(), this.getProcess(), null, "process", null, 0, 1, ProcessInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractAssignmentEClass, AbstractAssignment.class, "AbstractAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractAssignment_RoleInst(), this.getRoleInstanceVariable(), null, "roleInst", null, 0, 1, AbstractAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractAssignment_RoleTypeRef(), this.getRoleType(), null, "roleTypeRef", null, 0, 1, AbstractAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractAssignment_CompInstance(), this.getComponentInstance(), null, "compInstance", null, 0, 1, AbstractAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractMessageCallEClass, AbstractMessageCall.class, "AbstractMessageCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractMessageCall_MsgName(), ecorePackage.getEString(), "msgName", null, 0, 1, AbstractMessageCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outgoingMessageCallEClass, OutgoingMessageCall.class, "OutgoingMessageCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutgoingMessageCall_Receiver(), this.getAbstractRoleInstanceReference(), null, "receiver", null, 0, 1, OutgoingMessageCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutgoingMessageCall_ActualRoleParamsBlock(), this.getActualRoleParamsBlock(), null, "actualRoleParamsBlock", null, 0, 1, OutgoingMessageCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutgoingMessageCall_ActualDataParamsBlock(), this.getActualDataParamsBlock(), null, "actualDataParamsBlock", null, 0, 1, OutgoingMessageCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(incomingMessageCallEClass, IncomingMessageCall.class, "IncomingMessageCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIncomingMessageCall_FormalRoleParamsBlock(), this.getFormalRoleParamsBlock(), null, "formalRoleParamsBlock", null, 0, 1, IncomingMessageCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIncomingMessageCall_FormalDataParamsBlock(), this.getFormalDataParamsBlock(), null, "formalDataParamsBlock", null, 0, 1, IncomingMessageCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationCallEClass, OperationCall.class, "OperationCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationCall_Variable(), this.getDataVariable(), null, "variable", null, 0, 1, OperationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperationCall_OpName(), ecorePackage.getEString(), "opName", null, 0, 1, OperationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationCall_ActualDataParamsBlock(), this.getActualDataParamsBlock(), null, "actualDataParamsBlock", null, 0, 1, OperationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentAttributeSetterEClass, ComponentAttributeSetter.class, "ComponentAttributeSetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentAttributeSetter_Attr(), this.getComponentAttributeTypeReference(), null, "attr", null, 0, 1, ComponentAttributeSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentAttributeSetter_Value(), this.getDataExpression(), null, "value", null, 0, 1, ComponentAttributeSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleAttributeSetterEClass, RoleAttributeSetter.class, "RoleAttributeSetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleAttributeSetter_Attr(), this.getRoleAttributeTypeReference(), null, "attr", null, 0, 1, RoleAttributeSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoleAttributeSetter_Value(), this.getDataExpression(), null, "value", null, 0, 1, RoleAttributeSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLabel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(atomEClass, Atom.class, "Atom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(playsQueryEClass, PlaysQuery.class, "PlaysQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPlaysQuery_RoleTypeRef(), this.getRoleType(), null, "roleTypeRef", null, 0, 1, PlaysQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPlaysQuery_CompInstance(), this.getComponentInstance(), null, "compInstance", null, 0, 1, PlaysQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelation_Left(), this.getDataExpression(), null, "left", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelation_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelation_Right(), this.getDataExpression(), null, "right", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(guardInParenthesesEClass, GuardInParentheses.class, "GuardInParentheses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGuardInParentheses_Guard(), this.getGuard(), null, "guard", null, 0, 1, GuardInParentheses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractDataValueEClass, AbstractDataValue.class, "AbstractDataValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractDataValue_Value(), theXbasePackage.getXExpression(), null, "value", null, 0, 1, AbstractDataValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanValueEClass, BooleanValue.class, "BooleanValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numberValueEClass, NumberValue.class, "NumberValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stringValueEClass, StringValue.class, "StringValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(componentInstanceEClass, ComponentInstance.class, "ComponentInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(componentAssociationTypeReferenceEClass, ComponentAssociationTypeReference.class, "ComponentAssociationTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentAssociationTypeReference_Ref(), this.getComponentAssociationType(), null, "ref", null, 0, 1, ComponentAssociationTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ownerReferenceEClass, OwnerReference.class, "OwnerReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractRoleInstanceEClass, AbstractRoleInstance.class, "AbstractRoleInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractRoleInstance_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractRoleInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleInstanceVariableEClass, RoleInstanceVariable.class, "RoleInstanceVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(formalRoleParamEClass, FormalRoleParam.class, "FormalRoleParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormalRoleParam_Type(), this.getRoleType(), null, "type", null, 0, 1, FormalRoleParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalRoleParamsBlockEClass, FormalRoleParamsBlock.class, "FormalRoleParamsBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormalRoleParamsBlock_Params(), this.getFormalRoleParam(), null, "params", null, 0, -1, FormalRoleParamsBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleInstanceReferenceEClass, RoleInstanceReference.class, "RoleInstanceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractRoleInstanceReferenceEClass, AbstractRoleInstanceReference.class, "AbstractRoleInstanceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractRoleInstanceReference_Ref(), this.getAbstractRoleInstance(), null, "ref", null, 0, 1, AbstractRoleInstanceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actualRoleParamsBlockEClass, ActualRoleParamsBlock.class, "ActualRoleParamsBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActualRoleParamsBlock_Params(), this.getRoleInstanceReference(), null, "params", null, 0, -1, ActualRoleParamsBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractDataVariableEClass, AbstractDataVariable.class, "AbstractDataVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractDataVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractDataVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataVariableEClass, DataVariable.class, "DataVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(formalDataParamEClass, FormalDataParam.class, "FormalDataParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormalDataParam_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, FormalDataParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalDataParamsBlockEClass, FormalDataParamsBlock.class, "FormalDataParamsBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormalDataParamsBlock_Params(), this.getFormalDataParam(), null, "params", null, 0, -1, FormalDataParamsBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataExpressionEClass, DataExpression.class, "DataExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractDataReferenceEClass, AbstractDataReference.class, "AbstractDataReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractDataVariableReferenceEClass, AbstractDataVariableReference.class, "AbstractDataVariableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractDataVariableReference_Ref(), this.getAbstractDataVariable(), null, "ref", null, 0, 1, AbstractDataVariableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roleAttributeTypeReferenceEClass, RoleAttributeTypeReference.class, "RoleAttributeTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoleAttributeTypeReference_Ref(), this.getRoleAttributeType(), null, "ref", null, 0, 1, RoleAttributeTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentAttributeTypeReferenceEClass, ComponentAttributeTypeReference.class, "ComponentAttributeTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComponentAttributeTypeReference_Ref(), this.getComponentAttributeType(), null, "ref", null, 0, 1, ComponentAttributeTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actualDataParamsBlockEClass, ActualDataParamsBlock.class, "ActualDataParamsBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActualDataParamsBlock_Params(), this.getDataExpression(), null, "params", null, 0, -1, ActualDataParamsBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractDuplicateFreeObjectEClass, AbstractDuplicateFreeObject.class, "AbstractDuplicateFreeObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractHelenaEntityEClass, AbstractHelenaEntity.class, "AbstractHelenaEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractHelenaEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractHelenaEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractFieldTypeEClass, AbstractFieldType.class, "AbstractFieldType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractFieldType_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractRoleBehaviorEntityEClass, AbstractRoleBehaviorEntity.class, "AbstractRoleBehaviorEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractInstanceEClass, AbstractInstance.class, "AbstractInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(declaringRoleBehaviorEClass, DeclaringRoleBehavior.class, "DeclaringRoleBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDeclaringRoleBehavior_ProcessExpr(), this.getProcessExpression(), null, "processExpr", null, 0, 1, DeclaringRoleBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invokingRoleBehaviorEClass, InvokingRoleBehavior.class, "InvokingRoleBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInvokingRoleBehavior_ProcessInvocation(), this.getProcessInvocation(), null, "processInvocation", null, 0, 1, InvokingRoleBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInvokingRoleBehavior_Processes(), this.getProcess(), null, "processes", null, 0, -1, InvokingRoleBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(quitTermEClass, QuitTerm.class, "QuitTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(getAssignmentEClass, GetAssignment.class, "GetAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(createAssignmentEClass, CreateAssignment.class, "CreateAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(orTermEClass, OrTerm.class, "OrTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrTerm_Left(), this.getGuard(), null, "left", null, 0, 1, OrTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrTerm_Right(), this.getGuard(), null, "right", null, 0, 1, OrTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andTermEClass, AndTerm.class, "AndTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndTerm_Left(), this.getGuard(), null, "left", null, 0, 1, AndTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndTerm_Right(), this.getGuard(), null, "right", null, 0, 1, AndTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityTermEClass, EqualityTerm.class, "EqualityTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEqualityTerm_Left(), this.getGuard(), null, "left", null, 0, 1, EqualityTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEqualityTerm_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, EqualityTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEqualityTerm_Right(), this.getGuard(), null, "right", null, 0, 1, EqualityTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(notTermEClass, NotTerm.class, "NotTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNotTerm_Not(), ecorePackage.getEString(), "not", null, 0, 1, NotTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNotTerm_Atom(), this.getAtom(), null, "atom", null, 0, 1, NotTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selfReferenceEClass, SelfReference.class, "SelfReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(additionEClass, Addition.class, "Addition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAddition_Left(), this.getDataExpression(), null, "left", null, 0, 1, Addition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAddition_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, Addition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAddition_Right(), this.getDataExpression(), null, "right", null, 0, 1, Addition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subtractionEClass, Subtraction.class, "Subtraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSubtraction_Left(), this.getDataExpression(), null, "left", null, 0, 1, Subtraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSubtraction_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, Subtraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSubtraction_Right(), this.getDataExpression(), null, "right", null, 0, 1, Subtraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(msgDirectionEEnum, MsgDirection.class, "MsgDirection");
    addEEnumLiteral(msgDirectionEEnum, MsgDirection.IN);
    addEEnumLiteral(msgDirectionEEnum, MsgDirection.OUT);
    addEEnumLiteral(msgDirectionEEnum, MsgDirection.INOUT);

    // Create resource
    createResource(eNS_URI);
  }

} //HelenaTextPackageImpl
