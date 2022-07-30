// 2017 Jan Silver P2

#include <bits/stdc++.h>
using namespace std;
#define int long long

int32_t main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);
    int n; cin >> n;
    int inp[n];
    for (int i = 0; i < n; i++) cin >> inp[i];
    vector<int> a(n+1, 0);
    for (int i = 1; i <= n; i++) a[i] = (a[i-1] + inp[i-1]) % 7;
    // for (int i : a) cout << i << '\n';
    int ans = 0;
    vector<int> first(7, -1), last(7, -1);
    for (int i = 1; i <= n; i++) last[a[i]] = i;
    for (int i = n; i >= 1; i--) first[a[i]] = i;
    // for (int i = 0; i < 7; i++) cout << first[i] << ' ' << last[i] << '\n';
    for (int i = 0; i < 7; i++) ans = max(ans, last[i] - first[i]);
    cout << ans << '\n';
}