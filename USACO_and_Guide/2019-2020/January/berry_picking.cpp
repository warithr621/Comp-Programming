// 2020 Jan Silver P1

#include <bits/stdc++.h>
using namespace std;

int N, K, MX = 0, mod;
vector<int> B(1010);

int main() {
    freopen("berries.in", "r", stdin);
    freopen("berries.out", "w", stdout);

    int N, K, MX = 0; cin >> N >> K;
    vector<int> B(N);
    for (int i = 0; i < N; i++) {
        cin >> B[i];
        MX = max(B[i], MX);
    }

    int ans = 0;
    for (int i = 1; i <= MX; ++i) {
        int full = 0;
        for (int j = 0; j < N; ++j) full += B[j] / i;
        if (full < K/2) break;
        if (full >= K) {
            ans = max(ans, K / 2 * i);
            continue;
        }

        mod = i;
        sort(B.begin(), B.begin() + N, [](const int& x, const int& y) {
            return x % mod > y % mod;
        });
        int cur = i * (full - K/2);
        for (int j = 0; j < N && j + full < K; ++j) cur += B[j] % i;
        ans = max(ans, cur);
    }

    cout << ans << '\n';
}