package qualif2015;

public class Server implements Comparable<Server> {

	int Z;//size
	int C;//capacity
	public Server(int z, int c) {
		super();
		Z = z;
		C = c;
	}
	
	
	
	@Override
	public int compareTo(Server a) {
		if(this.C> a.C)// more capacity is better
		{
			return 1;
		}
		if(this.C< a.C)
		{
			return -1;
		}
		
		if(this.Z< a.Z)// smaller  is better
		{
			return 1;
		}
		
		if(this.Z> a.Z)// smaller  is better
		{
			return -1;
		}
		return 0;
		
		
	}
	
	
	
	
	
	
}
