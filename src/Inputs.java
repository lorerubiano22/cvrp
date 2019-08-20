import java.util.LinkedList;

/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class Inputs{
	
    /*******************************************************************************
    * Variables de instancia 
    ******************************************************************************/
	
    private Node[] nodes; // Conjunto de nodos, incluyendo el depot
    private float vCap = 0.0F; // Capacidad máxima de los vehículos
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