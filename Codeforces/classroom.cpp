//Problem: https://codeforces.com/contest/1166/problem/A

#include<bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;

void solve() {
    int n; cin >> n;
    vector<ull> vc(26);
    while(n-->0) {string s; cin >> s; vc[s[0] - 'a']++;}
    ull ans = 0;
    for (ull i : vc) {
        ull L = i/2, R = i-L;
        if (--L > 0) ans += (L+1)*L/2;
        if (--R > 0) ans += (R+1)*R/2;
    }
    cout << ans << '\n';
}

int main() {
    solve();
}
