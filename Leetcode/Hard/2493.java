// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/?envType=daily-question&envId=2025-01-30

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0] - 1).add(e[1] - 1);
            adj.get(e[1] - 1).add(e[0] - 1);
        }
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int node = 0; node < n; node++) {
            if (colors[node] != -1) continue;
            colors[node] = 0;
            if (!bipartite(adj, node, colors)) return -1;
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) d[i] = path(adj, i, n);

        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            ans += solve(adj, i, d, vis);
        }
        return ans;
    }

    private boolean bipartite(ArrayList<ArrayList<Integer>> adj, int node, int[] colors) {
        for (int dest : adj.get(node)) {
            if (colors[dest] == colors[node]) return false;
            if (colors[dest] != -1) continue;
            colors[dest] = colors[node] ^ 1;
            if (!bipartite(adj, dest, colors)) return false;
        }
        return true;
    }

    private int path(ArrayList<ArrayList<Integer>> adj, int src, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(src);
        vis[src] = true;
        int d = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                for (int dest : adj.get(cur)) {
                    if (vis[dest]) continue;
                    vis[dest] = true;
                    q.add(dest);
                }
            }
            ++d;
        }
        return d;
    }

    private int solve(ArrayList<ArrayList<Integer>> adj, int node, int[] d, boolean[] vis) {
        int mx = d[node];
        vis[node] = true;
        for (int dest : adj.get(node)) {
            if (vis[dest]) continue;
            mx = Math.max(mx, solve(adj, dest, d, vis));
        }
        return mx;
    }

}