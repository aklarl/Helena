/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.ComponentInstance;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.RoleInstanceVariable;
import eu.ascens.helenaText.RoleType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.AbstractAssignmentImpl#getRoleInst <em>Role Inst</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.AbstractAssignmentImpl#getRoleTypeRef <em>Role Type Ref</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.AbstractAssignmentImpl#getCompInstance <em>Comp Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractAssignmentImpl extends ActionImpl implements AbstractAssignment
{
  /**
   * The cached value of the '{@link #getRoleInst() <em>Role Inst</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleInst()
   * @generated
   * @ordered
   */
  protected RoleInstanceVariable roleInst;

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
   * The cached value of the '{@link #getCompInstance() <em>Comp Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompInstance()
   * @generated
   * @ordered
   */
  protected ComponentInstance compInstance;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractAssignmentImpl()
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
    return HelenaTextPackage.Literals.ABSTRACT_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleInstanceVariable getRoleInst()
  {
    return roleInst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRoleInst(RoleInstanceVariable newRoleInst, NotificationChain msgs)
  {
    RoleInstanceVariable oldRoleInst = roleInst;
    roleInst = newRoleInst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST, oldRoleInst, newRoleInst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoleInst(RoleInstanceVariable newRoleInst)
  {
    if (newRoleInst != roleInst)
    {
      NotificationChain msgs = null;
      if (roleInst != null)
        msgs = ((InternalEObject)roleInst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST, null, msgs);
      if (newRoleInst != null)
        msgs = ((InternalEObject)newRoleInst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST, null, msgs);
      msgs = basicSetRoleInst(newRoleInst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST, newRoleInst, newRoleInst));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF, oldRoleTypeRef, roleTypeRef));
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
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF, oldRoleTypeRef, roleTypeRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentInstance getCompInstance()
  {
    return compInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCompInstance(ComponentInstance newCompInstance, NotificationChain msgs)
  {
    ComponentInstance oldCompInstance = compInstance;
    compInstance = newCompInstance;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE, oldCompInstance, newCompInstance);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCompInstance(ComponentInstance newCompInstance)
  {
    if (newCompInstance != compInstance)
    {
      NotificationChain msgs = null;
      if (compInstance != null)
        msgs = ((InternalEObject)compInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE, null, msgs);
      if (newCompInstance != null)
        msgs = ((InternalEObject)newCompInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE, null, msgs);
      msgs = basicSetCompInstance(newCompInstance, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE, newCompInstance, newCompInstance));
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
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST:
        return basicSetRoleInst(null, msgs);
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE:
        return basicSetCompInstance(null, msgs);
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
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST:
        return getRoleInst();
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF:
        if (resolve) return getRoleTypeRef();
        return basicGetRoleTypeRef();
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE:
        return getCompInstance();
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
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST:
        setRoleInst((RoleInstanceVariable)newValue);
        return;
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF:
        setRoleTypeRef((RoleType)newValue);
        return;
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE:
        setCompInstance((ComponentInstance)newValue);
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
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST:
        setRoleInst((RoleInstanceVariable)null);
        return;
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF:
        setRoleTypeRef((RoleType)null);
        return;
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE:
        setCompInstance((ComponentInstance)null);
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
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_INST:
        return roleInst != null;
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__ROLE_TYPE_REF:
        return roleTypeRef != null;
      case HelenaTextPackage.ABSTRACT_ASSIGNMENT__COMP_INSTANCE:
        return compInstance != null;
    }
    return super.eIsSet(featureID);
  }

} //AbstractAssignmentImpl
