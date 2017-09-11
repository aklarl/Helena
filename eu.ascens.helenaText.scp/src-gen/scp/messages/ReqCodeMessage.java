
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Executor;

public class ReqCodeMessage extends Message {

	public ReqCodeMessage(Variable<Executor> e) {
		super(Auxiliaries.getAsList(e), new ArrayList<Variable<Object>>());
	}
}
