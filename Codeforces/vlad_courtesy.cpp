//Problem: https://codeforces.com/contest/811/problem/A

#include <bits/stdc++.h>
using namespace std;

int main() {
    int a, b; cin >> a >> b;
    int t = 1;
    while(a >= 0 && b >=0) {
        if (t&1) a -= t;
        else b -= t;
        ++t;
    }
    cout << (a < b ? "Vladik" : "Valera") << '\n';
}
