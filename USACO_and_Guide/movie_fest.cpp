// CSES Movie Festival

#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
using namespace std;

int main() {
    int n; cin >> n;
    vector<pair<int, int>> a(n);
    for (int i = 0; i < n; i++) {
        int start, stop; cin >> start >> stop;
        a[i] = make_pair(stop, start);
    }
    sort(a.begin(), a.end());
    int ans = 0, curt = -1;
    for (pair p : a) {
        if (p.second >= curt) {
            ++ans; curt = p.first;
        }
    }
    cout << ans << '\n';
}