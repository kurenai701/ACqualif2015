package qualif2015;



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
		this.roomMap = roomMap;
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
					roomMap[updatedR][updatedC] = ii;// clear or set
				}
				updateLine(curR);
				
			
			}
			
		}
		
		
		

	}	
	
	private void updateLine(int curR)//update continuousFreeSpace row
	{
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
	
	
	
}
