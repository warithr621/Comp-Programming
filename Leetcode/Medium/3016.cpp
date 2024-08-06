// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/?envType=daily-question&envId=2024-08-06

class Solution {
public:
    int minimumPushes(string word) {
        int freq[26];
        fill(freq, freq + 26, 0);
        for (char c : word) {
            freq[c - 'a']++;
        }
        sort(freq, freq + 26);
        reverse(freq, freq + 26);
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += (i / 8 + 1) * freq[i];
        }
        return ans;
    }
};