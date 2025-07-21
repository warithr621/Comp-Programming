// https://codeforces.com/contest/572/problem/B
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, s; cin >> n >> s;
    map<int, int> buy, sell;
    for (int i = 0; i < n; i++) {
        char c; int p,q;
        cin >> c >> p >> q;
        (c == 'B' ? buy : sell)[p] += q;
    }
    while (sell.size() > s) {
        sell.erase(--sell.end());
    }
    for (auto itr = sell.rbegin(); itr != sell.rend(); itr++) {
        cout << "S " << itr->first << ' ' << itr->second << '\n';
    }
    while (buy.size() > s) {
        buy.erase(buy.begin());
    }
    for (auto itr = buy.rbegin(); itr != buy.rend(); itr++) {
        cout << "B " << itr->first << ' ' << itr->second << '\n';
    }
}