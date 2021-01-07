import java.util.*;

/// THe shortest Path of each node on a DAG (ordered by toplogogical ordering)

class DijkstraAlgorithm {
    static int vertex = 8;
     
    static boolean visited[] = new boolean[vertex];
    static int ordering[] = new int[vertex];
    static int adMat[][] = new int[vertex][vertex];  // Adjacency Matrix for storing edge weight
    static int leastDistance[] = new int[vertex];  // Stores the least distance of node i (index i)


    //Weighted Edge being created
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination, int weight) { 
        graph.get(source).add(destination);  // Directed Graph (DAG)
        adMat[source][destination] = weight;
    }



    public static void main(String args[]){
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(vertex);
        

        Arrays.fill(leastDistance, 2147483641);


        for(int i=0;i<vertex;i++){
            graph.add(new ArrayList<Integer>());
            visited[i] = false;
        }

        addEdge(graph, 0, 1, 3);
        addEdge(graph, 0, 2, 6);
        addEdge(graph, 2, 3, 6);
        addEdge(graph, 1, 2, 4);
        addEdge(graph, 1, 3, 4);
        addEdge(graph, 1, 4, 11);
        addEdge(graph, 2, 6, 11);
        addEdge(graph, 3, 4, -4);
        addEdge(graph, 3, 6, 2);
        addEdge(graph, 3, 5, 5);
        addEdge(graph, 4, 7, 9);
        addEdge(graph, 5, 7, 1);
        addEdge(graph, 6, 7, 2);

        // Lets implement Dijkstra's Algorithm
        // Step 1 : Get a topological Ordering

        topSort(graph);
        System.out.print("NODES of THE GRAPH               :  ");
        for(int i=0;i<vertex;i++) {
            System.out.print(ordering[i] + "\t-->");
        }
        System.out.println();

        // Odering is now in ordering[] array

        // Step 2: Dijkstra's algorithm

        leastDistance[ordering[0]] = 0;
        dijkstra(graph, ordering[0]);

        System.out.print("THEIR RESPECTIVE LEAST DISTANCES :  ");
        for(int i=0;i<vertex;i++) {
            System.out.print(leastDistance[ordering[i]] + "\t-->");
        }
        System.out.println();
        
    }


    static void topSort(ArrayList<ArrayList<Integer>> graph) {
        int i = vertex - 1; // Index for ordering array

        for(int at = 0; at< vertex; at++) {
            if (!(visited[at])) {
                i = depthFirstSearch(i,at, graph);
            }
        }
    }


    static int depthFirstSearch(int i, int at, ArrayList<ArrayList<Integer>> graph ) {
        visited[at] = true;
        for(int j = 0; j< graph.get(at).size(); j++) {
            int node = graph.get(at).get(j);
            if(!(visited[node])) {
                i = depthFirstSearch(i,node, graph);
            }
        }
        ordering[i]= at;
        return i-1;
    }



    static void dijkstra(ArrayList<ArrayList<Integer>> graph, int startNode) {
        for(int i=0;i<ordering.length;i++) {
            int node = ordering[i];

            for(int j=0;j<graph.get(node).size();j++) {
                int childNode = graph.get(node).get(j);

                if(leastDistance[childNode] > (leastDistance[node] + adMat[node][childNode])) {
                    leastDistance[childNode] = leastDistance[node] + adMat[node][childNode];
                }
            }
        }
    }

    //Extra Code 
    // ____________________________________________________________________________________
    // ____________________________________________________________________________________

    static void showGraph(ArrayList<ArrayList<Integer>> graph) {
        for(int i=0;i< graph.size(); i++ ){
            System.out.print("Vertex : " + i + " : ");
            for(int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> "+ graph.get(i).get(j));
            }
        }
    }

}

