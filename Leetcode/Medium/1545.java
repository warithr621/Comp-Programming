// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/?envType=daily-question&envId=2024-10-19

class Solution {
    public char findKthBit(int n, int k) {
        int invert = 0, len = (1 << n) - 1;
        while (k > 1) {
            if (k == (len >> 1) + 1)
                return (char) ('0' + ((invert % 2) ^ 1));
            if (k > (len >> 1)) {
                k = len + 1 - k;
                ++invert;
            }
            len >>= 1;
        }
        return (char) ('0' + (invert % 2));
    }
}