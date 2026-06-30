class Solution {

    static boolean[][] vis;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public boolean dfs(int x, int y, char[][] board, String word, int idx) {
        if (vis[x][y]) return false;
        if (board[x][y] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;
        vis[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k], ny = y + dy[k];
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length
                && dfs(nx, ny, board, word, idx + 1)) {
                vis[x][y] = false;
                return true;
            }
        }
        vis[x][y] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }
}