/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.DeclaringRoleBehavior;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.ProcessExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaring Role Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.DeclaringRoleBehaviorImpl#getProcessExpr <em>Process Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeclaringRoleBehaviorImpl extends RoleBehaviorImpl implements DeclaringRoleBehavior
{
  /**
   * The cached value of the '{@link #getProcessExpr() <em>Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessExpr()
   * @generated
   * @ordered
   */
  protected ProcessExpression processExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DeclaringRoleBehaviorImpl()
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
    return HelenaTextPackage.Literals.DECLARING_ROLE_BEHAVIOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessExpression getProcessExpr()
  {
    return processExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProcessExpr(ProcessExpression newProcessExpr, NotificationChain msgs)
  {
    ProcessExpression oldProcessExpr = processExpr;
    processExpr = newProcessExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR, oldProcessExpr, newProcessExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcessExpr(ProcessExpression newProcessExpr)
  {
    if (newProcessExpr != processExpr)
    {
      NotificationChain msgs = null;
      if (processExpr != null)
        msgs = ((InternalEObject)processExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR, null, msgs);
      if (newProcessExpr != null)
        msgs = ((InternalEObject)newProcessExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR, null, msgs);
      msgs = basicSetProcessExpr(newProcessExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR, newProcessExpr, newProcessExpr));
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
      case HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR:
        return basicSetProcessExpr(null, msgs);
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
      case HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR:
        return getProcessExpr();
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
      case HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR:
        setProcessExpr((ProcessExpression)newValue);
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
      case HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR:
        setProcessExpr((ProcessExpression)null);
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
      case HelenaTextPackage.DECLARING_ROLE_BEHAVIOR__PROCESS_EXPR:
        return processExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //DeclaringRoleBehaviorImpl
