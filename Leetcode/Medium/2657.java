// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2025-01-14

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        boolean[] foundA = new boolean[n+1], foundB = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            foundA[A[i]] = true;
            foundB[B[i]] = true;
            for (int j = 0; j < n+1; j++) {
                if (foundA[j] && foundB[j]) ans[i]++;
            }
        }
        return ans;
    }
}