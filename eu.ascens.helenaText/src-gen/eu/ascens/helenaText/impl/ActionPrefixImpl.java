/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.Action;
import eu.ascens.helenaText.ActionPrefix;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.ProcessExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action Prefix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.ActionPrefixImpl#getAction <em>Action</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.ActionPrefixImpl#getProcessExpr <em>Process Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionPrefixImpl extends ProcessExpressionImpl implements ActionPrefix
{
  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected Action action;

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
  protected ActionPrefixImpl()
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
    return HelenaTextPackage.Literals.ACTION_PREFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(Action newAction, NotificationChain msgs)
  {
    Action oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ACTION_PREFIX__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(Action newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ACTION_PREFIX__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ACTION_PREFIX__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ACTION_PREFIX__ACTION, newAction, newAction));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR, oldProcessExpr, newProcessExpr);
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
        msgs = ((InternalEObject)processExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR, null, msgs);
      if (newProcessExpr != null)
        msgs = ((InternalEObject)newProcessExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR, null, msgs);
      msgs = basicSetProcessExpr(newProcessExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR, newProcessExpr, newProcessExpr));
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
      case HelenaTextPackage.ACTION_PREFIX__ACTION:
        return basicSetAction(null, msgs);
      case HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR:
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
      case HelenaTextPackage.ACTION_PREFIX__ACTION:
        return getAction();
      case HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR:
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
      case HelenaTextPackage.ACTION_PREFIX__ACTION:
        setAction((Action)newValue);
        return;
      case HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR:
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
      case HelenaTextPackage.ACTION_PREFIX__ACTION:
        setAction((Action)null);
        return;
      case HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR:
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
      case HelenaTextPackage.ACTION_PREFIX__ACTION:
        return action != null;
      case HelenaTextPackage.ACTION_PREFIX__PROCESS_EXPR:
        return processExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //ActionPrefixImpl
