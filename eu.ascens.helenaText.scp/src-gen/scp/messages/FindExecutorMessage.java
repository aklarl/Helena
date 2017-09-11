
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Initiator;

public class FindExecutorMessage extends Message {

	public FindExecutorMessage(Variable<Initiator> i, Variable<Integer> appReqs) {
		super(Auxiliaries.getAsList(i), Auxiliaries.getAsList(appReqs));
	}
}
