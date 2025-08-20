#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
using namespace __gnu_pbds;

template <typename T>
using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;

int main() {
	int n, k; cin >> n >> k;
	ordered_set<int> os;
	for (int i = 1; i <= n; i++) {
		os.insert(i);
	}
	int pos = 0;
	while (!os.empty()) {
		pos = (pos + k) % os.size();
		auto it = os.find_by_order(pos);
		cout << *it << ' ';
		os.erase(it);
	}
}