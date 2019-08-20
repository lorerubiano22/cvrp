import java.io.IOException;
import java.io.PrintWriter;

/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class Outputs{
	
    /*******************************************************************************
    * Variables de instancia 
    ******************************************************************************/
	
    private Solution cwsSolution;
    private Solution bestSol;

    /*******************************************************************************
     * Constructor 
     ******************************************************************************/
    
    public Outputs(){   
	   cwsSolution = null;
       bestSol = null;}

    /*******************************************************************************
     * Getters y Setters 
     ******************************************************************************/
    
    public Solution getCWSSol(){return cwsSolution;}
    public Solution getOBSol(){return bestSol;}
    public void setCWSSol(Solution cwsSol){cwsSolution = cwsSol;}
    public void setOBSol(Solution obSol){bestSol = obSol;}
    
	/******************************************************************************* 
     * MÉTODO PÚBLICO sendToFile()
     * Guarda en un documento las soluciones
     ******************************************************************************/
    
    public void sendToFile(String outFile){
        try{   
		 PrintWriter out = new PrintWriter(outFile);
            out.println("CWS Sol");
            out.println("------------------------");
            out.println(cwsSolution.toString() + "\r\n");
            out.println("-------------------------\r\n");
            out.println("RCWS Sol:\r\n");
            out.println("-------------------------");
            out.println(bestSol.toString() + "\r\n");
            out.close();} 
        catch (IOException exception){   
        	System.out.println("Error processing output file: " + exception);}}}