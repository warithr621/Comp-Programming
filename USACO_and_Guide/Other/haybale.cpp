// 2012 Jan Bronze P2

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("stacking.in", "r", stdin);
	freopen("stacking.out", "w", stdout);
	int n,k; cin >> n >> k;	
	vector<int> diff(n+1, 0);
	for (int i = 0; i < k; i++) {
	    int L,R; cin >> L >> R;
	    diff[L-1]++;
	    diff[R]--;
	}
	// for (int i : diff) cout << i << ' ';
	// cout << '\n';
	vector<int> fin(n);
	fin[0] = diff[0];
	for (int i = 1; i < n; i++) fin[i] = fin[i-1] + diff[i];
	// for (int i : fin) cout << i << ' ';
	// cout << '\n';
	sort(fin.begin(), fin.end());
	cout << fin[n/2] << '\n';
}