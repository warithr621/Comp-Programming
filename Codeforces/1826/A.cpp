// Problem: https://codeforces.com/contest/1826/problem/A

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int N; cin >> N;
    int L[N];
    for (int &i : L) cin >> i;
    
    // if there are 'x' liars, saying l > x is a lie
    
    int ans = -1; // if it stays -1, no number works
    for (int i = 0; i <= N; i++) {
        // i = potential number of liars
        int cnt = 0;
        for (int x : L) {
            if (x > i) ++cnt;
        }
        if (cnt == i) ans = i;
    }
    
    cout << ans << '\n';
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}