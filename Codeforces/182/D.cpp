#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
    string a, b; cin >> a >> b;
    int n = (int) a.size(), m = (int) b.size();
    set<int> ad, bd;
    for (int i = 1; i <= n; i++) {
        if (n % i != 0) continue; // cannot be divisor
        bool works = true;
        for (int j = 0; j + i < n; j++) {
            works &= a[j] == a[j+i];
        }
        if (works) ad.insert(i); // length of good prefix
    }
    for (int i = 1; i <= m; i++) {
        if (m % i != 0) continue; // cannot be divisor
        bool works = true;
        for (int j = 0; j + i < m; j++) {
            works &= b[j] == b[j+i];
        }
        if (works) bd.insert(i); // length of good prefix
    }
    int quack = 0;
    for (int i = 0; i < min(n,m); i++) {
        if (a[i] != b[i]) break;
        ++quack;
    }
    int ans = 0;
    for (int v : ad) {
        if (!bd.count(v)) continue;
        ans += (v <= quack);
    }
    cout << ans << '\n';
}