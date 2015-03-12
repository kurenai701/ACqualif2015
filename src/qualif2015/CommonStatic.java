package qualif2015;

public class CommonStatic {

	// FileUtil
	public static final FileUtil FU = new FileUtil();
	
	public static final String QualifFilesFolderPath = "C:\\ACQualifFile\\";
	
	// ZIP
	public static final String OUTPUT_ZIP_FILE = QualifFilesFolderPath+"FolderSourceMEGEClemAlex.zip"; 
	//  /!\ Folder ClemJava pour mes sources
	public static final String SOURCE_FOLDER = "C:\\ClemJava\\HC2015\\ACqualif2015\\src";

	
	// INPUT
	public static final String InputFilePath = QualifFilesFolderPath+"dc.in";
	// public static final String InputFilePathUnitTest =  QualifFilesFolderPath+"UNITTESTINPUT.txt";
	public static final String InputFilePathUnitTest =  QualifFilesFolderPath+"dc.in";
	
	
	
	public static final String InputFileVerifPath = QualifFilesFolderPath+"verifInputFromInputModel.txt";
	
	public static final String InputEncoding = "UTF-8";
	
	//Input of Full processing GeneratedFromOutput
	public static final String InputFileVerifPathFromOutputRead = QualifFilesFolderPath+"verifInputFromOutput.txt";
	
	
	// OUTPUT
	
	public static final String OutputGeneratedPathUnitTest = QualifFilesFolderPath+"UNITTESTOutputGenerated.txt";
	
	public static final String OutputGeneratedPath = QualifFilesFolderPath+"OutputGenerated.txt"; 	
	public static final String OutputEncoding = "UTF-8";
	
	
	// quand on aura généré le output generated, et qu'on veut le tester
	public static final String OutputTestFilePath = QualifFilesFolderPath+"TESTEXEMPLEOUTPUT.txt";
	//public static final String OutputTestFilePath = QualifFilesFolderPath+"OutputGenerated.txt";
	
	public static final String OutputTestFilePathUnitTest= QualifFilesFolderPath+"TESTEXEMPLEOUTPUT.txt";
	
	
	
	
}
