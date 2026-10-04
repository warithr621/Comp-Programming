#include <bits/stdc++.h>
using namespace std;

vector<int> manacher(string& s) {
	int n = s.size();
	vector<int> p(n);
	int l = 0, r = -1;
	for (int i = 0; i < n; i++) {
		int k = (i > r) ? 1 : min(p[l + r - i], r - i + 1);
		while (i + k < n && i - k >= 0 && s[i + k] == s[i - k]) {
			k++;
		}
		p[i] = k--;
		if (i + k > r) {
			l = i - k;
			r = i + k;
		}
	}
	return p;
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	string s; cin >> s;
	string t = "#";
	for (char c : s) {
		t += c;
		t += '#';
	}
	vector<int> p = manacher(t);

	int bestLen = 0, bestCenter = 0;
	for (int j = 0; j < (int)t.size(); j++) {
		if (p[j] - 1 > bestLen) {
			bestLen = p[j] - 1;
			bestCenter = j;
		}
	}

	int start = (bestCenter - bestLen) / 2;
	cout << s.substr(start, bestLen) << '\n';
}