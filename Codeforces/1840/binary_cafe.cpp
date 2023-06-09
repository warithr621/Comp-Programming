// Problem: https://codeforces.com/contest/1840/problem/B

#include <bits/stdc++.h>
using namespace std;
#define int long long

void solve() {
    //code
    int n,k; cin >> n >> k;
    // if there's k desserts, you need at least (1<<k)-1 coins
    
    // instead of checking if (n >= 2^k - 1), take log2(x) of each side
    if (log2(n) >= k) { // me when I have 3 WA's on this problem bcz I don't read bounds and try calculating 2^(10^9)
        cout << (1LL << k) << '\n';
    } else {
        // you only have enough for n+1 options
        cout << n+1 << '\n';
    }
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}