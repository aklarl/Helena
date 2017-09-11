/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Role Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.FormalRoleParam#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getFormalRoleParam()
 * @model
 * @generated
 */
public interface FormalRoleParam extends AbstractRoleInstance
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
   * @see #setType(RoleType)
   * @see eu.ascens.helenaText.HelenaTextPackage#getFormalRoleParam_Type()
   * @model
   * @generated
   */
  RoleType getType();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.FormalRoleParam#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(RoleType value);

} // FormalRoleParam
