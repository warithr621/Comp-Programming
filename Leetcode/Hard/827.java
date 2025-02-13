// https://leetcode.com/problems/making-a-large-island/description/?envType=daily-question&envId=2025-01-31
// man I need to store a DSU template at some point

class DSU {
    int par[], sz[];

    public DSU(int n) {
        par = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public void unite(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return;
        if (sz[x] < sz[y]) {
            par[x] = y;
            sz[y] += sz[x];
        } else {
            par[y] = x;
            sz[x] += sz[y];
        }
    }

}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        DSU d = new DSU(n * m);
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int p = i * m + j;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                            int adj = nx * m + ny;
                            d.unite(p, adj);
                        }
                    }
                }
            }
        }

        int ans = 0;
        boolean zero = false;
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    zero = true;
                    int cur = 1;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                            int adj = nx * m + ny;
                            int root = d.find(adj);
                            unique.add(root);
                        }
                    }
                    for (int root : unique) cur += d.sz[root];
                    unique.clear();
                    ans = Math.max(ans, cur);
                }
            }
        }
        if (!zero) return n * m;
        return ans;
    }
}