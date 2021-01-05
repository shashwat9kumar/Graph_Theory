import java.util.*;

class BFSUSingAdjacencyMatrix {
    static int vertex = 8;
    static boolean visited[] = new boolean[vertex];
    static Queue<Integer> queue = new LinkedList<>();  // queue for BFS

    //static int graph[][] = new int[vertex][vertex];  // Adjacency matrix for Graph
    
    static void addEdge(int graph[][], int source, int destination) {
        graph[source][destination] = 1;
        graph[destination][source] = 1;
    }

    public static void main(String args[]){
        
        int graph[][] = new int[vertex][vertex];
        
        for(int i=0;i<vertex;i++) {
            for(int j=0;j<vertex;j++) {
                graph[i][j]=0;
            }
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 5);
        addEdge(graph, 6, 5);
        addEdge(graph, 2, 6);
        addEdge(graph, 0, 7);
        addEdge(graph, 7, 2);
        addEdge(graph, 6, 7);

        breadthFirstSearch(graph, 0);
    }


    static void breadthFirstSearch(int graph[][] , int start) {
        
        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0){
            int row = queue.peek();
            for(int i=0;i<vertex;i++){
                if(graph[row][i] == 1 && (visited[i] != true)) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            System.out.println(queue.peek());
            queue.remove();

        }
        

    }

}

