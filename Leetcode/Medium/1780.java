// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/?envType=daily-question&envId=2025-03-04

class Solution {
    public boolean checkPowersOfThree(int n) {
        // we could just cheese this with Java properties...
        for (char c : Integer.toString(n, 3).toCharArray()) {
            if (c == '2') return false;
        }
        return true;
    }

    public boolean intended(int n) {
        // or the actual way
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }
}