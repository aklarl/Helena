
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;

public class StoreMessage extends Message {

	public StoreMessage(Variable<Integer> appID, Variable<Integer> appReqs, Variable<Integer> appCode) {
		super(new ArrayList<Variable<Role>>(), Auxiliaries.getAsList(appID, appReqs, appCode));
	}
}
