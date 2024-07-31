// https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int L = 0, R = 0, ans = 0;
        while (R != s.length()) {
            // see if we can add this char
            // temporarily add its frequency
            freq[s.charAt(R) - 'A']++;
            int mx = 0, sum = 0;
            for (int x : freq) {
                if (mx < x) mx = x;
                sum += x;
            }
            if (sum - mx <= k) {
                // we can make the changes necessary, so we can add this
                ++R;
                ans = Math.max(ans, R - L);
            } else {
                // first remove the R char from the freq
                --sum;
                --freq[s.charAt(R) - 'A'];
                mx = -1;
                for (int x : freq) mx = Math.max(x, mx);
                // now move the left pointer
                while (true) {
                    --sum;
                    --freq[s.charAt(L) - 'A'];
                    ++L;
                    mx = -1;
                    for (int x : freq) mx = Math.max(x, mx);
                    if (sum - mx <= k) break;
                }
                ans = Math.max(ans, R - L);
            }
        }
        return ans;
    }
}