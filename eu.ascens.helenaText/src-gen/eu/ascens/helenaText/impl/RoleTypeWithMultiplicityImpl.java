/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Type With Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl#getRoleType <em>Role Type</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl#getMin <em>Min</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl#getMax <em>Max</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.RoleTypeWithMultiplicityImpl#getCapacity <em>Capacity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleTypeWithMultiplicityImpl extends MinimalEObjectImpl.Container implements RoleTypeWithMultiplicity
{
  /**
   * The cached value of the '{@link #getRoleType() <em>Role Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleType()
   * @generated
   * @ordered
   */
  protected RoleType roleType;

  /**
   * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMin()
   * @generated
   * @ordered
   */
  protected static final String MIN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMin()
   * @generated
   * @ordered
   */
  protected String min = MIN_EDEFAULT;

  /**
   * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMax()
   * @generated
   * @ordered
   */
  protected static final String MAX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMax()
   * @generated
   * @ordered
   */
  protected String max = MAX_EDEFAULT;

  /**
   * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapacity()
   * @generated
   * @ordered
   */
  protected static final int CAPACITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCapacity()
   * @generated
   * @ordered
   */
  protected int capacity = CAPACITY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RoleTypeWithMultiplicityImpl()
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
    return HelenaTextPackage.Literals.ROLE_TYPE_WITH_MULTIPLICITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleType getRoleType()
  {
    if (roleType != null && roleType.eIsProxy())
    {
      InternalEObject oldRoleType = (InternalEObject)roleType;
      roleType = (RoleType)eResolveProxy(oldRoleType);
      if (roleType != oldRoleType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE, oldRoleType, roleType));
      }
    }
    return roleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoleType basicGetRoleType()
  {
    return roleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRoleType(RoleType newRoleType)
  {
    RoleType oldRoleType = roleType;
    roleType = newRoleType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE, oldRoleType, roleType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMin()
  {
    return min;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMin(String newMin)
  {
    String oldMin = min;
    min = newMin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MIN, oldMin, min));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMax()
  {
    return max;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMax(String newMax)
  {
    String oldMax = max;
    max = newMax;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MAX, oldMax, max));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getCapacity()
  {
    return capacity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCapacity(int newCapacity)
  {
    int oldCapacity = capacity;
    capacity = newCapacity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY, oldCapacity, capacity));
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
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE:
        if (resolve) return getRoleType();
        return basicGetRoleType();
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MIN:
        return getMin();
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MAX:
        return getMax();
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY:
        return getCapacity();
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
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE:
        setRoleType((RoleType)newValue);
        return;
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MIN:
        setMin((String)newValue);
        return;
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MAX:
        setMax((String)newValue);
        return;
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY:
        setCapacity((Integer)newValue);
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
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE:
        setRoleType((RoleType)null);
        return;
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MIN:
        setMin(MIN_EDEFAULT);
        return;
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MAX:
        setMax(MAX_EDEFAULT);
        return;
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY:
        setCapacity(CAPACITY_EDEFAULT);
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
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__ROLE_TYPE:
        return roleType != null;
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MIN:
        return MIN_EDEFAULT == null ? min != null : !MIN_EDEFAULT.equals(min);
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__MAX:
        return MAX_EDEFAULT == null ? max != null : !MAX_EDEFAULT.equals(max);
      case HelenaTextPackage.ROLE_TYPE_WITH_MULTIPLICITY__CAPACITY:
        return capacity != CAPACITY_EDEFAULT;
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
    result.append(" (min: ");
    result.append(min);
    result.append(", max: ");
    result.append(max);
    result.append(", capacity: ");
    result.append(capacity);
    result.append(')');
    return result.toString();
  }

} //RoleTypeWithMultiplicityImpl
