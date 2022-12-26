// 2022 Dec Silver P2

#include <bits/stdc++.h>
using namespace std;

const int MAXN = 5000005;
bool prime[MAXN];
int T, N, A[100005], mod4[4] = {2, 1, 2, 3}, turns[MAXN];

void sieve() {
	memset(prime, true, sizeof(prime));
	// new idea: pre-compute # of turns during the sieve
	turns[1] = 1;

	for (int i = 2; i < MAXN; ++i) {
		if (prime[i]) {
			// keep this as prime, then mark all multiples composite
			for (int j = 2*i; j < MAXN; j += i) { // lol out of bounds if you do i*i instead of 2*i
				prime[j] = false;
			}

			//next for turn pre-computing, note this is currently the biggest prime mod4
			mod4[i % 4] = i;
		}
		// lastly, mark the # of turns for a specific A[i]
		if (i % 2 == 0) turns[i] = i/2;
		else turns[i] = 1 + (i - mod4[i % 4]) / 2;
	}
}

void solve() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	
	/*
	if 'a' is even, then the optimal move for both farmers is to always subtract 2
	thus the total number of turns is 'a'/2

	if 'a' is odd, first farmer is going to remove the biggest possible prime, then follow even case
	thus, 1 + ('a' - prime) / 2
	other catch is that this prime should be the same as 'a' taken mod 4
	*/

	int game_ends = MAXN;
	for (int i = 0; i < N; i++) {
		if (turns[A[i]] / 2 < game_ends / 2) {
			// each room has 2 turns per cycle
			game_ends = turns[A[i]];
		}
	}

	// if # of turns is odd, John wins
	if (game_ends & 1) cout << "Farmer John\n";
	else cout << "Farmer Nhoj\n";
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	sieve();
	cin >> T;
	while(T--) solve();
}