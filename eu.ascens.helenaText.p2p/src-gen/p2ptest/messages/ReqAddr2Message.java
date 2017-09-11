
package p2ptest.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import p2ptest.Requester2;

public class ReqAddr2Message extends Message {

	public ReqAddr2Message(Variable<Requester2> req) {
		super(Auxiliaries.getAsList(req), new ArrayList<Variable<Object>>());
	}
}
