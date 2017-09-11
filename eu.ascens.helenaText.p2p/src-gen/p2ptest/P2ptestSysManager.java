package p2ptest;

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

import p2ptest.messages.ReqAddr2Message;
import p2ptest.messages.ReqAddrMessage;
import p2ptest.messages.ReqFile2Message;
import p2ptest.messages.ReqFileMessage;
import p2ptest.messages.SndAddr2Message;
import p2ptest.messages.SndAddrMessage;
import p2ptest.messages.SndFile2Message;
import p2ptest.messages.SndFileMessage;
import p2ptest.operations.Compute2Operation;
import p2ptest.operations.ComputeOperation;
import p2ptest.operations.RandomStepOperation;

public abstract class P2ptestSysManager extends SysManager {

	@Override
	protected void configureTypes()
			throws ConfigurationFinishedException, TypeAlreadyExistsException, PropertyNotDeclaredInClassException {

		List<DataFieldType> dataparams_computeOperation = new ArrayList<>();
		dataparams_computeOperation.add(DataFieldType.createType("input", Integer.class));
		dataparams_computeOperation.add(DataFieldType.createType("input2", Boolean.class));

		ComponentType peerType = ComponentType.createType(Peer.class,

				Auxiliaries.getAsSet(DataFieldType.createType("name", Integer.class),
						DataFieldType.createType("hasFile", Boolean.class),
						DataFieldType.createType("content", Integer.class)),
				Auxiliaries.getAsSet(ComponentAssociationType.createType("neighbor", Peer.class),
						ComponentAssociationType.createType("neighbor2", Peer2.class)),

				Auxiliaries.getAsSet(
						OperationType.createType(RandomStepOperation.class, new ArrayList<DataFieldType>(), Void.class),
						OperationType.createType(ComputeOperation.class, dataparams_computeOperation, Integer.class)));
		this.addCompType(peerType);

		List<DataFieldType> dataparams_compute2Operation = new ArrayList<>();
		dataparams_compute2Operation.add(DataFieldType.createType("input", Integer.class));
		dataparams_compute2Operation.add(DataFieldType.createType("input2", Boolean.class));

		ComponentType peer2Type = ComponentType.createType(Peer2.class,

				new HashSet<DataFieldType>(),
				Auxiliaries.getAsSet(ComponentAssociationType.createType("gustav", Peer.class)),

				Auxiliaries.getAsSet(OperationType.createType(Compute2Operation.class, dataparams_compute2Operation,
						Integer.class)));
		this.addCompType(peer2Type);

		this.addEnsembleStructure(EnsembleStructure.createType(TransferEnsemble.class, getRoles()));
	}

	private static Map<RoleType, MultiplicityCapacityPair> getRoles()
			throws ConfigurationFinishedException, TypeAlreadyExistsException, PropertyNotDeclaredInClassException {
		Map<RoleType, MultiplicityCapacityPair> roles = new HashMap<>();

		MessageType sndAddrMsg = MessageType.createType(SndAddrMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("prov", Provider.class)),
				new ArrayList<DataFieldType>());
		MessageType reqFile2Msg = MessageType.createType(ReqFile2Message.class,
				Auxiliaries.getAsList(RoleFieldType.createType("req", Requester.class)),
				new ArrayList<DataFieldType>());
		MessageType reqAddrMsg = MessageType.createType(ReqAddrMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("req", Requester.class)),
				new ArrayList<DataFieldType>());
		MessageType sndFileMsg = MessageType.createType(SndFileMessage.class, new ArrayList<RoleFieldType>(),
				Auxiliaries.getAsList(DataFieldType.createType("cont", Integer.class)));
		MessageType sndAddr2Msg = MessageType.createType(SndAddr2Message.class,
				Auxiliaries.getAsList(RoleFieldType.createType("prov", Provider.class)),
				new ArrayList<DataFieldType>());
		MessageType reqAddr2Msg = MessageType.createType(ReqAddr2Message.class,
				Auxiliaries.getAsList(RoleFieldType.createType("req", Requester2.class)),
				new ArrayList<DataFieldType>());
		MessageType sndFile2Msg = MessageType.createType(SndFile2Message.class, new ArrayList<RoleFieldType>(),
				Auxiliaries.getAsList(DataFieldType.createType("cont", Integer.class)));
		MessageType reqFileMsg = MessageType.createType(ReqFileMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("req", Requester.class)),
				new ArrayList<DataFieldType>());

		// requester
		Set<ComponentType> requesterCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> requesterAttrTypes = new HashSet<>();
		requesterAttrTypes.add(DataFieldType.createType("fileName", Integer.class));

		Set<MessageType> requesterMsgsOut = Auxiliaries.getAsSet(reqAddrMsg, reqFileMsg);

		Set<MessageType> requesterMsgsIn = Auxiliaries.getAsSet(reqAddrMsg, sndAddrMsg, sndFileMsg);

		roles.put(RoleType.createType(Requester.class, requesterCompTypes, requesterAttrTypes, requesterMsgsOut,
				requesterMsgsIn), new MultiplicityCapacityPair(1, 2));
		// requester2
		Set<ComponentType> requester2CompTypes = Auxiliaries.getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> requester2AttrTypes = new HashSet<>();
		requester2AttrTypes.add(DataFieldType.createType("fileName", Integer.class));

		Set<MessageType> requester2MsgsOut = Auxiliaries.getAsSet(reqAddr2Msg, reqFile2Msg);

		Set<MessageType> requester2MsgsIn = Auxiliaries.getAsSet(reqAddr2Msg, sndAddr2Msg, sndFile2Msg);

		roles.put(RoleType.createType(Requester2.class, requester2CompTypes, requester2AttrTypes, requester2MsgsOut,
				requester2MsgsIn), new MultiplicityCapacityPair(1, 2));
		// router
		Set<ComponentType> routerCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> routerAttrTypes = new HashSet<>();

		Set<MessageType> routerMsgsOut = Auxiliaries.getAsSet(reqAddrMsg, sndAddrMsg);

		Set<MessageType> routerMsgsIn = Auxiliaries.getAsSet(reqAddrMsg);

		roles.put(RoleType.createType(Router.class, routerCompTypes, routerAttrTypes, routerMsgsOut, routerMsgsIn),
				new MultiplicityCapacityPair(Integer.MAX_VALUE, 2));
		// router2
		Set<ComponentType> router2CompTypes = Auxiliaries.getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> router2AttrTypes = new HashSet<>();

		Set<MessageType> router2MsgsOut = Auxiliaries.getAsSet(reqAddr2Msg, sndAddr2Msg);

		Set<MessageType> router2MsgsIn = Auxiliaries.getAsSet(reqAddr2Msg);

		roles.put(RoleType.createType(Router2.class, router2CompTypes, router2AttrTypes, router2MsgsOut, router2MsgsIn),
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
