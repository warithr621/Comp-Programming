// https://leetcode.com/problems/count-number-of-nice-subarrays/description/


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // this should be 2-pointer
        int[] parity = new int[2];
        int ans = 0, prev = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            parity[nums[i] & 1]++;
            if (parity[1] == k) prev = cur;
            while (parity[1] == k) {
                parity[nums[cur++] & 1]--;
            }
            ans += cur - prev;
        }
        return ans;
    }
}