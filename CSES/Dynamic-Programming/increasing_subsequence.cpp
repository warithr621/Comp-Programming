// CSES Increasing Subsequence

#include <bits/stdc++.h>
using namespace std;

int main() {
    int N; cin >> N;
    vector<int> dp;
    while(N --> 0) {
        int X; cin >> X;
        int pos = lower_bound(dp.begin(), dp.end(), X) - dp.begin();
        if (pos == dp.size()) {
            // greater than the biggest element in dp, add it
            dp.push_back(X);
        } else {
            // allows us to throw a smaller element into the LIS
            dp[pos] = X;
        }
    }
    cout << (int) dp.size() << '\n';
}