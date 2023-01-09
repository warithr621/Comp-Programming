// 2018 Jan Silver P3

#include <bits/stdc++.h>
using namespace std;

int N, Q, K, V, ans;
vector<int> G[5005]; // adj list
int weight[5005][5005]; // adj matrix w/ weights
bool vis[5005];

void dfs(int par, int src, int mn) {
    // ended up being too slow
    if (mn >= K) ++ans;
    for (int dest : G[src]) {
        if (par != dest) {
            dfs(src, dest, min(mn, weight[src][dest]));
        }
    }
}

int main() {
    freopen("mootube.in", "r", stdin);
    freopen("mootube.out", "w", stdout);

    cin.tie(0)->sync_with_stdio(0);
    
    cin >> N >> Q;
    for (int i = 1; i < N; i++) {
        int U, V, W; cin >> U >> V >> W;
        weight[U][V] = weight[V][U] = W;
        G[U].push_back(V); G[V].push_back(U);
    }
    
    while (Q--) {
        cin >> K >> V;
        ans = 0;
        
        // new approach: queue BFS
        queue< array<int, 3> > q;
        q.push({0, V, (int)2e9});
        while(!q.empty()) {
            auto a = q.front(); q.pop();
            int par = a[0], src = a[1], mn = a[2];
            if (mn >= K) ++ans;
            for (int dest : G[src]) {
                if (par != dest) {
                    q.push({src, dest, min(mn, weight[src][dest])});
                }
            }
        }
        cout << --ans << '\n';
    }
}