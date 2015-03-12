package qualif2015;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



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
			
			
			
			// Parsing Unavailable spaces	
			

			int buildRoomMap[][] = new int[R][S]; // 0 emplacements libres. on mettra des -1 pour unavailable					
			int ri;
			int si;
						
			for (int uCounter = 1; uCounter <= U; uCounter++)
			{
				ri = scanInput.nextInt();
				si = scanInput.nextInt();
				
				buildRoomMap[ri][si] = -1;								
			}
			
			// Parsing SERVERS
			List<Server> servList = new ArrayList<Server>();			
			
			int zi; 
			int ci;
			Server serverI;
			for (int mCounter = 0; mCounter < M; mCounter++)
			{				
				zi = scanInput.nextInt();
				ci = scanInput.nextInt();
				
				serverI = new Server(mCounter,zi,ci);				
				System.out.println(zi + " " + ci);
				servList.add(serverI);
			}
			
			pbModel = new ProblemModel(R, S, U, P, M, buildRoomMap, servList);
				
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
				
				// write first line
				writer.println(pbModel.R + " " + pbModel.S + " " + pbModel.U + " " + pbModel.P + " " + pbModel.M);
				
				// write unavailable
				// mauvais esprit ;-) : would have been easier in C# using LINQ and Lambda !
				
				// print matrix, and write  liste of unavailable
				// list of unavailable
				for (int ii = 0; ii < pbModel.roomMap.length; ii++)
				{
					for (int jj = 0; jj < pbModel.roomMap[0].length; jj++)
					{						
						if (pbModel.roomMap[ii][jj] == -1)
						{	
							writer.println(ii + " " + jj);
						}
					}					
				}			
				
				// write list of server
			    
			    for(final Server serv: pbModel.serverList) {
			    	writer.println(serv.Z + " " + serv.C);
			    }				
				//  !!!!!!!!!!!!!!!!!!! //
			}
			writer.close();
		}
	}
	
	
}

