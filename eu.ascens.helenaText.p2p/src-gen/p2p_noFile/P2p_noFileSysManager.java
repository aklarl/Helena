package p2p_noFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import eu.ascens.helena.SysManager;
import eu.ascens.helena.metadata.ComponentAssociationType;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.DataFieldType;
import eu.ascens.helena.metadata.EnsembleStructure;
import eu.ascens.helena.metadata.MessageType;
import eu.ascens.helena.metadata.MultiplicityCapacityPair;
import eu.ascens.helena.metadata.OperationType;
import eu.ascens.helena.metadata.RoleFieldType;
import eu.ascens.helena.metadata.RoleType;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;

import p2p_noFile.messages.NoFileMessage;
import p2p_noFile.messages.ReqAddrMessage;
import p2p_noFile.messages.ReqFileMessage;
import p2p_noFile.messages.SndAddrMessage;
import p2p_noFile.messages.SndFileMessage;
import p2p_noFile.messages.TaskDoneMessage;
import p2p_noFile.operations.PrintFileOperation;

public abstract class P2p_noFileSysManager extends SysManager {

	@Override
	protected void configureTypes()
			throws ConfigurationFinishedException, TypeAlreadyExistsException, PropertyNotDeclaredInClassException {

		ComponentType peerType = ComponentType.createType(Peer.class,

				Auxiliaries.getAsSet(DataFieldType.createType("hasFile", Boolean.class),
						DataFieldType.createType("content", Integer.class)),
				Auxiliaries.getAsSet(ComponentAssociationType.createType("neighbor", Peer.class)),

				Auxiliaries.getAsSet(OperationType.createType(PrintFileOperation.class, new ArrayList<DataFieldType>(),
						Void.class)));
		this.addCompType(peerType);

		this.addEnsembleStructure(EnsembleStructure.createType(TransferEnsemble.class, getRoles()));
	}

	private static Map<RoleType, MultiplicityCapacityPair> getRoles()
			throws ConfigurationFinishedException, TypeAlreadyExistsException, PropertyNotDeclaredInClassException {
		Map<RoleType, MultiplicityCapacityPair> roles = new HashMap<>();

		MessageType reqAddrMsg = MessageType.createType(ReqAddrMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("req", Requester.class)),
				new ArrayList<DataFieldType>());
		MessageType noFileMsg = MessageType.createType(NoFileMessage.class, new ArrayList<RoleFieldType>(),
				new ArrayList<DataFieldType>());
		MessageType taskDoneMsg = MessageType.createType(TaskDoneMessage.class, new ArrayList<RoleFieldType>(),
				new ArrayList<DataFieldType>());
		MessageType sndFileMsg = MessageType.createType(SndFileMessage.class, new ArrayList<RoleFieldType>(),
				Auxiliaries.getAsList(DataFieldType.createType("content", Integer.class)));
		MessageType reqFileMsg = MessageType.createType(ReqFileMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("req", Requester.class)),
				new ArrayList<DataFieldType>());
		MessageType sndAddrMsg = MessageType.createType(SndAddrMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("prov", Provider.class)),
				new ArrayList<DataFieldType>());

		// requester
		Set<ComponentType> requesterCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> requesterAttrTypes = new HashSet<>();
		requesterAttrTypes.add(DataFieldType.createType("hasFile", Boolean.class));

		Set<MessageType> requesterMsgsOut = Auxiliaries.getAsSet(reqAddrMsg, reqFileMsg, taskDoneMsg);

		Set<MessageType> requesterMsgsIn = Auxiliaries.getAsSet(sndAddrMsg, sndFileMsg, noFileMsg);

		roles.put(RoleType.createType(Requester.class, requesterCompTypes, requesterAttrTypes, requesterMsgsOut,
				requesterMsgsIn), new MultiplicityCapacityPair(1, 2));
		// router
		Set<ComponentType> routerCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> routerAttrTypes = new HashSet<>();

		Set<MessageType> routerMsgsOut = Auxiliaries.getAsSet(reqAddrMsg, sndAddrMsg, noFileMsg, taskDoneMsg);

		Set<MessageType> routerMsgsIn = Auxiliaries.getAsSet(reqAddrMsg, taskDoneMsg);

		roles.put(RoleType.createType(Router.class, routerCompTypes, routerAttrTypes, routerMsgsOut, routerMsgsIn),
				new MultiplicityCapacityPair(Integer.MAX_VALUE, 2));
		// provider
		Set<ComponentType> providerCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> providerAttrTypes = new HashSet<>();

		Set<MessageType> providerMsgsOut = Auxiliaries.getAsSet(sndFileMsg);

		Set<MessageType> providerMsgsIn = Auxiliaries.getAsSet(reqFileMsg);

		roles.put(RoleType.createType(Provider.class, providerCompTypes, providerAttrTypes, providerMsgsOut,
				providerMsgsIn), new MultiplicityCapacityPair(1, 1));
		return roles;
	}

}
