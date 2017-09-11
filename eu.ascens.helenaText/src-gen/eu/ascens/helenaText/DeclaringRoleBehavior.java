/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaring Role Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.DeclaringRoleBehavior#getProcessExpr <em>Process Expr</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getDeclaringRoleBehavior()
 * @model
 * @generated
 */
public interface DeclaringRoleBehavior extends RoleBehavior
{
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
   * @see eu.ascens.helenaText.HelenaTextPackage#getDeclaringRoleBehavior_ProcessExpr()
   * @model containment="true"
   * @generated
   */
  ProcessExpression getProcessExpr();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.DeclaringRoleBehavior#getProcessExpr <em>Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process Expr</em>' containment reference.
   * @see #getProcessExpr()
   * @generated
   */
  void setProcessExpr(ProcessExpression value);

} // DeclaringRoleBehavior
