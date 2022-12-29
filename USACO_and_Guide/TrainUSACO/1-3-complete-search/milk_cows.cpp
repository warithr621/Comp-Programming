// USACO Trainer's "Milking Cows"

/*
ID: warithr1
LANG: C++11
TASK: milk2
*/

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("milk2.in", "r", stdin);
    freopen("milk2.out", "w", stdout);

    int N; cin >> N;
    vector< pair<int, int> > A;
    for (int i = 0; i < N; i++) {
        int x,y; cin >> x >> y;
        A.push_back({x, y});
    }

    sort(A.begin(), A.end());

    int ans1 = 0, ans2 = 0;
    pair<int, int> cur = A[0];
    for (int i = 1; i < N; i++) {
        if (A[i].first > cur.second) {
            ans2 = max(ans2, A[i].first - cur.second);
            ans1 = max(ans1, cur.second - cur.first);
            cur = A[i];
        } else {
            if (A[i].second > cur.second) {
                cur.second = A[i].second;
            }
        }
    }

    ans1 = max(ans1, cur.second - cur.first);

    cout << ans1 << ' ' << ans2 << '\n';
}   