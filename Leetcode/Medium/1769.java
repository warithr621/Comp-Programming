// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06

class Solution {
    public int[] minOperations(String boxes) {
        // surely this is O(N^2)? can't think of faster way (maybe later)
        // this already beats 53.65% (28ms)
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '0') continue;
            for (int j = 0; j < boxes.length(); j++) ans[j] += Math.abs(j-i);
        }
        return ans;
    }

    public int[] minOperations(String boxes) {
        // faster O(N), beats 76.56% (4ms) with about same memory
        int n = boxes.length();
        int[] ans = new int[n];
        int ballsL = 0, movesL = 0, ballsR = 0, movesR = 0;
        for (int i = 0, j = n-1; i < n; i++, j--) {
            // this is sort of like prefix sums
            ans[i] += movesL;
            ballsL += boxes.charAt(i) - '0';
            movesL += ballsL;
            ans[j] += movesR;
            ballsR += boxes.charAt(j) - '0';
            movesR += ballsR;
        }
        return ans;
    }
}