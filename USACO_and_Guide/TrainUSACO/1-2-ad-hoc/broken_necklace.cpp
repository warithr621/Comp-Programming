// USACO Trainer's "Broken Necklace"

/*
ID: warithr1
LANG: C++11
TASK: beads
*/

#include <bits/stdc++.h>
using namespace std;

int N;
string S;

int md(int a, int m) {
	return (a % m + m) % m;
}

int br(int start, int dir) {
	char color = 'w';
	int i = (dir == 1 ? start : md(start-1, N)), cur;

	for (cur = 0; cur < N; ++cur, i = md(i+dir, N)) {
		if (color == 'w' && S[i] != 'w') {
			color = S[i];
		}
		if (color != 'w' && S[i] != 'w' && S[i] != color) {
			break;
		}
	}

	return cur;
}

int main() {
	freopen("beads.in", "r", stdin);
	freopen("beads.out", "w", stdout);

	cin >> N >> S;

	int mx = 0;
	for (int i = 0; i < N; i++) {
		mx = max(mx, br(i,1) + br(i,-1));
	}

	cout << min(mx, N) << '\n';
}