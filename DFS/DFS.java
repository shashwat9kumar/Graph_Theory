import java.util.*;

class DFS {
    static int vertex = 5;
    static boolean visited[] = new boolean[vertex];

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
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

        depthFirstSearch(graph, 0);
    }


    static void depthFirstSearch(ArrayList<ArrayList<Integer>> graph , int index) {
        if(visited[index]){
            return;
        }

        visited[index] = true;
        System.out.println(index);
        for(int j = 0; j < graph.get(index).size(); j++) {
            depthFirstSearch(graph, graph.get(index).get(j));
        }
    }


    static void showGraph(ArrayList<ArrayList<Integer>> graph) {
        for(int i=0;i< graph.size(); i++ ){
            System.out.print("Vertex : " + i + " : ");
            for(int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> "+ graph.get(i).get(j));
            }
        }
    }

}

