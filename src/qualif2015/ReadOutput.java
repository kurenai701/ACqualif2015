package qualif2015;

import java.util.Scanner;

public class ReadOutput {	

	
	
	public static void main(String[] args) {
		
		ReadOutput ro = new ReadOutput();
		Scanner scanOutput = ro.ScannerOutputFile();
		scanOutput.hashCode();
			}
	
	public Scanner ScannerOutputFile()
	{
		return CommonStatic.FU.ScannerFile(CommonStatic.OutputTestFilePath);
	}
	
	
	// If there is a simple way to obtain a "score from the Generated outputFile"
	public int EvaluateScoreFromOutput()
	{
		int score = -42;
		
		return score;
	}
	


	
}
