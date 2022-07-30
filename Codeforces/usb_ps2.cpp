// https://codeforces.com/contest/762/problem/B

#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;
#define int long long

int32_t main() {
    int a,b,c,n; cin >> a >> b >> c >> n;
    vector<pair<int, string>> m(n);
    for (int i = 0; i < n; i++) {
        int p; string s;
        cin >> p >> s;
        m[i] = make_pair(p, s);
    }
    sort(m.begin(), m.end());
    int price = 0, orig = a + b + c;
    for (auto &p : m) {
        int val = p.first;
        string port = p.second;
        if (port == "USB") {
            if (a == 0 && c == 0) continue;
            if (a != 0) --a;
            else --c;
            price += val;
        } else {
            if (b == 0 && c == 0) continue;
            if (b != 0) --b;
            else --c;
            price += val;
        }
    }
    cout << orig - a - b - c << ' ' << price << '\n';
}
