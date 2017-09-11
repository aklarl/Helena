///////////// ensemble structure multiplicities //////////////////////
int minDeployer = 0;
int maxDeployer = 1;
int currentDeployer = 0;

int minPotStorage = 0;
int maxPotStorage = (2^31)-1;
int currentPotStorage = 0;

int minStorage = 0;
int maxStorage = 1;
int currentStorage = 0;

int minInitiator = 0;
int maxInitiator = 1;
int currentInitiator = 0;

int minPotExecutor = 0;
int maxPotExecutor = (2^31)-1;
int currentPotExecutor = 0;

int minExecutor = 0;
int maxExecutor = 1;
int currentExecutor = 0;

int minPotRequester = 0;
int maxPotRequester = (2^31)-1;
int currentPotRequester = 0;

int minRequester = 0;
int maxRequester = (2^31)-1;
int currentRequester = 0;

///////////// component operation definitions //////////////////////
typedef NodeOperation {
	mtype {
		// operations to access attributes of component
		GET_ID, SET_ID, GET_REQS, SET_REQS, GET_CODE, SET_CODE, GET_ISEXECUTING, SET_ISEXECUTING, 
		
		// operations to access associations to other components
		GET_NEIGHBOR, 
		
		// operations
		OP_PRINTRESULT, 
		
		// operations to manage role playing
		CREATE_DEPLOYER, GET_DEPLOYER, QUIT_DEPLOYER, PLAYS_DEPLOYER, 
		CREATE_POTSTORAGE, GET_POTSTORAGE, QUIT_POTSTORAGE, PLAYS_POTSTORAGE, 
		CREATE_STORAGE, GET_STORAGE, QUIT_STORAGE, PLAYS_STORAGE, 
		CREATE_INITIATOR, GET_INITIATOR, QUIT_INITIATOR, PLAYS_INITIATOR, 
		CREATE_POTEXECUTOR, GET_POTEXECUTOR, QUIT_POTEXECUTOR, PLAYS_POTEXECUTOR, 
		CREATE_EXECUTOR, GET_EXECUTOR, QUIT_EXECUTOR, PLAYS_EXECUTOR, 
		CREATE_POTREQUESTER, GET_POTREQUESTER, QUIT_POTREQUESTER, PLAYS_POTREQUESTER, 
		CREATE_REQUESTER, GET_REQUESTER, QUIT_REQUESTER, PLAYS_REQUESTER
	};
	
	mtype optype;
	chan parameters;
	chan answer;
}

//////// helpers for communication between roles and Node components /////////
inline node_retrieveRole(rtOperation,component,role) {
	NodeOperation op;
	op.optype = rtOperation;
		chan answer = [0] of { chan };
	op.answer = answer;
	component!op;
	answer?role;
}

inline node_quitRole(rtOperation,component) {
	NodeOperation op;
	op.optype = rtOperation;
	component!op;
}

inline node_isPlaying(playsOperation,component,plays) {
	NodeOperation op;
	op.optype = playsOperation;
		chan answer = [0] of { bool };
	op.answer = answer;
	component!op;
	answer?plays;
}

inline node_retrieveAssociation(assocOperation,component,assoc) {
	NodeOperation op;
	op.optype = assocOperation;
		chan answer = [0] of { chan };
	op.answer = answer;
	component!op;	
	answer?assoc;
}

inline node_getId(component,id) {
	NodeOperation op;
	op.optype = GET_ID;
		chan answer = [0] of { int };
	op.answer = answer;
	component!op;
	answer?id;
}

inline node_setId(component,value) {
	NodeOperation op;
	op.optype = SET_ID;
		chan parameters = [0] of { int };
	op.parameters = parameters;
	component!op;
	parameters!value;
}

inline node_getReqs(component,reqs) {
	NodeOperation op;
	op.optype = GET_REQS;
		chan answer = [0] of { int };
	op.answer = answer;
	component!op;
	answer?reqs;
}

inline node_setReqs(component,value) {
	NodeOperation op;
	op.optype = SET_REQS;
		chan parameters = [0] of { int };
	op.parameters = parameters;
	component!op;
	parameters!value;
}

inline node_getCode(component,code) {
	NodeOperation op;
	op.optype = GET_CODE;
		chan answer = [0] of { int };
	op.answer = answer;
	component!op;
	answer?code;
}

inline node_setCode(component,value) {
	NodeOperation op;
	op.optype = SET_CODE;
		chan parameters = [0] of { int };
	op.parameters = parameters;
	component!op;
	parameters!value;
}

inline node_getIsExecuting(component,isExecuting) {
	NodeOperation op;
	op.optype = GET_ISEXECUTING;
		chan answer = [0] of { bool };
	op.answer = answer;
	component!op;
	answer?isExecuting;
}

inline node_setIsExecuting(component,value) {
	NodeOperation op;
	op.optype = SET_ISEXECUTING;
		chan parameters = [0] of { bool };
	op.parameters = parameters;
	component!op;
	parameters!value;
}

inline node_callPrintResult(component) {
	NodeOperation op;
	op.optype = OP_PRINTRESULT;
	component!op;
}

///////////// message definitions //////////////////////
mtype {
	setOffInitialRole, 
	reqCode, 
	reqService, 
	store, 
	createStorage, 
	initiate, 
	findStorage, 
	executing, 
	sndService, 
	ackInformation, 
	foundExecutor, 
	findRequester, 
	inform, 
	sndCode, 
	execute, 
	findExecutor, 
	foundStorage
}

//////// helper for setting up initial state /////////
inline send_setOffInitialRole(receiver) {
	receiver!setOffInitialRole,1,1,1,1,1;
}

inline receive_setOffInitialRole() {
	self?setOffInitialRole,1,1,1,1,1;
}

//////// helper for communication between roles /////////
inline send_reqCode(receiver,e) {
	receiver!reqCode,e,1,1,1,1;
}

inline receive_reqCode(e) {
	self?reqCode,e,1,1,1,1;
}

inline send_reqService(receiver,r) {
	receiver!reqService,r,1,1,1,1;
}

inline receive_reqService(r) {
	self?reqService,r,1,1,1,1;
}

inline send_store(receiver,appID,appReqs,appCode) {
	receiver!store,1,1,appID,appReqs,appCode;
}

inline receive_store(appID,appReqs,appCode) {
	self?store,1,1,appID,appReqs,appCode;
}

inline send_createStorage(receiver,d,foundID,startID) {
	receiver!createStorage,d,1,foundID,startID,1;
}

inline receive_createStorage(d,foundID,startID) {
	self?createStorage,d,1,foundID,startID,1;
}

inline send_initiate(receiver,s,appID,appReqs) {
	receiver!initiate,s,1,appID,appReqs,1;
}

inline receive_initiate(s,appID,appReqs) {
	self?initiate,s,1,appID,appReqs,1;
}

inline send_findStorage(receiver,d,appID,foundID) {
	receiver!findStorage,d,1,appID,foundID,1;
}

inline receive_findStorage(d,appID,foundID) {
	self?findStorage,d,1,appID,foundID,1;
}

inline send_executing(receiver) {
	receiver!executing,1,1,1,1,1;
}

inline receive_executing() {
	self?executing,1,1,1,1,1;
}

inline send_sndService(receiver) {
	receiver!sndService,1,1,1,1,1;
}

inline receive_sndService() {
	self?sndService,1,1,1,1,1;
}

inline send_ackInformation(receiver) {
	receiver!ackInformation,1,1,1,1,1;
}

inline receive_ackInformation() {
	self?ackInformation,1,1,1,1,1;
}

inline send_foundExecutor(receiver,e) {
	receiver!foundExecutor,e,1,1,1,1;
}

inline receive_foundExecutor(e) {
	self?foundExecutor,e,1,1,1,1;
}

inline send_findRequester(receiver,e,startID) {
	receiver!findRequester,e,1,startID,1,1;
}

inline receive_findRequester(e,startID) {
	self?findRequester,e,1,startID,1,1;
}

inline send_inform(receiver,e,pr) {
	receiver!inform,e,pr,1,1,1;
}

inline receive_inform(e,pr) {
	self?inform,e,pr,1,1,1;
}

inline send_sndCode(receiver,appCode) {
	receiver!sndCode,1,1,appCode,1,1;
}

inline receive_sndCode(appCode) {
	self?sndCode,1,1,appCode,1,1;
}

inline send_execute(receiver,i,s,appID) {
	receiver!execute,i,s,appID,1,1;
}

inline receive_execute(i,s,appID) {
	self?execute,i,s,appID,1,1;
}

inline send_findExecutor(receiver,i,appReqs) {
	receiver!findExecutor,i,1,appReqs,1,1;
}

inline receive_findExecutor(i,appReqs) {
	self?findExecutor,i,1,appReqs,1,1;
}

inline send_foundStorage(receiver,s) {
	receiver!foundStorage,s,1,1,1,1;
}

inline receive_foundStorage(s) {
	self?foundStorage,s,1,1,1,1;
}

////////////// process definition of component type Node /////////////
proctype Node(
		int id; int reqs; int code; bool isExecuting; 
		chan neighbor; 
		chan self) {

	bool playsDeployer = false;
	chan deployer = [1] of { mtype,chan,chan,int,int,int };
	bool playsPotStorage = false;
	chan potstorage = [2] of { mtype,chan,chan,int,int,int };
	bool playsStorage = false;
	chan storage = [2] of { mtype,chan,chan,int,int,int };
	bool playsInitiator = false;
	chan initiator = [2] of { mtype,chan,chan,int,int,int };
	bool playsPotExecutor = false;
	chan potexecutor = [2] of { mtype,chan,chan,int,int,int };
	bool playsExecutor = false;
	chan executor = [2] of { mtype,chan,chan,int,int,int };
	bool playsPotRequester = false;
	chan potrequester = [2] of { mtype,chan,chan,int,int,int };
	bool playsRequester = false;
	chan requester = [2] of { mtype,chan,chan,int,int,int };

	startNode: true;

	NodeOperation op;

	do
	::atomic { 
		self?op ->
		if
		::op.optype == GET_ID -> op.answer!id
		::op.optype == SET_ID -> op.parameters?id
		::op.optype == GET_REQS -> op.answer!reqs
		::op.optype == SET_REQS -> op.parameters?reqs
		::op.optype == GET_CODE -> op.answer!code
		::op.optype == SET_CODE -> op.parameters?code
		::op.optype == GET_ISEXECUTING -> op.answer!isExecuting
		::op.optype == SET_ISEXECUTING -> op.parameters?isExecuting
		
		::op.optype == GET_NEIGHBOR -> op.answer!neighbor
		
		::op.optype == OP_PRINTRESULT -> 
			// add intended behavior of this operation
		
		::op.optype == CREATE_DEPLOYER ->
			if
			::!playsDeployer && currentDeployer < maxDeployer ->
				run Deployer(self, deployer);
				playsDeployer = true;
				currentDeployer++;
				op.answer!deployer
			fi
		::op.optype == GET_DEPLOYER ->
			if
			::playsDeployer ->
				op.answer!deployer
			fi
		::op.optype == QUIT_DEPLOYER ->
			if
			::playsDeployer && currentDeployer > minDeployer ->
				playsDeployer = false;
				currentDeployer--
			fi
		::op.optype == PLAYS_DEPLOYER ->
			op.answer!playsDeployer
		::op.optype == CREATE_POTSTORAGE ->
			if
			::!playsPotStorage && currentPotStorage < maxPotStorage ->
				run PotStorage(self, potstorage);
				playsPotStorage = true;
				currentPotStorage++;
				op.answer!potstorage
			fi
		::op.optype == GET_POTSTORAGE ->
			if
			::playsPotStorage ->
				op.answer!potstorage
			fi
		::op.optype == QUIT_POTSTORAGE ->
			if
			::playsPotStorage && currentPotStorage > minPotStorage ->
				playsPotStorage = false;
				currentPotStorage--
			fi
		::op.optype == PLAYS_POTSTORAGE ->
			op.answer!playsPotStorage
		::op.optype == CREATE_STORAGE ->
			if
			::!playsStorage && currentStorage < maxStorage ->
				run Storage(self, storage);
				playsStorage = true;
				currentStorage++;
				op.answer!storage
			fi
		::op.optype == GET_STORAGE ->
			if
			::playsStorage ->
				op.answer!storage
			fi
		::op.optype == QUIT_STORAGE ->
			if
			::playsStorage && currentStorage > minStorage ->
				playsStorage = false;
				currentStorage--
			fi
		::op.optype == PLAYS_STORAGE ->
			op.answer!playsStorage
		::op.optype == CREATE_INITIATOR ->
			if
			::!playsInitiator && currentInitiator < maxInitiator ->
				run Initiator(self, initiator);
				playsInitiator = true;
				currentInitiator++;
				op.answer!initiator
			fi
		::op.optype == GET_INITIATOR ->
			if
			::playsInitiator ->
				op.answer!initiator
			fi
		::op.optype == QUIT_INITIATOR ->
			if
			::playsInitiator && currentInitiator > minInitiator ->
				playsInitiator = false;
				currentInitiator--
			fi
		::op.optype == PLAYS_INITIATOR ->
			op.answer!playsInitiator
		::op.optype == CREATE_POTEXECUTOR ->
			if
			::!playsPotExecutor && currentPotExecutor < maxPotExecutor ->
				run PotExecutor(self, potexecutor);
				playsPotExecutor = true;
				currentPotExecutor++;
				op.answer!potexecutor
			fi
		::op.optype == GET_POTEXECUTOR ->
			if
			::playsPotExecutor ->
				op.answer!potexecutor
			fi
		::op.optype == QUIT_POTEXECUTOR ->
			if
			::playsPotExecutor && currentPotExecutor > minPotExecutor ->
				playsPotExecutor = false;
				currentPotExecutor--
			fi
		::op.optype == PLAYS_POTEXECUTOR ->
			op.answer!playsPotExecutor
		::op.optype == CREATE_EXECUTOR ->
			if
			::!playsExecutor && currentExecutor < maxExecutor ->
				run Executor(self, executor);
				playsExecutor = true;
				currentExecutor++;
				op.answer!executor
			fi
		::op.optype == GET_EXECUTOR ->
			if
			::playsExecutor ->
				op.answer!executor
			fi
		::op.optype == QUIT_EXECUTOR ->
			if
			::playsExecutor && currentExecutor > minExecutor ->
				playsExecutor = false;
				currentExecutor--
			fi
		::op.optype == PLAYS_EXECUTOR ->
			op.answer!playsExecutor
		::op.optype == CREATE_POTREQUESTER ->
			if
			::!playsPotRequester && currentPotRequester < maxPotRequester ->
				run PotRequester(self, potrequester);
				playsPotRequester = true;
				currentPotRequester++;
				op.answer!potrequester
			fi
		::op.optype == GET_POTREQUESTER ->
			if
			::playsPotRequester ->
				op.answer!potrequester
			fi
		::op.optype == QUIT_POTREQUESTER ->
			if
			::playsPotRequester && currentPotRequester > minPotRequester ->
				playsPotRequester = false;
				currentPotRequester--
			fi
		::op.optype == PLAYS_POTREQUESTER ->
			op.answer!playsPotRequester
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
		fi
	}
	od
}

/////////////// process definition for role type Deployer ////////////////////
proctype Deployer(chan owner, self) {
	// role type attributes
	int roleAttr_appID;
	int roleAttr_appReqs;
	int roleAttr_appCode;
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan s;
	chan ps;
	
	// local variables for all formal data parameters (of incoming messages)
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startDeployer: true;
	
	//////// role behavior //////////
	
	// set role attr
	roleAttr_appID = 1234;
	
	// set role attr
	roleAttr_appReqs = 1234;
	
	// set role attr
	roleAttr_appCode = 1234;
	
	// retrieve reference to component instance
	node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
	
	// create/get role instance
	node_retrieveRole(CREATE_POTSTORAGE,compAssoc_neighbor,ps);
	
	// outgoing message
	node_getId(owner,compAttr_id);
	send_findStorage(ps,self,roleAttr_appID,compAttr_id);
	
	// incoming message
	receive_foundStorage(s);
	
	// outgoing message
	send_store(s,roleAttr_appID,roleAttr_appReqs,roleAttr_appCode);
	
	// quit
	node_quitRole(QUIT_DEPLOYER,owner);
	goto endDeployer
	;
	
	endDeployer: false
}

/////////////// process definition for role type PotStorage ////////////////////
proctype PotStorage(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan s;
	chan psFwd1;
	chan psFwd2;
	chan depl;
	chan psNotSmallest1;
	chan psNotSmallest2;
	chan depl2;
	chan psSmallest1;
	chan psSmallest2;
	
	// local variables for all formal data parameters (of incoming messages)
	int foundID2;
	int appID;
	int startID;
	int foundID;
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	bool ownerPlaysStorage;
	bool compAssoc_neighborPlaysPotStorage;
	
	// start label
	startPotStorage: true;
	
	//////// role behavior //////////
	
	// declare local process by label
	processPotStorageProcess: true;
	
	// incoming message
	receive_findStorage(depl,appID,foundID);
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		node_getId(owner,compAttr_id);;
		
		if
		::((compAttr_id-appID < 0 && foundID-appID < 0 && appID-compAttr_id < appID-foundID) || (compAttr_id-appID >= 0 && foundID-appID >= 0 && compAttr_id-appID < foundID-appID) || (compAttr_id-appID < 0 && foundID-appID >= 0 && appID-compAttr_id < foundID-appID) || (compAttr_id-appID >= 0 && foundID-appID < 0 && compAttr_id-appID < appID-foundID)) ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			node_isPlaying(PLAYS_POTSTORAGE,compAssoc_neighbor,compAssoc_neighborPlaysPotStorage);
			
			if
			::(!compAssoc_neighborPlaysPotStorage) ->
				
				// retrieve reference to component instance
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				node_retrieveRole(CREATE_POTSTORAGE,compAssoc_neighbor,psSmallest1);
				
				goto label671806307
				
			:: else ->
				
				// retrieve reference to component instance
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				node_retrieveRole(GET_POTSTORAGE,compAssoc_neighbor,psSmallest2);
				
				goto label1651723401
			fi
		:: else ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			node_isPlaying(PLAYS_POTSTORAGE,compAssoc_neighbor,compAssoc_neighborPlaysPotStorage);
			
			if
			::(!compAssoc_neighborPlaysPotStorage) ->
				
				// retrieve reference to component instance
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				node_retrieveRole(CREATE_POTSTORAGE,compAssoc_neighbor,psNotSmallest1);
				
				goto label983559797
				
			:: else ->
				
				// retrieve reference to component instance
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				node_retrieveRole(GET_POTSTORAGE,compAssoc_neighbor,psNotSmallest2);
				
				goto label1215582695
			fi
		fi
	};
	
	label671806307: true;
	
	// outgoing message
	node_getId(owner,compAttr_id);
	send_findStorage(psSmallest1,depl,appID,compAttr_id);
	
	// declare local process by label
	processSecondRoundTrip: true;
	
	// incoming message
	receive_createStorage(depl2,foundID2,startID);
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		node_getId(owner,compAttr_id);;
		
		if
		::(compAttr_id == foundID2) ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_isPlaying(PLAYS_STORAGE,owner,ownerPlaysStorage);
			
			if
			::(!ownerPlaysStorage) ->
				
				// retrieve reference to component instance
				
				// create/get role instance
				node_retrieveRole(CREATE_STORAGE,owner,s);
				
				goto label1308429587
				
			:: else ->
				
				// quit
				node_quitRole(QUIT_POTSTORAGE,owner);
				goto endPotStorage
			fi
		:: else ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_getId(owner,compAttr_id);;
			
			if
			::(compAttr_id != startID) ->
				
				// if-then-else
				// retrieve values for guards in if-then-else
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				node_isPlaying(PLAYS_POTSTORAGE,compAssoc_neighbor,compAssoc_neighborPlaysPotStorage);
				
				if
				::(compAssoc_neighborPlaysPotStorage) ->
					
					// retrieve reference to component instance
					node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
					
					// create/get role instance
					node_retrieveRole(GET_POTSTORAGE,compAssoc_neighbor,psFwd2);
					
					goto label899967066
					
				:: else ->
					
					// quit
					node_quitRole(QUIT_POTSTORAGE,owner);
					goto endPotStorage
				fi
				
			:: else ->
				
				// quit
				node_quitRole(QUIT_POTSTORAGE,owner);
				goto endPotStorage
			fi
		fi
	};
	
	label1308429587: true;
	
	// outgoing message
	send_foundStorage(depl2,s);
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		node_getId(owner,compAttr_id);;
		
		if
		::(compAttr_id != startID) ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			node_isPlaying(PLAYS_POTSTORAGE,compAssoc_neighbor,compAssoc_neighborPlaysPotStorage);
			
			if
			::(compAssoc_neighborPlaysPotStorage) ->
				
				// retrieve reference to component instance
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				node_retrieveRole(GET_POTSTORAGE,compAssoc_neighbor,psFwd1);
				
				goto label1458850595
				
			:: else ->
				
				// quit
				node_quitRole(QUIT_POTSTORAGE,owner);
				goto endPotStorage
			fi
		:: else ->
			
			// quit
			node_quitRole(QUIT_POTSTORAGE,owner);
			goto endPotStorage
		fi
	};
	
	label1458850595: true;
	
	// outgoing message
	send_createStorage(psFwd1,depl2,foundID2,startID);
	
	// quit
	node_quitRole(QUIT_POTSTORAGE,owner);
	goto endPotStorage
	;
	;
	
	;
	;
	
	label899967066: true;
	
	// outgoing message
	send_createStorage(psFwd2,depl2,foundID2,startID);
	
	// quit
	node_quitRole(QUIT_POTSTORAGE,owner);
	goto endPotStorage
	;
	;
	;
	label1651723401: true;
	
	// outgoing message
	node_getId(owner,compAttr_id);node_getId(owner,compAttr_id);
	send_createStorage(psSmallest2,depl,compAttr_id,compAttr_id);
	
	// process invocation by goto label
	goto processSecondRoundTrip
	;
	
	label983559797: true;
	
	// outgoing message
	send_findStorage(psNotSmallest1,depl,appID,foundID);
	
	// process invocation by goto label
	goto processSecondRoundTrip
	;
	label1215582695: true;
	
	// outgoing message
	node_getId(owner,compAttr_id);
	send_createStorage(psNotSmallest2,depl,foundID,compAttr_id);
	
	// process invocation by goto label
	goto processSecondRoundTrip
	;
	
	endPotStorage: false
}

/////////////// process definition for role type Storage ////////////////////
proctype Storage(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan i;
	chan e;
	
	// local variables for all formal data parameters (of incoming messages)
	int appCode;
	int appReqs;
	int appID;
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startStorage: true;
	
	//////// role behavior //////////
	
	// incoming message
	receive_store(appID,appReqs,appCode);
	
	// set comp attr
	node_setCode(owner,appCode);
	
	// retrieve reference to component instance
	
	// create/get role instance
	node_retrieveRole(CREATE_INITIATOR,owner,i);
	
	// outgoing message
	send_initiate(i,self,appID,appReqs);
	
	// incoming message
	receive_reqCode(e);
	
	// outgoing message
	node_getCode(owner,compAttr_code);
	send_sndCode(e,compAttr_code);
	
	// quit
	node_quitRole(QUIT_STORAGE,owner);
	goto endStorage
	;
	
	endStorage: false
}

/////////////// process definition for role type Initiator ////////////////////
proctype Initiator(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan pr;
	chan pe;
	chan s;
	chan e;
	
	// local variables for all formal data parameters (of incoming messages)
	int appReqs;
	int appID;
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startInitiator: true;
	
	//////// role behavior //////////
	
	// incoming message
	receive_initiate(s,appID,appReqs);
	
	// retrieve reference to component instance
	
	// create/get role instance
	node_retrieveRole(CREATE_POTEXECUTOR,owner,pe);
	
	// outgoing message
	send_findExecutor(pe,self,appReqs);
	
	// incoming message
	receive_foundExecutor(e);
	
	// outgoing message
	send_execute(e,self,s,appID);
	
	// incoming message
	receive_executing();
	
	// retrieve reference to component instance
	node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
	
	// create/get role instance
	node_retrieveRole(CREATE_POTREQUESTER,compAssoc_neighbor,pr);
	
	// outgoing message
	node_getId(owner,compAttr_id);
	send_findRequester(pr,e,compAttr_id);
	
	// quit
	node_quitRole(QUIT_INITIATOR,owner);
	goto endInitiator
	;
	
	endInitiator: false
}

/////////////// process definition for role type PotExecutor ////////////////////
proctype PotExecutor(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan pe;
	chan i;
	chan e;
	
	// local variables for all formal data parameters (of incoming messages)
	int appReqs;
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	bool ownerPlaysExecutor;
	bool compAssoc_neighborPlaysPotExecutor;
	
	// start label
	startPotExecutor: true;
	
	//////// role behavior //////////
	
	// incoming message
	receive_findExecutor(i,appReqs);
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		node_getReqs(owner,compAttr_reqs);;
		
		if
		::(compAttr_reqs == appReqs) ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_isPlaying(PLAYS_EXECUTOR,owner,ownerPlaysExecutor);
			
			if
			::(!ownerPlaysExecutor) ->
				
				// retrieve reference to component instance
				
				// create/get role instance
				node_retrieveRole(CREATE_EXECUTOR,owner,e);
				
				goto label1650405298
				
			:: else ->
				
				// quit
				node_quitRole(QUIT_POTEXECUTOR,owner);
				goto endPotExecutor
			fi
		:: else ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			node_isPlaying(PLAYS_POTEXECUTOR,compAssoc_neighbor,compAssoc_neighborPlaysPotExecutor);
			
			if
			::(!compAssoc_neighborPlaysPotExecutor) ->
				
				// retrieve reference to component instance
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				node_retrieveRole(CREATE_POTEXECUTOR,compAssoc_neighbor,pe);
				
				goto label484971172
				
			:: else ->
				
				// quit
				node_quitRole(QUIT_POTEXECUTOR,owner);
				goto endPotExecutor
			fi
		fi
	};
	
	label1650405298: true;
	
	// outgoing message
	send_foundExecutor(i,e);
	
	// quit
	node_quitRole(QUIT_POTEXECUTOR,owner);
	goto endPotExecutor
	;
	;
	
	label484971172: true;
	
	// outgoing message
	send_findExecutor(pe,i,appReqs);
	
	// quit
	node_quitRole(QUIT_POTEXECUTOR,owner);
	goto endPotExecutor
	;
	;
	
	endPotExecutor: false
}

/////////////// process definition for role type Executor ////////////////////
proctype Executor(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan i;
	chan s;
	chan r;
	
	// local variables for all formal data parameters (of incoming messages)
	int appCode;
	int appID;
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startExecutor: true;
	
	//////// role behavior //////////
	
	// declare local process by label
	processExecutorProcess: true;
	
	// incoming message
	receive_execute(i,s,appID);
	
	// outgoing message
	send_reqCode(s,self);
	
	// incoming message
	receive_sndCode(appCode);
	
	// set comp attr
	node_setIsExecuting(owner,true);
	
	// outgoing message
	send_executing(i);
	
	// declare local process by label
	processExecutorRunning: true;
	
	// incoming message
	receive_reqService(r);
	
	// outgoing message
	send_sndService(r);
	
	// process invocation by goto label
	goto processExecutorRunning
	;
	
	endExecutor: false
}

/////////////// process definition for role type PotRequester ////////////////////
proctype PotRequester(chan owner, self) {
	// role type attributes
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan e;
	chan pr1;
	chan r;
	chan pr2;
	
	// local variables for all formal data parameters (of incoming messages)
	int startID;
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	bool ownerPlaysRequester;
	bool compAssoc_neighborPlaysPotRequester;
	
	// start label
	startPotRequester: true;
	
	//////// role behavior //////////
	
	// declare local process by label
	processPotRequesterProcess: true;
	
	// incoming message
	receive_findRequester(e,startID);
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		node_isPlaying(PLAYS_REQUESTER,owner,ownerPlaysRequester);
		
		if
		::(ownerPlaysRequester) ->
			
			// retrieve reference to component instance
			
			// create/get role instance
			node_retrieveRole(GET_REQUESTER,owner,r);
			
			goto label1057193990
		:: else ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_getId(owner,compAttr_id);;
			
			if
			::(compAttr_id != startID) ->
				
				// if-then-else
				// retrieve values for guards in if-then-else
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				node_isPlaying(PLAYS_POTREQUESTER,compAssoc_neighbor,compAssoc_neighborPlaysPotRequester);
				
				if
				::(!compAssoc_neighborPlaysPotRequester) ->
					
					// retrieve reference to component instance
					node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
					
					// create/get role instance
					node_retrieveRole(CREATE_POTREQUESTER,compAssoc_neighbor,pr2);
					
					goto label2046478100
					
				:: else ->
					
					// quit
					node_quitRole(QUIT_POTREQUESTER,owner);
					goto endPotRequester
				fi
				
			:: else ->
				
				// quit
				node_quitRole(QUIT_POTREQUESTER,owner);
				goto endPotRequester
			fi
		fi
	};
	
	label1057193990: true;
	
	// outgoing message
	send_inform(r,e,self);
	
	// incoming message
	receive_ackInformation();
	
	// if-then-else
	atomic {		
		// retrieve values for guards in guarded choice
		node_getId(owner,compAttr_id);;
		
		if
		::(compAttr_id != startID) ->
			
			// if-then-else
			// retrieve values for guards in if-then-else
			node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
			node_isPlaying(PLAYS_POTREQUESTER,compAssoc_neighbor,compAssoc_neighborPlaysPotRequester);
			
			if
			::(!compAssoc_neighborPlaysPotRequester) ->
				
				// retrieve reference to component instance
				node_retrieveAssociation(GET_NEIGHBOR,owner,compAssoc_neighbor);
				
				// create/get role instance
				node_retrieveRole(CREATE_POTREQUESTER,compAssoc_neighbor,pr1);
				
				goto label1272752612
				
			:: else ->
				
				// quit
				node_quitRole(QUIT_POTREQUESTER,owner);
				goto endPotRequester
			fi
		:: else ->
			
			// quit
			node_quitRole(QUIT_POTREQUESTER,owner);
			goto endPotRequester
		fi
	};
	
	label1272752612: true;
	
	// outgoing message
	send_findRequester(pr1,e,startID);
	
	// quit
	node_quitRole(QUIT_POTREQUESTER,owner);
	goto endPotRequester
	;
	;
	
	;
	
	label2046478100: true;
	
	// outgoing message
	send_findRequester(pr2,e,startID);
	
	// quit
	node_quitRole(QUIT_POTREQUESTER,owner);
	goto endPotRequester
	;
	;
	;
	
	endPotRequester: false
}

/////////////// process definition for role type Requester ////////////////////
proctype Requester(chan owner, self) {
	// role type attributes
	bool roleAttr_hasResult;
	
	// component type attributes
	int compAttr_id;
	int compAttr_reqs;
	int compAttr_code;
	bool compAttr_isExecuting;
	
	// component type associations
	chan compAssoc_neighbor;
	
	// local variables for all role instance variables (of create/get and incoming messages)
	chan e;
	chan pr;
	
	// local variables for all formal data parameters (of incoming messages)
	
	// local variables for all return values of operations
	
	// local variables for all plays queries
	
	// start label
	startRequester: true;
	
	//////// role behavior //////////
	
	// incoming message
	receive_inform(e,pr);
	
	// outgoing message
	send_ackInformation(pr);
	
	// outgoing message
	send_reqService(e,self);
	
	// incoming message
	receive_sndService();
	
	// set role attr
	roleAttr_hasResult = true;
	
	// call operation at component
	node_callPrintResult(owner);
	
	// quit
	node_quitRole(QUIT_REQUESTER,owner);
	goto endRequester
	;
	
	endRequester: false
}
