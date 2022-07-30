//CSES Tasks and Deadlines

#include <bits/stdc++.h>
using namespace std;
#define int long long

int32_t main() {
    int n; cin >> n;
    vector<pair<int, int>> t(n);
    for (int i = 0; i < n; i++) {
        int a,d; cin >> a >> d;
        t[i] = make_pair(a, d);
    }
    //a = duration, d = deadline
    sort(t.begin(), t.end());
    int cur = 0, tot = 0;
    for (pair p : t) {
        cur += p.first;
        tot += p.second - cur;
    }
    cout << tot << '\n';
}
