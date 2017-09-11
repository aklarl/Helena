package scp;

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

import scp.messages.AckInformationMessage;
import scp.messages.CreateStorageMessage;
import scp.messages.ExecuteMessage;
import scp.messages.ExecutingMessage;
import scp.messages.FindExecutorMessage;
import scp.messages.FindRequesterMessage;
import scp.messages.FindStorageMessage;
import scp.messages.FoundExecutorMessage;
import scp.messages.FoundStorageMessage;
import scp.messages.InformMessage;
import scp.messages.InitiateMessage;
import scp.messages.ReqCodeMessage;
import scp.messages.ReqServiceMessage;
import scp.messages.SndCodeMessage;
import scp.messages.SndServiceMessage;
import scp.messages.StoreMessage;
import scp.operations.PrintResultOperation;

public abstract class ScpSysManager extends SysManager {

	@Override
	protected void configureTypes()
			throws ConfigurationFinishedException, TypeAlreadyExistsException, PropertyNotDeclaredInClassException {

		ComponentType nodeType = ComponentType.createType(Node.class,

				Auxiliaries.getAsSet(DataFieldType.createType("id", Integer.class),
						DataFieldType.createType("reqs", Integer.class),
						DataFieldType.createType("code", Integer.class),
						DataFieldType.createType("isExecuting", Boolean.class)),
				Auxiliaries.getAsSet(ComponentAssociationType.createType("neighbor", Node.class)),

				Auxiliaries.getAsSet(OperationType.createType(PrintResultOperation.class,
						new ArrayList<DataFieldType>(), Void.class)));
		this.addCompType(nodeType);

		this.addEnsembleStructure(EnsembleStructure.createType(ScienceCloudPlatform.class, getRoles()));
	}

	private static Map<RoleType, MultiplicityCapacityPair> getRoles()
			throws ConfigurationFinishedException, TypeAlreadyExistsException, PropertyNotDeclaredInClassException {
		Map<RoleType, MultiplicityCapacityPair> roles = new HashMap<>();

		MessageType reqCodeMsg = MessageType.createType(ReqCodeMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("e", Executor.class)), new ArrayList<DataFieldType>());
		MessageType reqServiceMsg = MessageType.createType(ReqServiceMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("r", Requester.class)), new ArrayList<DataFieldType>());
		MessageType storeMsg = MessageType.createType(StoreMessage.class, new ArrayList<RoleFieldType>(),
				Auxiliaries.getAsList(DataFieldType.createType("appID", Integer.class),
						DataFieldType.createType("appReqs", Integer.class),
						DataFieldType.createType("appCode", Integer.class)));
		MessageType createStorageMsg = MessageType.createType(CreateStorageMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("d", Deployer.class)),
				Auxiliaries.getAsList(DataFieldType.createType("foundID", Integer.class),
						DataFieldType.createType("startID", Integer.class)));
		MessageType initiateMsg = MessageType.createType(InitiateMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("s", Storage.class)),
				Auxiliaries.getAsList(DataFieldType.createType("appID", Integer.class),
						DataFieldType.createType("appReqs", Integer.class)));
		MessageType findStorageMsg = MessageType.createType(FindStorageMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("d", Deployer.class)),
				Auxiliaries.getAsList(DataFieldType.createType("appID", Integer.class),
						DataFieldType.createType("foundID", Integer.class)));
		MessageType executingMsg = MessageType.createType(ExecutingMessage.class, new ArrayList<RoleFieldType>(),
				new ArrayList<DataFieldType>());
		MessageType sndServiceMsg = MessageType.createType(SndServiceMessage.class, new ArrayList<RoleFieldType>(),
				new ArrayList<DataFieldType>());
		MessageType ackInformationMsg = MessageType.createType(AckInformationMessage.class,
				new ArrayList<RoleFieldType>(), new ArrayList<DataFieldType>());
		MessageType foundExecutorMsg = MessageType.createType(FoundExecutorMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("e", Executor.class)), new ArrayList<DataFieldType>());
		MessageType findRequesterMsg = MessageType.createType(FindRequesterMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("e", Executor.class)),
				Auxiliaries.getAsList(DataFieldType.createType("startID", Integer.class)));
		MessageType informMsg = MessageType.createType(InformMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("e", Executor.class),
						RoleFieldType.createType("pr", PotRequester.class)),
				new ArrayList<DataFieldType>());
		MessageType sndCodeMsg = MessageType.createType(SndCodeMessage.class, new ArrayList<RoleFieldType>(),
				Auxiliaries.getAsList(DataFieldType.createType("appCode", Integer.class)));
		MessageType executeMsg = MessageType.createType(ExecuteMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("i", Initiator.class),
						RoleFieldType.createType("s", Storage.class)),
				Auxiliaries.getAsList(DataFieldType.createType("appID", Integer.class)));
		MessageType findExecutorMsg = MessageType.createType(FindExecutorMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("i", Initiator.class)),
				Auxiliaries.getAsList(DataFieldType.createType("appReqs", Integer.class)));
		MessageType foundStorageMsg = MessageType.createType(FoundStorageMessage.class,
				Auxiliaries.getAsList(RoleFieldType.createType("s", Storage.class)), new ArrayList<DataFieldType>());

		// deployer
		Set<ComponentType> deployerCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> deployerAttrTypes = new HashSet<>();
		deployerAttrTypes.add(DataFieldType.createType("appID", Integer.class));
		deployerAttrTypes.add(DataFieldType.createType("appReqs", Integer.class));
		deployerAttrTypes.add(DataFieldType.createType("appCode", Integer.class));

		Set<MessageType> deployerMsgsOut = Auxiliaries.getAsSet(findStorageMsg, storeMsg);

		Set<MessageType> deployerMsgsIn = Auxiliaries.getAsSet(foundStorageMsg);

		roles.put(RoleType.createType(Deployer.class, deployerCompTypes, deployerAttrTypes, deployerMsgsOut,
				deployerMsgsIn), new MultiplicityCapacityPair(1, 1));
		// potStorage
		Set<ComponentType> potStorageCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> potStorageAttrTypes = new HashSet<>();

		Set<MessageType> potStorageMsgsOut = Auxiliaries.getAsSet(findStorageMsg, createStorageMsg, foundStorageMsg);

		Set<MessageType> potStorageMsgsIn = Auxiliaries.getAsSet(findStorageMsg, createStorageMsg);

		roles.put(RoleType.createType(PotStorage.class, potStorageCompTypes, potStorageAttrTypes, potStorageMsgsOut,
				potStorageMsgsIn), new MultiplicityCapacityPair(Integer.MAX_VALUE, 2));
		// storage
		Set<ComponentType> storageCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> storageAttrTypes = new HashSet<>();

		Set<MessageType> storageMsgsOut = Auxiliaries.getAsSet(initiateMsg, sndCodeMsg);

		Set<MessageType> storageMsgsIn = Auxiliaries.getAsSet(storeMsg, reqCodeMsg);

		roles.put(RoleType.createType(Storage.class, storageCompTypes, storageAttrTypes, storageMsgsOut, storageMsgsIn),
				new MultiplicityCapacityPair(1, 2));
		// initiator
		Set<ComponentType> initiatorCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> initiatorAttrTypes = new HashSet<>();

		Set<MessageType> initiatorMsgsOut = Auxiliaries.getAsSet(findExecutorMsg, executeMsg, findRequesterMsg);

		Set<MessageType> initiatorMsgsIn = Auxiliaries.getAsSet(initiateMsg, foundExecutorMsg, executingMsg);

		roles.put(RoleType.createType(Initiator.class, initiatorCompTypes, initiatorAttrTypes, initiatorMsgsOut,
				initiatorMsgsIn), new MultiplicityCapacityPair(1, 2));
		// potExecutor
		Set<ComponentType> potExecutorCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> potExecutorAttrTypes = new HashSet<>();

		Set<MessageType> potExecutorMsgsOut = Auxiliaries.getAsSet(findExecutorMsg, foundExecutorMsg);

		Set<MessageType> potExecutorMsgsIn = Auxiliaries.getAsSet(findExecutorMsg);

		roles.put(RoleType.createType(PotExecutor.class, potExecutorCompTypes, potExecutorAttrTypes, potExecutorMsgsOut,
				potExecutorMsgsIn), new MultiplicityCapacityPair(Integer.MAX_VALUE, 2));
		// executor
		Set<ComponentType> executorCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> executorAttrTypes = new HashSet<>();

		Set<MessageType> executorMsgsOut = Auxiliaries.getAsSet(reqCodeMsg, executingMsg, sndServiceMsg);

		Set<MessageType> executorMsgsIn = Auxiliaries.getAsSet(executeMsg, sndCodeMsg, reqServiceMsg);

		roles.put(RoleType.createType(Executor.class, executorCompTypes, executorAttrTypes, executorMsgsOut,
				executorMsgsIn), new MultiplicityCapacityPair(1, 2));
		// potRequester
		Set<ComponentType> potRequesterCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> potRequesterAttrTypes = new HashSet<>();

		Set<MessageType> potRequesterMsgsOut = Auxiliaries.getAsSet(findRequesterMsg, informMsg);

		Set<MessageType> potRequesterMsgsIn = Auxiliaries.getAsSet(findRequesterMsg, ackInformationMsg);

		roles.put(RoleType.createType(PotRequester.class, potRequesterCompTypes, potRequesterAttrTypes,
				potRequesterMsgsOut, potRequesterMsgsIn), new MultiplicityCapacityPair(Integer.MAX_VALUE, 2));
		// requester
		Set<ComponentType> requesterCompTypes = Auxiliaries.getAsSet(ComponentType.getType(Node.class));

		Set<DataFieldType> requesterAttrTypes = new HashSet<>();
		requesterAttrTypes.add(DataFieldType.createType("hasResult", Boolean.class));

		Set<MessageType> requesterMsgsOut = Auxiliaries.getAsSet(ackInformationMsg, reqServiceMsg);

		Set<MessageType> requesterMsgsIn = Auxiliaries.getAsSet(informMsg, sndServiceMsg);

		roles.put(RoleType.createType(Requester.class, requesterCompTypes, requesterAttrTypes, requesterMsgsOut,
				requesterMsgsIn), new MultiplicityCapacityPair(Integer.MAX_VALUE, 2));
		return roles;
	}

}
