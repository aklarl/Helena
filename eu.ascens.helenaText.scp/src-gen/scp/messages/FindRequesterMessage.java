
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Executor;

public class FindRequesterMessage extends Message {

	public FindRequesterMessage(Variable<Executor> e, Variable<Integer> startID) {
		super(Auxiliaries.getAsList(e), Auxiliaries.getAsList(startID));
	}
}
