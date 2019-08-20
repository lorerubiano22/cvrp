import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**********************************************************************************
* Implementación de un algoritmo Multi-Start para resolver el CVRP. 
*
* Máster en Ingeniería Computacional y Matemática
* Optimización Combinatoria
**********************************************************************************/

public class InputsManager{
	
	/******************************************************************************* 
     * MÉTODO PÚBLICO readInputs()
     * Lee y guarda los inputs 
     ******************************************************************************/
	
    public static Inputs readInputs(String nodesFilePath, String vehiclesFilePath){
        Inputs inputs = null;
        try{   
            BufferedReader br = new BufferedReader(new FileReader(nodesFilePath));
            String f = null;
            int nNodes = 0;
            while((f = br.readLine())!=null){   
            	if(f.charAt(0) != '#') nNodes++;}
            inputs = new Inputs(nNodes);
            FileReader reader = new FileReader(nodesFilePath);
            Scanner in = new Scanner(reader);
            in.useLocale(Locale.US);
            String s = null;
            int k = 0;
            while(in.hasNextLine()){   
            	s = in.next();
                if(s.charAt(0) == '#') in.nextLine();
                else{   
                	float x = Float.parseFloat(s); 
                    float y = in.nextFloat();
                    float demand = in.nextFloat();
                    Node node = new Node(k, x, y, demand);
                    inputs.getNodes()[k] = node;
                    k++;}}
            in.close();
            reader = new FileReader(vehiclesFilePath);
            in = new Scanner(reader);
            in.useLocale(Locale.US);
            br.close();
            while( in.hasNextLine()){   
			s = in.next();
                if(s.charAt(0) == '#') in.nextLine();
                else{   
                	float vCap = Float.parseFloat(s);
                    inputs.setVehCap(vCap);}}
            in.close();}
        catch (IOException exception){   
        	System.out.println("Error processing inputs files: " + exception);}
        return inputs;}

	/******************************************************************************* 
     * MÉTODO PÚBLICO generateSavingsList()
     * Crea la lista de savings 
     ******************************************************************************/  
    
    public static void generateSavingsList(Inputs inputs){
        int nNodes = inputs.getNodes().length;
        Edge[] savingsArray = new Edge[(nNodes - 1) * (nNodes - 2) / 2];
        Node depot = inputs.getNodes()[0];
        int k = 0;
        for(int i = 1; i < nNodes - 1; i++){
           for(int j = i + 1; j < nNodes; j++){
                Node iNode = inputs.getNodes()[i];
                Node jNode = inputs.getNodes()[j];
                Edge ijEdge = new Edge(iNode, jNode);
                ijEdge.setCosts(ijEdge.calcCosts(iNode, jNode));
                ijEdge.setSavings(ijEdge.calcSavings(iNode, jNode, depot));
                Edge jiEdge = new Edge(jNode, iNode);
                jiEdge.setCosts(jiEdge.calcCosts(jNode, iNode));
                jiEdge.setSavings(jiEdge.calcSavings(jNode, iNode, depot));
                ijEdge.setInverse(jiEdge);
                jiEdge.setInverse(ijEdge);
                savingsArray[k] = ijEdge;
                k++;}}
        Arrays.sort(savingsArray);
        List<Edge> sList = Arrays.asList(savingsArray);
        LinkedList<Edge> savingsList = new LinkedList<Edge>(sList);
        inputs.setList(savingsList);}

	/******************************************************************************* 
     * MÉTODO PÚBLICO generateDepotEdges()
     * Crea los arcos que contienen el depot (nodes[0]) 
     ******************************************************************************/
    
    public static void generateDepotEdges(Inputs inputs){
        Node[] nodes = inputs.getNodes();
        Node depot = nodes[0];
        for(int i = 1; i < nodes.length; i++){
            Node iNode = nodes[i];
            Edge diEdge = new Edge(depot, iNode);
            iNode.setDiEdge(diEdge);
            diEdge.setCosts(diEdge.calcCosts(depot, iNode));
            Edge idEdge = new Edge(iNode, depot);
            iNode.setIdEdge(idEdge);
            idEdge.setCosts(idEdge.calcCosts(depot, iNode));
            idEdge.setInverse(diEdge);
            diEdge.setInverse(idEdge);}}
}