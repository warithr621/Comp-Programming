// done via Neetcode
// https://neetcode.io/problems/valid-tree

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // a graph is a tree if
        // - it has N nodes and N-1 edges
        // - no cycles exist
        // - only one simple path exists between any pair of nodes
        if (edges.length != n-1) return false; // 1st condition
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{-1, 0});
        while (!q.isEmpty()) {
            int prev = q.peek()[0];
            int src = q.poll()[1];
            if (vis[src]) return false; // 2nd condition
            vis[src] = true;
            for (int dest : adj[src]) {
                if (!vis[dest] && prev != dest) {
                    q.add(new int[]{src, dest});
                } 
            }

        }
        for (boolean b : vis) {
            if (!b) return false; // 3rd condition
        }
        return true;
    }
}
