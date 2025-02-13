#include <bits/stdc++.h>
using namespace std;

class FenwickTree {
public:
    vector<int> ft;
    FenwickTree(int n) : ft(n + 1, 0) {}

    void update(int i, int delta) {
        while (i < ft.size()) {
            ft[i] += delta;
            i += i & -i;
        }
    }

    int query(int i) {
        int sum_ = 0;
        while (i > 0) {
            sum_ += ft[i];
            i -= i & -i;
        }
        return sum_;
    }
};

int check(int N, vector<int>& A) {
    vector<int> sorted_A = A;
    sort(sorted_A.begin(), sorted_A.end());
    sorted_A.erase(unique(sorted_A.begin(), sorted_A.end()), sorted_A.end());

    unordered_map<int, int> ranks;
    for (int i = 0; i < sorted_A.size(); i++) {
        ranks[sorted_A[i]] = i + 1;
    }

    FenwickTree bit(sorted_A.size());
    int inv_count = 0;
    for (int i = N - 1; i >= 0; i--) {
        inv_count += bit.query(ranks[A[i]] - 1);
        bit.update(ranks[A[i]], 1);
    }
    return (inv_count % 2 == 0) ? 1 : 0;
}

void solve() {
    int N;
    cin >> N;
    vector<int> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    cout << check(N, A) << "\n";
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    solve();
}