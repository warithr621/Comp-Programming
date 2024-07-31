// https://leetcode.com/problems/valid-perfect-square/

class Solution {
    public boolean isPerfectSquare(int num) {
        int L = 1, R = num;
        while (L <= R) {
            int M = L + (R - L) / 2;
            long prod = 1L * M * M;
            if (prod == num) return true;
            else if (prod < num) L = ++M;
            else R = --M;
        }
        return L * L == num;
    }
}