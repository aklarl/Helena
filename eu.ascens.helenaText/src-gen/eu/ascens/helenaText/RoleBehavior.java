/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.RoleBehavior#getRoleTypeRef <em>Role Type Ref</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getRoleBehavior()
 * @model
 * @generated
 */
public interface RoleBehavior extends AbstractDuplicateFreeObject
{
  /**
   * Returns the value of the '<em><b>Role Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Type Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Type Ref</em>' reference.
   * @see #setRoleTypeRef(RoleType)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleBehavior_RoleTypeRef()
   * @model
   * @generated
   */
  RoleType getRoleTypeRef();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.RoleBehavior#getRoleTypeRef <em>Role Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Type Ref</em>' reference.
   * @see #getRoleTypeRef()
   * @generated
   */
  void setRoleTypeRef(RoleType value);

} // RoleBehavior
