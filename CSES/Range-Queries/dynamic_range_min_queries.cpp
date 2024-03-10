#include <bits/stdc++.h>
using namespace std;
#define int long long
 
signed main() {
    int N, Q; cin >> N >> Q;
    int A[N+1];
    for (int i = 1; i <= N; i++) cin >> A[i];
    int sz = (int) sqrt(N);
    vector<int> mins;
    vector< pair<int, int> > ranges;
    for (int i = 0; i < sz; i++) {
        int cur = (int) (1e9) + 1;
        for (int j = i * sz; j < (i+1) * sz; j++) {
            cur = min(cur, A[j+1]);
        }
        mins.push_back(cur);
        ranges.push_back({i * sz + 1, (i+1) * sz});
    }
    int cur = (int) (1e9) + 1;
    for (int i = sz * sz + 1; i <= N; i++) {
        cur = min(cur, A[i]);
    }
    mins.push_back(cur);
    ranges.push_back({sz * sz + 1, N});
    
    while (Q --> 0) {
        int J, K, L; cin >> J >> K >> L;
        if (J == 1) {
            // update
            for (int i = 0; i < ranges.size(); i++) {
                auto p = ranges[i];
                if (p.first <= K and K <= p.second) {
                    A[K] = L;
                    mins[i] = (int) (1e9) + 1;
                    for (int j = p.first; j <= p.second; j++) mins[i] = min(mins[i], A[j]);
                    break;
                }
            }
        } else {
            // print min
            int ans = (int) (1e9) + 1;
            int left = 0, right = 0;
            while (ranges[left].first > K or K > ranges[left].second) ++left;
            while (ranges[right].first > L or L > ranges[right].second) ++right;
            if (left == right) {
                for (int i = K; i <= L; i++) ans = min(ans, A[i]);
            } else {
                for (int i = K; i <= ranges[left].second; i++) ans = min(ans, A[i]);
                for (int i = ranges[right].first; i <= L; i++) ans = min(ans, A[i]);
                for (int i = left+1; i < right; i++) ans = min(ans, mins[i]);
            }
            cout << ans << '\n';
        }
    }
}