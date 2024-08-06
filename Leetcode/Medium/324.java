// https://leetcode.com/problems/wiggle-sort-ii/

class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int L = 0, R = (nums.length + 1) >> 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i % 2 == 1) nums[i] = arr[R++];
            else nums[i] = arr[L++];
        }
    }
}