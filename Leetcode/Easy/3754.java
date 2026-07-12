// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/?envType=daily-question&envId=2026-07-07

class Solution {
    public long sumAndMultiply(int n) {
        long x = 0, sum = 0, place = 1;
        while (n != 0) {
            int digit = n % 10;
            x += digit * place;
            sum += digit;
            if (digit != 0) place *= 10;
            n /= 10;
        }
        return x * sum;
    }
}