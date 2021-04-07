
/*
What you need to do is to make a primsMST method inside your adjacency graph.

You can get inspiration from the PrimMST on the matrix graph in the code.

The minheap is uploaded and ready for use.
 */
public class Main {

    public static void main(String[] args) {
        MatrixGraph thisGraph = new MatrixGraph(16); //all the cities
        thisGraph.addEdge(0, 1, 1);
        thisGraph.addEdge(0, 2, 5);

        //thisGraph.printGraph();
        thisGraph.MSTPrims();
    }
}
