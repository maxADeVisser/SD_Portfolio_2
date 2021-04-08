import java.util.ArrayList;
import java.util.Arrays;
<<<<<<< Updated upstream
import java.util.PriorityQueue;


// se link: https://www.youtube.com/watch?v=jsmMtJpPnhU

//------------------------------ADJACENCY GRAPH----------------------------------------//

public class AdjacencyGraph {
    //---ATTRIBUTES
    ArrayList<Vertex> vertices;

    //---METHODS
    public AdjacencyGraph() {
        vertices = new ArrayList<Vertex>(); //creates a list for vertices in the graph
    }

    public void addVertex(Vertex v) { //ads a vertex to the vertices list
        vertices.add(v);
    }

    public void addEdge(Vertex one, Vertex two, Integer w) { //ADDS AN ADGE TO THE GRAPH
        if (!(vertices.contains(one) && vertices.contains(two))) { //test whether the vertex exists in the graph
            System.out.println(" Vertex not in graph");
            return;
        }
        Edge e1 = new Edge(one, two, w);
        Edge e2 = new Edge(two, one, w); //ADDED FOR UNDIRECTING THE GRAPH
    }

    //---PRIMS ALGORITHM FOR FINDING MST
    public void primsMST(){
        int[] distance = new int[vertices.size()];
        int[] predecessor = new int[vertices.size()];
        boolean[] visited = new boolean[vertices.size()]; //list to keep track of vertices we have visited

        MinHeap<Pair> Q = new MinHeap<>();
        PriorityQueue<Pair> PQ = new PriorityQueue<>();

        ArrayList<Pair> VertexPairs = new ArrayList<>();

        Arrays.fill(distance, Integer.MAX_VALUE); //Integer.MAX_VALUE is supposed to resemble infinity
        Arrays.fill(predecessor,-1); //fill fylder listen med en værdi
        Arrays.fill(visited, false);

        if(vertices.size() > 0){
            distance[0] = 0;
        }

        for (int i = 0; i < vertices.size(); i++) {
            VertexPairs.add(new Pair(distance[i], i));
            Q.Insert(VertexPairs.get(i));
        }

        int MST = 0;

        while (!Q.isEmpty()){
            Pair u = Q.extractMin();

            for (int v = 0; v < vertices.size(); v++) {
                //WATCH THE VIDEO WHERE THE PRIMS ALGORITHM IS IMPLEMENTED to understand what to do here
=======


// se link: https://www.youtube.com/watch?v=jsmMtJpPnhU

//------------------------------ADJACENCY GRAPH----------------------------------------//

public class AdjacencyGraph {
    ArrayList<Node> nodes; //det her er grafen
    public AdjacencyGraph() { //constructor
        nodes = new ArrayList<Node>(); //creates a list for nodes in the graph
    }

    public void addNode(Node v) { //ads a node to the nodes list
        nodes.add(v);
    }

    public void addEdge(Node nodeOne, Node nodeTwo, Integer edgeWeight) { //ADDS AN ADGE TO THE GRAPH
        if (!(nodes.contains(nodeOne) && nodes.contains(nodeTwo))) { //test whether the vertex exists in the graph
            System.out.println(" Vertex not in graph");
            return;
        }

        Edge edge1 = new Edge(nodeOne, nodeTwo, edgeWeight);
        Edge edge2 = new Edge(nodeTwo, nodeOne, edgeWeight);
    }

    //-------PRIMS ALGORITHM FOR FINDING MST---------
    public void primsMST(){
        int[] distanceBetweenNodes = new int[nodes.size()]; //TROR det er en liste med distancerne over noder vi har besøgt
        int[] predecessorList = new int[nodes.size()]; //liste vi bruger som en historik over hvilken vej vi har gået i grafen
        boolean[] visitedList =  new boolean[nodes.size()]; //lsite vi bruger til at holde styr på om noder er besøgt

        MinHeap<Pair> minHeap =new MinHeap<>(); //the final MST
        //MinHeap<Node> minHeap = new MinHeap<>(); //consider making the heap with nodes instead

        Arrays.fill(distanceBetweenNodes, Integer.MAX_VALUE); //representere infinity
        Arrays.fill(predecessorList,-1); //-1 representere null, such that when we dont have a predecessor, its represented with -1
        Arrays.fill(visitedList,false);

        if (nodes.size()>0) {
            nodes.get(0).distance = 0; //vælger start node hvis ikke grafen er tom
        }

        ArrayList<Pair> NodePairList = new ArrayList<>(); //bruges til at gemme de forskellige par fra noden man står på
        for(int i=0;i< nodes.size();i++) {
            //OBS.: når vi tilføjer et par til minHeap, sorteres de automatisk for at opretholde minHeap struktur:
            NodePairList.add(new Pair(distanceBetweenNodes[i], i)); //opretter og tilføjer Node Par til NodePairList. distance , index
            minHeap.Insert(NodePairList.get(i)); //indsætter Par i minHeap
        }

        System.out.println(minHeap.extractMin());

        int MST = 0; //vi ved ikke endnu hvad vi bruger denne til

        while(!minHeap.isEmpty()){
            Pair currentMin = minHeap.extractMin(); //extracter den mindste weight fra hvor du står
            for (int node = 0; node < nodes.size(); node++) {
                //SEE VIDEO OG LAV WHILE LOOPET FÆRDIGT HER.
>>>>>>> Stashed changes
            }
        }

    }
<<<<<<< Updated upstream
    public void PrintGraph() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(" From the Vertex: " + vertices.get(i).vertexName);
            Vertex currentFrom = vertices.get(i); //states which vertex we are on

            for (int j = 0; j < currentFrom.OutEdges.size(); j++) {
                Edge currentEdge = currentFrom.OutEdges.get(j);
                System.out.println(" To: " + currentEdge.two.vertexName + " weight: " + currentEdge.weight);
=======



    public void PrintGraph() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println(" From the Vertex: " + nodes.get(i).nodeName);
            Node currentFrom = nodes.get(i); //states which vertex we are on

            for (int j = 0; j < currentFrom.OutEdges.size(); j++) {
                Edge currentEdge = currentFrom.OutEdges.get(j);
                System.out.println(" To: " + currentEdge.two.nodeName + " weight: " + currentEdge.weight);
>>>>>>> Stashed changes
            }
            System.out.println(" ");
        }
    } //doesnt work properly. It prints as if the graph is directional, which it is not
}

//---------------------------------VERTEX-------------------------------------//

<<<<<<< Updated upstream
class Vertex implements Comparable<Vertex> {
    //---ATTRIBUTES:
    String vertexName;
    ArrayList<Edge> OutEdges; //list of edges going out from the vertex
    Integer dist = Integer.MAX_VALUE; //resembles infinity in this context


    //---METHODS:
    public Vertex(String name) { //constructor for the vertex
        vertexName = name;
=======
class Node implements Comparable<Node> {
    //---ATTRIBUTES:
    String nodeName;
    ArrayList<Edge> OutEdges; //list of edges going out from the vertex
    Integer distance = Integer.MAX_VALUE; //resembles infinity in this context


    //---METHODS:
    public Node(String name) { //constructor for the vertex
        nodeName = name;
>>>>>>> Stashed changes
        OutEdges = new ArrayList<Edge>(); //list of edges going out from this vertex
    }

    public void addOutEdge(Edge e) { //adds a edge to the list of edges going out from this Vertex
        OutEdges.add(e);
    }

    public String getNodeName() { //THIS METHOD WAS CREATED FOR TESTING THE PRINTGRAPH METHOD. DELETE IT IF NOT USED
        return nodeName;
    }

    public ArrayList<Edge> getOutEdges() { //THIS METHOD WAS CREATED FOR TESTING THE PRINTGRAPH METHOD. DELETE IT IF NOT USED
        return OutEdges;
    }

    @Override
<<<<<<< Updated upstream
    public int compareTo(Vertex o) {
        if (this.dist < o.dist)
        return -1;
        if (this.dist > o.dist)
=======
    public int compareTo(Node o) {
        if (this.distance < o.distance)
            return -1;
        if (this.distance > o.distance)
>>>>>>> Stashed changes
            return 1;
        return 0;
    }
}

//--------------------------------EDGE--------------------------------------//

class Edge {
    //---ATTRIBUTES
    Integer weight;
<<<<<<< Updated upstream
    Vertex one; //represents the two vertexes the edge connects
    Vertex two;

    //---METHODS
    public Edge(Vertex first, Vertex second, Integer cost) { //constructor for the edge
=======
    Node one; //represents the two vertexes the edge connects
    Node two;

    //---METHODS
    public Edge(Node first, Node second, Integer cost) { //constructor for the edge
>>>>>>> Stashed changes
        this.one = first;
        this.two = second;
        this.weight = cost;
        this.one.addOutEdge(this); //maybe delete this
<<<<<<< Updated upstream
    }
}

//-------------------------------PAIR---------------------------------------//

//THE PAIR CLASS WAS COPIED FROM THE MATRIX GRAPH IMPLEMENTATION OF PRIMS ALGORITHM
//im not sure if it needs to be used yet
class Pair implements Comparable<Pair>{
    //---ATTRIBUTES
    Integer distance; //distance between two vertices
    Integer index;


    //---METHODS
    public Pair(Integer distance, Integer index){ //constructor for a Pair
        this.distance=distance;
        this.index = index;
    }

    @Override
    public int compareTo(Pair p){ //return the distance between to vertices
        return this.distance.compareTo(p.distance);
=======
>>>>>>> Stashed changes
    }
}

//-------------------------------PAIR---------------------------------------//

//THE PAIR CLASS WAS COPIED FROM THE MATRIX GRAPH IMPLEMENTATION OF PRIMS ALGORITHM
//The pair class is a new representation of Nodes such that they also have a distance to where they came from
class Pair implements Comparable<Pair>{

    Integer distance;
    Integer index;

    public Pair(Integer distance, Integer index){ //constructor for a Pair
        this.distance = distance;
        this.index = index;
    }

    @Override
    public int compareTo(Pair p){ //return the distance between to vertices
        return this.distance.compareTo(p.distance);
    }
}