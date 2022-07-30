//Problem: https://codeforces.com/contest/593/problem/A

#include <bits/stdc++.h>
using namespace std;

void solve() {
	int n;
	cin >> n;
	vector<string> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	int ans = 0;
	for (char c1 = 'a'; c1 <= 'z'; c1++) {
		for (char c2 = c1; c2 <= 'z'; c2++) {
			int cur = 0;
			for (int i = 0; i < n; i++) {
				bool b = 1;
				for (int j = 0; j < a[i].size(); j++) {
					if (a[i][j] != c1 && a[i][j] != c2) {
						b = 0;
						break;
					}
				}
				if (b) cur += a[i].size();
			}
			if (cur > ans)
				ans = cur;
		}
	}
	cout << ans;
}

int main() {
	solve();
}
