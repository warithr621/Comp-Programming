// CSES Subarray Sums II

#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main() {
    int n,x; cin >> n >> x;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    int pfx = 0, ans = 0;
    map<int, int> sum; sum[0] = 1;
    for (int i : a) {
        pfx += i;
        ans += sum[pfx - x];
        ++sum[pfx];
    }
    cout << ans << '\n';
}