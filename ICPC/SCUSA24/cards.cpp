#include <bits/stdc++.h>
using namespace std;
#define int long long

int wins(vector<int>&a, vector<int>&b, int n) {
	// max no. of games A can win against B
	int ans = 0;
	int ptrA = 0, ptrB = 0;
	while (ptrA < n && ptrB < n) {
		if (a[ptrA] > b[ptrB]) {
			++ans;
			++ptrA;
			++ptrB;
		} else {
			++ptrA;
		}
	}
	return ans;
}

signed main() {
	int n; cin >> n;
	vector<bool> cards(2*n+1, false); // true if alice
	for (int i = 0; i < n; i++) {
		int x; cin >> x;
		cards[x] = true;
	}
	vector<int> alice, bob;
	for (int i = 1; i <= 2*n; i++) {
		if (cards[i]) alice.push_back(i);
		else bob.push_back(i);
	}
	cout << n - wins(bob, alice, n) << ' ' << wins(alice, bob, n) << '\n';
}

