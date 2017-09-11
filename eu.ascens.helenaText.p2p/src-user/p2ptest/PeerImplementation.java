
package p2ptest;

public class PeerImplementation extends Peer {
	public PeerImplementation(Integer name, Boolean hasFile, Integer content, Peer neighbor, Peer2 neighbor2) {
		super(name, hasFile, content, neighbor, neighbor2);
	}

	public PeerImplementation(Integer name, Boolean hasFile, Integer content) {
		this(name, hasFile, content, null, null);
	}

	@Override
	public Void randomStepOperation() throws InstantiationException {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");
	}
	@Override
	public Integer computeOperation(Integer input, Boolean input2) throws InstantiationException {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");
	}

}
