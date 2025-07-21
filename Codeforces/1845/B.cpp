// https://codeforces.com/contest/1845/problem/B

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int x[3], y[3];
    for (int i = 0; i < 3; i++) cin >> x[i] >> y[i];
    int ans = 1;
    if ((x[0] > x[1]) == (x[0] > x[2])) {
        // both bob and carol live left/right of alice
        ans += min(abs(x[0] - x[1]), abs(x[0] - x[2]));
    }
    if ((y[0] > y[1]) == (y[0] > y[2])) {
        // both bob and carol live above/below alice
        ans += min(abs(y[0] - y[1]), abs(y[0] - y[2]));
    }
    
    cout << ans << '\n';
}

int main() {
    int T; cin >> T;
    while(T--) solve();
}