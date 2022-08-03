/*
ID: REDACTED
LANG: C++11
TASK: numtri
*/

#include <bits/stdc++.h>
using namespace std;

int a[1005][1005];
int dp[1005][1005];

int main() {
    freopen("numtri.in", "r", stdin);
    freopen("numtri.out", "w", stdout);
    
    int n; cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) cin >> a[i][j];
    }
    
    dp[1][1] = a[1][1];
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            dp[i][j] = a[i][j] + max(dp[i-1][j-1], dp[i-1][j]);
        }
    }
    
    int ans = -1;
    for (int j = 1; j <= n; j++) ans = max(ans, dp[n][j]);
    cout << ans << '\n';
}
