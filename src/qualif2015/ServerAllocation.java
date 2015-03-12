package qualif2015;

public class ServerAllocation {
	int serverNumber;
	public ServerAllocation(int serverNumber, int row, int column, int group) {
		super();
		this.serverNumber = serverNumber;
		Row = row;
		Column = column;
		Group = group;
	}
	int Row;
	int Column;
	int Group;// set to -1 if not used
	

}
