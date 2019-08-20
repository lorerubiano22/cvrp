/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class ElapsedTime{
	
	/******************************************************************************* 
     * Constructor
     ******************************************************************************/
	
    public ElapsedTime(){}

	/******************************************************************************* 
     * MÉTODO PÚBLICO systemTime()
     * Devuelve el tiempo en nanosegundos
     ******************************************************************************/
    
    public static long systemTime(){   
	   long time = System.nanoTime();
        return time;}

	/******************************************************************************* 
     * MÉTODO PÚBLICO calcElapsed()
     * Devuelve el tiempo en segundos entre dos valores
     ******************************************************************************/
    
    public static double calcElapsed(long start, long end){   		   
    	double elapsed = (end - start) / 1.0e+9;
        return elapsed;}
}