/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.ComponentType#getAttrs <em>Attrs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.ComponentType#getAssocs <em>Assocs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.ComponentType#getOps <em>Ops</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getComponentType()
 * @model
 * @generated
 */
public interface ComponentType extends AbstractHelenaEntity
{
  /**
   * Returns the value of the '<em><b>Attrs</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.ComponentAttributeType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attrs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attrs</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getComponentType_Attrs()
   * @model containment="true"
   * @generated
   */
  EList<ComponentAttributeType> getAttrs();

  /**
   * Returns the value of the '<em><b>Assocs</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.ComponentAssociationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assocs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assocs</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getComponentType_Assocs()
   * @model containment="true"
   * @generated
   */
  EList<ComponentAssociationType> getAssocs();

  /**
   * Returns the value of the '<em><b>Ops</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.OperationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ops</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ops</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getComponentType_Ops()
   * @model containment="true"
   * @generated
   */
  EList<OperationType> getOps();

} // ComponentType
