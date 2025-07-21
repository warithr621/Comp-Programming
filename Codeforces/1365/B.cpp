// https://codeforces.com/contest/1365/problem/B

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int N; cin >> N;
    bool S = true, Z = false, O = false;
    int A[N];
    for (int i = 0; i < N; i++) {
        cin >> A[i];
        if (i > 0 && A[i] < A[i-1]) S = false;
    }
    for (int i = 0; i < N; i++) {
        int B; cin >> B;
        Z |= B == 0;
        O |= B == 1;
    }

    cout << (S | (Z&O) ? "YES\n" : "NO\n");
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}