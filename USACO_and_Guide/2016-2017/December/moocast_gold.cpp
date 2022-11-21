// 2016 Dec Gold P1

#include <bits/stdc++.h>
using namespace std;

int n;
vector<pair<int, int>> a;
bool vis[1001];
int saw = 0;

int diff(pair<int, int> PA, pair<int, int> PB) {
    int dx = PA.first - PB.first, dy = PA.second - PB.second;
    return dx * dx + dy * dy;
}

void dfs(int cur, int dist) {
    vis[cur] = true; ++saw;
    for (int i = 0; i < n; i++) {
        if (diff(a[cur], a[i]) <= dist && !vis[i]) {
            dfs(i, dist);
        }
    }
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    freopen("moocast.in", "r", stdin);
    freopen("moocast.out", "w", stdout);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int x,y; cin >> x >> y;
        a.push_back({x, y});
    }
    
    int L = 0, R = 1000000000;
    while (L < R) {
        int M = (L + R) / 2;
        saw = 0;
        memset(vis, 0, n+1);
        
        dfs(0, M);
        
        if (saw == n) R = M;
        else L = ++M;
    }
    
    cout << L << '\n';
}
