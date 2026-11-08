// this is a Claude modification of my code :(

#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MAXN = 200005;
bool PRIME[MAXN];
int MOBIUS[MAXN];
vector<int> buckets[MAXN];
vector<int> sqf[MAXN];

struct DSU {
    vector<int> sz, par;
    DSU(int n) {
        sz = vector<int>(n, 1);
        par = vector<int>(n, 0);
        for (int i = 0; i < n; i++) par[i] = i;
    }
    int size(int x) {
        return sz[find(x)];
    }
    int find(int x) {
        if (par[x] == x) return x;
        else return par[x] = find(par[x]);
    }
    int join(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        int karp = sz[a] * sz[b];
        if (sz[a] < sz[b]) swap(a,b);
        sz[a] += sz[b];
        par[b] = a;
        return karp;
    }
};

void solve() {
    int n; cin >> n;
    int a[n];
    vector<int> used;
    vector<vector<int>> adj(n, vector<int>());
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        for (int d : sqf[a[i]]) {
            if (buckets[d].empty()) used.push_back(d);
            buckets[d].push_back(i);
        }
    }
    for (int i = 0; i < n-1; i++) {
        int u,v; cin >> u >> v;
        --u; --v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    vector<int> par(n, -1);
    queue<pair<int,int>> q;
    vector<bool> seen(n, 0);
    q.push({0, -1});
    while (!q.empty()) {
        auto p = q.front(); q.pop();
        seen[p.first] = true;
        par[p.first] = p.second;
        for (int x : adj[p.first]) {
            if (!seen[x]) q.push({x, p.first});
        }
    }
    int ans = 0;
    DSU ramen(n);
    for (int d : used) {
        int tmp = 0;
        for (int x : buckets[d]) {
            if (par[x] == -1) continue;
            if (a[par[x]] % d == 0) {
                tmp += ramen.join(x, par[x]);
            }
        }
        ans += MOBIUS[d] * tmp;
        for (int x : buckets[d]) {
            ramen.par[x] = x;
            ramen.sz[x] = 1;
        }
        buckets[d].clear();
    }
    for (int x : a) ans += (x == 1);
    cout << ans << '\n';
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    fill(PRIME, PRIME + MAXN, true);
    fill(MOBIUS, MOBIUS + MAXN, 1);
    for (int i = 2; i < MAXN; i++) {
        if (!PRIME[i]) continue;
        MOBIUS[i] = -1;
        for (int j = 2*i; j < MAXN; j += i) {
            PRIME[j] = false;
            MOBIUS[j] *= -1;
            if (MOBIUS[j] != 0) {
                int tmp = 0;
                for (int k = j; k % i == 0; k /= i) tmp++;
                if (tmp >= 2) MOBIUS[j] = 0;
            }
        }
    }
    for (int d = 1; d < MAXN; d++) {
        if (MOBIUS[d] == 0) continue;
        for (int m = d; m < MAXN; m += d) sqf[m].push_back(d);
    }

    int T; cin >> T;
    while (T--) solve();
    
}