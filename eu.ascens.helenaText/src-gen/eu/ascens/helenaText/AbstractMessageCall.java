/**
 */
package eu.ascens.helenaText;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Message Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.AbstractMessageCall#getMsgName <em>Msg Name</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractMessageCall()
 * @model
 * @generated
 */
public interface AbstractMessageCall extends Action
{
  /**
   * Returns the value of the '<em><b>Msg Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Msg Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Msg Name</em>' attribute.
   * @see #setMsgName(String)
   * @see eu.ascens.helenaText.HelenaTextPackage#getAbstractMessageCall_MsgName()
   * @model
   * @generated
   */
  String getMsgName();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.AbstractMessageCall#getMsgName <em>Msg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Msg Name</em>' attribute.
   * @see #getMsgName()
   * @generated
   */
  void setMsgName(String value);

} // AbstractMessageCall
