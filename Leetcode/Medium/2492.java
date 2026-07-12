// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/?envType=daily-question&envId=2026-07-04

public class DSU {
    private final int[] parent, rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean unite(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        // find the "smallest" road used in a path from 1 to n
        // a path exists from 1 -> n using a road a -> b
        // if 1,a is connected + b,n is connected
        // or 1,b is connected + a,n is connected
        DSU dsu = new DSU(n+1);
        for (int[] road : roads) {
            dsu.unite(road[0], road[1]);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (dsu.connected(1, road[0])) {
                ans = Math.min(ans, road[2]);
            }
        }
        return ans;
    }
}