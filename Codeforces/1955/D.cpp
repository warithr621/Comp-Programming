#include <iostream>
#include <set>
#include <vector>
#define int long long
 
using namespace std;
 
void solve() {
    int n, m, k; cin >> n >> m >> k;
    vector<int> a(n);
    for (int &x : a) cin >> x;
    multiset<int> cur, paired, sus;
    for (int j = 0; j < m; j++) {
        int b; cin >> b;
        cur.insert(b);
    }
    for (int j = 0; j < m; j++) {
        if (cur.find(a[j]) != cur.end()) {
            cur.erase(cur.find(a[j]));
            paired.insert(a[j]);
        } else {
            sus.insert(a[j]);
        }
    }
    int ans = (paired.size() >= k);
    for (int r = m; r < n; r++) {
        int old = a[r - m];
        if (sus.find(old) != sus.end()) {
            sus.erase(sus.find(old));
        } else if (paired.find(old) != paired.end()) {
            paired.erase(paired.find(old));
            cur.insert(old);
        }
        if (cur.find(a[r]) != cur.end()) {
            cur.erase(cur.find(a[r]));
            paired.insert(a[r]);
        } else {
            sus.insert(a[r]);
        }
        ans += (paired.size() >= k);
    }
    cout << ans << '\n';
}
 
signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while (T--) solve();
}