// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/?envType=daily-question&envId=2024-09-15

class Solution {

    public int findTheLongestSubstring(String s) {
        int pfx = 0;
        int[] arr = new int[26];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < 5; i++) {
            arr[vowels[i] - 'a'] = (1 << i);
            // craziest use of bitmask ever
        }
        int[] last = new int[32];
        int ans = 0;
        for (int i = 0; i < 32; i++) last[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            pfx ^= arr[c - 'a'];
            if (last[pfx] == -1 && pfx != 0) last[pfx] = i;
            ans = Math.max(ans, i - last[pfx]);
        }
        return ans;
    }
}