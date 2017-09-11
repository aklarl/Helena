/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ensemble Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.EnsembleStructureImpl#getRtWithMult <em>Rt With Mult</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnsembleStructureImpl extends AbstractHelenaEntityImpl implements EnsembleStructure
{
  /**
   * The cached value of the '{@link #getRtWithMult() <em>Rt With Mult</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRtWithMult()
   * @generated
   * @ordered
   */
  protected EList<RoleTypeWithMultiplicity> rtWithMult;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnsembleStructureImpl()
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
    return HelenaTextPackage.Literals.ENSEMBLE_STRUCTURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RoleTypeWithMultiplicity> getRtWithMult()
  {
    if (rtWithMult == null)
    {
      rtWithMult = new EObjectContainmentEList<RoleTypeWithMultiplicity>(RoleTypeWithMultiplicity.class, this, HelenaTextPackage.ENSEMBLE_STRUCTURE__RT_WITH_MULT);
    }
    return rtWithMult;
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
      case HelenaTextPackage.ENSEMBLE_STRUCTURE__RT_WITH_MULT:
        return ((InternalEList<?>)getRtWithMult()).basicRemove(otherEnd, msgs);
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
      case HelenaTextPackage.ENSEMBLE_STRUCTURE__RT_WITH_MULT:
        return getRtWithMult();
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
      case HelenaTextPackage.ENSEMBLE_STRUCTURE__RT_WITH_MULT:
        getRtWithMult().clear();
        getRtWithMult().addAll((Collection<? extends RoleTypeWithMultiplicity>)newValue);
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
      case HelenaTextPackage.ENSEMBLE_STRUCTURE__RT_WITH_MULT:
        getRtWithMult().clear();
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
      case HelenaTextPackage.ENSEMBLE_STRUCTURE__RT_WITH_MULT:
        return rtWithMult != null && !rtWithMult.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EnsembleStructureImpl
