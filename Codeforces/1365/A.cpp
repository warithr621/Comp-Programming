// https://codeforces.com/contest/1365/problem/A

#include <bits/stdc++.h>
using namespace std;

void solve() {
    int N, M; cin >> N >> M;
    set<int> R, C;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; j++) {
            int A; cin >> A;
            if (A == 1) {
                R.insert(i);
                C.insert(j);
            }
        }
    }

    int tst = min(N - R.size(), M - C.size());
    cout << (tst % 2 == 0 ? "Vivek" : "Ashish") << '\n';
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int T; cin >> T;
    while(T--) solve();
}