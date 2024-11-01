// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/?envType=daily-question&envId=2024-10-18

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        // observe the maximum OR is the OR of all elements
        int max = 0;
        for (int x : nums)
            max |= x;
        
        int ans = 0;
        // bitmask across all subsets, we only have 16 numbers at most
        for (int mask = 0; mask < (1 << n); mask++) {
            int curOr = 0;
            for (int i = 0; i < n; i++)
                if ((mask & (1 << i)) != 0)
                    curOr |= nums[i];
            if (curOr == max)
                ans++;
        }
        return ans;
    }
}