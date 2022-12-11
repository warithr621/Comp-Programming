// AoC 2022 D10

#include <bits/stdc++.h>
using namespace std;

int cycle = 0, val = 1, ans[2005];
string S;

void maf() {
	if (S[0] == 'n') ans[++cycle] = val;
	else {
		int x = stoi(S.substr(5));
		ans[cycle+1] = ans[cycle+2] = val;
		val += x; cycle += 2;
	}
}

void oog(int i, int j) {
	int x = i*40 + j+1;
	if (abs(ans[x]-j) <= 1) cout << '#';
	else cout << '.';
}


int main() {
	freopen("input.txt", "r", stdin);

	while(getline(cin, S)) {
		if (S.size() == 0) break;
		maf();
	}

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 40; ++j) oog(i,j);
		cout << '\n';
	}
}