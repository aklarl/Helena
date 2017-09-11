/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.Process#getName <em>Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.Process#getProcessExpr <em>Process Expr</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends AbstractDuplicateFreeObject, AbstractRoleBehaviorEntity
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see eu.ascens.helenaText.HelenaTextPackage#getProcess_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.Process#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Process Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Process Expr</em>' containment reference.
   * @see #setProcessExpr(ProcessExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getProcess_ProcessExpr()
   * @model containment="true"
   * @generated
   */
  ProcessExpression getProcessExpr();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.Process#getProcessExpr <em>Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process Expr</em>' containment reference.
   * @see #getProcessExpr()
   * @generated
   */
  void setProcessExpr(ProcessExpression value);

} // Process
