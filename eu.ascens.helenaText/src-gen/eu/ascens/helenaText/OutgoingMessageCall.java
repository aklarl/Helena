/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outgoing Message Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.OutgoingMessageCall#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link eu.ascens.helenaText.OutgoingMessageCall#getActualRoleParamsBlock <em>Actual Role Params Block</em>}</li>
 *   <li>{@link eu.ascens.helenaText.OutgoingMessageCall#getActualDataParamsBlock <em>Actual Data Params Block</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getOutgoingMessageCall()
 * @model
 * @generated
 */
public interface OutgoingMessageCall extends AbstractMessageCall
{
  /**
   * Returns the value of the '<em><b>Receiver</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Receiver</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Receiver</em>' containment reference.
   * @see #setReceiver(AbstractRoleInstanceReference)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOutgoingMessageCall_Receiver()
   * @model containment="true"
   * @generated
   */
  AbstractRoleInstanceReference getReceiver();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OutgoingMessageCall#getReceiver <em>Receiver</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Receiver</em>' containment reference.
   * @see #getReceiver()
   * @generated
   */
  void setReceiver(AbstractRoleInstanceReference value);

  /**
   * Returns the value of the '<em><b>Actual Role Params Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual Role Params Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual Role Params Block</em>' containment reference.
   * @see #setActualRoleParamsBlock(ActualRoleParamsBlock)
   * @see eu.ascens.helenaText.HelenaTextPackage#getOutgoingMessageCall_ActualRoleParamsBlock()
   * @model containment="true"
   * @generated
   */
  ActualRoleParamsBlock getActualRoleParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OutgoingMessageCall#getActualRoleParamsBlock <em>Actual Role Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual Role Params Block</em>' containment reference.
   * @see #getActualRoleParamsBlock()
   * @generated
   */
  void setActualRoleParamsBlock(ActualRoleParamsBlock value);

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
   * @see eu.ascens.helenaText.HelenaTextPackage#getOutgoingMessageCall_ActualDataParamsBlock()
   * @model containment="true"
   * @generated
   */
  ActualDataParamsBlock getActualDataParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.OutgoingMessageCall#getActualDataParamsBlock <em>Actual Data Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual Data Params Block</em>' containment reference.
   * @see #getActualDataParamsBlock()
   * @generated
   */
  void setActualDataParamsBlock(ActualDataParamsBlock value);

} // OutgoingMessageCall
