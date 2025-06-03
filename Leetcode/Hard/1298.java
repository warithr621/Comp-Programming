// https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/?envType=daily-question&envId=2025-06-03

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        // this might be doable for an lc hard...
        // note that it's not guaranteed an initial box is necessarily open
        int ans = 0;
        int n = status.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] used = new boolean[n];
        boolean[] openable = new boolean[n];
        boolean[] avail = new boolean[n];
        for (int i = 0; i < n; i++) {
            openable[i] = (status[i] == 1);
        }
        for (int box : initialBoxes) {
            avail[box] = true;
            if (openable[box]) {
                q.add(box);
                ans += candies[box];
                used[box] = true;
            }
        }
        while (!q.isEmpty()) {
            int box = q.poll();
            for (int key : keys[box]) {
                openable[key] = true;
                if (!used[key] && avail[key]) {
                    q.offer(key);
                    used[key] = true;
                    ans += candies[key];
                }
            }
            for (int inner : containedBoxes[box]) {
                avail[inner] = true;
                if (!used[inner] && openable[inner]) {
                    q.add(inner);
                    ans += candies[inner];
                    used[inner] = true;
                }
            }
        }
        return ans;
    }
}