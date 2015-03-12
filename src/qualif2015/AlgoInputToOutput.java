package qualif2015;


public class AlgoInputToOutput {

	
	

	public static void main(String[] args) {
		
		AlgoInputToOutput algo = new AlgoInputToOutput();
		
		ProblemModel pbModTest = algo.getProblemModTestAlgo();
		
		algo.AlgoSimple(pbModTest);

	}
	
	public ProblemModel getProblemModTestAlgo()
	{
		ProblemModel res = new ProblemModel();
		res.intTest1 = 42;
		res.stringTest = "bbb";
		return res;
	}
	
	
	public OutputModel AlgoSimple(ProblemModel pbModel)
	{
		OutputModel res = new OutputModel();
		
		System.out.println("Demarrage Algo");
		
		// TODO CODER ICI LA LOGIQUE DE L'ALGO
		res.OutputInt = pbModel.intTest1;
		res.OtherInt = 31416;
		res.OutputString = pbModel.stringTest;
		
		return res;
	}
	
	
}
