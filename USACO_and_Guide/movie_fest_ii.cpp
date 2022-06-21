// CSES Movie Festival II

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <set>
using namespace std;

int32_t main() {
    cin.tie(0)->sync_with_stdio(0);
    
    int n,k; cin >> n >> k;
    vector<pair<int, int>> a(n);
    for (int i = 0; i < n; i++) {
        int first,last;
        cin >> first >> last;
        a[i] = make_pair(last, first);
    }
    sort(a.begin(), a.end());
    multiset<int> ends;
    for (int i = 0; i < k; i++) ends.insert(0);
    int ans = 0;
    for (auto p : a) {
        auto it = ends.upper_bound(p.second);
        if (it == ends.begin()) continue;

        ends.erase(--it);
        ends.insert(p.first);

        ++ans;
    }
    cout << ans << '\n';

}
