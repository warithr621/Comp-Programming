// https://leetcode.com/problems/construct-k-palindrome-strings/description/?envType=daily-question&envId=2025-01-11

class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false; // string not long enough
        if (s.length() == k) return true; // k 1-char strings
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        // if X is the number of odd chars, we must make at least X palindromic strings
        int odd = 0;
        for (int x : freq) odd += (x & 1);
        return (odd <= k); // ??
        /*
        because of the checks with s.length(), we guaranteed that
        we make 'odd' strings with the odd-frequency characters
        and the other 'k - odd' strings with the even-frequency chars
        */
    }

    public boolean alt(String s, int k) {
        // this uses an integer to store the frequencies,
        // and the number of 1s is the number of odd-freq
        if (s.length() < k) return false; // string not long enough
        if (s.length() == k) return true; // k 1-char strings
        int tmp = 0;
        for (char c : s.toCharArray()) tmp ^= 1 << (c - 'a');
        return Integer.bitCount(tmp) <= k;
    }
}