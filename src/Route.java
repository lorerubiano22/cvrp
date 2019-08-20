import java.util.LinkedList;
import java.util.List;

/**********************************************************************************
* Implementaci�n de un algoritmo Multi-Start para resolver el CVRP. 
*
* M�ster en Ingenier�a Computacional y Matem�tica
* Optimizaci�n Combinatoria
**********************************************************************************/

public class Route{
	
	/******************************************************************************* 
     * Variables de instancia
     ******************************************************************************/
	
    private double costs = 0.0;
    private float demand = 0.0F;
    private LinkedList<Edge> edges;
    private float[] center;

    /*******************************************************************************
     * Constructor 
     ******************************************************************************/
    
    public Route(){   
	   edges = new LinkedList<Edge>();
       center = new float[2];}
    
    /*******************************************************************************
     * Getters y setters 
     ******************************************************************************/
    
    public double getCosts(){return costs;}
    
    public float getDemand(){return demand;}
    
    public float[] getCenter(){return center;}
    
    public List<Edge> getEdges(){return edges;}
    
    public void setCosts(double c){costs = c;}
    
    public void setDemand(float d){demand = d;}
    
    public void setCenter(float[] coord){center = coord;}
    
    public void setEdges(LinkedList<Edge> e){edges = e;}
    
	/******************************************************************************* 
     * M�TODO P�BLICO reverse()
     * Cambia el sentido de la ruta 
     ******************************************************************************/
    
    public void reverse(){   
        for(int i = 0; i < edges.size(); i++){   
        	Edge e = edges.get(i);
            Edge invE = e.getInverseEdge();
            edges.remove(e);
            edges.add(0, invE);}}
    
	/******************************************************************************* 
     * M�TODO P�BLICO toString()
     ******************************************************************************/
    
    @Override
    public String toString(){   
	   String s = "\nRute costs: " + this.costs;
       s += "\nRuta demand:" + this.demand;
       s += "\nRuta edges: " + this.edges;
       return s;}
}