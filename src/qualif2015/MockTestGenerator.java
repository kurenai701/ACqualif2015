package qualif2015;

public class MockTestGenerator {

	
	
	
	public ProblemModel getProblemModTestAlgo()
	{
		ProblemModel res = null;//new ProblemModel();
		
		// CAS DE TEST
	//	res.intTest1 = 42;
	//	res.stringTest = "bbb";
			
		return res;
	}
	
	// TO Initialize TEST
	//	public OutputModel getOutputModelTest()
	//	{
		//	OutputModel outMod = new OutputModel();
		//	outMod.OutputInt = 42;
		//	outMod.OtherInt = 1337;
		//	return outMod;
	//	}
	
	
	public ServerAllocation[] getServerAllocationTest()
	{
		ServerAllocation[] serverAllocation = new ServerAllocation[5];	
		
		serverAllocation[0] = new ServerAllocation(0, 0, 1, 0, 42);
		serverAllocation[1] = new ServerAllocation(1, 1, 0, 1, 42 );
		serverAllocation[2] = new ServerAllocation(2, 1, 3, 0, 42);
		serverAllocation[3] = new ServerAllocation(3, 0, 4, 1, 42);
		serverAllocation[4] = new ServerAllocation(4, -1, 42, 42, 42);
		
		return serverAllocation;
		
	}
	
	
}
