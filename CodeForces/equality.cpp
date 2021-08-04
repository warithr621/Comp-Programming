//Problem: https://codeforces.com/contest/1038/problem/A

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n,k; cin >> n >> k;
    vector<int> a(26);
    for (int i = 0; i < 26; i++) a[i] = 0;
    while(n--) {
        char c; cin >> c;
        a[c - 'A']++;
    }
    sort(a.begin(), a.begin() + k);
    cout << a[0] * k << '\n';
}
