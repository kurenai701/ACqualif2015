package qualif2015;

import java.util.Scanner;
import java.io.PrintWriter;



public class ReadInput {

	
	

	public static void main(String[] args) {
		
		ReadInput ri = new ReadInput();
		
		Scanner scanInput = ri.ScannerInputFile();
		ProblemModel pbMod = ri.ProcessReadInputToModel(scanInput);
		ri.ProcessInputModelToVerifFile(pbMod);

	}
	
	public Scanner ScannerInputFile()
	{
		return CommonStatic.FU.ScannerFile(CommonStatic.InputFilePath);
	}
			
	// From Input file to Input Model
	public ProblemModel ProcessReadInputToModel(Scanner scanInput)
	{	
		System.out.println("ProcessReadInputToModel");
		ProblemModel pbModel = new ProblemModel();
		
		if (scanInput != null)
		{
			// TODO	CODE here parsing of file, and saving to model		
			pbModel.stringTest = scanInput.next();
			pbModel.intTest1 = 42;
		}	
		
		return pbModel;
	}
	
	
	
	// If time, and if we want to verify that we have correct modeling
	// From Input Model to Something same as Input Text File
	public void ProcessInputModelToVerifFile(ProblemModel pbModel)
	{
		System.out.println("ProcessModelToVerifFile");
		
		// Writer
		PrintWriter writer = CommonStatic.FU.CreateWriterFile(CommonStatic.InputFileVerifPath, "UTF-8");
		
		if (writer != null)
		{
			if (pbModel != null)
			{	// TODO CODE here processing to read the model and write the file
				writer.println("testingInputWriter");
				writer.println(pbModel.stringTest);	
				writer.println(pbModel.intTest1);
			}
			writer.close();
		}
	}
	
	
}

