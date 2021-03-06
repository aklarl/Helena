/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.Relation#getLeft <em>Left</em>}</li>
 *   <li>{@link eu.ascens.helenaText.Relation#getOperator <em>Operator</em>}</li>
 *   <li>{@link eu.ascens.helenaText.Relation#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends Atom
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
   * @see #setLeft(DataExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRelation_Left()
   * @model containment="true"
   * @generated
   */
  DataExpression getLeft();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.Relation#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(DataExpression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see #setOperator(String)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRelation_Operator()
   * @model
   * @generated
   */
  String getOperator();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.Relation#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see #getOperator()
   * @generated
   */
  void setOperator(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(DataExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRelation_Right()
   * @model containment="true"
   * @generated
   */
  DataExpression getRight();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.Relation#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(DataExpression value);

} // Relation
