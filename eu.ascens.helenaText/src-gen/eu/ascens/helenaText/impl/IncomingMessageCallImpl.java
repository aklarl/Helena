/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.IncomingMessageCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Incoming Message Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.IncomingMessageCallImpl#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.IncomingMessageCallImpl#getFormalDataParamsBlock <em>Formal Data Params Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IncomingMessageCallImpl extends AbstractMessageCallImpl implements IncomingMessageCall
{
  /**
   * The cached value of the '{@link #getFormalRoleParamsBlock() <em>Formal Role Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalRoleParamsBlock()
   * @generated
   * @ordered
   */
  protected FormalRoleParamsBlock formalRoleParamsBlock;

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
  protected IncomingMessageCallImpl()
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
    return HelenaTextPackage.Literals.INCOMING_MESSAGE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormalRoleParamsBlock getFormalRoleParamsBlock()
  {
    return formalRoleParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormalRoleParamsBlock(FormalRoleParamsBlock newFormalRoleParamsBlock, NotificationChain msgs)
  {
    FormalRoleParamsBlock oldFormalRoleParamsBlock = formalRoleParamsBlock;
    formalRoleParamsBlock = newFormalRoleParamsBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK, oldFormalRoleParamsBlock, newFormalRoleParamsBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalRoleParamsBlock(FormalRoleParamsBlock newFormalRoleParamsBlock)
  {
    if (newFormalRoleParamsBlock != formalRoleParamsBlock)
    {
      NotificationChain msgs = null;
      if (formalRoleParamsBlock != null)
        msgs = ((InternalEObject)formalRoleParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK, null, msgs);
      if (newFormalRoleParamsBlock != null)
        msgs = ((InternalEObject)newFormalRoleParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK, null, msgs);
      msgs = basicSetFormalRoleParamsBlock(newFormalRoleParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK, newFormalRoleParamsBlock, newFormalRoleParamsBlock));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK, oldFormalDataParamsBlock, newFormalDataParamsBlock);
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
        msgs = ((InternalEObject)formalDataParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK, null, msgs);
      if (newFormalDataParamsBlock != null)
        msgs = ((InternalEObject)newFormalDataParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK, null, msgs);
      msgs = basicSetFormalDataParamsBlock(newFormalDataParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK, newFormalDataParamsBlock, newFormalDataParamsBlock));
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
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK:
        return basicSetFormalRoleParamsBlock(null, msgs);
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK:
        return getFormalRoleParamsBlock();
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK:
        setFormalRoleParamsBlock((FormalRoleParamsBlock)newValue);
        return;
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK:
        setFormalRoleParamsBlock((FormalRoleParamsBlock)null);
        return;
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_ROLE_PARAMS_BLOCK:
        return formalRoleParamsBlock != null;
      case HelenaTextPackage.INCOMING_MESSAGE_CALL__FORMAL_DATA_PARAMS_BLOCK:
        return formalDataParamsBlock != null;
    }
    return super.eIsSet(featureID);
  }

} //IncomingMessageCallImpl
