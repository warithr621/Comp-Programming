#include <iostream>
#include <unordered_set>
#include <vector>
#define st unordered_set
#define int long long
using namespace std;

signed main() {
	int T; cin >> T;
	while (T--) {
		int N; cin >> N;
		vector<int> A(N);
		for (int &x : A) cin >> x;
		int ans = 0;
		st<int> cur, nxt;
		for (int x : A) {
			cur.insert(x);
			nxt.insert(x);
			if (cur.size() == nxt.size()) {
				++ans;
				nxt.clear();
			}
		}
		cout << ans << '\n';
	}
}