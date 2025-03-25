class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]}); // destination, weight
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        boolean[] vis = new boolean[n];
        int[] comps = new int[n];
        List<Integer> costs = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            
            int curCost = Integer.MAX_VALUE;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (vis[cur]) continue;
                vis[cur] = true;
                comps[cur] = id;
                for (int[] edge : adj.get(cur)) {
                    if (!vis[edge[0]]) {
                        q.add(edge[0]);
                        curCost &= edge[1];
                    }
                }
            }
            costs.add(curCost);
            id++;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            ans[i] = (comps[x] == comps[y] ? costs.get(comps[x]) : -1);
        }
        return ans;
    }
}