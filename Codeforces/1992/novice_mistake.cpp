// https://codeforces.com/contest/1992/problem/E
// got this post-contest because i am BAD and cost myself like 20 delta for no reason

#include <bits/stdc++.h>
using namespace std;

void solve() {
    //code
    int N; cin >> N;
    string S = to_string(N);
    int len = S.size();
    vector< pair<int,int> > ans;
    for (int a = 1; a <= 10000; ++a) {
        int L = ceil(log10(a+1));
        string cur = "";
        for (int i = 0; i <= L; i++) {
            cur += S[i % len];
            int b = a * len - i - 1;
            if (b <= 0) continue;
            if (a * N - b == stoi(cur)) {
                ans.push_back({a, b});
                break;
            }
            if (a * N - b < stoi(cur)) break;
        }
    }
    cout << ans.size() << '\n';
    for (auto p : ans) cout << p.first << ' ' << p.second << '\n';
}
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T = 1;
    cin >> T;
    while(T--) solve();
}