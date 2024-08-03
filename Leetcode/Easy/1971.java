// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (vis[x]) continue;
            vis[x] = true;
            if (x == destination) return true;
            for (int d : adj[x]) {
                if (!vis[d]) q.add(d);
            }
        }
        return false;
    }
}