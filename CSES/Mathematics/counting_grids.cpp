// CSES Counting Grids

#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = (int) 1e9 + 7;

int fexp(int base, int pw) {
    // I think this is the first time I've called it fexp lmao
    if (base == 0) return (pw == 0 ? 1 : 0);
    if (base == 1) return 1;
    base %= MOD;
    
    int ans = 1;
    while (pw) {
        if (pw & 1) ans = ans * base % MOD;
        base = base * base % MOD;
        pw >>= 1;
    }
    return ans;
}

signed main() {
    int N; cin >> N;
    // https://oeis.org/A047937, lol
    int inv = fexp(4, MOD-2); // i need inverse of 4 lmao
    int Nsq = N * N;
    int ans = fexp(2, Nsq) % MOD;
    int tmp = Nsq + 3 * (N & 1);
    ans += 2 * fexp(2, tmp >> 2) % MOD;
    tmp = Nsq + (N & 1);
    ans += fexp(2, tmp >> 1) % MOD;
    cout << ans * inv % MOD << '\n';
}