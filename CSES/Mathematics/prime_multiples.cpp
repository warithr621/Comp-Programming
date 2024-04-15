// CSES Prime Multiples

#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    int N, K;
    cin >> N >> K;
    vector<int> A(K);
    for (int &i : A) cin >> i;
    
    int ans = 0;
    for (int i = 1; i < (1 << K); ++i) {
        int prod = 1, cnt = 0;
        for (int j = 0; j < K; ++j) {
            if (i & (1 << j)) {
                if (prod >= (1LL << 62) / A[j]) {
                    // long long overflow...
                    prod = N+1;
                    break;
                }
                prod *= A[j];
                cnt += 1;
            }
        }
        ans += (cnt % 2 == 1 ? 1 : -1) * (N / prod);
    }
    cout << ans;
}
