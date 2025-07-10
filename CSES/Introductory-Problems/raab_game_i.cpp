#include <bits/stdc++.h>
using namespace std;

void solve() {
	int n,a,b; cin >> n >> a >> b;
	if (a + b > n || (min(a,b) == 0 && max(a,b) > 0)) {
		cout << "NO\n";
		return;
	}

	cout << "YES\n";
	int alpha[n], beta[n];
	bool sw = (a > b);
	if (sw) swap(a,b);
	for (int i = 0; i < n; i++) {
		alpha[i] = beta[i] = i+1;
	}
	int cnt = 0, i = 0;
	while (i + 1 < n && cnt < a-1) {
		swap(beta[i], beta[i+1]);
		i += 2;
		cnt++;
	}
	if (!(a==0 && b==0)) {
		int start = 2 * (a-1), end = (a+b-1);
		if (start < n && end < n && start <= end) {
			rotate(beta + start, beta + start + 1, beta + end + 1);
		}
	}

	if (sw) swap_ranges(alpha, alpha + n, beta);
	for (int i = 0; i < n; i++) {
		cout << alpha[i] << " ";
	}
	cout << '\n';
	for (int i = 0; i < n; i++) {
		cout << beta[i] << " ";
	}
	cout << '\n';
}

int main() {
	int T; cin >> T;
	while(T--) solve();
}