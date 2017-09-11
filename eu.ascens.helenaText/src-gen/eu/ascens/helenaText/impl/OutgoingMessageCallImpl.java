/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.AbstractRoleInstanceReference;
import eu.ascens.helenaText.ActualDataParamsBlock;
import eu.ascens.helenaText.ActualRoleParamsBlock;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.OutgoingMessageCall;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outgoing Message Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.OutgoingMessageCallImpl#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.OutgoingMessageCallImpl#getActualRoleParamsBlock <em>Actual Role Params Block</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.OutgoingMessageCallImpl#getActualDataParamsBlock <em>Actual Data Params Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutgoingMessageCallImpl extends AbstractMessageCallImpl implements OutgoingMessageCall
{
  /**
   * The cached value of the '{@link #getReceiver() <em>Receiver</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReceiver()
   * @generated
   * @ordered
   */
  protected AbstractRoleInstanceReference receiver;

  /**
   * The cached value of the '{@link #getActualRoleParamsBlock() <em>Actual Role Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActualRoleParamsBlock()
   * @generated
   * @ordered
   */
  protected ActualRoleParamsBlock actualRoleParamsBlock;

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
  protected OutgoingMessageCallImpl()
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
    return HelenaTextPackage.Literals.OUTGOING_MESSAGE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractRoleInstanceReference getReceiver()
  {
    return receiver;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReceiver(AbstractRoleInstanceReference newReceiver, NotificationChain msgs)
  {
    AbstractRoleInstanceReference oldReceiver = receiver;
    receiver = newReceiver;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER, oldReceiver, newReceiver);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReceiver(AbstractRoleInstanceReference newReceiver)
  {
    if (newReceiver != receiver)
    {
      NotificationChain msgs = null;
      if (receiver != null)
        msgs = ((InternalEObject)receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER, null, msgs);
      if (newReceiver != null)
        msgs = ((InternalEObject)newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER, null, msgs);
      msgs = basicSetReceiver(newReceiver, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER, newReceiver, newReceiver));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActualRoleParamsBlock getActualRoleParamsBlock()
  {
    return actualRoleParamsBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActualRoleParamsBlock(ActualRoleParamsBlock newActualRoleParamsBlock, NotificationChain msgs)
  {
    ActualRoleParamsBlock oldActualRoleParamsBlock = actualRoleParamsBlock;
    actualRoleParamsBlock = newActualRoleParamsBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK, oldActualRoleParamsBlock, newActualRoleParamsBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActualRoleParamsBlock(ActualRoleParamsBlock newActualRoleParamsBlock)
  {
    if (newActualRoleParamsBlock != actualRoleParamsBlock)
    {
      NotificationChain msgs = null;
      if (actualRoleParamsBlock != null)
        msgs = ((InternalEObject)actualRoleParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK, null, msgs);
      if (newActualRoleParamsBlock != null)
        msgs = ((InternalEObject)newActualRoleParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK, null, msgs);
      msgs = basicSetActualRoleParamsBlock(newActualRoleParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK, newActualRoleParamsBlock, newActualRoleParamsBlock));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK, oldActualDataParamsBlock, newActualDataParamsBlock);
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
        msgs = ((InternalEObject)actualDataParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK, null, msgs);
      if (newActualDataParamsBlock != null)
        msgs = ((InternalEObject)newActualDataParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK, null, msgs);
      msgs = basicSetActualDataParamsBlock(newActualDataParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK, newActualDataParamsBlock, newActualDataParamsBlock));
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
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER:
        return basicSetReceiver(null, msgs);
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK:
        return basicSetActualRoleParamsBlock(null, msgs);
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER:
        return getReceiver();
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK:
        return getActualRoleParamsBlock();
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER:
        setReceiver((AbstractRoleInstanceReference)newValue);
        return;
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK:
        setActualRoleParamsBlock((ActualRoleParamsBlock)newValue);
        return;
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER:
        setReceiver((AbstractRoleInstanceReference)null);
        return;
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK:
        setActualRoleParamsBlock((ActualRoleParamsBlock)null);
        return;
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__RECEIVER:
        return receiver != null;
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_ROLE_PARAMS_BLOCK:
        return actualRoleParamsBlock != null;
      case HelenaTextPackage.OUTGOING_MESSAGE_CALL__ACTUAL_DATA_PARAMS_BLOCK:
        return actualDataParamsBlock != null;
    }
    return super.eIsSet(featureID);
  }

} //OutgoingMessageCallImpl
