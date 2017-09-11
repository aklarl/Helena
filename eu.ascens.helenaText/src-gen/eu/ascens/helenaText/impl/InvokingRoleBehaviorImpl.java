/**
 */
package eu.ascens.helenaText.impl;

import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.InvokingRoleBehavior;
import eu.ascens.helenaText.ProcessInvocation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoking Role Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.impl.InvokingRoleBehaviorImpl#getProcessInvocation <em>Process Invocation</em>}</li>
 *   <li>{@link eu.ascens.helenaText.impl.InvokingRoleBehaviorImpl#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvokingRoleBehaviorImpl extends RoleBehaviorImpl implements InvokingRoleBehavior
{
  /**
   * The cached value of the '{@link #getProcessInvocation() <em>Process Invocation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessInvocation()
   * @generated
   * @ordered
   */
  protected ProcessInvocation processInvocation;

  /**
   * The cached value of the '{@link #getProcesses() <em>Processes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcesses()
   * @generated
   * @ordered
   */
  protected EList<eu.ascens.helenaText.Process> processes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvokingRoleBehaviorImpl()
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
    return HelenaTextPackage.Literals.INVOKING_ROLE_BEHAVIOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessInvocation getProcessInvocation()
  {
    return processInvocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProcessInvocation(ProcessInvocation newProcessInvocation, NotificationChain msgs)
  {
    ProcessInvocation oldProcessInvocation = processInvocation;
    processInvocation = newProcessInvocation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION, oldProcessInvocation, newProcessInvocation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProcessInvocation(ProcessInvocation newProcessInvocation)
  {
    if (newProcessInvocation != processInvocation)
    {
      NotificationChain msgs = null;
      if (processInvocation != null)
        msgs = ((InternalEObject)processInvocation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION, null, msgs);
      if (newProcessInvocation != null)
        msgs = ((InternalEObject)newProcessInvocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION, null, msgs);
      msgs = basicSetProcessInvocation(newProcessInvocation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION, newProcessInvocation, newProcessInvocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<eu.ascens.helenaText.Process> getProcesses()
  {
    if (processes == null)
    {
      processes = new EObjectContainmentEList<eu.ascens.helenaText.Process>(eu.ascens.helenaText.Process.class, this, HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESSES);
    }
    return processes;
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
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION:
        return basicSetProcessInvocation(null, msgs);
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESSES:
        return ((InternalEList<?>)getProcesses()).basicRemove(otherEnd, msgs);
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
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION:
        return getProcessInvocation();
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESSES:
        return getProcesses();
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
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION:
        setProcessInvocation((ProcessInvocation)newValue);
        return;
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESSES:
        getProcesses().clear();
        getProcesses().addAll((Collection<? extends eu.ascens.helenaText.Process>)newValue);
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
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION:
        setProcessInvocation((ProcessInvocation)null);
        return;
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESSES:
        getProcesses().clear();
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
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESS_INVOCATION:
        return processInvocation != null;
      case HelenaTextPackage.INVOKING_ROLE_BEHAVIOR__PROCESSES:
        return processes != null && !processes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InvokingRoleBehaviorImpl
