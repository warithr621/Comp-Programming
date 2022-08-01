// CSES Distributing Apples

#include <bits/stdc++.h>
#define int long long
using namespace std;

int fact[2000005], MOD = 1e9 + 7;

int inv(int num) {
    int exp = MOD - 2;
    num %= MOD;
    int ans = 1;
    while(exp > 0) {
        if (exp & 1) ans = ans * num % MOD;
        num = num * num % MOD;
        exp >>= 1;
    }
    return ans;
}

signed main() {
    int n, m; cin >> n >> m;
    fact[0] = 1;
    for (int i = 1; i <= 2000000; i++) fact[i] = fact[i-1] * i % MOD;
    cout << fact[n + m - 1] * inv(fact[m]) % MOD * inv(fact[n - 1]) % MOD << '\n';
}