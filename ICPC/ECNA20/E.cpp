#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

int cipher(char c) {
	if ('A' <= c && c <= 'Z') return c - 'A';
	else if ('0' <= c && c <= '9') return (c - '0') + 26;
	else return 36;
}

char decipher(int x) {
	if (x < 26) return (char) ('A' + x);
	else if (x != 36) return (char) ('0' + (x - 26));
	else return ' ';
}

signed main() {
	cin.tie(0)->sync_with_stdio(0);
	cout << fixed << setprecision(8);

	int n; cin >> n;
	vector<vector<int>> mat(n, vector<int>(n));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> mat[i][j];
		}
	}
	string s;
	getline(cin, s); getline(cin, s);
	while (!s.empty() && s.back() == '\r') s.pop_back();
	int cols = ((int)s.size() + n - 1) / n; // ceil cause padding
	vector<vector<int>> conv(n, vector<int>(cols, 36));
	for (int j = 0; j < cols; j++) {
		for (int i = 0; i < n; i++) {
			if (j * n + i >= s.size()) continue;
			conv[i][j] = cipher(s[j * n + i]);
			// cout << i << ' ' << j << ' ' << j*n*i << ' ' << s[j*n+i] << ' ' << conv[i][j] << '\n';
		}
	}

	// now multiply mat * conv, printing as we go
	for (int j = 0; j < cols; j++) {
		for (int i = 0; i < n; i++) {
			// cout << i << ' ' << j << ' ' << '!' << conv[i][j];
			int cur = 0;
			for (int k = 0; k < n; k++) {
				cur += mat[i][k] * conv[k][j];
				cur %= 37;
			}
			cout << decipher(cur);
		}
	}
	cout << '\n';
}