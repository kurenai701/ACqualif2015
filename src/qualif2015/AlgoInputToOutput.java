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
		
		
		//Round Robin Row allocation, random group allocation;
		int curGroup=0;
		int curRow=0;
		int lastRow=0;
		int nAllocated = 0;
		for(Server curServ : sortedServerList )
		{
			curRow = (curRow+1)% pbModel.R;
			while(curRow!=lastRow)
			{
				//Try to fit server is room row
				int pos = firstFitPosition( curServ.Z, curRow, res);
				if(pos>=0)
				{
					ServerAllocation myAlloc=new ServerAllocation(curServ.Number, curRow, pos, curGroup);
					res.updateServerAllocation(  myAlloc);
					nAllocated++;
					break;//get out while loop
				}
				curRow = (curRow+1)% pbModel.R;
			}
			lastRow = curRow;
			curGroup = randi(0,pbModel.P-1, rand);
			
		}
		System.out.println(""+nAllocated+" servers allocated");
		
		
		System.out.println("Finished simple algo");
		
		
		
		OutputModel resopt = optimizeAlloc( res);
		
		// Now Call server allocation to group optimization
		
		
		return resopt;
	}
	
	
	
	
	public OutputModel   optimizeAlloc(OutputModel resInitial)
	{
//		// Optimize the server allocation to groups
//		GroupAlloc initialGroupAlloc[] = new GroupAlloc[pbModel.P];
//		
//		for(int curG=0;curG<pbModel.P;curG++)
//		{
//			initialGroupAlloc[curG] = new GroupAlloc( new ArrayList<Server>(),pbModel);
//		}
//
//		
//		for(ServerAllocation curAlloc:  resInitial.serverAllocation)
//		{
//			
//			(initialGroupAlloc[curAlloc.Group]).allocatedServers.add(   pbModel.serverList.get(curAlloc.serverNumber)   );
//		}
		
		ServerAllocation bestResult[] = resInitial.serverAllocation.clone();
		
		
		int Nit = 100;
		for(int itc = 0;itc<Nit;itc++)
		{
			optimize(resInitial);
		}
		
		
		
		
		//resInitial.serverAllocation =bestResult;
		
		
		// initialGroupAlloc contains the servers allocated to each group.
		return resInitial;
		
		
	
	}
	
	
	public void optimize(OutputModel res)
	{
	//Take to the rich, give to the poor
		ScoreInfo curScore = res.getScoreModel();
		System.out.println( "" +curScore.score);
		
		int bestScore = 0;
		int bestG = -1;
		int minScore  = Integer.MAX_VALUE;
		int minG = -1;
		
		for(int curG = 0;curG<res.pb.P;curG++)
		{
			int curS = curScore.scoreByGroup[curG];
			if(curS> bestScore)
			{
				bestScore = curS;
				bestG = curG;
			}
			if(curS< minScore)
			{
				minScore = curS;
				minG = curG;
			}
		}
		
		// Select one server and exchange it
		ServerAllocation token = getServerFromGroup(res,bestG,curScore);// a optimiser
		transferFromTo(res, bestG,minG, token);
	
		
		
	}
	
	public void transferFromTo(OutputModel res, int bestG,int minG,ServerAllocation token)
	{
		token.Group = minG;
	}
	
	
	
  public ServerAllocation getServerFromGroup(OutputModel res,int bestG, ScoreInfo curScore)
  {
	  
	  // extract the least problematic server from the group: the lowest capacity server from the best score row
	  int bestRow = curScore.bestRowByGroup[bestG];
	  
	  ServerAllocation candidate = null;
	  for(ServerAllocation curAlloc : res.serverAllocation)
	  {
		  
		  if(curAlloc.Group == bestG   && curAlloc.Row == bestRow)
		  {
			  if( candidate == null ||  res.pb.serverList.get(  curAlloc.serverNumber).C <   res.pb.serverList.get(  candidate.serverNumber).C    )
			  {
				  candidate = curAlloc;
			  }
		  }
		  
		  
		  
	  }
	  return candidate;
	  
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
