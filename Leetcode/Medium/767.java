// https://leetcode.com/problems/reorganize-string/

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int n = s.length();
        char max = 'a';
        for (int i = 0; i < 26; i++) {
            if (freq[i] > freq[max - 'a']) max = (char) ('a' + i);
        }
        if (freq[max - 'a'] > (n+1)/2) {
            return "";
        }
        char[] ans = new char[n];
        int idx = 0;
        while (freq[max - 'a'] != 0) {
            ans[idx] = max;
            freq[max - 'a']--;
            idx += 2;
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i] != 0) {
                if (idx >= n) idx = 1;
                ans[idx] = (char) ('a' + i);
                freq[i]--;
                idx += 2;
            }
        }
        return new String(ans);
    }
}