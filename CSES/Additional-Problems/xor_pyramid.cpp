// CSES Xor Pyramid

#include <bits/stdc++.h>
using namespace std;

int mod[200005];

int main() {
	cin.tie(0)->sync_with_stdio(0);

	for (int i = 1; i < 200005; i++) {
		int cur = i;
		while (!(cur & 1)) {
			cur >>= 1;
			mod[i]++;
		}
		mod[i] += mod[i-1];
	}
	
	int N; cin >> N;
	int A[N];
	for (int &x : A) cin >> x;
	int ans = 0;
	for (int i = 0; i < N; i++) {
		if (mod[N-1] - mod[i] - mod[N-1-i] == 0) {
			ans ^= A[i];
		}
	}
	
	cout << ans << '\n';
}