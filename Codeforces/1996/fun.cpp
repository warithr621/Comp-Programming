// https://codeforces.com/contest/1996/problem/D

#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
    int T; cin >> T;
    while (T--) {
        int N, X, ans = 0; cin >> N >> X;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N / i + 1; j++) {
                ans += max(0, min((N - i * j) / (i + j), X - i - j));
            }
        }
        cout << ans << '\n';
    }
}