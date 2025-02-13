// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/?envType=daily-question&envId=2025-02-05

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt = 0, f1[] = new int[26], f2[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) ++cnt;
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }
        if (cnt == 0) return true;
        if (cnt == 2 && Arrays.equals(f1, f2)) return true;
        return false;
    }
}