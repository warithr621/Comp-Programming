// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/?envType=daily-question&envId=2024-12-04

class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int ptr = 0;
        for (int i = 0; i < str1.length() && ptr != str2.length(); i++) {
            int orig = str1.charAt(i) - 'a', goal = str2.charAt(ptr) - 'a';
            if (orig == goal || (orig + 1) % 26 == goal) ++ptr;
        }
        return ptr == str2.length();
    }
}