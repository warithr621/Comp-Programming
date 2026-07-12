// https://leetcode.com/problems/network-recovery-pathways/description/?envType=daily-question&envId=2026-07-03

class Solution {

    static List<List<int[]>> adj;
    static int n;
    static long MAX;
    static int[] topo;

    public static void compute() {
        int[] indeg = new int[n];
        for (int u = 0; u < n; u++) {
            for (int[] e : adj.get(u)) {
                indeg[e[0]]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        topo = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] e : adj.get(u)) {
                int v = e[0];
                if (--indeg[v] == 0) q.add(v);
            }
        }
    }

    public static boolean satisfiable(long lim, boolean[] online) {
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int node = topo[i];
            if (dp[node] == Long.MAX_VALUE) continue;
            long dist = dp[node];
            for (int[] e : adj.get(node)) {
                int next = e[0];
                int weight = e[1];
                if (weight < lim || !online[next]) continue;
                if (dist + weight < dp[next]) {
                    dp[next] = dist + weight;
                }
            }
        }
        return dp[n-1] <= MAX;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;
        MAX = k;
        long biggest = 0;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            biggest = Math.max(biggest, e[2]);
        }

        compute();
        long L = 0, R = biggest, best = -1;
        while (L <= R) {
            long M = L + (R - L) / 2;
            if (satisfiable(M, online)) {
                best = M;
                L = ++M;
            } else {
                R = --M;
            }
        }
        return (int) best;
    }
}