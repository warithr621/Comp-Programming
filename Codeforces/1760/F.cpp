// https://codeforces.com/contest/1760/problem/F

%:include <bits/stdc++.h>
using namespace std;
%:define int long long
typedef vector<int> vi;
typedef pair<int, int> pii;
%:define order(v) sort(v.begin(), v.end())
%:define rev(v) sort(v.rbegin(), v.rend())
%:define pb(x) push_back(x)
%:define forn(i, ty) for(int i = 0; i < ty; i++)

void solve() {
    //code
    int n,c,d; cin >> n >> c >> d;
	vi a(n+1);
	for (int i = 1; i <= n; i++) cin >> a[i];
	sort(a.begin()+1, a.end(), greater<int>());
	vi pref = a;
	for (int i = 1; i <= n; i++) pref[i] = pref[i-1] + a[i];


	if (a[1] * d < c) cout << "Impossible\n";
	else if (pref[min(d,n)] >= c) cout << "Infinity\n";
	else {
		//binsearch on 'k'

		int L = 0, R = 5e5;
		while(L < R) {
			int M = (L + R+ 1) / 2;

			int cnt = d / (M + 1);
			int test = cnt * pref[min(M+1, n)] + pref[min(n, d % (M+1))];

			if (test >= c) L = M;
			else R = --M;
		}
		cout << L << '\n';
	}
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	int T; cin >> T;
	while(T--) solve();
}