
package p2ptest;

public class Peer2Implementation extends Peer2 {
	public Peer2Implementation(Peer gustav) {
		super(gustav);
	}

	public Peer2Implementation() {
		this(null);
	}

	@Override
	public Integer compute2Operation(Integer input, Boolean input2) throws InstantiationException {
		//TODO: This function has to be implemented by the user
		throw new UnsupportedOperationException("Method not implemented: User Input required");
	}

}
