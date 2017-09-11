/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.RoleType#getCompTypes <em>Comp Types</em>}</li>
 *   <li>{@link eu.ascens.helenaText.RoleType#getRoleattrs <em>Roleattrs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.RoleType#getRolemsgs <em>Rolemsgs</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getRoleType()
 * @model
 * @generated
 */
public interface RoleType extends AbstractHelenaEntity
{
  /**
   * Returns the value of the '<em><b>Comp Types</b></em>' reference list.
   * The list contents are of type {@link eu.ascens.helenaText.ComponentType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comp Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comp Types</em>' reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleType_CompTypes()
   * @model
   * @generated
   */
  EList<ComponentType> getCompTypes();

  /**
   * Returns the value of the '<em><b>Roleattrs</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.RoleAttributeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Roleattrs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Roleattrs</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleType_Roleattrs()
   * @model containment="true"
   * @generated
   */
  EList<RoleAttributeType> getRoleattrs();

  /**
   * Returns the value of the '<em><b>Rolemsgs</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.MessageType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rolemsgs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rolemsgs</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleType_Rolemsgs()
   * @model containment="true"
   * @generated
   */
  EList<MessageType> getRolemsgs();

} // RoleType
