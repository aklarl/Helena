/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Incoming Message Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.IncomingMessageCall#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}</li>
 *   <li>{@link eu.ascens.helenaText.IncomingMessageCall#getFormalDataParamsBlock <em>Formal Data Params Block</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getIncomingMessageCall()
 * @model
 * @generated
 */
public interface IncomingMessageCall extends AbstractMessageCall
{
  /**
   * Returns the value of the '<em><b>Formal Role Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Role Params Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Role Params Block</em>' containment reference.
   * @see #setFormalRoleParamsBlock(FormalRoleParamsBlock)
   * @see eu.ascens.helenaText.HelenaTextPackage#getIncomingMessageCall_FormalRoleParamsBlock()
   * @model containment="true"
   * @generated
   */
  FormalRoleParamsBlock getFormalRoleParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.IncomingMessageCall#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Role Params Block</em>' containment reference.
   * @see #getFormalRoleParamsBlock()
   * @generated
   */
  void setFormalRoleParamsBlock(FormalRoleParamsBlock value);

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
   * @see eu.ascens.helenaText.HelenaTextPackage#getIncomingMessageCall_FormalDataParamsBlock()
   * @model containment="true"
   * @generated
   */
  FormalDataParamsBlock getFormalDataParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.IncomingMessageCall#getFormalDataParamsBlock <em>Formal Data Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Data Params Block</em>' containment reference.
   * @see #getFormalDataParamsBlock()
   * @generated
   */
  void setFormalDataParamsBlock(FormalDataParamsBlock value);

} // IncomingMessageCall
