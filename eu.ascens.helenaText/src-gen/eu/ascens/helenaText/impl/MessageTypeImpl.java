/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.MsgDirection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.MessageTypeImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.MessageTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.MessageTypeImpl#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.MessageTypeImpl#getFormalDataParamsBlock <em>Formal Data Params Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageTypeImpl extends AbstractDuplicateFreeObjectImpl implements MessageType
{
  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final MsgDirection DIRECTION_EDEFAULT = MsgDirection.IN;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected MsgDirection direction = DIRECTION_EDEFAULT;

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
  protected MessageTypeImpl()
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
    return HelenaTextPackage.Literals.MESSAGE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MsgDirection getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirection(MsgDirection newDirection)
  {
    MsgDirection oldDirection = direction;
    direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MESSAGE_TYPE__DIRECTION, oldDirection, direction));
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
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MESSAGE_TYPE__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK, oldFormalRoleParamsBlock, newFormalRoleParamsBlock);
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
        msgs = ((InternalEObject)formalRoleParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK, null, msgs);
      if (newFormalRoleParamsBlock != null)
        msgs = ((InternalEObject)newFormalRoleParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK, null, msgs);
      msgs = basicSetFormalRoleParamsBlock(newFormalRoleParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK, newFormalRoleParamsBlock, newFormalRoleParamsBlock));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK, oldFormalDataParamsBlock, newFormalDataParamsBlock);
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
        msgs = ((InternalEObject)formalDataParamsBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK, null, msgs);
      if (newFormalDataParamsBlock != null)
        msgs = ((InternalEObject)newFormalDataParamsBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK, null, msgs);
      msgs = basicSetFormalDataParamsBlock(newFormalDataParamsBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK, newFormalDataParamsBlock, newFormalDataParamsBlock));
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
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK:
        return basicSetFormalRoleParamsBlock(null, msgs);
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.MESSAGE_TYPE__DIRECTION:
        return getDirection();
      case HelenaTextPackage.MESSAGE_TYPE__NAME:
        return getName();
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK:
        return getFormalRoleParamsBlock();
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.MESSAGE_TYPE__DIRECTION:
        setDirection((MsgDirection)newValue);
        return;
      case HelenaTextPackage.MESSAGE_TYPE__NAME:
        setName((String)newValue);
        return;
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK:
        setFormalRoleParamsBlock((FormalRoleParamsBlock)newValue);
        return;
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.MESSAGE_TYPE__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case HelenaTextPackage.MESSAGE_TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK:
        setFormalRoleParamsBlock((FormalRoleParamsBlock)null);
        return;
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK:
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
      case HelenaTextPackage.MESSAGE_TYPE__DIRECTION:
        return direction != DIRECTION_EDEFAULT;
      case HelenaTextPackage.MESSAGE_TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_ROLE_PARAMS_BLOCK:
        return formalRoleParamsBlock != null;
      case HelenaTextPackage.MESSAGE_TYPE__FORMAL_DATA_PARAMS_BLOCK:
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
    result.append(" (direction: ");
    result.append(direction);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //MessageTypeImpl
