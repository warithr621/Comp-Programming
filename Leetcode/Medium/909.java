// https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150

class Solution {

    public static int[] conv(int n, int space) {
        int x = space / n, y = space % n;
        if (x % 2 == 1) y = n - y - 1;
        x = n - x - 1;
        return new int[]{x, y};
    }

    public int snakesAndLadders(int[][] board) {
        int ans = Integer.MAX_VALUE, n = board.length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0}); // [space, # of moves]
        int[][] mindist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mindist[i][j] = Integer.MAX_VALUE;
            }
        }
        // for (int i = 1; i <= n * n; i++) {
        //     System.out.println(Arrays.toString(conv(n, i-1)));
        // }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int space = cur[0];
            int mvs = cur[1];
            // System.out.println("We're at %d and have used %d moves so far.".formatted(space, mvs));
            for (int i = 1; i <= 6; i++) {
                // this is how much we roll
                if (space + i == n*n) {
                    // we can reach n^2! update ans and then break for-loop
                    ans = Math.min(ans, mvs + 1);
                    break;
                }
                int newpos = space + i;
                int newx = conv(n, newpos-1)[0], newy = conv(n, newpos-1)[1]; // -1 because 0-indexing
                if (board[newx][newy] != -1) newpos = board[newx][newy];
                // remember this newpos could be the end lol
                if (newpos == n * n) {
                    ans = Math.min(ans, mvs + 1);
                    continue;
                }
                newx = conv(n, newpos-1)[0]; newy = conv(n, newpos-1)[1];
                if (mindist[newx][newy] > mvs + 1) {
                    mindist[newx][newy] = mvs + 1;
                    q.offer(new int[]{newpos, mvs + 1});
                }
            }
        }
        System.gc();
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}