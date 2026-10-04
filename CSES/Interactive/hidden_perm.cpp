#include <bits/stdc++.h>
using namespace std;

bool query(int x, int y) {
	cout << "? " << x << ' ' << y << endl;
	string res; cin >> res;
	return res == "YES"; // yes means x < y
}

int main() {
	int n; cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; i++) a[i] = i;
	// now we just merge sort this
	auto merge = [&](auto self, vector<int> &a, int l, int r) -> void {
		if (l + 1 >= r) return;
		int m = (l + r) / 2;
		self(self, a, l, m);
		self(self, a, m, r);
		vector<int> b(r - l);
		int i = l, j = m;
		for (int k = 0; k < r - l; k++) {
			if (i < m && (j >= r || query(a[i]+1, a[j]+1))) {
				b[k] = a[i++];
			} else {
				b[k] = a[j++];
			}
		}
		for (int k = 0; k < r - l; k++) {
			a[l + k] = b[k];
		}
	};
	merge(merge, a, 0, n);
	vector<int> ans(n);
	for (int i = 0; i < n; i++) {
		ans[a[i]] = i + 1;
	}
	cout << "! ";
	for (int x : ans) cout << x << ' ';
	cout << endl;
}