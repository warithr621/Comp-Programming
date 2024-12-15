// https://leetcode.com/problems/two-best-non-overlapping-events/description/?envType=daily-question&envId=2024-12-08

class Solution {
    public int maxTwoEvents(int[][] events) {
        List<int[]> t = new ArrayList<>();
        for (int[] e : events) {
            t.add(new int[]{e[0], 1, e[2]});
            t.add(new int[]{e[1] + 1, 0, e[2]});
        }
        t.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ans = 0, mx = 0;
        for (int[] times : t) {
            if (times[1] == 1) ans = Math.max(ans, times[2] + mx);
            else mx = Math.max(mx, times[2]);
        }
        return ans;
    }
}