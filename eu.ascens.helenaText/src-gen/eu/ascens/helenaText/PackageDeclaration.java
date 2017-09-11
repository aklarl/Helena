/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.PackageDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.PackageDeclaration#getCompTypes <em>Comp Types</em>}</li>
 *   <li>{@link eu.ascens.helenaText.PackageDeclaration#getRoleTypes <em>Role Types</em>}</li>
 *   <li>{@link eu.ascens.helenaText.PackageDeclaration#getEnsStructs <em>Ens Structs</em>}</li>
 *   <li>{@link eu.ascens.helenaText.PackageDeclaration#getRoleBehaviors <em>Role Behaviors</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getPackageDeclaration()
 * @model
 * @generated
 */
public interface PackageDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see eu.ascens.helenaText.HelenaTextPackage#getPackageDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.PackageDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Comp Types</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.ComponentType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comp Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comp Types</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getPackageDeclaration_CompTypes()
   * @model containment="true"
   * @generated
   */
  EList<ComponentType> getCompTypes();

  /**
   * Returns the value of the '<em><b>Role Types</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.RoleType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Types</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getPackageDeclaration_RoleTypes()
   * @model containment="true"
   * @generated
   */
  EList<RoleType> getRoleTypes();

  /**
   * Returns the value of the '<em><b>Ens Structs</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.EnsembleStructure}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ens Structs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ens Structs</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getPackageDeclaration_EnsStructs()
   * @model containment="true"
   * @generated
   */
  EList<EnsembleStructure> getEnsStructs();

  /**
   * Returns the value of the '<em><b>Role Behaviors</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.RoleBehavior}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Behaviors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Behaviors</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getPackageDeclaration_RoleBehaviors()
   * @model containment="true"
   * @generated
   */
  EList<RoleBehavior> getRoleBehaviors();

} // PackageDeclaration
