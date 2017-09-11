
package p2ptest.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;

public class SndFileMessage extends Message {

	public SndFileMessage(Variable<Integer> cont) {
		super(new ArrayList<Variable<Role>>(), Auxiliaries.getAsList(cont));
	}
}
