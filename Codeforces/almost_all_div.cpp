//Problem: https://codeforces.com/contest/1165/problem/D
//Note: Virtual Submission

#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

void solve() {
    int n; cin >> n;
    vector<ll> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a.begin(), a.end());
    ll test = a[0] * a[n-1];
    vector<ll> think;
    for (int i = 2; i * 1LL * i <= test; i++) {
        if (test % i == 0) {
            think.push_back(i);
            if (i != test / i) think.push_back(test / i);
        }
    }
    sort(think.begin(), think.end());
    cout << (a == think ? test : -1) << '\n';
}

int main() {
    int t; cin >> t; while(t--) solve();
}