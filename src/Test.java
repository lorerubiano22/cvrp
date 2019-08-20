/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class Test{
	
    /*******************************************************************************
    * Variables de instancia 
    ******************************************************************************/
	
    private String instanceName, distrib;
    private float maxRouteCosts, maxTime, firstParam, secondParam;
    private int seed; 
 
    /*******************************************************************************
     * Constructor 
     ******************************************************************************/
    
    public Test(String name, float rCosts, float t, String d, float p1, float p2, int s){
        instanceName = name; distrib = d;
        maxRouteCosts = rCosts; maxTime = t; firstParam = p1; secondParam = p2;
        seed = s;}

    /*******************************************************************************
     * Getters y Setters 
     ******************************************************************************/
    
    public String getInstanceName(){return instanceName;}
    
    public float getMaxRouteCosts(){return maxRouteCosts;}
    
    public float getMaxTime(){return maxTime;}
    
    public String getDistribution(){return distrib;}
    
    public float getFirstParam(){return firstParam;}
    
    public float getSecondParam(){return secondParam;}
    
    public int getSeed(){return seed;}
}