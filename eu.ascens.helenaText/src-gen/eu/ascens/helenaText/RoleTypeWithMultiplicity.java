/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Type With Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getRoleType <em>Role Type</em>}</li>
 *   <li>{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getMin <em>Min</em>}</li>
 *   <li>{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getMax <em>Max</em>}</li>
 *   <li>{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getCapacity <em>Capacity</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getRoleTypeWithMultiplicity()
 * @model
 * @generated
 */
public interface RoleTypeWithMultiplicity extends EObject
{
  /**
   * Returns the value of the '<em><b>Role Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Role Type</em>' reference.
   * @see #setRoleType(RoleType)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleTypeWithMultiplicity_RoleType()
   * @model
   * @generated
   */
  RoleType getRoleType();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getRoleType <em>Role Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role Type</em>' reference.
   * @see #getRoleType()
   * @generated
   */
  void setRoleType(RoleType value);

  /**
   * Returns the value of the '<em><b>Min</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min</em>' attribute.
   * @see #setMin(String)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleTypeWithMultiplicity_Min()
   * @model
   * @generated
   */
  String getMin();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getMin <em>Min</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min</em>' attribute.
   * @see #getMin()
   * @generated
   */
  void setMin(String value);

  /**
   * Returns the value of the '<em><b>Max</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max</em>' attribute.
   * @see #setMax(String)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleTypeWithMultiplicity_Max()
   * @model
   * @generated
   */
  String getMax();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getMax <em>Max</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max</em>' attribute.
   * @see #getMax()
   * @generated
   */
  void setMax(String value);

  /**
   * Returns the value of the '<em><b>Capacity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capacity</em>' attribute.
   * @see #setCapacity(int)
   * @see eu.ascens.helenaText.HelenaTextPackage#getRoleTypeWithMultiplicity_Capacity()
   * @model
   * @generated
   */
  int getCapacity();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.RoleTypeWithMultiplicity#getCapacity <em>Capacity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capacity</em>' attribute.
   * @see #getCapacity()
   * @generated
   */
  void setCapacity(int value);

} // RoleTypeWithMultiplicity
