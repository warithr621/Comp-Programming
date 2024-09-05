// https://leetcode.com/problems/find-missing-observations/?envType=daily-question&envId=2024-09-05

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int x : rolls) sum += x;
        int required = mean * (m + n) - sum;
        if (required > 6 * n || required < n) return new int[0];
        int low = required / n; 
        // every value will be low or low + 1
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (i < (required % n) ? low + 1 : low);
        }
        return ans;
    }
}