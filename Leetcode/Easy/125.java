// https://leetcode.com/problems/valid-palindrome/

class Solution {

    public static boolean alnum(char c) {
        return '0' <= c && c <= '9' || 'a' <= c && c <= 'z';
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int L = 0, R = s.length() - 1;
        while (L < s.length() && !alnum(s.charAt(L))) ++L;
        while (R >= 0 && !alnum(s.charAt(R))) --R;
        while (L < R) {
            if (s.charAt(L) != s.charAt(R)) return false;
            do {
                L++;
            } while (!alnum(s.charAt(L)));
            do {
                R--;
            } while (!alnum(s.charAt(R)));
        }
        return true;
    }
}