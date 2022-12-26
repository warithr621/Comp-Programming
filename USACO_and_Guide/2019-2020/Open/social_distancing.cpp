// 2020 Silver Open P1

#include <bits/stdc++.h>
using namespace std;
#define int long long

int N,M;
vector<pair<int, int>> A;

bool works(int D) {
    int placed = 1;
    int cur = A[0].first;
    
    for (auto& P : A) {
        while(max(cur + D, P.first) <= P.second) {
            cur = max(cur + D, P.first);
            ++placed;
        }
    }

    return placed >= N;
}

signed main() {
    freopen("socdist.in", "r", stdin);
    freopen("socdist.out", "w", stdout);

    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int x,y; cin >> x >> y;
        A.push_back({x, y});
    }
    sort(A.begin(), A.end());

    int L = 1, R = 2e18;
    while (L < R) {
        int mid = (L + R + 1) / 2;
        if (works(mid)) L = mid;
        else R = --mid;
    }

    cout << L << '\n';
}