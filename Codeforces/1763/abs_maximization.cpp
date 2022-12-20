// https://codeforces.com/contest/1763/problem/A

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int N, A = -1, O = 0; cin >> N;
    while(N--) {
        int X; cin >> X;
        A &= X;
        O |= X;
    }
    cout << O - A << '\n';
}

int main() {
    int T; cin >> T;
    while(T--) solve();
}