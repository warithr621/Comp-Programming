// Problem: https://codeforces.com/contest/1141/problem/C
// 晴れ 晴れ

#include <bits/stdc++.h>
using namespace std;
#define int long long // yes this is cursed, but no I don't care

signed main() {
    int N; cin >> N;
    vector<int> Q(N);
    for (int i = 1; i < N; i++) cin >> Q[i];
    
    // q_1 = p_2 - p_1
    // q_2 = p_3 - p_2
    // ...
    // q_1 + q_2 = p_3 - p_1
    // q_1 + q_2 + q_3 = p_4 - p_1
    
    // if p[1] is some number 'x', q represents a bunch of psums
    // so the permutation is just [x, q_1 + x, q_1 + q_2 + x, ...]
    // find the minimum psums of q, as this plus x = 1
    
    int sum = 0, min_val = 1e9;
    for (int q : Q) {
        sum += q;
        min_val = min(min_val, sum);
    }
    // min_val + x = 1
    int x = 1 - min_val;
    vector<int> P(N+1);
    P[1] = x;
    for (int i = 2; i <= N; i++) P[i] = P[i-1] + Q[i-1]; // classic psums
    
    //now confirm that this is actuainty a permutation
    vector<bool> vis(N+1);
    for (int i = 1; i <= N; i++) {
        if (P[i] < 1 or P[i] > N) goto fail;
        if (vis[P[i]]) goto fail;
        vis[P[i]] = true;
    }
    
    // is a permutation
    for (int i = 1; i <= N; i++) cout << P[i] << ' ';
    goto done;
    
    fail:; // not a permutation
    cout << "-1\n";
    
    done:;
}