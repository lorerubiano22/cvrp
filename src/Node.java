/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class Node{
	
    /*******************************************************************************
    * Variables de instancia 
    ******************************************************************************/
	
    private int id;
    private float x, y; // coordenadas 
    private float demand;
    private Route inRoute = null;
    private boolean isInterior = false;
    private Edge diEdge = null; // depot-cliente
    private Edge idEdge = null; // cliente-depot

    /*******************************************************************************
     * Constructor 
     ******************************************************************************/
    
    public Node(int nodeId, float nodeX, float nodeY, float nodeDemand){   
	   id = nodeId;
       x = nodeX;
       y = nodeY;
       demand = nodeDemand;}

    /*******************************************************************************
     * Getters y Setters 
     ******************************************************************************/
    
    public int getId(){return id;}
    
    public float getX(){return x;}
    
    public float getY(){return y;}
    
    public float getDemand(){return demand;}
    
    public Route getInRoute(){return inRoute;}
    
    public boolean getIsInterior(){return isInterior;}
    
    public Edge getDiEdge(){return diEdge;}
    
    public Edge getIdEdge(){return idEdge;}
    
    public void setInRoute(Route r){inRoute = r;}
    
    public void setIsInterior(boolean value){isInterior = value;}
    
    public void setDiEdge(Edge e){diEdge = e;}
    
    public void setIdEdge(Edge e){idEdge = e;}

    /*******************************************************************************
     * MÉTODO PÚBLICO toString()
     ******************************************************************************/
    
    @Override
    public String toString(){   
	   String s = "" + this.id + " ";
        s += this.x + " ";
        s += this.y + " ";
        s = this.demand + "";
        return s;}
}