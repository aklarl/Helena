/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Prefix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.ActionPrefix#getAction <em>Action</em>}</li>
 *   <li>{@link eu.ascens.helenaText.ActionPrefix#getProcessExpr <em>Process Expr</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getActionPrefix()
 * @model
 * @generated
 */
public interface ActionPrefix extends ProcessExpression
{
  /**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(Action)
   * @see eu.ascens.helenaText.HelenaTextPackage#getActionPrefix_Action()
   * @model containment="true"
   * @generated
   */
  Action getAction();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.ActionPrefix#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(Action value);

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
   * @see eu.ascens.helenaText.HelenaTextPackage#getActionPrefix_ProcessExpr()
   * @model containment="true"
   * @generated
   */
  ProcessExpression getProcessExpr();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.ActionPrefix#getProcessExpr <em>Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process Expr</em>' containment reference.
   * @see #getProcessExpr()
   * @generated
   */
  void setProcessExpr(ProcessExpression value);

} // ActionPrefix
