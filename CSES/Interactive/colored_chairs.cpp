#include <bits/stdc++.h>
using namespace std;

int n;
unordered_map<int, char> mp;

char query(int pos) {
	int idx = ((pos - 1) % n) + 1; // wrap into [1, n]
	if (mp.count(idx)) return mp[idx];
	cout << "? " << pos << endl;
	char c; cin >> c;
	mp[idx] = c;
	return c;
}

void ans(int x) {
	cout << "! " << x << endl;
	exit(0);
}

bool valid(int L, int R, char cl, char cr) {
	// if we have an odd diff, say 1-2-3-4, then 1=4 implies an equal pair exists
	// if even diff, say 1-2-3-4-5, then 1!=5 implies an equal pair exists
	return ((R-L) & 1) ? cl == cr : cl != cr;
}

int main() {
	cin >> n;
	int L = 1, R = n + 1;
	char cl = query(L);

	while (R - L > 1) {
		int M = (L + R) / 2;
		char cm = query(M);
		if (valid(L, M, cl, cm)) {
			R = M;
		} else {
			L = M;
			cl = cm;
		}
	}

	ans(((L - 1) % n) + 1);
}