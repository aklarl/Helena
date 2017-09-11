/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Data Params Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.ActualDataParamsBlock#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getActualDataParamsBlock()
 * @model
 * @generated
 */
public interface ActualDataParamsBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link eu.ascens.helenaText.DataExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see eu.ascens.helenaText.HelenaTextPackage#getActualDataParamsBlock_Params()
   * @model containment="true"
   * @generated
   */
  EList<DataExpression> getParams();

} // ActualDataParamsBlock
