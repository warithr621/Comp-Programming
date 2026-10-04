// https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/?envType=daily-question&envId=2026-07-28

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];
        int ptr = 0;
        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                ans[ptr] = ans[n - ptr - 1] = (char) ('a' + i);
                freq[i] -= 2;
                ptr++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 1) {
                ans[ptr] = (char) ('a' + i);
            }
        }

        return new String(ans);
    }
}