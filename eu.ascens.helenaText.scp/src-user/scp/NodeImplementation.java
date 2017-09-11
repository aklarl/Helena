
package scp;

public class NodeImplementation extends Node {
	public NodeImplementation(Integer id, Integer reqs, Integer code, Boolean isExecuting, Node neighbor) {
		super(id, reqs, code, isExecuting, neighbor);
	}

	public NodeImplementation(Integer id, Integer reqs, Integer code, Boolean isExecuting) {
		this(id, reqs, code, isExecuting, null);
	}

	@Override
	public Void printResultOperation() throws InstantiationException {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");
	}

}
