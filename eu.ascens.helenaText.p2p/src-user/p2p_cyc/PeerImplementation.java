
package p2p_cyc;

public class PeerImplementation extends Peer {
	public PeerImplementation(Boolean hasFile, Integer content, Peer neighbor) {
		super(hasFile, content, neighbor);
	}

	public PeerImplementation(Boolean hasFile, Integer content) {
		this(hasFile, content, null);
	}

	@Override
	public Void printFileOperation() throws InstantiationException {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");
	}

}
