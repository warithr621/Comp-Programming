// https://leetcode.com/problems/count-the-number-of-complete-components/

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            int curE = 0, cnt = 0;;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()) {
                int node = q.poll();
                if (vis[node]) continue;
                System.out.println(node);
                curE += adj.get(node).size();
                vis[node] = true;
                ++cnt;
                for (int dest : adj.get(node)) {
                    if (!vis[dest]) q.add(dest);
                }
            }
            ans += cnt * (cnt - 1) == curE ? 1 : 0;
        }
        return ans;
    }
}
