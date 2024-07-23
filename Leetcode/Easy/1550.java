// https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2024-07-01

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int seq = 0;
        for (int x : arr) {
            if (x % 2 == 1) ++seq;
            else seq = 0;
            if (seq == 3) return true;
        }
        return seq == 3;
    }
}