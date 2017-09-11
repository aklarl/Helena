/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.OperationCall#getVariable <em>Variable</em>}</li>
 *   <li>{@link eu.ascens.helenaText.OperationCall#getOpName <em>Op Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.OperationCall#getActualDataParamsBlock <em>Actual Data Params Block</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getOperationCall()
 * @model
 * @generated
 */
public interface OperationCall extends Action
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(DataVariable)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOperationCall_Variable()
   * @model containment="true"
   * @generated
   */
  DataVariable getVariable();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OperationCall#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(DataVariable value);

  /**
   * Returns the value of the '<em><b>Op Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op Name</em>' attribute.
   * @see #setOpName(String)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOperationCall_OpName()
   * @model
   * @generated
   */
  String getOpName();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OperationCall#getOpName <em>Op Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op Name</em>' attribute.
   * @see #getOpName()
   * @generated
   */
  void setOpName(String value);

  /**
   * Returns the value of the '<em><b>Actual Data Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual Data Params Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual Data Params Block</em>' containment reference.
   * @see #setActualDataParamsBlock(ActualDataParamsBlock)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOperationCall_ActualDataParamsBlock()
   * @model containment="true"
   * @generated
   */
  ActualDataParamsBlock getActualDataParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OperationCall#getActualDataParamsBlock <em>Actual Data Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual Data Params Block</em>' containment reference.
   * @see #getActualDataParamsBlock()
   * @generated
   */
  void setActualDataParamsBlock(ActualDataParamsBlock value);

} // OperationCall
