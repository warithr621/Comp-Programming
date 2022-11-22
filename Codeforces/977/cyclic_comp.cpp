// https://codeforces.com/contest/977/problem/E
// Virtual

#include <iostream>
#include <vector>
using namespace std;

int n,m;
bool vis[200002];
vector<int> comp;
vector<int> graph[200002];

void dfs(int v) {
    vis[v] = true;
    comp.push_back(v);
    for (auto x : graph[v]) if (!vis[x]) dfs(x);
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin>> n >> m;
    for (int i = 0; i < m; i++) {
        int x,y; cin >> x >> y;
        --x; --y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            comp.clear();
            dfs(i);
            bool b = true;
            for (int i : comp) b &= graph[i].size() == 2;
            ans += b;
        }
    }
    cout << ans << '\n';
}