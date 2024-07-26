import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GraphImplementation {
    private int[][] adjacencyMatrix;
    private Map<Integer, String> indexToCityMap;
    private Map<String, Integer> cityToIndexMap;

    public GraphImplementation(int size) {
        adjacencyMatrix = new int[size][size];
        indexToCityMap = new HashMap<>();
        cityToIndexMap = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public void addCity(int index, String cityName) {
        indexToCityMap.put(index, cityName);
        cityToIndexMap.put(cityName, index);
    }

    public int getIndexByCityName(String cityName) {
        for (Map.Entry<String, Integer> entry : cityToIndexMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(cityName)) {
                return entry.getValue();
            }
        }
        return -1;
    }

    public void displayAdjacencyMatrix() {
        System.out.println("\nAdjacency Matrix:");
   
        System.out.print("             ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.printf("%-12s", indexToCityMap.get(i));
        }
        System.out.println();
    
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.printf("%-12s", indexToCityMap.get(i));
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.printf("%-12d", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public void findShortestRoute(String sourceCity, String destinationCity) {
        int sourceIndex = getIndexByCityName(sourceCity);
        int destinationIndex = getIndexByCityName(destinationCity);
    
        int[] distance = new int[adjacencyMatrix.length];
        boolean[] visited = new boolean[adjacencyMatrix.length];
        int[] previous = new int[adjacencyMatrix.length];
    
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }
    
        distance[sourceIndex] = 0;
        pq.add(new Node(sourceIndex, 0));
    
        while (!pq.isEmpty()) {
            int current = pq.poll().getIndex();
            visited[current] = true;
            for (int neighbor = 0; neighbor < adjacencyMatrix[current].length; neighbor++) {
                int weight = adjacencyMatrix[current][neighbor];
                if (weight > 0 && !visited[neighbor]) {
                    int newDistance = distance[current] + weight;
                    if (newDistance < distance[neighbor]) {
                        distance[neighbor] = newDistance;
                        previous[neighbor] = current;
                        pq.add(new Node(neighbor, distance[neighbor]));
                    }
                }
            }
        }
    
        printShortestPath(sourceIndex, destinationIndex, previous);
        printShortestDistance(destinationIndex, distance);
    }
    
    private void printShortestDistance(int destination, int[] distance) {
        System.out.println("Shortest Distance: " + distance[destination] + " km");
    }

    private void printShortestPath(int source, int destination, int[] previous) {
        System.out.println(
                "\nShortest Path from " + indexToCityMap.get(source) + " to " + indexToCityMap.get(destination) + ":");
        int current = destination;
        StringBuilder path = new StringBuilder(indexToCityMap.get(destination));
        while (previous[current] != -1) {
            path.insert(0, " -> ");
            path.insert(0, indexToCityMap.get(previous[current]));
            current = previous[current];
        }
        System.out.println(path);
    }

    private static class Node implements Comparable<Node> {
        private final int index;
        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        GraphImplementation graph = new GraphImplementation(30);
    
        graph.addCity(0, "Surabaya");
        graph.addCity(1, "Gresik");
        graph.addCity(2, "Sidoarjo");
        graph.addCity(3, "Mojokerto");
        graph.addCity(4, "Jombang");
        graph.addCity(5, "Bojonegoro");
        graph.addCity(6, "Lamongan");
        graph.addCity(7, "Tuban");
        graph.addCity(8, "Madiun");
        graph.addCity(9, "Ngawi");
        graph.addCity(10, "Magetan");
        graph.addCity(11, "Ponorogo");
        graph.addCity(12, "Pacitan");
        graph.addCity(13, "Kediri");
        graph.addCity(14, "Nganjuk");
        graph.addCity(15, "Tulungagung");
        graph.addCity(16, "Blitar");
        graph.addCity(17, "Trenggalek");
        graph.addCity(18, "Malang");
        graph.addCity(19, "Pasuruan");
        graph.addCity(20, "Probolinggo");
        graph.addCity(21, "Lumajang");
        graph.addCity(22, "Bondowoso");
        graph.addCity(23, "Situbondo");
        graph.addCity(24, "Jember");
        graph.addCity(25, "Banyuwangi");
        graph.addCity(26, "Bangkalan");
        graph.addCity(27, "Sampang");
        graph.addCity(28, "Pamekasan");
        graph.addCity(29, "Sumenep");

        graph.addEdge(0, 1, 18); // surabaya - gresik
        graph.addEdge(0, 26, 28); // surabaya - bangkalan
        graph.addEdge(0, 2, 23); // surabaya - sidoarjo
        graph.addEdge(0, 3, 49); // surabaya - mojokerto
        graph.addEdge(1, 6, 27); // gresik - lamongan
        graph.addEdge(1, 26, 46); // gresik - bangkalan
        graph.addEdge(2, 3, 72); // sidoarjo - mojokerto
        graph.addEdge(2, 18, 66); // sidoarjo - malang
        graph.addEdge(2, 19, 39); // sidoarjo - pasuruhan
        graph.addEdge(3, 4, 30); // mojokerto - jombang 
        graph.addEdge(4, 13, 44); // jombang - kediri
        graph.addEdge(4,14, 40 ); // jombang - nganjuk
        graph.addEdge(5, 7, 65); // bojonegoro - tuban
        graph.addEdge(5, 14, 125); // bojonegoro - nganjuk
        graph.addEdge(5, 9, 78); // bojonegoro - ngawi
        graph.addEdge(6, 7, 58); // lamongan - tuban
        graph.addEdge(8, 9, 32); // madiun - ngawi
        graph.addEdge(8, 10, 24); // madiun - magetan  
        graph.addEdge(8, 11, 29); // madiun - ponorogo
        graph.addEdge(8, 14, 50); // madiun - nganjuk
        graph.addEdge(9, 10, 34); //ngawi - magetan
        graph.addEdge(10, 11, 53); // magetan - ponorogo
        graph.addEdge(11, 12, 78); // ponoroo - pacitan
        graph.addEdge(11, 17, 52); // ponorogo - trenggalek
        graph.addEdge(12 ,17, 117); // pacitan - trenggalek
        graph.addEdge(13, 14, 28); // kediri - nganjuk
        graph.addEdge(13, 15, 31); // kediri - tulunggagung
        graph.addEdge(13, 16, 44); // kediri - blitar 
        graph.addEdge(13, 18, 100); // kediri - malang
        graph.addEdge(15, 17, 32); // tulungagung - trenggalek
        graph.addEdge(15, 16, 33); // tulungagung - blitar
        graph.addEdge(16, 18, 78); // blitar - malang
        graph.addEdge(18, 19, 55); // malang - pasuruhan
        graph.addEdge(18, 21, 112); // malang - lumajang 
        graph.addEdge(19, 20, 39); // pasuruhan - probolinggo 
        graph.addEdge(20, 23, 95); // probolinggo - situbondo
        graph.addEdge(20, 22, 92); // probolinggo - bondowoso
        graph.addEdge(20, 24, 96); // probolinggo - jember
        graph.addEdge(20, 21, 46); // probolinggo - lumajang 
        graph.addEdge(21, 24, 72); // lumajang - jember
        graph.addEdge(22, 23, 35); // bondowoso - situbondo 
        graph.addEdge(22, 24, 32); // bondowoso - jember
        graph.addEdge(23, 25, 94); // situbondo - banyuwangi
        graph.addEdge(24, 25, 105); // jember - banyuwangi
        graph.addEdge(26, 27, 62); // bangkalan - sampang
        graph.addEdge(26, 28, 96); // bangkalan - pamekasan
        graph.addEdge(27, 29, 85); // sampang - sumenep
        graph.addEdge(27, 28, 33); // sampang - pamekasan 
        graph.addEdge(28, 29, 52); // pamekasan - sumenep

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("a. Display Adjacency Matrix");
            System.out.println("b. Find Shortest Route");
            System.out.println("c. Exit");
            System.out.print("Choose an option: ");
            char choice = scanner.next().charAt(0);
            
            scanner.nextLine();
        
            switch (choice) {
                case 'a':
                    graph.displayAdjacencyMatrix();
                    break;
                case 'b':
                    System.out.print("Enter source city: ");
                    String sourceCity = scanner.nextLine();
                    System.out.print("Enter destination city: ");
                    String destinationCity = scanner.nextLine();
                    graph.findShortestRoute(sourceCity, destinationCity);
                    break;
                case 'c':
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

