//Problem: https://codeforces.com/gym/103150/problem/F

#include <bits/stdc++.h>
using namespace std;

int triangle(int x) {
    return floor((-1 + sqrt(1 + 8*x)) / 2);
}

void prt(char c, int x) {
    while(x--) cout << c;
}

void solve() {
    int n; cin >> n;
    char lol = 'a';
    while(n > 0) {
        int temp = triangle(n);
        prt(lol, temp);
        n -= temp * (temp + 1) / 2;
        ++lol;
    }
    cout << '\n';
}

int main() {
    int t; cin >> t; while(t--) solve();
}
