// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2026-06-30

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int a = -1, b = -1, c = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a = i;
            else if (ch == 'b') b = i;
            else if (ch == 'c') c = i;
            int amt = Math.min(a, Math.min(b,c));
            ans += amt + 1;
        }
        return ans;
    }
}