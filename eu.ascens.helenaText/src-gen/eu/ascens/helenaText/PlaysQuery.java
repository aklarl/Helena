/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plays Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.PlaysQuery#getRoleTypeRef <em>Role Type Ref</em>}</li>
 *   <li>{@link eu.ascens.helenaText.PlaysQuery#getCompInstance <em>Comp Instance</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getPlaysQuery()
 * @model
 * @generated
 */
public interface PlaysQuery extends Atom
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
   * @see eu.ascens.helenaText.HelenaTextPackage#getPlaysQuery_RoleTypeRef()
   * @model
   * @generated
   */
  RoleType getRoleTypeRef();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.PlaysQuery#getRoleTypeRef <em>Role Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Type Ref</em>' reference.
   * @see #getRoleTypeRef()
   * @generated
   */
  void setRoleTypeRef(RoleType value);

  /**
   * Returns the value of the '<em><b>Comp Instance</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comp Instance</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comp Instance</em>' containment reference.
   * @see #setCompInstance(ComponentInstance)
   * @see eu.ascens.helenaText.HelenaTextPackage#getPlaysQuery_CompInstance()
   * @model containment="true"
   * @generated
   */
  ComponentInstance getCompInstance();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.PlaysQuery#getCompInstance <em>Comp Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comp Instance</em>' containment reference.
   * @see #getCompInstance()
   * @generated
   */
  void setCompInstance(ComponentInstance value);

} // PlaysQuery
