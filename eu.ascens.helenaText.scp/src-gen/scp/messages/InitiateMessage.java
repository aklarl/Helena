
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Storage;

public class InitiateMessage extends Message {

	public InitiateMessage(Variable<Storage> s, Variable<Integer> appID, Variable<Integer> appReqs) {
		super(Auxiliaries.getAsList(s), Auxiliaries.getAsList(appID, appReqs));
	}
}
