#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	// do you just simulate this?
	string n,m; cin >> n >> m;
	if (n == m) {
		cout << "1\n";
		return 0;
	}
	set<string> seen;
	seen.insert(n);
	vector<int> freq(10, 0);
	for (int i = 2; i <= 101; i++) {
		// transform n
		freq.assign(10, 0);
		for (char c : n) {
			freq[c - '0']++;
		}
		string nxt = "";
		for (int j = 0; j <= 9; j++) {
			if (freq[j] == 0) continue;
			nxt += to_string(freq[j]) + to_string(j);
		}
		n = nxt;
		if (n == m) {
			cout << i << '\n';
			return 0;
		}
		if (!seen.insert(n).second) {
			cout << "Does not appear\n";
			return 0;
		}
	}
	cout << "I'm bored\n";
}