package qualif2015;

import java.util.List;


/*
 *  ProblemModel : For Modeling the HashCode Problem
 *  
 */
public class ProblemModel {

	
	int R;//R​(1 ≤ R ≤ 1000) ​: le nombre de rangées du centre de données,
	int S;//​(1 ≤ S ≤ 1000) : le nombre d'emplacements de chaque rangée du centre de données,
	int U;//​(0 ≤ U ≤ R × S) : le nombre d'emplacements indisponibles,
	int P;//​(1 ≤ P ≤ 1000) : le nombre de groupes à créer,
	int M;//​(1
	
	int roomMap[][];//Row Column
	
	List<Server> serverList;

	public ProblemModel(int r, int s, int u, int p, int m, int[][] roomMap,List<Server> serverList) {
		super();
		R = r;
		S = s;
		U = u;
		P = p;
		M = m;
		this.roomMap = roomMap;
		this.serverList=serverList;
	}
	
	
	
	
	
	
	
}
