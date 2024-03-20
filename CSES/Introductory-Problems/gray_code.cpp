// CSES Gray Code

#include <bits/stdc++.h>
using namespace std;
#define int long long
 
signed main() {
    int N; cin >> N;
    const int sz = N;
    int cur = 0;
    for (int i = 0; i < (1 << N); i++) {
        cur ^= (-i & i);
        int tmp = cur;
        for (int j = (1 << (N-1)); j > 0; j >>= 1) {
            if (tmp >= j) {
                cout << 1;
                tmp -= j;
            } else cout << 0;
        }
        cout << '\n';
    }
}