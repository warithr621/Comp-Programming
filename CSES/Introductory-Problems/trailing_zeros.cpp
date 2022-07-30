// CSES Trailing Zeros

#include <bits/stdc++.h>
using namespace std;
 
int main() {
	typedef unsigned long long ull;
	ull n, p=1, ans=0; cin >> n;
	while ( pow(5, p) <= n) {
		ans += n / (pow(5,p));
		p++;
	}
	cout << ans << "\n";
}