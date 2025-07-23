// 2023 NAQ: Water Journal

#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, a, b; cin >> n >> a >> b;
	vector<int> f(55, 0);
	for (int i = 1; i < n; i++) {
	    int x; cin >> x;
	    f[x]++;
	}
	if (f[a] == 0 && f[b] == 0) cout << "-1\n";
	else if (f[a] == 0) cout << a << '\n';
	else if (f[b] == 0) cout << b << '\n';
	else {
	    for (int i = a; i <= b; i++) cout << i << '\n';
	}
}
