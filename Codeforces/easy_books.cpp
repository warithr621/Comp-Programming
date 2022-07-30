//Problem: https://codeforces.com/contest/1249/problem/B1

#include<bits/stdc++.h>
using namespace std;

void solve() {
    int n; cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i]; --a[i];
    }
    for (int i = 0; i < n; i++) {
        int cnt = 1;
        int j = a[i];
        while(j != i) {++cnt; j = a[j];}
        cout << cnt << ' ';
    }
    cout << '\n';
}

int main() {
    int t; cin >> t; while(t--) solve();
}
