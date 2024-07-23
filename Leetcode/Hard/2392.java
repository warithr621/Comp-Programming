// https://leetcode.com/problems/build-a-matrix-with-conditions/?envType=daily-question&envId=2024-07-21

import java.util.*;

class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> toporow = topoSort(rowConditions, k);
        List<Integer> topocol = topoSort(colConditions, k);

        // guhhhhh
        if (toporow.isEmpty() || topocol.isEmpty()) return new int[0][0];

        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (toporow.get(i).equals(topocol.get(j))) {
                    matrix[i][j] = toporow.get(i);
                }
            }
        }
        return matrix;
    }

    private List<Integer> topoSort(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> topo = new ArrayList<>();
        int[] vis = new int[n+1]; // 0 = nonvis, 1 = currently on, 2 = visited alr
        boolean[] cyclic = {false}; // if I make this a var it gets passed by value

        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, topo, cyclic);
                if (cyclic[0]) return new ArrayList<>();
            }
        }

        Collections.reverse(topo);
        return topo;
    }

    private void dfs(int cur, List<List<Integer>> adj, int[] vis, List<Integer> topo, boolean[] cyclic) {
        vis[cur] = 1;
        for (int dest : adj.get(cur)) {
            if (vis[dest] == 0) {
                dfs(dest, adj, vis, topo, cyclic);
                if (cyclic[0]) return; // i hate that cycles can be found
            } else if (vis[dest] == 1) {
                // how did we just get to a node we are visiting???
                cyclic[0] = true;
                return;
            }
        }
        vis[cur] = 2; // ok now we're done
        topo.add(cur);
    }
}