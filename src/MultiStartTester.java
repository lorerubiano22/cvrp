import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class MultiStartTester{
	
    /*******************************************************************************
    * Variables de instancia 
    ******************************************************************************/
	
    final static String inputFolder = "inputs";
    final static String outputFolder = "outputs";
    final static String testFolder = "tests";
    final static String fileNameTest = "test2run.txt";
    final static String sufixFileNodes = "_input_nodes.txt";
    final static String sufixFileVehicules = "_input_vehicles.txt";
    
	/******************************************************************************* 
     * MÉTODO PÚBLICO main()
     ******************************************************************************/
    
    public static void main( String[] args ){
        System.out.println("* Starting *");
        String testsFilePath = testFolder + File.separator + fileNameTest;
        System.out.println(testsFilePath);
        ArrayList<Test> testsList = TestsManager.getTestsList(testsFilePath);
        int nTests = testsList.size();
        System.out.println("Number of tests " +nTests);
        for( int k = 0; k < nTests; k++ ){   
        	Test aTest = testsList.get(k);
            System.out.println("\n# Test " + (k + 1) + " of " + nTests);
            String inputNodesPath = inputFolder + File.separator + aTest.getInstanceName() + sufixFileNodes;
            String inputVehPath = inputFolder + File.separator + aTest.getInstanceName() + sufixFileVehicules;
            Inputs inputs = InputsManager.readInputs(inputNodesPath, inputVehPath);
            InputsManager.generateDepotEdges(inputs);
            InputsManager.generateSavingsList(inputs);
            Random rng = new Random(aTest.getSeed());
            MultiStart algorithm = new MultiStart(aTest, inputs, rng);
            Outputs output = algorithm.solve();
            String outputsFilePath = outputFolder + File.separator + aTest.getInstanceName() + 
            		"_" + aTest.getDistribution() + "_" + aTest.getFirstParam() + "_" + aTest.getSecondParam()
            		+ "_" + aTest.getSeed() +"_" + aTest.getMaxTime()  + ".txt";
            output.sendToFile(outputsFilePath);}
        	System.out.println("\n* End *");}}