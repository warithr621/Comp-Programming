// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int L = 0, R = numbers.length - 1;
        while (L < R) {
            if (numbers[L] + numbers[R] == target) {
                return new int[]{L+1, R+1};
            } else if (numbers[L] + numbers[R] > target) --R;
            else ++L;
        }
        return new int[]{-1, -1};
    }
}