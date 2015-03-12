package qualif2015;


public class AlgoInputToOutput {

	
	

	public static void main(String[] args) {
		
		AlgoInputToOutput algo = new AlgoInputToOutput();
		MockTestGenerator mock = new MockTestGenerator();
		
		ProblemModel pbModTest = mock.getProblemModTestAlgo();		
		algo.AlgoSimple(pbModTest);

	}	
	
	
	public OutputModel AlgoSimple(ProblemModel pbModel)
	{
		OutputModel res = new OutputModel();
		
		System.out.println("Demarrage Algo");
		
		//  !!!!!!!!!!!!!!!!!!! //
		// TODO CODER ICI LA LOGIQUE DE L'ALGO
		//  !!!!!!!!!!!!!!!!!!! //
		
		res.OutputInt = pbModel.intTest1;
		res.OtherInt = 31416;
		res.OutputString = pbModel.stringTest;
		
		//  !!!!!!!!!!!!!!!!!!! // FIN LOGIQUE ALGO
		
		return res;
	}
	
	
}
