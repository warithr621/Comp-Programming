// https://codeforces.com/contest/1992/problem/D

#include <bits/stdc++.h>
using namespace std;

void solve() {
    //code
    int N, M, K; cin >> N >> M >> K;
    string s; cin >> s;
    // left bank at 0, right bank at N+1, swamp is [1,N]
    int dp[N+2];
    dp[0] = 0;
    dp[N+1] = -1; // -1 means we cannot reach this
    for (int i = 1; i <= N+1; i++) {
        // process each location
        dp[i] = (int) (1e9);
        if (i != N+1 && s[i-1] == 'C') {
            dp[i] = -1; // crocodile rip
            continue;
        }
        for (int j = 1; j <= M; j++) {
            int prev = i - j;
            if (prev < 0) break;
            if (dp[prev] == -1) continue; // we can't even reach here bruh
            if (prev == 0) {
                dp[i] = 0; // just jump directly here
                continue;
            }
            if (s[prev-1] == 'L') {
                // this means the prev place is a log and we were actually able to reach this place
                dp[i] = min(dp[i], dp[prev]);
            }
            if (j == 1 && s[prev-1] == 'W') {
                // water right before us and we're on water, so we can just swim here
                dp[i] = min(dp[i], dp[prev] + 1);
            }
        }
        if (dp[i] > K) {
            // oops in water for too long
            dp[i] = -1;
        }
        // cout << dp[i] << ' ' << i << '\n' << flush;
    }
    
    cout << (dp[N+1] != -1 ? "YES" : "NO") << '\n'; // doesn't matter how long we actually take
}
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}