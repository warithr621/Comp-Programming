// https://leetcode.com/problems/pacific-atlantic-water-flow/

import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        // given a cell (i, j), it is touching...
            // the Pacific if i == 0 or j == 0
            // the Atlantic if i == n-1 or j == m-1
        // instead of searching from each cell outwards, let's just start at the boundary and search inward!
        // to avoid needing pairs, I'll just denote each cell with a number
        // this number will be equal to i * m + j, which should be unique among all cells

        Queue<Integer> q = new LinkedList<>(); // no reason to use a PQ
        boolean vp[][] = new boolean[n][m], va[][] = new boolean[n][m];
        int dx[] = new int[]{1, 0, -1, 0};
        int dy[] = new int[]{0, 1, 0, -1};

        // first let's search from the Pacific inward
        for (int i = 0; i < n; i++) q.add(i * m);
        for (int j = 0; j < m; j++) q.add(j);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / m, y = cur % m;
            if (vp[x][y]) continue;
            vp[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (heights[nx][ny] >= heights[x][y]) q.add(nx * m + ny);
            }
        }

        // now repeat for Atlantic
        for (int i = 0; i < n; i++) q.add(i * m + (m-1));
        for (int j = 0; j < m; j++) q.add((n-1) * m + j);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int x = cur / m, y = cur % m;
            if (va[x][y]) continue;
            va[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (heights[nx][ny] >= heights[x][y]) q.add(nx * m + ny);
            }
        }

        List< List<Integer> > ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vp[i][j] && va[i][j]) ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }
}