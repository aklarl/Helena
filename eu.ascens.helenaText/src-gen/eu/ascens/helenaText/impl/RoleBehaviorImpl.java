/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.RoleBehaviorImpl#getRoleTypeRef <em>Role Type Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleBehaviorImpl extends AbstractDuplicateFreeObjectImpl implements RoleBehavior
{
  /**
   * The cached value of the '{@link #getRoleTypeRef() <em>Role Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleTypeRef()
   * @generated
   * @ordered
   */
  protected RoleType roleTypeRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RoleBehaviorImpl()
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
    return HelenaTextPackage.Literals.ROLE_BEHAVIOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleType getRoleTypeRef()
  {
    if (roleTypeRef != null && roleTypeRef.eIsProxy())
    {
      InternalEObject oldRoleTypeRef = (InternalEObject)roleTypeRef;
      roleTypeRef = (RoleType)eResolveProxy(oldRoleTypeRef);
      if (roleTypeRef != oldRoleTypeRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HelenaTextPackage.ROLE_BEHAVIOR__ROLE_TYPE_REF, oldRoleTypeRef, roleTypeRef));
      }
    }
    return roleTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleType basicGetRoleTypeRef()
  {
    return roleTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoleTypeRef(RoleType newRoleTypeRef)
  {
    RoleType oldRoleTypeRef = roleTypeRef;
    roleTypeRef = newRoleTypeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ROLE_BEHAVIOR__ROLE_TYPE_REF, oldRoleTypeRef, roleTypeRef));
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
      case HelenaTextPackage.ROLE_BEHAVIOR__ROLE_TYPE_REF:
        if (resolve) return getRoleTypeRef();
        return basicGetRoleTypeRef();
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
      case HelenaTextPackage.ROLE_BEHAVIOR__ROLE_TYPE_REF:
        setRoleTypeRef((RoleType)newValue);
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
      case HelenaTextPackage.ROLE_BEHAVIOR__ROLE_TYPE_REF:
        setRoleTypeRef((RoleType)null);
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
      case HelenaTextPackage.ROLE_BEHAVIOR__ROLE_TYPE_REF:
        return roleTypeRef != null;
    }
    return super.eIsSet(featureID);
  }

} //RoleBehaviorImpl
