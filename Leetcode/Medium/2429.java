// https://leetcode.com/problems/minimize-xor/description/?envType=daily-question&envId=2025-01-15

class Solution {
    public int minimizeXor(int num1, int num2) {
        // remember an int has 32 bits
        boolean[] set = new boolean[32];
        int num2bits = 0;
        for (int i = 0; i < 32; i++) {
            if ((num1 & (1 << i)) != 0) {
                set[i] = true; // num1 has this bit set
            }
            if ((num2 & (1 << i)) != 0) {
                num2bits++; // add to the num2 bit count
            }
        }
        int ans = 0;
        for (int i = 31; i >= 0 && num2bits != 0; i--) {
            if (set[i]) {
                ans |= (1 << i);
                num2bits--;
            }
        }
        for (int i = 0; i < 32 && num2bits != 0; i++) {
            if (!set[i]) {
                ans |= (1 << i);
                num2bits--;
            }
        }
        return ans;

    }
}