// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/?envType=daily-question&envId=2024-09-11

class Solution {
    public int minBitFlips(int start, int goal) {
        // ints only have 32 bits lol
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((start & 1 << i) == 0) && ((goal & 1 << i) == 0)) ans++;
            if (((start & 1 << i) != 0) && ((goal & 1 << i) != 0)) ans++;
        }
        return 32 - ans;
    }
}