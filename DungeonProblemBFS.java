import java.util.*;

class DungeonProblemBFS {
    static int row = 5, column = 7;
    static boolean visited[][] = new boolean[row][column];
    static Queue<Integer> rqueue = new LinkedList<>();  // row queue for BFS
    static Queue<Integer> cqueue = new LinkedList<>();  // column queue for BFS
    

    static int grid[][] = { 
        {0, 1, 1,-1, 1, 1, 1},
        {1,-1, 1, 1, 1,-1, 1},
        {1,-1, 1, 1, 1, 1, 1},
        {1, 1,-1,-1, 1, 1, 1},
        {-1,1,-1, 2, 1,-1, 1}
    };
    
    static int moveCount = 0;
    static int nodesInThisLayer = 1;
    static int nodesInNextLayer = 0;

    static boolean reachedEnd = false;

    static int rowDirection[] =    {-1,1,0,0};
    static int columnDirection[] = {0,0,-1,1};


    static int startRow = 0, startColumn = 0;  // starting position on the grid

    public static void main(String args[]){
        
        /*
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                grid[i][j] = sc.nextInt();  // 0 for start 2 for End 1 for movement and -1 for not allowed
                visited[i][j] = false;
            }
        }
        sc.close();
        */

        int count = breadthFirstSearch();
        System.out.println(count);
    }


    static int breadthFirstSearch() {
        rqueue.add(startRow);
        cqueue.add(startColumn);  // Enquing the indices of the start point , not the no of node itself.

        visited[startRow][startColumn] = true;

        while(rqueue.size() != 0) {  // Also could have checked cqueue.size()
            int r = rqueue.remove();
            int c = cqueue.remove();

            if (grid[r][c] == 2) {
                reachedEnd = true;
                break;
            }

            exploreNeighbour(r,c);

            nodesInThisLayer--;

            if (nodesInThisLayer == 0) {
                nodesInThisLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }
        }
        if(reachedEnd) {
            return moveCount;
        }
        return -1;
    }


    static void exploreNeighbour(int r, int c){
        for(int i=0;i<4;i++){
            int rr = r + rowDirection[i];
            int cc = c + columnDirection[i];

            if(rr < 0 || cc < 0 || rr>=row || cc >=column || (visited[rr][cc]==true) || (grid[rr][cc] == -1)) {
                continue;
            }

            rqueue.add(rr);
            cqueue.add(cc);
            visited[rr][cc] = true;
            nodesInNextLayer++;
        }
    }

}

