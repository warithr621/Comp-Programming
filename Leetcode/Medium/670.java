// https://leetcode.com/problems/maximum-swap/description/?envType=daily-question&envId=2024-10-17

class Solution {
    public int maximumSwap(int num) {
        String temp = Integer.toString(num);
        char[] original = temp.toCharArray();

        int maxIdx = -1, L = -1, R = -1;
        for (int i = original.length - 1; i >= 0; i--) {
            if (maxIdx == -1 || original[i] > original[maxIdx]) {
                maxIdx = i;
            } else if (original[i] < original[maxIdx]) {
                L = i;
                R = maxIdx;
            }
        }

        if (L != -1 && R != -1) {
            char c = original[L];
            original[L] = original[R];
            original[R] = c;
        }

        return Integer.parseInt(new String(original));
    }
}