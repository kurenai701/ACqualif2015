package qualif2015;

import java.util.Scanner;

public class FullProcess {

	
	

	public static void main(String[] args) {
	
		//// process input
		ReadInput ri = new ReadInput();
		Scanner scanInput = ri.ScannerInputFile();
		ProblemModel pbMod = ri.ProcessReadInputToModel(scanInput);
				
		ri.ProcessInputModelToVerifFile(pbMod, CommonStatic.InputFileVerifPath);
		
		//// Algorithm
		AlgoInputToOutput algo = new AlgoInputToOutput();
				OutputModel outMod = algo.AlgoSimple(pbMod);
		
		// GenerateOutputFile
		GenerateOutput genOut = new GenerateOutput();		
				genOut.GenerateOutputFileFromOutputModel(outMod);
			
			
				
		// To Verify Output correctly linked to Input				
		ReadOutput ro = new ReadOutput();
		Scanner scanOutput = ro.ScannerOutputFile();	
		ProblemModel pbModVerif = ro.ProcessReadOutputToInputModel(scanOutput);
				
		ri.ProcessInputModelToVerifFile(pbModVerif, CommonStatic.InputFileVerifPathFromOutputRead);	
		
		ro.EvaluateScoreFromOutput();
	}
	
}
