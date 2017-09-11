/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.IfThenElse#getGuard <em>Guard</em>}</li>
 *   <li>{@link eu.ascens.helenaText.IfThenElse#getIfProcessExpr <em>If Process Expr</em>}</li>
 *   <li>{@link eu.ascens.helenaText.IfThenElse#getElseProcessExpr <em>Else Process Expr</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getIfThenElse()
 * @model
 * @generated
 */
public interface IfThenElse extends ProcessExpression
{
  /**
   * Returns the value of the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard</em>' containment reference.
   * @see #setGuard(Guard)
   * @see eu.ascens.helenaText.HelenaTextPackage#getIfThenElse_Guard()
   * @model containment="true"
   * @generated
   */
  Guard getGuard();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.IfThenElse#getGuard <em>Guard</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard</em>' containment reference.
   * @see #getGuard()
   * @generated
   */
  void setGuard(Guard value);

  /**
   * Returns the value of the '<em><b>If Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Process Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Process Expr</em>' containment reference.
   * @see #setIfProcessExpr(ProcessExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getIfThenElse_IfProcessExpr()
   * @model containment="true"
   * @generated
   */
  ProcessExpression getIfProcessExpr();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.IfThenElse#getIfProcessExpr <em>If Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Process Expr</em>' containment reference.
   * @see #getIfProcessExpr()
   * @generated
   */
  void setIfProcessExpr(ProcessExpression value);

  /**
   * Returns the value of the '<em><b>Else Process Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Process Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Process Expr</em>' containment reference.
   * @see #setElseProcessExpr(ProcessExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getIfThenElse_ElseProcessExpr()
   * @model containment="true"
   * @generated
   */
  ProcessExpression getElseProcessExpr();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.IfThenElse#getElseProcessExpr <em>Else Process Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Process Expr</em>' containment reference.
   * @see #getElseProcessExpr()
   * @generated
   */
  void setElseProcessExpr(ProcessExpression value);

} // IfThenElse
