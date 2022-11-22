// AoC 2019 D1

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("input.txt", "r", stdin);

	int ans = 0, n;
	while(cin >> n) {
		ans += n / 3 - 2;
	}

	cout << ans << '\n';
}