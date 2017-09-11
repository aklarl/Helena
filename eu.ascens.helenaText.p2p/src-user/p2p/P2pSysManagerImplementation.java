package p2p;

import eu.ascens.helena.SysManager;
import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;

public class P2pSysManagerImplementation extends P2pSysManager {
	public P2pSysManagerImplementation() {
		super();
	}

	public static void main(String[] args) {
		SysManager sys = new P2pSysManagerImplementation();
		sys.start();
	}

	protected void createComponents() {
		Peer peer1 = new PeerImplementation(false, 0);
		Peer peer2 = new PeerImplementation(false, 0);
		Peer peer3 = new PeerImplementation(false, 0);
		Peer peer4 = new PeerImplementation(true, 12345);
		Peer peer5 = new PeerImplementation(false, 0);

		peer1.setNeighbor(peer2);
		peer2.setNeighbor(peer3);
		peer3.setNeighbor(peer4);
		peer4.setNeighbor(peer5);
		peer5.setNeighbor(peer1);

		this.addComponent(peer1);
		this.addComponent(peer2);
		this.addComponent(peer3);
		this.addComponent(peer4);
		this.addComponent(peer5);
	}

	protected void startEnsembles()
			throws RoleTypeNotAllowedForEnsembleException, RoleTypeNotAllowedForComponentTypeException,
			ComponentNotInEnsembleException, ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
			ReflectionException, PropertyNotDeclaredInClassException {
		Ensemble ens1 = new TransferEnsembleImplementation("ens1", this.getComponents());
		this.addEnsemble(ens1);
		ens1.startEnsemble(this.getComponent());
	}
}
