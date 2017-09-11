
package p2ptest;

import eu.ascens.helena.dev.Component;
import java.util.logging.Logger;

public abstract class Peer extends Component {

	protected Integer name;
	protected Boolean hasFile;
	protected Integer content;
	protected Peer neighbor;
	protected Peer2 neighbor2;

	public Peer(Integer name, Boolean hasFile, Integer content, Peer neighbor, Peer2 neighbor2) {
		this.name = name;
		this.hasFile = hasFile;
		this.content = content;
		this.neighbor = neighbor;
		this.neighbor2 = neighbor2;
	}

	public abstract Void randomStepOperation() throws InstantiationException;
	public abstract Integer computeOperation(Integer input, Boolean input2) throws InstantiationException;

	public void setNeighbor(Peer neighbor) {
		this.neighbor = neighbor;
	}
	public void setNeighbor2(Peer2 neighbor2) {
		this.neighbor2 = neighbor2;
	}
}
