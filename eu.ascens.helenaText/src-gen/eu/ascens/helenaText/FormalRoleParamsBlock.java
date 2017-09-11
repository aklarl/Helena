/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Role Params Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.FormalRoleParamsBlock#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getFormalRoleParamsBlock()
 * @model
 * @generated
 */
public interface FormalRoleParamsBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.FormalRoleParam}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getFormalRoleParamsBlock_Params()
   * @model containment="true"
   * @generated
   */
  EList<FormalRoleParam> getParams();

} // FormalRoleParamsBlock
