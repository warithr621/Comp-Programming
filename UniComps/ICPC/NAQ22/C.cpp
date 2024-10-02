// 2022 NAQ: Class Field Trip

#include <bits/stdc++.h>
using namespace std;

int main() {
	string S, T; cin >> S >> T;
	int N = S.size(), M = T.size();
	for (int i = 0, j = 0; i < N || j < M; ) {
		if (i == N) cout << T[j++];
		else if (j == M) cout << S[i++];
		else if (S[i] < T[j]) cout << S[i++];
		else cout << T[j++];
	}
}
