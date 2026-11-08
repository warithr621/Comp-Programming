// stream twice!!

%:include <bits/stdc++.h>
using namespace std;
#define int long long

#pragma GCC optimize("O3") // :troll:
#pragma GCC optimize("unroll-loops")

void solve() <%
	//code
	int N, K;
	cin >> N >> K;
	vector<vector<int>> A(N, vector<int>(N));
	int tot = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> A[i][j];
			tot += A[i][j];
		}
	}
	// trivial ah tc
	if (K == 1) {
		cout << tot << '\n';
		return;
	}
	// fix a top and bottom row and do some bs
	vector<vector<int>> pfx(N+1, vector<int>(N, 0));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			pfx[i+1][j] = pfx[i][j] + A[i][j];
		}
	}
	vector<int> mnpf(K, 0); // values
	vector<int> vis(K, 0); // timestamps
	int timestamp = 1; // allows us to avoid consistent re-initialization
	int ans = 0;
	bool any = false;
	for (int i = 0; i < N; i++) {
		for (int j = i; j < N; j++) {
			int range = 0; // early pruning
			for (int k = 0; k < N; k++) {
				range += pfx[j+1][k] - pfx[i][k];
			}
			if (range <= ans) {
				continue;
			}
			timestamp++;
			int prefix = 0;
			mnpf[0] = 0;
			vis[0] = timestamp;
			for (int k = 0; k < N; k++) {
				int val = pfx[j+1][k] - pfx[i][k];
				prefix += val;
				int r = (prefix % K + K) % K;
				if (vis[r] == timestamp) {
					int candidate = prefix - mnpf[r];
					if (candidate > ans) {
						ans = candidate;
						any = true;
						if (ans == tot) break;
					}
				}
				if (vis[r] != timestamp) {
					vis[r] = timestamp;
					mnpf[r] = prefix;
				} else if (prefix < mnpf[r]) {
					mnpf[r] = prefix;
				}
			}
			if (ans == tot) break;
		}
		if (ans == tot) break;
	}
	cout << (any ? ans : 0) << '\n';
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while (T --> 0) solve();
%>
