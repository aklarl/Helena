/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.ComponentAssociationType;
import eu.ascens.helenaText.ComponentAttributeType;
import eu.ascens.helenaText.ComponentType;
import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.OperationType;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.ComponentTypeImpl#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.ComponentTypeImpl#getAssocs <em>Assocs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.ComponentTypeImpl#getOps <em>Ops</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentTypeImpl extends AbstractHelenaEntityImpl implements ComponentType
{
  /**
   * The cached value of the '{@link #getAttrs() <em>Attrs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttrs()
   * @generated
   * @ordered
   */
  protected EList<ComponentAttributeType> attrs;

  /**
   * The cached value of the '{@link #getAssocs() <em>Assocs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssocs()
   * @generated
   * @ordered
   */
  protected EList<ComponentAssociationType> assocs;

  /**
   * The cached value of the '{@link #getOps() <em>Ops</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOps()
   * @generated
   * @ordered
   */
  protected EList<OperationType> ops;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentTypeImpl()
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
    return HelenaTextPackage.Literals.COMPONENT_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentAttributeType> getAttrs()
  {
    if (attrs == null)
    {
      attrs = new EObjectContainmentEList<ComponentAttributeType>(ComponentAttributeType.class, this, HelenaTextPackage.COMPONENT_TYPE__ATTRS);
    }
    return attrs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ComponentAssociationType> getAssocs()
  {
    if (assocs == null)
    {
      assocs = new EObjectContainmentEList<ComponentAssociationType>(ComponentAssociationType.class, this, HelenaTextPackage.COMPONENT_TYPE__ASSOCS);
    }
    return assocs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OperationType> getOps()
  {
    if (ops == null)
    {
      ops = new EObjectContainmentEList<OperationType>(OperationType.class, this, HelenaTextPackage.COMPONENT_TYPE__OPS);
    }
    return ops;
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
      case HelenaTextPackage.COMPONENT_TYPE__ATTRS:
        return ((InternalEList<?>)getAttrs()).basicRemove(otherEnd, msgs);
      case HelenaTextPackage.COMPONENT_TYPE__ASSOCS:
        return ((InternalEList<?>)getAssocs()).basicRemove(otherEnd, msgs);
      case HelenaTextPackage.COMPONENT_TYPE__OPS:
        return ((InternalEList<?>)getOps()).basicRemove(otherEnd, msgs);
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
      case HelenaTextPackage.COMPONENT_TYPE__ATTRS:
        return getAttrs();
      case HelenaTextPackage.COMPONENT_TYPE__ASSOCS:
        return getAssocs();
      case HelenaTextPackage.COMPONENT_TYPE__OPS:
        return getOps();
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
      case HelenaTextPackage.COMPONENT_TYPE__ATTRS:
        getAttrs().clear();
        getAttrs().addAll((Collection<? extends ComponentAttributeType>)newValue);
        return;
      case HelenaTextPackage.COMPONENT_TYPE__ASSOCS:
        getAssocs().clear();
        getAssocs().addAll((Collection<? extends ComponentAssociationType>)newValue);
        return;
      case HelenaTextPackage.COMPONENT_TYPE__OPS:
        getOps().clear();
        getOps().addAll((Collection<? extends OperationType>)newValue);
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
      case HelenaTextPackage.COMPONENT_TYPE__ATTRS:
        getAttrs().clear();
        return;
      case HelenaTextPackage.COMPONENT_TYPE__ASSOCS:
        getAssocs().clear();
        return;
      case HelenaTextPackage.COMPONENT_TYPE__OPS:
        getOps().clear();
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
      case HelenaTextPackage.COMPONENT_TYPE__ATTRS:
        return attrs != null && !attrs.isEmpty();
      case HelenaTextPackage.COMPONENT_TYPE__ASSOCS:
        return assocs != null && !assocs.isEmpty();
      case HelenaTextPackage.COMPONENT_TYPE__OPS:
        return ops != null && !ops.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ComponentTypeImpl
