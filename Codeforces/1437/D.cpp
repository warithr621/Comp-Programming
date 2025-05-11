#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
	int T; cin >> T;
	while (T--) {
		int N; cin >> N;
		int A[N];
		for (int &x : A) {
			cin >> x;
		}
		int H[N];
		fill(H, H + N, (int) (1e9));
		H[0] = 0;
		int parent = 0;
		for (int i = 1; i < N; i++) {
			if (i > 1 && A[i-1] > A[i]) ++parent;
			H[i] = H[parent] + 1;
		}
		cout << H[N-1] << '\n';
	}
}