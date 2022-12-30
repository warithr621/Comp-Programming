// 2015 Dec Silver P3

#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1e5 + 5;
int N, Q;
int inp[MAXN], H[MAXN], G[MAXN], J[MAXN];

int main() {
    freopen("bcount.in", "r", stdin);
    freopen("bcount.out", "w", stdout);
    cin >> N >> Q;
    for (int i = 0; i < N; i++) cin >> inp[i];
    for (int i = 1; i <= N; i++) {
        H[i] = H[i-1] + (inp[i-1] == 1);
        G[i] = G[i-1] + (inp[i-1] == 2);
        J[i] = J[i-1] + (inp[i-1] == 3);
    }
    while(Q--) {
        int L, R; cin >> L >> R;
        --L;
        cout << H[R]-H[L] << ' ' << G[R]-G[L] << ' ' << J[R]-J[L] << '\n';
    }
}