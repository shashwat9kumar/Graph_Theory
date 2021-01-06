import java.util.*;

class TopologicalSort {
    static int vertex = 5;
    static boolean visited[] = new boolean[vertex];
    static int ordering[] = new int[vertex];

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) { 
        graph.get(source).add(destination);
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
                ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
                depthFirstSearch(at, graph, visitedNodes);
                for(int j=0;j<visitedNodes.size();j++) {
                    ordering[i] = visitedNodes.get(j);
                    i=i-1;
                }
            }
        }
    }


    static void depthFirstSearch(int at, ArrayList<ArrayList<Integer>> graph , ArrayList<Integer> visitedNodes) {
        visited[at] = true;
        for(int j = 0; j< graph.get(at).size(); j++) {
            int node = graph.get(at).get(j);

            if(!(visited[node])) {
                depthFirstSearch(node, graph, visitedNodes);
            }
        }
        visitedNodes.add(at);
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

