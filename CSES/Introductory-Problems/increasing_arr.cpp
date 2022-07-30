// CSES Increasing Array

#include <bits/stdc++.h>
using namespace std;
 
int main() {
	typedef unsigned long long ull;
	ull n; cin >> n;
	ull ans = 0;
	vector<int> val(n);
	for (ull i = 0; i < n; i++) cin >> val[i];
	for (ull i = 0; i < n - 1; i++) {
		if (val[i] > val[i+1]) {
			ans += val[i] - val[i+1];
			val[i+1] = val[i];
		}
	}
	cout << ans << "\n";
}