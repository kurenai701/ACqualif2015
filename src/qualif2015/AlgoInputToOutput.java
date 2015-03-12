package qualif2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class AlgoInputToOutput {

	
	

//	public static void main(String[] args) {
//		
//		AlgoInputToOutput algo = new AlgoInputToOutput();
//		MockTestGenerator mock = new MockTestGenerator();
//		
//		ProblemModel pbModTest = mock.getProblemModTestAlgo();		
//		algo.AlgoSimple(pbModTest);
//
//	}	
	
	public void   optimizeAlloc(ProblemModel pbModel)
	{
		// Optimize the server allocation to groups
		
		
		
		
		
	
	}
	
	
	
	
	
	
	public OutputModel AlgoSimple(ProblemModel pbModel)
	{
		System.out.println("Starting simple algo");
		ServerAllocation servA[] = new ServerAllocation[pbModel.M];
		for(int ii =0;ii<pbModel.M;ii++ )
		{
			servA[ii] = new ServerAllocation(ii+1, -1, -1, -1);
		}
		
		OutputModel res = new OutputModel(servA, pbModel.roomMap, pbModel);
		 
		Random rand = new Random(42+12);
		
		System.out.println("Demarrage Algo");
		
		// Sort server List 
		List<Server> sortedServerList = new ArrayList<Server>(pbModel.serverList);
		Collections.sort(sortedServerList,Collections.reverseOrder());//: inline sort, Higher score to lower score!
		
		
		//Round Robin Group and Row allocation;
		int curGroup=0;
		int curRow=0;
		for(Server curServ : sortedServerList )
		{
			//Try to fit server is room Line
			int pos = firstFitPosition( curServ.Z, curRow, res);
			if(pos>=0)
			{
				ServerAllocation myAlloc=new ServerAllocation(curServ.Number, curRow, pos, curGroup);
				res.updateServerAllocation(  myAlloc);
			}
			curRow = (curRow+1)% pbModel.R;
			curGroup = randi(0,pbModel.P-1, rand);
			
		}
		
		
		
		System.out.println("Finished simple algo");
		return res;
	}
	
	public static int randi(int min,int max, Random rand)
	{
		return  rand.nextInt(max - min + 1) + min;
	}
	
	
	
	int firstFitPosition(int size, int row, OutputModel outp)
	{
		//Return fit position for the server of size size at row row
		
		for(int curC =0;curC<outp.S;curC++)
		{
			if( outp.continuousFreeSpace[row][curC]>=size  )
			{
				return curC;
			}
			
		}
		return -1;
		
		
	}
	
	
	
	
	
}
