#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n; cin >> n;
	while(n--) {
		string s,t; cin >> s >> t;
		vector<int> fs(26), ft(26);
		for (char c : s) fs[c - 'a']++;
		for (char c : t) ft[c - 'a']++;
		string ans = "YES";
		for (int i = 0; i < 26; i++) {
			if (ft[i] && !fs[i]) ans = "NO";
		}
		cout << ans << '\n';
	}
}