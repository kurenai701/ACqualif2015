package qualif2015;

import java.util.Scanner;
import java.io.PrintWriter;



public class ReadInput {

	
	public static String InputFilePath = "C:\\ACQualifFile\\test.txt";
	public static String InputFileVerifPath = "C:\\ACQualifFile\\verifInput.txt";
	public static FileUtil Fu = new FileUtil();

	public static void main(String[] args) {
		
		ReadInput ri = new ReadInput();
		
		Scanner scanInput = ri.ScannerInputFile();
		ProblemModel pbMod = ri.ProcessReadInputToModel(scanInput);
		ri.ProcessModelToVerifFile(pbMod);

	}
	
	public Scanner ScannerInputFile()
	{
		//FileUtil fu = new FileUtil();		
		return Fu.ScannerFile(InputFilePath);
	}
			
	
	public ProblemModel ProcessReadInputToModel(Scanner scanInput)
	{	
		ProblemModel pbModel = new ProblemModel();
		
		if (scanInput != null)
		{
			pbModel.stringTest = scanInput.next();			
		}	
		
		return pbModel;
	}
	
	public void ProcessModelToVerifFile(ProblemModel pbModel)
	{
		// Writer
		PrintWriter writer = Fu.CreateWriterFile(InputFileVerifPath, "UTF-8");
		writer.println("test writer");
		
		if (pbModel != null)
		{
			writer.println(pbModel.stringTest);
		}
		writer.close();
	}
	
	
}

