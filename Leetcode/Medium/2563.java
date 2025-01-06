// https://leetcode.com/problems/count-the-number-of-fair-pairs/?envType=daily-question&envId=2025-01-03

class Solution {

    private long solve(int[] arr, int x) {
        int L = 0, R = arr.length - 1;
        long ans = 0;
        while (L < R) {
            int sum = arr[L] + arr[R];
            if (sum < x) {
                ans += (R - L);
                ++L;
            } else --R;
        }
        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        // obviously you could do this in O(N^2), what about O(N)?
        // oh wait sort and 2ptr surely
        Arrays.sort(nums);
        return solve(nums, upper + 1) - solve(nums, lower);
    }
}