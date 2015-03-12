package qualif2015;

public class ServerAllocation implements Comparable<ServerAllocation> {
	int serverNumber;
	int serverCapacity;
	int Row;
	int Column;
	int Group;// set to -1 if not used
	
	
	public ServerAllocation(int serverNumber, int row, int column, int group,int serverCapacity) {
		super();
		this.serverNumber = serverNumber;
		Row = row;
		Column = column;
		Group = group;
		this.serverCapacity = serverCapacity;
	}
	
	public ServerAllocation(ServerAllocation s) {
		super();
		this.serverNumber = s.serverNumber;
		Row = s.Row;
		Column = s.Column;
		Group = s.Group;
		this.serverCapacity = s.serverCapacity;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " number : " + serverNumber + " Row:" + Row + " Col:" + Column + " Group:" + Group ;
	}

	@Override
	public int compareTo(ServerAllocation o) {
		return ((Integer)serverCapacity).compareTo(    (o.serverCapacity));
	}

}
