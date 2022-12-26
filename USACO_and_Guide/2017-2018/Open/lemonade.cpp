// 2018 Open Silver P2

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    freopen("lemonade.in", "r", stdin);
    freopen("lemonade.out", "w", stdout);
    
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a.rbegin(), a.rend());
    int ans = 0, queue = 0;
    for (int i = 0; i < n; i++) {
        if (queue <= a[i]) {
            ++ans; ++queue;
        }
    }
    cout << ans << '\n';
}