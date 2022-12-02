// CSES Flight Routes Check

#include <bits/stdc++.h>
using namespace std;

int N, M;
vector<int> dir[100005], rev[100005];
bool vis[100005];
// dir has edge from u->v, rev has edge from v->u

void dirfs(int start, int cur) {
    if (vis[cur]) return;
    vis[cur] = true;
    for (int x : dir[cur]) dirfs(start, x);
}

void revfs(int start, int cur) {
    if (vis[cur]) return;
    vis[cur] = true;
    for (int x : rev[cur]) revfs(start, x);
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int u,v; cin >> u >> v;
        dir[u].push_back(v);
        rev[v].push_back(u);
    }
    
    memset(vis, false, N+1);
    dirfs(1, 1);
    for (int i = 1; i <= N; i++) {
        if (!vis[i]) {
            cout << "NO\n" << 1 << ' ' << i << '\n';
            return 0;
        }
    }
    
    memset(vis, false, N+1);
    revfs(1, 1);
    for (int i = 1; i <= N; i++) {
        if (!vis[i]) {
            cout << "NO\n" << i << ' ' << "1\n";
            return 0;
        }
    }
    
    cout << "YES\n";
}