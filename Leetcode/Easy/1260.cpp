// https://leetcode.com/problems/shift-2d-grid/?envType=daily-question&envId=2026-07-20

class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> ans(n, vector<int>(m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int original = i * m + j;
                int nxt = (original + k) % (n * m);
                // cout << original << ' ' << nxt << '\n';
                int x = nxt / m, y = nxt % m;
                ans[x][y] = grid[i][j];
            }
        }
        return ans;
    }
};