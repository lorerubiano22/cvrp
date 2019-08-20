import java.util.Random;

/**********************************************************************************
* Implementaci�n de un algoritmo Multi-Start para resolver el CVRP. 
*
* M�ster en Ingenier�a Computacional y Matem�tica
* Optimizaci�n Combinatoria
**********************************************************************************/

public class MultiStart{
	
	/******************************************************************************* 
     * Variables de instancia
     ******************************************************************************/
	
    private Test aTest;
    private Inputs inputs;
    private Random rng;
    private Solution cwsSol = null, bestSol = null, newSol = null;
    private Outputs outputs = new Outputs();
    
    /*******************************************************************************
     * Constructor 
     ******************************************************************************/
    
    MultiStart(Test myTest, Inputs myInputs, Random myRng){
        aTest = myTest;
        inputs = myInputs;
        rng = myRng;}
    
	/******************************************************************************* 
     * M�TODO P�BLICO solve()
     * Procedimiento Multi-Start 
     ******************************************************************************/
    
    public Outputs solve(){
        long start = ElapsedTime.systemTime();
        cwsSol = RandCWS.solve(aTest, inputs, rng, false);
        double elapsed = ElapsedTime.calcElapsed(start, ElapsedTime.systemTime());
        double elapsedB;
        cwsSol.setTime(elapsed);
        System.out.println("CWS sol cost: " + cwsSol.getCosts());
        System.out.println("CWS sol time: " + cwsSol.getTime());
        bestSol = cwsSol;
        outputs.setCWSSol(cwsSol);
        start = ElapsedTime.systemTime();
        elapsed = 0.0;
        elapsedB = 0.0;
        int i = 1, j = 1;
        while(elapsed < aTest.getMaxTime()){
            newSol = RandCWS.solve(aTest, inputs, rng, true);
            if(newSol.getCosts() < bestSol.getCosts()){
                bestSol = newSol;
                elapsedB = ElapsedTime.calcElapsed(start, ElapsedTime.systemTime());
                bestSol.setTime(elapsedB);
                j=i;}
            elapsed = ElapsedTime.calcElapsed(start, ElapsedTime.systemTime());
            i++;}
        System.out.println("Num best sol (total): " + j + "(" + i + ")");
        System.out.println("OBSol cost: " + bestSol.getCosts());
        System.out.println("OBSol time: " + bestSol.getTime());
        outputs.setOBSol(bestSol);
        return outputs;}
}