// https://leetcode.com/problems/reverse-string/description/

class Solution {
    public void reverseString(char[] s) {
        int L = 0, R = s.length - 1;
        while (L < R) {
            char c = s[L];
            s[L] = s[R];
            s[R] = c;
            ++L; --R;
        }
    }
}