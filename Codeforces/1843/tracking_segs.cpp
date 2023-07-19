// https://codeforces.com/contest/1843/problem/E

#include <bits/stdc++.h>
using namespace std;
#define int long long

int N, M;
vector<int> q;
vector< pair<int, int> > seg;

bool works(int m) {
    vector<int> arr(N, 0), pfx(N+1, 0);
    for (int i = 0; i < m; i++) arr[q[i] - 1] = 1;
    for (int i = 1; i <= N; i++) pfx[i] = pfx[i-1] + arr[i-1];
    for (auto p : seg) {
        int left = p.first, right = p.second;
        int ones = pfx[right] - pfx[left-1];
        if (ones > (right - left + 1) / 2) return true;
    }
    return false;
}

void solve() {
    cin >> N >> M;
    seg = vector< pair<int, int> >(M);
    for (auto& [x,y] : seg) cin >> x >> y;
    int Q; cin >> Q;
    q = vector<int>(Q);
    for (int i = 0; i < Q; i++) cin >> q[i];
    int L = 0, R = Q, ans = -1;
    while(L <= R) {
        int M = L + (R-L) / 2;
        if (works(M)) {
            ans = M;
            R = --M;
        } else {
            L = ++M;
        }
    }
    cout << ans << '\n';
}

signed main() {
    int T; cin >> T;
    while(T--) solve();
}