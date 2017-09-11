/**
 */
package eu.ascens.helenaText;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.OperationType#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link eu.ascens.helenaText.OperationType#getName <em>Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.OperationType#getFormalDataParamsBlock <em>Formal Data Params Block</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getOperationType()
 * @model
 * @generated
 */
public interface OperationType extends AbstractDuplicateFreeObject
{
  /**
   * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' containment reference.
   * @see #setReturnType(JvmTypeReference)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOperationType_ReturnType()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getReturnType();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OperationType#getReturnType <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' containment reference.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(JvmTypeReference value);

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
   * @see eu.ascens.helenaText.HelenaTextPackage#getOperationType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OperationType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Formal Data Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Data Params Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Data Params Block</em>' containment reference.
   * @see #setFormalDataParamsBlock(FormalDataParamsBlock)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOperationType_FormalDataParamsBlock()
   * @model containment="true"
   * @generated
   */
  FormalDataParamsBlock getFormalDataParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OperationType#getFormalDataParamsBlock <em>Formal Data Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Data Params Block</em>' containment reference.
   * @see #getFormalDataParamsBlock()
   * @generated
   */
  void setFormalDataParamsBlock(FormalDataParamsBlock value);

} // OperationType
