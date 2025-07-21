// https://codeforces.com/contest/1846/problem/G
// 晴れ 晴れ

#include <bits/stdc++.h>
using namespace std;
#define int long long

const int inf = 1e18;
int N, M, init, days, dist[1024];
bool vis[1024];
string condition, fix, unfix;
vector< pair<int, int> > adj[1024]; // n at most 10, so biggest thing is 1023

int bindec(string s) {
    // converts binary string to decimal
    // yes there's probably a C function that can do this already, I don't care
    int ans = 0;
    int shift = 1;
    for (int i = s.size() - 1; i >= 0; --i) {
        ans += (s[i] == '1' ? shift : 0);
        shift <<= 1;
    }
    return ans;
}

int transform(int init, string f, string u) {
    int fix = bindec(f), unfix = bindec(u);
    // cue 5 minutes of thinking to figure out how bitwise operators work
    int ans = init & (init ^ fix);
    return ans | unfix;
}

void solve() {
    cin >> N >> M;
    fill(adj, adj + 1024, vector< pair<int, int> >());
    cin >> condition;
    init = bindec(condition);
    while (M --> 0) {
        cin >> days >> fix >> unfix;
        
        /* for something x fix (smth & (smth ^ fix))
        0 x 0 = 0
        0 x 1 = 0
        1 x 0 = 1
        1 x 1 = 0
        
        for something x unfix (smth | unfix)
        0 x 0 = 0
        0 x 1 = 1
        1 x 0 = 1
        1 x 1 = 1 */
        
        for (int i = 0; i < 1024; i++) {
            adj[i].push_back({transform(i, fix, unfix), days});
            // for each medicine, figure out how it can change every possible state
        }
    }
    
    // queue (lol) the dijkstra
    fill(dist, dist + 1024, inf);
    fill(vis, vis + 1024, false);
    dist[init] = 0;
    priority_queue< pair<int, int> > q;
    q.push({0, init});
    while (!q.empty()) {
        int node = q.top().second; q.pop();
        if (vis[node]) continue;
        vis[node] = true;
        for (auto p : adj[node]) {
            int dest = p.first, weight = p.second;
            if (dist[node] + weight < dist[dest]) {
                dist[dest] = dist[node] + weight;
                q.push({-dist[dest], dest}); // negative because C++ uses max heap
            }
        }
    }
    
    cout << (dist[0] == inf ? -1 : dist[0]) << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T --> 0) solve();
}