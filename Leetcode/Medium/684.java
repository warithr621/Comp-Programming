// https://leetcode.com/problems/redundant-connection/description/?envType=daily-question&envId=2025-01-29

class DSU {
    int N, size[], par[];

    public DSU(int N) {
        this.N = N;
        size = new int[N];
        par = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
            par[i] = i;
        }
    }

    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public boolean unite(int x, int y) {
        int a = find(x), b = find(y);
        if (a == b) return false;
        else if (size[a] > size[b]) {
            par[b] = a;
            size[a] += size[b];
        } else {
            par[a] = b;
            size[b] += size[a];
        }
        return true;
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        DSU solver = new DSU(N);
        for (int[] edge : edges) {
            if (!solver.unite(edge[0] - 1, edge[1] - 1)) return edge;
        }
        return new int[2];
    }
}