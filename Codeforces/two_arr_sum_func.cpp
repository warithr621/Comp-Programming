//Problem: https://codeforces.com/contest/1165/problem/E
//Note: Virtual Submission

//By the way, this took five tries solely because of overflow and modulo errors, in both C++ and Java

#include <bits/stdc++.h>
using namespace std;
#define foru(i, n, k, x) for (int i = n; i < k; i += x)
#define forn(i, k) foru(i, 0, k, 1)
#define s(x) sort(x.begin(), x.end());
#define r(x) sort(x.rbegin(), x.rend());
#define mod 998244353
typedef long long ll;

int main() {
    int n; cin >> n;
    vector<ll> a(n), b(n), v(n);
    forn(i, n) {
        cin >> a[i];
        v[i] = a[i] * 1LL * (i+1) * (n-i);
    }
    forn(i, n) cin >> b[i];
    s(b); r(v);
    ll ans = 0;
    forn(i, n) {
        ll add = (v[i] % mod * 1LL * b[i]) % mod;
        ans += add;
        ans %= mod;
    }
    cout << ans << '\n';
}
