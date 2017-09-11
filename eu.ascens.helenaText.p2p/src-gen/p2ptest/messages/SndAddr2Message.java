
package p2ptest.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import p2ptest.Provider;

public class SndAddr2Message extends Message {

	public SndAddr2Message(Variable<Provider> prov) {
		super(Auxiliaries.getAsList(prov), new ArrayList<Variable<Object>>());
	}
}
