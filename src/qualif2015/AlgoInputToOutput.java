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
			servA[ii] = new ServerAllocation(ii+1, -1, -1, -1,0);
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
					ServerAllocation myAlloc=new ServerAllocation(curServ.Number, curRow, pos, curGroup, pbModel.serverList.get(curServ.Number).C );
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
		
		
		
		OutputModel resopt = optimizeAlloc( res,rand);
		
		// Now Call server allocation to group optimization
		
		
		return resopt;
	}
	
	
	
	
	public OutputModel   optimizeAlloc(OutputModel resInitial,Random rand)
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
		
		ServerAllocation bestResult[] = new ServerAllocation[ resInitial.serverAllocation.length];
		
		for(int ii = 0;ii<bestResult.length;ii++ )
		{
			bestResult[ii] = new ServerAllocation(resInitial.serverAllocation[ii]);
		}
		
		ScoreInfo curScore = resInitial.getScoreModel();
		int bestScore = curScore.score;
		
		int Nit = 500000;
		int ThresholdKeep = 50;// probability to stay at best result
		int ThresholdNotBest = 970;
		for(int itc = 0;itc<Nit;itc++)
		{
			optimize(resInitial,ThresholdNotBest,rand);
			
			curScore = resInitial.getScoreModel();
			if(curScore.score>bestScore)
			{
				bestScore=curScore.score;
				for(int ii = 0;ii<bestResult.length;ii++ )
				{
					bestResult[ii] = new ServerAllocation(resInitial.serverAllocation[ii]);
				}

			}else
			{
				if(randi(0,1000,rand)<ThresholdKeep)
				{
				
					
					for(int ii = 0;ii<bestResult.length;ii++ )
					{
						resInitial.serverAllocation[ii] = new ServerAllocation(bestResult[ii]);
					}
					
				}
				
			}
			
		}
		
		
		
		for(int ii = 0;ii<bestResult.length;ii++ )
		{
			resInitial.serverAllocation[ii] = new ServerAllocation(bestResult[ii]);
		}
		
		
		// initialGroupAlloc contains the servers allocated to each group.
		return resInitial;
		
		
	
	}
	
	
	public void optimize(OutputModel res,int Threshold,Random rand)
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
		if(randi(0,1000,rand)>950)
		{
			bestG = randi(0,res.pb.P-1,rand);
		}
		
		
		ServerAllocation token = getServerFromGroup(res,bestG,curScore, rand, Threshold);// a optimiser
		transferFromTo(res, bestG,minG, token);
	
		
		
	}
	
	public void transferFromTo(OutputModel res, int bestG,int minG,ServerAllocation token)
	{
		token.Group = minG;
	}
	
	
	
  public ServerAllocation getServerFromGroup(OutputModel res,int bestG, ScoreInfo curScore, Random rand, int Threshold)
  {
	  
	  // extract the least problematic server from the group: the lowest capacity server from the best score row
	  int bestRow = curScore.bestRowByGroup[bestG];
	  
	  List<ServerAllocation> candidateList = new ArrayList<ServerAllocation>();
	  for(ServerAllocation curAlloc : res.serverAllocation)
	  {
		  
		  if(curAlloc.Group == bestG   && curAlloc.Row == bestRow)
		  {
			  candidateList.add(curAlloc);
		  }
		  
		
	  }
	  
	  Collections.sort(candidateList);//: inline sort, lower size to higher size
	  
	  
	  int index = 0;
	  if(randi(0,1000,rand)>Threshold )
	  {
		  index = randi(0,(int)Math.floor((candidateList.size()-1)/2),rand );
	  }
	  
	  
	  return candidateList.get(index);
	  
	  
	  
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
