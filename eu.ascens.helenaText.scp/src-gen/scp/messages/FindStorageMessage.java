
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Deployer;

public class FindStorageMessage extends Message {

	public FindStorageMessage(Variable<Deployer> d, Variable<Integer> appID, Variable<Integer> foundID) {
		super(Auxiliaries.getAsList(d), Auxiliaries.getAsList(appID, foundID));
	}
}
