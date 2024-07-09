// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/description/


class Solution {
    public boolean checkString(String s) {
        // last 'a' must occur before first 'b'
        int a = -1, b = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a = i;
            else if (b == -1) b = i;
        }
        return a < b || a == -1 || b == -1;
    }
}