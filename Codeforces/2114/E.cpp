#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define int long long

const int MAXN = 200005;
vector<int> tree[MAXN];
int a[MAXN];
int dp[MAXN][2];
int threat[MAXN];

void dfs(int u, int parent) {
    if (parent == -1) {
        dp[u][0] = a[u];
        dp[u][1] = a[u];
    } else {
        dp[u][0] = max(a[u], a[u] - dp[parent][1]);
        dp[u][1] = min(a[u], a[u] - dp[parent][0]);
    }
    threat[u] = dp[u][0];
    for (int v : tree[u]) {
        if (v != parent) {
            dfs(v, u);
        }
    }
}

void solve() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) tree[i].clear();
    for (int i = 0; i < n; i++) cin >> a[i];

    for (int i = 1; i < n; i++) {
        int u, v;
        cin >> u >> v;
        --u; --v;
        tree[u].push_back(v);
        tree[v].push_back(u);
    }

    dfs(0, -1);
    for (int i = 0; i < n; ++i) {
        cout << threat[i] << " ";
    }
    cout << "\n";
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T--) solve();
}