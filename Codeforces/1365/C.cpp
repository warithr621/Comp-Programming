// https://codeforces.com/contest/1365/problem/C

#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    
    int N; cin >> N;
    int A[N], B[N];
    for (int i = 0; i < N; i++) cin >> A[i];
    for (int i = 0; i < N; i++) cin >> B[i];

    vector<int> pos(N, 0);
    for (int i = 0; i < N; i++) {
        --A[i]; --B[i];
        pos[A[i]] = i;
    }

    map<int, int> cyc;
    for (int i = 0; i < N; i++) {
        int cur = pos[B[i]] - i;
        if (cur < 0) cur += N;
        cyc[cur]++;
    }

    int ans = 0;
    for (auto it : cyc) {
        ans = max(ans, it.second);
    }
    cout << ans;
}