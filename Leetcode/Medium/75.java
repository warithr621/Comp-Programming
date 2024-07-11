// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int L = 0, M = 0, R = nums.length - 1;
        while (M <= R) {
            if (nums[M] == 0) {
                // bring to left
                int tmp = nums[L];
                nums[L] = nums[M];
                nums[M] = tmp;
                ++L; ++M;
            } else if (nums[M] == 1) {
                ++M;
            } else {
                // bring to right
                int tmp = nums[R];
                nums[R] = nums[M];
                nums[M] = tmp;
                --R;
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}