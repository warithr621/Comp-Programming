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

int main() {
	freopen("input.txt", "r", stdin);

	while(getline(cin, S)) {
		if (S.size() == 0) break;
		maf();
	}

	int res = 0;
	for (int i = 20; i <= 220; i += 40) res += ans[i] * i;
	cout << res << '\n';
}