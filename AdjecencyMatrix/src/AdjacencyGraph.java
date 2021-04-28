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


    public void printGraph(){ //Print statement for all connections for a given city, with kilometers.
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

    int MSTminheap = 0;
    public void primsUsingMinHeap(){ //Isen't activated, as we used PriorityQue instead of prims algorithm
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

    int MST = 0; //Empty variable only used for primsUsingPQ method
    public void primsUsingPQ(){
        PriorityQueue <Node> citiesPQ = new PriorityQueue<Node>();

        if (nodes.size() > 0) { //Creating a node at the first index in the node list, with a distance of 0.
            nodes.get(0).distance = 0;
            citiesPQ.offer(nodes.get(0));
        } else {
            System.out.println("The adjacency graph is empty");
        }

        while(!citiesPQ.isEmpty()){ //As long as the list aint empty, do following...
            Node currentNode = citiesPQ.poll();

            if(!currentNode.hasBeenVisited){ //If current node havent been visited execute following ...
                for (int i = 0; i < currentNode.getOutgoingEdgesFromNode().size(); i++) { //Iterate through all nodes connected to current node

                    Node toNode = currentNode.getOutgoingEdgesFromNode().get(i).getToNote();
                    Integer currentEdgeWeight = currentNode.getOutgoingEdgesFromNode().get(i).getWeight();

                    if((!toNode.hasBeenVisited) && currentEdgeWeight < toNode.distance){ //If any nodes connected to current node has a shorter distance, replace current node, set is a previous as iterating through
                        toNode.distance = currentEdgeWeight;
                        toNode.predecessorNode = currentNode;
                        citiesPQ.offer(toNode);
                    }
                }
                currentNode.hasBeenVisited = true;
                MST += currentNode.distance; //sum af MST
            }
        }
    }

    public void printMST(){ //Print statement for MST
        System.out.println("The Minimum Spanning Tree is connected as such: \n");
        for (int i = 0; i < nodes.size(); i++) {
            Node predecessorNode = nodes.get(i).predecessorNode;
            if (predecessorNode != null) { //since all Nodes initially dont have a predecessor node initalized, we can sort the ones that has
                //been givin a predecessor in Prims algorithm (an so, we will know that it is part of the MST).
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
    ArrayList<Edge> outgoingEdgesFromNode; //list of edges going out from the vertex
    Integer distance = Integer.MAX_VALUE; //Variabel representing the distance to the node which is initialized as infinity except the choosen starting node (which is 0)
    Node predecessorNode = null; //used to store the previous Node to the current one, when traversing through the tree in Prims algorithm
    Boolean hasBeenVisited = false;

    //---METHODS---
    public Node(String name) { //constructor for the vertex
        nodeName = name;
        outgoingEdgesFromNode = new ArrayList<>(); //list of edges going out from this vertex
    }

    public void addOutgoingEdge(Edge e) {
        outgoingEdgesFromNode.add(e);
    }

    @Override
    public int compareTo(Node o) { //utilityfunction used to compare distances between nodes
        //how the function is used: firstNode.compareTo(secondNode)
        if (this.distance < o.distance)
            return -1; //resembels that the distance from firstNode is SMALLER than distance from secondNote
        if (this.distance > o.distance)
            return 1; //resembels that the distance from firstNode is LARGER than distance from secondNote
        return 0; //resembles if they are of equal value
    }



    //---GETTERS AND SETTERS
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

    //---GETTERS AND SETTERS
    public Node getToNote() {
        return toNote;
    }
    public Integer getWeight() {
        return weight;
    }
}
