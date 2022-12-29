// USACO Trainer's "Wormholes"

/*
ID: warithr1
LANG: C++11
TASK: wormhole
*/

#include <bits/stdc++.h>
using namespace std;

int N, X[13], Y[13];
int partner[13], nxt[13]; // bruh "next" is an STL word smh

bool cycle() {
    for (int i = 1; i <= N; i++) {
        int pos = i;
        for (int j = 0; j < N; ++j) {
            pos = nxt[partner[pos]];
        }
        if (pos != 0) return true;
    }
    return false;
}

int solve() {
    int i, tot = 0;
    for (i = 1; i <= N; i++) {
        if (partner[i] == 0) break;
    }
    if (i > N) return cycle();

    for (int j = i+1; j <= N; ++j) {
        if (partner[j] == 0) {
            partner[i] = j; partner[j] = i;
            tot += solve(); // yay recursion
            partner[i] = partner[j] = 0;
        }
    }

    return tot;
}

int main() {
    freopen("wormhole.in", "r", stdin);
    freopen("wormhole.out", "w", stdout);

    cin >> N;
    for (int i = 1; i <= N; i++) cin >> X[i] >> Y[i];

    // pcomp some stuff
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; ++j) {
            if (X[j] > X[i] && Y[i] == Y[j]) {
                if (nxt[i] == 0 || 
                    X[j] - X[i] < X[nxt[i]] - X[i]) {
                    nxt[i] = j;
                }
            }
        }
    }

    cout << solve() << '\n';
}