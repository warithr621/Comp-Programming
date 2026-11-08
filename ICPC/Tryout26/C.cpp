#include <bits/stdc++.h>
using namespace std;
#define int long long

#pragma GCC optimize ("Ofast")

vector<pair<int, int>> bits;

void solve() {
    int n, m; cin >> n >> m;
    vector<vector<bool>> edge(n, vector<bool>(n, false));
    vector<vector<int>> weight(n, vector<int>(n, 0));
    for (int i = 0; i < m; i++) {
        int u,v,w; cin >> u >> v >> w;
        u--; v--;
        edge[u][v] = edge[v][u] = true;
        weight[u][v] = weight[v][u] = w;
    }
    vector<int> size(1<<n, 0), cost(1<<n, 0);
    for (auto &[skib, mask] : bits) {
        if (mask >= (1<<n)) continue;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (!edge[i][j]) continue;
                int skibidi = (1 << i) | (1 << j);
                if ((mask | skibidi) != mask) continue;
                int prev = mask - skibidi;
                // cout << mask << ' ' << prev << "!\n";
                int check = size[prev] + 2;
                if (check > size[mask]) {
                    size[mask] = check;
                    cost[mask] = cost[prev] + weight[i][j];
                } else if (check == size[mask]) {
                    cost[mask] = min(cost[mask], cost[prev] + weight[i][j]);
                }
            }
        }
    }
    int a = 0, b = 0;
    for (int i = 0; i < (1<<n); i++) {
        if (size[i] > a) {
            a = size[i];
            b = cost[i];
        } else if (size[i] == a) {
            b = min(b, cost[i]);
        }
    }
    cout << a/2 << ' ' << b << '\n';

}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    for (int i = 0; i < (1<<20); i++) {
        int cnt = 0;
        for (int j = 0; j < 20; j++) {
            if (i & (1 << j)) ++cnt;
        }
        if (cnt & 1) continue;
        bits.push_back({cnt, i});
    }
    sort(bits.begin(), bits.end());
    int t; cin >> t;
    while (t--) solve();
}