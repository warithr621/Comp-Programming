#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

string ans = "-1";

void solve(vector<string> v) {
	int n = v.size();
	if (n == 1) {
		string cur = v[0];
		if (ans == "-1" || cur.size() < ans.size() || (cur.size() == ans.size() && cur < ans)) ans = cur;
		return;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j) continue;
			string s = v[i], t = v[j];
			for (int k = 1; k <= (int)min(s.size(), t.size()); k++) {
				if (s.substr(s.size()-k) == t.substr(0, k)) {
					vector<string> w;
					for (int idx = 0; idx < n; idx++) {
						if (idx != i && idx != j) w.push_back(v[idx]);
					}
					w.push_back(s + t.substr(k));
					solve(w);
				}
			}
		}
	}
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n; cin >> n;
	vector<string> v;
	for (int i = 0; i < n; i++) {
		string s; cin >> s;
		v.push_back(s);
	}
	solve(v);
	cout << ans << '\n';
}