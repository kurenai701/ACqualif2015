package qualif2015;

public class Server implements Comparable<Server> {
	int Number;
	int Z;//size
	int C;//capacity
	public Server(int number,int z, int c) {
		super();
		Number = number;// commence à 1
		Z = z;
		C = c;
	}
	
	
	
	@Override
	public int compareTo(Server a) {
		double thisScore = (this.C)/(double)(this.Z);
		double aScore = (a.C)/(double)(a.Z);
		
		
		if(thisScore> aScore)// more capacity is better
		{
			return 1;
		}
		if(thisScore< aScore)
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
	
	@Override
	public String toString() {
		
		return 	"N:"+Number+" Z:"+Z+" C:"+ C;
	}
	
	
	
	
}
