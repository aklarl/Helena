
package p2p;

public class PeerImplementation extends Peer {
	public PeerImplementation(Boolean hasFile, Integer content, Peer neighbor) {
		super(hasFile, content, neighbor);
	}

	public PeerImplementation(Boolean hasFile, Integer content) {
		this(hasFile, content, null);
	}

	@Override
	public Void printFileOperation() throws InstantiationException {
		System.out.println("PRINT FILE");
		return null;
	}

}
