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
package eu.ascens.helena.dev;

import java.util.ArrayList;
import java.util.List;

import eu.ascens.helena.dev.exceptions.ParameterListNotEqualException;
import eu.ascens.helena.dev.exceptions.ParameterListNotEqualException.ParamListType;
import eu.ascens.helena.metadata.MessageType;

/**
 * This is the abstract class for a message sent between two role instances.
 *
 * @author Annabelle Klarl
 */
public abstract class Message implements AbstractHelenaInstance {

	protected final MessageType type;
	protected final List<? extends Variable<? extends Role>> roleParams;
	protected final List<? extends Variable<? extends Object>> dataParams;

	public Message() {
		this(new ArrayList<Variable<Role>>(),
				new ArrayList<Variable<Object>>());
	}

	public Message(List<? extends Variable<? extends Role>> roleParams,
			List<? extends Variable<? extends Object>> dataParams) {
		this.type = MessageType.getType(this.getClass());
		this.roleParams = roleParams;
		this.dataParams = dataParams;
	}

	public MessageType getType() {
		return this.type;
	}

	void setParamsFrom(Message msg) {
		if (this.roleParams.size() != msg.roleParams.size()) {
			throw new ParameterListNotEqualException(ParamListType.ROLE_PARAMS,
					this.roleParams.size(), msg.roleParams.size());
		}
		for (int i = 0; i < this.roleParams.size(); i++) {
			this.roleParams.get(i).setValue(msg.roleParams.get(i).getValue());
		}

		if (this.dataParams.size() != msg.dataParams.size()) {
			throw new ParameterListNotEqualException(ParamListType.DATA_PARAMS,
					this.roleParams.size(), msg.roleParams.size());
		}
		for (int i = 0; i < this.dataParams.size(); i++) {
			this.dataParams.get(i).setValue(msg.dataParams.get(i).getValue());
		}
	}

}
