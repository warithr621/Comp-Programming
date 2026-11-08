#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	map<string, string> m;
	m["fishing"] = "alice";
	m["golf"] = "bob";
	m["hockey"] = "charlie";
	int n; cin >> n;
	while (n--) {
		string person, game;
		cin >> person >> game >> game >> game >> game;
		if (m[game] == person) {
			cout << person << " already has " << game << '\n';
		} else {
			cout << person << " borrows " << game << " from " << m[game] << '\n';
		}
		m[game] = person;
	}
}