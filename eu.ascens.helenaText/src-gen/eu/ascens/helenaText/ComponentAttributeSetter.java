/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Attribute Setter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.ComponentAttributeSetter#getAttr <em>Attr</em>}</li>
 *   <li>{@link eu.ascens.helenaText.ComponentAttributeSetter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getComponentAttributeSetter()
 * @model
 * @generated
 */
public interface ComponentAttributeSetter extends Action
{
  /**
   * Returns the value of the '<em><b>Attr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attr</em>' containment reference.
   * @see #setAttr(ComponentAttributeTypeReference)
   * @see eu.ascens.helenaText.HelenaTextPackage#getComponentAttributeSetter_Attr()
   * @model containment="true"
   * @generated
   */
  ComponentAttributeTypeReference getAttr();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.ComponentAttributeSetter#getAttr <em>Attr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attr</em>' containment reference.
   * @see #getAttr()
   * @generated
   */
  void setAttr(ComponentAttributeTypeReference value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(DataExpression)
   * @see eu.ascens.helenaText.HelenaTextPackage#getComponentAttributeSetter_Value()
   * @model containment="true"
   * @generated
   */
  DataExpression getValue();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.ComponentAttributeSetter#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(DataExpression value);

} // ComponentAttributeSetter
