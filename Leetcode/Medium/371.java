// https://leetcode.com/problems/sum-of-two-integers/description/

class Solution {
    public int getSum(int a, int b) {
        return (a&b) + (a|b);
    }
}