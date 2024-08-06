// https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false; // edge case
        int[] permfreq = new int[26], curfreq = new int[26];
        for (char c : s1.toCharArray()) permfreq[c - 'a']++;
        for (int i = 0; i < s1.length(); i++) {
            curfreq[s2.charAt(i) - 'a']++;
        }
        boolean works = true;
        for (int i = 0; i < 26; i++) works &= (permfreq[i] == curfreq[i]);
        if (works) return true;
        for (int itr = s1.length(); itr < s2.length(); itr++) {
            curfreq[s2.charAt(itr) - 'a']++;
            curfreq[s2.charAt(itr - s1.length()) - 'a']--;
            boolean yay = true;
            for (int i = 0; i < 26; i++) yay &= (permfreq[i] == curfreq[i]);
            if (yay) return true;
        }
        return false;
    }
}