// AoC 2022 D9

#include <bits/stdc++.h>
using namespace std;

string S;
set<pair<int, int>> st;
int hx=0, hy=0, px, py, tx=0, ty=0;

void do_stuff() {
	char d = S[0];
	int mv = stoi(S.substr(2));
	while(mv--) {
		px = hx; py = hy;
		if (d=='U') ++hy;
		if (d=='D') --hy;
		if (d=='L') --hx;
		if (d=='R') ++hx;

		if (abs(tx-hx) > 1 || abs(ty-hy) > 1) {
			tx = px; ty = py;
		}

		st.insert({tx, ty});
	}
}

int main() {
	freopen("input.txt", "r", stdin);

	while(getline(cin, S)) {
		if (S.size() == 0) break;
		do_stuff();
	}

	cout << st.size() << '\n';
}