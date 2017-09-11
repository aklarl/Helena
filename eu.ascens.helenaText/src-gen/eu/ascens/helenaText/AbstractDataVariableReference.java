/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Data Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.AbstractDataVariableReference#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractDataVariableReference()
 * @model
 * @generated
 */
public interface AbstractDataVariableReference extends AbstractDataReference
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(AbstractDataVariable)
   * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractDataVariableReference_Ref()
   * @model
   * @generated
   */
  AbstractDataVariable getRef();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.AbstractDataVariableReference#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(AbstractDataVariable value);

} // AbstractDataVariableReference
