// https://codeforces.com/contest/1766/problem/D

#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MX = (int)(1e7);

vector<int> min_prime_fact(MX);

int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

void solve() {
    int x, y; cin >> x >> y;
    int d = y - x;
    
    if (d == 1) {
        // infinite lol
        cout << "-1\n";
        return;
    }
    
    int ans = MX;
    vector<int> pf;
    while(d > 1) {
        if (pf.empty() or pf.back() != min_prime_fact[d]) {
            pf.push_back(min_prime_fact[d]);
        }
        d /= min_prime_fact[d];
    }
    for (int p : pf) {
        ans = min(ans, ((p - x) % p + p) % p);
    }
    cout << ans << '\n';
}

signed main() {
    cin.tie(0)->sync_with_stdio(0);
    
    // precomp
    // instead of just getting all prime factors and looping through all
    // get the smallest prime factor of every number via sieve
    // then only iterate through prime numbers of 'd'
    
    for (int i = 2; i < MX; i++) min_prime_fact[i] = i;
    for (int i = 2; i < MX; i++) {
        if (min_prime_fact[i] == i) {
            for (int j = 2*i; j < MX; j += i) {
                min_prime_fact[j] = min(min_prime_fact[j], i);
            }
        }
    }
    
    // solve
    int T; cin >> T;
    while(T--) solve();
}