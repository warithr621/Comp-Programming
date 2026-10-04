// https://leetcode.com/problems/find-greatest-common-divisor-of-array/description/?envType=daily-question&envId=2026-07-18

class Solution {
    public int findGCD(int[] nums) {
        int mx = -1, mn = 1001;
        for (int x : nums) {
            if (x > mx) mx = x;
            if (x < mn) mn = x;
        }
        while (mn != 0) {
            // mx,mn -> mn, mx%mn
            int tmp = mn;
            mn = mx % mn;
            mx = tmp;
        }
        return mx;
    }
}