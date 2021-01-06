import java.util.*;

class TopologicalSortOptimized {
    static int vertex = 5;
    static boolean visited[] = new boolean[vertex];
    static int ordering[] = new int[vertex];

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) { 
        graph.get(source).add(destination);  // Directed Graph (DAG)
    }


    public static void main(String args[]){
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(vertex);
        for(int i=0;i<vertex;i++){
            graph.add(new ArrayList<Integer>());
            visited[i] = false;
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 4, 3);

        topSort(graph);
        for(int i=0;i<vertex;i++) {
            System.out.println(ordering[i]);
        }
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

