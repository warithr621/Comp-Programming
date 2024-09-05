// https://leetcode.com/problems/walking-robot-simulation/?envType=daily-question&envId=2024-09-04

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        int xpos = 0, ypos = 0;
        int state = 0;
        int[] dx = {0, 1, 0, -1}; // N E S W
        int[] dy = {1, 0, -1, 0};
        // oops watch out for obstacles
        HashSet<Integer> bad = new HashSet<>();
        for (int[] arr : obstacles) {
            bad.add(arr[0] * 100000 + arr[1]);
        }
        for (int v : commands) {
            if (v > 0) {
                for (int m = 0; m < v; m++) {
                    xpos += dx[state]; ypos += dy[state];
                    if (bad.contains(xpos * 100000 + ypos)) {
                        xpos -= dx[state]; ypos -= dy[state];
                        break;
                    }
                }
            } else if (v == -1) {
                state = (state + 1) % 4;
            } else {
                state = (state + 3) % 4;
            }
            System.out.println(xpos + " " + ypos);
            ans = Math.max(ans, xpos*xpos + ypos*ypos);
        }
        return ans;
    }
}