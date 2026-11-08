#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double
signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	int n; cin >> n;
	string alphabet = "0123456789";
	for (char c = 'a'; c <= 'z'; c++) alphabet += c;
	for (char c = 'A'; c <= 'Z'; c++) alphabet += c;
	while (n--) {
		string s, t; cin >> s >> t;
		// compare by treating as b62
		// then compare by treating as strings
		string big2 = (s > t ? s : t);
		string big1 = "";
		// do math
		if (s.size() > t.size()) big1 = s;
		else if (t.size() > s.size()) big1 = t;
		else {
			for (int i = 0; i < s.size(); i++) {
				int u = alphabet.find(s[i]), v = alphabet.find(t[i]);
				if (u > v) {
					big1 = s;
					break;
				} else if (v > u) {
					big1 = t;
					break;
				}
			}
		}
		cout << (big1 == big2 ? "YES" : "NO") << '\n';
	}
}