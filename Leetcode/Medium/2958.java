// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/?envType=daily-question&envId=2026-08-12

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // wait i think we can just 2ptr this
        int ans = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            hm.merge(nums[R], 1, Integer::sum);
            while (hm.get(nums[R]) > k) {
                hm.merge(nums[L], -1, Integer::sum);
                L++;
            }
            ans = Math.max(ans, R - L + 1);
        }
        return ans;
    }
}