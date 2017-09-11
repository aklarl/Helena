/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.RoleAttributeType;
import eu.ascens.helenaText.RoleType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.RoleTypeImpl#getCompTypes <em>Comp Types</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.RoleTypeImpl#getRoleattrs <em>Roleattrs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.RoleTypeImpl#getRolemsgs <em>Rolemsgs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleTypeImpl extends AbstractHelenaEntityImpl implements RoleType
{
  /**
   * The cached value of the '{@link #getCompTypes() <em>Comp Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompTypes()
   * @generated
   * @ordered
   */
  protected EList<ComponentType> compTypes;

  /**
   * The cached value of the '{@link #getRoleattrs() <em>Roleattrs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleattrs()
   * @generated
   * @ordered
   */
  protected EList<RoleAttributeType> roleattrs;

  /**
   * The cached value of the '{@link #getRolemsgs() <em>Rolemsgs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRolemsgs()
   * @generated
   * @ordered
   */
  protected EList<MessageType> rolemsgs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RoleTypeImpl()
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
    return HelenaTextPackage.Literals.ROLE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentType> getCompTypes()
  {
    if (compTypes == null)
    {
      compTypes = new EObjectResolvingEList<ComponentType>(ComponentType.class, this, HelenaTextPackage.ROLE_TYPE__COMP_TYPES);
    }
    return compTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RoleAttributeType> getRoleattrs()
  {
    if (roleattrs == null)
    {
      roleattrs = new EObjectContainmentEList<RoleAttributeType>(RoleAttributeType.class, this, HelenaTextPackage.ROLE_TYPE__ROLEATTRS);
    }
    return roleattrs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MessageType> getRolemsgs()
  {
    if (rolemsgs == null)
    {
      rolemsgs = new EObjectContainmentEList<MessageType>(MessageType.class, this, HelenaTextPackage.ROLE_TYPE__ROLEMSGS);
    }
    return rolemsgs;
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
      case HelenaTextPackage.ROLE_TYPE__ROLEATTRS:
        return ((InternalEList<?>)getRoleattrs()).basicRemove(otherEnd, msgs);
      case HelenaTextPackage.ROLE_TYPE__ROLEMSGS:
        return ((InternalEList<?>)getRolemsgs()).basicRemove(otherEnd, msgs);
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
      case HelenaTextPackage.ROLE_TYPE__COMP_TYPES:
        return getCompTypes();
      case HelenaTextPackage.ROLE_TYPE__ROLEATTRS:
        return getRoleattrs();
      case HelenaTextPackage.ROLE_TYPE__ROLEMSGS:
        return getRolemsgs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case HelenaTextPackage.ROLE_TYPE__COMP_TYPES:
        getCompTypes().clear();
        getCompTypes().addAll((Collection<? extends ComponentType>)newValue);
        return;
      case HelenaTextPackage.ROLE_TYPE__ROLEATTRS:
        getRoleattrs().clear();
        getRoleattrs().addAll((Collection<? extends RoleAttributeType>)newValue);
        return;
      case HelenaTextPackage.ROLE_TYPE__ROLEMSGS:
        getRolemsgs().clear();
        getRolemsgs().addAll((Collection<? extends MessageType>)newValue);
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
      case HelenaTextPackage.ROLE_TYPE__COMP_TYPES:
        getCompTypes().clear();
        return;
      case HelenaTextPackage.ROLE_TYPE__ROLEATTRS:
        getRoleattrs().clear();
        return;
      case HelenaTextPackage.ROLE_TYPE__ROLEMSGS:
        getRolemsgs().clear();
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
      case HelenaTextPackage.ROLE_TYPE__COMP_TYPES:
        return compTypes != null && !compTypes.isEmpty();
      case HelenaTextPackage.ROLE_TYPE__ROLEATTRS:
        return roleattrs != null && !roleattrs.isEmpty();
      case HelenaTextPackage.ROLE_TYPE__ROLEMSGS:
        return rolemsgs != null && !rolemsgs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RoleTypeImpl
