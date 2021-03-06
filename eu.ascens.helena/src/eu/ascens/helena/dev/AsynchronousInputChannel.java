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

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This class models asynchronous message exchange.
 *
 * @author Annabelle Klarl
 */
class AsynchronousInputChannel extends RoleInputChannel {

	private final BlockingQueue<Message> queuedMsgs;

	public AsynchronousInputChannel(int capacity) {
		this.queuedMsgs = new ArrayBlockingQueue<>(capacity);
	}

	@Override
	protected synchronized int getFreeMessageSpots() {
		return this.queuedMsgs.remainingCapacity();
	}

	@Override
	protected synchronized void writeToChannel(Message msg) {
		this.queuedMsgs.offer(msg);
	}

	@Override
	protected synchronized Message peekAtChannel() {
		return this.queuedMsgs.peek();
	}

	@Override
	protected synchronized Message takeFromChannel()
			throws InterruptedException {
		Message msg = this.queuedMsgs.poll();
		return msg;
	}

	@Override
	protected void waitUntilMessageWasWritten(Message msg)
			throws InterruptedException {
		return;
	}
}
