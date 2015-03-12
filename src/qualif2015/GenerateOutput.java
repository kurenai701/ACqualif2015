package qualif2015;

import java.io.PrintWriter;

public class GenerateOutput {

	
	public static void main(String[] args) {

		GenerateOutput go = new GenerateOutput();
		MockTestGenerator mock = new MockTestGenerator();
		
		// Obtain output model.
	
		OutputModel outModTest = mock.getOutputModelTest();
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
				writer.println(outModel.OutputInt);
				writer.println(outModel.OtherInt);
				
				//  !!!!!!!!!!!!!!!!!!! //
				
				writer.close();
			}		
		}
	}
	

	
}
