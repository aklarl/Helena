/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Association Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.ComponentAssociationType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getComponentAssociationType()
 * @model
 * @generated
 */
public interface ComponentAssociationType extends AbstractComponentFieldType
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(ComponentType)
   * @see eu.ascens.helenaText.HelenaTextPackage#getComponentAssociationType_Type()
   * @model
   * @generated
   */
  ComponentType getType();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.ComponentAssociationType#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(ComponentType value);

} // ComponentAssociationType
