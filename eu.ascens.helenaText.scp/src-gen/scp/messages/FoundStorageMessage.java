
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Storage;

public class FoundStorageMessage extends Message {

	public FoundStorageMessage(Variable<Storage> s) {
		super(Auxiliaries.getAsList(s), new ArrayList<Variable<Object>>());
	}
}
