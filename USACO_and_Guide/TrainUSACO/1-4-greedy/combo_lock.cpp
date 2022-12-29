// USACO Trainer's "Combination Lock"

/*
ID: warithr1
LANG: C++11
TASK: combo
*/

#include <bits/stdc++.h>
using namespace std;

int N, J[3], M[3];

bool close(int X, int Y) {
    return abs(X-Y) <= 2 || abs(X-Y) >= N-2;
}

bool yay(int i, int j, int k) {
    bool john = close(i,J[0]) && close(j,J[1]) && close(k,J[2]);
    bool mast = close(i,M[0]) && close(j,M[1]) && close(k,M[2]);
    return john || mast;
}

int main() {
    freopen("combo.in", "r", stdin);
    freopen("combo.out", "w", stdout);

    cin >> N;
    for (int &x : J) cin >> x;
    for (int &x : M) cin >> x;

    int ans = 0;
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
            for (int k = 1; k <= N; ++k) {
                if (yay(i,j,k)) {
                    ++ans;
                    // cout << i << ' ' << j << ' ' << k << '\n';
                }
            }
        }
    }

    cout << ans << '\n';
}   