// nick

#include <bits/stdc++.h>

using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin.exceptions(cin.failbit);

    int n, e; cin >> n >> e;
    vector<vector<int>> adj(n);
    for (int i = 0; i < e; i++) {
        int u,v;cin >> u >> v; u--; v--;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    int INF = 1e9;
    vector<int> dz(n, INF), dy(n, INF); 
    {
        queue<pair<int, int>> q;
        q.push({0, 0});
        vector<bool> vis(n, false); vis[0] = true;
        while (!q.empty()) {
            auto [node, dist] = q.front();
            dy[node] = dist;
            q.pop();
            for (int nxt : adj[node]) {
                if (vis[nxt])
                    continue;
                q.push({nxt, dist + 1});
                vis[nxt] = true;
            }
        }
    }
    {
        queue<pair<int, int>> q;
        q.push({n - 1, 0});
        vector<bool> vis(n, false); vis[n - 1] = true;
        while (!q.empty()) {
            auto [node, dist] = q.front();
            dz[node] = dist;
            q.pop();
            for (int nxt : adj[node]) {
                if (vis[nxt])
                    continue;
                q.push({nxt, dist + 1});
                vis[nxt] = true;
            }
        }
    }
    vector<long double> p(n); p[n - 1] = 1;
    {
        vector<int> nodes(n);
        iota(nodes.begin(), nodes.end(), 0);
        sort(nodes.begin(), nodes.end(), [&](int x, int y) {
            if (dz[x] != dz[y])
                return dz[x] < dz[y];
            return x < y;
        });
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int o = nodes[i];
            //cout <<p[o] << ' ';
            for (int x : adj[o]) {
                if (dz[x] == dz[o] + 1)
                    cnt++;
            }
            long double frac = (long double) 1 / (long double) cnt;
            //cout << frac << 'x';
            for (int x : adj[o]) {
                if (dz[x] == dz[o] + 1)
                    p[x] += frac * p[o];
            }
        }
    }

    long double res = 1;
    // for (int i = 0; i < n; i++) {
    //     cout << dz[i] << ' ' << dy[i] << '\n';
    // }
    for (int i = 0; i < n; i++) {
        if (dy[i] + 1 <= dz[i]) {
            res = min(res, p[i]);
        }
        for (int x : adj[i]) {
            if (dy[x] < dz[x] && dy[i] <= dz[i] + 1)
                res = min(res, p[i]);
        }
    }

    cout << setprecision(12) << res;

    return 0;
}