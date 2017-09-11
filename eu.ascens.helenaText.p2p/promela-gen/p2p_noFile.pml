///////////// ensemble structure multiplicities //////////////////////
int minRequester = 1;
int maxRequester = 1;
int currentRequester = 0;

int minRouter = 1;
int maxRouter = (2^31)-1;
int currentRouter = 0;

int minProvider = 0;
int maxProvider = 1;
int currentProvider = 0;

///////////// component operation definitions //////////////////////
typedef PeerOperation {
	mtype {
		// operations to access attributes of component
		GET_HASFILE, SET_HASFILE, GET_CONTENT, SET_CONTENT, 
		
		// operations to access associations to other components
		GET_NEIGHBOR, 
		
		// operations
		OP_PRINTFILE, 
		
		// operations to manage role playing
		CREATE_REQUESTER, GET_REQUESTER, QUIT_REQUESTER, PLAYS_REQUESTER, 
		CREATE_ROUTER, GET_ROUTER, QUIT_ROUTER, PLAYS_ROUTER, 
		CREATE_PROVIDER, GET_PROVIDER, QUIT_PROVIDER, PLAYS_PROVIDER
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

inline peer_callPrintFile(component) {
	PeerOperation op;
	op.optype = OP_PRINTFILE;
	component!op;
}

///////////// message definitions //////////////////////
mtype {
	setOffInitialRole, 
	reqAddr, 
	noFile, 
	taskDone, 
	sndFile, 
	reqFile, 
	sndAddr
}

//////// helper for setting up initial state /////////
inline send_setOffInitialRole(receiver) {
	receiver!setOffInitialRole,1,1;
}

inline receive_setOffInitialRole() {
	self?setOffInitialRole,1,1;
}

//////// helper for communication between roles /////////
inline send_reqAddr(receiver,req) {
	receiver!reqAddr,req,1;
}

inline receive_reqAddr(req) {
	self?reqAddr,req,1;
}

inline send_noFile(receiver) {
	receiver!noFile,1,1;
}

inline receive_noFile() {
	self?noFile,1,1;
}

inline send_taskDone(receiver) {
	receiver!taskDone,1,1;
}

inline receive_taskDone() {
	self?taskDone,1,1;
}

inline send_sndFile(receiver,content) {
	receiver!sndFile,1,content;
}

inline receive_sndFile(content) {
	self?sndFile,1,content;
}

inline send_reqFile(receiver,req) {
	receiver!reqFile,req,1;
}

inline receive_reqFile(req) {
	self?reqFile,req,1;
}

inline send_sndAddr(receiver,prov) {
	receiver!sndAddr,prov,1;
}

inline receive_sndAddr(prov) {
	self?sndAddr,prov,1;
}

////////////// process definition of component type Peer /////////////
proctype Peer(
		bool hasFile; int content; 
		chan neighbor; 
		chan self) {

	bool playsRequester = false;
	chan requester = [2] of { mtype,chan,int };
	bool playsRouter = false;
	chan router = [2] of { mtype,chan,int };
	bool playsProvider = false;
	chan provider = [1] of { mtype,chan,int };

	startPeer: true;

	PeerOperation op;

	do
	::atomic { 
		self?op ->
		if
		::op.optype == GET_HASFILE -> op.answer!hasFile
		::op.optype == SET_HASFILE -> op.parameters?hasFile
		::op.optype == GET_CONTENT -> op.answer!content
		::op.optype == SET_CONTENT -> op.parameters?content
		
		::op.optype == GET_NEIGHBOR -> op.answer!neighbor
		
		::op.optype == OP_PRINTFILE -> 
			// add intended behavior of this operation
		
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

/////////////// process definition for role type Requester ////////////////////
proctype Requester(chan owner, self) {
	// role type attributes
	bool roleAttr_hasFile;
	
	// component type attributes
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan prov;
	chan router;
	
	// local variables for all formal data parameters (of incoming messages)
	int content;
	
	// local variables for all return values of operations
	
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
	
	// nondeterministic choice
	if
	:: // first branch
		
		// incoming message
		receive_sndAddr(prov);
		
		// state label
		stateSndAddr: true;
		
		// outgoing message
		send_reqFile(prov,self);
		
		// incoming message
		receive_sndFile(content);
		
		// state label
		stateSndFile: true;
		
		// set comp attr
		peer_setContent(owner,content);
		
		// set comp attr
		peer_setHasFile(owner,true);
		
		// set role attr
		roleAttr_hasFile = true;
		
		// call operation at component
		peer_callPrintFile(owner);
		
		// outgoing message
		send_taskDone(router);
		
		// quit
		peer_quitRole(QUIT_REQUESTER,owner);
		goto endRequester
	:: // second branch
		
		// incoming message
		receive_noFile();
		
		// quit
		peer_quitRole(QUIT_REQUESTER,owner);
		goto endRequester
	fi
	;
	
	endRequester: false
}

/////////////// process definition for role type Router ////////////////////
proctype Router(chan owner, self) {
	// role type attributes
	
	// component type attributes
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan routerDone;
	chan routerFwd;
	chan routerDone2;
	chan req;
	chan prov;
	
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
			
			goto label350321464
		:: else ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			peer_isPlaying(PLAYS_ROUTER,compAssoc_neighbor,compAssoc_neighborPlaysRouter);
			
			if
			::(!compAssoc_neighborPlaysRouter) ->
				
				// retrieve reference to component instance
				peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				peer_retrieveRole(CREATE_ROUTER,compAssoc_neighbor,routerFwd);
				
				goto label1782831724
				
			:: else ->
				
				// outgoing message
				send_noFile(req);
				
				goto label696113188
			fi
		fi
	};
	
	label350321464: true;
	
	// outgoing message
	send_sndAddr(req,prov);
	
	// quit
	peer_quitRole(QUIT_ROUTER,owner);
	goto endRouter
	;
	
	label1782831724: true;
	
	// outgoing message
	send_reqAddr(routerFwd,req);
	
	// incoming message
	receive_taskDone();
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
		peer_isPlaying(PLAYS_ROUTER,compAssoc_neighbor,compAssoc_neighborPlaysRouter);
		
		if
		::(compAssoc_neighborPlaysRouter) ->
			
			// retrieve reference to component instance
			peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			
			// create/get role instance
			peer_retrieveRole(GET_ROUTER,compAssoc_neighbor,routerDone);
			
			goto label1384867636
		:: else ->
			
			// quit
			peer_quitRole(QUIT_ROUTER,owner);
			goto endRouter
		fi
	};
	
	label1384867636: true;
	
	// outgoing message
	send_taskDone(routerDone);
	
	// quit
	peer_quitRole(QUIT_ROUTER,owner);
	goto endRouter
	;
	
	;
	label696113188: true;
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
		peer_isPlaying(PLAYS_ROUTER,compAssoc_neighbor,compAssoc_neighborPlaysRouter);
		
		if
		::(compAssoc_neighborPlaysRouter) ->
			
			// retrieve reference to component instance
			peer_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			
			// create/get role instance
			peer_retrieveRole(GET_ROUTER,compAssoc_neighbor,routerDone2);
			
			goto label2014017961
		:: else ->
			
			// quit
			peer_quitRole(QUIT_ROUTER,owner);
			goto endRouter
		fi
	};
	
	label2014017961: true;
	
	// outgoing message
	send_taskDone(routerDone2);
	
	// quit
	peer_quitRole(QUIT_ROUTER,owner);
	goto endRouter
	;
	
	;
	
	endRouter: false
}

/////////////// process definition for role type Provider ////////////////////
proctype Provider(chan owner, self) {
	// role type attributes
	
	// component type attributes
	bool compAttr_hasFile;
	int compAttr_content;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan req;
	
	// local variables for all formal data parameters (of incoming messages)
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startProvider: true;
	
	//////// role behavior //////////
	
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
