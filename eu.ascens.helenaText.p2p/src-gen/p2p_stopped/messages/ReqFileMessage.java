
package p2p_stopped.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import p2p_stopped.Requester;

public class ReqFileMessage extends Message {

	public ReqFileMessage(Variable<Requester> req) {
		super(Auxiliaries.getAsList(req), new ArrayList<Variable<Object>>());
	}
}
