// 2015 Dec Silver P3

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdout);
    int n, q; cin >> n >> q;
    int inp[n];
    for (int i = 0; i < n; i++) cin >> inp[i];
    vector<int> h(n+1), g(n+1), j(n+1);
    h[0] = 0;
    g[0] = 0;
    j[0] = 0;
    for (int i = 1; i <= n; i++) {
        h[i] = h[i-1] + (inp[i-1] == 1);
        g[i] = g[i-1] + (inp[i-1] == 2);
        j[i] = j[i-1] + (inp[i-1] == 3);
    }
    while(q--) {
        int l, r; cin >> l >> r;
        --l;
        // --r;
        cout << h[r] - h[l] << ' ' << g[r] - g[l] << ' ' << j[r] - j[l] << '\n';
    }
}