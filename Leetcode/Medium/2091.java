// https://leetcode.com/problems/removing-minimum-and-maximum-from-array/?envType=daily-question&envId=2026-08-30

class Solution {
    public int minimumDeletions(int[] nums) {
        int mn = 0, mx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[mn]) mn = i;
            if (nums[i] > nums[mx]) mx = i;
        }
        // we only care about the indices (not which is min and which is max)
        // let's make "mn" the smaller of the indices (even if its the max element)
        if (mn > mx) {
            int tmp = mn;
            mn = mx;
            mx = tmp;
        }
        // three options: remove all from left, all from right, or do both ends
        // System.out.println(mx + 1);
        // System.out.println(nums.length - mn);
        // System.out.println((mn + 1) + (nums.length - mx));
        int ans = Math.min(mx + 1, nums.length - mn);
        return Math.min(ans, (mn + 1) + (nums.length - mx));
    }
}