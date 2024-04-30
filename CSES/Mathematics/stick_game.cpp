// CSES Stick Game

#include <bits/stdc++.h>
using namespace std;

int N, K, P[105], ans[1000005];

int main() {
	cin >> N >> K;
	for (int i = 1; i <= K; i++) cin >> P[i];

	for (int i = 1; i <= K; i++) {
		// mark the ones we can already pick as W (2)
		ans[P[i]] = 2;
	}

	for (int i = 1; i <= N; i++) {
		// if already set, continue
		if (ans[i] != 0) continue;
		// if anything prior to it is L, we win
		// otherwise we suck
		int val = 1;
		for (int j = 1; j <= K; j++) {
			if (i - P[j] >= 1 && ans[i - P[j]] == 1) {
				val = 2;
			}
		}
		ans[i] = val;
	}

	for (int i = 1; i <= N; i++) {
		cout << (ans[i] == 1 ? 'L' : 'W');
	}
}