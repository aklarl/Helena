/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.Guard;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.IfThenElse;
import eu.ascens.helenaText.ProcessExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Then Else</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.IfThenElseImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.IfThenElseImpl#getIfProcessExpr <em>If Process Expr</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.IfThenElseImpl#getElseProcessExpr <em>Else Process Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfThenElseImpl extends ProcessExpressionImpl implements IfThenElse
{
  /**
   * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuard()
   * @generated
   * @ordered
   */
  protected Guard guard;

  /**
   * The cached value of the '{@link #getIfProcessExpr() <em>If Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfProcessExpr()
   * @generated
   * @ordered
   */
  protected ProcessExpression ifProcessExpr;

  /**
   * The cached value of the '{@link #getElseProcessExpr() <em>Else Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseProcessExpr()
   * @generated
   * @ordered
   */
  protected ProcessExpression elseProcessExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfThenElseImpl()
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
    return HelenaTextPackage.Literals.IF_THEN_ELSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard getGuard()
  {
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuard(Guard newGuard, NotificationChain msgs)
  {
    Guard oldGuard = guard;
    guard = newGuard;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.IF_THEN_ELSE__GUARD, oldGuard, newGuard);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuard(Guard newGuard)
  {
    if (newGuard != guard)
    {
      NotificationChain msgs = null;
      if (guard != null)
        msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.IF_THEN_ELSE__GUARD, null, msgs);
      if (newGuard != null)
        msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.IF_THEN_ELSE__GUARD, null, msgs);
      msgs = basicSetGuard(newGuard, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.IF_THEN_ELSE__GUARD, newGuard, newGuard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessExpression getIfProcessExpr()
  {
    return ifProcessExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIfProcessExpr(ProcessExpression newIfProcessExpr, NotificationChain msgs)
  {
    ProcessExpression oldIfProcessExpr = ifProcessExpr;
    ifProcessExpr = newIfProcessExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR, oldIfProcessExpr, newIfProcessExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIfProcessExpr(ProcessExpression newIfProcessExpr)
  {
    if (newIfProcessExpr != ifProcessExpr)
    {
      NotificationChain msgs = null;
      if (ifProcessExpr != null)
        msgs = ((InternalEObject)ifProcessExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR, null, msgs);
      if (newIfProcessExpr != null)
        msgs = ((InternalEObject)newIfProcessExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR, null, msgs);
      msgs = basicSetIfProcessExpr(newIfProcessExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR, newIfProcessExpr, newIfProcessExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessExpression getElseProcessExpr()
  {
    return elseProcessExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseProcessExpr(ProcessExpression newElseProcessExpr, NotificationChain msgs)
  {
    ProcessExpression oldElseProcessExpr = elseProcessExpr;
    elseProcessExpr = newElseProcessExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR, oldElseProcessExpr, newElseProcessExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseProcessExpr(ProcessExpression newElseProcessExpr)
  {
    if (newElseProcessExpr != elseProcessExpr)
    {
      NotificationChain msgs = null;
      if (elseProcessExpr != null)
        msgs = ((InternalEObject)elseProcessExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR, null, msgs);
      if (newElseProcessExpr != null)
        msgs = ((InternalEObject)newElseProcessExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR, null, msgs);
      msgs = basicSetElseProcessExpr(newElseProcessExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR, newElseProcessExpr, newElseProcessExpr));
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
      case HelenaTextPackage.IF_THEN_ELSE__GUARD:
        return basicSetGuard(null, msgs);
      case HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR:
        return basicSetIfProcessExpr(null, msgs);
      case HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR:
        return basicSetElseProcessExpr(null, msgs);
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
      case HelenaTextPackage.IF_THEN_ELSE__GUARD:
        return getGuard();
      case HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR:
        return getIfProcessExpr();
      case HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR:
        return getElseProcessExpr();
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
      case HelenaTextPackage.IF_THEN_ELSE__GUARD:
        setGuard((Guard)newValue);
        return;
      case HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR:
        setIfProcessExpr((ProcessExpression)newValue);
        return;
      case HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR:
        setElseProcessExpr((ProcessExpression)newValue);
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
      case HelenaTextPackage.IF_THEN_ELSE__GUARD:
        setGuard((Guard)null);
        return;
      case HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR:
        setIfProcessExpr((ProcessExpression)null);
        return;
      case HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR:
        setElseProcessExpr((ProcessExpression)null);
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
      case HelenaTextPackage.IF_THEN_ELSE__GUARD:
        return guard != null;
      case HelenaTextPackage.IF_THEN_ELSE__IF_PROCESS_EXPR:
        return ifProcessExpr != null;
      case HelenaTextPackage.IF_THEN_ELSE__ELSE_PROCESS_EXPR:
        return elseProcessExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //IfThenElseImpl
