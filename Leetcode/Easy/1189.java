// https://leetcode.com/problems/maximum-number-of-balloons/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray()) freq[c - 'a']++;
        freq['l' - 'a'] >>= 1;
        freq['o' - 'a'] >>= 1;
        int ans = Integer.MAX_VALUE;
        for (char c : "balon".toCharArray()) {
            ans = Math.min(ans, freq[c - 'a']);
        }
        return ans;
    }
}