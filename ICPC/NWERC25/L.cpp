#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int n; cin >> n;
	vector<vector<string>> ranks(n);
	set<string> artists;
	map<string, int> freq;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 10; j++) {
			string s; cin >> s;
			ranks[i].push_back(s);
			artists.insert(s);
			freq[s]++;
		}
	}
	int mx = 0;
	for (string s : artists) mx = max(mx, freq[s]);
	set<string> nxt;
	for (string s : artists) {
		if (freq[s] == mx) nxt.insert(s);
	}
	artists = nxt;
	int chk = 0;
	while (!artists.empty() && chk != 10) {
		freq = map<string, int>();
		for (int i = 0; i < n; i++) {
			freq[ranks[i][chk]]++;
		}
		int mx = 0;
		for (string s : artists) mx = max(mx, freq[s]);
		nxt = set<string>();
		for (string s : artists) {
			if (freq[s] == mx) nxt.insert(s);
		}
		artists = nxt;
		chk++;
	}
	if (artists.size() == 1) {
		cout << *artists.begin() << '\n';
	} else {
		cout << "tie\n";
	}
}