// USACO Trainer's "Mixing Milk"

/*
ID: warithr1
LANG: C++11
TASK: milk
*/

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("milk.in", "r", stdin);
    freopen("milk.out", "w", stdout);

    int N,M; cin >> N >> M;
    vector< pair<int,int> > V(M);
    for (int i = 0; i < M; i++) {
        int P,A; cin >> P >> A;
        V[i] = {P, A};
    }
    sort(V.begin(), V.end());

    int cost = 0;
    for (int i = 0; i < M && N != 0; ++i) {
        int rem = min(V[i].second, N);
        N -= rem;
        cost += rem * V[i].first;
    }

    cout << cost << '\n';
}   