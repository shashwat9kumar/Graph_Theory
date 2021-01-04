import java.util.*;

class BFS_ForStartAndEndNode {
    static int vertex = 8;
    static boolean visited[] = new boolean[vertex];
    static int previous[] = new int[vertex];
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
            previous[i] = -1;
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 2);
        addEdge(graph, 4, 5);
        addEdge(graph, 6, 2);
        addEdge(graph, 7, 0);
        addEdge(graph, 7, 6);
        addEdge(graph, 7, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 6, 5);


        breadthFirstSearchWithStartAndEndNode(graph, 0, 5); // Find path from 0 to 5 
    }


    static void breadthFirstSearchWithStartAndEndNode(ArrayList<ArrayList<Integer>> graph , int index, int endNode) {
        
        queue.add(index);
        visited[index] = true;


        while(queue.size() != 0){
            for(int j=0; j<graph.get(queue.peek()).size();j++) {
                if(!(visited[ graph.get( queue.peek() ) . get(j) ])) {
                    queue.add(graph.get(queue.peek()).get(j));
                    visited[graph.get( queue.peek() ) . get(j) ] = true;
                    previous[ graph.get( queue.peek() ) . get(j) ] = queue.peek();  // To mark the previous node before this current node.
                }
            }
            //System.out.println(queue.peek());
            queue.remove();
        }


        // Reconstruct the path from start node (index) to end node (endNode)
        ArrayList<Integer> path = new ArrayList<Integer>();
        for(int i=endNode; i != -1; i = previous[i]) {
            path.add(i);
        }

        if(path.size() != 0){
            for(int i=path.size()-1;i>=0;i--) {  // printing the path in reverse order (start to end)
                System.out.print(path.get(i) + " -> ");
            }
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

