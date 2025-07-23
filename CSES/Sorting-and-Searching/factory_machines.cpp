#include <bits/stdc++.h>
using namespace std;
#define int long long
 
signed main() {
	cin.tie(0)->sync_with_stdio(0);
 
	int N, K; cin >> N >> K;
	int A[N];
	for (int &x : A) cin >> x;
	int L = 1, R = K * *min_element(A, A + N);
 
	while (L < R) {
		int M = (L + R) >> 1;
		// can you do it in t = M?
		int products = 0;
		for (int x : A) products += M / x;
		if (products >= K) {
			R = M;
		} else {
			L = ++M;
		}
	}
	
	cout << L << '\n';
}