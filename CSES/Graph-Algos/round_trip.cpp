// CSES Round Trip

#include <iostream>
#include <vector>
#define pb push_back
using namespace std;
const int N = 300000;

vector<int> graph[N], cyc;
bool vis[N];

bool dfs(int cur, int p) {
    vis[cur] = 1;
    for (auto i : graph[cur]) {
        cyc.pb(i);
        if (!vis[i]) {
        	if (dfs(i, cur)) return 1;
        }
        else if (i != p) return 1;
        cyc.pop_back();
    }
    return 0;
}

int main() {
	cin.tie(0)->sync_with_stdio(0);

	int n,m; cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x,y; cin >> x >> y;
		graph[x].pb(y);
		graph[y].pb(x);
	}

	for (int i = 1; i <= n; i++) {
	    cyc.pb(i);
	    if (!vis[i] && dfs(i, 0)) {
	        vector<int> ans = {*cyc.rbegin()};
	        for (auto j = cyc.rbegin() + 1; j != cyc.rend(); j++) {
	            ans.pb(*j);
	            if (*j == *cyc.rbegin()) break;
	        }
	        cout << ans.size() << '\n';
	        for (int x : ans) cout << x << ' ';
	        return 0;
	    }
	    cyc.pop_back();
	}
	cout << "IMPOSSIBLE\n";
}