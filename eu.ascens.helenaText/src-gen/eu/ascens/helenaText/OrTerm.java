/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.OrTerm#getLeft <em>Left</em>}</li>
 *   <li>{@link eu.ascens.helenaText.OrTerm#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getOrTerm()
 * @model
 * @generated
 */
public interface OrTerm extends Guard
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Guard)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOrTerm_Left()
   * @model containment="true"
   * @generated
   */
  Guard getLeft();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OrTerm#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Guard value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Guard)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOrTerm_Right()
   * @model containment="true"
   * @generated
   */
  Guard getRight();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OrTerm#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Guard value);

} // OrTerm
