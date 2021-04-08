import java.util.ArrayList;
import java.util.Arrays;
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
            }
        }

    }
    public void PrintGraph() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(" From the Vertex: " + vertices.get(i).vertexName);
            Vertex currentFrom = vertices.get(i); //states which vertex we are on

            for (int j = 0; j < currentFrom.OutEdges.size(); j++) {
                Edge currentEdge = currentFrom.OutEdges.get(j);
                System.out.println(" To: " + currentEdge.two.vertexName + " weight: " + currentEdge.weight);
            }
            System.out.println(" ");
        }
    } //doesnt work properly. It prints as if the graph is directional, which it is not
}

//---------------------------------VERTEX-------------------------------------//

class Vertex implements Comparable<Vertex> {
    //---ATTRIBUTES:
    String vertexName;
    ArrayList<Edge> OutEdges; //list of edges going out from the vertex
    Integer dist = Integer.MAX_VALUE; //resembles infinity in this context


    //---METHODS:
    public Vertex(String name) { //constructor for the vertex
        vertexName = name;
        OutEdges = new ArrayList<Edge>(); //list of edges going out from this vertex
    }

    public void addOutEdge(Edge e) { //adds a edge to the list of edges going out from this Vertex
        OutEdges.add(e);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.dist < o.dist)
        return -1;
        if (this.dist > o.dist)
            return 1;
        return 0;
    }
}

//--------------------------------EDGE--------------------------------------//

class Edge {
    //---ATTRIBUTES
    Integer weight;
    Vertex one; //represents the two vertexes the edge connects
    Vertex two;

    //---METHODS
    public Edge(Vertex first, Vertex second, Integer cost) { //constructor for the edge
        this.one = first;
        this.two = second;
        this.weight = cost;
        this.one.addOutEdge(this); //maybe delete this
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
    }
}
