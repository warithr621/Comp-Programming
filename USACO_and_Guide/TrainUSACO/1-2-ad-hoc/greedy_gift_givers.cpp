// USACO Trainer's "Greedy Gift Givers"

/*
ID: warithr1
LANG: C++11
TASK: gift1
*/

#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("gift1.in", "r", stdin);
	freopen("gift1.out", "w", stdout);

	int N; cin >> N;
	unordered_map<string, int> m;
	vector<int> val;
	vector<string> names;

	for (int i = 0; i < N; i++) {
		string name; cin >> name;
		m[name] = i;
		val.push_back(0);
		names.push_back(name);
	}

	for (int i = 0; i < N; i++) {
		string giver; cin >> giver;
		int giver_idx = m[giver];

		int amt, num; cin >> amt >> num;
		if (amt == 0 || num == 0) continue; // edge
		int gifted = amt / num, left = amt - gifted * num;

		for (int i = 0; i < num; i++) {
			string reward; cin >> reward;
			val[m[reward]] += gifted;
		}
		val[giver_idx] -= amt - left;
	}

	for (int i = 0; i < N; i++) {
		cout << names[i] << ' ' << val[i] << '\n';
	}
}