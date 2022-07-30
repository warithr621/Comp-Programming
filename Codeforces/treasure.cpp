//Problem: https://codeforces.com/problemset/problem/1091/B

#include <bits/stdc++.h>
using namespace std;

int main() {
    long long n; cin >> n;
    long long si = 0, sj = 0;
    for (long long i = 0; i < 2*n; i++) {
        long long x,y; cin >> x >> y;
        si += x; sj += y;
    }
    cout << si/n << " " << sj/n << '\n';
}
