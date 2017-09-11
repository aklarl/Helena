/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.OperationType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.OperationTypeImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.OperationTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.OperationTypeImpl#getFormalDataParamsBlock <em>Formal Data Params Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationTypeImpl extends AbstractDuplicateFreeObjectImpl implements OperationType
{
  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected JvmTypeReference returnType;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFormalDataParamsBlock() <em>Formal Data Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalDataParamsBlock()
   * @generated
   * @ordered
   */
  protected FormalDataParamsBlock formalDataParamsBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return HelenaTextPackage.Literals.OPERATION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReturnType(JvmTypeReference newReturnType, NotificationChain msgs)
  {
    JvmTypeReference oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE, oldReturnType, newReturnType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(JvmTypeReference newReturnType)
  {
    if (newReturnType != returnType)
    {
      NotificationChain msgs = null;
      if (returnType != null)
        msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE, null, msgs);
      if (newReturnType != null)
        msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE, null, msgs);
      msgs = basicSetReturnType(newReturnType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE, newReturnType, newReturnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalDataParamsBlock getFormalDataParamsBlock()
  {
    return formalDataParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormalDataParamsBlock(FormalDataParamsBlock newFormalDataParamsBlock, NotificationChain msgs)
  {
    FormalDataParamsBlock oldFormalDataParamsBlock = formalDataParamsBlock;
    formalDataParamsBlock = newFormalDataParamsBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK, oldFormalDataParamsBlock, newFormalDataParamsBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalDataParamsBlock(FormalDataParamsBlock newFormalDataParamsBlock)
  {
    if (newFormalDataParamsBlock != formalDataParamsBlock)
    {
      NotificationChain msgs = null;
      if (formalDataParamsBlock != null)
        msgs = ((InternalEObject)formalDataParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK, null, msgs);
      if (newFormalDataParamsBlock != null)
        msgs = ((InternalEObject)newFormalDataParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK, null, msgs);
      msgs = basicSetFormalDataParamsBlock(newFormalDataParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK, newFormalDataParamsBlock, newFormalDataParamsBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE:
        return basicSetReturnType(null, msgs);
      case HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK:
        return basicSetFormalDataParamsBlock(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE:
        return getReturnType();
      case HelenaTextPackage.OPERATION_TYPE__NAME:
        return getName();
      case HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK:
        return getFormalDataParamsBlock();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE:
        setReturnType((JvmTypeReference)newValue);
        return;
      case HelenaTextPackage.OPERATION_TYPE__NAME:
        setName((String)newValue);
        return;
      case HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK:
        setFormalDataParamsBlock((FormalDataParamsBlock)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE:
        setReturnType((JvmTypeReference)null);
        return;
      case HelenaTextPackage.OPERATION_TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK:
        setFormalDataParamsBlock((FormalDataParamsBlock)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case HelenaTextPackage.OPERATION_TYPE__RETURN_TYPE:
        return returnType != null;
      case HelenaTextPackage.OPERATION_TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case HelenaTextPackage.OPERATION_TYPE__FORMAL_DATA_PARAMS_BLOCK:
        return formalDataParamsBlock != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //OperationTypeImpl
