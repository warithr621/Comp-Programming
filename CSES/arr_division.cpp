// CSES Array Division

#include <bits/stdc++.h>
#define int long long
using namespace std;

int32_t main() {
	int n,k; cin >> n >> k;
	vector<int> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];

	//binsearch on the max sum
	int L = 1, R = 200000000000005;
	int ans = 0;
	while(L <= R) {
		int M = (L + R) / 2;
		int subarr = 0, sum = 0;
		for (int i = 0; i < n; i++) {
		    if (a[i] > M) {
		        subarr = k+7;
		        break;
		    }
		    if (sum + a[i] > M) {
		        ++subarr;
		        sum = 0;
		    }
		    sum += a[i];
		}
		if (sum > 0) ++subarr;
		
		if (subarr <= k) {
		    ans = M--;
		    R = M;
		} else L = ++M;
	}
	cout << L << '\n';
}
