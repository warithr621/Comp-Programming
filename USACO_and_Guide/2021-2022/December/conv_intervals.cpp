// 2021 Dec Silver P3

#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
    cin.tie(0)->sync_with_stdio(0);

    int N,M; cin >> N >> M;
    vector< pair<int, int> > inv(N);
    for (int i = 0; i < N; i++) {
        int x, y; cin >> x >> y;
        inv[i] = {x, y};
    }
    
    vector<int> start(2*M + 1), end(2*M + 1);
    vector<int> A(M+1), B(M+1);
    for (int i = 0; i < N; i++) {
        ++A[inv[i].first];
        ++B[inv[i].second];
    }
    for (int i = 0; i <= M; i++) {
        for (int j = 0; j <= M; j++) {
            start[i+j] += A[i] * A[j];
            end[i+j] += B[i] * B[j];
        }
    }
    
    int ans = 0;
    for (int i = 0; i <= 2*M; i++) {
        cout << ans + start[i] << '\n';
        ans += start[i] - end[i];
    }
}