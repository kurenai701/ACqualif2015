package qualif2015;

import java.util.ArrayList;
import java.util.List;


/*
 *  OutputModel : classe Output
 *  @author : Clemence MEGE
 */
  
public class OutputModel {
	protected ServerAllocation serverAllocation[];
	
	
	
	int roomMap[][];//Row Column
	
	int continuousFreeSpace[][];//continuous free space after this
	
	int R;//number of Row
	int S;//number of columns
	
	ProblemModel pb;
	
	
	public OutputModel(ServerAllocation[] serverAllocation, int[][] roomMap,ProblemModel pb) {
		super();
		this.serverAllocation = serverAllocation;
		this.roomMap = roomMap.clone();
		this.pb = pb;
		
		R = roomMap.length;
		S = roomMap[0].length;
		
		continuousFreeSpace = new int[R][S];
		
		for(int curR = 0;curR< roomMap.length;curR++ )
		{
			updateLine(curR);
			
			
		}
	}
	
	public void updateServerAllocation( ServerAllocation myAlloc) //update model 
	{
		
		
		
		int curR =  serverAllocation[ myAlloc.serverNumber].Row;
		int curC =  serverAllocation[ myAlloc.serverNumber].Column;
		//int curG =  serverAllocation[ myAlloc.serverNumber].Group;
		
		int newR =  myAlloc.Row;
		int newC =   myAlloc.Column;
		
		
		int serverZ =  pb.serverList.get( myAlloc.serverNumber).Z;
		
		// ******************************
		System.out.println("Reallocating at " + myAlloc + " Server :" +  pb.serverList.get( myAlloc.serverNumber) );
		// ******************************
		
		
		//update in list
		serverAllocation[ myAlloc.serverNumber] = myAlloc;

		//Update roomMap
		
		for(int ii =0;ii<2;ii++)
		{
			int updatedR=-1;
			int updatedC=-1;
			switch(ii)
			{
				case 0:
					updatedR = curR;
					updatedC = curC;
					break;
				case 1:
					updatedR = newR;
					updatedC = newC;
					break;
					default:
			}
			
			if(updatedR>=0)
			{
				for( int jj = 0;jj< serverZ;jj++)
				{
					roomMap[updatedR][updatedC+jj] = ii;// clear or set
				}
			}
			
		}
		updateLine(curR);
		updateLine(newR);
		
		
		

	}	
	
	private void updateLine(int curR)//update continuousFreeSpace row
	{
		if(curR==-1)
		{
			return;
		}
		int curSpace=0;
		for(int curC = roomMap[0].length-1;curC>=0;curC-- )
		{
			if( roomMap[curR][curC]==0 )
			{
				curSpace++;
				
			}else
			{
				curSpace = 0;
			}
			this.continuousFreeSpace[curR][curC] =curSpace;
		}
	}
	
	
	int[][] computeScoreRow ()
	{
		//Get score per row
		int scoreRow[][] = new int[pb.P][pb.R];//power per Group per Row
		for(ServerAllocation curAlloc :serverAllocation)
		{
			if(curAlloc.Row>=0)
			{
				scoreRow[curAlloc.Group][curAlloc.Row] += pb.serverList.get(  curAlloc.serverNumber ).C;
			}
		}
	 return 	scoreRow;
	}
	
	
	ScoreInfo getScoreModel()
	{
		//Return the score of current model
		
		int lowestScore = Integer.MAX_VALUE;
		
		//Get score per row
		int scoreRow[][] = computeScoreRow();
		
		int scoreGroup[] = new int[pb.P];
		
		int bestRowByGroup[] = new int[pb.P];
		
		for(int curG = 0;curG<pb.P;curG++ )
		{
			scoreGroup[curG] = 0;
			int highestRow = 0;
			for(int curR = 0; curR< pb.R;curR++)
			{
				scoreGroup[curG] =  scoreGroup[curG] + scoreRow[curG][curR];
				if(scoreRow[curG][curR] > highestRow)
				{
					highestRow = scoreRow[curG][curR];
					bestRowByGroup[curG]=curR;
				}
				
			}
			
			// Remove highest row capacity;
			scoreGroup[curG] = scoreGroup[curG] - highestRow;
			// update total score
			if(scoreGroup[curG] < lowestScore)
			{
				lowestScore = scoreGroup[curG];
			}
			
		}
		
		if(lowestScore == Integer.MAX_VALUE)
		{
			return new ScoreInfo(0, scoreGroup,bestRowByGroup);
		}
		
		
		return new ScoreInfo(lowestScore, scoreGroup,bestRowByGroup);
		
		
	}
	
	
	
	
	// mode mauvais esprit d'une Dev .NET ;-), il me manque LINQ pour faire �a en une ligne!
	public List<Server> getListServerInGroup(int groupNum)
	{		
		List<Server> servList = new ArrayList<Server>();
							
		for(ServerAllocation servAlloc: this.serverAllocation) {
		if (servAlloc.Group == groupNum);
			for (Server serv : this.pb.serverList)
			{
				if (serv.Number == servAlloc.serverNumber)
				{
					servList.add(serv);
				}
			}
		}
		
		return servList;
	}

	
}
