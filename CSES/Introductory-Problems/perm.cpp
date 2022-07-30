// CSES Permutations

#include <bits/stdc++.h>
using namespace std;
 
int main() {
	int n; cin >> n;
	if (n == 1) {
		cout << 1 << "\n";
	} else if (n <= 3) {
		cout << "NO SOLUTION\n";
	} else {
		cout << 2;
		for (int i = 2; i <= n/2; i++) {
			cout << " " << 2*i;
		}
		for (int i = 1; i <= (n+1)/2; i++) {
			cout << " " << 2*i-1;
		}
		
	} 
}