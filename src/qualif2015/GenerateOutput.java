package qualif2015;

import java.io.PrintWriter;

public class GenerateOutput {

	
	public static void main(String[] args) {

		GenerateOutput go = new GenerateOutput();
		go.GenerateOutputFile();

	}


	public void GenerateOutputFile()
	{
		PrintWriter writer = CommonStatic.FU.CreateWriterFile(CommonStatic.OutputGeneratedPath, CommonStatic.OutputEncoding);
		if (writer != null)
		{
			writer.println("Test Generate Output");
			
			
			
			
			writer.close();
		}		
	}
	

	
}
