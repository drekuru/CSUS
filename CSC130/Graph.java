import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    // fields
    public int[][] g;
    public int v;
    public int E;

    public void addEdge(int v1, int v2) {

    }

    public boolean isAdjacent(int v1, int v2) {
        return g[v1][v2] == 1;
    }

    public boolean isConnected(int v1, int v2) {
        int[] bfs = BFStoArray(v1);

        for (int i = 0; i < bfs.length; i++) {
            if (bfs[i] == v2)
                return true;
        }
        return false;
    }

    public int[] adj(int v) {
        ArrayList<Integer> a1 = new ArrayList<>();

        for (int i = 0; i < this.v; i++) {
            if (g[v][i] == 1)
                a1.add(i);
        }
        int[] ret = new int[a1.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = a1.get(i);
        }
        return ret;
    }

    public int[] BFStoArray(int v) {
        ArrayList<Integer> a1 = new ArrayList<>();
        boolean[] visited = new boolean[this.v];

        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        int visit;

        while (!q.isEmpty()) {
            visit = q.remove();
            a1.add(visit);

            for (int i = 0; i < this.v; i++) {
                if(isAdjacent(visit, i) && !visited[i])
                {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        int [] ret = new [a1.size()];
        for(int i = 0; i < ret.length; i++)
        {
            ret[i] = a1.get(i);
        }
        return ret;
    }

    public String BFS(int v) {

    }

    public String DFS(int v) {

    }

    public String DFS(int v, boolean[] visited, String str) {
        str += v + " ";
        visited[v] = true;

        return "Hello";
    }
} // end of Graph class