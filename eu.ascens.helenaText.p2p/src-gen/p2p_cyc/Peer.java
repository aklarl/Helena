
package p2p_cyc;

import eu.ascens.helena.dev.Component;
import java.util.logging.Logger;

public abstract class Peer extends Component {

	protected Boolean hasFile;
	protected Integer content;
	protected Peer neighbor;

	public Peer(Boolean hasFile, Integer content, Peer neighbor) {
		this.hasFile = hasFile;
		this.content = content;
		this.neighbor = neighbor;
	}

	public abstract Void printFileOperation() throws InstantiationException;

	public void setNeighbor(Peer neighbor) {
		this.neighbor = neighbor;
	}
}
