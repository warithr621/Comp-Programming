#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define pb push_back
const int MAXN = 300'005;
const int LOG = 20;

int L[MAXN], R[MAXN], P[MAXN];
ll dp[MAXN], dp2[MAXN];
int up[MAXN][LOG];
int first[MAXN];
vector<int> tour;

struct State {
	int u, stage;
};

void solve() {
	int N, Q; cin >> N >> Q;
	// reset stuff
	tour.clear();
	for (int i = 0; i <= N; i++) {
		L[i] = R[i] = P[i] = 0;
		dp[i] = dp2[i] = 0;
		first[i] = -1;
		for (int j = 0; j < LOG; j++) up[i][j] = 0;
	}
	vector<int> L(N+1), R(N+1), P(N+1, 0);
	for (int i = 1; i <= N; i++) {
		cin >> L[i] >> R[i];
		if (L[i]) P[L[i]] = i;
		if (R[i]) P[R[i]] = i;
	}

	// run down the tree, and use that to build dp
	// where dp[i] is time to traverse i's subtree and then jump up
	vector<int> order, st = {1};
	while (!st.empty()) {
		int u = st.back(); st.pop_back();
		order.pb(u);
		if (L[u]) st.pb(L[u]);
		if (R[u]) st.pb(R[u]);
	}
	reverse(order.begin(), order.end());
	for (int u : order) {
		if (L[u] == 0) dp[u] = 1;
		else dp[u] = dp[L[u]] + dp[R[u]] + 3;
	}

	// create Euler tour, also make dp2
	// where dp2[i] is a prefix sum along the path from i to root
	vector<State> stack; stack.pb({1, 0});
	while (!stack.empty()) {
		State& top = stack.back();
		if (top.stage == 0) {
			first[top.u] = tour.size();
			tour.pb(top.u);
			dp2[top.u] = dp[top.u] + dp2[P[top.u]];
			if (L[top.u] != 0) {
				top.stage = 1;
				stack.pb({L[top.u], 0});
			} else {
				stack.pop_back();
			}
		} else if (top.stage == 1) {
			tour.pb(top.u);
			top.stage = 2;
			stack.pb({R[top.u], 0});
		} else {
			tour.pb(top.u);
			stack.pop_back();
		}
	}
	tour.pb(0);

	// wtf is binary lifting vro
	for (int i = 0; i <= N; i++) {
		up[i][0] = P[i];
	}
	for (int j = 1; j < LOG; j++) {
		for (int i = 0; i <= N; i++) {
			up[i][j] = up[up[i][j-1]][j-1];
		}
	}
	
	while (Q--) {
		int v; ll k; cin >> v >> k;
		int cur = v;
		for (int j = LOG-1; j >= 0; j--) {
			int ancestor = up[cur][j];
			if (ancestor != 0 and dp2[v] - dp2[ancestor] <= k) {
				cur = ancestor;
			}
		}
		ll rem = k - (dp2[v] - dp2[cur]);
		cout << tour[first[cur] + rem] << ' ';
	}
	cout << '\n';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}