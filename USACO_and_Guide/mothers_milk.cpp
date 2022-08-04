// USACO Trainer's "Mother's Milk"

/*
ID: REDACTED
LANG: C++11
TASK: milk3
*/

#include <bits/stdc++.h>
using namespace std;

bool sol[25], mark[25][25][25];

int AL, BL, CL, AT, BT, CT;

pair<int, int> move(int src, int dest, int len) {
	while(src > 0 && dest < len) {
		--src;
		++dest;
	}
	return {src, dest};
}

void solve(int a, int b, int c) {
	if (mark[a][b][c]) return;
	mark[a][b][c] = true; //vis
	
	if (a == 0) sol[c] = true;
	tie(CT, AT) = move(c, a, AL); solve(AT, b, CT);
	tie(CT, BT) = move(c, b, BL); solve(a, BT, CT);
	
	tie(AT, BT) = move(a, b, BL); solve(AT, BT, c);
	tie(AT, CT) = move(a, c, CL); solve(AT, b, CT);

	tie(BT, AT) = move(b, a, AL); solve(AT, BT, c);
	tie(BT, CT) = move(b, c, CL); solve(a, BT, CT);
}

int main() {
	freopen("milk3.in", "r", stdin);
	freopen("milk3.out", "w", stdout);

	cin >> AL >> BL >> CL;
	solve(0, 0, CL);
	
	int printed = 0; //bruh I forgot trainer cares about whitespace smh
	for (int i = 0; i < 25; ++i) {
		if (sol[i]) {
			if (printed != 0) cout << ' ';
			cout << i; ++printed;
		}
	}
	cout << '\n';
}