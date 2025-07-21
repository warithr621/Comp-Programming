// https://codeforces.com/contest/1974/problem/A

#include <bits/stdc++.h>
using namespace std;

int main() {
    int T; cin >> T;
    while (T--) {
        int x, y; cin >> x >> y;
        // need at least ceil(y/2) screens
        int ans = (y + 1) / 2;
        int left = 15 * ans - 4 * y;
        x -= left;
        cout << ans + (x <= 0 ? 0 : (x + 14) / 15) << '\n';
    }
}