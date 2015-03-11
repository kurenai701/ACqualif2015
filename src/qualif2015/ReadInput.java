package qualif2015;

import java.util.Scanner;
import java.io.PrintWriter;



public class ReadInput {

	
	

	public static void main(String[] args) {
		
		ReadInput ri = new ReadInput();
		
		Scanner scanInput = ri.ScannerInputFile();
		ProblemModel pbMod = ri.ProcessReadInputToModel(scanInput);
		ri.ProcessModelToVerifFile(pbMod);

	}
	
	public Scanner ScannerInputFile()
	{
		return CommonStatic.FU.ScannerFile(CommonStatic.InputFilePath);
	}
			
	// From Input file to Input Model
	public ProblemModel ProcessReadInputToModel(Scanner scanInput)
	{	
		ProblemModel pbModel = new ProblemModel();
		
		if (scanInput != null)
		{
			// 	CODE here parsing of file, and saving to model		
			pbModel.stringTest = scanInput.next();			
		}	
		
		return pbModel;
	}
	
	
	
	// If we want to verify that we have correct modeling
	// From Input Model to Something same as Input Text File
	public void ProcessModelToVerifFile(ProblemModel pbModel)
	{
		// Writer
		PrintWriter writer = CommonStatic.FU.CreateWriterFile(CommonStatic.InputFileVerifPath, "UTF-8");
		
		if (writer != null)
		{
			if (pbModel != null)
			{
			
				
				// CODE here processing to read the model and write the file
				writer.println(pbModel.stringTest);
				
			}
			writer.close();
		}
	}
	
	
}

