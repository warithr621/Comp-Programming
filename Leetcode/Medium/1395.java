// https://leetcode.com/problems/count-number-of-teams/?envType=daily-question&envId=2024-07-29

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length, ans = 0;
        for (int j = 0; j < n; j++) {
            int[] L = new int[2], R = new int[2];
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) ++L[0];
                if (rating[i] > rating[j]) ++L[1];
                // can't do if-else, because we could have equal elements
            }
            for (int k = j+1; k < n; k++) {
                if (rating[k] > rating[j]) ++R[0];
                if (rating[k] < rating[j]) ++R[1];
            }
            ans += L[0] * R[0] + L[1] * R[1];
        }
        System.gc();
        return ans;
    }
}