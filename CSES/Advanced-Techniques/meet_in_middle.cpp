// CSES Meet in the Middle

#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, x; cin >> n >> x;
    int M = n/2;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    vector<int> L, R;
    
    for (int i = 0; i < (1 << M); i++) {
        int sum = 0;
        for (int j = 0; j < 32; j++) {
            if (i & (1 << j)) sum += a[j];
        }
        L.push_back(sum);
    }
    
    int rem = n - M;
    for (int i = 0; i < (1 << rem); i++) {
        int sum = 0;
        for (int j = 0; j < 32; j++) {
            if (i & (1 << j)) sum += a[M+j];
        }
        R.push_back(sum);
    }
    
    int ans = 0;
    map<int, int> m;
    sort(R.begin(), R.end());
    for (int i = 0; i < L.size(); i++) {
        ans += upper_bound(R.begin(), R.end(), x - L[i]) - lower_bound(R.begin(), R.end(), x - L[i]);
    }
    cout << ans << '\n';
}