/*
* generated by Xtext
*/
package eu.ascens;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class HelenaTextStandaloneSetup extends HelenaTextStandaloneSetupGenerated{

	public static void doSetup() {
		new HelenaTextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

