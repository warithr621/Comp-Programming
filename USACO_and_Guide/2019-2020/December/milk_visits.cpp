// 2019 Dec Silver P3

#include <bits/stdc++.h>
using namespace std;
#define pb push_back

vector<int> G[100005];
string S;
int N, M, A, B, comp[100005];
char C;

void dfs(int prev, int src, int val) {
    comp[src] = val;
    for (int x : G[src]) {
        if (x != prev && S[src-1] == S[x-1]) dfs(src, x, val);
        // launch dfs if hasn't been visited + letters match
    }
    
}

int main() {
    freopen("milkvisits.in", "r", stdin);
    freopen("milkvisits.out", "w", stdout);
    
    
    cin >> N >> M >> S;
    for (int i = 0; i < N-1; i++) {
        int x,y; cin >> x >> y;
        G[x].pb(y);
        G[y].pb(x);
    }
    
    // new approach, split into same-letter components
    
    int num = 1;
    for (int i = 1; i <= N; i++) {
        if (comp[i] == 0) dfs(0, i, num++);
    }
    
    while(M--) {
        cin >> A >> B >> C;
        if (comp[A] != comp[B] || S[A-1] == C) cout << 1;
        // if comps are different, you pass through G and H when going from src to dest
        // if same the path is full of the same type of cow, check to see if this is the one you want
        else cout << 0;
    }
}