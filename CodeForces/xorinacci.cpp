//Problem: https://codeforces.com/contest/1208/problem/A

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int a,b,n; cin >> a >> b >> n;
    cout << (n % 3 == 0 ? a : (n % 3 == 1 ? b : a^b)) << '\n';
}

int main() {
    int t; cin >> t; while(t--) solve();
}
