import java.util.*;

class BFS {
    static int vertex = 8;
    static boolean visited[] = new boolean[vertex];
    static Queue<Integer> queue = new LinkedList<>();  // queue for BFS


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
        addEdge(graph, 4, 5);
        addEdge(graph, 6, 2);
        addEdge(graph, 7, 0);
        addEdge(graph, 7, 6);
        addEdge(graph, 7, 2);
        addEdge(graph, 1, 3);

        breadthFirstSearch(graph, 0);
    }


    static void breadthFirstSearch(ArrayList<ArrayList<Integer>> graph , int index) {
        
        queue.add(index);
        visited[index] = true;

        while(queue.size() != 0){
            for(int j=0; j<graph.get(queue.peek()).size();j++) {
                if(!(visited[ graph.get( queue.peek() ) . get(j) ])) {
                    queue.add(graph.get(queue.peek()).get(j));
                    visited[graph.get( queue.peek() ) . get(j) ] = true;
                }
            }
            System.out.println(queue.peek());
            queue.remove();
        }

    }





    // Extra code
    // ________________________________________________________________________________________________
    // ________________________________________________________________________________________________


    static void showGraph(ArrayList<ArrayList<Integer>> graph) {
        for(int i=0;i< graph.size(); i++ ){
            System.out.print("Vertex : " + i + " : ");
            for(int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> "+ graph.get(i).get(j));
            }
        }
    }

}

