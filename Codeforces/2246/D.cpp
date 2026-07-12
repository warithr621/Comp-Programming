%:include <bits/stdc++.h>
using namespace std;
%:define int long long

const int MAXN = (1 << 19);
const int MAXPW = 4; // surely smth small like this works
const int DEPTH = 20;
static int steps[MAXN + 1];
static int dp[MAXPW + 1][MAXN + 1];

void pcomp() {
	steps[0] = 0;
	for (int i = 1; i <= MAXN; i++) {
		steps[i] = 1 + steps[(i % 2 == 0 ? i/2 : i-1)];
	}
	for (int r = 0; r <= MAXPW; r++) {
		int skib = 1 << r;
		dp[r][MAXN] = steps[MAXN];
		for (int i = MAXN-1; i >= 0; i--) {
			dp[r][i] = min(steps[i], skib + dp[r][i+1]);
		}
	}
}

int func(int value, int r) {
	int num = 1 << r;
	int needed = (value + num - 1) / num;
	if (needed < 1) needed = 1;
	int remaining = (r <= MAXPW ? dp[r][needed] : steps[needed]);
	int round = needed * num - value;
	return r + round + remaining;
}

void solve() <%
	//code
	int n; cin >> n;
	vector<int> a(n);
	for (int &x : a) {
		cin >> x;
	}

	// hm okay if all numbers are even bob is kinda stuck
	// bob wants to either make a1 odd or a1 even (but a2 is odd)
	// but if all even, you're bottlenecked by the number with the smallest 2^pw | a_i

	int ans = LLONG_MAX;
	for (int r = 0; r <= DEPTH; r++) {
		int cost = 0;
		for (int i = 0; i < n; i++) {
			cost += func(a[i], r);
		}
		ans = min(ans, cost - r * (n-1));
	}
	cout << ans << '\n';
%>
 
signed main() <%
	cin.tie(0)->sync_with_stdio(0);
	pcomp();
	int T = 1;
	cin >> T;
	while (T --> 0) solve();
%>