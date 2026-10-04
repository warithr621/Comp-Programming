#include <bits/stdc++.h>
using namespace std;
#define int long long
 
const int MOD = 1e9+7;
const int p = 67; // im hilarious
 
signed main() {
    string s; cin >> s;
    int n = s.size();
    int ppow[n] = {1};
    for (int i = 1; i < n; i++) {
        ppow[i] = (ppow[i-1] * p) % MOD;
    }
    int pleft = 0, pright = 0;
    for (int i = 0; i < n-1; i++) {
        int l = s[i] - 'a' + 1, r = s[n-i-1] - 'a' + 1;
        pleft = (pleft + l * ppow[i]) % MOD;
        pright = (pright * p + r) % MOD;
        if (pleft == pright) {
            cout << i+1 << ' ';
        }
    }
    cout << '\n';
}