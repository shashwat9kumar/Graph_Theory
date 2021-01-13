import java.util.*;

public class practice {


    private static final double EPS = 1e-6;



    public static class Edge {
        int to, from, cost;
        public Edge(int from, int to, int cost){
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    } 

    static void addEdge(int from, int to, int cost) {
        graph.get(from).add(new Edge(from, to, cost));
    }



    public static class Node {
        int id;
        double value;
    
        public Node(int id, double value) {
          this.id = id;
          this.value = value;
        }
    }

    static Comparator<Node> comparator = new Comparator<Node>() {
        public int compare(Node node1, Node node2) {
          if (Math.abs(node1.value - node2.value) < EPS) return 0;
          return (node1.value - node2.value) > 0 ? +1 : -1;
        }
    };

    static int vertex = 5;
    static boolean visited[] = new boolean[vertex];
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(vertex);
    static int cost[] = new int[vertex];
    static int previous[] = new int[vertex];
    static PriorityQueue<Node> pq = new PriorityQueue<>(2*vertex , comparator);

    public static void main(String Args[]) {
        for(int i=0;i<vertex;i++) {
            graph.add(new ArrayList<Edge>());
        }
        Arrays.fill(cost, 2147483641);
        Arrays.fill(visited, false);
        Arrays.fill(previous, -1);

    }




    static void dijkstra(int start, int end) {
        pq.add(new Node(start, 0));

        while(!(pq.isEmpty())) {
            Node node = pq.poll();
            visited[node.id] = true;
        }

    }
}
