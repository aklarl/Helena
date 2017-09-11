
package p2ptest;

import eu.ascens.helena.dev.Component;
import java.util.logging.Logger;

public abstract class Peer2 extends Component {

	protected Peer gustav;

	public Peer2(Peer gustav) {
		this.gustav = gustav;
	}

	public abstract Integer compute2Operation(Integer input, Boolean input2) throws InstantiationException;

	public void setGustav(Peer gustav) {
		this.gustav = gustav;
	}
}
