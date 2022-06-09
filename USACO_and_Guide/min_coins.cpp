#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, x; cin >> n >> x;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    vector<long long> ans(x+1, INT_MAX);
    ans[0] = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j <= x; j++) {
            if (j - a[i] >= 0) {
                ans[j] = min(ans[j], ans[j-a[i]] + 1);
            }
        }
    }
    cout << (ans[x] == INT_MAX ? -1 : ans[x]);
}