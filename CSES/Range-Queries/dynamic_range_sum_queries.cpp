#include <bits/stdc++.h>
using namespace std;
#define int long long

signed main() {
    int N, Q; cin >> N >> Q;
    int A[N+1];
    for (int i = 1; i <= N; i++) cin >> A[i];
    int sz = (int) sqrt(N);
    vector<int> sums;
    vector< pair<int, int> > ranges;
    for (int i = 0; i < sz; i++) {
        int cur = 0;
        for (int j = i * sz; j < (i+1) * sz; j++) {
            cur += A[j + 1];
        }
        sums.push_back(cur);
        ranges.push_back({i * sz + 1, (i+1) * sz});
    }
    int cur = 0;
    for (int i = sz * sz + 1; i <= N; i++) {
        cur += A[i];
    }
    sums.push_back(cur);
    ranges.push_back({sz * sz + 1, N});
    
    // for (int x : sums) cout << x << ' ';
    // cout << '\n';
    // for (auto p : ranges) {
    //     cout << "(" << p.first << ", " << p.second << ") ";
    // }
    // cout << '\n';
    
    while (Q --> 0) {
        int J, K, L; cin >> J >> K >> L;
        if (J == 1) {
            // update
            for (int i = 0; i < ranges.size(); i++) {
                auto p = ranges[i];
                if (p.first <= K and K <= p.second) {
                    sums[i] += L - A[K];
                    A[K] = L;
                    break;
                }
            }
            // for (int x : sums) cout << x << ' ';
            // cout << '\n';
            // for (auto p : ranges) {
            //     cout << "(" << p.first << ", " << p.second << ") ";
            // }
            // cout << '\n';
        } else {
            // print sum
            int ans = 0;
            int left = 0, right = 0;
            while (ranges[left].first > K or K > ranges[left].second) ++left;
            while (ranges[right].first > L or L > ranges[right].second) ++right;
            if (left == right) {
                for (int i = K; i <= L; i++) ans += A[i];
            } else {
                for (int i = K; i <= ranges[left].second; i++) ans += A[i];
                for (int i = ranges[right].first; i <= L; i++) ans += A[i];
                for (int i = left+1; i < right; i++) ans += sums[i];
            }
            cout << ans << '\n';
        }
    }
}