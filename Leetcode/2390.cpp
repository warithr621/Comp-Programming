// https://leetcode.com/problems/removing-stars-from-a-string/description/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string removeStars(string s) {
    	// this was the greedy solution I originally came up with,
    	// which I thought was a bit convoluted
        int n = s.size();
        bool inc[n];
        fill(inc, inc + n, true);
        int star = 0;
        for (int i = n-1; i >= 0; i--) {
            if (s[i] == '*') {
                ++star;
                inc[i] = false;
            } else if (star > 0) {
                --star;
                inc[i] = false;
            }
        }
        string ans = "";
        for (int i = 0; i < n; i++) if (inc[i]) ans += s[i];
        return ans;
    }

    string space(string s) {
    	// this is O(1) space rather than O(N) AND runs a tiny bit faster
    	// beats 92.9% instead of 82.8% in speed, and 93.3% instead of 87.6% in memory
        int l = 0, r = 0;
        while (r < s.size()) {
            if (s[r] == '*') --l;
            else s[l++] = s[r];
            ++r;
        }
        // not gonna lie I forgot you could just treat a C-string like an array of chars
        return s.substr(0, l);
    }
};