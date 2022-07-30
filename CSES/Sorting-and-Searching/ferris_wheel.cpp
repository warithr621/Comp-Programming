// CSES Ferris Wheel
 
#include <iostream>
#include <algorithm>
#include <vector>
#include <iterator>
#define int long long
using namespace std;
 
int32_t main() {
    int n,x; cin >> n >> x;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a.begin(), a.end());
    int L = 0, R = n-1, ans = 0;
    vector<bool> have(n, false);
    while(L < R) {
        if (a[L] + a[R] > x) --R;
        else {
            ++ans;
            have[L++] = true;
            have[R--] = true;
        }
    }
    for (int i = 0; i < n; i++) ans += have[i] == false;
    cout << ans << '\n';
}
