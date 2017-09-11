/*
 *  jHelena is a Java library for the execution of ensemble specification
 *  according to the Helena approach. It is fully documented in the PhD 
 *  thesis "Helena - Handling massively distributed systems with ELaborate 
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 
 *  Website: http://www.pst.ifi.lmu.de/Personen/team/klarl/helena.html
 *  PhD thesis: https://edoc.ub.uni-muenchen.de/20087/
 *
 *  Copyright (C) 2013-2017  Annabelle Klarl
 *  All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 */
package eu.ascens.helena.p2p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import eu.ascens.helena.SysManager;
import eu.ascens.helena.dev.Auxiliaries;
import eu.ascens.helena.dev.Ensemble;
import eu.ascens.helena.dev.exceptions.ComponentAlreadyAdoptsRoleException;
import eu.ascens.helena.dev.exceptions.ComponentNotInEnsembleException;
import eu.ascens.helena.dev.exceptions.ConfigurationFinishedException;
import eu.ascens.helena.dev.exceptions.PropertyNotDeclaredInClassException;
import eu.ascens.helena.dev.exceptions.ReflectionException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForComponentTypeException;
import eu.ascens.helena.dev.exceptions.RoleTypeNotAllowedForEnsembleException;
import eu.ascens.helena.dev.exceptions.TooManyRoleInstancesException;
import eu.ascens.helena.dev.exceptions.TypeAlreadyExistsException;
import eu.ascens.helena.metadata.ComponentAssociationType;
import eu.ascens.helena.metadata.ComponentType;
import eu.ascens.helena.metadata.DataFieldType;
import eu.ascens.helena.metadata.EnsembleStructure;
import eu.ascens.helena.metadata.MessageType;
import eu.ascens.helena.metadata.MultiplicityCapacityPair;
import eu.ascens.helena.metadata.OperationType;
import eu.ascens.helena.metadata.RoleFieldType;
import eu.ascens.helena.metadata.RoleType;
import eu.ascens.helena.p2p.messages.PrintFileOperation;
import eu.ascens.helena.p2p.messages.ReqAddrMessage;
import eu.ascens.helena.p2p.messages.ReqFileMessage;
import eu.ascens.helena.p2p.messages.SndAddrMessage;
import eu.ascens.helena.p2p.messages.SndFileMessage;

public class P2PSysManager extends SysManager {

	@Override
	protected void configureTypes() throws ConfigurationFinishedException,
	        TypeAlreadyExistsException, PropertyNotDeclaredInClassException {
		ComponentType peerType = ComponentType.createType(Peer.class,
		        Auxiliaries.getAsSet(
		                DataFieldType.createType("name", String.class),
		                DataFieldType.createType("hasFile", Boolean.class),
		                DataFieldType.createType("content", Integer.class)),
		        Auxiliaries.getAsSet(ComponentAssociationType
		                .createType("neighbor", Peer.class)),
		        Auxiliaries.getAsSet(
		                OperationType.createType(PrintFileOperation.class,
		                        new ArrayList<DataFieldType>(), Void.class)));
		this.addCompType(peerType);

		this.addEnsembleStructure(EnsembleStructure
		        .createType(TransferEnsemble.class, getRoles()));
	}

	private static Map<RoleType, MultiplicityCapacityPair> getRoles()
	        throws ConfigurationFinishedException, TypeAlreadyExistsException,
	        PropertyNotDeclaredInClassException {
		Map<RoleType, MultiplicityCapacityPair> roles = new HashMap<>();

		// messages
		MessageType reqAddrMsg = MessageType.createType(ReqAddrMessage.class,
		        Auxiliaries.getAsList(
		                RoleFieldType.createType("requester", Requester.class)),
		        new ArrayList<DataFieldType>());
		MessageType sndAddrMsg = MessageType.createType(SndAddrMessage.class,
		        Auxiliaries.getAsList(
		                RoleFieldType.createType("address", Provider.class)),
		        new ArrayList<DataFieldType>());
		MessageType reqFileMsg = MessageType.createType(ReqFileMessage.class,
		        Auxiliaries.getAsList(
		                RoleFieldType.createType("requester", Requester.class)),
		        new ArrayList<DataFieldType>());
		MessageType sndFileMsg = MessageType.createType(SndFileMessage.class,
		        new ArrayList<RoleFieldType>(), Auxiliaries.getAsList(
		                DataFieldType.createType("content", Integer.class)));

		// requester
		Set<ComponentType> reqCompTypes = Auxiliaries
		        .getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> reqAttrTypes = new HashSet<>();
		reqAttrTypes.add(DataFieldType.createType("hasFile", Boolean.class));

		Set<MessageType> reqMsgsOut = Auxiliaries.getAsSet(reqAddrMsg,
		        reqFileMsg);

		Set<MessageType> reqMsgsIn = Auxiliaries.getAsSet(sndAddrMsg,
		        sndFileMsg);

		roles.put(
		        RoleType.createType(Requester.class, reqCompTypes, reqAttrTypes,
		                reqMsgsOut, reqMsgsIn),
		        new MultiplicityCapacityPair(1, 2));

		// router
		Set<ComponentType> routCompTypes = Auxiliaries
		        .getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> routAttrTypes = new HashSet<>();

		Set<MessageType> routMsgsOut = Auxiliaries.getAsSet(reqAddrMsg,
		        sndAddrMsg);

		Set<MessageType> routMsgsIn = Auxiliaries.getAsSet(reqAddrMsg);

		roles.put(
		        RoleType.createType(Router.class, routCompTypes, routAttrTypes,
		                routMsgsOut, routMsgsIn),
		        new MultiplicityCapacityPair(Integer.MAX_VALUE, 2));

		// provider
		Set<ComponentType> provCompTypes = Auxiliaries
		        .getAsSet(ComponentType.getType(Peer.class));

		Set<DataFieldType> provAttrTypes = new HashSet<>();

		Set<MessageType> provMsgsOut = Auxiliaries.getAsSet(sndFileMsg);

		Set<MessageType> provMsgsIn = Auxiliaries.getAsSet(reqFileMsg);

		roles.put(
		        RoleType.createType(Provider.class, provCompTypes,
		                provAttrTypes, provMsgsOut, provMsgsIn),
		        new MultiplicityCapacityPair(1, 1));

		return roles;
	}

	@Override
	protected void createComponents() {
		Peer peer1 = new Peer("p1", false, 0);
		Peer peer2 = new Peer("p2", false, 0);
		Peer peer3 = new Peer("p3", false, 0);
		Peer peer4 = new Peer("p4", true, 12345);
		Peer peer5 = new Peer("p5", false, 0);

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

	@Override
	protected void startEnsembles()
	        throws RoleTypeNotAllowedForEnsembleException,
	        RoleTypeNotAllowedForComponentTypeException,
	        ComponentNotInEnsembleException,
	        ComponentAlreadyAdoptsRoleException, TooManyRoleInstancesException,
	        ReflectionException, PropertyNotDeclaredInClassException {
		Ensemble ens1 = new TransferEnsemble("ens1", this.getComponents());
		this.addEnsemble(ens1);
		ens1.startEnsemble(this.getComponent());
	}

	public static void main(String[] args) {
		SysManager sys = new P2PSysManager();
		sys.start();
	}
}
