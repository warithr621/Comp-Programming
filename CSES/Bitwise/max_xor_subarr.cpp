#include <bits/stdc++.h>
using namespace std;

struct TrieNode {
	TrieNode* bits[2];
	TrieNode() {
		bits[0] = nullptr;
		bits[1] = nullptr;
	}
};

struct Trie {
	TrieNode* root;

	Trie() {
		root = new TrieNode();
	}

	void insert(int num) {
		TrieNode* cur = root;
		for (int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;
			if (!cur->bits[bit]) {
				cur->bits[bit] = new TrieNode();
			}
			cur = cur->bits[bit];
		}
	}

	int query(int num) {
		// from MSB to LSB, find the opposite bit if possible
		TrieNode* cur = root;
		int mx = 0;
		for (int i = 31; i >= 0; i--) {
			int b = (num >> i) & 1;
			if (cur->bits[1-b]) {
				mx |= (1 << i);
				cur = cur->bits[1-b];
			} else {
				cur = cur->bits[b];
			}
		}
		return mx;
	}
};

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int n; cin >> n;
	Trie t;
	t.insert(0);
	int ans = -1, pfx = 0;
	for (int i = 0; i < n; i++) {
		int x; cin >> x;
		pfx ^= x;
		ans = max(ans, t.query(pfx));
		t.insert(pfx);
	}
	cout << ans << '\n';
}