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
};

int main() {
	int N; cin >> N;
	string S, T; cin >> S >> T;
	DSU dsu(26);
	for (int i = 0; i < N; i++) {
		int u = S[i] - 'a', v = T[i] - 'a';
		if (u != v) {
			dsu.unite(u, v);
		}
	}
	// hm maybe I do a bit of tomfoolery rn
	for (int i = 0; i < 26; i++) dsu.find(i); // just to make all the parents equal I think
	// for (int i = 0; i < 26; i++) {
	// 	cout << (char) ('a' + i) << ' ' << (char) ('a' + dsu.find(i)) << '\n';
	// }
	vector<pair<char, char>> ans;
	for (char parent = 'a'; parent <= 'z'; parent++) {
		vector<char> children;
		for (char child = 'a'; child <= 'z'; child++) {
			if (child != parent && dsu.find(child - 'a') == parent - 'a') {
				children.push_back(child);
			}
		}
		for (char child : children) {
			ans.push_back({parent, child});
		}
	}
	cout << ans.size() << '\n';
	for (auto& [parent, child] : ans) {
		cout << parent << ' ' << child << '\n';
	}
}