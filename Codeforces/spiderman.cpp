//Problem: https://codeforces.com/contest/705/problem/B

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    int e = 0;
    for (int i = 0; i < n; i++) {
        int a; cin >> a;
        if (a % 2 == 0) ++e;
        if (e & 1) cout << "1\n";
        else cout << "2\n";
    }
}
