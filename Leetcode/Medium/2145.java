// https://leetcode.com/problems/count-the-hidden-sequences/?envType=daily-question&envId=2025-04-21

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // assume smallest number 0
        long cur = 0, L = 0, R = 0;
        for (int x : differences) {
            cur += x;
            L = (cur < L ? cur : L);
            R = (cur > R ? cur : R);
        }
        // R - L is the difference that we have compared to upper - lower
        return (int) Math.max(0L, (upper - lower) - (R - L) + 1);
    }
}