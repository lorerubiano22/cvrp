/**********************************************************************************
* Implementaci�n de un algoritmo Multi-Start para resolver el CVRP. 
*
* M�ster en Ingenier�a Computacional y Matem�tica
* Optimizaci�n Combinatoria
**********************************************************************************/

public class ElapsedTime{
	
	/******************************************************************************* 
     * Constructor
     ******************************************************************************/
	
    public ElapsedTime(){}

	/******************************************************************************* 
     * M�TODO P�BLICO systemTime()
     * Devuelve el tiempo en nanosegundos
     ******************************************************************************/
    
    public static long systemTime(){   
	   long time = System.nanoTime();
        return time;}

	/******************************************************************************* 
     * M�TODO P�BLICO calcElapsed()
     * Devuelve el tiempo en segundos entre dos valores
     ******************************************************************************/
    
    public static double calcElapsed(long start, long end){   		   
    	double elapsed = (end - start) / 1.0e+9;
        return elapsed;}
}