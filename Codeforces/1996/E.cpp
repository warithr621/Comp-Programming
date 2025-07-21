// https://codeforces.com/problemset/problem/1996/E

#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = 1e9 + 7;

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T--) {
        string S;
        cin >> S;
        int N = S.length();
        unordered_map<int64_t, int64_t> freq;
        int cur = 0;
        int ans = 0;
        freq[0] = 1;

        for (int i = 0; i < N; i++) {
            cur += (S[i] == '1' ? 1 : -1);
            if (freq.find(cur) != freq.end()) {
                ans = (ans + freq[cur] * (N - i) % MOD) % MOD;
            }
            freq[cur] += i + 2;
        }
        cout << ans << '\n';
    }
}
