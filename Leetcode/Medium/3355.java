class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1];
        for (int[] q : queries) {
            diff[q[0]]++;
            if (q[1] + 1 < n) diff[q[1] + 1]--;
        }
        int[] delta = new int[n];
        delta[0] = diff[0];
        for (int i = 1; i < n; i++) {
            delta[i] = diff[i] + delta[i-1];
        }
        for (int i = 0; i < n; i++) {
            if (delta[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}