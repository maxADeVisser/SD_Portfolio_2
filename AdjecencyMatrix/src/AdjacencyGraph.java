import java.util.ArrayList;
import java.util.PriorityQueue;

//---------------------Adjacency Graph----------------------

public class AdjacencyGraph {
    ArrayList<Node> nodes; //the list used for making the adjacency graph

    public AdjacencyGraph() { //constructor
        nodes = new ArrayList<>();
    }

    public void addNode(Node n) { //adds a node to the adjacency graph
        nodes.add(n);
    }

    public void addEdge(Node nodeOne, Node nodeTwo, Integer edgeWeight) { //adds an edge to the adjacency graph
        if (!(nodes.contains(nodeOne) && nodes.contains(nodeTwo))) {
            System.out.println("Node doesn't exist in the graph");
            return;
        }
        //there are two edges created to represent, that the graph is bidirectional (aka undirectional)
        Edge edge1 = new Edge(nodeOne, nodeTwo, edgeWeight);
        Edge edge2 = new Edge(nodeTwo, nodeOne, edgeWeight);
    }


    public void printGraph(){ //Print statement for all connections in the graph, with kilometers.
        for (int i = 0; i < nodes.size(); i++) {
            Node currentNode = nodes.get(i);
            System.out.println("Connections from " + currentNode.getNodeName() + " are:");
            for (int j = 0; j < currentNode.outgoingEdgesFromNode.size(); j++) {
                Edge currentEdge = currentNode.outgoingEdgesFromNode.get(j);
                System.out.println(currentNode.outgoingEdgesFromNode.get(j).getToNote().getNodeName() + " - distance: " + currentEdge.getWeight() + " km");
            }
            System.out.println();
        }
    }

    //Below code isen't used, because we used PriorityQue instead of MinHeap.
    //But we left in to be able to see our thought process and how we tried making it work.
    /*
    int MSTminheap = 0;
    public void primsUsingMinHeap(){
        MinHeap<Node> citiesMinHeap = new MinHeap<Node>();

        if (nodes.size() > 0) { //Creating a node at the first index in the node list, with a distance of 0.
            nodes.get(0).distance = 0;
            citiesMinHeap.Insert(nodes.get(0));
        }

        while(!citiesMinHeap.isEmpty()){ //As long as the list aint empty, do following...
            Node currentNode = citiesMinHeap.extractMin();

            if(!currentNode.hasBeenVisited){ //If current node havent been visited execute following ...
                for (int i = 0; i < currentNode.getOutgoingEdgesFromNode().size(); i++) { //Iterate through all nodes connected to current node

                    Node currentToNode = currentNode.getOutgoingEdgesFromNode().get(i).getToNote();
                    Integer currentEdgeWeight = currentNode.getOutgoingEdgesFromNode().get(i).getWeight();

                    if((!currentToNode.hasBeenVisited) && currentEdgeWeight < currentToNode.distance){ //If any nodes connected to current node has a shorter distance, replace current node, set is a previous as iterating through
                        currentToNode.distance = currentEdgeWeight;
                        currentToNode.predecessorNode = currentNode;
                        citiesMinHeap.Insert(currentToNode);
                    }
                }
                currentNode.hasBeenVisited = true;
                MSTminheap += currentNode.distance; //sum of MST
            }
        }
    }
    */

    int MST = 0; // Variable used later to store the MST total distance

    public void primsUsingPQ(){ // Runs prims algorithm using a PQ
        PriorityQueue <Node> citiesPQ = new PriorityQueue<Node>(); // initiates an empty PQ holding nodes

        if (nodes.size() > 0) { //Creating a node at the first index in the node list, with a distance of 0 if the PQ is not empty
            nodes.get(0).distance = 0;
            citiesPQ.offer(nodes.get(0)); // add node to PQ
        } else {
            System.out.println("The adjacency graph is empty");
        }

        while(!citiesPQ.isEmpty()){ //As long as the PQ is not empty, do following...
            Node currentNode = citiesPQ.poll(); // currentNode is the node with the smallest distance available, at each iteration in the while-loop

            if(!currentNode.hasBeenVisited){ //If current node HASN'T been visited execute following ...

                // Iterate through all toNodes and the weight of their edge:
                for (int i = 0; i < currentNode.getOutgoingEdgesFromNode().size(); i++) {
                    Node toNode = currentNode.getOutgoingEdgesFromNode().get(i).getToNote();
                    Integer currentEdgeWeight = currentNode.getOutgoingEdgesFromNode().get(i).getWeight();

                    // If any toNodes from currentNode haven't been visited yet and is smaller than currentEdgeWeight ->
                    if((!toNode.hasBeenVisited) && currentEdgeWeight < toNode.distance){
                        toNode.distance = currentEdgeWeight; // update the toNode distance to currentEdgeWeight
                        toNode.predecessorNode = currentNode; // update the predecessor from toNode to be the currentNode
                        citiesPQ.offer(toNode); // add the toNode to the PQ
                    }
                }
                currentNode.hasBeenVisited = true; // update that we now have visited currentNode
                MST += currentNode.distance; // add the currentNode's distance to the MST sum
            }
        }
    }

    public void printMST(){ //Print statement for MST
        System.out.println("The Minimum Spanning Tree is connected as such: \n");
        for (int i = 0; i < nodes.size(); i++) {
            Node predecessorNode = nodes.get(i).predecessorNode;
            if (predecessorNode != null) { //since all Nodes initially dont have a predecessor node initialized, we can sort the ones that has
                //been given a predecessor in Prims algorithm, and so we will know that it is part of the MST.
                System.out.println(predecessorNode.getNodeName() +
                        " to " + nodes.get(i).getNodeName() + " Edge Weight: " +
                        nodes.get(i).distance + "km");
            }
        }
        System.out.println("\nTotal distance covered by the MST: " + MST + " km");
        System.out.println("Total Cost of the grid: " + MST*100000 + " kr");
    }
}

//------------------------NODE-------------------------------
class Node  implements Comparable<Node>{
    //---ATTRIBUTES---
    String nodeName;
    ArrayList<Edge> outgoingEdgesFromNode; //list of edges going out from the node
    Integer distance = Integer.MAX_VALUE; //Variable representing the distance to the node which is initialized as infinity except the chosen starting node (which is 0 initially)
    Node predecessorNode = null; //used to store the previous Node to the current one, when traversing through the tree in Prims algorithm
    Boolean hasBeenVisited = false; // a boolean used to check if the note has been visited or not

    //---METHODS---
    public Node(String name) { //constructor for the node
        nodeName = name;
        outgoingEdgesFromNode = new ArrayList<>(); //list of edges going out from this node
    }

    public void addOutgoingEdge(Edge e) {
        outgoingEdgesFromNode.add(e);
    }

    @Override
    public int compareTo(Node o) { //utility function used to compare distances between nodes
        if (this.distance < o.distance)
            return -1; //resembles that the distance from firstNode is SMALLER than distance from secondNote
        if (this.distance > o.distance)
            return 1; //resembles that the distance from firstNode is LARGER than distance from secondNote
        return 0; //resembles if they are of equal value
    }

    //---GETTERS AND SETTERS FOR NODE CLASS
    public String getNodeName() {
        return nodeName;
    }
    public ArrayList<Edge> getOutgoingEdgesFromNode() {
        return outgoingEdgesFromNode;
    }
}

//------------------------EDGE-------------------------------
class Edge{
    //---ATTRIBUTES---
    Node fromNote;
    Node toNote;
    Integer weight; //represents the distance between cities

    //---METHODS---
    public Edge (Node from, Node to, Integer w){ //constructor
        this.fromNote = from;
        this.toNote = to;
        this.weight = w;
        this.fromNote.addOutgoingEdge(this); //adds the current edge created to the fromNode's outgoindEdgeList
    }

    //---GETTERS AND SETTERS FOR NODE EDGE CLASS
    public Node getToNote() {
        return toNote;
    }
    public Integer getWeight() {
        return weight;
    }
}
