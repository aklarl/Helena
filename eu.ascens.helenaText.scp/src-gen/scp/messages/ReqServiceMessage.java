
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Requester;

public class ReqServiceMessage extends Message {

	public ReqServiceMessage(Variable<Requester> r) {
		super(Auxiliaries.getAsList(r), new ArrayList<Variable<Object>>());
	}
}
