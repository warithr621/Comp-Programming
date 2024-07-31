// https://leetcode.com/problems/max-consecutive-ones-iii/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int L = 0, R = 0, zeros = 0, ones = 0, ans = 0;
        while (R != nums.length) {
            // can we add this char?
            if (nums[R] == 1) {
                ++ones;
                ++R;
                ans = Math.max(ans, zeros + ones);
            } else if (nums[R] == 0 && zeros + 1 <= k) {
                ++zeros;
                ++R;
                ans = Math.max(ans, zeros + ones);
            } else {
                // we need to remove some digits
                while (true) {
                    if (nums[L] == 0) --zeros;
                    else --ones;
                    ++L;
                    if (zeros <= k) break;
                }
                ans = Math.max(ans, zeros + ones);
            }
        }
        return ans;
    }
}