/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invoking Role Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.InvokingRoleBehavior#getProcessInvocation <em>Process Invocation</em>}</li>
 *   <li>{@link eu.ascens.helenaText.InvokingRoleBehavior#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getInvokingRoleBehavior()
 * @model
 * @generated
 */
public interface InvokingRoleBehavior extends RoleBehavior
{
  /**
   * Returns the value of the '<em><b>Process Invocation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Process Invocation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Process Invocation</em>' containment reference.
   * @see #setProcessInvocation(ProcessInvocation)
   * @see eu.ascens.helenaText.HelenaTextPackage#getInvokingRoleBehavior_ProcessInvocation()
   * @model containment="true"
   * @generated
   */
  ProcessInvocation getProcessInvocation();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.InvokingRoleBehavior#getProcessInvocation <em>Process Invocation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process Invocation</em>' containment reference.
   * @see #getProcessInvocation()
   * @generated
   */
  void setProcessInvocation(ProcessInvocation value);

  /**
   * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.Process}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Processes</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getInvokingRoleBehavior_Processes()
   * @model containment="true"
   * @generated
   */
  EList<eu.ascens.helenaText.Process> getProcesses();

} // InvokingRoleBehavior
