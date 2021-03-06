
package scp.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;
import scp.Deployer;

public class CreateStorageMessage extends Message {

	public CreateStorageMessage(Variable<Deployer> d, Variable<Integer> foundID, Variable<Integer> startID) {
		super(Auxiliaries.getAsList(d), Auxiliaries.getAsList(foundID, startID));
	}
}
