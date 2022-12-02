// 2021 Feb Silver P2

#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, K, ans = 0, last = 0; cin >> N >> K;
    set<int> range;
    for (int i = 0; i < N; i++) {
        int x; cin >> x;
        range.insert((x + 11) / 12);
    }
    
    vector<int> gap; ans = *range.rbegin();
    while (!range.empty()) {
        gap.push_back(*range.begin() - last - 1);
        last = *range.begin();
        range.erase(*range.begin());
    }
    
    sort(gap.rbegin(), gap.rend());
    for (int i = 0; i < K-1 and i < gap.size(); ++i) ans -= gap[i];
    cout << 12 * ans << '\n';
}