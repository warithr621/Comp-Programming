// lmao I spent half the time solving this problem fixing my gcc :sob:

#include <iostream>
using namespace std;

void solve() {
	int N, M, K; cin >> N >> M >> K;
	int cur = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (M % K != 0) cout << cur+1 << ' ';
			else cout << (cur+i)%K + 1 << ' ';
			cur = (cur + 1) % K;
		}
		cout << '\n';
	}
}

int main() {
	int T; cin >> T;
	while (T--) solve();
}