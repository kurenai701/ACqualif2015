package qualif2015;

import java.io.PrintWriter;

public class GenerateOutput {

	
	public static void main(String[] args) {

		GenerateOutput go = new GenerateOutput();
		
		// Obtain output model.
	
		OutputModel outModTest = go.getOutputModelTest();
		go.GenerateOutputFileFromOutputModel(outModTest);
	}

	
	public OutputModel getOutputModelTest()
	{
		OutputModel outMod = new OutputModel();
		outMod.OutputInt = 42;
		outMod.OtherInt = 1337;
		return outMod;
	}

	public void GenerateOutputFileFromOutputModel(OutputModel outModel)
	{
		System.out.println("GenerateOutputFileFromOutputModel");
	

		if (outModel == null)
		{
			System.out.println("outModel null");
		}
		else
		{
			PrintWriter writer = CommonStatic.FU.CreateWriterFile(CommonStatic.OutputGeneratedPath, CommonStatic.OutputEncoding);
			if (writer != null)
			{
				// CODE HERE Output Generation Logic
				writer.println("Test Generate Output");
				writer.println(outModel.OutputInt);
				writer.println(outModel.OtherInt);
				
				writer.close();
			}		
		}
	}
	

	
}
