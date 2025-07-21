// https://codeforces.com/contest/1528/problem/A
// 晴れ 晴れ

#include <bits/stdc++.h>
using namespace std;
#define int long long

const int MX = 2e5;
vector<int> adj[MX];
int dp[2][MX], A[2][MX];

void dfs(int cur, int prev) {
    dp[0][cur] = dp[1][cur] = 0; // clear stuff
    for (int dest : adj[cur]) {
        if (dest == prev) continue;
        dfs(dest, cur);
        
        dp[0][cur] += max( abs(A[0][cur] - A[1][dest]) + dp[1][dest], abs(A[0][cur] - A[0][dest]) + dp[0][dest]);
        dp[1][cur] += max( abs(A[1][cur] - A[1][dest]) + dp[1][dest], abs(A[1][cur] - A[0][dest]) + dp[0][dest]);
    }
}

void solve() {
    int N; cin >> N;
    fill(adj + 1, adj + 1 + N, vector<int>());
    for (int i = 1; i <= N; i++) {
        cin >> A[0][i] >> A[1][i];
    }
    for (int i = 1; i < N; i++) {
        int U, V; cin >> U >> V;
        adj[U].push_back(V);
        adj[V].push_back(U);
    }
    
    // dfs on subtrees and use either `L` or `R`, updating both using DP
    // idk smth smth math
    dfs(1, -1);
    cout << max(dp[0][1], dp[1][1]) << '\n';
}

signed main() {
    cin.tie(0) -> sync_with_stdio(0);
    int T; cin >> T;
    while (T --> 0) solve();
}