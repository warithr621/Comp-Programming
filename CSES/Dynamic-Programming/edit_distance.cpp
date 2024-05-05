// CSES Edit Distance

#include <bits/stdc++.h>
using namespace std;

int main() {
    string s, t; cin >> s >> t;
    vector< vector<int> > dp(s.size() + 1, vector<int>(t.size() + 1, 5000*5000));
    dp[0][0] = 0;
    for (int i = 0; i <= s.size(); i++) {
        for (int j = 0; j <= t.size(); j++) {
            if (i != 0) dp[i][j] = min(dp[i][j], dp[i-1][j] + 1);
            if (j != 0) dp[i][j] = min(dp[i][j], dp[i][j-1] + 1);
            if (i != 0 && j != 0) {
                dp[i][j] = min(dp[i][j], dp[i-1][j-1] + (s[i-1] != t[j-1]));
            }
        }
    }
    cout << dp[s.size()][t.size()] << '\n';
}