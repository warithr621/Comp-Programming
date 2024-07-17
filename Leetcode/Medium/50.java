// https://leetcode.com/problems/powx-n/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public double myPow(double x, int n) {
        if (x == -1) return ((n & 1) == 0 ? 1 : -1);
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (n == 1) return x;
        if (n == 0) return 1;
        
        double ans = 1;
        if (n < 0) {
            x = 1 / x;
            n = (Math.abs((long) n) > Integer.MAX_VALUE ? Math.abs(n) - 1 : Math.abs(n));
        }
        while (n > 0) {
            if ((n & 1) != 0) ans = ans * x;
            x = x * x;
            n >>= 1;
        }
        return ans;
    }
}