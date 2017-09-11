/**
 */
package eu.ascens.helenaText;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.ascens.helenaText.Model#getHeadPkg <em>Head Pkg</em>}</li>
 * </ul>
 *
 * @see eu.ascens.helenaText.HelenaTextPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Head Pkg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Head Pkg</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Head Pkg</em>' containment reference.
   * @see #setHeadPkg(PackageDeclaration)
   * @see eu.ascens.helenaText.HelenaTextPackage#getModel_HeadPkg()
   * @model containment="true"
   * @generated
   */
  PackageDeclaration getHeadPkg();

  /**
   * Sets the value of the '{@link eu.ascens.helenaText.Model#getHeadPkg <em>Head Pkg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Head Pkg</em>' containment reference.
   * @see #getHeadPkg()
   * @generated
   */
  void setHeadPkg(PackageDeclaration value);

} // Model
