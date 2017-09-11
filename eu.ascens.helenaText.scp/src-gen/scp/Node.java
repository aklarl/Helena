
package scp;

import eu.ascens.helena.dev.Component;
import java.util.logging.Logger;

public abstract class Node extends Component {

	protected Integer id;
	protected Integer reqs;
	protected Integer code;
	protected Boolean isExecuting;
	protected Node neighbor;

	public Node(Integer id, Integer reqs, Integer code, Boolean isExecuting, Node neighbor) {
		this.id = id;
		this.reqs = reqs;
		this.code = code;
		this.isExecuting = isExecuting;
		this.neighbor = neighbor;
	}

	public abstract Void printResultOperation() throws InstantiationException;

	public void setNeighbor(Node neighbor) {
		this.neighbor = neighbor;
	}
}
