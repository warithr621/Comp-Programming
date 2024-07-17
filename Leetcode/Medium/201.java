// https://leetcode.com/problems/bitwise-and-of-numbers-range/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) right &= (right - 1);
        return right;
    }
}