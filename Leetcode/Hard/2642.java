// https://leetcode.com/problems/design-graph-with-shortest-path-calculator/

class Graph {

    // my original solution used Dijkstra
    // however pre-computing using Floyd-Warshall is way faster
    // even though Floyd-Warshall is O(V^3) every time you run it
    // while Dijkstra is like O(E log V)

    int n;
    int[][] dist;

    public Graph(int n, int[][] edges) {
        this.n = n;
        this.dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) dist[i][j] = 5_000_000;
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
        }
        // now the algorithmic part
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int cur = edge[0], dest = edge[1], w = edge[2];
        if (dist[cur][dest] <= w) {
            // adding this doesn't even change any min distances
            return;
        }
        dist[cur][dest] = w;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.min(dist[i][j], dist[i][cur] + w + dist[dest][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return (dist[node1][node2] == 5_000_000 ? -1 : dist[node1][node2]);
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */