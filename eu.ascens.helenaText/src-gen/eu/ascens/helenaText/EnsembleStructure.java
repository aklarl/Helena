/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ensemble Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.EnsembleStructure#getRtWithMult <em>Rt With Mult</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getEnsembleStructure()
 * @model
 * @generated
 */
public interface EnsembleStructure extends AbstractHelenaEntity
{
  /**
   * Returns the value of the '<em><b>Rt With Mult</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.RoleTypeWithMultiplicity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rt With Mult</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rt With Mult</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getEnsembleStructure_RtWithMult()
   * @model containment="true"
   * @generated
   */
  EList<RoleTypeWithMultiplicity> getRtWithMult();

} // EnsembleStructure
