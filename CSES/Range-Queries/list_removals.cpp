#include <bits/stdc++.h>
using namespace std;

struct Fenwick {
	int n;
	vector<int> bit;
	int highestPow;

	Fenwick(int n) : n(n), bit(n + 1, 0) {
		highestPow = 1;
		while ((highestPow << 1) <= n) highestPow <<= 1;
	}

	void add(int i, int v) {
		for (; i <= n; i += i & -i) {
			bit[i] += v;
		}
	}

	int sum(int i) {
		int s = 0;
		for (; i > 0; i -= i & -i) {
			s += bit[i];
		}
		return s;
	}

	int find_kth(int k) {
		int idx = 0;
		for (int pw = highestPow; pw > 0; pw >>= 1) {
			int next = idx + pw;
			if (next <= n && bit[next] <= k) {
				k -= bit[next];
				idx = next;
			}
		}
		return idx + 1;
	}
};

int main() {
	int n; cin >> n;
	vector<int> arr(n);
	for (int &x : arr) {
		cin >> x;
	}
	Fenwick fw(n);
	for (int i = 1; i <= n; i++) {
		fw.add(i, 1);
	}
	for (int q = 0; q < n; q++) {
		int pos; cin >> pos;
		int idx = fw.find_kth(--pos);
		cout << arr[idx-1] << ' ';
		fw.add(idx, -1);
	}
}