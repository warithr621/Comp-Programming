// https://leetcode.com/problems/maximum-score-words-formed-by-letters/description/
// also lol made an editorial https://leetcode.com/problems/maximum-score-words-formed-by-letters/solutions/5464166/bitmask-dp-on-max-score/?source=submission-ac

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        // I feel like this is supposed to be knapsack dp, but bitmask should work??
        // since we cannot use a word more than once and we can only have at most 14 words,
        // just run a bitmask to brute force all options

        int L = words.size();
        int freq[26];
        fill(freq, freq + 26, 0);
        for (char c : letters) freq[c - 'a']++;
        int ans = 0;
        for (int mask = 0; mask < (1 << L); ++mask) {
            int curfreq[26];
            fill(curfreq, curfreq + 26, 0);
            for (int i = 0; i < L; i++) {
                if (mask & (1 << i)) {
                    for (char c : words[i]) curfreq[c - 'a']++;
                }
            }
            bool works = true;
            for (int i = 0; i < 26; i++) works &= (freq[i] >= curfreq[i]);
            if (works) {
                int tmp = 0;
                for (int i = 0; i < 26; i++) tmp += curfreq[i] * score[i];
                ans = max(ans, tmp);
            }
        }
        return ans;
    }
};