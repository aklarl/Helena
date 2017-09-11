/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nondeterministic Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.NondeterministicChoice#getFirst <em>First</em>}</li>
 *   <li>{@link eu.ascens.helenaText.NondeterministicChoice#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getNondeterministicChoice()
 * @model
 * @generated
 */
public interface NondeterministicChoice extends ProcessExpression
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference.
   * @see #setFirst(ProcessExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getNondeterministicChoice_First()
   * @model containment="true"
   * @generated
   */
  ProcessExpression getFirst();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.NondeterministicChoice#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(ProcessExpression value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference.
   * @see #setSecond(ProcessExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getNondeterministicChoice_Second()
   * @model containment="true"
   * @generated
   */
  ProcessExpression getSecond();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.NondeterministicChoice#getSecond <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' containment reference.
   * @see #getSecond()
   * @generated
   */
  void setSecond(ProcessExpression value);

} // NondeterministicChoice
