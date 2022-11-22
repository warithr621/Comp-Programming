//Problem: https://codeforces.com/contest/1101/problem/B

#include <bits/stdc++.h>
using namespace std;

void rem(string &s, const string &c) {
	auto pos = s.find(c);
	if (pos == string::npos) {
		cout << -1 << endl;
		exit(0);
	}
	s.erase(0, pos + 1);
}

int main() {
	string s; cin >> s;
	rem(s, "[");
	rem(s, ":");
	reverse(s.begin(), s.end());
	rem(s, "]");
	rem(s, ":");
	cout << count(s.begin(), s.end(), '|') + 4 << endl;
	
	return 0;
}
