/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.PackageDeclaration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.ModelImpl#getHeadPkg <em>Head Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getHeadPkg() <em>Head Pkg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeadPkg()
   * @generated
   * @ordered
   */
  protected PackageDeclaration headPkg;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return HelenaTextPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration getHeadPkg()
  {
    return headPkg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetHeadPkg(PackageDeclaration newHeadPkg, NotificationChain msgs)
  {
    PackageDeclaration oldHeadPkg = headPkg;
    headPkg = newHeadPkg;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MODEL__HEAD_PKG, oldHeadPkg, newHeadPkg);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHeadPkg(PackageDeclaration newHeadPkg)
  {
    if (newHeadPkg != headPkg)
    {
      NotificationChain msgs = null;
      if (headPkg != null)
        msgs = ((InternalEObject)headPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.MODEL__HEAD_PKG, null, msgs);
      if (newHeadPkg != null)
        msgs = ((InternalEObject)newHeadPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.MODEL__HEAD_PKG, null, msgs);
      msgs = basicSetHeadPkg(newHeadPkg, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.MODEL__HEAD_PKG, newHeadPkg, newHeadPkg));
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
      case HelenaTextPackage.MODEL__HEAD_PKG:
        return basicSetHeadPkg(null, msgs);
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
      case HelenaTextPackage.MODEL__HEAD_PKG:
        return getHeadPkg();
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
      case HelenaTextPackage.MODEL__HEAD_PKG:
        setHeadPkg((PackageDeclaration)newValue);
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
      case HelenaTextPackage.MODEL__HEAD_PKG:
        setHeadPkg((PackageDeclaration)null);
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
      case HelenaTextPackage.MODEL__HEAD_PKG:
        return headPkg != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
