public class Main {

    public static void main(String[] args) {
        AdjacencyGraph Cities = new AdjacencyGraph(); //initializes the adjacency graph

        Node Eskildstrup = new Node("Eskildsstrup");   Cities.addNode(Eskildstrup);
        Node Haslev = new Node("Haslev");              Cities.addNode(Haslev);
        Node Holbæk = new Node( "Holbæk");             Cities.addNode(Holbæk);
        Node Jærgerspris = new Node("Jærgerspris");    Cities.addNode(Jærgerspris);
        Node Kalundborg = new Node("Kalundborg");      Cities.addNode(Kalundborg);
        Node Korsør = new Node( "Korsør");             Cities.addNode(Korsør);
        Node Køge = new Node("Køge");                  Cities.addNode(Køge);
        Node Maribo = new Node("Maribo");              Cities.addNode(Maribo);
        Node Næstved = new Node("Næstved");            Cities.addNode(Næstved);
        Node Ringsted = new Node("Ringsted");          Cities.addNode(Ringsted);
        Node Slagelse = new Node("Slagelse");          Cities.addNode(Slagelse);
        Node Nykøbing_F = new Node("Nykøbing F");      Cities.addNode(Nykøbing_F);
        Node Vordingborg = new Node("Vordingborg");    Cities.addNode(Vordingborg);
        Node Roskilde = new Node("Roskilde");          Cities.addNode(Roskilde);
        Node Sorø = new Node("Sorø");                  Cities.addNode(Sorø);
        Node Nakskov = new Node("Nakskov");            Cities.addNode(Nakskov);

<<<<<<< Updated upstream
=======
        // ------- EDGES -----
>>>>>>> Stashed changes
        Cities.addEdge(Eskildstrup,Maribo,28);             Cities.addEdge(Jærgerspris,Sorø, 51);
        Cities.addEdge(Eskildstrup,Nykøbing_F, 13);        Cities.addEdge(Kalundborg,Ringsted, 62);
        Cities.addEdge(Eskildstrup,Vordingborg,24);        Cities.addEdge(Kalundborg,Roskilde, 70);
        Cities.addEdge(Haslev,Korsør,60);                  Cities.addEdge(Kalundborg,Slagelse, 39);
        Cities.addEdge(Haslev,Køge,24);                    Cities.addEdge(Kalundborg,Sorø, 51);
        Cities.addEdge(Haslev,Næstved,25);                 Cities.addEdge(Korsør,Næstved, 45);
        Cities.addEdge(Haslev,Ringsted,19);                Cities.addEdge(Korsør,Slagelse, 20);
        Cities.addEdge(Haslev,Roskilde, 47);               Cities.addEdge(Køge,Næstved, 45);
        Cities.addEdge(Haslev,Slagelse, 48);               Cities.addEdge(Køge,Ringsted, 28);
        Cities.addEdge(Haslev,Sorø,34);                    Cities.addEdge(Køge,Roskilde, 25);
        Cities.addEdge(Haslev,Vordingborg, 40);            Cities.addEdge(Køge,Vordingborg, 60);
        Cities.addEdge(Holbæk,Jærgerspris,34);             Cities.addEdge(Maribo,Nakskov, 27);
        Cities.addEdge(Holbæk,Kalundborg, 44);             Cities.addEdge(Maribo,Nykøbing_F, 26);
        Cities.addEdge(Holbæk,Korsør, 66);                 Cities.addEdge(Næstved,Roskilde, 57);
        Cities.addEdge(Holbæk,Ringsted, 36);               Cities.addEdge(Næstved,Ringsted, 26);
        Cities.addEdge(Holbæk,Roskilde, 32);               Cities.addEdge(Næstved,Slagelse, 37);
        Cities.addEdge(Holbæk,Slagelse, 46);               Cities.addEdge(Næstved,Sorø, 32);
        Cities.addEdge(Holbæk,Sorø, 63);                   Cities.addEdge(Næstved,Vordingborg, 28);
        Cities.addEdge(Jærgerspris,Korsør, 95);            Cities.addEdge(Ringsted,Roskilde, 31);
        Cities.addEdge(Jærgerspris,Køge, 58);              Cities.addEdge(Ringsted,Sorø, 15);
        Cities.addEdge(Jærgerspris,Ringsted, 56);          Cities.addEdge(Ringsted,Vordingborg, 58);
        Cities.addEdge(Jærgerspris,Roskilde, 33);          Cities.addEdge(Slagelse,Sorø, 14);
        Cities.addEdge(Jærgerspris,Slagelse, 74);

        //------------------------------OPERATIONS-----------------------------//

        //Cities.PrintGraph();

    }
}
