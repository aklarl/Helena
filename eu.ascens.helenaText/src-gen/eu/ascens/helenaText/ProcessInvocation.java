/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.ProcessInvocation#getProcess <em>Process</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getProcessInvocation()
 * @model
 * @generated
 */
public interface ProcessInvocation extends ProcessExpression
{
  /**
   * Returns the value of the '<em><b>Process</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Process</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Process</em>' reference.
   * @see #setProcess(eu.ascens.helenaText.Process)
   * @see eu.ascens.helenaText.HelenaTextPackage#getProcessInvocation_Process()
   * @model
   * @generated
   */
  eu.ascens.helenaText.Process getProcess();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.ProcessInvocation#getProcess <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process</em>' reference.
   * @see #getProcess()
   * @generated
   */
  void setProcess(eu.ascens.helenaText.Process value);

} // ProcessInvocation
