// 2017 Silver Feb P1

#include <bits/stdc++.h>
using namespace std;
#define int long long
#define ord(V) sort(V.begin(), V.end());

signed main() {
    freopen("helpcross.in", "r", stdin);
    freopen("helpcross.out", "w", stdout);

    int N,C; cin >> N >> C;
    vector<int> A(N); vector<pair<int, int>> B(C);
    for (int& i : A) cin >> i;
    for (auto& P : B) cin >> P.second >> P.first; // <end, start>
    ord(A); ord(B);

    int ans = 0;
    for (auto cow : B) {
        auto itr = lower_bound(A.begin(), A.end(), cow.second);
        if (itr != A.end() && *itr <= cow.first) {
            ++ans;
            A.erase(itr);
        }
    }

    cout << ans << '\n';
}