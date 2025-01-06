// https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02

class Solution {

    private boolean vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        // surely this is common-sense pfx?
        // upd after first submission: i forgot regex is super slow relatively
        final String vowels = "aeiou";
        int n = words.length, q = queries.length;
        int[] ans = new int[q];
        int[] pfx = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int len = words[i-1].length();
            boolean satisfy = vowel(words[i-1].charAt(0)) && vowel(words[i-1].charAt(len-1));
            pfx[i] = pfx[i-1] + (satisfy ? 1 : 0);
        }
        for (int i = 0; i < q; i++) {
            int L = queries[i][0], R = queries[i][1];
            ans[i] = pfx[R+1] - pfx[L];
        }
        return ans;
    }
}