/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.AbstractAssignment#getRoleInst <em>Role Inst</em>}</li>
 *   <li>{@link eu.ascens.helenaText.AbstractAssignment#getRoleTypeRef <em>Role Type Ref</em>}</li>
 *   <li>{@link eu.ascens.helenaText.AbstractAssignment#getCompInstance <em>Comp Instance</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractAssignment()
 * @model
 * @generated
 */
public interface AbstractAssignment extends Action
{
  /**
   * Returns the value of the '<em><b>Role Inst</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Inst</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Inst</em>' containment reference.
   * @see #setRoleInst(RoleInstanceVariable)
   * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractAssignment_RoleInst()
   * @model containment="true"
   * @generated
   */
  RoleInstanceVariable getRoleInst();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.AbstractAssignment#getRoleInst <em>Role Inst</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Inst</em>' containment reference.
   * @see #getRoleInst()
   * @generated
   */
  void setRoleInst(RoleInstanceVariable value);

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
   * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractAssignment_RoleTypeRef()
   * @model
   * @generated
   */
  RoleType getRoleTypeRef();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.AbstractAssignment#getRoleTypeRef <em>Role Type Ref</em>}' reference.
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
   * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractAssignment_CompInstance()
   * @model containment="true"
   * @generated
   */
  ComponentInstance getCompInstance();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.AbstractAssignment#getCompInstance <em>Comp Instance</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comp Instance</em>' containment reference.
   * @see #getCompInstance()
   * @generated
   */
  void setCompInstance(ComponentInstance value);

} // AbstractAssignment
