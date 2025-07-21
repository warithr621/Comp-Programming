// Problem: https://codeforces.com/contest/1983/problem/B

#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) {
        int N, M; cin >> N >> M;
        char a[N][M], b[N][M];
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) cin >> a[i][j];
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) cin >> b[i][j];
        bool works = true;
        for (int i = 0; i < N; i++) {
            int cur = 0;
            for (int j = 0; j < M; j++) cur += a[i][j] - b[i][j];
            works &= cur % 3 == 0;
        }
        for (int j = 0; j < M; j++) {
            int cur = 0;
            for (int i = 0; i < N; i++) cur += a[i][j] - b[i][j];
            works &= cur % 3 == 0;
        }
        cout << (works ? "YES" : "NO") << '\n';
    }
}