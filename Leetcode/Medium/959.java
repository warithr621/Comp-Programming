// https://leetcode.com/problems/regions-cut-by-slashes/?envType=daily-question&envId=2024-08-10

class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] exp = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    exp[3 * i][3 * j + 2] = 1;
                    exp[3 * i + 1][3 * j + 1] = 1;
                    exp[3 * i + 2][3 * j] = 1;
                } else if (c == '\\') {
                    exp[3 * i][3 * j] = 1;
                    exp[3 * i + 1][3 * j + 1] = 1;
                    exp[3 * i + 2][3 * j + 2] = 1;
                }
            }
        }

        int[][] comps = new int[3 * n][3 * n];
        int cur = 1;
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (comps[i][j] != 0 || exp[i][j] == 1) continue;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                comps[i][j] = cur;

                while (!q.isEmpty()) {
                    int[] cell = q.poll();
                    int x = cell[0];
                    int y = cell[1];
                    
                    int[] dx = {0, 1, 0, -1};
                    int[] dy = {1, 0, -1, 0};
                    
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx >= 0 && nx < 3 * n && ny >= 0 && ny < 3 * n && comps[nx][ny] == 0 && exp[nx][ny] == 0) {
                            comps[nx][ny] = cur;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
                cur++;
            }
        }
        
        return --cur;
    }
}
