///////////// ensemble structure multiplicities //////////////////////
int minRequester = 1;
int maxRequester = 1;
int currentRequester = 0;

int minRequester2 = 1;
int maxRequester2 = 1;
int currentRequester2 = 0;

int minRouter = 1;
int maxRouter = (2^31)-1;
int currentRouter = 0;

int minRouter2 = 1;
int maxRouter2 = (2^31)-1;
int currentRouter2 = 0;

int minProvider = 0;
int maxProvider = 1;
int currentProvider = 0;

///////////// component operation definitions //////////////////////
typedef PeerOperation {
	mtype {
		// operations to access attributes of component
		GET_NAME, SET_NAME, GET_HASFILE, SET_HASFILE, GET_CONTENT, SET_CONTENT, 
		
		// operations to access associations to other components
		GET_NEIGHBOR, GET_NEIGHBOR2, 
		
		// operations
		OP_RANDOMSTEP, OP_COMPUTE, 
		
		// operations to manage role playing
		CREATE_REQUESTER, GET_REQUESTER, QUIT_REQUESTER, PLAYS_REQUESTER, 
		CREATE_REQUESTER2, GET_REQUESTER2, QUIT_REQUESTER2, PLAYS_REQUESTER2, 
		CREATE_ROUTER, GET_ROUTER, QUIT_ROUTER, PLAYS_ROUTER, 
		CREATE_ROUTER2, GET_ROUTER2, QUIT_ROUTER2, PLAYS_ROUTER2, 
		CREATE_PROVIDER, GET_PROVIDER, QUIT_PROVIDER, PLAYS_PROVIDER
	};
	
	mtype optype;
	chan parameters;
	chan answer;
}
///////////// component operation definitions //////////////////////
typedef Peer2Operation {
	mtype {
		// operations to access attributes of component
		
		// operations to access associations to other components
		GET_GUSTAV, 
		
		// operations
		OP_COMPUTE2, 
		
		// operations to manage role playing
	};
	
	mtype optype;
	chan parameters;
	chan answer;
}

//////// helpers for communication between roles and Peer components /////////
inline peer_retrieveRole(rtOperation,component,role) {
	PeerOperation op;
	op.optype = rtOperation;
		chan answer = [0] of { chan };
	op.answer = answer;
	component!op;
	answer?role;
}

inline peer_quitRole(rtOperation,component) {
	PeerOperation op;
	op.optype = rtOperation;
	component!op;
}

inline peer_isPlaying(playsOperation,component,plays) {
	PeerOperation op;
	op.optype = playsOperation;
		chan answer = [0] of { bool };
	op.answer = answer;
	component!op;
	answer?plays;
}

inline peer_retrieveAssociation(assocOperation,component,assoc) {
	PeerOperation op;
	op.optype = assocOperation;
		chan answer = [0] of { chan };
	op.answer = answer;
	component!op;	
	answer?assoc;
}

inline peer_getName(component,name) {
	PeerOperation op;
	op.optype = GET_NAME;
		chan answer = [0] of { int };
	op.answer = answer;
	component!op;
	answer?name;
}

inline peer_setName(component,value) {
	PeerOperation op;
	op.optype = SET_NAME;
		chan parameters = [0] of { int };
	op.parameters = parameters;
	component!op;
	parameters!value;
}

inline peer_getHasFile(component,hasFile) {
	PeerOperation op;
	op.optype = GET_HASFILE;
		chan answer = [0] of { bool };
	op.answer = answer;
	component!op;
	answer?hasFile;
}

inline peer_setHasFile(component,value) {
	PeerOperation op;
	op.optype = SET_HASFILE;
		chan parameters = [0] of { bool };
	op.parameters = parameters;
	component!op;
	parameters!value;
}

inline peer_getContent(component,content) {
	PeerOperation op;
	op.optype = GET_CONTENT;
		chan answer = [0] of { int };
	op.answer = answer;
	component!op;
	answer?content;
}

inline peer_setContent(component,value) {
	PeerOperation op;
	op.optype = SET_CONTENT;
		chan parameters = [0] of { int };
	op.parameters = parameters;
	component!op;
	parameters!value;
}

inline peer_callRandomStep(component) {
	PeerOperation op;
	op.optype = OP_RANDOMSTEP;
	component!op;
}

inline peer_callCompute(component,input,input2,re) {
	PeerOperation op;
	op.optype = OP_COMPUTE;
	chan parameters = [0] of { int,bool };
	op.parameters = parameters;
	chan answer = [0] of { int };
	op.answer = answer;
	component!op;
	parameters!input,input2;
	answer?re;
}

//////// helpers for communication between roles and Peer2 components /////////
inline peer2_retrieveRole(rtOperation,component,role) {
	Peer2Operation op;
	op.optype = rtOperation;
		chan answer = [0] of { chan };
	op.answer = answer;
	component!op;
	answer?role;
}

inline peer2_quitRole(rtOperation,component) {
	Peer2Operation op;
	op.optype = rtOperation;
	component!op;
}

inline peer2_isPlaying(playsOperation,component,plays) {
	Peer2Operation op;
	op.optype = playsOperation;
		chan answer = [0] of { bool };
	op.answer = answer;
	component!op;
	answer?plays;
}

inline peer2_retrieveAssociation(assocOperation,component,assoc) {
	Peer2Operation op;
	op.optype = assocOperation;
		chan answer = [0] of { chan };
	op.answer = answer;
	component!op;	
	answer?assoc;
}


inline peer2_callCompute2(component,input,input2,re) {
	Peer2Operation op;
	op.optype = OP_COMPUTE2;
	chan parameters = [0] of { int,bool };
	op.parameters = parameters;
	chan answer = [0] of { int };
	op.answer = answer;
	component!op;
	parameters!input,input2;
	answer?re;
}

///////////// message definitions //////////////////////
mtype {
	setOffInitialRole, 
	sndAddr, 
	reqFile2, 
	reqAddr, 
	sndFile, 
	sndAddr2, 
	reqAddr2, 
	sndFile2, 
	reqFile
}

//////// helper for setting up initial state /////////
inline send_setOffInitialRole(receiver) {
	receiver!setOffInitialRole,1,1;
}

inline receive_setOffInitialRole() {
	self?setOffInitialRole,1,1;
}

//////// helper for communication between roles /////////
inline send_sndAddr(receiver,prov) {
	receiver!sndAddr,prov,1;
}

inline receive_sndAddr(prov) {
	self?sndAddr,prov,1;
}

inline send_reqFile2(receiver,req) {
	receiver!reqFile2,req,1;
}

inline receive_reqFile2(req) {
	self?reqFile2,req,1;
}

inline send_reqAddr(receiver,req) {
	receiver!reqAddr,req,1;
}

inline receive_reqAddr(req) {
	self?reqAddr,req,1;
}

inline send_sndFile(receiver,cont) {
	receiver!sndFile,1,cont;
}

inline receive_sndFile(cont) {
	self?sndFile,1,cont;
}

inline send_sndAddr2(receiver,prov) {
	receiver!sndAddr2,prov,1;
}

inline receive_sndAddr2(prov) {
	self?sndAddr2,prov,1;
}

inline send_reqAddr2(receiver,req) {
	receiver!reqAddr2,req,1;
}

inline receive_reqAddr2(req) {
	self?reqAddr2,req,1;
}

inline send_sndFile2(receiver,cont) {
	receiver!sndFile2,1,cont;
}

inline receive_sndFile2(cont) {
	self?sndFile2,1,cont;
}

inline send_reqFile(receiver,req) {
	receiver!reqFile,req,1;
}

inline receive_reqFile(req) {
	self?reqFile,req,1;
}

////////////// process definition of component type Peer /////////////
proctype Peer(
		int name; bool hasFile; int content; 
		chan neighbor; chan neighbor2; 
		chan self) {

	bool playsRequester = false;
	chan requester = [2] of { mtype,chan,int };
	bool playsRequester2 = false;
	chan requester2 = [2] of { mtype,chan,int };
	bool playsRouter = false;
	chan router = [2] of { mtype,chan,int };
	bool playsRouter2 = false;
	chan router2 = [2] of { mtype,chan,int };
	bool playsProvider = false;
	chan provider = [1] of { mtype,chan,int };

	startPeer: true;

	PeerOperation op;

	do
	::atomic { 
		self?op ->
		if
		::op.optype == GET_NAME -> op.answer!name
		::op.optype == SET_NAME -> op.parameters?name
		::op.optype == GET_HASFILE -> op.answer!hasFile
		::op.optype == SET_HASFILE -> op.parameters?hasFile
		::op.optype == GET_CONTENT -> op.answer!content
		::op.optype == SET_CONTENT -> op.parameters?content
		
		::op.optype == GET_NEIGHBOR -> op.answer!neighbor
		::op.optype == GET_NEIGHBOR2 -> op.answer!neighbor2
		
		::op.optype == OP_RANDOMSTEP -> 
			// add intended behavior of this operation
		::op.optype == OP_COMPUTE -> 
			int input;
			bool input2;
			op.parameters?input,input2;
			// add intended behavior of this operation
			op.answer!1;
		
		::op.optype == CREATE_REQUESTER ->
			if
			::!playsRequester && currentRequester < maxRequester ->
				run Requester(self, requester);
				playsRequester = true;
				currentRequester++;
				op.answer!requester
			fi
		::op.optype == GET_REQUESTER ->
			if
			::playsRequester ->
				op.answer!requester
			fi
		::op.optype == QUIT_REQUESTER ->
			if
			::playsRequester && currentRequester > minRequester ->
				playsRequester = false;
				currentRequester--
			fi
		::op.optype == PLAYS_REQUESTER ->
			op.answer!playsRequester
		::op.optype == CREATE_REQUESTER2 ->
			if
			::!playsRequester2 && currentRequester2 < maxRequester2 ->
				run Requester2(self, requester2);
				playsRequester2 = true;
				currentRequester2++;
				op.answer!requester2
			fi
		::op.optype == GET_REQUESTER2 ->
			if
			::playsRequester2 ->
				op.answer!requester2
			fi
		::op.optype == QUIT_REQUESTER2 ->
			if
			::playsRequester2 && currentRequester2 > minRequester2 ->
				playsRequester2 = false;
				currentRequester2--
			fi
		::op.optype == PLAYS_REQUESTER2 ->
			op.answer!playsRequester2
		::op.optype == CREATE_ROUTER ->
			if
			::!playsRouter && currentRouter < maxRouter ->
				run Router(self, router);
				playsRouter = true;
				currentRouter++;
				op.answer!router
			fi
		::op.optype == GET_ROUTER ->
			if
			::playsRouter ->
				op.answer!router
			fi
		::op.optype == QUIT_ROUTER ->
			if
			::playsRouter && currentRouter > minRouter ->
				playsRouter = false;
				currentRouter--
			fi
		::op.optype == PLAYS_ROUTER ->
			op.answer!playsRouter
		::op.optype == CREATE_ROUTER2 ->
			if
			::!playsRouter2 && currentRouter2 < maxRouter2 ->
				run Router2(self, router2);
				playsRouter2 = true;
				currentRouter2++;
				op.answer!router2
			fi
		::op.optype == GET_ROUTER2 ->
			if
			::playsRouter2 ->
				op.answer!router2
			fi
		::op.optype == QUIT_ROUTER2 ->
			if
			::playsRouter2 && currentRouter2 > minRouter2 ->
				playsRouter2 = false;
				currentRouter2--
			fi
		::op.optype == PLAYS_ROUTER2 ->
			op.answer!playsRouter2
		::op.optype == CREATE_PROVIDER ->
			if
			::!playsProvider && currentProvider < maxProvider ->
				run Provider(self, provider);
				playsProvider = true;
				currentProvider++;
				op.answer!provider
			fi
		::op.optype == GET_PROVIDER ->
			if
			::playsProvider ->
				op.answer!provider
			fi
		::op.optype == QUIT_PROVIDER ->
			if
			::playsProvider && currentProvider > minProvider ->
				playsProvider = false;
				currentProvider--
			fi
		::op.optype == PLAYS_PROVIDER ->
			op.answer!playsProvider
		fi
	}
	od
}

////////////// process definition of component type Peer2 /////////////
proctype Peer2(
		chan gustav; 
		chan self) {


	startPeer2: true;

	Peer2Operation op;

	do
	::atomic { 
		self?op ->
		if
		
		::op.optype == GET_GUSTAV -> op.answer!gustav
		
		::op.optype == OP_COMPUTE2 -> 
			int input;
			bool input2;
			op.parameters?input,input2;
			// add intended behavior of this operation
			op.answer!1;
		
		fi
	}
	od
}

/////////////// process definition for role type Requester ////////////////////
proctype Requester(chan owner, self) {
	// role type attributes
	int roleAttr_fileName;
	
	// component type attributes
	int compAttr_name;
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	chan compAssoc_neighbor2;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan router;
	chan prov;
	
	// local variables for all formal data parameters (of incoming messages)
	int cont2;
	
	// local variables for all return values of operations
	int cont3;
	
	// local variables for all plays queries
	
	// start label
	startRequester: true;
	
	//////// role behavior //////////
	
	// retrieve reference to component instance
	peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
	
	// create/get role instance
	peer_retrieveRole(CREATE_ROUTER,compAssoc_neighbor,router);
	
	// outgoing message
	send_reqAddr(router,self);
	
	// incoming message
	receive_sndAddr(prov);
	
	// state label
	stateSndAddr: true;
	
	// outgoing message
	send_reqFile(prov,self);
	
	// incoming message
	receive_sndFile(cont2);
	
	// state label
	stateSndFile: true;
	
	// call operation at component
	peer_callRandomStep(owner);
	
	// call operation at component
	peer_getContent(owner,compAttr_content);peer_getHasFile(owner,compAttr_hasFile);
	peer_callCompute(owner,compAttr_content,compAttr_hasFile,cont3);
	
	// set comp attr
	peer_setContent(owner,cont3);
	
	// set comp attr
	peer_setContent(owner,cont2);
	
	// quit
	peer_quitRole(QUIT_REQUESTER,owner);
	goto endRequester
	;
	
	endRequester: false
}

/////////////// process definition for role type Requester2 ////////////////////
proctype Requester2(chan owner, self) {
	// role type attributes
	int roleAttr_fileName;
	
	// component type attributes
	int compAttr_name;
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	chan compAssoc_neighbor2;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan router;
	chan prov;
	chan router2;
	
	// local variables for all formal data parameters (of incoming messages)
	int c;
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startRequester2: true;
	
	//////// role behavior //////////
	
	// retrieve reference to component instance
	peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
	
	// create/get role instance
	peer_retrieveRole(CREATE_ROUTER2,compAssoc_neighbor,router);
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		
		if
		::(true) ->
			
			// retrieve reference to component instance
			peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			
			// create/get role instance
			peer_retrieveRole(CREATE_ROUTER2,compAssoc_neighbor,router2);
			
			goto label828161786
		:: else ->
			
			// incoming message
			receive_sndFile2(c);
			
			goto label201199842
		fi
	};
	
	label828161786: true;
	
	// incoming message
	receive_sndAddr2(prov);
	
	// quit
	peer_quitRole(QUIT_REQUESTER2,owner);
	goto endRequester2
	;
	
	label201199842: true;
	
	// quit
	peer_quitRole(QUIT_REQUESTER2,owner);
	goto endRequester2
	;
	
	endRequester2: false
}

/////////////// process definition for role type Router ////////////////////
proctype Router(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_name;
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	chan compAssoc_neighbor2;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan req;
	chan router2;
	chan prov;
	chan router1;
	
	// local variables for all formal data parameters (of incoming messages)
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	bool compAssoc_neighborPlaysRouter;
	
	// start label
	startRouter: true;
	
	//////// role behavior //////////
	
	// declare local process by label
	processRouterProc: true;
	
	// incoming message
	receive_reqAddr(req);
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		peer_getHasFile(owner,compAttr_hasFile);;
		
		if
		::(compAttr_hasFile) ->
			
			// retrieve reference to component instance
			
			// create/get role instance
			peer_retrieveRole(CREATE_PROVIDER,owner,prov);
			
			goto label1328972178
		:: else ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			peer_isPlaying(PLAYS_ROUTER,compAssoc_neighbor,compAssoc_neighborPlaysRouter);
			
			if
			::(compAssoc_neighborPlaysRouter) ->
				
				// retrieve reference to component instance
				peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				peer_retrieveRole(GET_ROUTER,compAssoc_neighbor,router2);
				
				goto label206251475
				
			:: else ->
				
				// retrieve reference to component instance
				peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				peer_retrieveRole(CREATE_ROUTER,compAssoc_neighbor,router1);
				
				goto label423538492
			fi
		fi
	};
	
	label1328972178: true;
	
	// outgoing message
	send_sndAddr(req,prov);
	
	// quit
	peer_quitRole(QUIT_ROUTER,owner);
	goto endRouter
	;
	
	label206251475: true;
	
	// outgoing message
	send_reqAddr(router2,req);
	
	// process invocation by goto label
	goto processRouterProc
	;
	label423538492: true;
	
	// outgoing message
	send_reqAddr(router1,req);
	
	// process invocation by goto label
	goto processRouterProc
	;
	
	endRouter: false
}

/////////////// process definition for role type Router2 ////////////////////
proctype Router2(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_name;
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	chan compAssoc_neighbor2;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	
	// local variables for all formal data parameters (of incoming messages)
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startRouter2: true;
	
	//////// role behavior //////////
	
	// quit
	peer_quitRole(QUIT_ROUTER2,owner);
	goto endRouter2;
	
	endRouter2: false
}

/////////////// process definition for role type Provider ////////////////////
proctype Provider(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_name;
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	chan compAssoc_neighbor2;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan req;
	
	// local variables for all formal data parameters (of incoming messages)
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startProvider: true;
	
	//////// role behavior //////////
	
	// declare local process by label
	processProviderProc: true;
	
	// incoming message
	receive_reqFile(req);
	
	// outgoing message
	peer_getContent(owner,compAttr_content);
	send_sndFile(req,compAttr_content);
	
	// quit
	peer_quitRole(QUIT_PROVIDER,owner);
	goto endProvider
	;
	
	endProvider: false
}
