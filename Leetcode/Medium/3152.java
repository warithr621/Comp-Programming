// https://leetcode.com/problems/special-array-ii/description/?envType=daily-question&envId=2024-12-09

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] group = new int[n];
        int g = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) group[i] = g;
            else if (nums[i] % 2 != nums[i - 1] % 2) group[i] = g;
            else group[i] = ++g;
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = group[queries[i][0]] == group[queries[i][1]];
        }
        return ans;
    }
}