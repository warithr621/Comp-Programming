// 2021 Silver Dec P2

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define LOW(vec, x) lower_bound(vec.begin(), vec.end(), x)

int T, N, M, tmp[300005];
vector<int> graph[300005], comp[300005];

void dfs(int x, int val) {
    if (tmp[x] != 0) return;
    tmp[x] = val;
    for (int y : graph[x]) dfs(y, val);
}

int dist(int src, int dest) {
    // build the cheapest road between the comps src and dest
    int ret = 1e10;
    for (int x : comp[src]) {
        /* for each node 'x' that's in the src comp:
            - binsearch (LB) to find the closest value in dest comp
            - update ret according
            - remmeber to consider val under AND upper
        */
        int lb = LOW(comp[dest], x) - comp[dest].begin();
        if (lb > 0) ret = min(ret, abs(comp[dest][lb-1] - x));
        if (lb < comp[dest].size()) {
            ret = min(ret, abs(comp[dest][lb] - x));
        }
    }
    return ret * ret;
}

void quack() {
    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        graph[i].clear();
        comp[i].clear();
        tmp[i] = 0;
    }
    for (int i = 0; i < M; i++) {
        int U, V; cin >> U >> V;
        graph[U].push_back(V); graph[V].push_back(U);
        // form graph
    }

    int c = 0;
    for (int i = 1; i <= N; i++) {
        if (tmp[i] == 0) dfs(i, ++c);
        // dfs to make component numbers
    }

    for (int i = 1; i <= N; i++) comp[tmp[i]].push_back(i);
    // group nodes by component

    int ans = dist(tmp[1], tmp[N]); /* this takes care of two scenarios:
        - we don't need a road, i.e. tmp[1] == tmp[N]
        - we build one road connecting those two components
    */
    
    for (int i = 1; i <= c; i++) {
        ans = min(ans, dist(i, tmp[1]) + dist(i, tmp[N]));
        /* the last case: we build a road from:
            - 1's comp to some arbitrary comp
            - same arbitrary comp to N's comp
        */
    }

    cout << ans << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> T;
    while(T--) quack();
    // yes, the solver method is called "quack"
}