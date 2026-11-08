#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	
	string s,t; cin >> s >> t;
	int sz = max(s.size(), t.size());
	s.insert(0, sz - s.size(), '0');
	t.insert(0, sz - t.size(), '0');

	int ptr = 0, ones = 0;
	while (ptr < sz && s[ptr] == t[ptr]) {
		ones += (s[ptr++] == '1');
	}
	cout << ones + (sz - ptr) << '\n';
}