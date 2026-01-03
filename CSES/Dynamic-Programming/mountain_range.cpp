#include <bits/stdc++.h>
using namespace std;
const int MAXN = (int) (2e5) + 1;
int t[4 * MAXN]; // max segtree

void build(const vector<int> &vec, int v, int tl, int tr) {
	if (tl == tr) {
		t[v] = vec[tl];
	} else {
		int tm = (tl + tr) / 2;
		build(vec, v*2, tl, tm);
		build(vec, v*2+1, tm+1, tr);
		t[v] = max(t[v*2], t[v*2+1]);
	}
}

int mx(int v, int tl, int tr, int l, int r) {
	if (l > r) return 0;
	if (l == tl && r == tr) return t[v];
	int tm = (tl + tr) / 2;
	return max(mx(v*2, tl, tm, l, min(r, tm)),
		mx(v*2+1, tm+1, tr, max(l, tm+1), r));
}

void update(int v, int tl, int tr, int pos, int changed) {
	if (tl == tr) {
		t[v] = changed;
	} else {
		int tm = (tl + tr) / 2;
		if (pos <= tm) update(v*2, tl, tm, pos, changed);
		else update(v*2+1, tm+1, tr, pos, changed);
		t[v] = max(t[v*2], t[v*2+1]);
	}
}

int main() {
	int n; cin >> n;
	vector<int> h(n);
	for (int &x : h) {
		cin >> x;
	}
	build(vector<int>(n, 0), 1, 0, n-1);
	// for each index, find the first mountain to the left not less
	// and the first mountain to the right not less
	vector<int> left(n, 0), right(n, n-1);
	stack<int> st;
	for (int i = 0; i < n; i++) {
		while (!st.empty() && h[st.top()] < h[i]) {
			st.pop();
		}
		if (!st.empty()) left[i] = st.top()+1;
		st.push(i);
	}
	st = stack<int>();
	for (int i = n-1; i >= 0; i--) {
		while (!st.empty() && h[st.top()] < h[i]) {
			st.pop();
		}
		if (!st.empty()) right[i] = st.top()-1;
		st.push(i);
	}
	
	vector<int> indices;
	for (int i = 0; i < n; i++) indices.push_back(i);
	sort(indices.begin(), indices.end(), [&](const int& a, const int& b) {
		return h[a] < h[b];
	});
	for (int i : indices) {
		int MX = mx(1, 0, n-1, left[i], right[i]);
		update(1, 0, n-1, i, 1+MX);
	}
	cout << mx(1, 0, n-1, 0, n-1) << '\n';
}