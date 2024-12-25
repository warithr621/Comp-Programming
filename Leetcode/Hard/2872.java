// https://leetcode.com/problems/maximum-number-of-k-divisible-components/description/?envType=daily-question&envId=2024-12-21

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        for (int i = 0; i < n; i++) {
            values[i] %= k;
        }
        if (n < 2) return 1;
        int ans = 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.computeIfAbsent(u, K -> new HashSet<>()).add(v);
            graph.computeIfAbsent(v, K -> new HashSet<>()).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for (Integer x : graph.keySet()) {
            if (graph.get(x).size() == 1) {
                // leaf
                q.add(x);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            int neighbor = -1;
            if (graph.get(cur) != null && !graph.get(cur).isEmpty()) {
                neighbor = graph.get(cur).iterator().next();
            }
            if (neighbor >= 0) {
                graph.get(cur).remove(neighbor);
                graph.get(neighbor).remove(cur);
            }
            if (values[cur] == 0) {
                ++ans;
            } else if (neighbor >= 0) {
                values[neighbor] = (values[neighbor] + values[cur]) % k;
            }
            if (neighbor >= 0 && graph.get(neighbor) != null && graph.get(neighbor).size() == 1) {
                q.add(neighbor);
            }
        }
        return ans;
    }
}