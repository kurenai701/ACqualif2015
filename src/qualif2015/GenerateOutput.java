package qualif2015;

import java.io.PrintWriter;
import java.util.Scanner;

public class GenerateOutput {

	
	public static void main(String[] args) {

		GenerateOutput go = new GenerateOutput();
		MockTestGenerator mock = new MockTestGenerator();
		
		ReadInput ri = new ReadInput();
		
		Scanner scanInput = ri.ScannerInputFileForUnitTest();
		ProblemModel pbMod = ri.ProcessReadInputToModel(scanInput);
		
		// Obtain output model.
	
		ServerAllocation[] serverAllocation = mock.getServerAllocationTest();
		int[][] roomMapInProgress = new int[2][5];
				
		OutputModel outModTest = new OutputModel(serverAllocation, roomMapInProgress, pbMod);	
		go.GenerateOutputFileFromOutputModel(outModTest, CommonStatic.OutputGeneratedPathUnitTest);
	}	

	public void GenerateOutputFileFromOutputModel(OutputModel outModel, String filePath)
	{
		System.out.println("GenerateOutputFileFromOutputModel");
		if (outModel == null)
		{
			System.out.println("outModel null");
		}
		else
		{
			PrintWriter writer = CommonStatic.FU.CreateWriterFile(CommonStatic.OutputGeneratedPathUnitTest, CommonStatic.OutputEncoding);
			if (writer != null)
			{
				//  !!!!!!!!!!!!!!!!!!! //
				// TODO CODE HERE Output Generation Logic
				//  !!!!!!!!!!!!!!!!!!! //
				writer.println("Test Generate Output");
				

				int row;
				int col;
				int group;
				
				for (int ss = 0; ss < outModel.serverAllocation.length; ss++)
				{			
					row = outModel.serverAllocation[ss].Row;
					col = outModel.serverAllocation[ss].Column;
					group = outModel.serverAllocation[ss].Group;
					
					if (row == -1)
					{
						System.out.println("x");
						writer.println("x");
					}
					else
					{
						System.out.println(row + " " + col + " " + group);
						writer.println(row + " " + col + " " + group);	
					}
				}
				//  !!!!!!!!!!!!!!!!!!! //
				
				writer.close();
			}		
		}
	}
	

	
}
