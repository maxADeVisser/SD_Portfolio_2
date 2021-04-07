import java.util.jar.JarEntry;

public class Main {

    public static void main(String[] args) {
        AdjacencyGraph Cities = new AdjacencyGraph(); //initializes the adjecency graph

        Vertex Eskildstrup = new Vertex("Eskildsstrup");   Cities.addVertex(Eskildstrup);
        Vertex Haslev = new Vertex("Haslev");              Cities.addVertex(Haslev);
        Vertex Holbæk = new Vertex( "Holbæk");             Cities.addVertex(Holbæk);
        Vertex Jærgerspris = new Vertex("Jærgerspris");    Cities.addVertex(Jærgerspris);
        Vertex Kalundborg = new Vertex("Kalundborg");      Cities.addVertex(Kalundborg);
        Vertex Korsør = new Vertex( "Korsør");             Cities.addVertex(Korsør);
        Vertex Køge = new Vertex("Køge");                  Cities.addVertex(Køge);
        Vertex Maribo = new Vertex("Maribo");              Cities.addVertex(Maribo);
        Vertex Næstved = new Vertex("Næstved");            Cities.addVertex(Næstved);
        Vertex Ringsted = new Vertex("Ringsted");          Cities.addVertex(Ringsted);
        Vertex Slagelse = new Vertex("Slagelse");          Cities.addVertex(Slagelse);
        Vertex Nykøbing_F = new Vertex("Nykøbing F");      Cities.addVertex(Nykøbing_F);
        Vertex Vordingborg = new Vertex("Vordingborg");    Cities.addVertex(Vordingborg);
        Vertex Roskilde = new Vertex("Roskilde");          Cities.addVertex(Roskilde);
        Vertex Sorø = new Vertex("Sorø");                  Cities.addVertex(Sorø);
        Vertex Nakskov = new Vertex("Nakskov");            Cities.addVertex(Nakskov);

        Cities.addEdge(Eskildstrup,Maribo,28);
        Cities.addEdge(Eskildstrup,Nykøbing_F, 13);
        Cities.addEdge(Eskildstrup,Vordingborg,24);
        Cities.addEdge(Haslev,Korsør,60);
        Cities.addEdge(Haslev,Køge,24);
        Cities.addEdge(Haslev,Næstved,25);
        Cities.addEdge(Haslev,Ringsted,19);
        Cities.addEdge(Haslev,Roskilde, 47);
        Cities.addEdge(Haslev,Slagelse, 48);
        Cities.addEdge(Haslev,Sorø,34);
        Cities.addEdge(Haslev,Vordingborg, 40);
        Cities.addEdge(Holbæk,Jærgerspris,34);
        Cities.addEdge(Holbæk,Kalundborg, 44);
        Cities.addEdge(Holbæk,Korsør, 66);
        Cities.addEdge(Holbæk,Ringsted, 36);
        Cities.addEdge(Holbæk,Roskilde, 32);
        Cities.addEdge(Holbæk,Slagelse, 46);
        Cities.addEdge(Holbæk,Sorø, 63);
        Cities.addEdge(Jærgerspris,Korsør, 95);
        Cities.addEdge(Jærgerspris,Køge, 58);
        Cities.addEdge(Jærgerspris,Ringsted, 56);
        Cities.addEdge(Jærgerspris,Roskilde, 33);
        Cities.addEdge(Jærgerspris,Slagelse, 74);
        Cities.addEdge(Jærgerspris,Sorø, 51);
        Cities.addEdge(Kalundborg,Ringsted, 62);
        Cities.addEdge(Kalundborg,Roskilde, 70);
        Cities.addEdge(Kalundborg,Slagelse, 39);
        Cities.addEdge(Kalundborg,Sorø, 51);
        Cities.addEdge(Korsør,Næstved, 45);
        Cities.addEdge(Korsør,Slagelse, 20);
        Cities.addEdge(Køge,Næstved, 45);
        Cities.addEdge(Køge,Ringsted, 28);
        Cities.addEdge(Køge,Roskilde, 25);
        Cities.addEdge(Køge,Vordingborg, 60);
        Cities.addEdge(Maribo,Nakskov, 27);
        Cities.addEdge(Maribo,Nykøbing_F, 26);
        Cities.addEdge(Næstved,Roskilde, 57);
        Cities.addEdge(Næstved,Ringsted, 26);
        Cities.addEdge(Næstved,Slagelse, 37);
        Cities.addEdge(Næstved,Sorø, 32);
        Cities.addEdge(Næstved,Vordingborg, 28);
        Cities.addEdge(Ringsted,Roskilde, 31);
        Cities.addEdge(Ringsted,Sorø, 15);
        Cities.addEdge(Ringsted,Vordingborg, 58);
        Cities.addEdge(Slagelse,Sorø, 14);


        Cities.PrintGraph();

    }
}
