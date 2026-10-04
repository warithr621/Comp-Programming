// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/?envType=daily-question&envId=2026-07-19

class Solution {
public:
    string smallestSubsequence(string s) {
        vector<int> vis(26), cnt(26);
        for (char c : s) cnt[c - 'a']++;
        string ans;
        for (char c : s) {
            if (!vis[c - 'a']) {
                while (!ans.empty() && ans.back() > c) {
                    if (cnt[ans.back() - 'a'] > 0) {
                        vis[ans.back() - 'a'] = 0;
                        ans.pop_back();
                    } else break;
                }
                vis[c - 'a'] = 1;
                ans.push_back(c);
            }
            cnt[c - 'a']--;
            // cout << ans << '\n';
        }
        return ans;
    }
};