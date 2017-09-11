/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.MessageType#getDirection <em>Direction</em>}</li>
 *   <li>{@link eu.ascens.helenaText.MessageType#getName <em>Name</em>}</li>
 *   <li>{@link eu.ascens.helenaText.MessageType#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}</li>
 *   <li>{@link eu.ascens.helenaText.MessageType#getFormalDataParamsBlock <em>Formal Data Params Block</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getMessageType()
 * @model
 * @generated
 */
public interface MessageType extends AbstractDuplicateFreeObject
{
  /**
   * Returns the value of the '<em><b>Direction</b></em>' attribute.
   * The literals are from the enumeration {@link eu.ascens.helenaText.MsgDirection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direction</em>' attribute.
   * @see eu.ascens.helenaText.MsgDirection
   * @see #setDirection(MsgDirection)
   * @see eu.ascens.helenaText.HelenaTextPackage#getMessageType_Direction()
   * @model
   * @generated
   */
  MsgDirection getDirection();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.MessageType#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see eu.ascens.helenaText.MsgDirection
   * @see #getDirection()
   * @generated
   */
  void setDirection(MsgDirection value);

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
   * @see eu.ascens.helenaText.HelenaTextPackage#getMessageType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.MessageType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see eu.ascens.helenaText.HelenaTextPackage#getMessageType_FormalRoleParamsBlock()
   * @model containment="true"
   * @generated
   */
  FormalRoleParamsBlock getFormalRoleParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.MessageType#getFormalRoleParamsBlock <em>Formal Role Params Block</em>}' containment reference.
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
   * @see eu.ascens.helenaText.HelenaTextPackage#getMessageType_FormalDataParamsBlock()
   * @model containment="true"
   * @generated
   */
  FormalDataParamsBlock getFormalDataParamsBlock();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.MessageType#getFormalDataParamsBlock <em>Formal Data Params Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Data Params Block</em>' containment reference.
   * @see #getFormalDataParamsBlock()
   * @generated
   */
  void setFormalDataParamsBlock(FormalDataParamsBlock value);

} // MessageType
