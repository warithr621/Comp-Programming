//Problem: https://codeforces.com/contest/1165/problem/B
//Note: Virtual Submission

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a.begin(), a.end());
    int ans = 1;
    for (int i = 0; i < n; i++) {
        if (a[i] >= ans) ++ans;
    }
    cout << --ans << '\n';
}