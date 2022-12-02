// 2016 Jan Silver P2

#include <bits/stdc++.h>
using namespace std;
#define ll long long

ll inp[500005], a[500005];
vector<pair<int, int>> sum(7, {-1, -1});

int main() {
    freopen("div7.in", "r", stdin);
    freopen("div7.out", "w", stdout);
    int n, ans = 0; cin >> n;
    for (int i = 0; i < n; i++) cin >> inp[i];
    for (int i = 1; i <= n; i++) a[i] = (a[i-1] + inp[i-1]) % 7;
    for (int i = 1; i <= n; i++) {
        sum[a[-i+n+1]].first = -i+n+1;
        sum[a[i]].second = i;
    }
    for (auto p : sum) ans = max(ans, p.second - p.first);
    cout << ans << '\n';
}