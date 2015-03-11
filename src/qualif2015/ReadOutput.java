package qualif2015;

import java.util.Scanner;

public class ReadOutput {	

	public static String OutputTestFilePath = "C:\\ACQualifFile\\OutputTest.txt";

	public static void main(String[] args) {
		
		ReadOutput ro = new ReadOutput();
		Scanner scanOutput = ro.ScannerOutputFile();
		scanOutput.hashCode();
			}
	
	public Scanner ScannerOutputFile()
	{
		FileUtil fu = new FileUtil();		
		return fu.ScannerFile(OutputTestFilePath);
	}
	
	

	
}
