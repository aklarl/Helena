
package p2p_stopped.messages;

import java.util.ArrayList;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Message;
import eu.ascens.helena.dev.Role;
import eu.ascens.helena.dev.Variable;

public class TaskDoneMessage extends Message {

	public TaskDoneMessage() {
		super(new ArrayList<Variable<Role>>(), new ArrayList<Variable<Object>>());
	}
}
