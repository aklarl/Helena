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

/**
 * This class models synchronous message exchange.
 *
 * @author Annabelle Klarl
 */
class SynchronousInputChannel extends RoleInputChannel {

	private Message queuedMsg;

	@Override
	protected int getFreeMessageSpots() {
		return (this.queuedMsg == null) ? 1 : 0;
	}

	@Override
	protected void writeToChannel(Message msg) {
		this.queuedMsg = msg;
	}

	@Override
	protected Message peekAtChannel() {
		return this.queuedMsg;
	}

	@Override
	protected Message takeFromChannel() throws InterruptedException {
		Message result = this.queuedMsg;
		this.queuedMsg = null;
		this.notifyAll();
		return result;
	}

	@Override
	protected void waitUntilMessageWasWritten(Message msg)
			throws InterruptedException {
		// synchronous message passing: waiting until message is received
		while (this.queuedMsg != null) {
			try {
				this.wait();
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new InterruptedException("Sending the message "
						+ msg.getClass().getSimpleName()
						+ " via synchronous message passing was interrupted.");
			}
		}
	}

}