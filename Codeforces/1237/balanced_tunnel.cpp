// https://codeforces.com/contest/1237/problem/B

%:include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    vector<int> a(n+1), b(n+1, 0);
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        b[x] = i;
    }
    vector<int> c(n+1, 0);
    for (int i = 0; i < n; i++) c[i] = b[a[i]];
    vector<int> mx(n+1, c[0]);
    for (int i = 1; i < n; i++) mx[i] = max(mx[i-1], c[i]);
    int ans = 0;
    for (int i = 1; i < n; i++) if (c[i] < mx[i-1]) ++ans;
    cout << ans<< '\n';
}