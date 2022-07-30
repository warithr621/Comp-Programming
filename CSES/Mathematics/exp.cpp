// CSES Exponentiation

#include <iostream>
#include <vector>
#define pb push_back
#define int long long
#define MOD 1000000007
using namespace std;

void solve() {
	int a,b; cin >> a >> b;
	if (a == 0) {
		cout << (b == 0 ? 1 : 0) << '\n';
		return;
	}
	if (a == 1) {
		cout << 1 << '\n';
		return;
	}

	vector<int> pws;
	int cur = a;
	int i = 1;
	for (; i <= b; i *= 2) {
		pws.pb(cur);
		cur *= cur;
		cur %= MOD;
	}
	i /= 2;
	int curi = (int) pws.size() - 1;

	int ans = 1;
	while (b != 0) {
		while (i > b) {
			i /= 2;
			--curi;
		}
		ans *= pws[curi];
		b -= i;
		ans %= MOD;
	}
	cout << ans << '\n';

}

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int t; cin >> t; while(t--) solve();
}
