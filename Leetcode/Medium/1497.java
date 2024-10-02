// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/?envType=daily-question&envId=2024-10-01

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] mod = new int[k];
        for (int x : arr) {
            mod[(x % k + k) % k]++;
        }
        for (int L = 1, R = k-1; L <= R; L++, R--) {
            if (L == R) {
                if (mod[L] % 2 == 1) return false;
            } else {
                if (mod[L] != mod[R]) return false;
            }
        }
        return true;
    }
}