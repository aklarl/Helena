
package p2ptest.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import p2ptest.Requester;

public class ReqAddrMessage extends Message {

	public ReqAddrMessage(Variable<Requester> req) {
		super(Auxiliaries.getAsList(req), new ArrayList<Variable<Object>>());
	}
}
