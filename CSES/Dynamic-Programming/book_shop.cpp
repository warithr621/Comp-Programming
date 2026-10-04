// CSES Book Shop

#include <iostream>
using namespace std;
int dp[100005];
int cost[1005], page[1005];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, x; cin >> n >> x;
    for (int i = 0; i < n; ++i) cin >> cost[i];
    for (int i = 0; i < n; i++) cin >> page[i];

    for (int i = 0; i < n; i++) {
        int cc = cost[i], cp = page[i];
        for (int j = x; j >= cc; j--) {
            dp[j] = max(dp[j], dp[j - cc] + cp);
        }
    }
    cout << dp[x];
}