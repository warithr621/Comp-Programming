// https://leetcode.com/problems/network-delay-time/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // find sum of min dist between k and all other nodes
        // Dijkstra
        ArrayList<int[]>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<int[]>();
        for (int[] edge : times) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]}); // dest, weight
        }
        int[] dist = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i == k) dist[i] = 0;
            else dist[i] = Integer.MAX_VALUE >> 1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        pq.add(new int[]{0, k}); // dist, node
        while (!pq.isEmpty()) {
            int cur = pq.poll()[1];
            for (int[] dest : adj[cur]) {
                if (dist[dest[0]] > dist[cur] + dest[1]) {
                    dist[dest[0]] = dist[cur] + dest[1];
                    pq.add(new int[]{dist[dest[0]], dest[0]});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (Integer.MAX_VALUE >> 1)) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}