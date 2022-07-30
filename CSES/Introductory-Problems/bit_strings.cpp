// CSES Bit Strings

#include <bits/stdc++.h>
using namespace std;
 
int main() {
	typedef unsigned long long ull;
	ull n, ans=1; cin >> n;
	while (n--) {
		ans = (ans * 2) % 1000000007;
	}
	cout << ans << "\n";
}