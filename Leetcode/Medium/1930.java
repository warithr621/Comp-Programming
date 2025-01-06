// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2025-01-04

class Solution {
    public int countPalindromicSubsequence(String s) {
        // wait this is such bad variable naming
        int ans = 0;
        int[] f = new int[26], l = new int[26];
        Arrays.fill(f, -1);
        Arrays.fill(l, -1);
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - 'a';
            if (f[v] == -1) f[v] = i;
            l[v] = i;
        }
        for (int c = 0; c < 26; c++) {
            if (f[c] == -1) continue;
            Set<Character> m = new HashSet<>();
            for (int i = f[c]+1; i < l[c]; i++) m.add(s.charAt(i));
            ans += m.size();
        }
        return ans;
    }
}