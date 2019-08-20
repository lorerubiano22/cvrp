import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class TestsManager{
	
	/******************************************************************************* 
     * MÉTODO PÚBLICO getTestsList()
     * Lee y guarda los tests 
     ******************************************************************************/	
	
    public static ArrayList<Test> getTestsList(String testsFilePath){   
	ArrayList<Test> list = new ArrayList<Test>();
        try{   
		 FileReader reader = new FileReader(testsFilePath);
            Scanner in = new Scanner(reader);
            in.useLocale(Locale.US);
            while(in.hasNextLine()){   
			String s = in.next();
                if(s.charAt(0) == '#') in.nextLine(); 
                else{   
                	String instanceName = s;
                    float maxRouteCosts = in.nextFloat(); 
                    float maxTime = in.nextFloat();
                    String distrib = in.next();
                    float firstParam = in.nextFloat();
                    float secondParam = in.nextFloat();
                    int seed = in.nextInt();
                    Test aTest = new Test(instanceName, maxRouteCosts, maxTime, distrib, firstParam, secondParam, seed);
                    list.add(aTest);}}
            in.close();}
        catch (IOException exception){   
		System.out.println("Error processing tests file: " + exception);}
        return list;}
}