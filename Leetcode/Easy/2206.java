// https://leetcode.com/problems/divide-array-into-equal-pairs


class Solution {
    public boolean divideArray(int[] nums) {
        int[] tmp = new int[501];
        for (int x : nums) tmp[x] ^= x;
        boolean ans = true;
        for (int x : tmp) ans &= (x == 0);
        return ans;
    }
}