// https://leetcode.com/problems/factorial-trailing-zeroes/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public int trailingZeroes(int n) {
        // this is equal to floor(n / 5) + floor(n / 25) + floor(n / 125) + ...
        int ans = 0, cur = 5;
        while (n / cur != 0) {
            ans += n / cur;
            cur *= 5;
        }
        return ans;
    }
}