#include <bits/stdc++.h>
using namespace std;
#define int long long
#define double long double

signed main() {
	int w,k,c; cin >> w >> k >> c;
	// goal number of wishes, starting rank, k' <= k-c
	if (k > w) {
		cout << "no\n";
		return 0;
	}
	int poss = 0;
	while (k != 0) {
		poss += k-1;
		k = max(k-c, 0LL);
		if (k == 0) poss++; // needed to use kth wish lol
	}
	cout << (poss >= w ? "yes" : "no") << '\n';
}