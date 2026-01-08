#include <bits/stdc++.h>
using namespace std;

class DSU {
	private:
		vector<int> parents;
		vector<int> sizes;

	public:
		DSU(int size) : parents(size), sizes(size, 1) {
			for (int i = 0; i < size; i++) { parents[i] = i; }
		}

		int find(int x) { return parents[x] == x ? x : (parents[x] = find(parents[x])); }

		bool unite(int x, int y) {
			int x_root = find(x);
			int y_root = find(y);
			if (x_root == y_root) { return false; }

			if (sizes[x_root] < sizes[y_root]) { swap(x_root, y_root); }
			sizes[x_root] += sizes[y_root];
			parents[y_root] = x_root;
			return true;
		}

		bool connected(int x, int y) { return find(x) == find(y); }

		int size(int x) { return sizes[find(x)]; }
};

int main() {
	int n, m; cin >> n >> m;
	int comps = n, largest = 0; // 0-indexing
	// largest is the *vertex*, not the actual size
	DSU dsu(n);
	while(m--) {
		int a,b; cin >> a >> b;
		--a; --b;
		if (!dsu.connected(a,b)) {
			--comps;
			dsu.unite(a, b);
			if (dsu.size(a) > dsu.size(largest)) largest = a;
		}
		cout << comps << ' ' << dsu.size(largest) << '\n';
	}
}