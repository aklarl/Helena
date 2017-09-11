/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.PackageDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.PackageDeclarationImpl#getCompTypes <em>Comp Types</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.PackageDeclarationImpl#getRoleTypes <em>Role Types</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.PackageDeclarationImpl#getEnsStructs <em>Ens Structs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.PackageDeclarationImpl#getRoleBehaviors <em>Role Behaviors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageDeclarationImpl extends MinimalEObjectImpl.Container implements PackageDeclaration
{
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
   * The cached value of the '{@link #getCompTypes() <em>Comp Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCompTypes()
   * @generated
   * @ordered
   */
  protected EList<ComponentType> compTypes;

  /**
   * The cached value of the '{@link #getRoleTypes() <em>Role Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleTypes()
   * @generated
   * @ordered
   */
  protected EList<RoleType> roleTypes;

  /**
   * The cached value of the '{@link #getEnsStructs() <em>Ens Structs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnsStructs()
   * @generated
   * @ordered
   */
  protected EList<EnsembleStructure> ensStructs;

  /**
   * The cached value of the '{@link #getRoleBehaviors() <em>Role Behaviors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoleBehaviors()
   * @generated
   * @ordered
   */
  protected EList<RoleBehavior> roleBehaviors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PackageDeclarationImpl()
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
    return HelenaTextPackage.Literals.PACKAGE_DECLARATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.PACKAGE_DECLARATION__NAME, oldName, name));
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
      compTypes = new EObjectContainmentEList<ComponentType>(ComponentType.class, this, HelenaTextPackage.PACKAGE_DECLARATION__COMP_TYPES);
    }
    return compTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RoleType> getRoleTypes()
  {
    if (roleTypes == null)
    {
      roleTypes = new EObjectContainmentEList<RoleType>(RoleType.class, this, HelenaTextPackage.PACKAGE_DECLARATION__ROLE_TYPES);
    }
    return roleTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnsembleStructure> getEnsStructs()
  {
    if (ensStructs == null)
    {
      ensStructs = new EObjectContainmentEList<EnsembleStructure>(EnsembleStructure.class, this, HelenaTextPackage.PACKAGE_DECLARATION__ENS_STRUCTS);
    }
    return ensStructs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RoleBehavior> getRoleBehaviors()
  {
    if (roleBehaviors == null)
    {
      roleBehaviors = new EObjectContainmentEList<RoleBehavior>(RoleBehavior.class, this, HelenaTextPackage.PACKAGE_DECLARATION__ROLE_BEHAVIORS);
    }
    return roleBehaviors;
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
      case HelenaTextPackage.PACKAGE_DECLARATION__COMP_TYPES:
        return ((InternalEList<?>)getCompTypes()).basicRemove(otherEnd, msgs);
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_TYPES:
        return ((InternalEList<?>)getRoleTypes()).basicRemove(otherEnd, msgs);
      case HelenaTextPackage.PACKAGE_DECLARATION__ENS_STRUCTS:
        return ((InternalEList<?>)getEnsStructs()).basicRemove(otherEnd, msgs);
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_BEHAVIORS:
        return ((InternalEList<?>)getRoleBehaviors()).basicRemove(otherEnd, msgs);
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
      case HelenaTextPackage.PACKAGE_DECLARATION__NAME:
        return getName();
      case HelenaTextPackage.PACKAGE_DECLARATION__COMP_TYPES:
        return getCompTypes();
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_TYPES:
        return getRoleTypes();
      case HelenaTextPackage.PACKAGE_DECLARATION__ENS_STRUCTS:
        return getEnsStructs();
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_BEHAVIORS:
        return getRoleBehaviors();
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
      case HelenaTextPackage.PACKAGE_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__COMP_TYPES:
        getCompTypes().clear();
        getCompTypes().addAll((Collection<? extends ComponentType>)newValue);
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_TYPES:
        getRoleTypes().clear();
        getRoleTypes().addAll((Collection<? extends RoleType>)newValue);
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__ENS_STRUCTS:
        getEnsStructs().clear();
        getEnsStructs().addAll((Collection<? extends EnsembleStructure>)newValue);
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_BEHAVIORS:
        getRoleBehaviors().clear();
        getRoleBehaviors().addAll((Collection<? extends RoleBehavior>)newValue);
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
      case HelenaTextPackage.PACKAGE_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__COMP_TYPES:
        getCompTypes().clear();
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_TYPES:
        getRoleTypes().clear();
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__ENS_STRUCTS:
        getEnsStructs().clear();
        return;
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_BEHAVIORS:
        getRoleBehaviors().clear();
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
      case HelenaTextPackage.PACKAGE_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case HelenaTextPackage.PACKAGE_DECLARATION__COMP_TYPES:
        return compTypes != null && !compTypes.isEmpty();
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_TYPES:
        return roleTypes != null && !roleTypes.isEmpty();
      case HelenaTextPackage.PACKAGE_DECLARATION__ENS_STRUCTS:
        return ensStructs != null && !ensStructs.isEmpty();
      case HelenaTextPackage.PACKAGE_DECLARATION__ROLE_BEHAVIORS:
        return roleBehaviors != null && !roleBehaviors.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PackageDeclarationImpl
