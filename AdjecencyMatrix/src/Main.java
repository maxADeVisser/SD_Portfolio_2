public class Main {

    public static void main(String[] args) {
        AdjacencyGraph cities = new AdjacencyGraph(); //initializes the adjacency graph holding all the cities

        //---initializing Nodes and adding them to the adjacency graph
        Node Eskildstrup = new Node("Eskildsstrup");            cities.addNode(Eskildstrup);
        Node Haslev = new Node("Haslev");                       cities.addNode(Haslev);
        Node Holbæk = new Node( "Holbæk");                      cities.addNode(Holbæk);
        Node Jærgerspris = new Node("Jærgerspris");             cities.addNode(Jærgerspris);
        Node Kalundborg = new Node("Kalundborg");               cities.addNode(Kalundborg);
        Node Korsør = new Node( "Korsør");                      cities.addNode(Korsør);
        Node Køge = new Node("Køge");                           cities.addNode(Køge);
        Node Maribo = new Node("Maribo");                       cities.addNode(Maribo);
        Node Næstved = new Node("Næstved");                     cities.addNode(Næstved);
        Node Ringsted = new Node("Ringsted");                   cities.addNode(Ringsted);
        Node Slagelse = new Node("Slagelse");                   cities.addNode(Slagelse);
        Node Nykøbing_F = new Node("Nykøbing F");               cities.addNode(Nykøbing_F);
        Node Vordingborg = new Node("Vordingborg");             cities.addNode(Vordingborg);
        Node Roskilde = new Node("Roskilde");                   cities.addNode(Roskilde);
        Node Sorø = new Node("Sorø");                           cities.addNode(Sorø);
        Node Nakskov = new Node("Nakskov");                     cities.addNode(Nakskov);

        //---Adding all the connections (edges) between cities
        cities.addEdge(Eskildstrup,Maribo,28);             cities.addEdge(Jærgerspris,Sorø, 51);
        cities.addEdge(Eskildstrup,Nykøbing_F, 13);        cities.addEdge(Kalundborg,Ringsted, 62);
        cities.addEdge(Eskildstrup,Vordingborg,24);        cities.addEdge(Kalundborg,Roskilde, 70);
        cities.addEdge(Haslev,Korsør,60);                  cities.addEdge(Kalundborg,Slagelse, 39);
        cities.addEdge(Haslev,Køge,24);                    cities.addEdge(Kalundborg,Sorø, 51);
        cities.addEdge(Haslev,Næstved,25);                 cities.addEdge(Korsør,Næstved, 45);
        cities.addEdge(Haslev,Ringsted,19);                cities.addEdge(Korsør,Slagelse, 20);
        cities.addEdge(Haslev,Roskilde, 47);               cities.addEdge(Køge,Næstved, 45);
        cities.addEdge(Haslev,Slagelse, 48);               cities.addEdge(Køge,Ringsted, 28);
        cities.addEdge(Haslev,Sorø,34);                    cities.addEdge(Køge,Roskilde, 25);
        cities.addEdge(Haslev,Vordingborg, 40);            cities.addEdge(Køge,Vordingborg, 60);
        cities.addEdge(Holbæk,Jærgerspris,34);             cities.addEdge(Maribo,Nakskov, 27);
        cities.addEdge(Holbæk,Kalundborg, 44);             cities.addEdge(Maribo,Nykøbing_F, 26);
        cities.addEdge(Holbæk,Korsør, 66);                 cities.addEdge(Næstved,Roskilde, 57);
        cities.addEdge(Holbæk,Ringsted, 36);               cities.addEdge(Næstved,Ringsted, 26);
        cities.addEdge(Holbæk,Roskilde, 32);               cities.addEdge(Næstved,Slagelse, 37);
        cities.addEdge(Holbæk,Slagelse, 46);               cities.addEdge(Næstved,Sorø, 32);
        cities.addEdge(Holbæk,Sorø, 63);                   cities.addEdge(Næstved,Vordingborg, 28);
        cities.addEdge(Jærgerspris,Korsør, 95);            cities.addEdge(Ringsted,Roskilde, 31);
        cities.addEdge(Jærgerspris,Køge, 58);              cities.addEdge(Ringsted,Sorø, 15);
        cities.addEdge(Jærgerspris,Ringsted, 56);          cities.addEdge(Ringsted,Vordingborg, 58);
        cities.addEdge(Jærgerspris,Roskilde, 33);          cities.addEdge(Slagelse,Sorø, 14);
        cities.addEdge(Jærgerspris,Slagelse, 74);

        //------------------------------OPERATIONS-----------------------------//

        cities.primsUsingPQ();
        //cities.primsUsingMinHeap();
        cities.printMST();
        //cities.printGraph();
    }
}
