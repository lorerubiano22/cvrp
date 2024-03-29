import java.util.LinkedList;

/**********************************************************************************
* Implementaci�n de un algoritmo Multi-Start para resolver el CVRP. 
*
* M�ster en Ingenier�a Computacional y Matem�tica
* Optimizaci�n Combinatoria
**********************************************************************************/

public class Inputs{
	
    /*******************************************************************************
    * Variables de instancia 
    ******************************************************************************/
	
    private Node[] nodes; // Conjunto de nodos, incluyendo el depot
    private float vCap = 0.0F; // Capacidad m�xima de los veh�culos
    private LinkedList<Edge> savings = null; // Lista de savings
   
    /*******************************************************************************
     * Constructor 
     ******************************************************************************/
    
    public Inputs(int n){   
	   nodes = new Node[n];}

    /*******************************************************************************
     * Getters y Setters 
     ******************************************************************************/
    
    public Node[] getNodes(){return nodes;}
    
    public LinkedList<Edge> getSavings(){return savings;}
    
    public float getVehCap(){return vCap;}

    public void setVehCap(float c){vCap = c;}
    
    public void setList(LinkedList<Edge> sList){savings = sList;}
}