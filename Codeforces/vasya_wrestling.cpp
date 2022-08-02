// https://codeforces.com/contest/493/problem/B

#include <bits/stdc++.h>
#define ll long long //me not using #define int long long for once??
using namespace std;

int main() {
	cin.tie(0)->sync_with_stdio(0);

	int n; cin >> n;
	vector<int> f, s;
	ll sf = 0, ss = 0;
	int x;
	while(n--) {
		cin >> x;
		if (x > 0) {
			f.push_back(x);
			sf += x;
		} else {
			s.push_back(-x);
			ss -= x;
		}
	}
	if (sf != ss) {
	    cout << (sf > ss ? "first" : "second") << '\n';
	    return 0;
	}
	
	int sz = max(f.size(), s.size());
	for (int i = 0; i < sz; i++) {
	    if (f[i] != s[i]) {
	        cout << (f[i] > s[i] ? "first" : "second") << '\n';
	        return 0;
	    }
	}
	
	if (f.size() != s.size()) cout << (f.size() > s.size() ? "first" : "second") << '\n';
	else cout << (x > 0 ? "first" : "second") << '\n';
}