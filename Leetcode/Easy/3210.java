// https://leetcode.com/problems/find-the-encrypted-string/

class Solution {
    public String getEncryptedString(String s, int k) {
        return s.substring(k % s.length()) + s.substring(0, k % s.length());
    }

    public String memory(String s, int k) {
        StringBuilder ans = new StringBuilder(s.substring(k % s.length()));
        ans.append(s.substring(0, k % s.length()));
        return ans.toString();
        // reduces from 42.68 MB (beats 53.89%) to 42.11 MB (beats 99.23%)
    }
}