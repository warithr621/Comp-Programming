// Problem: https://codeforces.com/contest/1826/problem/D

#include <bits/stdc++.h>
using namespace std;
constexpr int inf = 1e9;

void solve() {
    int N; cin >> N;
    int B[N+2];
    for (int i = 1; i <= N; i++) cin >> B[i];
    
    // b_l + b_m + b_r - (r-l) = b_m + (b_l + l) + (b_r - r)
    // this makes stuff more arbitrary
    // use pfx+sfx arrays to store max values for different indices
    // and take max of pfx[before i] + b[i] + sfx[after i]
    // aka a sight's beauty, the best left sight, and the best right sight
    
    int pfx[N+2], sfx[N+2]; // make pfx + sfx
    pfx[0] = sfx[N+1] = -inf;
    for (int i = 1; i <= N; i++) {
        pfx[i] = max(pfx[i-1], B[i] + i);
    }
    for (int i = N; i >= 1; i--) {
        sfx[i] = max(sfx[i+1], B[i] - i);
    }
    
    int ans = -inf;
    for (int i = 1; i <= N; i++) {
        ans = max(ans, pfx[i-1] + B[i] + sfx[i+1]); // loop through
    }
    
    cout << ans << '\n';
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}