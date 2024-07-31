// https://leetcode.com/problems/find-closest-number-to-zero/

class Solution {
    public int findClosestNumber(int[] nums) {
        int best = Integer.MAX_VALUE;
        for (int x : nums) {
            if (Math.abs(x) < Math.abs(best)) best = x;
            else if (Math.abs(x) == Math.abs(best)) best = Math.max(best, x);
        }
        return best;
    }
}