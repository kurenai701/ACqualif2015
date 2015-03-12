package qualif2015;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;



public class ReadInput {

	
	

	public static void main(String[] args) {
		
		ReadInput ri = new ReadInput();
		
		Scanner scanInput = ri.ScannerInputFileForUnitTest();
		ProblemModel pbMod = ri.ProcessReadInputToModel(scanInput);
		ri.ProcessInputModelToVerifFile(pbMod, CommonStatic.InputFileVerifPath);

	}
	
	public Scanner ScannerInputFile()
	{
		return CommonStatic.FU.ScannerFile(CommonStatic.InputFilePath);
	}
	
	public Scanner ScannerInputFileForUnitTest()
	{
		return CommonStatic.FU.ScannerFile(CommonStatic.InputFilePathUnitTest);
	}
			
	// From Input file to Input Model
	public ProblemModel ProcessReadInputToModel(Scanner scanInput)
	{	
		System.out.println("ProcessReadInputToModel");
		ProblemModel pbModel = null;//new ProblemModel();
		
		if (scanInput != null)
		{
			//  !!!!!!!!!!!!!!!!!!! //
			// TODO	CODE here parsing of file, and saving to model	
			//  !!!!!!!!!!!!!!!!!!! //
			
			
			int R = scanInput.nextInt();
			int S = scanInput.nextInt();
			int U = scanInput.nextInt();
			int P = scanInput.nextInt();
			int M = scanInput.nextInt();
			
			pbModel = new ProblemModel(R, S, U, P, M, null, null);
							
			//System.out.println(R + " " + S + " " + U + " " + P + " " + M);
			
			int ri;
			int si;
			
			
			// Parsing Unavailable			
			for (int uCounter = 1; uCounter <= U; uCounter++)
			{
				ri = scanInput.nextInt();
				si = scanInput.nextInt();
				
				System.out.println("rienfaitpourlemoment");
				System.out.println(ri + " " + si);
			}
			
			// Parsing SERVERS
			List<Server> servList = new ArrayList<Server>();			
			
			int zi; 
			int ci;
			Server serverI;
			for (int sCounter = 1; sCounter <= S; sCounter++)
			{				
				zi = scanInput.nextInt();
				ci = scanInput.nextInt();
				
				serverI = new Server(zi,ci);				
				System.out.println(zi + " " + ci);
				servList.add(serverI);
			}
			
			pbModel = new ProblemModel(R, S, U, P, M, null, servList);
				
			//  !!!!!!!!!!!!!!!!!!! //
		}	
		
		return pbModel;
	}
	
	
	
	// If time, and if we want to verify that we have correct modeling
	// From Input Model to Something same as Input Text File
	public void ProcessInputModelToVerifFile(ProblemModel pbModel, String FilePath)
	{
		System.out.println("ProcessModelToVerifFile");
		
		// Writer
		PrintWriter writer = CommonStatic.FU.CreateWriterFile(FilePath, "UTF-8");
		
		if (writer != null)
		{
			if (pbModel != null)
			{	
				//  !!!!!!!!!!!!!!!!!!! //
				// TODO CODE here processing to read the model and write the file
				//  !!!!!!!!!!!!!!!!!!! //

				
				writer.println("testingInputWriter");
		//		writer.println(pbModel.stringTest);	
		//		writer.println(pbModel.intTest1);
				
				//  !!!!!!!!!!!!!!!!!!! //
			}
			writer.close();
		}
	}
	
	
}

