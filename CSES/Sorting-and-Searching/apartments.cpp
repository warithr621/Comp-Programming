// CSES Apartments
 
#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;
#define int long long
 
int32_t main() {
    int n,m,k; cin >> n >> m >> k;
    vector<int> a(n), b(m);
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    int aptr = 0, bptr = 0, ans = 0;
    while(aptr < n && bptr < m) {
        if (abs(a[aptr] - b[bptr]) <= k) {
            ++aptr; ++bptr; ++ans;
        } else if (a[aptr] - b[bptr] > k) ++bptr;
        else ++aptr;
    }
    cout << ans << '\n';
}
