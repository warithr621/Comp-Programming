// https://codeforces.com/problemset/problem/701/C

#include <bits/stdc++.h>
using namespace std;

int main() {
	int n; string s;
	cin >> n >> s;
	set<char> tmp;
	for (char c : s) tmp.insert(c);
	int unique = (int) tmp.size();

	int L = 1, R = n;
	while(L < R) {
		int M = (L + R) / 2;

		bool yay = false;
		map<char, int> mp;
		for (int i = 0; i < M; i++) mp[ s[i] ]++;
		if ((int) mp.size() >= unique) yay = true;

		for (int i = M; i < n; i++) {
			mp[ s[i-M] ]--;
			if (mp[ s[i-M] ] == 0) mp.erase(s[i-M]);
			mp[ s[i] ]++;
			yay |= (int) mp.size() >= unique;
		}

		// cout << M << ' ' << (yay ? "T" : "F") << '\n';

		if (yay) R = M;
		else L = ++M;
	}

	cout << L << '\n';
}