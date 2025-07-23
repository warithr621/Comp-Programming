// 2023 NAQ: Lines Per Hour

#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, l; cin >> n >> l;
	int a[n];
	for (int &i : a) cin >> i;
	sort(a, a + n);
	int ans = 0, cur = 0;
	for (int x : a) {
	    if (cur + x > 5 * l) break;
	    cur += x;
	    ++ans;
	}
	cout << ans << '\n';
}
