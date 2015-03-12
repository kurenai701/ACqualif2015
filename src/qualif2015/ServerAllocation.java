package qualif2015;

public class ServerAllocation {
	int serverNumber;
	int Row;
	int Column;
	int Group;// set to -1 if not used
	
	
	public ServerAllocation(int serverNumber, int row, int column, int group) {
		super();
		this.serverNumber = serverNumber;
		Row = row;
		Column = column;
		Group = group;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " number : " + serverNumber + " Row:" + Row + " Col:" + Column + " Group:" + Group ;
	}

}
