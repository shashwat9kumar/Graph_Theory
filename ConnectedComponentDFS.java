import java.util.*;

public class ConnectedComponentDFS {

    static int vertex = 12;
    static boolean visited[] = new boolean[vertex];
    static int component[] = new int[vertex];
    static int count = 0;

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }


    public static void main(String args[]){
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(vertex);
        for(int i=0;i<vertex;i++){
            graph.add(new ArrayList<Integer>());
            visited[i] = false;
            component[i] = -1;
        }

        addEdge(graph, 0, 11);
        addEdge(graph, 0, 10);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 9);
        addEdge(graph, 1, 9);
        addEdge(graph, 10, 9);
        addEdge(graph, 10, 11);

        addEdge(graph, 2, 3);
        addEdge(graph, 3, 6);
        addEdge(graph, 6, 2);

        addEdge(graph, 4, 5);
        addEdge(graph, 5, 8);
        addEdge(graph, 5, 7);

        findComponent(graph);

        System.out.println(count);
        for(int i=0;i<vertex;i++){
            System.out.println(i + " : " + component[i]);
        }
    }


    static void findComponent(ArrayList<ArrayList<Integer>> graph) {

        for(int i=0;i<vertex;i++) {
            if(visited[i] == false) {
                count++;
                depthFirstSearch(graph, i);
            }
        }

    }

    static void depthFirstSearch(ArrayList<ArrayList<Integer>> graph , int index) {
        if(visited[index]){
            return;
        }

        visited[index] = true;
        component[index] = count;
        //System.out.println(index);
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
