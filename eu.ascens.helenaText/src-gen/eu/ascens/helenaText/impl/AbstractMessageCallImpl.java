/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.AbstractMessageCall;
import eu.ascens.helenaText.HelenaTextPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Message Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.AbstractMessageCallImpl#getMsgName <em>Msg Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractMessageCallImpl extends ActionImpl implements AbstractMessageCall
{
  /**
   * The default value of the '{@link #getMsgName() <em>Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsgName()
   * @generated
   * @ordered
   */
  protected static final String MSG_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMsgName() <em>Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsgName()
   * @generated
   * @ordered
   */
  protected String msgName = MSG_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractMessageCallImpl()
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
    return HelenaTextPackage.Literals.ABSTRACT_MESSAGE_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMsgName()
  {
    return msgName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMsgName(String newMsgName)
  {
    String oldMsgName = msgName;
    msgName = newMsgName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ABSTRACT_MESSAGE_CALL__MSG_NAME, oldMsgName, msgName));
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
      case HelenaTextPackage.ABSTRACT_MESSAGE_CALL__MSG_NAME:
        return getMsgName();
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
      case HelenaTextPackage.ABSTRACT_MESSAGE_CALL__MSG_NAME:
        setMsgName((String)newValue);
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
      case HelenaTextPackage.ABSTRACT_MESSAGE_CALL__MSG_NAME:
        setMsgName(MSG_NAME_EDEFAULT);
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
      case HelenaTextPackage.ABSTRACT_MESSAGE_CALL__MSG_NAME:
        return MSG_NAME_EDEFAULT == null ? msgName != null : !MSG_NAME_EDEFAULT.equals(msgName);
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
    result.append(" (msgName: ");
    result.append(msgName);
    result.append(')');
    return result.toString();
  }

} //AbstractMessageCallImpl
