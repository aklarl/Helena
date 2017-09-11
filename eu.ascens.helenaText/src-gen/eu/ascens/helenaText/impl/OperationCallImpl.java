/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.ActualDataParamsBlock;
import eu.ascens.helenaText.DataVariable;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.OperationCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.OperationCallImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.OperationCallImpl#getOpName <em>Op Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.OperationCallImpl#getActualDataParamsBlock <em>Actual Data Params Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationCallImpl extends ActionImpl implements OperationCall
{
  /**
   * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable()
   * @generated
   * @ordered
   */
  protected DataVariable variable;

  /**
   * The default value of the '{@link #getOpName() <em>Op Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpName()
   * @generated
   * @ordered
   */
  protected static final String OP_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOpName() <em>Op Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpName()
   * @generated
   * @ordered
   */
  protected String opName = OP_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getActualDataParamsBlock() <em>Actual Data Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActualDataParamsBlock()
   * @generated
   * @ordered
   */
  protected ActualDataParamsBlock actualDataParamsBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationCallImpl()
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
    return HelenaTextPackage.Literals.OPERATION_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataVariable getVariable()
  {
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariable(DataVariable newVariable, NotificationChain msgs)
  {
    DataVariable oldVariable = variable;
    variable = newVariable;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_CALL__VARIABLE, oldVariable, newVariable);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable(DataVariable newVariable)
  {
    if (newVariable != variable)
    {
      NotificationChain msgs = null;
      if (variable != null)
        msgs = ((InternalEObject)variable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_CALL__VARIABLE, null, msgs);
      if (newVariable != null)
        msgs = ((InternalEObject)newVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_CALL__VARIABLE, null, msgs);
      msgs = basicSetVariable(newVariable, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_CALL__VARIABLE, newVariable, newVariable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOpName()
  {
    return opName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpName(String newOpName)
  {
    String oldOpName = opName;
    opName = newOpName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_CALL__OP_NAME, oldOpName, opName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualDataParamsBlock getActualDataParamsBlock()
  {
    return actualDataParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActualDataParamsBlock(ActualDataParamsBlock newActualDataParamsBlock, NotificationChain msgs)
  {
    ActualDataParamsBlock oldActualDataParamsBlock = actualDataParamsBlock;
    actualDataParamsBlock = newActualDataParamsBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK, oldActualDataParamsBlock, newActualDataParamsBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActualDataParamsBlock(ActualDataParamsBlock newActualDataParamsBlock)
  {
    if (newActualDataParamsBlock != actualDataParamsBlock)
    {
      NotificationChain msgs = null;
      if (actualDataParamsBlock != null)
        msgs = ((InternalEObject)actualDataParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK, null, msgs);
      if (newActualDataParamsBlock != null)
        msgs = ((InternalEObject)newActualDataParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK, null, msgs);
      msgs = basicSetActualDataParamsBlock(newActualDataParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK, newActualDataParamsBlock, newActualDataParamsBlock));
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
      case HelenaTextPackage.OPERATION_CALL__VARIABLE:
        return basicSetVariable(null, msgs);
      case HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK:
        return basicSetActualDataParamsBlock(null, msgs);
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
      case HelenaTextPackage.OPERATION_CALL__VARIABLE:
        return getVariable();
      case HelenaTextPackage.OPERATION_CALL__OP_NAME:
        return getOpName();
      case HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK:
        return getActualDataParamsBlock();
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
      case HelenaTextPackage.OPERATION_CALL__VARIABLE:
        setVariable((DataVariable)newValue);
        return;
      case HelenaTextPackage.OPERATION_CALL__OP_NAME:
        setOpName((String)newValue);
        return;
      case HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK:
        setActualDataParamsBlock((ActualDataParamsBlock)newValue);
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
      case HelenaTextPackage.OPERATION_CALL__VARIABLE:
        setVariable((DataVariable)null);
        return;
      case HelenaTextPackage.OPERATION_CALL__OP_NAME:
        setOpName(OP_NAME_EDEFAULT);
        return;
      case HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK:
        setActualDataParamsBlock((ActualDataParamsBlock)null);
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
      case HelenaTextPackage.OPERATION_CALL__VARIABLE:
        return variable != null;
      case HelenaTextPackage.OPERATION_CALL__OP_NAME:
        return OP_NAME_EDEFAULT == null ? opName != null : !OP_NAME_EDEFAULT.equals(opName);
      case HelenaTextPackage.OPERATION_CALL__ACTUAL_DATA_PARAMS_BLOCK:
        return actualDataParamsBlock != null;
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
    result.append(" (opName: ");
    result.append(opName);
    result.append(')');
    return result.toString();
  }

} //OperationCallImpl
