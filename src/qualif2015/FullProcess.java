package qualif2015;

import java.util.Scanner;

public class FullProcess {

	
	

	public static void main(String[] args) {
	
		//// process input
		ReadInput ri = new ReadInput();
		Scanner scanInput = ri.ScannerInputFile();
		ProblemModel pbMod = ri.ProcessReadInputToModel(scanInput);
				
		ri.ProcessInputModelToVerifFile(pbMod);
		
		//// Algorithm
		AlgoInputToOutput algo = new AlgoInputToOutput();
				OutputModel outMod = algo.AlgoSimple(pbMod);
		
		// GenerateOutputFile
		GenerateOutput genOut = new GenerateOutput();		
				genOut.GenerateOutputFileFromOutputModel(outMod);
			
				
	}
	
}
