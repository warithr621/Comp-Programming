// https://leetcode.com/problems/valid-arrangement-of-pairs/description/?envType=daily-question&envId=2024-11-30

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>(), out = new HashMap<>();
        for (int[] edge : pairs) {
            int start = edge[0], end = edge[1];
            adj.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            out.put(start, out.getOrDefault(start, 0) + 1);
            in.put(end, in.getOrDefault(end, 0) + 1);
        }
        List<Integer> path = new ArrayList<>();
        int start = -1;
        for (int node : out.keySet()) {
            if (out.get(node) == in.getOrDefault(node, 0) + 1) {
                start = node;
                break;
            }
        }
        if (start == -1)
            start = pairs[0][0];
        
        dfs(start, adj, path);
        Collections.reverse(path);
        int[][] ans = new int[path.size() - 1][2];
        for (int i = 1; i < path.size(); i++)
            ans[i-1] = new int[]{path.get(i-1), path.get(i)};
        
        return ans;
    }

    private void dfs(int node, Map<Integer, Deque<Integer>> adj, List<Integer> path) {
        Deque<Integer> neighbors = adj.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            int next = neighbors.pollFirst();
            dfs(next, adj, path);
        }
        path.add(node);
    }
}