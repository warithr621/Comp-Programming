#include <bits/stdc++.h>
using namespace std;

static const int fact[10] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
static const pair<int, int> swaps[] = {
	{0,1}, {1,2}, {3,4}, {4,5}, {6,7}, {7,8},
	{0,3}, {1,4}, {2,5}, {3,6}, {4,7}, {5,8}
};

int cantor(const array<int, 9>& p) {
	int idx = 0;
	bool used[10] = {false};
	for (int i = 0; i < 9; i++) {
		int l = 0;
		for (int v = 1; v < p[i]; v++) {
			l += (!used[v]);
		}
		used[p[i]] = true;
		idx += l * fact[8 - i];
	}
	return idx;
}

array<int, 9> decode(int idx) {
	array<int, 9> p;
	bool used[10] = {false};
	for (int i = 0; i < 9; i++) {
		int l = idx / fact[8 - i];
		idx %= fact[8 - i];
		int v = 1;
		while (l > 0 || used[v]) {
			if (!used[v]) {
				l--;
			}
			v++;
		}
		p[i] = v;
		used[v] = true;
	}
	return p;
}

int main() {
	cin.tie(0)->sync_with_stdio(0);
	array<int, 9> g;
	for (int i = 0; i < 9; i++) cin >> g[i];
	
	int n = fact[9];
	vector<int> d1(n, -1), d2(n, -1);
	deque<int> q1, q2;
	int start = cantor(g), goal = cantor({1,2,3,4,5,6,7,8,9});
	if (start == goal) {
		cout << "0\n";
		return 0;
	}
	d1[start] = 0; q1.push_back(start);
	d2[goal] = 0; q2.push_back(goal);
	while (!q1.empty() && !q2.empty()) {
		deque<int> &q = (q1.size() <= q2.size() ? q1 : q2);
		vector<int> &d = (q1.size() <= q2.size() ? d1 : d2);
		vector<int> &od = (q1.size() <= q2.size() ? d2 : d1);
		int sz = q.size();
		while(sz--) {
			int u = q.front(); q.pop_front();
			auto p = decode(u);
			for (auto [i, j] : swaps) {
				swap(p[i], p[j]);
				int v = cantor(p);
				if (od[v] != -1) {
					cout << d[u] + od[v] + 1 << '\n';
					return 0;
				}
				if (d[v] == -1) {
					d[v] = d[u] + 1;
					q.push_back(v);
				}
				swap(p[i], p[j]);
			}
		}
	}
}