// https://leetcode.com/problems/shortest-palindrome/description/?envType=daily-question&envId=2024-09-20

class Solution {
    public String shortestPalindrome(String s) {
        // whatever string we add "X" to the beginning must exist as reverse in the end
        int L = 0;
        for (int R = s.length() - 1; R >= 0; R--) {
            if (s.charAt(L) == s.charAt(R)) ++L;
        }
        if (L == s.length()) return s;
        StringBuilder end = new StringBuilder(s.substring(L));
        StringBuilder front = new StringBuilder(end).reverse();
        return front.append(shortestPalindrome(s.substring(0,L))).append(end).toString();
    }
}