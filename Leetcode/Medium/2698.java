// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/?envType=daily-question&envId=2025-02-15

class Solution {

    private boolean valid(int x, int target) {
        if (target < 0 || x < target) return false;
        if (x == target) return true;
        return valid(x / 10, target - x%10) ||
            valid(x / 100, target - x%100) || 
            valid(x / 1000, target - x%1000);
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int x = i * i;
            if (valid(x, i)) ans += x;
        }
        return ans;
    }
}