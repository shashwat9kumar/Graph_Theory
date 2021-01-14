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
        int value;
    
        public Node(int id, int value) {
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

    static int vertex = 6;
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

        addEdge(0, 1, 5);
        addEdge(0, 2, 1);
        addEdge(1, 2, 2);
        addEdge(2, 1, 3);
        addEdge(1, 3, 3);
        addEdge(1, 4, 20);
        addEdge(2, 4, 12);
        addEdge(3, 2, 3);
        addEdge(3, 4, 2);
        addEdge(3, 5, 6);
        addEdge(4, 5, 1);
        dijkstra(0, 5);

        //showGraph();
        for(int i=0;i<vertex;i++) {
            System.out.println(i + "\t->\t" + cost[i]);
        }

    }




    static void dijkstra(int start, int end) {
        pq.add(new Node(start, 0));
        cost[start] = 0;
        while(!(pq.isEmpty())) {
            Node node = pq.poll();
            visited[node.id] = true;
            
            //System.out.println("Intermediate cost\t" + node.id + "\t" + cost[node.id]);
            if (cost[node.id] < node.value) continue;


            ArrayList<Edge> edges = graph.get(node.id);
            for(int i=0;i<edges.size();i++) {

                Edge e = edges.get(i);
                if(visited[e.to]) {
                    continue;
                }
                int dist = e.cost + cost[e.from];
                if(dist < cost[e.to]) {
                    cost[e.to] = dist;
                    pq.add(new Node(e.to, cost[e.to]));
                }
            }

        }

    }


    static void showGraph() {
        for(int i=0;i< graph.size(); i++ ){
            System.out.print("Vertex : " + i + " : ");
            ArrayList<Edge> edges = graph.get(i);
            for(int j = 0; j < edges.size(); j++) {
                Edge e = edges.get(j);
                System.out.print(" -> "+ "("+e.cost+")" + " : " + e.to);
            }
            System.out.println();
        }
    }
}

/*



*/