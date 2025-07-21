// https://codeforces.com/contest/1770/problem/C

// bruh why didnt i solve this in contest :skull:

#include <bits/stdc++.h>
#define int long long
#define vi vector<int>
#define forn(i, n) for (int i = 0; i < n; i++)
using namespace std;

void solve() {
    int n; cin >> n;
    vi a(n);
    forn(i, n) cin >> a[i];
    sort(a.begin(), a.end());
    
    bool yay = true;
    for (int i = 1; i < n; i++) {
        //check duplicates
        yay &= (a[i] != a[i-1]);
    }
    
    for (int i = 2; i <= 100; i++) {
        int mods[i];
        fill(mods, mods+i, 0);
        forn(j, n) mods[a[j] % i]++;
        
        bool test = false;
        forn(j, i) test |= mods[j] < 2;
        yay &= test;
    }
    
    cout << (yay ? "YES\n" : "NO\n");
}

signed main() {
    int T; cin >> T;
    while(T--) solve();
}