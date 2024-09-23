// https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/?envType=daily-question&envId=2024-09-22

class Solution {
    public int findKthNumber(int n, int k) {
        int ans = 1;
        k--;
        while (k > 0) {
            int steps = steps(n, ans, ans+1);
            if (steps <= k) {
                ans++;
                k -= steps;
            } else {
                ans *= 10;
                k--;
            }
        }
        return ans;
    }

    public int steps(int n, long p, long q) {
        int ans = 0;
        while (p <= n) {
            ans += Math.min(n + 1, q) - p;
            p *= 10;
            q *= 10;
        }
        return ans;
    }
}