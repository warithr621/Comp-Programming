// https://codeforces.com/contest/608/problem/B

#include <bits/stdc++.h>
using namespace std;

int pfx[200005][2];

int main() {
	string s,t; cin >> s >> t;
	int a = (int) s.length(), b = (int) t.length();

	for (int i = 1; i <= b; i++) {
		pfx[i][0] = pfx[i-1][0] + (t[i-1] == '0');
		pfx[i][1] = pfx[i-1][1] + (t[i-1] == '1');
	}

	long long ans = 0;
	for (int i = 0; i < a; i++) {
		ans += abs(s[i] - '0') * (pfx[b-a+i+1][0] - pfx[i][0]);
		ans += abs(s[i] - '1') * (pfx[b-a+i+1][1] - pfx[i][1]);
	}

	cout << ans << '\n';

	// for (int i = 0; i <= b; i++)cout<<pfx[i][0]<<' '<<pfx[i][1]<<'\n';
}