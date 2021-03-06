/**
 */
package eu.ascens.helenaText;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.ComponentAttributeType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getComponentAttributeType()
 * @model
 * @generated
 */
public interface ComponentAttributeType extends AbstractComponentFieldType
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(JvmTypeReference)
   * @see eu.ascens.helenaText.HelenaTextPackage#getComponentAttributeType_Type()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getType();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.ComponentAttributeType#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmTypeReference value);

} // ComponentAttributeType
