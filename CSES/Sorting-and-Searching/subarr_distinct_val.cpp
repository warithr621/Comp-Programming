// CSES Subarray Distinct Values

#include <bits/stdc++.h>
#define int long long
using namespace std;

signed main() {
    cin.tie(0)->sync_with_stdio(0);

    int n, k; cin >> n >> k;
    int a[n];
    for (int i = 0; i < n; i++) cin >> a[i];
    map<int, int> m;
    int L = 0, R = 0, ans = 0, sz = 0;


    while(L < n) {
        while(R < n) {
            if (m.count(a[R]) == 0) {
                if (sz == k) break;
                m[a[R]] = 1;
                ++sz;
            } else m[a[R]]++;
            ++R;
        }
        ans += R - L;
        
        if (m[a[L]] == 1) {
            --sz;
            m.erase(a[L]);
        } else m[a[L]]--;
        
        ++L;
    }

    
    cout << ans << '\n';
}