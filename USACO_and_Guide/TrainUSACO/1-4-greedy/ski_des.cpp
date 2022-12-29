// USACO Trainer's "Ski Course Design"

/*
ID: warithr1
LANG: C++11
TASK: skidesign
*/

#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("skidesign.in", "r", stdin);
    freopen("skidesign.out", "w", stdout);

    int N; cin >> N;
    vector<int> A(N);
    for (int &x : A) cin >> x;
    sort(A.begin(), A.end());

    int best = 1e9;
    for (int high = 17; high <= A.back(); ++high) {
        int low = high - 17; // low + high of interval
        int cost = 0;
        for (int x : A) {
            if (x < low) cost += (low-x) * (low-x);
            else if (x > high) cost += (x-high) * (x-high);
        }
        best = min(best, cost);
    }

    cout << best << '\n';
}   