// https://leetcode.com/problems/valid-triangle-number/description/

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        for (int k = n-1; k >= 2; k--) {
            int i = 0, j = k-1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    ans += j - i;
                    --j;
                } else {
                    ++i;
                }
            }
        }
        return ans;
    }
}