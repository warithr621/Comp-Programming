// CSES Exponentiation II

#include <iostream>
#include <vector>
#define pb push_back
#define int long long
#define MOD 1000000007
using namespace std;

int pow(int base, int exp, int m) {
	if (base == 0) return (exp == 0 ? 1 : 0);
	if (base == 1) return 1;

	vector<int> pws;
	int cur = base;
	int i = 1;
	for (; i <= exp; i *= 2) {
		pws.pb(cur);
		cur = cur * cur % m;
	}
	i /= 2;
	int curi = (int) pws.size() - 1;
	int ans = 1;

	while(exp != 0) {
		while (i > exp) {
			i /= 2;
			--curi;
		}
		ans = ans * pws[curi] % m;
		exp -= i;
	}
	return ans;
}

void solve() {
	int a,b,c; cin >> a >> b >> c;
	int temp = pow(b, c, MOD - 1);
	temp = pow(a, temp, MOD);
	cout << temp << '\n';
}

int32_t main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int t; cin >> t; while(t--) solve();
}
